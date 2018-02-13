import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;

public class Tile extends JButton {
    int row;
    int column;

    public Tile(int row, int column) {
        this.row = row;
        this.column = column;

        setOpaque(true);
        setUI(new MetalButtonUI());
    }
}
