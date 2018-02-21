import java.util.ArrayList;

public class King extends Piece{

    public King(ChessColor chessColor, ArrayList<Piece> list, Tile tile) {
        super(chessColor, list, tile);
        this.value = 1000;
    }

    @Override
    public boolean isMovable(Move move) {

        if(!move.toTile.hasPiece() || move.toTile.hasEnemyPiece(this.chessColor)){
        return move.isOneStepAnyInAnyDirection();
        }
        return false;
    }

    @Override
    public String toString() {
        return this.chessColor + " KING";
    }
}
