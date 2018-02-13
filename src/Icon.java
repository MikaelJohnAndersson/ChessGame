import javax.swing.*;
import java.awt.*;

public class Icon{
    ImageIcon getIcon(Player player, Piece piece){

        String pieceColor;

        if(player.color == Color.black){
           pieceColor = "black";

        }
        else{
            pieceColor = "white";

        }
        String data = "Resources/"+pieceColor+"-"+piece.kindOfPiece+".png";

        return new ImageIcon(data);
    }
}
