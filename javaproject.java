import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

/** 
 * This class javaproject provides command-line interference for the user for operations like: Statistical Information about an array,
 * matrix operations, text encryption/decryption,
 * and a Tic-tac-toe game
 */
public class javaproject{
    
	/**
     * Array to hold the positions chosen by Player 1 (X)
     */
	static int[] player1Positions = new int[9]; //holds the positions chosen by X (max 9 moves) 
	/**
     * Array to hold the positions chosen by Player 2 (O)
     */
	static int[] player2Positions = new int[9]; //holds the positions chosen by O (max 9 moves)
	/**
     * Tracks the number of positions taken by Player 1 (X)
     */
	static int player1PositionCount = 0; //tracks how many positions player 1 (X) has taken
	 /**
     * Tracks the number of positions taken by Player 2 (O)
     */
	static int player2PositionCount = 0; //tracks how many positions player 2 (O) has taken
	/**
     * Tracks the total number of turns taken in the game
     */
	static int turnCount = 0; // tracks the total number of turns taken in game

    // made the scanner object global because we are using it frequently
    private static Scanner myScanner = new Scanner(System.in);


    /**
     * This is the main function for the program
     * @param args
     */
    public static void main(String[] args) 
    {
        ascii_func();
        String userChose ="0";
        short userinput =0;
        
        while(true)
        {
            while(true)
            {
                try
                {
                System.out.println("Please choose any operations below: \n");
                System.out.println();
                System.out.println("1. Statistical Information about an array\n");
                System.out.println("2. Matrix Operations\n");
                System.out.println("3. Text Encryption/Decryption\n");
                System.out.println("4. Tic-tac-toe HotSeat \n");
                System.out.println("To Terminate please click q\n");
                System.out.println("Enter: ");

                userChose = myScanner.next();

                if(userChose.equalsIgnoreCase("q"))
                {
                    System.out.println("end of program !!");
                    return;
                }
                
                userinput = Short.parseShort(userChose);
                if (userinput < 1 || userinput >4)
                {
                    flush_terminal();
                    System.out.println("Please enter an Valid operation !!");
                }
                else
                    break;
                }catch(NumberFormatException e)
                {
                    flush_terminal();
                    System.out.println("INVALID INPUT");
                }
  
            }
            try
            {
                switch (userinput) {
                    case 1:
                        flush_terminal();
                        System.out.println("Statistical Information about an array");
                        int size_of_array =-1;

                        while(size_of_array <=0)
                        {
                            System.out.println("Positive integers only");
                            try
                            {
                                System.out.println("Enter the size of the array: ");
                                size_of_array = myScanner.nextInt();

                            }catch(InputMismatchException e)
                            {
                                System.out.println("Please enter integers only!");
                                myScanner.next(); 
                            }
                        }
                        double[] arr = new double[size_of_array];
                        boolean flag = true;
                        int counter = 0;
                        while(flag)
                        {
                            System.out.println("Enter the elements of array: ");
                            try 
                            {
                                int element = myScanner.nextInt();
                                arr[counter] = element;
                                counter++;
                            } catch (InputMismatchException e) 
                            {
                                System.out.println("Please enter integers only!");
                                myScanner.next(); 
                            }
                            if(counter == size_of_array)
                                flag = false;
                        }
                        statistical_func(arr, size_of_array);
                        System.out.println("Enter 1 for main menu ");
                        System.out.println("OR Enter anything to Terminate");
                        String user_main_menu = myScanner.next();
                        if(user_main_menu.equalsIgnoreCase("1"))
                        {
                            flush_terminal();
                            break;
                        }
                        flush_terminal();
                        return;
                    case 2:
                    
                        flush_terminal();
                        System.out.println("Matrix Operations");

                        int chose = displaySubmenu_chose();
                        System.out.println();
                        boolean repeatOperations = true;

                        while(repeatOperations)
                        {
                            switch (chose) 
                            {
                                case 1:
                                    flush_terminal();
                                    mat_transpose();
                                    break;
                                case 2:
                                    flush_terminal();
                                    mat_multiple();
                                    break;
                                case 3:
                                    flush_terminal();
                                    element_wise_multiple();
                                    break;
                                case 4:
                                    flush_terminal(); 
                                    mat_inverse_main();
                                    break;    
                                case 5: 
                                    repeatOperations = false;
                                    flush_terminal();
                                    break;

                                default:
                                    break;
                            }
                            if(repeatOperations)
                            {
                                System.out.println();
                                chose = displaySubmenu_chose();
                            }
                        }
                        System.out.println();
                        flush_terminal();
                        break;
                    case 3:

                        flush_terminal();
                        myScanner.nextLine();
                        System.out.println("Text Encryption/Decryption");
                        
                        //handle input
                        C_Submenu();
                        boolean flag4 = true;
                        while(flag4)
                        {
                            String option = myScanner.nextLine().toLowerCase();
                            if(option != "a" || option != "b" || option != "c")
                                System.out.println("Invalid input! Please enter correctly.");
                            switch (option) 
                            {
                                case "a":
                                    flush_terminal();
                                    System.out.println("You  elected option a"); 
                                    String newText1 = encrypt();
                                    System.out.println(newText1);
                                    System.out.println();
                                    C_Submenu();        
                                    break;
                                case "b":
                                    flush_terminal();
                                    System.out.println("You selected option b"); 
                                    String newText2 = decrypt();
                                    System.out.println(newText2);    
                                    System.out.println();
                                    C_Submenu();             
                                    break;
                                case "c":
                                    flush_terminal();
                                    flag4 = false;        
                                    break;
                            }
                        }
                        break;
                    case 4:
                        flush_terminal();
                        System.out.println("Tic-tac-toe HotSeat");
                        System.out.println();
                        tictakteo_main();
                        flush_terminal();
                        break;
                    default:
                }
            }catch(NumberFormatException e)
            {
                
                System.out.println("INVALID INPUT");
            }
                    
            
        }    
    }

    /**
     * To clear the terminal.  
     */
    public static void flush_terminal()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();  
    }

    /**
    * To visualize the ASCII art.
    */
    public static void ascii_func()
    {

        String[] lines = {
                                "    ┓ ┏┏┓┓ ┏┓┏┓┳┳┓┏┓     ",
                                "    ┃┃┃┣ ┃ ┃ ┃┃┃┃┃┣      ",
                                "    ┗┻┛┗┛┗┛┗┛┗┛┛ ┗┗┛     ",
                                "┏┳┓┏┓  ┏┓┳┳┳┓  ┏┳┏┓┓┏┏┓  ",
                                " ┃ ┃┃  ┃┃┃┃┣┫   ┃┣┫┃┃┣┫  ",
                                " ┻ ┗┛  ┗┛┗┛┛┗  ┗┛┛┗┗┛┛┗  ",
                                "    ┏┓┳┓┏┓┏┳┏┓┏┓┏┳┓      ",
                                "    ┃┃┣┫┃┃ ┃┣ ┃  ┃       ",
                                "    ┣┛┛┗┗┛┗┛┗┛┗┛ ┻       ",
                                "                         ",
                                "",
                                "                      ••",
                                "┳┓┳┓ ┏┓┏┓  ┏┓┏┓┏┓┳┓┏┳┓┳┳┳┓┓┏┓",  
                                "┣┫┃┃ ┃┓┣   ┣┫┃ ┣┫┣┫ ┃ ┃┃┣┫┃┫",   
                                "┻┛┻┗┛┗┛┗┛  ┛┗┗┛┛┗┛┗ ┻ ┗┛┛┗┛┗┛",  
                                "",
                                "┏┓┏┓┳┓  ┏┓┏┓┳┓┓┏┏┓┏┳┓  ┏┓┓ ┏┓┳",  
                                "┃ ┣┫┃┃  ┗┓┣ ┣┫┃┃┣  ┃   ┣ ┃ ┃ ┃",
                                "┗┛┛┗┛┗  ┗┛┗┛┛┗┗┛┗┛ ┻   ┗┛┗┛┗┛┻",
                                "",
                                "┳┳┓┏┓┳┳┳┓┏┓┏┓┳┓┏┓┓┏  ┳┓┏┓┓┏┓┳┓",  
                                "┃┃┃┣┫┃┃┃┃┃┃┃┃┃┃┣┫┣┫  ┣┫┣┫┃┫ ┣┫",
                                "┛ ┗┛┗┻┛ ┗┗┛┗┛┛┗┛┗┛┗  ┻┛┛┗┛┗┛┛┗",
                                "",
                                "┳┓┏┓┳┓┏┓┳┏┓  ┓┏┳┳┏┓┏┓┓┏┳┓┏┓┓┏┏┓",
                                "┃┃┣┫┣┫┃┓┃┏┛  ┣┫┃┃┗┓┣ ┗┫┃┃┃┃┃┃┣┫",
                                "┛┗┛┗┛┗┗┛┻┗┛  ┛┗┗┛┗┛┗┛┗┛┛┗┗┛┗┛┛┗",
                                "",
                                "                   ••",
                                "┏┓┏┓┳┳┓┳┳┓  ┏┓┳┓┏┳┓┳┳┳┓┓┏┓",
                                "┗┓┣┫┃┃┃┃┣┫  ┣ ┣┫ ┃ ┃┃┣┫┃┫ ",
                                "┗┛┛┗┛ ┗┻┛┗  ┗┛┛┗ ┻ ┗┛┛┗┛┗┛"
                          

                             
                                
                                

                               

        };
        
        for (String line : lines) {
            System.out.println(line);
        }
    }
    
    //case 1

    /**
     * A function to calculate the median of an array  
     * @param arr the array is taken by the user at the main function
     * @param size_of_array also taken by the user at the main function
     * @return return the median of the array
    */
    public static double median_func(double[] arr, int size_of_array)
    {
        int half = size_of_array/2;
        
        //median solve
        if(size_of_array %2 == 1)
        {
            return arr[half];
        }
        else
        {
            return (arr[half-1] + arr[half])/2;
        }
    }
    
    /**
     * A function to calculate the arithmetic mean of an array  
     * @param arr the array is taken by the user at the main function
     * @param size_of_array also taken by the user at the main function
     * @return return the arithmetic mean of the array
    */
    public static double arithmetic_mean(double[] arr, int size_of_array)
    {
        double ans = 0;
        for(int i = 0; i < size_of_array; i++)
        {
            ans += arr[i];
        }
        return ans/size_of_array;
    }
    /**
     * A function to calculate the geometric mean of an array  
     * @param arr the array is taken by the user at the main function
     * @param size_of_array also taken by the user at the main function
     * @return return the geometric mean of the array
    */
    public static double geometric_mean(double[] arr, int size_of_array)
    {
        double multiple_of_array = 1.0;
        for(int i = 0; i < size_of_array; i++)
        {
            multiple_of_array *= arr[i];
        }

        double ans = Math.pow(multiple_of_array, 1.0/size_of_array);

        return ans;
    }
    /**
     * A function to calculate the harmonic mean of an array  
     * @param arr the array is taken by the user at the main function
     * @param size_of_array also taken by the user at the main function
     * @return return the harmonic mean of the array
    */
    public static double harmonic_func(double[] arr , int size_of_array, int counter)
    {
        if (counter == size_of_array)
            return 0;
        return 1.0/arr[counter] + harmonic_func(arr, size_of_array, counter+1);
    }

    /**
     * This is the main fucntion for the statistical operations
     * @param arr the array is taken by the user at the main function
     * @param size_of_array also taken by the user at the main function
    */
    public static void statistical_func(double[] arr, int size_of_array) 
    {
        flush_terminal();
        Arrays.sort(arr);
        
        // visualize in table form

        double median = median_func(arr, size_of_array);
        double arithmetic_mean = arithmetic_mean(arr, size_of_array);
        double geometric_mean = geometric_mean(arr, size_of_array);
        double harmonic_func= size_of_array/harmonic_func(arr, size_of_array,0);
        
        System.out.println("Median of the array is: " + median);
        System.out.println("Arithmetic Mean of the array is: " + arithmetic_mean);
        System.out.println("Geometric Mean of the array is: " + geometric_mean);
        System.out.println("Harmonic Mean of the array is: " + harmonic_func);
        
    }




    //ENCRYPTION & DECRYPTION
    /**
     * Submenu for the 'C' option that allows user to choose encryption or decryption.
     */
    private static void C_Submenu(){
        System.out.println("Select an option from the C submenu below: ");
        System.out.println("[a] Encyryption");
        System.out.println("[b] Decryption");
        System.out.println("[c] Return to the main menu");
        
    }
    
    /**
     * Encrypts the input text by shifting alphabetic characters by a specified key,
     * while leaving numeric values unchanged. Non-alphabetic characters are unaffected.
     * 
     * @return the encrypted text, or an empty string if the key is out of range or input is invalid
     */
    private static String encrypt() {
        int shift = 0;
        try {
            System.out.println("Enter an encryption key (Integer between 26 and -26): ");
            shift = myScanner.nextInt();
            myScanner.nextLine(); // clear the buffer
    
            // Check if shift is within the valid range
            if (shift > 26 || shift < -26) {
                System.out.println("Error: shift value is outside the valid range, returning to submenu");
                C_Submenu();
                return ""; // Return empty string if shift is invalid
            } else if (shift == 0) {
                System.out.println("You entered 0, so no encryption will be applied.");
                return ""; // Return empty string if no shift
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!!");
            return ""; // Return empty string if input is invalid
        }
    
        System.out.println("Please enter text to encrypt: ");
        String text = myScanner.nextLine();
        
        String result = "";
        // Encrypt each character in the text
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result += (char)((((c - base + shift) + 26) % 26) + base); // Apply Caesar shift
            } else {
                result += c; // Non-letter characters remain unchanged
            }
        }
        return result;
    }
    
    /**
     * Decrypts the input text by shifting alphabetic characters by a specified key
     * in the opposite direction, while leaving numeric values unchanged.
     * Non-alphabetic characters are unaffected.
     * 
     * @return the decrypted text, or an empty string if the key is out of range
     */
    private static String decrypt() {
        System.out.println("Enter an decryption key (Integer between 26 and -26): ");
        int shift = myScanner.nextInt();
        myScanner.nextLine();  // clear the buffer
        if (shift > 26 || shift < -26) {
            System.out.println("Error: shift value is outside the valid range, returning to submenu");
            C_Submenu();
            return ""; // Return empty string if shift is invalid
        } else if (shift == 0) {
            System.out.println("You entered 0, so no decryption will be applied.");
            return ""; // Return empty string if no shift
        }
    
        
        System.out.println("Please enter encryption text: ");
        String text = myScanner.nextLine();
        
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
    
            if (Character.isLetter(c)) {
                int new_AscII = c - shift;
                result += (char)((new_AscII)% 128);
            } else {
                result += c;  // non-letter characters stay the same
            }
        }
        return result;
    }

    /**
    * This is the main function of the tictaktoe operation
    */
    private static void tictakteo_main()
    {
		
        boolean playAgain = true; //for enabling replay capability, we add a playAgain flag
        
        while (playAgain) 
        { //we add a while loop that continues until the player chooses to return main menu
            resetGame(); //resets positions and counts before each new game
            
            char [][] gameBoard = { //gameBoard is represented by 2D array for the structure of the game. Vertical I and horizontal - and +'s separate cells
                    {'1', ' ', ' ', ' ', ' ', '|', '2', ' ', ' ', ' ', ' ', '|', '3', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '},
                    {'-', '-', '-', '-', ' ', '+', '-', '-', '-', '-', ' ', '+', '-', '-', '-', '-', ' '},
                    {'4', ' ', ' ', ' ', ' ', '|', '5', ' ', ' ', ' ', ' ', '|', '6', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '},
                    {'-', '-', '-', '-', ' ', '+', '-', '-', '-', '-', ' ', '+', '-', '-', '-', '-', ' '},
                    {'7', ' ', ' ', ' ', ' ', '|', '8', ' ', ' ', ' ', ' ', '|', '9', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' '}
                    };
            
            printGameBoard(gameBoard); //empty for now
            
            //player 1 (X) starts the game.
            while(true) { //game runs in an infinite while loop until a winner is declared or has a tie
                int player1Pos = getPlayerPosition("Player 1 (X)", gameBoard); //getPlayerPosition method is called to get a valid position from the player
                    placePiece(gameBoard, player1Pos, "player 1 (X)"); //placePiece method is called to place the mark on the board
                    turnCount++; //then we increase the counter because a player made a move

                    String result = checkEnd(); //checkEnd method determines if there's a winner or a tie, 
                    if (result.length() > 0) {
                        // if a result is found, it breaks out of the game loop and prints the result sentence
                        printGameBoard(gameBoard);
                        System.out.println(result);
                        break;
                    }
                    
                    printGameBoard(gameBoard); //if not, it prints the X's move and goes on

                    // Player 2's (O) turn
                    int player2Pos = getPlayerPosition("Player 2 (O)", gameBoard); //this time we're calling the getPlayerPosition but this time for player 2 (o), to get a valid position from the second player
                    placePiece(gameBoard, player2Pos, "player 2 (O)"); //then the placePiece to mark O on the board
                    turnCount++; //we increase the counter

                    result = checkEnd(); //once again we're checking if the game has ended to print result
                    if (result.length() > 0) {
                        printGameBoard(gameBoard);
                        System.out.println(result);
                        break;
                    }
                    printGameBoard(gameBoard); //if there's no result, we print the gameBoard with an O mark inside
                } //while ending
                
                int replayChoice = -1;
                System.out.println("Do you want to play again ? (1 to play again, 0 to return to main menu)");
                while (replayChoice != 1 && replayChoice != 0)
                {
                    System.out.println("Please enter your choice 1 to replay. 0 to return to main menu");
                    replayChoice = myScanner.nextInt();
                }

                if(replayChoice == 1)
                    playAgain =true;
                else
                    playAgain = false;
                
        }
	}
    
    /**
     * Resets the game variables for a new round
     */
    public static void resetGame() { //with this method, we reset the game variables for a new round
        flush_terminal();
        player1Positions = new int[9];
        player2Positions = new int[9];
        player1PositionCount = 0;
        player2PositionCount = 0;
        turnCount = 0;
    }
    /**
     * Prompts the specified player to enter their placement on the game board.
     * Validates the input to ensure it's an integer between 1 and 9,
     * and checks if the position is already taken.
     *
     * @param player    The player who is making the move ("Player 1" or "Player 2")
     * @param scan      The scanner object to read user input
     * @param gameBoard The current state of the game board
     * @return The position chosen by the player (1-9)
     * @throws InputMismatchException if the input is not an integer.
     */
	public static int getPlayerPosition(String player, char[][] gameBoard) 
    { //String Player is going to print if it's player 1 (X) or player 2 (0), scanner for input reading and current state of the board
		int playerPos = 0; //the position initially set to 0 to indicate no valid selection has been made yet

		while (true) {
			try {
				System.out.println(player + ", enter your placement (1-9) for the first cell being number 1 and the last is 9: ");
				playerPos = myScanner.nextInt();
				
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
				myScanner.next(); //scanner avoids infinite loop and gets the later entered input
                continue;
			}

		return playerPos; //if the player successfully entered a value, we're returning that value
		} //while ending
	} //getPlayerPosition ending

    /**
     * Prints the current state of the game board
     *
     * @param gameBoard The current state of the game board
    */
	public static void printGameBoard(char [][] gameBoard) 
    {
		for(char [] row: gameBoard) { //each row is a one-dimensional array and this loop iterates through each row in the gameBoard array
			for (char c: row) { //this loop iterates through each character in the current row
			System.out.print(c); 
		}
		System.out.println(); //after finishing all the characters in a row, this line prints a newline character
	  }
	}
	/**
     * Places the player's symbol ('X' or 'O') on the game board
     *
     * @param gameBoard The current state of the game board
     * @param pos       The position chosen by the player (1-9)
     * @param user      The player making the move ("player 1" or "player 2")
     */
    public static void placePiece(char [][] gameBoard, int pos, String user) { //defined int pos is representing the position where the player wants to place their symbol
		
		char symbol = ' ';
		
		if (user.equals("player 1 (X)")) {
			symbol = 'X';
			player1Positions[player1PositionCount] = pos; //the current position is recorded in the player1Positions array (for the X), this indicates that the move will be stored at the index equal to player1PositionCount
			                                              //for example player 1 (X) chooses cell no 3 in the first round --> player1Positions[0]=3 which is (3,0,0,0,0,0,0,0,0)
			                                              //then chooses 5 in the second round --> player1Positions[1]=5 which is (3,5,0,0,0,0,0,0,0)
			player1PositionCount++; //then we increase the counter for player 1
			
		} else if (user.equals("player 2 (O)")) { //same arrangements is for player 2 (O) continues
			symbol = 'O';
			player2Positions[player2PositionCount] = pos;
			player2PositionCount++;
			
		}
		
		
		switch(pos) { //switch statement updates the array based on the selected cell (pos)

            case 1:
                gameBoard[1][2] = symbol; // 1st cell (upper-left)
                break;
            case 2:
                gameBoard[1][8] = symbol; // 2nd cell (upper-middle)
                break;
            case 3:
                gameBoard[1][14] = symbol; // 3rd cell (upper-right)
                break;
            case 4:
                gameBoard[5][2] = symbol; // 4th cell (middle-left)
                break;
            case 5:
                gameBoard[5][8] = symbol; // 5th cell (center)
                break;
            case 6:
                gameBoard[5][14] = symbol; // 6th cell (middle-right)
                break;
            case 7:
                gameBoard[9][2] = symbol; // 7th cell (bottom-left)
                break;
            case 8:
                gameBoard[9][8] = symbol; // 8th cell (bottom-middle)
                break;
            case 9:
                gameBoard[9][14] = symbol; // 9th cell (bottom-right)
                break;
            default:
                break;
            } //other combinations like [0][3],[2][1],[4][3]... are the separators or the spaces of the gameBoard	(, ,|,-,+)
        } //placePiece ending
        

    public static int[][] winningCombinations = 
    {
        {1, 2, 3}, //row 1
        {4, 5, 6}, //row 2
        {7, 8, 9}, //row 3
        {1, 4, 7}, //column 1
        {2, 5, 8}, //column 2
        {3, 6, 9}, //column 3
        {1, 5, 9}, //diagonal 1
        {7, 5, 3}  //diagonal 2
    };

	/**
     * Checks whether a player has a winning combination of positions
     *
     * @param positions The array of positions selected by a player
     * @param count     The number of moves made by the player so far
     * @param winningCombination The winning combination of positions to check
     * @return true if the player has all positions in the winning combination, false otherwise
     */
    public static boolean containsAll(int[] positions, int count, int[] winningCombination) 
    { //this method iterates through each position in the winningCombination
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

	/**
     * Checks whether the game has ended in a win or tie, based on the current game state
     *
     * @return A string describing the result of the game (either "Player 1 won!", "Player 2 won!", or "TIE!"), or an empty string if the game has not yet ended
     */
    public static String checkEnd() 
    {
        flush_terminal();
		for (int[] winningCombination : winningCombinations) {
	        if (containsAll(player1Positions, player1PositionCount, winningCombination)) { //for each combination it calls the containsAll method
	            return "Player 1 (X) won!" + " Total turns: " + turnCount; //if ContainsAll method return true for player1Positions, it means X won
	        } else if (containsAll(player2Positions, player2PositionCount, winningCombination)) {
	            return "Player 2 (O) won!" + " Total turns: " + turnCount; //if ContainsAll method return true for player2Positions, it means O won
	        }
	    }
	    
	    if (player1PositionCount + player2PositionCount == 9) { //if all 9 cells (positions) on the board have been occupied by both players,
	        return "TIE!" + " Total turns: " + turnCount; //it indicates a tie
	    }
	    
	    return "";
	} //checkEnd ending

    public static int displaySubmenu_chose () 
    {
        boolean flag6= true;
        int chose = 0;
        while(flag6)
        {
            
            try
            {
                System.out.println("[1] Transpose Matrix");
                System.out.println("[2] Matrix Multiplication");
                System.out.println("[3] Element-wise Multiplication");
                System.out.println("[4] Inverse");
                System.out.println("[5] Return to the main menu");
                System.out.print("Select one of the matrix operations: ");
                chose = myScanner.nextInt();
                if(chose > 0 && chose < 6)
                    flag6 = false;
                else
                {
                    System.out.println("Invalid input!!");
                }
            }catch(InputMismatchException e)
            {
                System.out.println("Invalid input!!");
                myScanner.next();
            }
        }
        return chose;
    }
    public static double[][] mat_filling(int mat_row, int mat_col)
    {
        double[][] ans = new double[mat_row][2*mat_col];

        boolean flag = true;
                        
        int row_counter = 0;
        int col_counter = 0;
        
        while(flag)
        {
            try
            {
                System.out.printf("Enter the row:%d coloum:%d of the matrix: ",row_counter,col_counter);
                double element = myScanner.nextDouble();
                System.out.println();

                if(row_counter == mat_row-1 && col_counter == mat_col-1)
                    flag = false;
                    
                ans[row_counter][col_counter] = element;
                
                col_counter++;

    
                if(col_counter == mat_col)
                {
                    row_counter++;
                    col_counter=0;
                }

            }catch(InputMismatchException e)
            {
                System.out.println("Please enter integers only!");
                myScanner.next(); 
            }
            
        }
        return ans;
    }

    //function for transpose
    public static void mat_transpose()
    {
        int row_mat = -1;
        while(row_mat <= 0)
        {
            System.out.println("Please enter the row size of the matrix (positive number)");
            row_mat = myScanner.nextInt();
        }
        int col_mat = -1;
        while(col_mat <= 0)
        {
            System.out.println("Please enter the column size of the matrix (positive number)");
            col_mat = myScanner.nextInt();
        }


        System.out.printf("the size of row is %d and column is %d ",row_mat,col_mat);
        System.out.println();
        double[][] mat1 = new double[row_mat][2*col_mat];
        mat1 = mat_filling(row_mat, col_mat);

        flush_terminal();
        System.out.println("matrix transpose: ");
        //using col_mat at the outer loop because not to get a out of bound. the matrix is not only square 
        for(int i = 0; i < col_mat; i++)
        {
            for(int j = 0; j< row_mat;j++ )
            {
                System.out.print(mat1[j][i] + " ");
            }
            System.out.println();
        }


    }



    public static void mat_inverse_main()
    {
        int row_mat = -1;
        long temp_row;
    
        while (row_mat <= 0) {
            System.out.print("Please enter the row size of the matrix (positive number): ");
            
            try {
                temp_row = myScanner.nextLong();
                if (temp_row > 0 && temp_row <= Integer.MAX_VALUE) {
                    row_mat = (int) temp_row;
                } else {
                    System.out.println("Invalid input! Row size must be a positive number within int range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                myScanner.next(); // Clear the invalid input
            }
        }
        
        int col_mat = -1;
       
        while (col_mat <= 0) {
            System.out.print("Please enter the column size of the matrix (positive number): ");
            
            try {
                temp_row = myScanner.nextLong();
                if (temp_row > 0 && temp_row <= Integer.MAX_VALUE) {
                    col_mat = (int) temp_row;
                } else {
                    System.out.println("Invalid input! Column size must be a positive number within int range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                myScanner.next(); // Clear the invalid input
            }
        }

        System.out.printf("the size of row is %d and column is %d ",row_mat,col_mat);
        System.out.println();

        double[][] mat1;
        mat1 = mat_filling(row_mat, col_mat);

        System.out.printf("the size of row is %d and column is %d ",row_mat,col_mat);
        System.out.println();    


        if (row_mat != col_mat)
        {
            row_mat = -1;
        
            while (row_mat <= 0) {
                System.out.print("Please enter the row size of the matrix (positive number): ");
                
                try {
                    temp_row = myScanner.nextLong();
                    if (temp_row > 0 && temp_row <= Integer.MAX_VALUE) {
                        row_mat = (int) temp_row;
                    } else {
                        System.out.println("Invalid input! Row size must be a positive number within int range.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a numeric value.");
                    myScanner.next(); // Clear the invalid input
                }
            }
        }


        inverse_mat(mat1, row_mat, col_mat);


    }
    public static void inverse_mat(double[][] mat,int mat_row,int mat_col)
    {
        System.out.println("MATRIX");
        
        for(int i = 0; i< mat_row; i++)
        {
            for(int j = 0 ; j < mat_col; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Create the augmented matrix
        for (int i = 0; i < mat_row; i++) 
        {

            for (int j = 0; j < 2 * mat_row; j++) 
            {
    
                // Add '1' at the diagonal places of
                // the matrix to create a identity matrix
                if (j == (i + mat_row))
                    mat[i][j] = 1;
            }
        }
        double temp;
        for (int i = mat_row - 1; i > 0; i--) 
        {
 
            if (mat[i - 1][0] < mat[i][0]) 
            {
                double[] tempArr = mat[i];
                mat[i] = mat[i - 1];
                mat[i - 1] = tempArr;
            }
        }
        // Replace a row by sum of itself and a
        for (int i = 0; i < mat_row; i++) {
 
            for (int j = 0; j < mat_row; j++) {
 
                if (j != i) {
 
                    temp = mat[j][i] / mat[i][i];
                    for (int k = 0; k < 2 * mat_row; k++) {
 
                        mat[j][k] -= mat[i][k] * temp;
                    }
                }
            }
        }
 
        for (int i = 0; i < mat_row; i++) {
 
            temp = mat[i][i];
            for (int j = 0; j < 2 * mat_row; j++) {
 
                mat[i][j] = mat[i][j] / temp;
            }
        }
        flush_terminal();
        //printing
        System.out.println("Inverse of Matrix");
        for (int i = 0; i < mat_row; i++) {
            for (int j = mat_row; j < (2*mat_row); j++) {
                System.out.printf("%.3f  ", mat[i][j]);
            }
            System.out.println();
        }

    }

    
    public static void mat_multiple()
    {
        int row_mat = -1;
        long temp_row;
    
        while (row_mat <= 0) {
            System.out.print("Please enter the row size of the matrix (positive number): ");
            
            try {
                temp_row = myScanner.nextLong();
                if (temp_row > 0 && temp_row <= Integer.MAX_VALUE) {
                    row_mat = (int) temp_row;
                } else {
                    System.out.println("Invalid input! Row size must be a positive number within int range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                myScanner.next(); // Clear the invalid input
            }
        }
        
        int col_mat = -1;
       
        while (col_mat <= 0) {
            System.out.print("Please enter the column size of the matrix (positive number): ");
            
            try {
                temp_row = myScanner.nextLong();
                if (temp_row > 0 && temp_row <= Integer.MAX_VALUE) {
                    col_mat = (int) temp_row;
                } else {
                    System.out.println("Invalid input! Column size must be a positive number within int range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                myScanner.next(); // Clear the invalid input
            }
        }

        System.out.printf("the size of row is %d and column is %d ",row_mat,col_mat);
        System.out.println();

        double[][] mat1;
        mat1 = mat_filling(row_mat, col_mat);

        int row_mat2 = -1;
        long temp_row2;
        // Prompt for row size
        while (row_mat2 <= 0) {
            System.out.print("Please enter the row size of the matrix (positive number): ");
            
            try {
                temp_row2 = myScanner.nextLong();
                if (temp_row2 > 0 && temp_row2 <= Integer.MAX_VALUE) {
                    row_mat2 = (int) temp_row2;
                } else {
                    System.out.println("Invalid input! Row size must be a positive number within int range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                myScanner.next(); // Clear the invalid input
            }
        }
        
        int col_mat2 = -1;
        // Prompt for column size
        while (col_mat2 <= 0) {
            System.out.print("Please enter the column size of the matrix (positive number): ");
            
            try {
                temp_row2 = myScanner.nextLong();
                if (temp_row2 > 0 && temp_row2 <= Integer.MAX_VALUE) {
                    col_mat2 = (int) temp_row2;
                } else {
                    System.out.println("Invalid input! Column size must be a positive number within int range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                myScanner.next(); // Clear the invalid input
            }
        }

        System.out.printf("the size of row is %d and column is %d ",row_mat2,col_mat2);
        System.out.println();

        if (col_mat != row_mat2)
        {
            System.out.println("can not be multipled! matrix 1 col is not equal to matrix 2 row!");
            System.out.println("Changing matrix 2 size and elements...");
            col_mat2 = -1;
            while(col_mat2 <= 0)
            {
                System.out.println("Please enter the column size of the matrix 2 (positive number)");
                col_mat2 = myScanner.nextInt();
            }
        }
        double[][] mat2;
        mat2 = mat_filling(row_mat2, col_mat2);

        

        flush_terminal();

        double[][] ans = new double[row_mat][col_mat2];

        System.out.println("MATRIX MULTIPLICATION");        
        for(int i = 0;i < row_mat; i++)
        {
            for(int j = 0; j < col_mat2; j++)
            {
                for(int k = 0; k < col_mat;k++)
                {
                    ans[i][j] += mat1[i][k] * mat2[k][j]; 
                }
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void element_wise_multiple()
    {
        int row_mat = -1;
        long temp_row;
        // Prompt for row size
        while (row_mat <= 0) {
            System.out.print("Please enter the row size of the matrix (positive number): ");
            
            try {
                temp_row = myScanner.nextLong();
                if (temp_row > 0 && temp_row <= Integer.MAX_VALUE) {
                    row_mat = (int) temp_row;
                } else {
                    System.out.println("Invalid input! Row size must be a positive number within int range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                myScanner.next(); // Clear the invalid input
            }
        }

        int col_mat = -1;
        // Prompt for column size
        while (col_mat <= 0) {
            System.out.print("Please enter the column size of the matrix (positive number): ");
            
            try {
                temp_row = myScanner.nextLong();
                if (temp_row > 0 && temp_row <= Integer.MAX_VALUE) {
                    col_mat = (int) temp_row;
                } else {
                    System.out.println("Invalid input! Column size must be a positive number within int range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                myScanner.next(); // Clear the invalid input
            }
        }


        System.out.printf("the size of row is %d and column is %d ",row_mat,col_mat);
        System.out.println();

        double[][] mat1;
        mat1 = mat_filling(row_mat, col_mat);

        System.out.println("Enter the elements for second matrix");

        int row_mat2 = row_mat;
        int col_mat2 = col_mat;


        
        double[][] mat2;
        mat2 = mat_filling(row_mat2, col_mat2);

        flush_terminal();
        double[][] ans = new double[row_mat][col_mat];
        System.out.println("ELEMENT WISE MULTIPLICATION");
        for(int i = 0; i < row_mat;i++)
        {
            for(int j = 0; j < col_mat; j++)
            {
                ans[i][j] = mat1[i][j] * mat2[i][j];
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }
}


