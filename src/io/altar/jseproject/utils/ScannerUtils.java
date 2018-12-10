package io.altar.jseproject.utils;

import java.util.Arrays;

import java.util.Scanner;

public class ScannerUtils {
	// Scanner Instance
	private Scanner inputConsole = new Scanner(System.in);

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
			if (input.equals("N") || input.equals("n")) {
				return userOption = false;
			}

		} while (!userOptionType(input));
		return userOption;
	}

	// Validating inputConsole Type
	public boolean inputType(String input, String type) {
		Scanner inputTest = new Scanner(input);
		boolean result = false;
		switch (type) {
		case "int":
			if (inputTest.hasNextInt()) {
				result = true;
			} else {
				System.out.println("Colocar um numero Inteiro!");
			}
			break;
		case "Double":
			if (inputTest.hasNextDouble()) {
				result = true;
			} else {
				System.out.println("Colocar um numero Decimal!");
			}
			break;

		default:
			result = false;
		}
		inputTest.close();
		return result;
	}

	// Menu scanner
	public int InputInt(int[] validOptions) {
		int input;
		boolean validInt = false;
		do {
			input = InputInt();
			for (int i : validOptions) {
				if (input == i) {
					validInt = true;
				}
			}
			if (!validInt) {
				String validString = Arrays.toString(validOptions);
				System.out.println("Por Favor Selecione as seguintes opcoes:" + validString);
			}
		} while (!validInt);
		return input;
	}

	// Scanner Of Number Long
	public Long InputLong() {
		String input;
		do {
			input = inputConsole.nextLine();
		} while (!inputType(input, "int"));
		return Long.parseLong(input);
	}

	// Scanner Of Number Int
	public int InputInt() {
		String input;
		do {
			input = inputConsole.nextLine();	
		} while (!inputType(input, "int"));
		return Integer.parseInt(input);
	}

	// Shelf Capacity scanner
	public int InputCapacity(int[] validOptions) {
		int input;
		boolean validInt = false;
		do {
			input = InputInt();
			
				for (int i : validOptions) {
					if (input == i) {
						validInt = true;
					}
				}
				if (!validInt) {
					String validString = Arrays.toString(validOptions);
					System.out.println("Numero errado tem de ser:" + validString);
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
		} while (!validInt);
		return result;
	}

	// Scanner Of Number Float
	public Float validInputFloat() {
		String input;
		do {
			input = inputConsole.nextLine();
		} while (!inputType(input, "Float"));
		return Float.valueOf(input);
	}


}
