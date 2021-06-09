package kioskapp.item;

import java.io.Serializable;


public class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private int item;
	private String name;
	private float price;
	
	/**
	 * @return the item
	 */
	public int getItem() {
		return item;
	}
	
	/**
	 * @param item the item to set
	 */
	public void setItem(int itemProduct) {
		this.item = itemProduct;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	

}
