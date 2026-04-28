package solutions.pixelart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*
 * Tämä on JavaFX-sovelluksen pääluokka.
 * Tässä rakennetaan ikkuna, 8x8 ruudukko ja nappi.
 */
public class PixelArtEditorApp extends Application {

    private final PixelGrid pixelGrid = new PixelGrid();
    private final Rectangle[][] cells = new Rectangle[8][8];

    @Override
    public void start(Stage stage) {

        GridPane gridPane = new GridPane();

        /*
         * Luodaan 8x8 ruudukko.
         * Jokainen ruutu on Rectangle.
         */
        for (int row = 0; row < pixelGrid.getSize(); row++) {
            for (int col = 0; col < pixelGrid.getSize(); col++) {

                Rectangle cell = new Rectangle(40, 40);
                cell.setStroke(Color.GRAY);

                cells[row][col] = cell;
                gridPane.add(cell, col, row);
            }
        }

        Button createCodeButton = new Button("Create Code");

        /*
         * Button käyttää GenerateCodeCommand-komentoa.
         */
        createCodeButton.setOnAction(event -> {
            Command command = new GenerateCodeCommand(pixelGrid);
            command.execute();
        });

        VBox root = new VBox(10, gridPane, createCodeButton);

        Scene scene = new Scene(root, 340, 390);

        /*
         * Näppäimistön käyttö.
         * Nuolinäppäimet liikuttavat kursoria.
         * Space vaihtaa pikselin tilan.
         */
        scene.setOnKeyPressed(event -> {

            Command command = null;

            if (event.getCode() == KeyCode.UP) {
                command = new MoveCursorUpCommand(pixelGrid);
            } else if (event.getCode() == KeyCode.DOWN) {
                command = new MoveCursorDownCommand(pixelGrid);
            } else if (event.getCode() == KeyCode.LEFT) {
                command = new MoveCursorLeftCommand(pixelGrid);
            } else if (event.getCode() == KeyCode.RIGHT) {
                command = new MoveCursorRightCommand(pixelGrid);
            } else if (event.getCode() == KeyCode.SPACE) {
                command = new TogglePixelCommand(pixelGrid);
            }

            if (command != null) {
                command.execute();
                updateGrid();
            }
        });

        updateGrid();

        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.show();

        /*
         * Tämä varmistaa, että näppäimistö toimii heti kun ikkuna avautuu.
         */
        root.requestFocus();
    }

    /*
     * Tämä metodi päivittää ruudukon värit.
     * Musta = pikseli päällä.
     * Valkoinen = pikseli pois päältä.
     * Punainen reunus = kursori.
     */
    private void updateGrid() {

        for (int row = 0; row < pixelGrid.getSize(); row++) {
            for (int col = 0; col < pixelGrid.getSize(); col++) {

                Rectangle cell = cells[row][col];

                if (pixelGrid.isPixelOn(row, col)) {
                    cell.setFill(Color.BLACK);
                } else {
                    cell.setFill(Color.WHITE);
                }

                if (row == pixelGrid.getCursorRow() && col == pixelGrid.getCursorCol()) {
                    cell.setStroke(Color.RED);
                    cell.setStrokeWidth(3);
                } else {
                    cell.setStroke(Color.GRAY);
                    cell.setStrokeWidth(1);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}