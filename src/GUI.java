import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame{
    private Icon icon = new Icon();

    public GUI(ChessBoard board) throws HeadlessException{
        super();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTiles(board);
        pack();

    }

    public void renderPieces(ChessBoard board, Player player){
        ArrayList<Piece> playerPieces;
        playerPieces = player.pieces;

        for(Piece piece : playerPieces){
            board.getTiles()[piece.row][piece.col].setIcon(icon.getIcon(player,piece));

        }
    }

    private void setTiles(ChessBoard board){

        final int TILESIZE = 75;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(board.ROWS, board.COLUMNS));
        panel.setPreferredSize(new Dimension(board.COLUMNS * TILESIZE, board.ROWS * TILESIZE));

        for (int row = 0; row < board.ROWS; row++) {
            for (int col = 0; col < board.COLUMNS; col++) {
                if ((row + col) % 2 != 0)
                    board.getTiles()[row][col].setBackground(Color.GRAY);

                panel.add(board.getTiles()[row][col]);
            }
        }
        add(panel);
    }
}
