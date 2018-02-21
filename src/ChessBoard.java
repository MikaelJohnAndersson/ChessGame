
import java.util.Arrays;
import java.util.List;

public class ChessBoard {

    private Tile[][] tiles;

    final int NUMBEROFROWS = 8;
    final int NUMBEROFCOLUMNS = 8;
    public List<Player> players;

    //Skapar schackbrädet. Skapar två spelare i en lista. Skapar rutorna tillhörande brädet. Skapar pjäser och sätter ut dem på brädet.
    public ChessBoard() {
        tiles = new Tile[8][8];
        players = Arrays.asList(new Player(ChessColor.BLACK), new Player(ChessColor.WHITE));
        createTiles();
        createPieces();
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void createTiles() {
        for (int row = 0; row < NUMBEROFROWS; row++) {
            for (int col = 0; col < NUMBEROFCOLUMNS; col++) {

                //Creating tile
                tiles[row][col] = new Tile(row, col);
            }
        }
    }

    private void createPieces() {

        int backRow;
        int frontRow;

        for (Player player : players) {

            if (player.getChessColor() == ChessColor.BLACK) {
                frontRow = 6;
                backRow = 7;

            } else {
                frontRow = 1;
                backRow = 0;

            }

            for (int col = 0; col < NUMBEROFCOLUMNS; col++) {
                player.getPieces().add(new Pawn(player.getChessColor(), player.getPieces(), tiles[frontRow][col]));
            }


            for (int col = 0; col < NUMBEROFCOLUMNS; col++) {

                if (col == 1 || col == 6) {
                    player.getPieces().add(new Knight(player.getChessColor(), player.getPieces(), tiles[backRow][col]));
                }

                else if(col == 4)
                    player.getPieces().add(new King(player.getChessColor(), player.getPieces(), tiles[backRow][col]));

                    }

                /*

            } else if (i == 0 || i == 7) {
                    player.pieces.add(new Rook(player.chessColor, player.pieces, tiles[backRow][col]));

            } else if (i == 2 || i == 5) {
               player.pieces.add(new Bishop(backRow, i));

            } else if (i == 3) {
                player.pieces.add(new Queen(backRow, i));

            } else {
                player.pieces.add(new King(backRow, i));

            }
            */
                }

            }
        }


