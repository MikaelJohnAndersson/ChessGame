import java.awt.*;
import java.util.ArrayList;

public class Player{
    Color color;
    ArrayList<Piece> pieces = new ArrayList<>();

    public Player(Color color){
        this.color = color;
        createPieces.pieceList(color);

    }

    private CreatePieces createPieces = (pieceColor) -> {
        int COLUMNS = 8;
        int backRow;
        int frontRow;

        if (pieceColor == Color.WHITE){
            frontRow = 6;
            backRow = 7;

        } else{
            frontRow = 1;
            backRow = 0;

        }

        for (int col = 0; col < COLUMNS; col++){
            pieces.add(new Pawn(frontRow,col));

        }

        for (int i = 0; i < COLUMNS; i++){

            if(i == 0 || i==7){
                pieces.add(new Rook(backRow,i));

            }

            else if(i == 1 || i==6){
                pieces.add(new Knight(backRow,i));

            }

            else if(i == 2 || i==5){
                pieces.add(new Bishop(backRow,i));

            }

            else if(i == 3){
                pieces.add(new Queen(backRow,i));

            }

            else{
                pieces.add(new King(backRow,i));

            }
        }
    };
}
