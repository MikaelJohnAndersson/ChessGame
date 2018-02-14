import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;

public class Tile extends JButton {

    int row;
    int column;
    Piece piece;

    //Setting appereance of tile
    public Tile(int row, int column) {
        this.row = row;
        this.column = column;
        this.piece = null;

        setOpaque(true);
        setUI(new MetalButtonUI());
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean hasPiece(){
        return piece != null;
    }

    public boolean hasEnemyPiece(ChessColor chessColor){
        if (piece != null) {
            return chessColor != piece.chessColor;
        }
        else
            return false;
    }

    @Override
    public String toString(){
        return row + "*" + column;
    }

}
