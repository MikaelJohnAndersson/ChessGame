

public class ChessBoard {

    private Tile[][] tiles;

    final int NUMBEROFROWS = 8;
    final int NUMBEROFCOLUMNS = 8;

    public ChessBoard() {
        tiles = new Tile[8][8];
        setTiles();
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(){
        for(int row = 0; row < NUMBEROFROWS; row++) {
            for (int col = 0; col < NUMBEROFCOLUMNS; col++) {

                //Creating tile
                tiles[row][col] = new Tile();
            }
        }
    }
}
