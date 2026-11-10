import java.util.Scanner;

public class AdversarialSearch {

    private String[][] board = new String[6][6];

    private int whiteScore = 0;
    private int blackScore = 0;

    private boolean gameEnded = false;

    public void whiteMove(int i, int j) {
        if(board[i][j] == null)
            board[i][j] = "W";
    }

    public void blackMove(int i, int j) {
        if(board[i][j] == null)
            board[i][j] = "B";
    }

    public void printBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        AdversarialSearch game = new AdversarialSearch();
        game.printBoard();

        while (!game.gameEnded) {
            System.out.println("White's move:");
            System.out.print("Enter row and column: ");
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            game.whiteMove(i, j);
            game.printBoard();

            System.out.println("Black's move:");
            System.out.print("Enter row and column: ");
            i = scanner.nextInt();
            j = scanner.nextInt();
            game.blackMove(i, j);
            game.printBoard();

            // Check if the game has ended (for example, if the board is full)
            boolean boardFull = true;
            for (int x = 0; x < 6; x++) {
                for (int y = 0; y < 6; y++) {
                    if (game.board[x][y] == null) {
                        boardFull = false;
                        break;
                    }
                }
                if (!boardFull) break;
            }
            if (boardFull) {
                game.gameEnded = true;
            }
            if (game.gameEnded) {
                System.out.println("Game over!");
            }
            scanner.nextLine(); // Consume the newline character left by scanner.nextInt()

        }
        scanner.close();
    }
    
}
