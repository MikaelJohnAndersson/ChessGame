import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;

public class Tile extends JButton {

    int row, col;

    //Setting appereance of button
    public Tile() {
        row = 0;
        col = 0;
        setOpaque(true);
        setUI(new MetalButtonUI());
    }

    public Tile(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }
}
