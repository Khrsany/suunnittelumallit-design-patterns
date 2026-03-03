public class Main {
    public static void main(String[] args) {
        int players = 3;
        int goal = 30;

        Game game = new DiceRaceGame(goal);
        game.play(players);
    }
}