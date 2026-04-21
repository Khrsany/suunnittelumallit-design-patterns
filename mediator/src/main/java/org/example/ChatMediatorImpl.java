package org.example;

import java.util.HashMap;
import java.util.Map;

public class ChatMediatorImpl implements ChatMediator {
    // tänne talletetaan clientit käyttäjänimen perusteella
    private Map<String, ChatClientController> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClientController client) {
        // lisätään client mediatorin tietoon
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String from, String to, String message) {
        ChatClientController sender = clients.get(from);
        ChatClientController receiver = clients.get(to);

        // tarkistetaan että molemmat löytyvät
        if (sender == null || receiver == null) {
            return;
        }

        // lähettäjän ikkunaan näkyy lähtevä viesti
        sender.receiveSystemMessage("To " + to + ": " + message);

        // vastaanottajan ikkunaan näkyy saapuva viesti
        receiver.receiveMessage(from, message);
    }
}