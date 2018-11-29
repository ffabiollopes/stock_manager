package io.altar.jseproject.state;

public class MainMenu implements State{
	
	@Override
	public int execute() {
		int [] validOptions = {1,2,3};
		System.out.println("Escolha uma opcão:\n");
		System.out.println("1 - Listar produtos.");
		System.out.println("2 - Listar prateleiras.");
		System.out.println("3 - Sair.");
		return input.getValidIntFromScanner("Por favor selecione uma das opções: ", validOptions);	
	}

}
