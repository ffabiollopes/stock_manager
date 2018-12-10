package io.altar.jseproject.state;

public class ShelfMenu extends MainMenu implements State{

	@Override
	public int execute() {
		
		int [] validOptions = {1,2,3,4,5};
		System.out.println("\nLista de Prateleiras:\n");
		System.out.println("1 - Criar nova prateleira.");
		System.out.println("2 - Editar uma prateleira existente.");
		System.out.println("3 - Consultar o detalhe de uma prateleira.");
		System.out.println("4 - Remover uma prateleira.");
		System.out.println("5 - Voltar ao ecra anterior.\n");
		return inputConsole.InputInt(validOptions);
	}

}
