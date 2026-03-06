public class GeneralFeedbackHandler extends Handler {

    @Override
    public void handle(Message message) {

        if (message.getType() == MessageType.GENERAL) {
            System.out.println("General feedback received from: " + message.getSenderEmail());
            System.out.println("Analyzing feedback: " + message.getContent());
            System.out.println("Thank you for your feedback!\n");
        }
        else if (nextHandler != null) {
            nextHandler.handle(message);
        }

    }
}