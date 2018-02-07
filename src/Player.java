import java.util.*;

public class Player {
    ArrayList<Piece> pieces = new ArrayList<>();
    int numberOfStartingPawns = 8;


    Player(Color color){
        for (int i = 0; i <numberOfStartingPawns; i++){
            pieces.add(new Pawn(color));

        }
    }
}
