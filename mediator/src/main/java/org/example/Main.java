package org.example;
import javafx.application.Application;
import javafx.stage.Stage;
import org.example.ChatClientController;
import org.example.ChatMediator;
import org.example.ChatMediatorImpl;

import java.util.Arrays;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // mediator on viestinnän keskuspiste
        ChatMediator mediator = new ChatMediatorImpl();

        // vähintään kolme clientiä tehtävänannon mukaan
        List<String> usernames = Arrays.asList("Alice", "Bob", "Charlie");

        // luodaan client controllerit
        ChatClientController alice = new ChatClientController("Alice", mediator, usernames);
        ChatClientController bob = new ChatClientController("Bob", mediator, usernames);
        ChatClientController charlie = new ChatClientController("Charlie", mediator, usernames);

        // rekisteröidään ne mediatorille
        mediator.registerClient(alice);
        mediator.registerClient(bob);
        mediator.registerClient(charlie);
    }

    public static void main(String[] args) {
        launch(args);
    }
}