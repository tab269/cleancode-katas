/**
 * Created by tom on 19.05.2017.
 */
public class Game {

    private Board b = new Board();
    private Player playerX = new Player(b, 'X');
    private Player playerO = new Player(b, 'O');
    private Player activePlayer = playerX;

    public static void main(String[] args) {
        new Game().play();
    }

    public void play() {
        while (!this.isFinished()) {
            activePlayer.putPieceOnBoard();
            togglePlayers();
        }
        togglePlayers();
        if (b.onePlayerWins()) {
            System.out.println("Player " + activePlayer + " wins.");
        } else {
            System.out.println("Game is drawn.");
        }
    }

    private boolean isFinished() {
        return b.onePlayerWins() || b.isFull();
    }

    private void togglePlayers() {
        if (activePlayer == playerX) {
            activePlayer = playerO;
        } else {
            activePlayer = playerX;
        }
    }
}
