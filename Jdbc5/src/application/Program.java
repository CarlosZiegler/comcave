package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbintegrityException;

public class Program {

	public static void main(String[] args) {
	
		//atualizar o salario de um vendedor
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn= DB.getConnection();// sql para deletar o registro do DB
			st = conn.prepareStatement("DELETE FROM department "
					+ "WHERE "
					+ "Id = ?"
					);
					
			st.setInt(1, 2); // vai dar exception pois estou deletando um departamento que tem funcionarios 
							// se colocar um departamento que noa tem funcionarios ele deleta normal	
			
			
			int rowsAffected =  st.executeUpdate();
			System.out.println("Done! Rows affected : " + rowsAffected);
			
		} catch (SQLException e) { //pego a exception do sql e lanco a minha exception personalizada
			throw new DbintegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		
		
	}
}
