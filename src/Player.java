import java.util.*;

public class Player {
    ArrayList<Piece> pieces = new ArrayList<>();
    int numberOfStartingPawns = 8;


    Player(Color color){
        for (int i = 0; i <numberOfStartingPawns; i++){
            pieces.add(new Pawn(color));

        }
    }

    public void makeMove(Tile toTile){

        Piece piece;
        while (true) {
            piece = pickPiece();
            if (piece.isMovable(toTile)) {
                piece.move(toTile);
                break;
            }
        }
    }

    public Piece pickPiece(){

        Random random = new Random();
        return pieces.get(random.nextInt(pieces.size()));
    }

}
