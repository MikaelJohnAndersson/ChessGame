
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.HashMap;

public class ChessGUI extends JFrame{

    private HashMap<String, ImageIcon> imageicons = new HashMap<>();
    {
        imageicons.put("WHITE PAWN", new ImageIcon("Resources/white-pawn.png"));
        imageicons.put("BLACK PAWN", new ImageIcon("Resources/black-pawn.png"));
        imageicons.put("WHITE KNIGHT", new ImageIcon("Resources/white-knight.png"));
        imageicons.put("BLACK KNIGHT", new ImageIcon("Resources/black-knight.png"));
        imageicons.put("WHITE KING", new ImageIcon("Resources/white-king.png"));
        imageicons.put("BLACK KING", new ImageIcon("Resources/black-king.png"));
    }

    public ChessGUI(ChessBoard board) throws HeadlessException {
        super();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTiles(board);
        pack();
    }

    private void setTiles(ChessBoard board) {
        final int TILESIZE = 75;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(board.NUMBEROFROWS, board.NUMBEROFCOLUMNS));
        panel.setPreferredSize(new Dimension(board.NUMBEROFCOLUMNS * TILESIZE, board.NUMBEROFROWS * TILESIZE));

        for (int row = 0; row < board.NUMBEROFROWS; row++) {
            for (int col = 0; col < board.NUMBEROFCOLUMNS; col++) {
                if ((row + col) % 2 != 0) {
                    board.getTiles()[row][col].setBackground(Color.DARK_GRAY);
                }
                panel.add(board.getTiles()[row][col]);
            }
        }
        add(panel);
    }

    public void renderPieces(ChessBoard chessBoard) {

        for(Tile[] row : chessBoard.getTiles()){
            for(Tile column : row){
                column.setIcon(null);
            }
        }
        for(Player player : chessBoard.playerList){
            for(Piece piece : player.pieces){
                piece.getTile().setIcon(imageicons.get(piece.toString()));

            }
        }
    }
}
