
import java.util.ArrayList;

public class Pawn extends Piece {


    public Pawn(ChessColor chessColor, ArrayList<Piece> pieces, Tile tile) {
        super(chessColor, pieces, tile);
        this.value = 10;
    }

    @Override
    public boolean isMovable(Move move) {

        //Om destinationsrutan inte har en pjäs på sig
        if(!move.toTile.hasPiece()) {
            if (chessColor == ChessColor.BLACK && move.isOneStepUp() && move.isVertical()) {
                return true;
            }

            if (chessColor == ChessColor.WHITE && move.isOneStepDown() && move.isVertical()) {
                return true;
            }
        }
        //Om destinationsrutan har en fiendepjäs och draget är diagonalt
        else if (move.toTile.hasEnemyPiece(this.chessColor) && move.isDiagonal()){
            if (chessColor == ChessColor.BLACK && move.isOneStepUp()) {
                return true;
            }

            if (chessColor == ChessColor.WHITE && move.isOneStepDown()) {
                return true;
            }
        }

        //(Om destinationsrutan har en pjäs och draget inte är diagonalt och/eller ett steg)
        return false;
    }

    @Override
    public String toString() {
        return this.chessColor + " PAWN";
    }
}
