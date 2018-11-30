package io.altar.jseproject.state.shelf;

import java.util.ArrayList;
import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.state.ShelfMenu;
import io.altar.jseproject.state.State;
import io.altar.jseproject.utils.ScannerUtils;

public class AddShelf extends ShelfMenu implements State {

	List<Shelf> shelfList = new ArrayList<>();
	List<Product> produtoList = new ArrayList<>();
	private int[] optionsCapacity = new int[] { 0, 100 };

	@Override
	public int execute() {
		System.out.println("\nAdicionar Prateleiras:\n");
		boolean searchProductId = true;
		//colocar se quero meter produto
		System.out.println("1 - Produto que Alberga.");
		Long id = inputConsole.InputLong();
		do {
			if (productRepository.findById(id) == null) {
				System.out.println("Não existe nenhum produto com esse Id.");
				System.out.println("Deseja procurar outro Produto?");
				searchProductId = inputConsole.userOption();
			}
		} while (searchProductId == true);
		System.out.println("1- Capacidade da Prateleira.");
		//este scanner esta mal
		int EmptyFull = inputConsole.InputInt(optionsCapacity);
		System.out.println("3 - Preco de aluguer de localizacao diario");
		int rentPricePerDay = inputConsole.InputInt();
		Shelf shelf = new Shelf(EmptyFull, rentPricePerDay);
//		shelf.addProduct(produtoList);
		shelfRepository.save(shelf);
		shelfList.add(shelf);		
//		productRepository.findById(id).addShelves(shelfList);
		
		// Return to state 1
		return 1;
	}

}
