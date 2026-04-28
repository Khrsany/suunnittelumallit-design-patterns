package solutions.pixelart;

/*
 * Tämä command liikuttaa kursoria oikealle.
 */
public class MoveCursorRightCommand implements Command {

    private final PixelGrid pixelGrid;

    public MoveCursorRightCommand(PixelGrid pixelGrid) {
        this.pixelGrid = pixelGrid;
    }

    @Override
    public void execute() {
        pixelGrid.moveRight();
    }
}