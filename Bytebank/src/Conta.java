
public class Conta {
	private double saldo;
	int agencia;
	int numero;
	String titular;

	public void deposita(double valor) {
		this.saldo += valor;

	}

	public boolean saca(double valor) {

		if (this.saldo > valor) {
			this.saldo -= valor;
			return true;
		} else
			return false;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean transfere(double valor, Conta destino) {

		return false;

	}

}