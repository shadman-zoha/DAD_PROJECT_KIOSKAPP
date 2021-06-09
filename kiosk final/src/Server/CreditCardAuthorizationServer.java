package Server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import CreditCardValidation.CreditCard;
import CreditCardValidation.InvalidCreditCardException;
import Views.CCServerView;

public class CreditCardAuthorizationServer {

	public static void main (String[] args) throws IOException {
	

		
		int PORT = 3322;
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(PORT); 
		
		CCServerView creditCardServerGUI = new CCServerView();
		creditCardServerGUI.setVisible(true);
		
		while(true) {
			
		Socket socket = serverSocket.accept();// connect to orderServer 
		
		DataInputStream dataIn = new DataInputStream(socket.getInputStream());
		DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
	
			boolean status = false;
			String receive = dataIn.readUTF();// receive the text 
			
			creditCardServerGUI.addText("Receiving the credit card number ("+receive+")");
			
			
			CreditCard creditCardValidation = new CreditCard();
			try {
				Long creditCard = Long.parseLong(receive);
				
				creditCardServerGUI.addText("Checking the validity of the credit card");
				if(!(creditCardValidation.isValid(creditCard))) {
					status = false;
					throw new InvalidCreditCardException();
				}
				else {
					
					status = true;
					JFrame frame = new JFrame();
				    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    frame.setAlwaysOnTop(true);
				    frame.setSize(500, 500);
				    frame.setLocation(500, 500);
					JOptionPane.showMessageDialog(frame, "the transaction is success. ThankYou :D", "DONE!", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}catch (InvalidCreditCardException e) {
				System.out.println(e.getMessage());
			}
			
			if(status) {
				creditCardServerGUI.addText("The credit card is valid");
			}
			else {
				creditCardServerGUI.addText("The credit card is not valid");
			}
			
			dataOut.writeBoolean(status);// send the data
			// update to the server gui that we send it off
			creditCardServerGUI.addText("Sending the status back to requester");
		}
		
	}
}