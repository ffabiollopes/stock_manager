package io.altar.jseproject.FSM;

import io.altar.jseproject.state.*;

public class FSM {
	
	//All Menus of StockManager;
	private State[] states = { 
			new MainMenu(),		 // 0
			new ProductMenu(), 	 // 1
			new ShelfMenu() }; 	 // 2

	//The Transition Matrix;
	private int stateMatrix[][] = { 
			{ 1, 2 }, 		   // state 0
			{ 0,1,1,1,1,0},    // state 1
			{ 0,2,2,2,2,0} };  // state 2

	//My state always star at 0;
	private int currentState = 0;
	
	//Main
	public static void main(String[] args) {
		FSM fsm = new FSM();
		int navigation = 0;
		
		while (true) {
			//Start
			navigation = fsm.states[fsm.currentState].execute();
			//Exit Option
			if (fsm.currentState == 0 && navigation == 3) {
				break;
			}
			//Navigation in the Matrix
			fsm.currentState = fsm.stateMatrix[fsm.currentState][navigation-1];
		}

	}

}
