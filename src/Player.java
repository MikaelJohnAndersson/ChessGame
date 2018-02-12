import java.util.*;

public class Player {
    ArrayList<Piece> pieces = new ArrayList<>();
    int numberOfStartingPawns = 8;
    Color color;


    Player(Color color){
        this.color = color;
        for (int i = 0; i <numberOfStartingPawns; i++){
            pieces.add(new Pawn(color, pieces));
        }
    }

    public void makeMove(ChessBoard board){

       List<Move> possibleMoves = new ArrayList<>();
       List<Move> bestMoves = new ArrayList<>();

       for(Piece p : pieces){
           possibleMoves.addAll(p.possibleMoves(board));
       }

        for(Move move : possibleMoves){
            if(move.toTile.hasPiece()) {
                if (move.toTile.hasEnemyPiece(this.color)) {
                    bestMoves.add(move);
                }
            }
        }

        if (!bestMoves.isEmpty()){
            Move move = bestMoves.get(new Random().nextInt(bestMoves.size()));
            Piece piece = move.fromTile.getPiece();

            Piece opponentPiece = move.toTile.getPiece();
            opponentPiece.remove();

            piece.move(move.toTile);

        }
        else{
            Move move = possibleMoves.get(new Random().nextInt(possibleMoves.size()));
            Piece piece = move.fromTile.getPiece();

            piece.move(move.toTile);
        }


    }

}
