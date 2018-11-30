package io.altar.jseproject.state.shelf;

import static io.altar.jseproject.state.MainMenu.shelfRepository;

import java.util.ArrayList;
import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.state.ShelfMenu;
import io.altar.jseproject.state.State;

public class EditShelf extends ShelfMenu implements State {

	@Override
	public int execute() {
		
		boolean searchShelfId = true;
		do {
			System.out.println("Digite o id da prateleira a alterar");
			Long id = inputConsole.InputLong();
			if (shelfRepository.findById(id) == null) {
				System.out.println("Não existe nenhuma prateleira com esse Id.");
				System.out.println("Deseja procurar outro prateleira?");
				searchShelfId = inputConsole.userOption();
			}
		} while (searchShelfId == true);
		
		// CAPACIDADE DA PRATELEIRA
		System.out.println("\n 1 - Capacidade da Prateleira.");
		System.out.println(shelfRepository.findById(id).getProduct());
		inputConsole.clearScanner();
		System.out.println("introduza o valor novo ou pressiona enter para manter o Valor");
		String EmptyFull = sc.nextLine();
		if (EmptyFull.equals("")) {
			System.out.println("...O valor ficou o mesmo...");
		} else {
			int capacity = Integer.parseInt(EmptyFull);
			shelfRepository.findById((long) id).setCapacity(capacity);
		}

		// PRODUTO
		System.out.println("2 - Produto que Alberga.");
		System.out.println(shelfRepository.findById((long) id).getProduct());

		System.out.println("introduza o valor novo ou pressiona enter para eliminar a referencia do produto");
		String produtoCheck = sc.nextLine();
		if (produtoCheck.equals("")) {
			List<Product> produtoList = new ArrayList<>();
			shelfRepository.findById((long) id).addProduct(produtoList);
		} else {
			List<Product> produtoList = new ArrayList<>();
			System.out.println("Novo Produto");
			Long idProduto = sc.nextLong();
			Product produtoParaPrateleira = shelfRepository.findById(idProduto);
			produtoList.add(produtoParaPrateleira);
			shelfRepository.findById((long) id).addProduct(produtoList);
		}

		// ALUGUER
		System.out.println("3 - Aluguer");
		System.out.println(shelfRepository.findById((long) id).getDailyRentPrice());
		System.out.println("introduza o valor novo ou pressiona enter para manter o Valor");
		String AluguerCheck = sc.nextLine();
		if (AluguerCheck.equals("")) {
			System.out.println("...O valor ficou o mesmo...");
		} else {
			int aluguer = Integer.parseInt(AluguerCheck);
			shelfRepository.findById((long) id).setDailyRentPrice(aluguer);
		}
		
		return 1;
	}

}
