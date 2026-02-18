package printer;

public class XMLPrinter extends PrinterDecorator {

    public XMLPrinter(Printer component) {
        super(component);
    }

    @Override
    public void print(String message) {
        String xml = "<message>" + message + "</message>";
        component.print(xml);
    }
}