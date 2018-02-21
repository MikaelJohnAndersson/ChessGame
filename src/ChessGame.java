import java.util.Comparator;
import java.util.Scanner;

public class ChessGame{

    ChessBoard board;
    ChessGUI chessGUI;
    boolean gameOver = false;


    public ChessGame() {

        board = new ChessBoard();
        chessGUI = new ChessGUI(board);

        gameLoop();
    }

    public void gameLoop() {

        Scanner scan = new Scanner(System.in);

            while (!gameOver) {

                for (Player player : board.playerList) {

                    if (!gameOver){
                        player.makeMove(board);
                        chessGUI.renderPieces(board);
                        System.out.println("Press any key to continue.");
                        scan.nextLine();
                        isGameOver();
                    }
                }
            }

        System.out.println("WINNING PLAYER IS: " + winningPlayer());
    }


    public void isGameOver() {

        for (Player player : board.playerList) {
            if (player.pieces.stream()
                    .noneMatch(piece -> piece instanceof King)) {
                System.out.println(player + "'S KING IS DEAD! GAME OVER!");
                gameOver = true;
            } else if (player.possibleMoves(board) == null) {
                System.out.println(player + " cannot move. GAME OVER!");
                gameOver = true;
            }
        }
    }

    public Player winningPlayer(){

        return board.playerList.stream()
               .sorted(Comparator.comparingInt((Player o) -> o.pieces.stream().mapToInt((Piece p) -> p.value).sum()).reversed())
                .findFirst()
                .orElse(null);
    }

}
