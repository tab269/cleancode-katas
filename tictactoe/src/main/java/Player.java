import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tom on 19.05.2017.
 */
public class Player {
    private Stack<Piece> pieces = new Stack<>();
    private Board board;
    private char pieceType;

    public Player(Board board, char pieceType) {
        this.board = board;
        this.pieceType = pieceType;
        for (int i = 0; i < 5; i++) {
            pieces.add(new Piece(pieceType));
        }
    }

    public void putPieceOnBoard() {

        int row;
        int col;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Player " + pieceType + " - Enter row: ");
            row = scanner.nextInt();
            System.out.println();
            System.out.print("Player " + pieceType + " - Enter col: ");
            col = scanner.nextInt();
            System.out.println();
        } while (!board.acceptPiece(pieces.peek(), row, col));

        pieces.pop();

        board.visualize();
    }

    @Override
    public String toString() {
        return "" + pieceType;
    }
}
