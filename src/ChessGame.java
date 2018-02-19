import java.util.Scanner;

public class ChessGame{

    ChessBoard board;
    ChessGUI chessGUI;


    public ChessGame() {

        board = new ChessBoard();
        chessGUI = new ChessGUI(board);

        gameLoop();
    }

    public void gameLoop() {

        Scanner scan = new Scanner(System.in);
        boolean gameOver = false;

            while (!gameOver) {

                for (Player player : board.playerList) {

                    if (!gameOver){
                        player.initiateMoves(board);
                        player.makeMove(board);

                        chessGUI.renderPieces(board);

                        System.out.println("Press any key to continue.");
                        scan.nextLine();

                        gameOver = isGameOver(player);
                    }

                }
            }



    }


    public boolean isGameOver(Player player) {

        Boolean isKingAlive = player.pieces.stream()
                .anyMatch(piece -> piece instanceof King);

        if(!isKingAlive){
            System.out.println(player + "'S KING IS DEAD! GAME OVER!");
            return true;
        }

        else if (player.possibleMoves.isEmpty()) {

            System.out.println(player + " cannot move. GAME OVER!");

            Player player1 = board.playerList.get(0);
            Player player2 = board.playerList.get(1);

            if(player1.pieces.size() > player2.pieces.size()){
                System.out.println(player1.chessColor + " PLAYER IS THE WINNER!");
            }
            else{
                System.out.println(player2.chessColor + " PLAYER IS THE WINNER!");
            }
                return true;
        }
        return false;
    }

}
