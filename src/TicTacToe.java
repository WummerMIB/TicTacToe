import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	public static int change;
	public static boolean rightPlace = false;
	public static char[] gameboard = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
	public static void main(String[] args) {

		boolean winCon = false;
		char changeSymbol = ' ';
		String player = "Player 1";

		printTicTacToeBoard(gameboard);
		System.out.println("1 Zweispielermodus");
		System.out.println("2 CPU");
		functionScanner();

		if (change == 1) {
			System.out.println("Sie haben Zweispieler Modus Ausgewählt ");
			while (winCon == false) {
				if (player == "Player 1") {
					while (rightPlace == false) {
						functionScanner();
						changeSymbol = 'X';
						rightPlacement(gameboard, changeSymbol, change);
					}
					rightPlace = false;
					winCondition(gameboard, winCon);
					player = "Player 2";
				}
				if (player == "Player 2") {
					while (rightPlace == false) {
						functionScanner();
						changeSymbol = 'O';
						rightPlacement(gameboard, changeSymbol, change);
					}
					rightPlace = false;
					winCondition(gameboard, winCon);
					player = "Player 1";
				}
			}
		} else if (change == 2) {
			System.out.println("Sie spielen nun gegen den PC");
			while (winCon == false) {
				if (player == "Player 1") {
					functionScanner();
					changeSymbol = 'X';
					butInBoardXOrOAndPrintBoard(gameboard, changeSymbol);
					winCondition(gameboard, winCon);
					player = "CPU";
				}
				if (player == "CPU") {
					randomNumber();
					changeSymbol = 'O';
					butInBoardXOrOAndPrintBoard(gameboard, changeSymbol);
					winCondition(gameboard, winCon);
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
		Scanner sc = new Scanner(System.in);
		change = sc.nextInt();
		return change;
	}

	// Method to check if the Player or the CPU has won and changes winCon to true
	public static boolean winCondition(char[] gameboard, boolean winCon) {

		if (gameboard[0] == 'X' && gameboard[1] == 'X' && gameboard[2] == 'X'
				|| gameboard[0] == 'O' && gameboard[1] == 'O' && gameboard[2] == 'O') {
			System.out.println("Sie haben gewonnen");
			return winCon = true;
		}
		if (gameboard[3] == 'X' && gameboard[4] == 'X' && gameboard[5] == 'X'
				|| gameboard[3] == 'O' && gameboard[4] == 'O' && gameboard[5] == 'O') {
			System.out.println("Sie haben gewonnen");
			return winCon = true;
		}
		if (gameboard[6] == 'X' && gameboard[7] == 'X' && gameboard[8] == 'X'
				|| gameboard[6] == 'O' && gameboard[7] == 'O' && gameboard[8] == 'O') {
			System.out.println("Sie haben gewonnen");
			return winCon = true;
		}
		if (gameboard[0] == 'X' && gameboard[3] == 'X' && gameboard[6] == 'X'
				|| gameboard[0] == 'O' && gameboard[3] == 'O' && gameboard[6] == 'O') {
			System.out.println("Sie haben gewonnen");
			return winCon = true;
		}
		if (gameboard[1] == 'X' && gameboard[4] == 'X' && gameboard[7] == 'X'
				|| gameboard[1] == 'O' && gameboard[4] == 'O' && gameboard[7] == 'O') {
			System.out.println("Sie haben gewonnen");
			return winCon = true;
		}
		if (gameboard[2] == 'X' && gameboard[5] == 'X' && gameboard[8] == 'X'
				|| gameboard[2] == 'O' && gameboard[5] == 'O' && gameboard[8] == 'O') {
			System.out.println("Sie haben gewonnen");
			return winCon = true;
		}
		if (gameboard[0] == 'X' && gameboard[4] == 'X' && gameboard[8] == 'X'
				|| gameboard[0] == 'O' && gameboard[4] == 'O' && gameboard[8] == 'O') {
			System.out.println("Sie haben gewonnen");
			return winCon = true;
		}
		if (gameboard[6] == 'X' && gameboard[4] == 'X' && gameboard[2] == 'X'
				|| gameboard[6] == 'O' && gameboard[4] == 'O' && gameboard[2] == 'O') {
			System.out.println("Sie haben gewonnen");
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

	public static boolean rightPlacement(char[] gameboard, char changeSymbol, int change) {
		System.out.println(gameboard);
		if (gameboard[change] == 'X' || gameboard[change] == 'O' ) {
			System.out.println("Bitte setzen sie ih Symbol wo noch kein Symbol ist");
			return rightPlace = false;
		}if (gameboard [change] == ' ') {
			butInBoardXOrOAndPrintBoard(gameboard, changeSymbol);
			return rightPlace = true;
		}
			return false;
	}

	public static int randomNumber() {
		Random randomNum = new Random();
		change = randomNum.nextInt(9) + 1;
		return change;
	}
}
