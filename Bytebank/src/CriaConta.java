
public class CriaConta {

	public static void main(String[] args) {
		Conta primeiraconta = new Conta();
		//primeiraconta.saldo = 200; // voce nao tem acesso DIRETO ao atributo saldo, pois o atributo tem o
									// modificador PRIVATE
		primeiraconta.setSaldo(200); // voce consegue o atribuir valor 200 ao atributo SALDO com o metodo setSaldo
		//System.out.println("Saldo: " + primeiraconta.saldo);
		System.out.println("Saldo: " + primeiraconta.getSaldo());
		//primeiraconta.saldo += 100;
		//System.out.println("Saldo:" + primeiraconta.saldo);
		Conta segundaConta = primeiraconta;
		//segundaConta.saldo = 50;
		//System.out.println(segundaConta.saldo);

		Conta paulo = new Conta();
		//paulo.saldo = 100;
		paulo.deposita(50);

		boolean conseguSacar = paulo.saca(30);
		System.out.println(conseguSacar);
	}

}
