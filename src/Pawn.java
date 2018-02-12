import javax.swing.*;
import java.util.ArrayList;

public class Pawn extends Piece {

    private ImageIcon whitePawn = new ImageIcon("ChessGame/Resources/white-pawn.png");
    private ImageIcon blackPawn = new ImageIcon("ChessGame/Resources/black-pawn.png");

    public Pawn(Color color, ArrayList<Piece> pieces) {
        super(color, pieces);

        if (color == Color.BLACK){
            this.icon = blackPawn;
        }
        else {
            this.icon = whitePawn;
        }

    }

    @Override
    public boolean isMovable(Move move) {

        if(!move.toTile.hasPiece()) {
            if (color == Color.BLACK && move.isOneStepUp() && move.isVertical()) {
                return true;
            }

            if (color == Color.WHITE && move.isOneStepDown() && move.isVertical()) {
                return true;
            }
        }
        else if (move.toTile.hasEnemyPiece(this.color) && move.isDiagonal()){
            if (color == Color.BLACK && move.isOneStepUp()) {
                return true;
            }

            if (color == Color.WHITE && move.isOneStepDown()) {
                return true;
            }
        }

        return false;
    }

}
