package db;


import java.sql.*;

public class DBConnection {
		
	private String databaseName = "kioskappdb_dev";
	private String username = "root";
	private String password = "";
	Connection connection = null;
	
	public DBConnection() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");// driver for JDBC
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ databaseName, username, password);// the username and password for mysql
			
			//System.out.println("Xampp Mysql Connected...");// done connect to db

		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	PreparedStatement prepareStatement(String query) throws SQLException {
		return connection.prepareStatement(query);
	}
	
		
}