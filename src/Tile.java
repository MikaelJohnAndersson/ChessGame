import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;

public class Tile extends JButton {


    //Setting appereance of button
    public Tile() {
        setOpaque(true);
        setUI(new MetalButtonUI());
    }
}
