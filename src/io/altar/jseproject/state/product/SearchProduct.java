package io.altar.jseproject.state.product;

import io.altar.jseproject.state.ProductMenu;
import io.altar.jseproject.state.State;

public class SearchProduct extends ProductMenu implements State{

	@Override
	public int execute() {
		boolean searchProductById = true;
		do {
			System.out.println("Digite o id do Produto a consultar");
			Long id = inputConsole.InputLong();
			if (productRepository.findById(id) == null) {
				System.out.println("Não existe nenhum Produto com esse Id.");
				System.out.println("Deseja procurar outro Produto? S/N");
				searchProductById = inputConsole.userOption();
			}
			else {
			System.out.println(productRepository.findById(id));
			searchProductById = false;
			}
		} while (searchProductById == true);
		
		return 1;
	}

}
