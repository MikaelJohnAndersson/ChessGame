public class Move{

    Tile fromTile, toTile;

    public Move(Tile fromTile, Tile toTile) {
        this.fromTile = fromTile;
        this.toTile = toTile;
    }

    public boolean isOneStepUp(){
        return fromTile.column == toTile.column && toTile.row - fromTile.row == -1;
    }
    public boolean isOneStepDown(){
        return fromTile.column == toTile.column && toTile.row - fromTile.row == 1;
    }
}