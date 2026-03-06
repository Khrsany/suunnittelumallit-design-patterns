public class ContactHandler extends Handler {

    @Override
    public void handle(Message message) {

        if (message.getType() == MessageType.CONTACT) {
            System.out.println("Contact request from: " + message.getSenderEmail());
            System.out.println("Forwarding message to customer service department.");
            System.out.println("Message: " + message.getContent() + "\n");
        }
        else if (nextHandler != null) {
            nextHandler.handle(message);
        }

    }
}