package memento.guistate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {
    private Controller controller;

    private ColorBox box1;
    private ColorBox box2;
    private ColorBox box3;
    private CheckBox checkBox;

    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
        controller = new Controller(model);

        box1 = new ColorBox();
        box2 = new ColorBox();
        box3 = new ColorBox();
        checkBox = new CheckBox("Selected");

        controller.setGui(this);

        box1.setOnMouseClicked(e -> controller.changeBoxColor(1));
        box2.setOnMouseClicked(e -> controller.changeBoxColor(2));
        box3.setOnMouseClicked(e -> controller.changeBoxColor(3));

        checkBox.setOnAction(e -> controller.changeCheckbox(checkBox.isSelected()));

        Button historyButton = new Button("Open History");
        historyButton.setOnAction(e -> controller.openHistoryWindow());

        HBox boxes = new HBox(15, box1, box2, box3);
        boxes.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, boxes, checkBox, historyButton);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 450, 250);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                controller.undo();
                event.consume();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                controller.redo();
                event.consume();
            }
        });

        primaryStage.setTitle("Memento GUI State");
        primaryStage.setScene(scene);
        primaryStage.show();

        controller.updateView();
    }

    public void updateFromModel(int box1Color, int box2Color, int box3Color, boolean checkboxSelected) {
        box1.setColorIndex(box1Color);
        box2.setColorIndex(box2Color);
        box3.setColorIndex(box3Color);

        checkBox.setSelected(checkboxSelected);
    }

    public static void main(String[] args) {
        launch(args);
    }
}