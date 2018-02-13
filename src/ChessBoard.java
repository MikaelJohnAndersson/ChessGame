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

    private void createTiles(){
        for(int row = 0; row < NUMBEROFROWS; row++) {
            for (int col = 0; col < NUMBEROFCOLUMNS; col++) {
                //Creating tile
                tiles[row][col] = new Tile(row, col);
            }
        }
    }

    private void setPiecesOnBoard(){
        for(int column = 0; column < NUMBEROFCOLUMNS; column++) {
            playerWhite.pieces.get(column).setCurrentTile(tiles[1][column]);
        }

        for(int column = 0; column < NUMBEROFCOLUMNS; column++) {
            playerBlack.pieces.get(column).setCurrentTile(tiles[6][column]);
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
