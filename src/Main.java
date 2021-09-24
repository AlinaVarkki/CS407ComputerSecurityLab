import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        VigenereEncyptor vigenereEncyptor = new VigenereEncyptor();
        String encryptedS = vigenereEncyptor.getEncryptedString("I shall call him squishy and he shall be mine and he shall be my squishy", "key");
        System.out.println(encryptedS);
    }
}
