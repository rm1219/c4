package game;

import java.util.Scanner;

public class Board {

	char[][] board = new char[6][7];

	int column;

	// Fills the empty spaces
	public void fillBoard() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				board[i][j] = ' ';
			}
		}
	}

	// Prints the board
	public void presentBoard() {
		for (int i = 0; i < 6; i++) {
			System.out.print("    | ");
			for (int j = 0; j < 7; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.print("    -----------------------------");
			System.out.println();
		}
	}

	// Turn
	public void makeTurn(char badge, char Player) {
		Scanner scanner = new Scanner(System.in);
		do {
			// 1. Ask for a column
			System.out.println("Player " + Player + " turn: ");
			column = scanner.nextInt();

			// 2. Check if it's between 0 and 6
			if (column > 6) {
				System.out.println("That is not a valid number. Please enter a number between 0 and 6: ");
				continue;
			}

			// 3. Place a badge
			for (int i = 6 - 1; i >= 0; i--) {
				if (board[i][column] == ' ') {
					board[i][column] = badge;
					return;
				}
			}

			// If column is full
			System.out.println("Column " + column + " is full. Try another column:");

		} while (true);
	}

	// Check for vertical win
	public boolean checkWinVertical() {
		return verticalWin(5, column);
	}

	// Check for horizontal win
	public boolean checkWinHorizontal() {
		return horizontalWin(5, column);
	}

	// Conditions for vertical win
	private boolean verticalWin(int x, int y) {
		char charToCheck = board[x][y];
		if (board[x - 1][y] == charToCheck && board[x - 2][y] == charToCheck && board[x - 3][y] == charToCheck) {
			return true;
		}

		return false;
	}

	// Conditions for horizontal win
	private boolean horizontalWin(int x, int y) {
	    char charToCheck = board[x][y];
	    if (board[x][y+1] == charToCheck &&
	            board[x][y+2] == charToCheck &&
	            board[x][y+3] == charToCheck) {
	        return true;
	    }
	    return false;
	}
}