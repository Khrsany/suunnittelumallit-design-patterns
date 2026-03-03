import java.util.Random;

public class DiceRaceGame extends Game {

    private int numberOfPlayers;
    private int[] scores;

    private int winningScore;
    private boolean gameEnded;
    private int winnerIndex; // 0..n-1

    private final Random random = new Random();

    public DiceRaceGame(int winningScore) {
        if (winningScore <= 0) throw new IllegalArgumentException("winningScore must be > 0");
        this.winningScore = winningScore;
        this.gameEnded = false;
        this.winnerIndex = -1;
    }

    @Override
    public void initializeGame(int numberOfPlayers) {
        if (numberOfPlayers < 2) {
            throw new IllegalArgumentException("Game needs at least 2 players.");
        }

        this.numberOfPlayers = numberOfPlayers;
        this.scores = new int[numberOfPlayers];
        this.gameEnded = false;
        this.winnerIndex = -1;

        System.out.println("=== Dice Race Game ===");
        System.out.println("Players: " + numberOfPlayers);
        System.out.println("Goal: first to reach " + winningScore + " points wins.");
        System.out.println("----------------------");
    }

    @Override
    public boolean endOfGame() {
        return gameEnded;
    }

    @Override
    public void playSingleTurn(int player) {
        int dice = random.nextInt(6) + 1; // 1..6
        scores[player] += dice;

        System.out.println("Player " + (player + 1) + " rolled " + dice
                + " -> total: " + scores[player]);

        if (scores[player] >= winningScore) {
            gameEnded = true;
            winnerIndex = player;
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("----------------------");
        System.out.println("GAME OVER!");
        System.out.println("Winner: Player " + (winnerIndex + 1) + " with " + scores[winnerIndex] + " points.");
        System.out.println("======================");
    }
}