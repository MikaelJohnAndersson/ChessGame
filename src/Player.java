import java.util.*;

public class Player {

    private ArrayList<Piece> pieces = new ArrayList<>();
    private ChessColor chessColor;
    private List<Move> possibleMoves;

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
                .sorted(Comparator.comparing((Move move) -> move.toTile.getPiece().getValue()).reversed())
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

    //Metod som returnerar en lista med spelarens möjliga drag.
    public List<Move> possibleMoves(ChessBoard board){
        //Rensar aktuell spelares lista
        this.possibleMoves.clear();

        //Lagrar de möjliga dragen för varje pjäs i listan
        pieces.forEach(piece -> possibleMoves.addAll(piece.possibleMoves(board)));

        return possibleMoves;
    }

    @Override
    public String toString() {
        return this.chessColor + " PLAYER";
    }


    public ChessColor getChessColor() {
        return chessColor;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

}
