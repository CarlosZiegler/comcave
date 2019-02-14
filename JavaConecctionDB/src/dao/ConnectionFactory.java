package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class ConnectionFactory {

	
	public Connection  getConexao() {
		
		
			try {
				return DriverManager.getConnection("jdbc:mysql://localhost:3306/comercial?user=root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
			
		
		
		
	}
	
	
}
