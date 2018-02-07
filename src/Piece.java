import javax.swing.*;

public abstract class Piece implements Moveable{

    Color color;
    Tile currentTile;
    ImageIcon icon;


    public Piece(){
        this.color = null;
        this.currentTile = null;
    }

    public Piece(Color color){
        this.color = color;

    }

    public void setCurrentTile(Tile tile) {
        this.currentTile = tile;

    }

    public void move(Tile toTile) {
        this.setCurrentTile(toTile);
    }


}
