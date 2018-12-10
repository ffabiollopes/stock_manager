package io.altar.jseproject.state.product;

import java.util.ArrayList;
import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.state.ProductMenu;
import io.altar.jseproject.state.State;

public class AddProduct extends ProductMenu implements State{
	List<Shelf> shelfList = new ArrayList<>();
	List<Product> productList = new ArrayList<>();
	
	@Override
	public int execute() {
		int[] validOptionsForIva = {6,13,23};
		boolean addShelfWithProduct = false;
		System.out.println("Criar Novo produto:\n");
		System.out.println("Deseja adicionar o produto a uma prateira?S/N");
		addShelfWithProduct = inputConsole.userOption();
		addMore(addShelfWithProduct);
		System.out.println("2 - Valor unitario de desconto.");
		int desconto = inputConsole.validInputIntDiscount(100);
		System.out.println("3 - IVA (Imposto de Valor Acrescentado em percentagem)");
		int iva = inputConsole.InputInt(validOptionsForIva);
		System.out.println("4 - PVP (Preco de Venda ao Publico)");
		int pvp = inputConsole.InputInt();
		Product product = new Product(desconto, iva, pvp);
		product.addShelves(shelfList);
		productRepository.save(product);
		productList.add(product);
		for (Long i = (long) 0; i < product.printIdShelves().size(); i++) {
			shelfRepository.findById(i).setProduct(productList);
		}
		System.out.println(product.toString());
		// Return to state 1
		return 1;
	}
}
