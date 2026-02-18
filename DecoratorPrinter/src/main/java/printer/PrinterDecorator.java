package printer;

public abstract class PrinterDecorator implements Printer {

    protected Printer component;

    public PrinterDecorator(Printer component) {
        this.component = component;
    }

    @Override
    public void print(String message) {
        component.print(message);
    }
}