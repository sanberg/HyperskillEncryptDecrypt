package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

enum ShiftDirection {
    LEFT,
    RIGHT
}

public class Main {
    public static char shift(char character, int shiftValue, ShiftDirection direction) {
        if (direction == ShiftDirection.RIGHT) {
            while (shiftValue > 0) {
                shiftValue--;
                character++;
                if (character >= Character.MAX_VALUE) {
                    character = Character.MIN_VALUE;
                }
            }
        } else if (direction == ShiftDirection.LEFT) {
            while (shiftValue > 0) {
                shiftValue--;
                character--;
                if (character <= Character.MIN_VALUE) character = Character.MAX_VALUE;
            }
        }
        return character;
    }


    public static String readFileAsString(String fileName) throws IOException {
        System.out.println(new String(Files.readAllBytes(Paths.get(fileName))));
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void main(String[] args) throws IOException {

        String mode = "enc";
        String input = "";
        int key = 0;
        String inPath = "";
        String outPath = "";
        String alg = "shift";

        for (int i = 0; i < args.length; i += 2) {
            if (args[i] == "-mode") {
                mode = args[i + 1];
            }
            if (args[i] == "-key") {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i] == "-data") {
                input = args[i + 1];
            }
            if (args[i] == "-in") {
                inPath = args[i + 1];
            }
            if (args[i] == "-out") {
                outPath = args[i + 1];
            }
            if (args[i] == "-alg") {
                alg = args[i + 1];
            }
        }

        if (!(inPath.isBlank())) {
            input = readFileAsString(inPath);
        }

 /*       switch (mode) {
            case "dec":
                DecryptionFactory df = new DecryptionFactory();
                break;
            case "enc":
                EncryptionFactory ef = new EncryptionFactory();
                break;
        }*/
        switch (mode) {
            case "enc":
                EncryptionFactory ef = new EncryptionFactory();
                Encryption cipher = (alg == "shift") ? ef.getShiftEncryption() : ef.getUnicodeEncryption();
                if (outPath.isBlank()) {
                    System.out.println(cipher.encrypt(input, key));
                } else {
                    File file = new File(outPath);
                    try (FileWriter writer = new FileWriter(file, false)) {
                        writer.write(cipher.encrypt(input, key));
                    } catch (IOException ioe) {
                        System.out.println("There is an Error");
                    }
                }
                break;
            case "dec":
                DecryptionFactory df = new DecryptionFactory();
                Decryption decripter = (alg == "shift") ? df.getShiftDecryption() : df.getUnicodeDecryption();
                if (outPath.isBlank()) {
                    System.out.println(decripter.decrypt(input, key));
                } else {
                    File file = new File(outPath);
                    try (FileWriter writer = new FileWriter(file)) {
                        writer.write(decripter.decrypt(input, key));
                    } catch (IOException ioe) {
                        System.out.println("There is an Error");
                    }
                }
                break;
        }
    }
}


/*    public static String encrypt(String input, int key) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(shift(input.charAt(i), key, ShiftDirection.RIGHT));
        }
        return output.toString();
    }

    public static String decrypt(String input, int key) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            output.append(shift(input.charAt(i), key, ShiftDirection.LEFT));
        }
        return output.toString();
    }*/