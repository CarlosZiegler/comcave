package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		// atualizar o salario de um vendedor

		Connection conn = null;
		Statement st = null;

		try {
			conn = DB.getConnection();// sql para deletar o registro do DB
			
			conn.setAutoCommit(false); // nao é para confirmar as operacoes automaticamente
			
			st = conn.createStatement();
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

			/*aqui simulando um erro para dar um excecao e para o programa*/
			int x = 1;
			//if (x<2) {
			//	throw new SQLException("Fake Error");
			//}
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			
			
			conn.commit();// confirma as operacoes  aqui
			
			
			System.out.println("Rows 1 : "+ rows1);
			System.out.println("Rows 2 : "+ rows2);
			

		} catch (SQLException e) { // pego a exception do sql e lanco a minha exception personalizada
			try {
				conn.rollback(); // volta ao estado anterior
				throw new DbException("Transaction rolled Back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e.getMessage());
			}
			
			
			
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}
}
