package school.cesar.q3;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Contabilidade {
	private List<Despesa> despesas = new ArrayList<Despesa>();

	public List<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(List<Despesa> despesas) {
		try {
			List<String> despesasUnicas = new ArrayList<String>();
			
			for(Despesa d : despesas) {
				if(despesasUnicas.contains(d.getNome())) throw new InvalidParameterException("Lista contém despesas com o mesmo nome");
				
				despesasUnicas.add(d.getNome());
			}
			
			this.despesas = despesas;
		}catch(InvalidParameterException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
	
	public static void imprimirDespesas(List<Despesa> despesas) {
		despesas.forEach(despesa -> System.out.println(despesa.toString()));
	}
	
	public void ordenadasPorValorMenor() {
		List<Despesa> ordenadas = this.getDespesas();
		
		ordenadas.sort((d1, d2) -> d1.getValor().compareTo(d2.getValor()));
		
		Contabilidade.imprimirDespesas(ordenadas);
	}
	
	public void ordenadasPorValorMaior() {
		List<Despesa> ordenadas = this.getDespesas();
		
		ordenadas.sort((d1, d2) -> d1.getValor().compareTo(d2.getValor()));
		Collections.reverse(ordenadas);
		Contabilidade.imprimirDespesas(ordenadas);
	}
	
	public void ordenadasPorNome() {
		List<Despesa> ordenadas = this.getDespesas();
		
		ordenadas.sort((d1, d2) -> d1.getNome().compareTo(d2.getNome()));
		Contabilidade.imprimirDespesas(ordenadas);
	}
	
	public void ordenadasPorData() {
		List<Despesa> ordenadas = this.getDespesas();
		
		ordenadas.sort((d1, d2) -> d1.getDataDeInsercao().compareTo(d2.getDataDeInsercao()));
		Contabilidade.imprimirDespesas(ordenadas);
	}
	
	public Double somaDespesas() {
		Double soma = despesas.stream().flatMapToDouble(d -> DoubleStream.of(d.getValor())).sum();
		return soma;
	}
	
	public Double mediaDespesas() {
		OptionalDouble media = despesas.stream().flatMapToDouble(d -> DoubleStream.of(d.getValor())).average();
		return media.getAsDouble();
	}
	
	public Despesa menorDespesa() {
		Despesa menor = Collections.min(despesas, Comparator.comparing(d -> d.getValor()));
		return menor;
	}
	
	public Despesa maiorDespesa() {
		Despesa maior = Collections.max(despesas, Comparator.comparing(d -> d.getValor()));
		return maior;
	}
	
	public List<Despesa> menoresQue(Double comparator) {
		List<Despesa> menores = despesas.stream().filter(d -> d.getValor() < comparator).collect(Collectors.toList());
		
		return menores;
	}
	
	public List<String> nomesDespesas() {
		List<String> nomes = new ArrayList<String>();
		despesas.forEach(d -> nomes.add(d.getNome()));
		
		return nomes;
	}
	
	public static void main(String[] args) {
		Contabilidade conta = new Contabilidade();
		List<Despesa> despesas = Despesa.criarDespesas();
		
		conta.setDespesas(despesas);
		
		
		Contabilidade.imprimirDespesas(conta.getDespesas());
		
		System.out.println("\nOrdanadas por valor Menor: ");
		conta.ordenadasPorValorMenor();
		
		System.out.println("\nOrdanadas por valor Maior: ");
		conta.ordenadasPorValorMaior();
		
		System.out.println("\nOrdanadas por nome: ");
		conta.ordenadasPorNome();
		
		System.out.println("\nOrdanadas por valor data de inserção: ");
		conta.ordenadasPorData();
		
		System.out.println("Soma das despesas: " + conta.somaDespesas());
		
		System.out.println("Media das despesas: " + conta.mediaDespesas());
		
		System.out.println("Menor despesa: " + conta.menorDespesa());
		
		System.out.println("Menor despesa: " + conta.maiorDespesa());
		
		System.out.println("Despesas Menores que 600: " + conta.menoresQue(600.0));
		
		System.out.println("Nomes das despesas: " + conta.nomesDespesas());		
	}
}
