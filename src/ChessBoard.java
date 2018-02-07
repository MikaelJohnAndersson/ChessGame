

public class ChessBoard {

    private Tile[][] tiles;

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
                tiles[row][col] = new Tile();
            }
        }
    }

    public void setPiecesOnBoard(){

        for(int column = 0; column < NUMBEROFCOLUMNS; column++) {
            new Pawn(Color.WHITE, tiles[1][column]);
        }

        for(int column = 0; column < NUMBEROFCOLUMNS; column++) {
            new Pawn(Color.BLACK, tiles[6][column]);
        }

    }
}
