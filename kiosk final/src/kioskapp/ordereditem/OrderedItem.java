package kioskapp.ordereditem;

import java.io.Serializable;

import kioskapp.item.Item;

public class OrderedItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// Declaration of attributes
	private int orderedItem;	
	
	// Implementation of 1:1
	private Item item;
	
	private int quantity;
	private float subTotalAmount;
	
	/**
	 * @return the orderedItem
	 */
	public int getOrderedItem() {
		return orderedItem;
	}
	
	/**
	 * @param orderedItem the orderedItem to set
	 */
	public void setOrderedItem(int orderedItem) {
		this.orderedItem = orderedItem;
	}
	
	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * @param item the item to set
	 */
	public void setItem(Item itemProduct) {
		this.item = itemProduct;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @return the subTotalAmount
	 */
	public float getSubTotalAmount() {
		return subTotalAmount;
	}
	
	/**
	 * @param subTotalAmount the subTotalAmount to set
	 */
	public void setSubTotalAmount(float subTotalAmount) {
		this.subTotalAmount = subTotalAmount;
	}

}
