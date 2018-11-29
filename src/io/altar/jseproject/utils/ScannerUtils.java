package io.altar.jseproject.utils;

import java.util.Scanner;

public class ScannerUtils {

	private Scanner inputConsole = new Scanner(System.in);
	public int getIntFromScanner(String msg, boolean canBeNull) {
		String input;
		do {
			System.out.println(msg);
			input = inputConsole.nextLine();
			if (canBeNull && input.equals("")) {
				return -1;
			}
		} while (!isType(input, "Integer"));
		return Integer.parseInt(input);
	}
	
	public int getIntFromScanner(String msg) {
		return getIntFromScanner(msg, false);
	}
	
	public int getValidIntFromScanner(String msg, int max, boolean canBeNull) {
		int result;
		do {
			result = getIntFromScanner(msg, canBeNull);
			if (result > max)
				System.out.println("O Numero tem de ser menor que " + max);
		} while (result > max);
		return result;
	}
	
	public int getValidIntFromScanner(String msg, int max) {
		return getValidIntFromScanner(msg, max, false);
	}
	
	public int getValidIntFromScanner(String msg, int[] ivas) {
		int result;
		boolean validInt = false;
		do {
			result = getIntFromScanner(msg, false);
			for ( int i : ivas) {
				if (result == i) {
					validInt = true;
				}
			}
			if (!validInt) {
				String validString = "";
				for ( int i : ivas) {
					validString += " " + i;
				}
				System.out.println("Numero errado tem de ser" + validString);
			}
		} while (!validInt);
		return result;
	}

	public float getFloatFromScanner(String msg, boolean canBeNull) {
		String input;
		do {
			System.out.println(msg);
			input = inputConsole.nextLine();
			if (canBeNull && input.equals("")) {
				return -1;
			}
		} while (!isType(input, "Float"));
		return Float.parseFloat(input);
	}
	
	public float getFloatFromScanner(String msg) {
		return getFloatFromScanner(msg, false);
	}

	public boolean isType(String input, String type) {
		switch (type) {
		case "Integer":
			try {
				Integer.parseInt(input);
				return true;
			} catch (NumberFormatException e) {
				System.out.println("Valor errado pff colocar um numero");
				return false;
			} catch (NullPointerException e) {
				System.out.println("Valor errado pff colocar um numero");
				return false;
			}
		case "Float":
			try {
				Float.parseFloat(input);
			} catch (NumberFormatException e) {
				System.out.println("Valor errado pff colocar um numero");
				return false;
			} catch (NullPointerException e) {
				System.out.println("Valor errado pff colocar um numero");
				return false;
			}
			return true;

		default:
			return false;
		}
	}


}
