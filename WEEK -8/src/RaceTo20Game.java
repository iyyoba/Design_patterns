import java.util.Random;

public class RaceTo20Game extends Game {

    private int[] scores;
    private int numberOfPlayers;
    private boolean gameEnded = false;
    private int winner = -1;
    private static final int TARGET_SCORE = 20;
    private Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        scores = new int[numberOfPlayers];

        System.out.println("Initializing Race to 20 Game with "
                + numberOfPlayers + " players.");
    }

    @Override
    public boolean endOfGame() {
        return gameEnded;
    }

    @Override
    public void playSingleTurn(int player) {
        int roll = random.nextInt(6) + 1;
        scores[player] += roll;

        System.out.println("Player " + player
                + " rolled " + roll
                + " (Total score: " + scores[player] + ")");

        if (scores[player] >= TARGET_SCORE) {
            gameEnded = true;
            winner = player;
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("Player " + winner + " wins with a score of "
                + scores[winner] + "!");
    }
}