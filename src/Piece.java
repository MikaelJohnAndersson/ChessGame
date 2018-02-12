import javax.swing.*;
import java.util.ArrayList;

public abstract class Piece implements Moveable{

    Color color;
    ImageIcon icon;
    Tile position;
    ArrayList<Piece> list;


    public Piece(Color color, ArrayList<Piece> list){
        this.color = color;
        this.list = list;
    }

    @Override
    public void move(Tile toTile) {
        position.setPiece(null);
        toTile.setPiece(this);
        setPosition(toTile);
    }

    @Override
    public ArrayList<Move> possibleMoves(ChessBoard board) {

        ArrayList<Move> possibleMoves = new ArrayList<>();
        Move move;

        for(Tile[] row : board.getTiles()){
            for (Tile column : row){
                move = new Move(position, column);
                if(isMovable(move)){
                    possibleMoves.add(move);
                }
            }
        }

        return possibleMoves;
    }


    public void setPosition(Tile position) {
        this.position = position;
    }

    public void remove(){
        list.remove(this);
    }
}
