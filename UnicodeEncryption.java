package encryptdecrypt;

import static encryptdecrypt.Main.shift;

public class UnicodeEncryption implements Encryption {
    @Override
    public String encrypt(String input, int key) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(shift(input.charAt(i), key, ShiftDirection.RIGHT));
        }
        return output.toString();
    }
}
