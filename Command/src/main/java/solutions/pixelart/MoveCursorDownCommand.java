package solutions.pixelart;

/*
 * Tämä command liikuttaa kursoria alaspäin.
 */
public class MoveCursorDownCommand implements Command {

    private final PixelGrid pixelGrid;

    public MoveCursorDownCommand(PixelGrid pixelGrid) {
        this.pixelGrid = pixelGrid;
    }

    @Override
    public void execute() {
        pixelGrid.moveDown();
    }
}