package io.altar.jseproject.state.shelf;

import io.altar.jseproject.state.State;

public class SearchShelf extends AddShelf implements State{

	@Override
	public int execute() {
		
		boolean searchShelfId = true;
		do {
			System.out.println("Digite o id da prateleira a consultar");
			Long id = inputConsole.InputLong();
			if (shelfRepository.findById(id) == null) {
				System.out.println("Não existe nenhuma prateleira com esse Id.");
				System.out.println("Deseja procurar outro prateleira? S/N");
				searchShelfId = inputConsole.userOption();
			}
			System.out.println(shelfRepository.findById(id));
			break;
		} while (searchShelfId == true);
		
		return 1;
	}

}
