import java.nio.charset.StandardCharsets;
import java.security.*;
import java.io.*;


public class DigitalSignature {

    KeyPairGenerator keyPairGenerator;
    SecureRandom secureRandom;
    int keySize = 2048;

    public DigitalSignature() throws NoSuchAlgorithmException, InvalidKeyException, IOException, SignatureException {
        keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        secureRandom = SecureRandom.getInstance("SHA1PRNG");
        keyPairGenerator.initialize(keySize, secureRandom);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        Signature signature = Signature.getInstance("DSA");
        signature.initSign(privateKey);
        signature.update(readFile().getBytes(StandardCharsets.UTF_8));
        signature.sign();
    }

    public String readFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        try {
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } finally {
            br.close();
        }

        return sb.toString();
    }
}
