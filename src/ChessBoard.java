
import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JFrame{

    private final int TILESIZE = 75;
    private final int NUMBEROFROWS = 8;
    private final int NUMBEROFCOLUMNS = 8;
    private Tile[][] tiles;


    public ChessBoard() throws HeadlessException {
        super();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTiles();
        pack();

    }

    private void setTiles(){

        //Creating array of tiles
        tiles = new Tile[8][8];

        //Creating panel to hold tiles
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(NUMBEROFROWS, NUMBEROFCOLUMNS));
        panel.setPreferredSize(new Dimension(NUMBEROFCOLUMNS * TILESIZE, NUMBEROFROWS * TILESIZE));

        for(int row = 0; row < NUMBEROFROWS; row++) {
            for (int col = 0; col < NUMBEROFCOLUMNS; col++) {

                //Creating tile
                tiles[row][col] = new Tile();

                //Changing color if tile is black
                if((row + col) % 2 != 0)
                tiles[row][col].setBackground(Color.DARK_GRAY);

                //Adding tile to panel
                panel.add(tiles[row][col]);
            }
        }
        //Adding panel to JFrame
        add(panel);
    }



}
