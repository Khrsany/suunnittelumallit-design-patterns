package solutions.pixelart;

/*
 * Tämä command liikuttaa kursoria ylöspäin.
 */
public class MoveCursorUpCommand implements Command {

    private final PixelGrid pixelGrid;

    public MoveCursorUpCommand(PixelGrid pixelGrid) {
        this.pixelGrid = pixelGrid;
    }

    @Override
    public void execute() {
        pixelGrid.moveUp();
    }
}