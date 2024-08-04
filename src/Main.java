
// August 04, 2024

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        char [][] board1  = {
            { '1', '2', '3'},
            { '4', '5', '6'},
            { '7', '8', '9'},
        };
         */

        // 3 X 3 Board
        char[][] board = new char[3][3];

        // Initializing the board
        for (int i=0; i < board.length; ++i) {
            for (int j=0; j < board[i].length; ++j) {
                board [i][j] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.println("__________________________________");
            printBoard(board);
            System.out.println("Player " + player + " turn. ");
            System.out.print("Enter row: ");
            int i = scanner.nextInt();
            System.out.print("Enter col: ");
            int j = scanner.nextInt();

            if (board[i][j] == ' ') {
                board[i][j] = player; // Place the element
                gameOver = haveWon (board, player);
                if (gameOver) {
                    System.out.println(player + " Player has won :)");
                }
                else {
                    player = switchPlayer(player);
                }
            }
            else {
                System.out.println("Invalid move. Try again!");
            }
        } // Game loop
        printBoard(board);
    }


    public static char switchPlayer (char player) {
        if (player == 'X') {
            return 'O';
        }
        else {
            return 'X';
        }
    }


    // This method will print the table in each iteration :)
    public static void  printBoard (char [][] board) {
        for (int i=0; i < board.length; ++i) {
            for (int j=0; j < board[i].length; ++j) {
                System.out.print (board[i][j] + " | ");
            }
            System.out.println();
        }
    }


    // This method is responsible to check if the player has won or not
    public static boolean haveWon (char[][] board, char player) {
        // Rows
        for (int i=0; i < board.length; ++i) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Columns
        for (int i=0; i< board.length; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Diagonals
        // Left to right diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        // Right to left diagonal
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}


/*
// Using ternary operator
// player = (player == 'X') ? 'X' : 'O';
*/