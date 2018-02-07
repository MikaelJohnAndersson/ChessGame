import javax.swing.*;

public abstract class Piece {

    Color color;
    Tile currentTile;
    ImageIcon icon;

    public Piece(){
        this.color = null;
        this.currentTile = null;
    }

    public Piece(Color color, Tile currentTile){
        this.color = color;
        this.currentTile = currentTile;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
