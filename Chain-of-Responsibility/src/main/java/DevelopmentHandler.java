public class DevelopmentHandler extends Handler {

    @Override
    public void handle(Message message) {

        if (message.getType() == MessageType.DEVELOPMENT) {
            System.out.println("Development suggestion received.");
            System.out.println("Logging suggestion: " + message.getContent());
            System.out.println("Suggestion will be prioritized by the development team.\n");
        }
        else if (nextHandler != null) {
            nextHandler.handle(message);
        }

    }
}