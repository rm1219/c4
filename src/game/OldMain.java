package game;

import java.util.Scanner;

public class OldMain {

	public static char[] playerNumber = new char[] { '1', '2' };
	public static char[] Badge = new char[] { 'X', 'O' };

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int moves = 7 * 6;
	    int whichPlayer = 0;
	
	    for (int i = 0; i < 10; i++) {
	    System.out.println("             CONNECT FOUR");
	    System.out.println("--------------------------------------");
	    System.out.println("Welcome to Connect Four!");
	    System.out.println("Choose a column number from 0 to 6:");
	    System.out.println();
	
	        Board board = new Board();
	        board.fillBoard();
	        board.presentBoard();
	
	        do {
	            // 1. get a badge
	            char Player = playerNumber[whichPlayer];
	            char badge = Badge[whichPlayer];
	
	            // 2. make a turn
	            board.makeTurn(badge, Player);
	            board.presentBoard();
	
	            // 3. Tjek om der er vinder
	            if (board.checkWinHorizontal() || board.checkWinVertical()) {
	                System.out.println("Player " + Player + " has won!");
	                break;
	            }
	
	            // 4. change the player
	            whichPlayer = 1 - whichPlayer;
	
	            // 5. decrease moves
	            --moves;
	
	            if (moves == 0) {
	                System.out.println("Game over, nobody has won.");
	                System.out.println("Do you want to play again? 'Y' or 'N':");
	                String newGame = scanner.nextLine();
	                if (newGame.equals("Y") || newGame.equals("y")) {
	                    break;
	                }
	                if (newGame.equals("N") || newGame.equals("n")) {
	                    System.out.println("Thanks for the game!");
	                    return;
	                }
	            }
	            // 6. repeat
	        } while (true);
	    }
	}
}