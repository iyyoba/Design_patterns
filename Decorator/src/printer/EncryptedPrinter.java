package printer;

public class EncryptedPrinter extends PrinterDecorator {

    private static final int SHIFT = 3;

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        printer.print(encryptedMessage);
    }

    private String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : message.toCharArray()) {
            encrypted.append((char) (c + SHIFT));
        }

        return encrypted.toString();
    }
}