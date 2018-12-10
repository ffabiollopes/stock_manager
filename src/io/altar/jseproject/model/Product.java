package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.List;

public class Product extends Entity {
	// Variables
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

	public List<Shelf> getShelves() {
		return shelves;
	}

	public void addShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}

	public int getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(int discountValue) {
		this.discountValue = discountValue;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public int getPvp() {
		return pvp;
	}

	public void setPvp(int pvp) {
		this.pvp = pvp;
	}

	// /**
//	 * @return str Shelves in string
//	 */
	private String printShelves() {
		String str = "";

		for (int i = 0; i < this.shelves.size(); i++) {
			str += this.shelves.get(i).getId();
			str += ", ";
		}
		return str;
	}

	public List<Long> printIdShelves() {
		List<Long> shelfListToInsert = new ArrayList<>();

		for (int i = 0; i < this.shelves.size(); i++) {
			shelfListToInsert.add(this.shelves.get(i).getId());
			;

		}
		return shelfListToInsert;
	}

	@Override
	public String toString() {
		return "|Product: " + getId() + ", shelves:" + printShelves() + " discountValue:" + discountValue + ", iva:"
				+ iva + ", pvp:" + pvp + "|";

	}

}
