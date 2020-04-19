package encryptdecrypt;

public class DecryptionFactory implements AlgorithmFactory{
    public ShiftDecryption getShiftDecryption() {
        return new ShiftDecryption();
    }
    public UnicodeDecryption getUnicodeDecryption() {
        return new UnicodeDecryption();
    }
}