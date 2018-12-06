package io.altar.jseproject.state.product;

import io.altar.jseproject.state.State;

public class AddProduct implements State{

	@Override
	public int execute() {
		
		System.out.println("add");
		return 1;
	}
}
