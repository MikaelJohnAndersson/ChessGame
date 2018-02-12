

public class ChessBoard {

    private Tile[][] tiles;

    final Player playerBlack = new Player(Color.BLACK);
    final Player playerWhite = new Player(Color.WHITE);

    final int NUMBEROFROWS = 8;
    final int NUMBEROFCOLUMNS = 8;

    public ChessBoard() {
        tiles = new Tile[8][8];
        createTiles();
        setPiecesOnBoard();
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void createTiles(){
        for(int row = 0; row < NUMBEROFROWS; row++) {
            for (int col = 0; col < NUMBEROFCOLUMNS; col++) {

                //Creating tile
                tiles[row][col] = new Tile(row, col);
            }
        }
    }

    public void setPiecesOnBoard(){
        //Setting pawns for white
        for(int column = 0; column < NUMBEROFCOLUMNS; column++) {
            Piece piece = playerWhite.pieces.get(column);
            tiles[1][column].setPiece(piece);
            piece.setPosition(tiles[1][column]);
        }

        //Setting pawns for black
        for(int column = 0; column < NUMBEROFCOLUMNS; column++) {
            Piece piece = playerBlack.pieces.get(column);
            tiles[6][column].setPiece(piece);
            piece.setPosition(tiles[6][column]);
        }
    }
}
