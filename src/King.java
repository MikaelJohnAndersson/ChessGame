import java.util.ArrayList;

public class King extends Piece{

    public King(ChessColor chessColor, ArrayList<Piece> list, Tile tile) {
        super(chessColor, list, tile);
        this.value = 100;
    }

    @Override
    public boolean isMovable(Move move) {
        return (!move.toTile.hasPiece() || move.toTile.hasEnemyPiece(this.chessColor)) && move.isOneStepAnyInAnyDirection();

    }

    @Override
    public String toString() {
        return this.chessColor + " KING";
    }
}
