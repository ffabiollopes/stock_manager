package io.altar.jseproject.state.product;

import io.altar.jseproject.state.ProductMenu;
import io.altar.jseproject.state.State;

public class DeleteProduct extends ProductMenu implements State{
	@Override
	public int execute() {
		
		boolean searchShelfId = true;
		do {
			System.out.println("Digite o id do Produto a eliminar");
			Long id = inputConsole.InputLong();
			if (productRepository.findById(id) == null) {
				System.out.println("Não existe nenhum produto com esse Id.");
				System.out.println("Deseja procurar outro produto?S/N");
				searchShelfId = inputConsole.userOption();
			}
			else {
				System.out.println(productRepository.findById(id));
				System.out.println("Confirma o Produto a eliminar, S/N");
				boolean delete = inputConsole.userOption();
					if(delete == true){
						productRepository.removeById(id);
					System.out.println(productRepository.getAll());
				}
				break;
			}
		} while (searchShelfId == true);
		return 1;
	}
}
