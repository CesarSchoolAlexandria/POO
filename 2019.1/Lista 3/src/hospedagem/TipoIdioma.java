package hospedagem;

public enum TipoIdioma {
	
	PORTUGUES('P'), INGLES('I'), ESPANHOL('E');
	
	private char tipoIdioma;
	
	 TipoIdioma(char tipo) {
		tipoIdioma = tipo;
	}
	 public char getTipoIdioma() {
		 return tipoIdioma;
	 }

}
