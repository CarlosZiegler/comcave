package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Client;

public class ClienDao {

	public DataSource datasource;

	public ClienDao(DataSource datasource) {
		this.datasource = datasource;
	}

	public ArrayList<Client> readAll() {

		try {

			String sql = "SELECT * FROM client";
			PreparedStatement ps = datasource.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			ArrayList<Client> listClient = new ArrayList<Client>();
			
			while (rs.next()) {
				Client client = new Client();
				client.setId(rs.getInt("idClient"));
				client.setNome(rs.getString("Nome"));
				client.setEmail(rs.getString("Email"));
				client.setTelefone(rs.getString("Telefone"));

				listClient.add(client);

			}
			ps.close();
			return listClient;

		} catch (SQLException ex) {
			System.err.println("Error get register" + ex.getMessage());
		} catch (Exception ex) {
			System.err.println("Error generic" + ex.getMessage());
		}

		return null;

	}

}
