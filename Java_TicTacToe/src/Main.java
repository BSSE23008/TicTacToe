
// August 04, 2024

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 3 X 3 Board
        char [][] board  = {
            { '1', '2', '3'},
            { '4', '5', '6'},
            { '7', '8', '9'},
        };

        char[] player = {'X'};
        boolean gameOver = false;
        boolean isDraw = false;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n_________________________________________________\n");
            printBoard(board);

            // This loop checks the validity of the move
            while(true) {
                char move = ' ';
                System.out.println(player[0] + " turn!");
                System.out.print ("Enter your move: ");
                move = scanner.next().charAt(0);
                if (isValidMove(board, player[0], move)) {
                    break;
                } else {
                    System.out.println("Invalid Move!");
                }
            }

            if (haveWon(board, player[0])) {
                break;
            }
            else if (isBoardFull (board)) {
                isDraw = true;
            }
            else {
                player[0] = switchPlayer(player[0]);
            }
        } // Game Loop

        printBoard(board);
        
        // Declare the result :)
        if (isDraw) {
            System.out.println("IT,S A DRAW :(");
        }
        else {
            System.out.println(player[0] + " has won :)\n");
        }

    } // main method


    public static char switchPlayer (char player) {
        if (player == 'X') {
            return 'Y';
        }
        else {
            return 'X';
        }
    }


    // Checking the draw situation
    public static boolean isBoardFull (char[][] board) {
        for (int i=0; i<board.length; ++i) {
            for (int j=0; j< board[i].length; ++j) {
                if (board[i][j] != 'X' && board[i][j] != 'Y') {
                    return false;
                }
            }
        }
        return true;
    }


    // This method will print the table in each iteration :)
    public static void  printBoard (char [][] board) {
        System.out.println("___________________");
        for (int i=0; i < board.length; ++i) {
            System.out.print ("|  ");
            for (int j=0; j < board[i].length; ++j) {
                System.out.print (board[i][j] + "  |  ");
            }
            System.out.println("\n|_____|_____|_____|");
        }
        System.out.println();
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


    public static boolean isValidMove(char [][] board, char playerSign, char move) {
        for (int i=0; i<board.length; ++i) {
            for (int j=0; j<board[i].length; ++j) {
                if (board[i][j] == move) {
                    board[i][j] = playerSign; // The problem is here I think :)
                    return true;
                }
            }
        }
        return false;
    }
} // class Main
