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

	List<Long> shelfList = new ArrayList<>();
	List<Product> productList = new ArrayList<>();
	

	@Override
	public int execute() {
		int[] validOptions = new int[] {0,100};
		System.out.println("\nAdicionar Prateleiras:\n");
		System.out.println("Deseja adicionar algum Produto?S/N");
		boolean addProductinShelf = false;
		addProductinShelf = inputConsole.userOption();
		System.out.println("1 - Produto que deseja adicionar.");
		Long id = inputConsole.InputLong();
		if (addProductinShelf == true) {
			boolean searchProductId = true;
			do {
				if (productRepository.findById(id) == null) {
					System.out.println("Não existe nenhum produto com esse Id.");
					System.out.println("Deseja procurar outro Produto?S/N");
					searchProductId = inputConsole.userOption();
				}
			} while (searchProductId == true);
		}
		System.out.println("2 - Capacidade da Prateleira.");
		int EmptyFull = inputConsole.InputCapacity(validOptions);	
		System.out.println("3 - Preco de aluguer de localizacao diario");
		int rentPricePerDay = inputConsole.InputInt();
		Shelf shelf = new Shelf(EmptyFull, rentPricePerDay);
		shelf.setProduct(productList);
		shelfRepository.save(shelf);
		shelfList.add(shelf.getId());
//		productRepository.findById(id).addShelves(shelfList);

		// Return to state 1
		return 1;
	}

}
