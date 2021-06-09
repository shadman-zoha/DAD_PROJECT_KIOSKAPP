package Client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import Views.MainView;
import WriteFile.WriteFile;
import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;
import kioskapp.ordertransaction.OrderTransaction;

public class MainKioskClient {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException, SQLException, ClassNotFoundException {
		

		int PORT = 3215;
		String ADDRESS = "localhost";
		String stop = "0";
		
		while(true) {
			
			MainView applicationFrame = new MainView();
			applicationFrame.setVisible(true);
			
			Socket socket = new Socket(ADDRESS, PORT);
			socket.setKeepAlive(true);
			
			DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			DataInputStream dataIn = new DataInputStream(socket.getInputStream());
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			
			
			if(applicationFrame.getChoose() != -1) {
				
				if(applicationFrame.getChoose() != -1) {
					
					if(applicationFrame.getChoose() != -1) {
						
						
						String creditCardNumber = applicationFrame.getCreditCardNumber();
						dataOut.writeUTF(creditCardNumber);
						dataOut.flush();
						
						
						ArrayList<OrderedItem> orderedItems = new ArrayList<OrderedItem>();
						orderedItems = applicationFrame.getOrderedItems();
						
						OrderTransaction orderTransaction = new OrderTransaction();
						orderTransaction = applicationFrame.getOrderTransaction();
						
						
						objectOutputStream.writeObject(orderedItems);
						objectOutputStream.reset();
						objectOutputStream.writeObject(orderTransaction);
						objectOutputStream.reset();
						
						
						Order order = new Order();
						order = (Order) objectInputStream.readObject();
						orderTransaction = (OrderTransaction) objectInputStream.readObject();
						
						
						// receipt part
						ReceiptTemplate receiptTemplate = new ReceiptTemplate();
						String receipt = receiptTemplate.Receipt(order, orderTransaction);
						WriteFile data = new WriteFile("Receipt"+order.getOrderId()+".txt", false);
						data.writeToFile(receipt);
						
					}	
					else {
						dataOut.writeUTF(stop);
					}
				}else {
					dataOut.writeUTF(stop);
				}
			}else {
				dataOut.writeUTF(stop);
			}
			
			
			objectOutputStream.close();
			objectInputStream.close();
			dataOut.close();
			dataIn.close();
			socket.close();
			
						applicationFrame.dispose();
			
		}
	}
}
