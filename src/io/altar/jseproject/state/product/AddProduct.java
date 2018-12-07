package io.altar.jseproject.state.product;

import io.altar.jseproject.state.State;

public class AddProduct implements State{

	@Override
	public int execute() {
		
		System.out.println("add");
		// Return to state 1
		return 1;
	}
}
