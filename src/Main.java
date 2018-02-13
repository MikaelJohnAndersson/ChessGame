public class Main{

    public static void main(String[] args){
        ChessBoard chessBoard = new ChessBoard();
        GUI gui = new GUI(chessBoard);

        gui.renderPieces(chessBoard,chessBoard.playerWhite);
        gui.renderPieces(chessBoard,chessBoard.playerBlack);

    }
}
