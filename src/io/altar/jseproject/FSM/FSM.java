package io.altar.jseproject.FSM;

import io.altar.jseproject.state.*;
import io.altar.jseproject.state.product.*;
import io.altar.jseproject.state.shelf.*;

public class FSM {

	// All Menus of StockManager;
	private State[] states = {
			new MainMenu(), 	 // 0
			new ProductMenu(),	 // 1
			new AddProduct(), 	 // 2
			new EditProduct(),   // 3
			new SearchProduct(), // 4
			new DeleteProduct(), // 5
			new ShelfMenu(),     // 6
			new AddShelf(),		 // 7
			new EditShelf(),	 // 8
			new SearchShelf(),	 // 9
			new DeleteShelf()};  // 10 
			

	// The Transition Matrix;
	private int stateMatrix[][] = { 
			{ 1, 6 }, 		  // state 0
			{ 2, 3, 4, 5, 0}, // state 1
			{ 1},             // state 2
			{ 1},             // state 3
			{ 1},             // state 4
			{ 1},             // state 5
			{ 7, 8, 9, 10, 0},// state 6
			{ 6},             // state 7
			{ 6},             // state 8
			{ 6},             // state 9
			{ 6}};		      // state 10

	// My state always star at 0;
	private int currentState = 0;

	// Main
	public static void main(String[] args) {
		FSM fsm = new FSM();
		int navigation = 0;

		while (true) {
			// Start
			navigation = fsm.states[fsm.currentState].execute();
			// Exit Option
			if (fsm.currentState == 0 && navigation == 3) {
				break;
			}
			// Navigation in the Matrix
			fsm.currentState = fsm.stateMatrix[fsm.currentState][navigation-1];
		}

	}

}
