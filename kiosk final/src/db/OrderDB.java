package db;

import java.sql.*;

import kioskapp.order.Order;

public class OrderDB {

	public int insertOrder(Order order) throws SQLException {
		DBConnection databaseConnection = new DBConnection();
		
		PreparedStatement ps = databaseConnection.prepareStatement("INSERT INTO `order` (`OrderId`, `TotalAmount`, `OrderReferenceNumber`) VALUES (NULL, ?, ?)");
		
		
		ps.setDouble	(1, order.getTotalAmount());
		ps.setInt		(2, order.getOrderReferenceNumber());
		
		int status = ps.executeUpdate();
		
		return status;
		
		
	}
	
	
	public Order getOrder(int id) throws SQLException {
		
		Order order = null;
		DBConnection databaseConnection = new DBConnection();
		PreparedStatement ps = databaseConnection.prepareStatement("SELECT * FROM order WHERE OrderId = ?");
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			order = new Order();
			
			order.setOrderId(id);
			order.setOrderReferenceNumber(rs.getInt(3));
			order.setTotalAmount(rs.getFloat(2));
			
		}
		
		rs.close();
		ps.close();
		return order;
		
	}
	
	public int getNextOrderId() throws SQLException {
		DBConnection databaseConnection = new DBConnection();
		PreparedStatement ps = databaseConnection.prepareStatement("SHOW TABLE STATUS LIKE 'order'");
		
		ResultSet rs= ps.executeQuery();
		
		if(rs.next()) {
			return rs.getInt(11);
		}
		else {
			return 1;
		}
	}
}
