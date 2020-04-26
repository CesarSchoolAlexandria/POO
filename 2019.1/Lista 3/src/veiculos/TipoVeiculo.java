package veiculos;

public enum TipoVeiculo {
	
	BASICO(1),COMUM(2), EXECUTIVO(3), LUXO(4);
	
	//atributo do tipo
	private int codTipo;
	
	//construtor
	TipoVeiculo(int tipo){
			codTipo = tipo;
	}
		
	public int getTipo() {
		return codTipo;
	}
	
	public static TipoVeiculo fromId(int id) {
		for(TipoVeiculo type : values()) {
			if(type.getTipo() == id) {
				return type;
			}
		}
		return null;
	}
}
