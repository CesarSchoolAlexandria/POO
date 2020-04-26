package school.cesar.q4.domain;

public enum DiasSemana {

	DOMINGO(1), SEGUNDA(2), TERÇA(3), QUARTA(4), QUINTA(5), SEXTA(6), SABADO(7) ;

	private int valor;

	DiasSemana(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

}
