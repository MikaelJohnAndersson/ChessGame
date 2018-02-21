
import java.util.ArrayList;

public abstract class Piece implements Moveable{

    ChessColor chessColor;
    Tile tile;
    ArrayList<Piece> list;
    int value;

    public Piece(ChessColor chessColor, ArrayList<Piece> list, Tile tile){
        //Pjäsens färg
        this.chessColor = chessColor;
        //Tillhörande spelares pjäslista
        this.list = list;
        //Pjäsens nuvarande schackruta
        this.tile = tile;
        //Sätter rutans pjäs till denna pjäs
        this.tile.setPiece(this);
    }

    @Override
    public void move(Tile toTile) {

        System.out.println("Moving " + this + " from " + this.getTile() + " to " + toTile);

        //Om pjäsen slår slår fiendepjäs
        if(toTile.hasEnemyPiece(this.chessColor)){
            Piece opponentPiece = toTile.getPiece();
            System.out.println(this + " beats " + opponentPiece + " at " + toTile);
            opponentPiece.remove();
        }

        //Sätter nuvarande rutas pjäs till null. Sätter ny rutas pjäs till denna pjäs. Sätter pjäsens ruta till den nya rutan.
        tile.setPiece(null);
        toTile.setPiece(this);
        setTile(toTile);
    }

    @Override
    public ArrayList<Move> possibleMoves(ChessBoard board) {

        Move move;
        ArrayList<Move> possibleMoves = new ArrayList<>();

        //Loopar igenom schackbrädet och returnerar möjliga drag från pjäsens nuvarande position
        for(Tile[] row : board.getTiles()){
            for (Tile column : row){
                move = new Move(tile, column);
                if(isMovable(move)){
                    possibleMoves.add(move);
                }
            }
        }

        return possibleMoves;
    }


    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    //Tar bort pjäsen från sin lista
    public void remove(){
        list.remove(this);
    }
}
