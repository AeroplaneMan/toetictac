import javax.sound.sampled.Clip;
import java.util.Scanner;
public class Main {
    private char[][] board;
    private char currentPlayer;

    // Constructor to initialize the game
    public Main() {
        board = new char[3][3];
        currentPlayer = 'X';

        // Initialize the board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Method to print the current state of the board
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Method to make a move on the board
    public boolean makeMove(int row, int col) {
        Sound playMakeMove = new Sound();
        Picture photoMakeMove = new Picture();
        // Check if the move is valid
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            System.out.println("\n\n\n\n\nInvalid move you silly goose.\n\n\n\n");
            return false;
        }

        // Make the move
        board[row][col] = currentPlayer;
        return true;
    }

    // Method to check if the current player has won
    public boolean checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    // Method to check if the board is full, resulting in a draw
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Method to switch to the next player
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Main method to run the game
    public static void main(String[] args) throws InterruptedException {
        Sound playMain = new Sound();
        Picture photoMain = new Picture();
        Scanner scanner = new Scanner(System.in);
        Main game = new Main();
        try {
            playMain.playMusic("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\Driftveil City [Pokémon： Black & White].wav\\");
            photoMain.OpenPicture("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\pondering.png", 880, 1159);
            // Game loop
            while (true) {
                game.printBoard();
                // Get the move from the current player
                System.out.print("Player " + game.currentPlayer + ", enter your row of choice (1-3): ");
                int row = scanner.nextInt() - 1;
                System.out.print("Player " + game.currentPlayer + ", enter your column of choice (1-3): ");
                int col = scanner.nextInt() - 1;
                // Make the move and check for a win or draw
                if (game.makeMove(row, col)) {
                    playMain.clip.stop();
                    Thread.sleep(1000);
                    if (game.checkWin()) {
                        System.out.println("\n\n\n\n\n");
                        game.printBoard();
                        playMain.stopAndPlaySound("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\free-bird-(bad).wav\\");
                        photoMain.frame.setVisible(false);
                        photoMain.OpenPicture("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\youre-Winner.jpg", 750, 850);
                        photoMain.frame.setVisible(true);
                        System.out.println("Player " + game.currentPlayer + " wins!");
                        break;
                    }
                    if (game.isBoardFull()) {
                        game.printBoard();
                        playMain.stopAndPlaySound("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\prowler-(long).wav\\");
                        photoMain.frame.setVisible(false);
                        photoMain.OpenPicture("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\goku.jpg", 1200, 675);
                        photoMain.frame.setVisible(true);
                        System.out.println("It's a draw...");
                        break;
                    }
                    playMain.playMusic("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\correct.wav\\");
                    photoMain.frame.setVisible(false);
                    photoMain.OpenPicture("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\yuh-huh.png", 718, 699);
                    photoMain.frame.setVisible(true);
                    playMain.playMusic("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\Driftveil City [Pokémon： Black & White].wav\\");
                    System.out.println("\n");
                    // Switch to the next player
                    game.switchPlayer();
                } else {
                    playMain.clip.stop();
                    Thread.sleep(1000);
                    playMain.playMusic("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\Lie.wav\\");
                    playMain.playMusic("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\hahaha1.wav\\");
                    photoMain.frame.setVisible(false);
                    photoMain.OpenPicture("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\nuh-uh.jpg", 705, 542);
                    photoMain.frame.setVisible(true);
                }
            }

            scanner.close();
        }
        catch (Exception e){
            playMain.clip.stop();
            Thread.sleep(1000);
            playMain.playMusic("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\Lie.wav\\");
            playMain.clip.loop(Clip.LOOP_CONTINUOUSLY);
            playMain.playMusic("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\hahaha1.wav\\");
            playMain.clip.loop(Clip.LOOP_CONTINUOUSLY);
            photoMain.frame.setVisible(false);
            photoMain.OpenPicture("C:\\Users\\Administrator\\Lucas-work-Java\\toetictac-assets\\nuh-uh.jpg", 705, 542);
            photoMain.frame.setVisible(true);
            System.out.println("\nGame over you bum, better luck next time");
        }
    }
}