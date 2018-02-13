public class Main {

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        ChessGUI chessGUI = new ChessGUI(board);

        board.playerBlack.makeMove(board.getTiles()[5][6]);
        board.playerWhite.makeMove(board.getTiles()[2][2]);
        chessGUI.renderPieces(board);


    }
}
