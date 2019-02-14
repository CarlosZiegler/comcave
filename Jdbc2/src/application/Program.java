package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DB.getConnection(); // cria ou recebe a conexao com DB
			st = conn.createStatement(); // prepara a conexao para receber uma query SQL
			rs = st.executeQuery("select * from department"); // recebe o resultado da query executada
			while (rs.next()) { // le cada elemento, se houver do resultado da query
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name")); // imprime na tela o resultado da query
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DB.closeResultset(rs); // fecha o resultset
			DB.closeStatement(st); // fecha o statement	
			DB.closeConnection(); // fecha a conexao;
		}
		
		
		
	}

}
