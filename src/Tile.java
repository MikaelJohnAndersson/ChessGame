import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;

public class Tile extends JButton {

    //Setting appereance of tile
    public Tile() {
        setOpaque(true);
        setUI(new MetalButtonUI());
    }
}
