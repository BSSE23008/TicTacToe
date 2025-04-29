
// Function to switch the current player
function switchPlayer(player) {
    return player === 'X' ? 'Y' : 'X';
}

// Function to print the board in the console
function printBoard(board) {
    console.log("\n___________________");
    for (let i = 0; i < 3; i++) {
        let row = "|  ";
        for (let j = 0; j < 3; j++) {
            row += board[i][j] + "  |  ";
        }
        console.log(row);
        console.log("|_____|_____|_____|");
    }
    console.log();
}

// Function to check if the board is completely filled
function isBoardFull(board) {
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 3; j++) {
            if (board[i][j] !== 'X' && board[i][j] !== 'Y') {
                return false; // Found at least one unoccupied cell
            }
        }
    }
    return true; // All cells are occupied
}

// Function to check if the current player has won
function isGameOver(board, player) {
    // Check rows
    for (let i = 0; i < 3; i++) {
        if (board[i][0] === player && board[i][1] === player && board[i][2] === player) {
            return true;
        }
    }

    // Check columns
    for (let j = 0; j < 3; j++) {
        if (board[0][j] === player && board[1][j] === player && board[2][j] === player) {
            return true;
        }
    }

    // Check diagonals
    if (board[0][0] === player && board[1][1] === player && board[2][2] === player) {
        return true;
    }

    if (board[0][2] === player && board[1][1] === player && board[2][0] === player) {
        return true;
    }

    return false;
}

// Function to validate and apply the player's move
function isValidMove(board, playerSign, moveChar) {
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 3; j++) {
            if (board[i][j] === moveChar) {
                board[i][j] = playerSign; // Apply move
                return true;
            }
        }
    }
    return false; // Move is invalid (cell already taken)
}

// Main game logic
function main() {
    // Initialize the board with numbers 1 to 9
    let board = [
        ['1', '2', '3'],
        ['4', '5', '6'],
        ['7', '8', '9']
    ];

    let player = 'X';
    let is_draw = false;

    while (true) {
        console.log("\n___________________________________________\n");
        printBoard(board);

        // Loop until valid move is made
        let moveMade = false;
        while (!moveMade) {
            let move = prompt(`Player ${player} turn!\nEnter a number (1-9):`);
            if (isValidMove(board, player, move)) {
                moveMade = true;
            } else {
                console.log("Invalid move. Try again!");
            }
        }

        // Check game result
        if (isGameOver(board, player)) {
            break;
        } else if (isBoardFull(board)) {
            is_draw = true;
            break;
        } else {
            player = switchPlayer(player);
        }
    }

    // Declare result
    console.log("\nFINAL RESULT");
    printBoard(board);
    if (is_draw) {
        console.log("IT'S A DRAW :(");
    } else {
        console.log(`${player} has won :)`);
    }
}

// Start the game
main();
