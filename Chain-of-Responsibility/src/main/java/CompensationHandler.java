public class CompensationHandler extends Handler {

    @Override
    public void handle(Message message) {

        if (message.getType() == MessageType.COMPENSATION) {
            System.out.println("Compensation claim received from: " + message.getSenderEmail());
            System.out.println("Reviewing compensation request: " + message.getContent());
            System.out.println("Decision: Claim approved or rejected.\n");
        }
        else if (nextHandler != null) {
            nextHandler.handle(message);
        }

    }
}