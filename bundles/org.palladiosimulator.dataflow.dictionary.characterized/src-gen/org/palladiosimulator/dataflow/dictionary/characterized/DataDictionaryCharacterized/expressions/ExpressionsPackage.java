/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface ExpressionsPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expressions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/dataflow/dictionary/characterized/expressions/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "expressions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionsPackage eINSTANCE = org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.TermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.TermImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ConstantImpl <em>Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ConstantImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getConstant()
	 * @generated
	 */
	int CONSTANT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__ID = TERM__ID;

	/**
	 * The number of structural features of the '<em>Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_FEATURE_COUNT = TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.TrueImpl <em>True</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.TrueImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getTrue()
	 * @generated
	 */
	int TRUE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE__ID = CONSTANT__ID;

	/**
	 * The number of structural features of the '<em>True</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_FEATURE_COUNT = CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.FalseImpl <em>False</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.FalseImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getFalse()
	 * @generated
	 */
	int FALSE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE__ID = CONSTANT__ID;

	/**
	 * The number of structural features of the '<em>False</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_FEATURE_COUNT = CONSTANT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.LogicTermImpl <em>Logic Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.LogicTermImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getLogicTerm()
	 * @generated
	 */
	int LOGIC_TERM = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_TERM__ID = TERM__ID;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_TERM__TERMS = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Logic Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_TERM_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.UnaryLogicTermImpl <em>Unary Logic Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.UnaryLogicTermImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getUnaryLogicTerm()
	 * @generated
	 */
	int UNARY_LOGIC_TERM = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_LOGIC_TERM__ID = LOGIC_TERM__ID;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_LOGIC_TERM__TERMS = LOGIC_TERM__TERMS;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_LOGIC_TERM__TERM = LOGIC_TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Logic Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_LOGIC_TERM_FEATURE_COUNT = LOGIC_TERM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.NotImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__ID = UNARY_LOGIC_TERM__ID;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__TERMS = UNARY_LOGIC_TERM__TERMS;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__TERM = UNARY_LOGIC_TERM__TERM;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = UNARY_LOGIC_TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.BinaryLogicTermImpl <em>Binary Logic Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.BinaryLogicTermImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getBinaryLogicTerm()
	 * @generated
	 */
	int BINARY_LOGIC_TERM = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LOGIC_TERM__ID = LOGIC_TERM__ID;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LOGIC_TERM__TERMS = LOGIC_TERM__TERMS;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LOGIC_TERM__LEFT = LOGIC_TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LOGIC_TERM__RIGHT = LOGIC_TERM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Logic Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LOGIC_TERM_FEATURE_COUNT = LOGIC_TERM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.AndImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__ID = BINARY_LOGIC_TERM__ID;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__TERMS = BINARY_LOGIC_TERM__TERMS;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__LEFT = BINARY_LOGIC_TERM__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__RIGHT = BINARY_LOGIC_TERM__RIGHT;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = BINARY_LOGIC_TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.OrImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getOr()
	 * @generated
	 */
	int OR = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__ID = BINARY_LOGIC_TERM__ID;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__TERMS = BINARY_LOGIC_TERM__TERMS;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__LEFT = BINARY_LOGIC_TERM__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__RIGHT = BINARY_LOGIC_TERM__RIGHT;

	/**
	 * The number of structural features of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = BINARY_LOGIC_TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.CharacteristicReferenceImpl <em>Characteristic Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.CharacteristicReferenceImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getCharacteristicReference()
	 * @generated
	 */
	int CHARACTERISTIC_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_REFERENCE__ID = TERM__ID;

	/**
	 * The feature id for the '<em><b>Characteristic Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_REFERENCE__CHARACTERISTIC_TYPE = TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_REFERENCE__LITERAL = TERM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Characteristic Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_REFERENCE_FEATURE_COUNT = TERM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ContainerCharacteristicReferenceImpl <em>Container Characteristic Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ContainerCharacteristicReferenceImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getContainerCharacteristicReference()
	 * @generated
	 */
	int CONTAINER_CHARACTERISTIC_REFERENCE = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CHARACTERISTIC_REFERENCE__ID = CHARACTERISTIC_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Characteristic Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CHARACTERISTIC_REFERENCE__CHARACTERISTIC_TYPE = CHARACTERISTIC_REFERENCE__CHARACTERISTIC_TYPE;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CHARACTERISTIC_REFERENCE__LITERAL = CHARACTERISTIC_REFERENCE__LITERAL;

	/**
	 * The number of structural features of the '<em>Container Characteristic Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CHARACTERISTIC_REFERENCE_FEATURE_COUNT = CHARACTERISTIC_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.DataCharacteristicReferenceImpl <em>Data Characteristic Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.DataCharacteristicReferenceImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getDataCharacteristicReference()
	 * @generated
	 */
	int DATA_CHARACTERISTIC_REFERENCE = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHARACTERISTIC_REFERENCE__ID = CHARACTERISTIC_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Characteristic Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHARACTERISTIC_REFERENCE__CHARACTERISTIC_TYPE = CHARACTERISTIC_REFERENCE__CHARACTERISTIC_TYPE;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHARACTERISTIC_REFERENCE__LITERAL = CHARACTERISTIC_REFERENCE__LITERAL;

	/**
	 * The feature id for the '<em><b>Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHARACTERISTIC_REFERENCE__PIN = CHARACTERISTIC_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Characteristic Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CHARACTERISTIC_REFERENCE_FEATURE_COUNT = CHARACTERISTIC_REFERENCE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Constant <em>Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Constant
	 * @generated
	 */
	EClass getConstant();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.True <em>True</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.True
	 * @generated
	 */
	EClass getTrue();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.False <em>False</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>False</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.False
	 * @generated
	 */
	EClass getFalse();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.LogicTerm <em>Logic Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logic Term</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.LogicTerm
	 * @generated
	 */
	EClass getLogicTerm();

	/**
	 * Returns the meta object for the reference list '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.LogicTerm#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Terms</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.LogicTerm#getTerms()
	 * @see #getLogicTerm()
	 * @generated
	 */
	EReference getLogicTerm_Terms();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.UnaryLogicTerm <em>Unary Logic Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Logic Term</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.UnaryLogicTerm
	 * @generated
	 */
	EClass getUnaryLogicTerm();

	/**
	 * Returns the meta object for the containment reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.UnaryLogicTerm#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.UnaryLogicTerm#getTerm()
	 * @see #getUnaryLogicTerm()
	 * @generated
	 */
	EReference getUnaryLogicTerm_Term();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm <em>Binary Logic Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Logic Term</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm
	 * @generated
	 */
	EClass getBinaryLogicTerm();

	/**
	 * Returns the meta object for the containment reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm#getLeft()
	 * @see #getBinaryLogicTerm()
	 * @generated
	 */
	EReference getBinaryLogicTerm_Left();

	/**
	 * Returns the meta object for the containment reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm#getRight()
	 * @see #getBinaryLogicTerm()
	 * @generated
	 */
	EReference getBinaryLogicTerm_Right();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference <em>Characteristic Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characteristic Reference</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference
	 * @generated
	 */
	EClass getCharacteristicReference();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference#getCharacteristicType <em>Characteristic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Characteristic Type</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference#getCharacteristicType()
	 * @see #getCharacteristicReference()
	 * @generated
	 */
	EReference getCharacteristicReference_CharacteristicType();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Literal</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference#getLiteral()
	 * @see #getCharacteristicReference()
	 * @generated
	 */
	EReference getCharacteristicReference_Literal();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ContainerCharacteristicReference <em>Container Characteristic Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Characteristic Reference</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ContainerCharacteristicReference
	 * @generated
	 */
	EClass getContainerCharacteristicReference();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference <em>Data Characteristic Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Characteristic Reference</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference
	 * @generated
	 */
	EClass getDataCharacteristicReference();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference#getPin <em>Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pin</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference#getPin()
	 * @see #getDataCharacteristicReference()
	 * @generated
	 */
	EReference getDataCharacteristicReference_Pin();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionsFactory getExpressionsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.TermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.TermImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ConstantImpl <em>Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ConstantImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getConstant()
		 * @generated
		 */
		EClass CONSTANT = eINSTANCE.getConstant();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.TrueImpl <em>True</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.TrueImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getTrue()
		 * @generated
		 */
		EClass TRUE = eINSTANCE.getTrue();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.FalseImpl <em>False</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.FalseImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getFalse()
		 * @generated
		 */
		EClass FALSE = eINSTANCE.getFalse();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.LogicTermImpl <em>Logic Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.LogicTermImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getLogicTerm()
		 * @generated
		 */
		EClass LOGIC_TERM = eINSTANCE.getLogicTerm();

		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGIC_TERM__TERMS = eINSTANCE.getLogicTerm_Terms();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.UnaryLogicTermImpl <em>Unary Logic Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.UnaryLogicTermImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getUnaryLogicTerm()
		 * @generated
		 */
		EClass UNARY_LOGIC_TERM = eINSTANCE.getUnaryLogicTerm();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_LOGIC_TERM__TERM = eINSTANCE.getUnaryLogicTerm_Term();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.NotImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.BinaryLogicTermImpl <em>Binary Logic Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.BinaryLogicTermImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getBinaryLogicTerm()
		 * @generated
		 */
		EClass BINARY_LOGIC_TERM = eINSTANCE.getBinaryLogicTerm();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_LOGIC_TERM__LEFT = eINSTANCE.getBinaryLogicTerm_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_LOGIC_TERM__RIGHT = eINSTANCE.getBinaryLogicTerm_Right();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.AndImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.OrImpl <em>Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.OrImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.CharacteristicReferenceImpl <em>Characteristic Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.CharacteristicReferenceImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getCharacteristicReference()
		 * @generated
		 */
		EClass CHARACTERISTIC_REFERENCE = eINSTANCE.getCharacteristicReference();

		/**
		 * The meta object literal for the '<em><b>Characteristic Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHARACTERISTIC_REFERENCE__CHARACTERISTIC_TYPE = eINSTANCE.getCharacteristicReference_CharacteristicType();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHARACTERISTIC_REFERENCE__LITERAL = eINSTANCE.getCharacteristicReference_Literal();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ContainerCharacteristicReferenceImpl <em>Container Characteristic Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ContainerCharacteristicReferenceImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getContainerCharacteristicReference()
		 * @generated
		 */
		EClass CONTAINER_CHARACTERISTIC_REFERENCE = eINSTANCE.getContainerCharacteristicReference();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.DataCharacteristicReferenceImpl <em>Data Characteristic Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.DataCharacteristicReferenceImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl#getDataCharacteristicReference()
		 * @generated
		 */
		EClass DATA_CHARACTERISTIC_REFERENCE = eINSTANCE.getDataCharacteristicReference();

		/**
		 * The meta object literal for the '<em><b>Pin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CHARACTERISTIC_REFERENCE__PIN = eINSTANCE.getDataCharacteristicReference_Pin();

	}

} //ExpressionsPackage
