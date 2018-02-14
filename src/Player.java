import java.util.*;
import java.util.stream.Collectors;

public class Player {

    ArrayList<Piece> pieces = new ArrayList<>();
    Color color;
    List<Move> possibleMoves;
    List<Move> bestMoves;

    Player(Color color){
        this.color = color;
        possibleMoves = new ArrayList<>();
        bestMoves = new ArrayList<>();
    }

    public void makeMove(ChessBoard board){

        this.possibleMoves.clear();
        this.bestMoves.clear();

        for(Piece p : pieces){
            possibleMoves.addAll(p.possibleMoves(board));
        }

       bestMoves = possibleMoves.stream()
                .filter(move -> move.toTile.hasEnemyPiece(this.color))
                .collect(Collectors.toList());

        if (!bestMoves.isEmpty()){
            Move move = bestMoves.get(new Random().nextInt(bestMoves.size()));
            Piece piece = move.fromTile.getPiece();

            Piece opponentPiece = move.toTile.getPiece();
            System.out.println(piece + " beats " + opponentPiece + " at " + move.toTile);

            opponentPiece.remove();

            piece.move(move.toTile);

        }
        else if (!possibleMoves.isEmpty()){
            Move move = possibleMoves.get(new Random().nextInt(possibleMoves.size()));
            Piece piece = move.fromTile.getPiece();

            piece.move(move.toTile);
        }
        else{
            System.out.println(this + " cannot move. GAME OVER!");
        }


    }

    @Override
    public String toString() {
        return this.color + " PLAYER";
    }


}
