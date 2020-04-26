package school.cesar.q5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ComparaListas {
	
	
	public static List<Integer> comparar(List<Integer> l1, List<Integer> l2) {
		List<Integer> resultado = new ArrayList<Integer>(l1);
		resultado.retainAll(l2);
		return resultado;
	}
	
	
	public static void main(String[] args) {
		List<Integer> l3 = new ArrayList<Integer>();
		List<Integer> l4 = new ArrayList<Integer>();
		
		//Provando que a função funciona
		System.out.println("Teste: ");
		l3.add(1);
		l3.add(2);
		l3.add(5);
		l3.add(8);
		l4.add(2);
		l4.add(6);
		l4.add(8);
		l4.add(7);
		System.out.println(comparar(l3,l4));
		
		System.out.println("Função com números aleatorios: ");
		for(int i = 0; i < 10; i++) {
			List<Integer> l1 = new ArrayList<Integer>();
			List<Integer> l2 = new ArrayList<Integer>();
			
			//Listas de tamanho 100 para aumentar a chance de ter numeros iguais nas duas
			for(int j = 0; j < 100; j++)
				l1.add(ThreadLocalRandom.current().nextInt(-1000,1000));
			
			for(int k = 0; k < 100; k++)
				l2.add(ThreadLocalRandom.current().nextInt(-1000,1000));
			
			System.out.println(comparar(l1,l2));
		}
	}
}
