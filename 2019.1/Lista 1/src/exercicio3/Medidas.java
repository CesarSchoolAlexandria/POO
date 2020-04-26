package exercicio3;



public class Medidas {

	// Atributos
	private String unidadeDeDistancia;
	private double distancia;
	private String unidadeDeMassa;
	private double massa;
	private String unidadeDeTemperatura;
	private double temperatura;

	// Construtor vazio
	public Medidas() {

	}

    //Construtor com parâmetros
	public Medidas(String unidadeDeDistancia, double distancia, String unidadeDeMassa, double massa,
			String unidadeDeTemperatura, double temperatura) {

		this.unidadeDeDistancia = unidadeDeDistancia;
		this.distancia = distancia;
		this.unidadeDeMassa = unidadeDeMassa;
		this.massa = massa;
		this.unidadeDeTemperatura = unidadeDeTemperatura;
		this.temperatura = temperatura;
	}

	public String getUnidadeDeDistancia() {
		return unidadeDeDistancia;
	}

	public void setUnidadeDeDistancia(String unidadeDeDistancia) {
		this.unidadeDeDistancia = unidadeDeDistancia;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public String getUnidadeDeMassa() {
		return unidadeDeMassa;
	}

	public void setUnidadeDeMassa(String unidadeDeMassa) {
		this.unidadeDeMassa = unidadeDeMassa;
	}

	public double getMassa() {
		return massa;
	}

	public void setMassa(double massa) {
		this.massa = massa;
	}

	public String getUnidadeDeTemperatura() {
		return unidadeDeTemperatura;
	}

	public void setUnidadeDeTemperatura(String unidadeDeTemperatura) {
		this.unidadeDeTemperatura = unidadeDeTemperatura;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return "Medidas [unidadeDeDistancia=" + unidadeDeDistancia + ", distancia=" + distancia + ", unidadeDeMassa="
				+ unidadeDeMassa + ", massa=" + massa + ", unidadeDeTemperatura=" + unidadeDeTemperatura
				+ ", temperatura=" + temperatura + "]";
	}
	
	

	}
