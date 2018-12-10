package io.altar.jseproject.state;


import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public interface State {
	// Singleton Instance of ProductRepository and shelfRepository
	 ShelfRepository shelfRepository = ShelfRepository.getInstance();
	 ProductRepository productRepository = ProductRepository.getInstance();

	public int execute();

}
