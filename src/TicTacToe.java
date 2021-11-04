import java.util.Iterator;
import java.util.Scanner;

public class TicTacToe {
	public static String change = null;
	public static void main(String[] args) {
		
		
		String playerString = "Player";

		char[] gameboard = { ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ', };

		printTicTacToeBoard(gameboard);
		
		functionScanner();

		char changeSymbol = ' ';

		if (playerString == "Player") {
			changeSymbol = 'X';
			playerString = "CPU";
		} else if (playerString == "CPU") {
			changeSymbol = 'O';
			playerString = "Player";
		}

		
		switch (change) {
		case "1A":
			gameboard[2] = changeSymbol;
		}

		printTicTacToeBoard(gameboard);

	}

	public static void printTicTacToeBoard(char[] gameboard) {
		
		//for (char[] row : gameboard) {
		//	System.out.println();
		//}
	}
	
	public static String functionScanner() {
		Scanner sc = new Scanner(System.in);
		change = sc.nextLine();
		return change;
	}
}
