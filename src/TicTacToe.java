
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
	public static boolean continueGame = true;
	public static String con = null;
	public static String player = "Player 1";
	
	public static void main(String[] args) {

		char changeSymbol = ' ';

		while (continueGame == true) {
			// Asks Player if he wants to play against a Person or the Computer
			System.out.println("1 Zweispielermodus");
			System.out.println("2 CPU");

			// Scanner for the decision if you want to play against a Player or CPU
			functionScanner();

			// If Input from User is 1 Play against a Player
			if (change == 1) {
				// Calls Method to show the Gameboard and explain the game
				explainGame(gameboard);
				System.out.println("Sie haben Zweispieler Modus Ausgew�hlt ");
				while (winCon == false) {
					if (player == "Player 1") {
						System.out.println("Spieler 1 ist am Zug");
						while (rightPlace == false) {
							functionScanner();
							changeSymbol = 'X';
							rightPlacement(gameboard, changeSymbol, change, player);
						}
						rightPlace = false;
						winCondition(gameboard, player);
						player = "Player 2";
					} else if (player == "Player 2") {
						while (rightPlace == false) {
							functionScanner();
							changeSymbol = 'O';
							rightPlacement(gameboard, changeSymbol, change, player);
						}
						rightPlace = false;
						winCondition(gameboard, player);
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
						player = "CPU";
					} else if (player == "CPU") {
						while (rightPlace == false) {
							randomNumber();
							System.out.println(change);
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

			continueGame();

		}
	}

	// Method to Print out the TicTacToe field
	public static void printTicTacToeBoard(char[] gameboard) {

		System.out.println("[" + gameboard[0] + "][" + gameboard[1] + "][" + gameboard[2] + "]");
		System.out.println("[" + gameboard[3] + "][" + gameboard[4] + "][" + gameboard[5] + "]");
		System.out.println("[" + gameboard[6] + "][" + gameboard[7] + "][" + gameboard[8] + "]");
	}

	// Method for an Input for the User to place an X
	public static int functionScanner() {
		boolean rightInput = false;
		while (rightInput == false) {
			Scanner sc = new Scanner(System.in);

			if (sc.hasNextInt()) {
				change = sc.nextInt();
				if (change <= 9) {
					return change;
				} else {
					System.out.println("Bitte geben sie ein Zahl eine Richtige Zahl ein");
				}

			} else {
				System.out.println("Bitte geben sie eine Zahl ein");
			}

		}
		return change;
	}

	// Method that gives Random Number between one and nine
	public static int randomNumber() {
		Random randNum = new Random();
		change = randNum.nextInt(9) + 1;
		return change;
	}

	// Method to check if the Player or the CPU has won and changes winCon to true
	public static boolean winCondition(char[] gameboard, String player) {

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
		if (gameboard[0] != ' ' && gameboard[1] != ' ' && gameboard[2] != ' ' && gameboard[3] != ' '
				&& gameboard[4] != ' ' && gameboard[5] != ' ' && gameboard[6] != ' ' && gameboard[7] != ' '
				&& gameboard[8] != ' ') {
			System.out.println("Unentschieden");
			return winCon = true;
		}
		return false;
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
		if (gameboard[change - 1] == 'X' || gameboard[change - 1] == 'O') {
			if (player == "CPU") {
				System.out.println("Thinking...");
			}
			System.out.println("Bitte setzen sie ihr Symbol wo noch kein Symbol ist");
			return rightPlace = false;
		}
		if (gameboard[change - 1] == ' ') {
			butInBoardXOrOAndPrintBoard(gameboard, changeSymbol);
			return rightPlace = true;
		}
		return false;
	}

	public static void explainGame(char[] gameboard) {
		System.out.println("[1][2][3]");
		System.out.println("[4][5][6]");
		System.out.println("[7][8][9]");
		System.out.println("Bitte geben sie eine Zahl ein die sie auf dem Feld sehen und an");
		System.out.println("welcher stellen sie ihr Symbol setzen wollen");

	}

	public static void continueGame() {
		boolean rigthContinueInput = false;
		while(rigthContinueInput == false) {
		System.out.println("M�chten Sie nocheinmal Spielen? (ja/nein)");
		Scanner continueGameScanner = new Scanner(System.in);
		con = continueGameScanner.nextLine();

		if (con.equals("nein")) {
			System.out.println("Danke f�rs Spielen!");
			continueGame = false;
			rigthContinueInput = true;
		} else if (con.equals("ja")) {
			System.out.println("Das Spiel startet von vorne!");
			winCon = false;
			for (int i = 0; i <= 8; i++) {
				gameboard[i] = ' ';
			}
			rigthContinueInput = true;
			player = "Player 1";
			continueGame = true;
		} else if (!con.equals("nein") && !con.equals("ja")) {
			System.out.println("Bitte geben sie ja oder nein ein");
			rigthContinueInput = false;
		}
	}
	}

}
