import java.util.*;

public class Player {

    ArrayList<Piece> pieces = new ArrayList<>();
    ChessColor chessColor;
    List<Move> possibleMoves;
    List<Move> bestMoves;

    Player(ChessColor chessColor){
        this.chessColor = chessColor;
        possibleMoves = new ArrayList<>();
        bestMoves = new ArrayList<>();
    }

    public void makeMove(ChessBoard board){

        this.possibleMoves.clear();
        this.bestMoves.clear();

        pieces.forEach(piece -> possibleMoves.addAll(piece.possibleMoves(board)));

        Move bestMove = possibleMoves.stream()
                .filter(move -> move.toTile.hasEnemyPiece(this.chessColor))
                .sorted(Comparator.comparing(move -> move.toTile.getPiece().value))
                .findFirst()
                .orElse(null);


        if (bestMove != null){
            Piece piece = bestMove.fromTile.getPiece();
            Piece opponentPiece = bestMove.toTile.getPiece();

            System.out.println(piece + " beats " + opponentPiece + " at " + bestMove.toTile);

            opponentPiece.remove();

            piece.move(bestMove.toTile);

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
        return this.chessColor + " PLAYER";
    }


}
