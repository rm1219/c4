package game;

import java.util.Scanner;

public class Game {
	
	public static char[] number = new char[] { '1', '2' };
	public static char[] badge = new char[] { 'X', 'O' };
	private Scanner scanner = new Scanner(System.in);
	private int moves = 7 * 6;
	private int currentPlayer;
	private Board board;
	
	public Game() {
		currentPlayer = 1;
		board = new Board();
		startGame();
	}
	
	private void startGame() {
		printHeader();
		
		board.fillBoard();
        board.presentBoard();
	}
	
	private void printHeader() {
	    System.out.println("           ->CONNECT FOUR<-");
	    System.out.println("--------------------------------------");
	    System.out.println("Welcome to Connect Four!");
	    System.out.println("Choose a column number from 0 to 6:");
	    System.out.println();
	}
	
	public boolean makeTurn() {
		// get a badge
        char playerNumber = number[currentPlayer];
        char playerBadge = badge[currentPlayer];

        // make a turn
        board.makeTurn(playerBadge, playerNumber);
        board.presentBoard();

        // check for winner
        if (board.checkWinHorizontal() || board.checkWinVertical()) {
            System.out.println("Player " + playerNumber + " has won!");
            return false;
        }
        
        changePlayer();
        decreaseMoves();
        return true;
	}
	
	private void changePlayer() {
        currentPlayer = 1 - currentPlayer;
	}
	
	private void decreaseMoves() {
		moves--;
	}
	
	public boolean checkRemainingMoves() {
        if (moves == 0) {
           return false;
        }
        return true;
	}
	
	public boolean playAgain() {
		System.out.println("Game over, nobody has won.");
        System.out.println("Do you want to play again? 'Y' or 'N':");
        String playAgain = scanner.nextLine();
        
        if (playAgain.toLowerCase().equals("y")) {
        	return true;
        } else {
        	System.out.println("Thanks for playing!");
        	return false;
        }
	}
	
}
