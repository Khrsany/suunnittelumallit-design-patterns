package org.example;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ChatClientController {
    // clientin nimi
    private String username;

    // mediator hoitaa viestit
    private ChatMediator mediator;

    // käyttöliittymän osat
    private TextArea chatArea;
    private TextField messageField;
    private ComboBox<String> recipientBox;
    private Button sendButton;

    public ChatClientController(String username, ChatMediator mediator, List<String> allUsers) {
        this.username = username;
        this.mediator = mediator;

        // tehdään käyttöliittymä heti konstruktorissa
        createUI(allUsers);
    }

    public String getUsername() {
        return username;
    }

    private void createUI(List<String> allUsers) {
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);

        messageField = new TextField();
        messageField.setPromptText("Write message here...");

        recipientBox = new ComboBox<>();
        recipientBox.setItems(FXCollections.observableArrayList());

        // omaa nimeä ei voi valita vastaanottajaksi
        for (String user : allUsers) {
            if (!user.equals(username)) {
                recipientBox.getItems().add(user);
            }
        }

        if (!recipientBox.getItems().isEmpty()) {
            recipientBox.setValue(recipientBox.getItems().get(0));
        }

        sendButton = new Button("Send");

        // painike lähettää viestin mediatorin kautta
        sendButton.setOnAction(e -> sendMessage());

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                new Label("Messages"),
                chatArea,
                new Label("Recipient"),
                recipientBox,
                new Label("Message"),
                messageField,
                sendButton
        );

        Stage stage = new Stage();
        stage.setTitle(username);
        stage.setScene(new Scene(root, 400, 350));
        stage.show();
    }

    private void sendMessage() {
        String recipient = recipientBox.getValue();
        String message = messageField.getText().trim();

        // ei lähetetä tyhjää viestiä
        if (recipient == null || message.isEmpty()) {
            return;
        }

        mediator.sendMessage(username, recipient, message);
        messageField.clear();
    }

    public void receiveMessage(String from, String message) {
        // vastaanotettu viesti näkyy muodossa From ...
        chatArea.appendText("From " + from + ": " + message + "\n");
    }

    public void receiveSystemMessage(String message) {
        // tällä näytetään oma lähetetty viesti
        chatArea.appendText(message + "\n");
    }
}