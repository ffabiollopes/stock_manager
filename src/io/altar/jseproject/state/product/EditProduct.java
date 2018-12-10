package io.altar.jseproject.state.product;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.state.ProductMenu;
import io.altar.jseproject.state.State;

public class EditProduct extends ProductMenu implements State {

	public Product searchProduct() {
		boolean searchShelfId = true;
		Product product = null;
		while (searchShelfId == true) {
			Long id = inputConsole.InputLong();
			if (productRepository.findById(id) == null) {
				System.out.println("Não existe nenhum produto com esse Id.");
				System.out.println("Deseja procurar outro produto?S/N");
				searchShelfId = inputConsole.userOption();
				System.out.println("Digite o id do produto a alterar");
			} else {
				product = productRepository.findById(id);
				searchShelfId = false;
			}
		}
		return product;
	}

	@Override
	public int execute() {
		int[] validOptionsForIva = {6,13,23};
		Product product = null;
		System.out.println("Digite o id do produto a alterar");
		product = searchProduct();
		System.out.println(product.toString());
		System.out.println("2 - Valor unitario de desconto.");
		System.out.println(product.getDiscountValue());
		System.out.println("introduza o valor novo ou pressiona enter para manter o Valor");
		product.setDiscountValue(inputConsole.validInputIntDiscount(100));
		System.out.println("3 - IVA (Imposto de Valor Acrescentado em percentagem)");
		System.out.println(product.getIva());
		System.out.println("introduza o valor novo ou pressiona enter para manter o Valor");
		product.setIva(inputConsole.InputInt(validOptionsForIva));
		System.out.println("4 - PVP (Preco de Venda ao Publico)");
		System.out.println(product.getPvp());
		System.out.println("introduza o valor novo ou pressiona enter para manter o Valor");
		product.setPvp(inputConsole.InputInt());
		System.out.println(product.toString());
		// Return to state 1
		return 1;
	}

}
