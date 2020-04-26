package hospedagem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Interfaces.IArrumavel;
import Interfaces.IAvaliavel;
import veiculos.TipoVeiculo;
import veiculos.Veiculo;

//contém os atributos compartilhados por todas as hospedagens
public abstract class Hospedagem implements IAvaliavel, IArrumavel{

	protected double valorDiaria;

	// em dias
	protected int tempoMinHospedagem;

	protected boolean cafeDaManha;

	protected String horarioCheckIn;

	protected String horarioCheckOut;

	protected List<TipoIdioma> idiomasFalados;

	protected boolean cancelamentoGratis;

	protected int nota;

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public int getTempoMinHospedagem() {
		return tempoMinHospedagem;
	}

	public void setTempoMinHospedagem(int tempoMinHospedagem) {
		this.tempoMinHospedagem = tempoMinHospedagem;
	}

	public boolean isCafeDaManha() {
		return cafeDaManha;
	}

	public void setCafeDaManha(boolean cafeDaManha) {
		this.cafeDaManha = cafeDaManha;
	}

	public String getHorarioCheckIn() {
		return horarioCheckIn;
	}

	public void setHorarioCheckIn(String horarioCheckIn) {
		this.horarioCheckIn = horarioCheckIn;
	}

	public String getHorarioCheckOut() {
		return horarioCheckOut;
	}

	public void setHorarioCheckOut(String horarioCheckOut) {
		this.horarioCheckOut = horarioCheckOut;
	}

	public boolean isCancelamentoGratis() {
		return cancelamentoGratis;
	}

	public void setCancelamentoGratis(boolean cancelamentoGratis) {
		this.cancelamentoGratis = cancelamentoGratis;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public List<TipoIdioma> getIdiomasFalados() {
		return idiomasFalados;
	}

	public void setIdiomasFalados(List<TipoIdioma> idiomasFalados) {
		this.idiomasFalados = idiomasFalados;
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
		Hospedagem other = (Hospedagem) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "\nHospedagem [valorDiaria=" + valorDiaria + ", idiomasFalados=" + idiomasFalados + ", nota=" + nota
				+ ", cancelamentoGratis=" + cancelamentoGratis + ", cafeDaManha=" + cafeDaManha + ", horarioCheckIn=" + horarioCheckIn
				+ ", horarioCheckOut=" + horarioCheckOut + ", tempoMinHospedagem=" + tempoMinHospedagem + "]\n";
	}

}
