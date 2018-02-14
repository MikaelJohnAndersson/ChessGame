import javax.swing.*;
import java.util.ArrayList;

public abstract class Piece implements Moveable{

    Color color;
    ImageIcon icon;
    Tile tile;
    ArrayList<Piece> list;


    public Piece(Color color, ArrayList<Piece> list, Tile tile){
        this.color = color;
        this.list = list;
        this.tile = tile;
        this.tile.setPiece(this);
    }

    @Override
    public void move(Tile toTile) {

        System.out.println("Moving " + this + " from " + this.getTile() + " to " + toTile);

        tile.setPiece(null);
        toTile.setPiece(this);
        setTile(toTile);
    }

    @Override
    public ArrayList<Move> possibleMoves(ChessBoard board) {

        ArrayList<Move> possibleMoves = new ArrayList<>();
        Move move;

        for(Tile[] row : board.getTiles()){
            for (Tile column : row){
                move = new Move(tile, column);
                if(isMovable(move)){
                    possibleMoves.add(move);
                }
            }
        }

        return possibleMoves;
    }


    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    public void remove(){
        list.remove(this);
    }
}
