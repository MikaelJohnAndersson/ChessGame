
public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);

    }

    @Override
    public boolean isMovable(Tile toTile) {
        Tile fromTile = this.currentTile;

        if(fromTile.column == toTile.column && toTile.row - fromTile.row == 1 || toTile.row - fromTile.row == -1 && fromTile.column == toTile.column){

            return true;

        }

        return false;
    }
}
