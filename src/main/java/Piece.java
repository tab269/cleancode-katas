/**
 * Created by tom on 19.05.2017.
 */
public class Piece {

    public static final Piece NO_PIECE = new Piece(' ');

    private char pieceType;

    public Piece(char pieceType) {
        this.pieceType = pieceType;
    }

    @Override
    public String toString() {
        return "" + pieceType;
    }

    public void visualize() {
        System.out.print(pieceType);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Piece) && this.pieceType == ((Piece) obj).pieceType ;
    }
}
