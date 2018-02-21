import java.util.Comparator;
import java.util.Scanner;

public class ChessGame{

    ChessBoard board;
    ChessGUI chessGUI;
    boolean gameOver = false;


    public ChessGame() {

        //Skapar brädet och GUI
        board = new ChessBoard();
        chessGUI = new ChessGUI(board);

        //Anropar gameloop
        gameLoop();
    }

    public void gameLoop() {

        Scanner scan = new Scanner(System.in);
        chessGUI.renderPieces(board);
        Print.pressEnterToContinue();
        scan.nextLine();

            while (!gameOver) {

                //Loopar igenom listan med players som finns i board-klassen
                for (Player player : board.players) {

                    if (!gameOver){

                        //Player söker efter möjliga moves och utför ett drag
                        player.makeMove(board);
                        //GUI-klassen renderar pjäserna på sina nya positioner
                        chessGUI.renderPieces(board);

                        Print.pressEnterToContinue();
                        scan.nextLine();

                        //Metod som kollar om någon av spelarna har förlorat sin kung, eller om någon spelare inte kan röra sig
                        isGameOver();
                    }
                }
            }

        System.out.println(winningPlayer() + " WINS!");
    }


    public void isGameOver() {

        //Kollar om någon av spelarna har förlorat sin kung
        for (Player player : board.players) {
            if (player.pieces.stream()
                    .noneMatch(piece -> piece instanceof King)) {
                System.out.println(player + "'S KING IS DEAD! GAME OVER!");
                gameOver = true;

        //KOllar om någon av spelarna inte kan röra sig (Möjliga drag == null)
            } else if (player.possibleMoves(board) == null) {
                System.out.println(player + " cannot move. GAME OVER!");
                gameOver = true;
            }
        }
    }

    //Metod som returnerar vinnaren genom att lägga sortera spelarlistan efter den spelare vars pjäser är värda mest poäng
    public Player winningPlayer(){

        return board.players.stream()
               .sorted(Comparator.comparingInt((Player o) -> o.pieces.stream().mapToInt((Piece p) -> p.value).sum()).reversed())
                .findFirst()
                .orElse(null);
    }

}
