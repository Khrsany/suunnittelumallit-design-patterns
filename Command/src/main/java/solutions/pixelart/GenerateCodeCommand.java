package solutions.pixelart;

/*
 * Tämä command luo Java-koodin nykyisestä pixel artista.
 */
public class GenerateCodeCommand implements Command {

    private final PixelGrid pixelGrid;

    public GenerateCodeCommand(PixelGrid pixelGrid) {
        this.pixelGrid = pixelGrid;
    }

    @Override
    public void execute() {
        System.out.println(pixelGrid.generateJavaCode());
    }
}