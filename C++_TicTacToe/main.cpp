#include <iostream>

void switchPlayer(char& player) { 
    if (player == 'X') player = 'Y';
    else player = 'X';   
}


void printBoard(char (*board)[3]) { 
    std::cout << "\n___________________\n";
    for (int i = 0; i < 3; ++i) { 
        std::cout << "|  ";
        for (int k = 0; k < 3; ++k) { 
            std::cout << board[i][k] << "  |  " ;
        }
        std::cout << "\n|_____|_____|_____|" << std::endl;
    }
    std::cout << std::endl; 
}


bool isBoardFull (char board[][3]) { 
    for (int i=0; i<3; i++) { 
        for (int j=0; j<3; j++) { 
            if (board[i][j] != 'X' && board[i][j] != 'Y') { 
                return false; 
            }
        }
    }
    return true; 
}


bool isGameOver(char (*board)[3], char player) { 
    // Horizontal check
    for (int row = 0; row < 3; row++) { 
        if (board[row][0] == player && board[row][1] == player && board[row][2] == player) { 
            return true; 
        }
    }

    // Column check
    for (int col = 0; col < 3; col++) { 
        if (board[0][col] == player && board[1][col] == player && board[2][col] == player) { 
            return true; 
        }
    }

    // Diagonal check
    // Left to right
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) { 
        return true; 
    }
    // Right to left
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) { 
        return true; 
    }

    return false; 
}



bool isValidMove(char (*board)[3], char playerSign, char move) { 
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) { 
            if (board[i][j] == move) {
                board[i][j] = playerSign;
                return true; 
            }
        }
    }
    return false; 
}



int main() {

    char board [3][3] = { 
        {'1', '2', '3'}, 
        {'4', '5', '6'}, 
        {'7', '8', '9'}
    }; 

    char player = 'X';
    bool is_game_over = false; 
    bool is_draw = false; 

    while (true) { 
        std::cout << "\n___________________________________________\n";
        printBoard(board);

        while (true) { 
            char move; 
            std::cout << "Player " << player << " turn!" << std::endl; 
            std::cout << "Enter: ";
            std::cin >> move; 

            if (isValidMove(board, player, move)) { 
                break; 
            } else { 
                std::cout << "Invalid move. Try again!" << std::endl; 
            }
        }

        if (isGameOver(board, player)) { 
            break; 
        }
        else if (isBoardFull(board)) { 
            is_draw = true;         
            break; 
        }
        else { 
            switchPlayer(player);
        }
    }


    // Declare the result
    if  (is_draw) { 
        std::cout << "ITS A DRAW :(" << std::endl; 
    }
    else { 
        printBoard (board);
        std::cout << "\nRESULT\n";
        std::cout << player << " has won :)" << std::endl; 
    }

    return 0;
}