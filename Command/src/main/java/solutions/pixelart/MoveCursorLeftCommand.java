package solutions.pixelart;

/*
 * Tämä command liikuttaa kursoria vasemmalle.
 */
public class MoveCursorLeftCommand implements Command {

    private final PixelGrid pixelGrid;

    public MoveCursorLeftCommand(PixelGrid pixelGrid) {
        this.pixelGrid = pixelGrid;
    }

    @Override
    public void execute() {
        pixelGrid.moveLeft();
    }
}