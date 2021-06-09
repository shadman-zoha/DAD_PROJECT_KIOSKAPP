package Client;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import Views.KitchenView;
import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

public class KitchenClient {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{

		KitchenView kitchenGUI = new KitchenView();
		kitchenGUI.setVisible(true);	
		
		int PORT = 3215;
		String ADDRESS = "localhost";
		
		while(true){
			
			Socket socket = new Socket(ADDRESS, PORT);
			socket.setKeepAlive(true);
			
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			
			ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());

			if(dataInputStream.readBoolean()) {
			
				Order order = new Order();
				order = (Order) objectIn.readObject();
				
				if(order != null) {
					
					OrderTransaction orderTransaction = (OrderTransaction) objectIn.readObject();
				
				
					String orderList = "Order referrence number: "+order.getOrderReferenceNumber()+"\n";
					for (OrderedItem orderedItem: order.getOrderedItems()) {
						orderList += orderedItem.getItem().getName()+": "+orderedItem.getQuantity()+"\n";
					}
			
					
					if(orderTransaction.getOrderMode().equalsIgnoreCase("Eat In")){
					kitchenGUI.setTextDineIn(orderList);
					}
					else {
						kitchenGUI.setTextTakeAway(orderList);
					}
				}
			}
		
			socket.close();
	
		}
	}
}