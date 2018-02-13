import java.util.*;

public class Player {
    ArrayList<Piece> pieces = new ArrayList<>();
    private final int numberOfStartingPawns = 8;


    Player(Color color){
        for (int i = 0; i <numberOfStartingPawns; i++){
            pieces.add(new Pawn(color));

        }
    }

    private Piece pickPiece(){
        Random random = new Random();
        return pieces.get(random.nextInt(pieces.size()));

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


}
