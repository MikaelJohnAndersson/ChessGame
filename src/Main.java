public class Main {

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();

        ChessGUI chessGUI = new ChessGUI(board);


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
