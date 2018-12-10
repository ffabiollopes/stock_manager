package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.List;

public class Shelf extends Entity{
	//Variables
	private List <Product> product;
	private int capacity;
	private int dailyRentPrice;
	/**
	 * @param capacity
	 * @param dailyRentPrice
	 */
	public Shelf(int capacity,int dailyRentPrice) {
		super();
		this.product = new ArrayList<>();
		this.capacity = capacity;
		this.dailyRentPrice = dailyRentPrice;
	}
	/**
	 * @return the product
	 */
	public List<Product> getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * @return the dailyRentPrice
	 */
	public int getDailyRentPrice() {
		return dailyRentPrice;
	}
	/**
	 * @param dailyRentPrice the dailyRentPrice to set
	 */
	public void setDailyRentPrice(int dailyRentPrice) {
		this.dailyRentPrice = dailyRentPrice;
	}
	/**
	 * @return str Products in string
	 */
	private String printProducts() {
		String str = "";

		for (int i = 0; i < this.product.size(); i++) {
			str += this.product.get(i).getId();
			str += ", ";
		}
		return str;
	}
	@Override
	public String toString() {
		return "|Shelf: "+ getId() + ", product:" + printProducts() + " capacity:" + capacity + ", dailyRentPrice:" + dailyRentPrice+"|";
	}
	
}
