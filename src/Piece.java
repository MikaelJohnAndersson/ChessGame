import javax.swing.*;

public abstract class Piece {

    Color color;
    Tile currentTile;
    ImageIcon icon;

    boolean moveIsValid(Move move){

        return false;
    };

    public Piece(){
        this.color = null;
        this.currentTile = null;
    }

    public Piece(Color color){
        this.color = color;

    }


    public Tile getCurrentTile() {
        return currentTile;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCurrentTile(Tile tile) {
        this.currentTile = tile;

    }
}
