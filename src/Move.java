public class Move{

    Tile fromTile, toTile;

    public Move(Tile fromTile, Tile toTile) {
        this.fromTile = fromTile;
        this.toTile = toTile;
    }

    public boolean isOneStepUp(){
        return toTile.row - fromTile.row == -1;
    }
    public boolean isOneStepDown(){
        return toTile.row - fromTile.row == 1;
    }
    public boolean isVertical(){
        return toTile.column == fromTile.column;
    }
    public boolean isDiagonal(){
        return Math.abs(toTile.row - fromTile.row) == Math.abs(toTile.column - fromTile.column);
    }
    public boolean isOneStepAnyInAnyDirection(){
        return Math.abs(toTile.row - fromTile.row) < 2 && Math.abs(toTile.column - fromTile.column) < 2;
    }
}