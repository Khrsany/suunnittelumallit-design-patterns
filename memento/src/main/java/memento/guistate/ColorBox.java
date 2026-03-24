package memento.guistate;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorBox extends StackPane {
    private final Rectangle rectangle;
    private int colorIndex;

    public ColorBox() {
        this.rectangle = new Rectangle(100, 100);
        this.colorIndex = 0;
        updateColor();
        getChildren().add(rectangle);
    }

    public void nextColor() {
        colorIndex = (colorIndex + 1) % 3;
        updateColor();
    }

    public void setColorIndex(int colorIndex) {
        this.colorIndex = colorIndex;
        updateColor();
    }

    public int getColorIndex() {
        return colorIndex;
    }

    private void updateColor() {
        switch (colorIndex) {
            case 0 -> rectangle.setFill(Color.RED);
            case 1 -> rectangle.setFill(Color.BLUE);
            case 2 -> rectangle.setFill(Color.YELLOW);
            default -> rectangle.setFill(Color.RED);
        }
        rectangle.setStroke(Color.BLACK);
    }
}