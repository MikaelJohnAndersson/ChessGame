public abstract class Print {

    public static void printMove(Piece piece, Tile toTile){
        System.out.println("Moving " + piece + " from " + piece.getTile() + " to " + toTile);
    }

    public static void beatsPiece(Piece piece, Piece opponentPiece){
        System.out.println(piece + " beats " + opponentPiece + " at " + opponentPiece.getTile());
    }

    public static void pressEnterToContinue(){
        System.out.println("Press ENTER to continue.");
    }
}
