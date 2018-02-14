

import javax.swing.*;
import java.awt.*;
import java.awt.Color;


public class ChessGUI extends JFrame {

    private final int TILESIZE = 75;
    private ImageIcon whitePawn = new ImageIcon("ChessGame/Resources/white-pawn.png");
    private ImageIcon blackPawn = new ImageIcon("ChessGame/Resources/black-pawn.png");
    private ImageIcon whiteKnight = new ImageIcon("ChessGame/Resources/white-knight.png");
    private ImageIcon blackKnight = new ImageIcon("ChessGame/Resources/black-knight.png");


    public ChessGUI(ChessBoard board) throws HeadlessException {
        super();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTiles(board);
        setImageIcons(board);
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

        for(Player player : chessBoard.playerList){
            for(Piece piece : player.pieces){
                piece.getTile().setIcon(piece.icon);
            }
        }

    }

    public void setImageIcons(ChessBoard chessBoard){

        for (Player player : chessBoard.playerList) {

            if (player.chessColor == ChessColor.WHITE) {
                for (Piece p : player.pieces) {
                    if (p instanceof Pawn) {
                        p.setIcon(whitePawn);
                    }
                    if (p instanceof Knight) {
                        p.setIcon(whiteKnight);
                    }
                }
            }

            if (player.chessColor == ChessColor.BLACK) {
                for (Piece p : player.pieces) {
                    if (p instanceof Pawn) {
                        p.setIcon(blackPawn);
                    }
                    if (p instanceof Knight) {
                        p.setIcon(blackKnight);
                    }
                }
            }

        }
    }
}
