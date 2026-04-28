package solutions.pixelart;

/*
 * Tämä luokka sisältää itse pixel gridin tiedot.
 * Se tietää missä kursori on ja mitkä pikselit ovat päällä.
 */
public class PixelGrid {

    private final int size = 8;
    private final boolean[][] pixels = new boolean[size][size];

    private int cursorRow = 0;
    private int cursorCol = 0;

    public int getSize() {
        return size;
    }

    public boolean isPixelOn(int row, int col) {
        return pixels[row][col];
    }

    public int getCursorRow() {
        return cursorRow;
    }

    public int getCursorCol() {
        return cursorCol;
    }

    /*
     * Liikutetaan kursoria ylöspäin.
     * Tarkistetaan myös, ettei kursori mene gridin ulkopuolelle.
     */
    public void moveUp() {
        if (cursorRow > 0) {
            cursorRow--;
        }
    }

    public void moveDown() {
        if (cursorRow < size - 1) {
            cursorRow++;
        }
    }

    public void moveLeft() {
        if (cursorCol > 0) {
            cursorCol--;
        }
    }

    public void moveRight() {
        if (cursorCol < size - 1) {
            cursorCol++;
        }
    }

    /*
     * Vaihdetaan nykyisen pikselin tila.
     * Jos se on pois päältä, se menee päälle.
     * Jos se on päällä, se menee pois päältä.
     */
    public void togglePixel() {
        pixels[cursorRow][cursorCol] = !pixels[cursorRow][cursorCol];
    }

    /*
     * Tämä metodi luo Java-koodin nykyisestä 8x8 kuvasta.
     */
    public String generateJavaCode() {
        StringBuilder code = new StringBuilder();

        code.append("int[][] pixelArt = {\n");

        for (int row = 0; row < size; row++) {
            code.append("    {");

            for (int col = 0; col < size; col++) {
                code.append(pixels[row][col] ? "1" : "0");

                if (col < size - 1) {
                    code.append(", ");
                }
            }

            code.append("}");

            if (row < size - 1) {
                code.append(",");
            }

            code.append("\n");
        }

        code.append("};");

        return code.toString();
    }
}