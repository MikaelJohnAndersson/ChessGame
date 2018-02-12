public class ChessGame {

    ChessBoard board;
    ChessGUI chessGUI;

    public ChessGame() {
        board = new ChessBoard();
        chessGUI = new ChessGUI(board);
        gameLoop();
    }

    public void gameLoop(){

        while (true) {
            board.playerWhite.makeMove(board);
            chessGUI.renderPieces(board);

            try {
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println(e);
            }

            board.playerBlack.makeMove(board);
            chessGUI.renderPieces(board);

            try {
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println(e);
            }

        }

    }

}
