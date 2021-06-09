package db;

import java.sql.*;

import kioskapp.item.Item;

public class ItemDB {

	public int insertItem(Item item) throws SQLException {
		
		DBConnection databaseConnection = new DBConnection();
		
		PreparedStatement ps = databaseConnection.prepareStatement("INSERT INTO item (name, price) VALUES ( ?, ?)");
		
		ps.setString	(1, item.getName());
		ps.setDouble	(2, item.getPrice());
		
		int status = ps.executeUpdate();
		
		return status;
		
	}
	
	public Item getItem(int id) throws SQLException {
		
		Item itemProduct = null;
		DBConnection databaseConnection = new DBConnection();
		PreparedStatement ps = databaseConnection.prepareStatement("SELECT * FROM item WHERE Item = ?");
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			itemProduct = new Item();
			
			itemProduct.setItem(id);
			itemProduct.setName(rs.getString(2));
			itemProduct.setPrice(rs.getFloat(3));
			
		}
		
		rs.close();
		ps.close();
		return itemProduct;
	
		
	}
}
