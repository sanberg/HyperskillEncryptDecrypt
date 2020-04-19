package encryptdecrypt;

public class ShiftEncryption implements Encryption {
    @Override
    public String encrypt(String input, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : input.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return String.valueOf(result);
    }
}