package io.altar.jseproject.utils;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerUtils {
	// Scanner Instance
	private Scanner inputConsole = new Scanner(System.in);
	// Validating inputConsole Type
	public boolean inputType(String input, String type) {
		Scanner inputTest = new Scanner(input);
		boolean result = false;
		switch (type) {
		case "Integer":
			if (inputTest.hasNextInt()) {
				result = true;
			} else {
				System.out.println("Colocar um número Inteiro!");
			}
			break;
		case "Float":
			if (inputTest.hasNextFloat()) {
				result = true;
			} else {
				System.out.println("Colocar um número Decimal!");
			}
			break;

		default:
			result = false;
		}
		inputTest.close();
		return result;
	}
	// Scanner Of Number Long
	public Long InputLong() {
		String input;
		do {
			input = inputConsole.nextLine();
			if (input.equals("")) {
				return null;
			}
		} while (!inputType(input, "Integer"));
		return Long.parseLong(input);
	}
	// Scanner Of Number Int
	public int InputInt() {
		String input;
		do {
			input = inputConsole.nextLine();
			if (input.equals("")) {
				return -1;
			}
		} while (!inputType(input, "Integer"));
		return Integer.parseInt(input);
	}
	// Menu Scanner
	public int InputInt(String msg, int[] validOptions) {
		String input;
		do {
			System.out.println(msg);
			input = inputConsole.nextLine();
			if (input.equals("")) {
				return -1;
			}
		} while (!inputType(input, "Integer"));

		return Integer.parseInt(input);
	}
	// Shelf Capacity scanner
	public int InputCapacity(int[] validOptions) {
		int input;
		boolean validInt = false;
		do {

			input = InputInt();
			if (input == -1) {
				return -1;
			} else {
				for (int i : validOptions) {
					if (input == i) {
						validInt = true;
					}
				}
				if (!validInt) {
					String validString = Arrays.toString(validOptions);
					System.out.println("Numero errado tem de ser:" + validString);
				}
			}
		} while (!validInt);

		return input;
	}
	// Scanner Of Number Int, with a Max and EnterKeyScanner
	public int validInputIntDiscount(int max) {
		int result;
		do {
			result = InputInt();
			if (result > max)
				System.out.println("O Numero tem de ser menor que " + max);
		} while (result > max);
		return result;
	}

	// Scanner Of Number Int, with a defined type of input
	public int validInputIntDiscount(String msg, int max) {
		return validInputIntDiscount(msg, max);
	}

	// Scanner Of Number Int, with a defined type of input
	public int validInputIntIva(String msg, int[] PossibleIva) {
		int result;
		boolean validInt = false;
		do {
			result = InputInt();
			if (result == -1) {
				return -1;
			} else {
				for (int i : PossibleIva) {
					if (result == i) {
						validInt = true;
					}
				}
				if (!validInt) {
					String validString = "";
					for (int i : PossibleIva) {
						validString += " " + i;
					}
					System.out.println("Numero errado tem de ser" + validString);
				}
			}
		} while (!validInt);
		return result;
	}

	// Scanner Of Number Float, with a defined type of input
	public float validInputFloat(String msg, boolean canBeNull) {
		String input;
		do {
			System.out.println(msg);
			input = inputConsole.nextLine();
			if (canBeNull && input.equals("")) {
				return -1;
			}
		} while (!inputType(input, "Float"));
		return Float.parseFloat(input);
	}

	// Scanner Of Number Float
	public float validInputFloat(String msg) {
		return validInputFloat(msg, false);
	}

	// Validating userOption Type
	public boolean userOptionType(String input) {
		Scanner inputTest = new Scanner(input);
		boolean result = false;
		switch (input) {
		case "S":
		case "s":
		case "N":
		case "n":
			if (inputTest.hasNext()) {
				result = true;
			}
			break;
		default:
			result = false;
			System.out.println("Colocar S ou N");
		}
		inputTest.close();
		return result;
	}

	public boolean userOption() {
		String input;
		boolean userOption = false;
		do {
			input = inputConsole.nextLine();
			if (input.equals("S") || input.equals("s")) {
				return userOption = true;
			}
			if (input.equals("N") || input.equals("s")) {
				return userOption = false;
			}

		} while (!userOptionType(input));
		return userOption;
	}

	public void clearScanner() {
		Scanner clear = new Scanner(System.in);
		clear.nextLine();
	}

}
