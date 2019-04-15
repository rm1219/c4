package game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Game game;
		boolean playing = true;
		
	    while (playing) {
	    	game = new Game();
	
	        do {
	        	boolean result = game.makeTurn();
	        	
	        	if (result) {
	        		 boolean movesLeft = game.checkRemainingMoves();
	        		 if (!movesLeft) {
	        			boolean playAgain = game.playAgain();
	        			
	 	                if (playAgain) {
	 	                    break;
	 	                } else {
	 	                    playing = false;
	 	                    return;
	 	                }
	        		 }
	        	} else {
	        		
	        	}
	        	
	        	
	        } while (true);
	    }
	}
}