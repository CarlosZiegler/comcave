package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			/*st = conn.prepareStatement( // aqui vai o SQL
					"INSERT INTO SELLER " + "(Name, Email, BirthDate, BaseSalary, DepartmentId)" + "VALUES"
							+ "(?,?,?,?,?)",// aqui nao precisa declara a string, pode-se usar os ? para indicar que
								Statement.RETURN_GENERATED_KEYS			// aqui vai ser inserido os valores mais tarde
							
			);
			st.setString(1, "José Maria"); // metodo para identificar onde sera inserido o valor ?
			st.setString(2, "jose@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("30/11/1988").getTime())); // aqui ele recebe o valor do tipo data
			st.setDouble(4, 5000.00);
			st.setInt(5, 2);
			 */
			
			st= conn.prepareStatement(
					"insert into department (Name) values ('D1'),('D2')",
					Statement.RETURN_GENERATED_KEYS);
			
			

			int rowsAffected = st.executeUpdate();
			//System.out.println("Done! Rows affected : " + rowsAffected);
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! ID= " + id);
				}
			}else {
				System.out.println("No rown Affected");
			}

		} catch (SQLException e) {
			e.getMessage();
		} /*catch (ParseException e) {
			e.getMessage();
		}*/

		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
