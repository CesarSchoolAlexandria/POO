package veiculos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Veiculo {

	private TipoVeiculo tipo;

	private boolean arCondicionado;

	private int numPassageiros;

	private TipoCombustivel tipoCombustivel;

	private double valorDiaria;

	private boolean kmLivre;

	private String placaVeiculo;

	private Integer anoFabricacao;

	private int kmTotal;

	public TipoVeiculo getTipos() {
		return tipo;
	}

	public void setTipos(TipoVeiculo tipos) {
		this.tipo = tipos;
	}

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	public int getNumPassageiros() {
		return numPassageiros;
	}

	public void setNumPassageiros(int numPassageiros) {
		this.numPassageiros = numPassageiros;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public boolean isKmLivre() {
		return kmLivre;
	}

	public void setKmLivre(boolean kmLivre) {
		this.kmLivre = kmLivre;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public int getanoFabricacao() {
		return anoFabricacao;
	}

	public void setanoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public int getKmTotal() {
		return kmTotal;
	}

	public void setKmTotal(int kmTotal) {
		this.kmTotal = kmTotal;
	}

	public static List<Veiculo> cadastrarVeiculos() {

		List<Veiculo> lista = new ArrayList<Veiculo>();

		Veiculo v1 = new Veiculo();

		v1.setTipos(TipoVeiculo.BASICO);
		v1.setArCondicionado(true);
		v1.setNumPassageiros(4);
		v1.setTipoCombustivel(TipoCombustivel.GASOLINA);
		v1.setValorDiaria(100);
		v1.setKmLivre(true);
		v1.setPlacaVeiculo("AAA-0000");
		v1.setanoFabricacao(2007);
		v1.setKmTotal(50000);
		
		Veiculo v4 = new Veiculo();

		v4.setTipos(TipoVeiculo.BASICO);
		v4.setArCondicionado(true);
		v4.setNumPassageiros(3);
		v4.setTipoCombustivel(TipoCombustivel.FLEX);
		v4.setValorDiaria(150);
		v4.setKmLivre(true);
		v4.setPlacaVeiculo("AAA-0000");
		v4.setanoFabricacao(2005);
		v4.setKmTotal(50000);

		Veiculo v2 = new Veiculo();

		v2.setTipos(TipoVeiculo.EXECUTIVO);
		v2.setArCondicionado(true);
		v2.setNumPassageiros(5);
		v2.setTipoCombustivel(TipoCombustivel.FLEX);
		v2.setValorDiaria(350);
		v2.setKmLivre(false);
		v2.setPlacaVeiculo("BBB-0000");
		v2.setanoFabricacao(2018);
		v2.setKmTotal(10000);

		Veiculo v3 = new Veiculo();

		v3.setTipos(TipoVeiculo.COMUM);
		v3.setArCondicionado(true);
		v3.setNumPassageiros(4);
		v3.setTipoCombustivel(TipoCombustivel.ELETRICO);
		v3.setValorDiaria(180);
		v3.setKmLivre(true);
		v3.setPlacaVeiculo("CCC-0000");
		v3.setanoFabricacao(2016);
		v3.setKmTotal(30000);

		lista.add(v1);
		lista.add(v2);
		lista.add(v3);
		lista.add(v4);
		return lista;

	}

	public static List<Veiculo> listarVeiculos(TipoVeiculo i) {

		
		List<Veiculo> veiculotipo = new ArrayList<Veiculo>();
		for (Veiculo veiculo : cadastrarVeiculos()) {
			if (veiculo.getTipos().equals(i)) {
				veiculotipo.add(veiculo);
			}
		}
		return veiculotipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoFabricacao;
		result = prime * result + (arCondicionado ? 1231 : 1237);
		result = prime * result + (kmLivre ? 1231 : 1237);
		result = prime * result + kmTotal;
		result = prime * result + numPassageiros;
		result = prime * result + ((placaVeiculo == null) ? 0 : placaVeiculo.hashCode());
		result = prime * result + ((tipoCombustivel == null) ? 0 : tipoCombustivel.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (anoFabricacao != other.anoFabricacao)
			return false;
		if (arCondicionado != other.arCondicionado)
			return false;
		if (kmLivre != other.kmLivre)
			return false;
		if (kmTotal != other.kmTotal)
			return false;
		if (numPassageiros != other.numPassageiros)
			return false;
		if (placaVeiculo == null) {
			if (other.placaVeiculo != null)
				return false;
		} else if (!placaVeiculo.equals(other.placaVeiculo))
			return false;
		if (tipoCombustivel != other.tipoCombustivel)
			return false;
		if (tipo != other.tipo)
			return false;
		if (Double.doubleToLongBits(valorDiaria) != Double.doubleToLongBits(other.valorDiaria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo [tipo=" + tipo + ", arCondicionado=" + arCondicionado + ", numPassageiros=" + numPassageiros
				+ ", tipoCombustivel=" + tipoCombustivel + ", valorDiaria=" + valorDiaria + ", kmLivre=" + kmLivre
				+ ", placaVeiculo=" + placaVeiculo + ", anoFabicacao=" + anoFabricacao + ", kmTotal=" + kmTotal + "]\n";
	}

	public static Comparator<Veiculo> comparaPorAno = new Comparator<Veiculo>() {

		@Override
		public int compare(Veiculo o1, Veiculo o2) {
			Integer anov1 = o1.getanoFabricacao();
			Integer anov2 = o2.getanoFabricacao();
			return anov1.compareTo(anov2);
		}

	};

	public static Comparator<Veiculo> comparaDiaria = new Comparator<Veiculo>() {

		@Override
		public int compare(Veiculo o1, Veiculo o2) {
			Double diariav1 = o1.getValorDiaria();
			Double diariav2 = o2.getValorDiaria();
			return diariav1.compareTo(diariav2);
		}

	};
}
