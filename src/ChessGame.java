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

            for (Player player : board.playerList) {
                player.makeMove(board);

                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e);
                }
                chessGUI.renderPieces(board);
            }
        }

    }

}
