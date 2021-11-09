
// 2120717 Marco Mohr, 2123474 Marie Kapusta
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/*To-DO
1. aufhören nach Spielen  
*/
public class TicTacToe {
	public static int change;
	public static boolean rightPlace = false;
	public static char[] gameboard = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };

	public static void main(String[] args) {

		boolean winCon = false;
		char changeSymbol = ' ';
		String player = "Player 1";

		// Calls Method to show the Gameboard and explain the game
		explainGame(gameboard);

		// Asks Player if he wants to play against a Person or the Computer
		System.out.println("1 Zweispielermodus");
		System.out.println("2 CPU");
		// Scanner for the decision if you want to play against a Player or CPU
		functionScanner();

		// If Input from User is 1 Play against a Player
		if (change == 1) {
			System.out.println("Sie haben Zweispieler Modus Ausgewählt ");
			while (winCon == false) {
				if (player == "Player 1") {
					System.out.println("Spieler 1 ist am Zug");
					while (rightPlace == false) {
						functionScanner();
						changeSymbol = 'X';
						rightPlacement(gameboard, changeSymbol, change, player);
					}
					rightPlace = false;
					winCondition(gameboard, winCon, player);
					player = "Player 2";
				}
				if (player == "Player 2") {
					while (rightPlace == false) {
						functionScanner();
						changeSymbol = 'O';
						rightPlacement(gameboard, changeSymbol, change, player);
					}
					rightPlace = false;
					winCondition(gameboard, winCon, player);
					player = "Player 1";
				}
			}
		} else if (change == 2) {
			System.out.println("Sie spielen nun gegen den PC");
			while (winCon == false) {
				if (player == "Player 1") {
					while (rightPlace == false) {
						functionScanner();
						changeSymbol = 'X';
						rightPlacement(gameboard, changeSymbol, change, player);
					}
					rightPlace = false;
					winCondition(gameboard, winCon, player);
					player = "CPU";
				}
				if (player == "CPU") {
					while (rightPlace == false) {
						randomNumber();
						System.out.println(change);
						changeSymbol = 'O';
						rightPlacement(gameboard, changeSymbol, change, player);
					}
					rightPlace = false;
					winCondition(gameboard, winCon, player);
					player = "Player 1";
				}
			}
		} else {
			System.out.println("Bitte geben sie 1 oder 2 ein");
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
		Random randomNum = new Random();
		change = randomNum.nextInt(gameboard.length);
		return change;
	}

	// Method to check if the Player or the CPU has won and changes winCon to true
	public static boolean winCondition(char[] gameboard, boolean winCon, String player) {

		if (gameboard[0] == 'X' && gameboard[1] == 'X' && gameboard[2] == 'X'
				|| gameboard[0] == 'O' && gameboard[1] == 'O' && gameboard[2] == 'O') {
			System.out.println("Sieger " + player);
			return winCon = true;
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
		printTicTacToeBoard(gameboard);
	}

	// Method that looks if the Player can put an X or O in the field and don't
	// overwrite a Player Symbol
	public static boolean rightPlacement(char[] gameboard, char changeSymbol, int change, String player) {
		System.out.println(change - 1);
		System.out.println(gameboard);
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
		System.out.println("Bitte geben sie eine Zahl ein die sie auf dem Feld sehen und an");
		System.out.println("welcher stellen sie ihr Symbol setzen wollen");
		for (int i = 0; i<gameboard.length;i++) {
			int a = 1;
			gameboard[i] = (char) a; 
			a++;
		}
		printTicTacToeBoard(gameboard);
	}

}
