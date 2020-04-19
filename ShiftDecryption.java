package encryptdecrypt;

public class ShiftDecryption implements Decryption {
    @Override
    public String decrypt(String input, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : input.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + 26 - (key % 26)) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return String.valueOf(result);
    }
}
