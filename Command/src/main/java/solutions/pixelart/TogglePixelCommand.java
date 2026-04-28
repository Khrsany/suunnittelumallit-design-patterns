package solutions.pixelart;

/*
 * Tämä command vaihtaa nykyisen pikselin tilan.
 */
public class TogglePixelCommand implements Command {

    private final PixelGrid pixelGrid;

    public TogglePixelCommand(PixelGrid pixelGrid) {
        this.pixelGrid = pixelGrid;
    }

    @Override
    public void execute() {
        pixelGrid.togglePixel();
    }
}