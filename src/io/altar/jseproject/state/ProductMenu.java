package io.altar.jseproject.state;

public class ProductMenu extends MainMenu implements State {
		
	@Override
	public int execute() {
		int[] validOptions = { 1, 2, 3, 4, 5 };
		System.out.println("\nLista de Produtos:\n");
		System.out.println("1 - Criar Novo produto.");
		System.out.println("2 - Editar um produto existente.");
		System.out.println("3 - Consultar o detalhe de um produto.");
		System.out.println("4 - Remover um produto.");
		System.out.println("5 - Voltar ao ecrã anterior.\n");
		return inputConsole.InputInt("Por favor selecione uma das opções: ", validOptions);
	}

}
