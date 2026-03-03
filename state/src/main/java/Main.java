import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Game Character Development (State Pattern) ===");
        System.out.print("Enter character name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "Hero";

        GameCharacter character = new GameCharacter(name);

        while (!character.isGameFinished()) {
            System.out.print(character.statusText());
            System.out.println(character.getState().availableActionsText());
            System.out.print("Choose action (number) or 0 to quit: ");

            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                System.out.println("You quit the game. Bye!");
                return;
            }

            switch (input) {
                case "1" -> character.train();
                case "2" -> character.meditate();
                case "3" -> character.fight();
                default -> System.out.println("Invalid choice. Try again.");
            }

            if (!character.isAlive()) {
                System.out.println("Your HP reached 0. Game over.");
                return;
            }

            if (character.isGameFinished()) {
                System.out.print(character.statusText());
                System.out.println(">>> Congratulations! You reached MASTER level. Game ends.");
                return;
            }

            System.out.println();
        }
    }
}