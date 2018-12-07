package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import io.altar.jseproject.model.Entity;


	//Generics Use
public abstract class EntityRepository<T extends Entity> {
	
	//initialize variables
	private long actualId = 0;
	private Map<Long, T> map = new HashMap<Long, T>();
	
	final public EntityRepository<T>   addMore(boolean add, T entity, Scanner scanner) {
		boolean searchProductId = true;
		while (add == true && searchProductId == true) {
			System.out.println("1 - Produto que deseja adicionar.");
			Long id = inputConsole.InputLong();
				if (entity.findById(id) == null) {
					System.out.println("N�o existe nenhum produto com esse Id.");
					System.out.println("Deseja procurar outro Produto?S/N");
					searchProductId = inputConsole.userOption();
				} else {
					productList.add(entity.findById(id));
					searchProductId = false;
				}
			}
		return entity.findById(id);
	}
	
	//Method to create Products/Shelves and give an automatic id
	public void save(T entity) {
		entity.setId(actualId);
		map.put(entity.getId(), entity);
		actualId++;
	}
	
	//Method to save a shelf on Product creation
	public void saveMyId(T entity, Long id) {
		entity.setId(id);
		map.put(entity.getId(), entity);
	}
	
	//Method to Find Products/Shelves by id
	public T findById(Long id) {
		return map.get(id);
	}
	
	//Method to remove Products/Shelves by id
	public void removeById(Long id) {
		map.remove(id);
	}
	
	//Method to get all Products/Shelves
	public Collection<T> getAll() {
		return map.values();
	}
	
	//Not in use - Method to update all Products/Shelves
	public void update(T entity) {
		map.replace(entity.getId(), entity);
	}
}
