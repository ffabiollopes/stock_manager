package io.altar.jseproject.state.shelf;

import java.util.ArrayList;
import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

import io.altar.jseproject.state.ShelfMenu;
import io.altar.jseproject.state.State;

public class AddShelf extends ShelfMenu implements State {

	List<Shelf> shelfList = new ArrayList<>();
	List<Product> productList = new ArrayList<>();

	public Product addMore(boolean add) {
		boolean searchProductId = true;
		Product product = null;
		while (add == true && searchProductId == true) {
			System.out.println("1 - Produto que deseja adicionar.");
			Long id = inputConsole.InputLong();
			if (productRepository.findById(id) != null) {
				product = productRepository.findById(id);
				searchProductId = false;
			} else {
				System.out.println("Nao existe nenhum produto com esse Id.");
				System.out.println("Deseja procurar outro Produto?S/N");
				searchProductId = inputConsole.userOption();
			}
		}
		return product;
	}

	@Override
	public int execute() {
		Product product = null;
		boolean addProductinShelf = false;
		int EmptyFull;
		System.out.println("\nAdicionar Prateleiras:\n");
		System.out.println("Deseja adicionar algum Produto?S/N");
		addProductinShelf = inputConsole.userOption();
		product = addMore(addProductinShelf);
		// Automatic Shelf capacity
		if (product == null) {
			EmptyFull = 0;
		} else {
			EmptyFull = 100;
		}
		System.out.println("2 - Preco de aluguer de localizacao diario");
		int rentPricePerDay = inputConsole.InputInt();
		Shelf shelf = new Shelf(EmptyFull, rentPricePerDay);
		if (product != null) {
			productList.add(product);
			shelf.setProduct(productList);
			shelfRepository.save(shelf);
			shelfList.add(shelf);
			productRepository.findById(product.getId()).addShelves(shelfList);
		}
		else {
			shelfRepository.save(shelf);
		}
		System.out.println(shelf.toString());
		// Return to state 1
		return 1;
	}
}
