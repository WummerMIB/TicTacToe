import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	public static int change;

	public static void main(String[] args) {

		String playerString = "Player";
		boolean winCon = false;

		char[] gameboard = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };

		printTicTacToeBoard(gameboard);

		while (winCon == false) {

			char changeSymbol = ' ';

			if (playerString == "Player") {
				System.out.println("Bitte geben sie eine Zahle von 1 - 9 ein");
				functionScanner();
				changeSymbol = 'X';
				butInBoardXOrO(gameboard, changeSymbol);
				winCondition(gameboard, winCon);
				playerString = "CPU";
			}
			if (playerString == "CPU") {
				Random randomPlacemant = new Random();
				System.out.println("CPU denkt nach");
				change = randomPlacemant.nextInt(9) + 1;
				changeSymbol = 'O';
				butInBoardXOrO(gameboard, changeSymbol);
				winCondition(gameboard, winCon);
				playerString = "Player";
			}

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

		if (gameboard[0] == 'X' && gameboard[1] == 'X' && gameboard[2] == 'X') {
			System.out.println("Sie haben gewonnen");
			return winCon = true;
		}
		return false;
	}

	// Method to place an X or an O
	public static void butInBoardXOrO(char[] gameboard, char changeSymbol) {
		switch (change) {
		case 1:
			gameboard[0] = changeSymbol;
			break;
		case 2:
			gameboard[3] = changeSymbol;
			break;
		case 3:
			gameboard[6] = changeSymbol;
			break;
		case 4:
			gameboard[2] = changeSymbol;
			break;
		case 5:
			gameboard[4] = changeSymbol;
			break;
		case 6:
			gameboard[7] = changeSymbol;
			break;
		case 7:
			gameboard[2] = changeSymbol;
			break;
		case 8:
			gameboard[5] = changeSymbol;
			break;
		case 9:
			gameboard[8] = changeSymbol;
			break;
		}
		printTicTacToeBoard(gameboard);
	}
}
