package io.altar.jseproject.state;

import java.util.ArrayList;
import java.util.List;

import io.altar.jseproject.model.Shelf;

public class ProductMenu extends MainMenu implements State {
	
	public List<Shelf> addMore(boolean add) {
		List<Shelf> shelfList = new ArrayList<>();
		boolean searchShelfId = true;
		while (add == true && searchShelfId == true) {
			System.out.println("1 - Prateleira onde deseja adicionar o Produto.");
			Long id = inputConsole.InputLong();
			if (shelfRepository.findById(id) == null) {
				System.out.println("Nao existe nenhuma Prateleira com esse Id.");
				System.out.println("Deseja procurar outra Prateleira?S/N");
				searchShelfId = inputConsole.userOption();
			} else {
				shelfList.add(shelfRepository.findById(id));
				System.out.println("Deseja adicionar o produto a mais prateleiras?S/N");
				searchShelfId = inputConsole.userOption();
			}
		}
		return shelfList;
	}

	@Override
	public int execute() {
		int[] validOptions = { 1, 2, 3, 4, 5 };
		System.out.println("\nLista de Produtos:\n");
		System.out.println("1 - Criar Novo produto.");
		System.out.println("2 - Editar um produto existente.");
		System.out.println("3 - Consultar o detalhe de um produto.");
		System.out.println("4 - Remover um produto.");
		System.out.println("5 - Voltar ao ecr� anterior.\n");
		return inputConsole.InputInt(validOptions);
	}

}
