package org.example;

public interface ChatMediator {
    // rekisteröidään client mediatorille
    void registerClient(ChatClientController client);

    // mediator välittää viestin oikealle clientille
    void sendMessage(String from, String to, String message);
}