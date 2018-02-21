
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.HashMap;


public class ChessGUI extends JFrame{

    //Storleken på schackrutorna i pixlar
    private final int TILESIZE = 75;

    //Hashmap som lagrar pjäsernas bildikoner. Ikonen hämtas genom pjäsens toString()-metod
    private HashMap<String, ImageIcon> imageicons = new HashMap<>();
    {
        imageicons.put("WHITE PAWN", new ImageIcon("ChessGame/Resources/white-pawn.png"));
        imageicons.put("BLACK PAWN", new ImageIcon("ChessGame/Resources/black-pawn.png"));
        imageicons.put("WHITE KNIGHT", new ImageIcon("ChessGame/Resources/white-knight.png"));
        imageicons.put("BLACK KNIGHT", new ImageIcon("ChessGame/Resources/black-knight.png"));
        imageicons.put("WHITE KING", new ImageIcon("ChessGame/Resources/white-king.png"));
        imageicons.put("BLACK KING", new ImageIcon("ChessGame/Resources/black-king.png"));
    }

    //Konstruktor sätter upp en ChessGUI(JFrame) och initierar rutorna genom en grid-layout
    public ChessGUI(ChessBoard board) throws HeadlessException {
        super();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTiles(board);
        pack();
    }

    private void setTiles(ChessBoard board) {

        //Creating panel to hold tiles
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(board.NUMBEROFROWS, board.NUMBEROFCOLUMNS));
        panel.setPreferredSize(new Dimension(board.NUMBEROFCOLUMNS * TILESIZE, board.NUMBEROFROWS * TILESIZE));

        for (int row = 0; row < board.NUMBEROFROWS; row++) {
            for (int col = 0; col < board.NUMBEROFCOLUMNS; col++) {

                //Changing chessColor if tile is black
                if ((row + col) % 2 != 0)
                    board.getTiles()[row][col].setBackground(Color.DARK_GRAY);

                //Adding tile to panel
                panel.add(board.getTiles()[row][col]);
            }
        }

        //Adding panel to JFrame
        add(panel);
    }

    void renderPieces(ChessBoard chessBoard) {

        for(Tile[] row : chessBoard.getTiles()){
            for(Tile column : row){
                column.setIcon(null);
            }
        }

        for(Player player : chessBoard.players){
            for(Piece piece : player.pieces){
                piece.getTile().setIcon(imageicons.get(piece.toString()));
            }
        }

    }

}
