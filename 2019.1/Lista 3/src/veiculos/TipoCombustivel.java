package veiculos;

public enum TipoCombustivel {
	
	GASOLINA('G'), FLEX('F'), DIESEL('D'), ELETRICO('E');
	
	private char tipoCombustivel;
	
	
	TipoCombustivel(char tipo) {
		tipoCombustivel = tipo;
	}
	
	public char getTipoCombustivel() {
	return tipoCombustivel;
	
	}
	
}
