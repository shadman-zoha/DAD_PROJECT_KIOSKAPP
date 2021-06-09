package db;

import java.sql.*;

import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;

public class OrderedItemDB {

	public int insertOrderedItem(Order order) throws SQLException {
		DBConnection databaseConnection = new DBConnection();
		int status = 0;
		for (OrderedItem orderedItem: order.getOrderedItems())
		{
			
		
		PreparedStatement ps = databaseConnection.prepareStatement("INSERT INTO ordereditem (Item,Quantity,SubTotalAmount,`Order`) VALUES (?, ?, ?, ?)");
		
		ps.setInt(1, orderedItem.getItem().getItem());
		ps.setInt(2, orderedItem.getQuantity());
		ps.setFloat(3, orderedItem.getSubTotalAmount());
		ps.setInt(4, order.getOrderId());
		
		status = status * ps.executeUpdate();
		}
		return status;
		
	}
	
	public OrderedItem getOrderedItem(int id) throws SQLException {
		OrderedItem orderedItem = null;
		DBConnection databaseConnection = new DBConnection();
		PreparedStatement ps = databaseConnection.prepareStatement("SELECT * FROM orderedItem WHERE OrderedItemId = ?");
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			orderedItem = new OrderedItem();
			
			orderedItem.setOrderedItem(id);
			
			ItemDB itemProductDatabase = new ItemDB();
			orderedItem.setItem(itemProductDatabase.getItem(rs.getInt(2)));
			
			orderedItem.setQuantity(rs.getInt(3));
			orderedItem.setSubTotalAmount(rs.getFloat(4));
			
		}
		
		rs.close();
		ps.close();
		return orderedItem;
		
	}
}
