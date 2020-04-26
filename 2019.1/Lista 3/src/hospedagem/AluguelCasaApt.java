package hospedagem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AluguelCasaApt extends Hospedagem{

	private int numQuartos;
	
	private boolean possuiCozinha;

	@Override
	public int notaAvaliacao() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite uma nota de Avaliação de 0 a 10");
		int nota = scan.nextInt();
		this.setNota(((this.getNota()*9)+nota)/10);
		System.out.println("Nova avaliação:" + this.getNota());
		scan.close();
		return this.getNota();
	}

	public int getNumQuartos() {
		return numQuartos;
	}

	public void setNumQuartos(int numQuartos) {
		this.numQuartos = numQuartos;
	}

	public boolean isPossuiCozinha() {
		return possuiCozinha;
	}

	public void setPossuiCozinha(boolean possuiCozinha) {
		this.possuiCozinha = possuiCozinha;
	}
	
	public static List<AluguelCasaApt> cadastrarCasaApt() {

		List<AluguelCasaApt> lista = new ArrayList<AluguelCasaApt>();

		AluguelCasaApt h1 = new AluguelCasaApt();
		
		h1.setCafeDaManha(true);
		h1.setCancelamentoGratis(true);
		h1.setHorarioCheckIn("14:00");
		h1.setHorarioCheckOut("12:00");
		h1.setNota(9);
		h1.setNumQuartos(3);
		h1.setTempoMinHospedagem(2);
		List<TipoIdioma> idiomas = new ArrayList<TipoIdioma>();
		idiomas.add(TipoIdioma.ESPANHOL);
		idiomas.add(TipoIdioma.PORTUGUES);
		h1.setIdiomasFalados(idiomas);
		h1.setPossuiCozinha(false);
		h1.setValorDiaria(1800);
		
		lista.add(h1);
		
		AluguelCasaApt h2 = new AluguelCasaApt();
		
		h2.setCafeDaManha(true);
		h2.setCancelamentoGratis(false);
		h2.setHorarioCheckIn("15:00");
		h2.setHorarioCheckOut("09:00");
		h2.setNota(7);
		h2.setNumQuartos(2);
		h2.setTempoMinHospedagem(2);
		List<TipoIdioma> idiomas2 = new ArrayList<TipoIdioma>();
		idiomas2.add(TipoIdioma.INGLES);
		idiomas2.add(TipoIdioma.PORTUGUES);
		h2.setIdiomasFalados(idiomas2);
		h2.setPossuiCozinha(true);
		h2.setValorDiaria(1000);
		
		lista.add(h2);
		
		return lista;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (cancelamentoGratis ? 1231 : 1237);
		result = prime * result + (cafeDaManha ? 1231 : 1237);
		result = prime * result + tempoMinHospedagem;
		result = prime * result + nota;
		result = prime * result + ((horarioCheckOut == null) ? 0 : horarioCheckOut.hashCode());
		result = prime * result + ((horarioCheckIn == null) ? 0 : horarioCheckIn.hashCode());
		result = prime * result + ((idiomasFalados == null) ? 0 : idiomasFalados.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorDiaria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numQuartos;
		result = prime * result + (possuiCozinha ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AluguelCasaApt other = (AluguelCasaApt) obj;
		if (cancelamentoGratis != other.cancelamentoGratis)
			return false;
		if (cafeDaManha != other.cafeDaManha)
			return false;
		if (tempoMinHospedagem != other.tempoMinHospedagem)
			return false;
		if (nota != other.nota)
			return false;
		if (horarioCheckOut == null) {
			if (other.horarioCheckOut != null)
				return false;
		} else if (!horarioCheckOut.equals(other.horarioCheckOut))
			return false;
		if (horarioCheckIn == null) {
			if (other.horarioCheckIn != null)
				return false;
		} else if (!horarioCheckIn.equals(other.horarioCheckIn))
			return false;
		if (idiomasFalados != other.idiomasFalados)
			return false;
		if (Double.doubleToLongBits(valorDiaria) != Double.doubleToLongBits(other.valorDiaria))
			return false;
		if (numQuartos != other.numQuartos)
			return false;
		if (possuiCozinha != other.possuiCozinha)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nCasa ou Apt [valorDiaria=" + valorDiaria + ", idiomasFalados=" + idiomasFalados + ", nota=" + nota
				+ ", cancelamentoGratis=" + cancelamentoGratis + ", cafeDaManha=" + cafeDaManha + ", horarioCheckIn=" + horarioCheckIn
				+ ", horarioCheckOut=" + horarioCheckOut + ", tempoMinHospedagem=" + tempoMinHospedagem + ", numQuartos="
				+ numQuartos + ", possuiCozinha=" + possuiCozinha  + "]\n";
	}

	public static List<AluguelCasaApt> listarHospedagem() {

		
		List<AluguelCasaApt> hospedagem = new ArrayList<AluguelCasaApt>();
		for (AluguelCasaApt hosp : cadastrarCasaApt()) {
				hospedagem.add(hosp);
		}
		return hospedagem;
	}
	
	public static Comparator<AluguelCasaApt> comparaQuartos = new Comparator<AluguelCasaApt>() {

		@Override
		public int compare(AluguelCasaApt o1, AluguelCasaApt o2) {
			Integer estrelash1 = o1.getNumQuartos();
			Integer estrelash2 = o2.getNumQuartos();
			return estrelash1.compareTo(estrelash2);
		}
	};
	
	public static Comparator<AluguelCasaApt> comparaDiaria = new Comparator<AluguelCasaApt>() {

		@Override
		public int compare(AluguelCasaApt o1, AluguelCasaApt o2) {
			Double diariav1 = o1.getValorDiaria();
			Double diariav2 = o2.getValorDiaria();
			return diariav1.compareTo(diariav2);
		}
	};
}
