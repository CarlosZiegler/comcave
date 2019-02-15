package entities;

public enum WorkrLevel {
	JUNIOR(1), MID_LEVEL(2), SENIOR(3);

	private final int valor;

	WorkrLevel(int valorOpcao) {
		valor = valorOpcao;
	}

	public int getValor() {
		return valor;
	}

}
