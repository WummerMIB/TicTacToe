
// 2120717 Marco Mohr, 2123474 Marie Kapusta
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import javax.lang.model.element.NestingKind;

public class TicTacToe {
	// Public Variable for User Input between one to nine
	public static int change;
	// Public Variable if User place Symbol right than change rightPlace to true and
	// place a Symbol
	public static boolean rightPlace = false;
	// Public Array that has nine space Elements
	public static char[] gameboard = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
	// Public Variable if player make a winning move set winCon to true give a
	// wining message and end the game
	public static boolean winCon = false;
	// Variable if user wants to continue the game
	public static boolean continueGame = true;
	// String that save user yes or no if he wants to continue
	public static String con = null;
	// Variable for player that starts the game
	public static String player = "Player 1";

	public static void main(String[] args) {

		// Variable that changes space in array to X for Player 1 and to O for Player 2
		char changeSymbol = ' ';

		// while loop if user wants to continue
		while (continueGame == true) {
			// Shows in Console what Game is played
			System.out.println("TicTacToe Spiel");
			// Asks Player if he wants to play against a Person or the Computer
			System.out.println("1 Zweispielermodus");
			System.out.println("2 CPU");

			// Scanner for the decision if you want to play against a Player or CPU
			functionScanner();

			// If Input from User is 1 Play against a Player
			if (change == 1) {
				// Calls Method to show the Gameboard and explain the game
				explainGame(gameboard);
				System.out.println("Sie haben Zweispieler Modus Ausgewählt ");
				// loops as long as no player wins if one fulfills winCon than break loop and
				// give winner message
				while (winCon == false) {
					// if variable player is Player 1 than go on if condition
					if (player == "Player 1") {
						System.out.println("Spieler 1 ist am Zug");
						// As long as the user does not place the symbol in the right place its loops
						while (rightPlace == false) {
							// calls Method fuctionScanner for Input from player to place a symbol
							functionScanner();
							// Variable that shows which symbol is placed
							changeSymbol = 'X';
							// Calls Method rightPlacement to check if the Player but the symbol on the
							// right place
							rightPlacement(gameboard, changeSymbol, change, player);
						}
						// changes Variable to false for player 2
						rightPlace = false;
						// Calls Method to check if the player won the game
						winCondition(gameboard, player);
						// changes String to Player 2 to change the player
						player = "Player 2";
					}
					// now player is Player 2 and it is Player 2 turn
					else if (player == "Player 2") {
						while (rightPlace == false) {
							functionScanner();
							changeSymbol = 'O';
							rightPlacement(gameboard, changeSymbol, change, player);
						}
						rightPlace = false;
						winCondition(gameboard, player);
						// changes String to Player 1 to go back to player 1
						player = "Player 1";
					}
				}
			} else if (change == 2) {
				// Calls Method to show the Gameboard and explain the game
				explainGame(gameboard);
				System.out.println("Sie spielen nun gegen den PC");
				while (winCon == false) {
					if (player == "Player 1") {
						while (rightPlace == false) {
							functionScanner();
							changeSymbol = 'X';
							rightPlacement(gameboard, changeSymbol, change, player);
						}
						rightPlace = false;
						winCondition(gameboard, player);
						// changes String to CPU to let the computer play
						player = "CPU";
					}
					// Player is now CPU meaning the Computer plays
					else if (player == "CPU") {
						while (rightPlace == false) {
							// calls Method to generate a Random Number
							randomNumber();
							changeSymbol = 'O';
							rightPlacement(gameboard, changeSymbol, change, player);
						}
						rightPlace = false;
						winCondition(gameboard, player);
						player = "Player 1";
					}
				}
			} else {
				System.out.println("Bitte geben sie 1 oder 2 ein");
			}
			// calls Method to repeat the game
			continueGame();

		}
	}

	// Method to Print out the TicTacToe field
	public static void printTicTacToeBoard(char[] gameboard) {

		// Prints out the board and puts in the gameboard[x] and show the value in the
		// array on that place x
		System.out.println("[" + gameboard[0] + "][" + gameboard[1] + "][" + gameboard[2] + "]");
		System.out.println("[" + gameboard[3] + "][" + gameboard[4] + "][" + gameboard[5] + "]");
		System.out.println("[" + gameboard[6] + "][" + gameboard[7] + "][" + gameboard[8] + "]");
	}

	// Method for Users to Input numbers
	public static int functionScanner() {
		// Variable for loop to look if user makes the right Input
		boolean rightInput = false;
		// while loop to continue if user makes wrong input
		while (rightInput == false) {
			// Scanner for number Input from User
			Scanner sc = new Scanner(System.in);
			// look if Input from User is a number
			if (sc.hasNextInt()) {
				// sets Variable change to number from User Input
				change = sc.nextInt();
				// if number is smaller than 9 and bigger than 0 than return number from User
				// Input
				if (change <= 9 && !(change <= 0)) {
					return change;
				}
				// if number is bigger than 9 or smaller or equal to 0 Print this message
				else {
					System.out.println("Bitte geben sie ein Zahl eine Zahl zwischen 1 und 9 ein");
				}
			}
			// if Input is a double number then print this message
			else if (sc.hasNextDouble()) {
				System.out.println("Bitte geben sie keine Kommazahl ein");
			}
			// if Input is a latter than Print this message
			else {
				System.out.println("Bitte geben sie eine Zahl ein");
			}

		}
		// method needs to return an int number and if it return it in if condition than
		// you get an error
		return change;
	}

	// Method that gives Random Number between one and nine
	public static int randomNumber() {
		// generates number between 0 and 8 and + 1 because Zero can't be an Input
		Random randNum = new Random();
		change = randNum.nextInt(9) + 1;
		return change;
	}

	// Method to check if the Player or the CPU has won and changes winCon to true
	public static boolean winCondition(char[] gameboard, String player) {

		// check in array on point 0, 1 and 2 if there is an X or O and returns winCone
		// true if true
		if (gameboard[0] == 'X' && gameboard[1] == 'X' && gameboard[2] == 'X'
				|| gameboard[0] == 'O' && gameboard[1] == 'O' && gameboard[2] == 'O') {

			System.out.println("Sieger " + player);
			winCon = true;
			return winCon;
		}
		if (gameboard[3] == 'X' && gameboard[4] == 'X' && gameboard[5] == 'X'
				|| gameboard[3] == 'O' && gameboard[4] == 'O' && gameboard[5] == 'O') {
			System.out.println("Sieger " + player);
			return winCon = true;
		}
		if (gameboard[6] == 'X' && gameboard[7] == 'X' && gameboard[8] == 'X'
				|| gameboard[6] == 'O' && gameboard[7] == 'O' && gameboard[8] == 'O') {
			System.out.println("Sieger " + player);
			return winCon = true;
		}
		if (gameboard[0] == 'X' && gameboard[3] == 'X' && gameboard[6] == 'X'
				|| gameboard[0] == 'O' && gameboard[3] == 'O' && gameboard[6] == 'O') {
			System.out.println("Sieger " + player);
			return winCon = true;
		}
		if (gameboard[1] == 'X' && gameboard[4] == 'X' && gameboard[7] == 'X'
				|| gameboard[1] == 'O' && gameboard[4] == 'O' && gameboard[7] == 'O') {
			System.out.println("Sieger " + player);
			return winCon = true;
		}
		if (gameboard[2] == 'X' && gameboard[5] == 'X' && gameboard[8] == 'X'
				|| gameboard[2] == 'O' && gameboard[5] == 'O' && gameboard[8] == 'O') {
			System.out.println("Sieger " + player);
			return winCon = true;
		}
		if (gameboard[0] == 'X' && gameboard[4] == 'X' && gameboard[8] == 'X'
				|| gameboard[0] == 'O' && gameboard[4] == 'O' && gameboard[8] == 'O') {
			System.out.println("Sieger " + player);
			return winCon = true;
		}
		if (gameboard[6] == 'X' && gameboard[4] == 'X' && gameboard[2] == 'X'
				|| gameboard[6] == 'O' && gameboard[4] == 'O' && gameboard[2] == 'O') {
			System.out.println("Sieger " + player);
			return winCon = true;
		}
		// if the array is full and no player won then Print that the game is a draw
		if (gameboard[0] != ' ' && gameboard[1] != ' ' && gameboard[2] != ' ' && gameboard[3] != ' '
				&& gameboard[4] != ' ' && gameboard[5] != ' ' && gameboard[6] != ' ' && gameboard[7] != ' '
				&& gameboard[8] != ' ') {
			System.out.println("Unentschieden");
			return winCon = true;
		}
		// if no one has won the game return false and continue the game;
		return winCon = false;
	}

	// Method to place an X or an O
	public static void butInBoardXOrOAndPrintBoard(char[] gameboard, char changeSymbol) {
		// switch for User Input if for example User Input is 2 then change array
		// Element one
		switch (change) {
		case 1:
			gameboard[0] = changeSymbol;
			break;
		case 2:
			gameboard[1] = changeSymbol;
			break;
		case 3:
			gameboard[2] = changeSymbol;
			break;
		case 4:
			gameboard[3] = changeSymbol;
			break;
		case 5:
			gameboard[4] = changeSymbol;
			break;
		case 6:
			gameboard[5] = changeSymbol;
			break;
		case 7:
			gameboard[6] = changeSymbol;
			break;
		case 8:
			gameboard[7] = changeSymbol;
			break;
		case 9:
			gameboard[8] = changeSymbol;
			break;
		}
		// after us set the Symbol print out the new board
		printTicTacToeBoard(gameboard);
	}

	// Method that looks if the Player can put an X or O in the field and don't
	// overwrite a Player Symbol
	public static boolean rightPlacement(char[] gameboard, char changeSymbol, int change, String player) {
		// looks in array on the place from User Input if there is an X or O than return
		// that you can't place the symbol there
		if (gameboard[change - 1] == 'X' || gameboard[change - 1] == 'O') {
			if (player == "CPU") {
				System.out.println("Thinking...");
			}
			System.out.println("Bitte setzen sie ihr Symbol wo noch kein Symbol ist");
			return rightPlace = false;
		}
		// if array is on user Input -1 empty than Print the Board and return rightPlace
		// true
		if (gameboard[change - 1] == ' ') {
			butInBoardXOrOAndPrintBoard(gameboard, changeSymbol);
			return rightPlace = true;
		}
		// method needs to return an boolean and if it return it in if condition than
		// you get an error
		return false;
	}

	// Method to explain the game only Prints Board and explain how to play
	public static void explainGame(char[] gameboard) {
		System.out.println("[1][2][3]");
		System.out.println("[4][5][6]");
		System.out.println("[7][8][9]");
		System.out.println("Bitte geben sie eine Zahl ein die sie auf dem Feld sehen und an");
		System.out.println("welcher stellen sie ihr Symbol setzen wollen");

	}

	// Method to start a new game
	public static void continueGame() {
		// boolean to check if the right Input was made
		boolean rigthContinueInput = false;
		// loops until the right Input ja or nein
		while (rigthContinueInput == false) {
			System.out.println("Möchten Sie nocheinmal Spielen? (ja/nein)");
			// Scanner for User Input that save it in the String con
			Scanner continueGameScanner = new Scanner(System.in);
			con = continueGameScanner.nextLine();
			// if Input is nein than dont't continue the game
			if (con.equals("nein")) {
				System.out.println("Danke fürs Spielen!");
				continueGame = false;
				// variable that shows that Input is true
				rigthContinueInput = true;
			}
			// if Input is ja than continue the game
			else if (con.equals("ja")) {
				System.out.println("Das Spiel startet von vorne!");
				// winCon to false for next game
				winCon = false;
				// array gets reset for next game all values go back to ' '
				for (int i = 0; i <= 8; i++) {
					gameboard[i] = ' ';
				}
				// variable that shows that Input is true
				rigthContinueInput = true;
				// changes player to Player 1 that in a new game Player 1 starts
				player = "Player 1";
				continueGame = true;
			}
			// if Input is not ja or nein then give out an error message and repeat the
			// question if User wants to continue
			else if (!con.equals("nein") && !con.equals("ja")) {
				System.out.println("Bitte geben sie ja oder nein ein");
				rigthContinueInput = false;
			}
		}
	}

}

