
import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class ChessGUI extends JFrame {

    private final int TILESIZE = 75;

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

                //Changing color if tile is black
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
            for (Tile column : row){
               column.setIcon(null);
            }
        }

        for(Tile[] row : chessBoard.getTiles()){
            for (Tile column : row){
                if (column.hasPiece()){
                    column.setIcon(column.piece.icon);
                }
            }
        }
    }
}
