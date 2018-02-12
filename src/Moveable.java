import java.util.ArrayList;

public interface Moveable {

    void move(Tile toTile);

    boolean isMovable(Move move);

    ArrayList<Move> possibleMoves(ChessBoard board);

}
