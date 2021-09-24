public class VigenereEncyptor {

    public String getEncryptedString(String plainText, String keyWord) {
        StringBuilder sb = new StringBuilder();
        plainText = plainText.toUpperCase().replace(" ", "");
        keyWord = keyWord.toUpperCase();

        for (int i = 0; i < plainText.length(); i++) {
            int currChar = plainText.charAt(i) - 'A';
            int keyChar = keyWord.charAt(i % keyWord.length()) - 'A';
            char encryptedChar = (char) ('A' + (currChar + keyChar) % 26);
            sb.append(encryptedChar);
        }

        return sb.toString();
    }

}
