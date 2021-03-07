package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.impl

import java.util.ArrayList
import java.util.List
import java.util.function.Supplier
import org.palladiosimulator.supporting.prolog.model.prolog.CompoundTerm
import org.palladiosimulator.supporting.prolog.model.prolog.PrologFactory
import org.palladiosimulator.supporting.prolog.model.prolog.directives.DirectivesFactory
import org.palladiosimulator.supporting.prolog.model.prolog.expressions.BinaryExpression
import org.palladiosimulator.supporting.prolog.model.prolog.expressions.Expression
import org.palladiosimulator.supporting.prolog.model.prolog.expressions.ExpressionsFactory

class PrologCreateUtils {
	
	val extension PrologFactory prologFactory = PrologFactory.eINSTANCE
	val extension ExpressionsFactory prologExpressionsFactory = ExpressionsFactory.eINSTANCE
	val extension DirectivesFactory prologDirectivesFactory = DirectivesFactory.eINSTANCE
	
	def toVar(CharSequence name) {
		createVariable(name)
	}
	
	def toInt(int number) {
		createAtomicNumber => [
			value = number
		]
	}
		
	def toQuotedString(String name) {
		createAtomicQuotedString => [
			value = name
		]
	}
	
	def createRule(CompoundTerm head, Expression body) {
		val rule = createRule
		rule.head = head
		rule.body = body
		rule
	}

	def createComment(String commentString) {
		val lines = new ArrayList(commentString.split("\\r?\\n"))
		if (commentString.endsWith("\n")) {
			lines.add("")
		}
		lines.map([ line |
			createComment => [
				value = line
			]
		])
	}
	
	
	def createCompoundTerm(String name, Expression... expressions) {
		createCompoundTerm => [
			value = name
			arguments += expressions
		]
	}
	
	def createCompoundTerm(String name, String... variableNames) {
		createCompoundTerm => [
			value = name
			arguments += variableNames.map[createVariable]
		]
	}

	def createVariable(CharSequence name) {
		createCompoundTerm => [
			value = name.toString
		]
	}
	
	def createList(List<String> headStrings) {
		createList(headStrings, #[])
	}
	
	def createList(List<String> headStrings, List<String> tailStrings) {
		createListExpressions(headStrings.map[createVariable], tailStrings.map[createVariable])
	}
	
	def createListExpressions(List<Expression> headExpressions) {
		createListExpressions(headExpressions, #[])
	}
	
	def createListExpressions(List<Expression> headExpressions, List<Expression> tailExpressions) {
		createList => [
			heads += headExpressions
			tails += tailExpressions
		]
	}

	def createConjunction(Expression... expressions) {
		[|createLogicalAnd].createSequence(expressions)
	}
	
	def createDisjunction(Expression... expressions) {
		[|createLogicalOr].createSequence(expressions)
	}

	def createSequence(Supplier<? extends BinaryExpression> binaryOperatorProvider, Expression... expressions) {
		val firstExpression = expressions.findFirst[true]
		if (expressions.size == 1) {
			return firstExpression;
		}
		
		var currentOp = binaryOperatorProvider.get => [
			left = firstExpression
		]
		for (var i = 1; i < expressions.size - 1; i++) {
			currentOp.right = expressions.get(i)
			var outerAnd = binaryOperatorProvider.get
			outerAnd.left = currentOp
			currentOp = outerAnd
		}
		currentOp.right = expressions.last
		
		return currentOp
	}
	
	def createUnification(Expression leftExpression, Expression rightExpression) {
		createUnification => [
			left = leftExpression
			right = rightExpression
		]
	}
	
	def createUnification(String leftVar, String rightVar) {
		createUnification(leftVar.toVar, rightVar.toVar)
	}
	
	def createNotUnifiable(String leftVar, String rightVar) {
		createNotUnifiable(leftVar.toVar, rightVar.toVar)
	}
	
	def createNotUnifiable(Expression leftExpression, Expression rightExpression) {
		createNotUnifiable => [
			left = leftExpression
			right = rightExpression
		]
	}
	
	def createDiscontiguousDirective(String predicateName, int arity) {
		val directive = createDiscontiguous
		directive.name = "discontiguous"
		val predicateIndicator = createPredicateIndicator
		directive.predicates += predicateIndicator
		predicateIndicator.name = predicateName
		predicateIndicator.arity = arity
		directive
	}
	
	def createHeaderComment(String commentString) {
		val longestLine = commentString.lines.map[length].max[i,j|Integer.compare(i,j)].get
		val delimiter = "=".repeat(longestLine)
		createComment(delimiter + "\n" + commentString + "\n" + delimiter)
	}

	def createFact(CompoundTerm head) {
		val fact = createFact
		fact.head = head
		fact
	}
	
	def createNotProvable(Expression expression) {
		createNotProvable => [
			expr = expression
		]
	}
}