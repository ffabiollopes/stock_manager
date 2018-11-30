package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.List;

public class Product extends Entity {
	//Variables
	private List<Shelf> shelves;
	private int discountValue;
	private int iva;
	private int pvp;
	/**
	 * @param discountValue
	 * @param iva
	 * @param pvp
	 */
	public Product(int discountValue, int iva, int pvp) {
		super();
		this.shelves = new ArrayList<>();
		this.discountValue = discountValue;
		this.iva = iva;
		this.pvp = pvp;
	}
	/**
	 * @return the shelves
	 */
	public List<Shelf> getShelves() {
		return shelves;
	}
	/**
	 * @param shelves
	 */
	public void addShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}
	/**
	 * @return the discountValue
	 */
	public int getDiscountValue() {
		return discountValue;
	}
	/**
	 * @param discountValue the discountValue to set
	 */
	public void setDiscountValue(int discountValue) {
		this.discountValue = discountValue;
	}
	/**
	 * @return the iva
	 */
	public int getIva() {
		return iva;
	}
	/**
	 * @param iva the iva to set
	 */
	public void setIva(int iva) {
		this.iva = iva;
	}
	/**
	 * @return the pvp
	 */
	public int getPvp() {
		return pvp;
	}
	/**
	 * @param pvp the pvp to set
	 */
	public void setPvp(int pvp) {
		this.pvp = pvp;
	}

	/**
	 * @return str Shelves in string
	 */
	private String printShelves() {
		String str = "";

		for (int i = 0; i < this.shelves.size(); i++) {
			str += this.shelves.get(i).getId();
			str += ", ";
		}
		return str;
	}

	@Override
	public String toString() {
		return "| Produto:" + getId() + ", Prateleira:" + printShelves() + "Valor de Desconto:" + discountValue + ", iva:"
				+ iva + ", pvp:" + pvp + " |";
	}
}
