public class Main {

    public static void main(String[] args) {

        Handler compensationHandler = new CompensationHandler();
        Handler contactHandler = new ContactHandler();
        Handler developmentHandler = new DevelopmentHandler();
        Handler generalHandler = new GeneralFeedbackHandler();

        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(developmentHandler);
        developmentHandler.setNextHandler(generalHandler);

        Message m1 = new Message(
                MessageType.COMPENSATION,
                "I received a damaged product and want compensation.",
                "customer1@email.com");

        Message m2 = new Message(
                MessageType.CONTACT,
                "Please contact me regarding my order.",
                "customer2@email.com");

        Message m3 = new Message(
                MessageType.DEVELOPMENT,
                "It would be great to add dark mode to the application.",
                "customer3@email.com");

        Message m4 = new Message(
                MessageType.GENERAL,
                "Your service is excellent!",
                "customer4@email.com");

        compensationHandler.handle(m1);
        compensationHandler.handle(m2);
        compensationHandler.handle(m3);
        compensationHandler.handle(m4);

    }
}