import java.awt.*;

public class ChessBoard{
    private Tile[][] tiles;

    final Player playerBlack = new Player(Color.BLACK);
    final Player playerWhite = new Player(Color.WHITE);

    final int ROWS = 8;
    final int COLUMNS = 8;

    public ChessBoard() {
        tiles = new Tile[8][8];
        createTiles();

    }

    public Tile[][] getTiles() {
        return tiles;

    }

    private void createTiles(){
        for(int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                //Creating tile
                tiles[row][col] = new Tile();
            }
        }
    }

}
