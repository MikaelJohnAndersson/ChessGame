import java.util.*;

public class Player {

    ArrayList<Piece> pieces = new ArrayList<>();
    ChessColor chessColor;
    List<Move> possibleMoves;

    Player(ChessColor chessColor){
        this.chessColor = chessColor;
        possibleMoves = new ArrayList<>();
    }

    public void makeMove(ChessBoard board){

        Move bestMove = possibleMoves.stream()
                .filter(move -> move.toTile.hasEnemyPiece(this.chessColor))
                .sorted(Comparator.comparing(move -> move.toTile.getPiece().value))
                .reduce((first, second) -> second)
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
    }

    public void initiateMoves(ChessBoard board){
        this.possibleMoves.clear();

        pieces.forEach(piece -> possibleMoves.addAll(piece.possibleMoves(board)));


    }

    @Override
    public String toString() {
        return this.chessColor + " PLAYER";
    }


}
