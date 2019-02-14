package dao;
import java.sql.Connection;;
public class ProdutoDao {

	public Connection conn;
	
	public ProdutoDao() {
		conn= new ConnectionFactory().getConexao();
		System.out.println("conexao realizada");
	}
	
	
}
