package io.altar.jseproject.state;


import io.altar.jseproject.utils.ScannerUtils;

public class MainMenu implements State{
	public ScannerUtils inputConsole = new ScannerUtils();
	
	@Override
	public int execute() {
		int [] validOptions = {1,2,3};
		System.out.println("STOCK MANAGER\n");
		System.out.println("1 - Listar produtos.");
		System.out.println("2 - Listar prateleiras.");
		System.out.println("3 - Sair.\n");
		return inputConsole.InputInt(validOptions);	
	}

}
