package dao;

import java.util.ArrayList;

import model.Client;

public class Main {

	public static void main(String[] args) {
		DataSource ds = new DataSource();
		ds.getConnection();
		System.out.println("Lesen Tabelle von Datenbank: \n\n");
		ClienDao a = new ClienDao(ds);
		
		
		ArrayList<Client> list = a.readAll();
		for (Client client : list) {
			System.out.println(client.getNome());
			System.out.println(client.getEmail());
			System.out.println(client.getTelefone());
			System.out.println("-------------------------------------------------------------------------------");
		}
		System.out.println();
	}

}
