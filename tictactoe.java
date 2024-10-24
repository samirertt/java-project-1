package tic; 

import java.util.Scanner; //is to get user input
import java.util.InputMismatchException; //to handle wrong input types


// public class Tictactoe {
	
	static int[] player1Positions = new int[9]; //holds the positions chosen by X (max 9 moves) 
	static int[] player2Positions = new int[9]; //holds the positions chosen by O (max 9 moves) 
	static int player1PositionCount = 0; //tracks how many positions player 1 (X) has taken
	static int player2PositionCount = 0; //tracks how many positions player 2 (O) has taken
	static int turnCount = 0; // tracks the total number of turns taken in game
	

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) { //a scanner object (scan) is created to read input from user
		char [][] gameBoard = { //gameBoard is represented by 2D array for the structure of the game. Vertical I and horizontal - and +'s separate cells
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}
				}; 	
		
		printGameBoard(gameBoard); //empty for now
		
		//player 1 (X) starts the game.
		while(true) { //game runs in an infinite while loop until a winner is declared or has a tie
			 int player1Pos = getPlayerPosition("Player X", scan, gameBoard); //getPlayerPosition method is called to get a valid position from the player
	            placePiece(gameBoard, player1Pos, "player 1"); //placePiece method is called to place the mark on the board
	            turnCount++; //then we increase the counter because a player made a move

	            String result = checkEnd(); //checkEnd method determines if there's a winner or a tie, 
	            if (result.length() > 0) { // if a result is found, it breaks out of the game loop and prints the result sentence
	                System.out.println(result);
	                break;
	            }

	            printGameBoard(gameBoard); //if not, it prints the X's move and goes on

	            // Player 2's (O) turn
	            int player2Pos = getPlayerPosition("Player O", scan, gameBoard); //this time we're calling the getPlayerPosition but this time for player 2 (o), to get a valid position from the second player
	            placePiece(gameBoard, player2Pos, "player 2"); //then the placePiece to mark O on the board
	            turnCount++; //we increase the counter

	            result = checkEnd(); //once again we're checking if the game has ended to print result
	            if (result.length() > 0) {
	                System.out.println(result);
	                break;
	            }
	            printGameBoard(gameBoard); //if there's no result, we print the gameBoard with an O mark inside
	        } //while ending
	    }
	}
	
	    // Method to get valid player position
	    public static int getPlayerPosition(String player, Scanner scan, char[][] gameBoard) { //String Player is going to print if it's player 1 (X) or player 2 (0), scanner for input reading and current state of the board
	        int playerPos = 0; //the position initially set to 0 to indicate no valid selection has been made yet

	        while (true) {
	            try {
	                System.out.println(player + ", enter your placement (1-9) for the first cell being number 1 and the last is 9: ");
	                playerPos = scan.nextInt();
	                
	                if (playerPos < 1 || playerPos > 9) {
	                    System.out.println("Invalid position! Please select a number between 1 and 9. ");
	                    continue;
	                }

	      
	                boolean positionTaken = false; //we initialize a boolean positionTaken to track if the chosen position is already occupied
	                for (int i = 0; i < player1PositionCount; i++) { //with a for loop we check both players' position arrays to see if the input position is already taken
	                	if (player1Positions[i] == playerPos) {
	                		positionTaken = true;
	                		break;
	                	}
	                }
	                
	                for (int i = 0; i < player2PositionCount; i++) {
	                	if (player2Positions[i] == playerPos) {
	                		positionTaken = true;
	                		break;
	                	}
	                }
	                
	                if (positionTaken) {
	                	System.out.println("Position taken! Select another one: "); //if it's taken, we notify the player and prompt them to choose again
	                	continue;
	                }

	            } catch (InputMismatchException e) { //unlike other invalid input handling, this one checks if the input is an integer or not
	                System.out.println("Invalid input! Please enter an integer, between 1 and 9. ");
	                scan.next(); //scanner avoids infinite loop and gets the later entered input
	            }

	        return playerPos; //if the player successfully entered a value, we're returning that value
	        } //while ending
	    } //getPlayerPosition ending
	
	public static void printGameBoard(char [][] gameBoard) {
		for(char [] row: gameBoard) { //each row is a one-dimensional array and this loop iterates through each row in the gameBoard array
			for (char c: row) { //this loop iterates through each character in the current row
			System.out.print(c); 
		}
		System.out.println(); //after finishing all the characters in a row, this line prints a newline character
	  }
	}
	
	public static void placePiece(char [][] gameBoard, int pos, String user) { //defined int pos is representing the position where the player wants to place their symbol
		
		char symbol = ' ';
		
		if (user.equals("player 1")) {
			symbol = 'X';
			player1Positions[player1PositionCount] = pos; //the current position is recorded in the player1Positions array (for the X), this indicates that the move will be stored at the index equal to player1PositionCount
			                                              //for example player 1 (X) chooses cell no 3 in the first round --> player1Positions[0]=3 which is (3,0,0,0,0,0,0,0,0)
			                                              //then chooses 5 in the second round --> player1Positions[1]=5 which is (3,5,0,0,0,0,0,0,0)
			player1PositionCount++; //then we increase the counter for player 1
			
		} else if (user.equals("player 2")) { //same arrangements is for player 2 (O) continues
			symbol = 'O';
			player2Positions[player2PositionCount] = pos;
			player2PositionCount++;
			
		}
		
		
		switch(pos) { //switch statement updates the array based on the selected cell (pos)
		case 1:
		    gameBoard[0][0] = symbol; //1st cell
		    break;
		case 2:
		    gameBoard[0][2] = symbol; //2nd cell
		    break;
		case 3:
		    gameBoard[0][4] = symbol; //3rd cell
		    break;
		case 4:
		    gameBoard[2][0] = symbol; //4th cell
		    break;
		case 5:
		    gameBoard[2][2] = symbol; //5th cell
		    break;
		case 6:
		    gameBoard[2][4] = symbol; //6th cell
		    break;
		case 7:
		    gameBoard[4][0] = symbol; //7th cell
		    break;
		case 8:
		    gameBoard[4][2] = symbol; //8th cell
		    break;
		case 9:
		    gameBoard[4][4] = symbol; //and 9th cell
		    break;
		default:
			break;
		} //other combinations like [0][1],[2][1],[4][3]... are the separators of the gameBoard	(|,-,+)
	} //placePiece ending
	
	public static int[][] winningCombinations = {
		    {1, 2, 3}, //row 1
		    {4, 5, 6}, //row 2
		    {7, 8, 9}, //row 3
		    {1, 4, 7}, //column 1
		    {2, 5, 8}, //column 2
		    {3, 6, 9}, //column 3
		    {1, 5, 9}, //diagonal 1
		    {7, 5, 3}  //diagonal 2
		};
	

	public static boolean containsAll(int[] positions, int count, int[] winningCombination) { //this method iterates through each position in the winningCombination
	    for (int pos : winningCombination) { //for each position,
	        boolean found = false;
	        for (int i = 0; i < count; i++) { 
	            if (positions[i] == pos) { //it checks if that position exists in the positions array
	                found = true; //if a match is found, it sets found to true
	                break;
	            }
	        }
	        if (!found) { //if no match is found after checking all occupied positions,
	            return false; //the method returns false
	        }
	    }
	    return true; //if all positions in the winningCombination are found, it returns true
	}	
	
	public static String checkEnd() {
		
		for (int[] winningCombination : winningCombinations) {
	        if (containsAll(player1Positions, player1PositionCount, winningCombination)) { //for each combination it calls the containsAll method
	            return "Player X won!" + " Total turns: " + turnCount; //if ContainsAll method return true for player1Positions, it means X won
	        } else if (containsAll(player2Positions, player2PositionCount, winningCombination)) {
	            return "Player O won!" + " Total turns: " + turnCount; //if ContainsAll method return true for player2Positions, it means O won
	        }
	    }
	    
	    if (player1PositionCount + player2PositionCount == 9) { //if all 9 cells (positions) on the board have been occupied by both players,
	        return "TIE!" + " Total turns: " + turnCount; //it indicates a tie
	    }
	    
	    return "";
	} //checkEnd ending
	
// }