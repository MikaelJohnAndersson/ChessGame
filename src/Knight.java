
import java.util.ArrayList;

public class Knight extends Piece{

    public Knight(ChessColor chessColor, ArrayList<Piece> list, Tile tile) {
        super(chessColor, list, tile);
        this.value = 20;
    }

    @Override
    public boolean isMovable(Move move) {
        int diffRow = Math.abs(move.toTile.row - this.tile.row);
        int diffCol = Math.abs(move.toTile.column - this.tile.column);

        if(!move.toTile.hasPiece() || move.toTile.hasEnemyPiece(this.chessColor)) {
            return diffRow == 2 && diffCol == 1 || diffRow == 1 && diffCol == 2;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.chessColor + " KNIGHT";
    }
}
