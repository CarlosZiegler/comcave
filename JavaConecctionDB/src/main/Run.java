package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.ProdutoDao;

public class Run {

	
	public static void main(String[] args) throws SQLException {
		
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/comercial?user=root");
		connection.close();
		
		ProdutoDao a = new ProdutoDao();
		if (connection.isClosed()) {
			System.out.println("Conexao esta fechada");
		} else {
			System.out.println("Conexao esta ativa");
		}
	}
	
}
