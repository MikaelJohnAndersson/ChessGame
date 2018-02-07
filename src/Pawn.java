

public class Pawn extends Piece {

    public Pawn() {

    }

    public Pawn(Color color) {
        super(color);
    }

    @Override
    boolean moveIsValid(Move move) {
        return super.moveIsValid(move);
    }
}
