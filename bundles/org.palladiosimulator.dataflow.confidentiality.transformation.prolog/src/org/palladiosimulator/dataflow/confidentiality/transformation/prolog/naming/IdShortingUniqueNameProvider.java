package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.naming;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.function.Function;

public class IdShortingUniqueNameProvider extends AbstractUniqueNameProvider {

    protected static final Function<String, String> ID_COMPRESSOR = createIdCompressor();

    @Override
    protected String constructName(String name, String id) {
        return String.format("%s (%s)", name, ID_COMPRESSOR.apply(id));
    }

    private static Function<String, String> createIdCompressor() {
        try {
            var md5 = MessageDigest.getInstance("MD5");
            return id -> {
                if (id.length() <= 25) {
                    return id;
                }
                byte[] idBytes = id.getBytes(StandardCharsets.UTF_8);
                var md5Digest = md5.digest(idBytes);
                var md5Int = new BigInteger(1, md5Digest);
                var md5String = md5Int.toString(36);
                return md5String;
            };
        } catch (NoSuchAlgorithmException e) {
            return Function.identity();
        }
    }

}
