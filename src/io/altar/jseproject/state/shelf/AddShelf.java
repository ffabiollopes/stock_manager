package io.altar.jseproject.state.shelf;

import java.util.ArrayList;
import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

import io.altar.jseproject.state.ShelfMenu;
import io.altar.jseproject.state.State;

public class AddShelf extends ShelfMenu implements State {

	List<Long> shelfList = new ArrayList<>();
	List<Product> productList = new ArrayList<>();

	// tornar isto generic
	final public Product addMore(boolean add) {
		boolean searchProductId = true;
		while (add == true && searchProductId == true) {
			System.out.println("1 - Produto que deseja adicionar.");
			Long id = inputConsole.InputLong();
			if (productRepository.findById(id) == null) {
				System.out.println("N�o existe nenhum produto com esse Id.");
				System.out.println("Deseja procurar outro Produto?S/N");
				searchProductId = inputConsole.userOption();
			} else {
				productList.add(productRepository.findById(id));
				searchProductId = false;
			}
		}
		return productRepository.findById(id);
	}

	Long id;

	@Override
	public int execute() {

		boolean addProductinShelf = false;
		int EmptyFull;
		System.out.println("\nAdicionar Prateleiras:\n");
		System.out.println("Deseja adicionar algum Produto?S/N");
		addProductinShelf = inputConsole.userOption();
		addMore(addProductinShelf);
		// Automatic Shelf capacity
		if (id == null) {
			EmptyFull = 0;
		} else {
			EmptyFull = 100;
		}
		System.out.println("2 - Preco de aluguer de localizacao diario");
		int rentPricePerDay = inputConsole.InputInt();
		Shelf shelf = new Shelf(EmptyFull, rentPricePerDay);
		shelf.setProduct(productList);
		shelfRepository.save(shelf);
		if (id != null) {
			shelfList.add(shelf.getId());
			productRepository.findById(id).addShelves(shelfList);
			System.out.println("funciona");
		}
		System.out.println(shelfRepository.getAll().toString());
		// Return to state 1
		return 1;
	}

}
