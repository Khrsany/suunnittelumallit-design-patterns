package printer;

public class EncryptedPrinter extends PrinterDecorator {
    public EncryptedPrinter(Printer printer) {
        super(printer);
    }
    @Override
    public void print(String message) {
        String reversed = new StringBuffer(message).reverse().toString();

        component.print(reversed);
    }

}
