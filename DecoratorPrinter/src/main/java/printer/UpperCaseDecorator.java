package printer;

public class UpperCaseDecorator extends PrinterDecorator {

    public UpperCaseDecorator(Printer component) {
        super(component);
    }

    @Override
    public void print(String message) {
        String upper = message.toUpperCase();
        component.print(upper);
    }
}