/**
 * Created by tom on 19.05.2017.
 */
public class Board {

    private Piece pieces[][] = new Piece[3][3];

    public Board() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                pieces[row][col] = Piece.NO_PIECE;
            }
        }
    }

    public void visualize() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                pieces[row][col].visualize();
            }
            System.out.println();
        }
    }

    public boolean acceptPiece(Piece piece, int row, int col) {
        boolean isFree = pieces[row][col] == Piece.NO_PIECE;
        if (isFree) {
            pieces[row][col] = piece;
        }
        return  isFree;
    }




    public boolean has3InARow() {
        for (int row = 0; row < 3; row++) {
            if (pieces[row][0].equals(pieces[row][1]) && pieces[row][1].equals(pieces[row][2]) && !pieces[row][0].equals(Piece.NO_PIECE))
                return true;
        }
        return false;
    }

    public boolean has3InACol() {
        for (int col = 0; col < 3; col++) {
            if (pieces[0][col].equals(pieces[1][col]) && pieces[1][col].equals(pieces[2][col]) && !pieces[0][col].equals(Piece.NO_PIECE))
                return true;
        }
        return false;
    }

    public boolean has3InDiag() {
        return pieces[0][0].equals(pieces[1][1]) && pieces[1][1].equals(pieces[2][2]) && !pieces[0][0].equals(Piece.NO_PIECE);
    }

    public boolean has3InAntiDiag() {
        return pieces[0][2].equals(pieces[1][1]) && pieces[1][1].equals(pieces[2][0]) && !pieces[2][0].equals(Piece.NO_PIECE);
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (pieces[row][col] == Piece.NO_PIECE) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean onePlayerWins() {
        return has3InARow() || has3InACol() || has3InDiag() || has3InAntiDiag();
    }
}
