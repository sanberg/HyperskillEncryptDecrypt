package encryptdecrypt;

import static encryptdecrypt.Main.shift;

public class UnicodeDecryption implements Decryption {
    @Override
    public String decrypt(String input, int key) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(shift(input.charAt(i), key, ShiftDirection.LEFT));
        }
        return output.toString();
    }
}