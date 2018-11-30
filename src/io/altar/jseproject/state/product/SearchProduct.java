package io.altar.jseproject.state.product;

import io.altar.jseproject.state.ProductMenu;
import io.altar.jseproject.state.State;

public class SearchProduct extends ProductMenu implements State{

	@Override
	public int execute() {
		System.out.println("Digite o id do produto a consultar:");
		Long id = inputConsole.InputLong();
		System.out.println(productRepository.findById(id);
		return 1;
	}

}
