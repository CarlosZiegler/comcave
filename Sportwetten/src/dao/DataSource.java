package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataSource {

	private String hostname;
	private int port;
	private String database;
	private String username;
	private String password;
	
	private Connection connection;

	private DataSource(String hostname, int port, String database, String username, String password) {
		super();
		
		
		try {
			this.hostname = hostname;
			this.port = port;
			this.database = database;
			this.username = username;
			this.password = password;
			
			String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			connection= DriverManager.getConnection(url,username,password);
			
			System.out.println("Connection Sucess!!");
		} catch (SQLException e) {
			System.err.println("Connection Error "+ e.getMessage());
		}catch (Exception e) {
			System.err.println("Error "+ e.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}
	
	
	public void closeDataSource() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			System.err.println("Error close connection!  "+ e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
}
