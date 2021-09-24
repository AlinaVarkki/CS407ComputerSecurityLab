import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA128HashGetter {

    private MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

    public SHA128HashGetter(String message) throws NoSuchAlgorithmException {
        System.out.println(hexRepresentationDigest(encryptSHA128Hash(message)));
    }

    public byte[] encryptSHA128Hash(String message) {
        byte[] arrBytes = message.getBytes(StandardCharsets.UTF_8);
        messageDigest.update(arrBytes);

        byte[] hashValue = messageDigest.digest();

        return hashValue;
    }

    public static String hexRepresentationDigest(byte[] d) {

        StringBuffer sb = new StringBuffer();

        for (byte b : d) sb.append(String.format("%02x", b & 0xff));
        return sb.toString();

    }

}
