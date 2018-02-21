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

        //Lagrar resultatet av possibleMoves() i aktuell spelares possibleMoves-lista
        this.possibleMoves = possibleMoves(board);

        //Filtrerar alla drag med möjlighet att slå ut en motståndarpjäs. Sorterar listan efter motståndarpjäsernas värde och tar högsta värdet.
        Move beatOpponentPiece = possibleMoves.stream()
                .filter(move -> move.toTile.hasEnemyPiece(this.chessColor))
                .sorted(Comparator.comparing((Move move) -> move.toTile.getPiece().value).reversed())
                .findFirst()
                .orElse(null);


        //Utför drag för att slå fiendepjäs om det är möjligt
        if (beatOpponentPiece != null){
            Piece piece = beatOpponentPiece.fromTile.getPiece();

            piece.move(beatOpponentPiece.toTile);

        }

        //Väljer annars ett slumpvalt drag ur possibleMoves
        else if (!possibleMoves.isEmpty()){
            Move move = possibleMoves.get(new Random().nextInt(possibleMoves.size()));
            Piece piece = move.fromTile.getPiece();

            piece.move(move.toTile);
        }
    }

    @Override
    public String toString() {
        return this.chessColor + " PLAYER";
    }

    //Metod som returnerar en lista med spelarens möjliga drag.
    public List<Move> possibleMoves(ChessBoard board){
        //Rensar aktuell spelares lista
        this.possibleMoves.clear();

        //Lagrar de möjliga dragen för varje pjäs i listan
        pieces.forEach(piece -> possibleMoves.addAll(piece.possibleMoves(board)));

        return possibleMoves;
    }


}
