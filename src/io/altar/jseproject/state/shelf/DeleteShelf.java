package io.altar.jseproject.state.shelf;

import io.altar.jseproject.state.State;

public class DeleteShelf extends AddShelf implements State {

	@Override
	public int execute() {
		
		boolean searchShelfId = true;
		do {
			System.out.println("Digite o id da prateleira a eliminar");
			Long id = inputConsole.InputLong();
			if (shelfRepository.findById(id) == null) {
				System.out.println("Não existe nenhuma prateleira com esse Id.");
				System.out.println("Deseja procurar outro prateleira?");
				searchShelfId = inputConsole.userOption();
			}
			else {
				System.out.println(shelfRepository.findById(id));
				System.out.println("Confirma a prateleira a eliminar, S/N");
				boolean delete = inputConsole.userOption();
					if(delete == true){
					shelfRepository.removeById(id);
					System.out.println(shelfRepository.getAll());
				}
				break;
			}
		} while (searchShelfId == true);

		// Return to state 1
		return 1;
	}

}
