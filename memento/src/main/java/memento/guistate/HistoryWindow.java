package memento.guistate;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HistoryWindow {
    public HistoryWindow(Controller controller) {
        Stage stage = new Stage();
        stage.setTitle("History");

        ListView<IMemento> listView = new ListView<>();
        listView.setItems(FXCollections.observableArrayList(controller.getHistory()));

        listView.setOnMouseClicked(event -> {
            IMemento selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                controller.restoreFromHistory(selected);
            }
        });

        BorderPane root = new BorderPane();
        root.setCenter(listView);

        Scene scene = new Scene(root, 700, 400);
        stage.setScene(scene);
        stage.show();
    }
}