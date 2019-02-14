package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//tem que adicionar a biblioteca .jar do Driver de conexao com o SQL no seu projeto
//ich muss mein Driver von MSQL JDBC bei Library importieren
//Build Patch - add external patch
public class DataSource {
	private String hostname;
	private int port;
	private String database;
	private String username;
	private String password;
	


	private Connection connection;

	public DataSource() {
		try {
			hostname = "localhost";
			port = 3306;
			username = "root";
			database="comercial";
			password = "";
			// Hier habe ich direkt bei Workbench genohmmen
			// "jdbc:mysql://localhost:3306/comercial?user=root"
			String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;

			// Hier ghabe ich bai Referenz Libraries die Driver initializiert
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			// hier habe ich die connetcion initializiert
			connection = DriverManager.getConnection(url, username, password);

			System.out.println("Connection läuft ");

		} catch (SQLException ex) {
			System.err.println("Erro na conexao" + ex.getMessage());
		} catch (Exception ex) {
			System.err.println("Erro geral" + ex.getMessage());
		}
	}

	
	public Connection getConnection() {
		return this.connection;
	}

	public void closeDataSource() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			System.err.println("Error Close connection"+e.getMessage());
		}
	}
}
