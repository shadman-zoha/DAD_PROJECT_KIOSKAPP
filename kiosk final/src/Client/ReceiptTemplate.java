package Client;


import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

public class ReceiptTemplate {

	public String Receipt(Order order, OrderTransaction orderTransaction) {
		
		
		String transStatus = "FAILED!!!";
		if(orderTransaction.isTransactionStatus()) {
			transStatus = "SUCCEED";
		}
		
		// receipt part
		
		String receipt =  "                Burger King RECEIPT\n"
						+ "------------------------------------------------\n"
						+ "               SALES RECEIPT    \n"
						+ "------------------------------------------------\n"
						+ "Qty	Item			Price(RM)\n"
						+ "------------------------------------------------\n";
		for(OrderedItem orderedItem: order.getOrderedItems()) {
			
			receipt += orderedItem.getQuantity()+"	"+orderedItem.getItem().getName()+"	"+String.format ("%4.2f",orderedItem.getSubTotalAmount())+"\n";
		}
		
		receipt += 		  "------------------------------------------------\n"
						+ "Order mode: "+orderTransaction.getOrderMode()+"\n"
						
						+ "------------------------------------------------\n"
						+ "TOTAL:			      "+String.format ("%4.2f",order.getTotalAmount())+"\n"
						+ "------------------------------------------------\n"
						+ "paid with:\n"
						+ "**** **** **** "+orderTransaction.getLast4Digits()+"\n"
						+ "TRANSACTION STATUS: "+transStatus+"\n"
						+ "------------------------------------------------\n"
						+ "------------------------------------------------\n"
						+ "                    THANK YOU         \n"
						+ ""+orderTransaction.getOrderTransactionId()+"                    "+orderTransaction.getTransactioDate();
		
		return receipt;
	}
}
