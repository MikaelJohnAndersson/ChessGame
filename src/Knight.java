import javax.swing.*;
import java.util.ArrayList;

public class Knight extends Piece{

    private ImageIcon whiteKnight = new ImageIcon("ChessGame/Resources/white-knight.png");
    private ImageIcon blackKnight = new ImageIcon("ChessGame/Resources/black-knight.png");

    public Knight(Color color, ArrayList<Piece> list, Tile tile) {
        super(color, list, tile);

        if (color == Color.BLACK){
            this.icon = blackKnight;
        }
        else {
            this.icon = whiteKnight;
        }
    }

    @Override
    public boolean isMovable(Move move) {
        int diffRow = Math.abs(move.toTile.row - this.tile.row);
        int diffCol = Math.abs(move.toTile.column - this.tile.column);

        if(!move.toTile.hasPiece() || move.toTile.hasEnemyPiece(this.color)) {
            return diffRow == 2 && diffCol == 1 || diffRow == 1 && diffCol == 2;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.color + " KNIGHT";
    }
}
