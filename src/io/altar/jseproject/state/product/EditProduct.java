package io.altar.jseproject.state.product;

import io.altar.jseproject.state.State;

public class EditProduct implements State{

	@Override
	public int execute() {
		System.out.println("edit");
		return 1;
	}

}
