package encryptdecrypt;

public class EncryptionFactory implements AlgorithmFactory{
    public ShiftEncryption getShiftEncryption() {
        return new ShiftEncryption();
    }
    public UnicodeEncryption getUnicodeEncryption() {
        return new UnicodeEncryption();
    }
}
