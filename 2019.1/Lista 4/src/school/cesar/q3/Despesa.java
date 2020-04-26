package school.cesar.q3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Despesa {
	private String nome;
	private Double valor;
	private Date dataDeInsercao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Date getDataDeInsercao() {
		return dataDeInsercao;
	}
	public void setDataDeInsercao(Date dataDeInsercao) {
		this.dataDeInsercao = dataDeInsercao;
	}
	
	public static List<Despesa> criarDespesas(){
		List<Despesa> despesas = new ArrayList<Despesa>();
		
		Despesa d1 = new Despesa();
		Despesa d2 = new Despesa();
		Despesa d3 = new Despesa();
		Date agora = new Date();
		
		d1.setNome("Carro");
		d1.setDataDeInsercao(agora);
		d1.setValor(520.20);
		
		d2.setNome("Energia"); // Carro para teste de nomes repetidos
		d2.setDataDeInsercao(agora);
		d2.setValor(300.50);
		
		d3.setNome("Apartamento");
		d3.setDataDeInsercao(agora);
		d3.setValor(1500.20);
		
		
		despesas.add(d1);
		despesas.add(d2);
		despesas.add(d3);
		
		return despesas;
	}
	
	@Override
	public String toString() {
		return "Despesa [nome=" + nome + ", valor=" + valor + ", dataDeInsercao=" + dataDeInsercao + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDeInsercao == null) ? 0 : dataDeInsercao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Despesa other = (Despesa) obj;
		if (dataDeInsercao == null) {
			if (other.dataDeInsercao != null)
				return false;
		} else if (!dataDeInsercao.equals(other.dataDeInsercao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
