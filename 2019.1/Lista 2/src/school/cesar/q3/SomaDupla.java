package school.cesar.q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SomaDupla {

	private static Integer alvo;
	private static List<Integer> valores = new ArrayList<Integer>();
	static int cont;

	public SomaDupla() {
	}

	public String soma(Integer alvo, List<Integer> valores) {

		for (int i = 0; i < (valores.size() - 1); i++) {
			int j = 1 + i;
			if ((valores.get(i) + valores.get(j)) == alvo) {
				return "indices: " + i + " e " + (i + 1) + "";
			}
		}
		for (int i = (valores.size() - 1); i <= valores.size(); i++) {
			return "indices: " + i + " e " + (i + 1) + "";
		}

		return "índices indeterminados";
	}

	public String somaDupla(Integer alvo, List<Integer> valores) {

		for (int i = 0; i < (valores.size() - 1); i++) {
			for (int j = 1 + i; j <= valores.size() - 1; j++) {
				if ((valores.get(i) + valores.get(j)) == alvo) {
					return "indices: " + i + " e " + j + "";
				}
			}

		}
		return "índices indeterminados";
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String opc = "continuar";
		cont = 0;

		SomaDupla sm = new SomaDupla();

		System.out.println("***** Soma Dupla *****");

		System.out.println(
				"Digite os números a serem inseridos na lista, caso deseje cancelar a inserção digite -parar-");
		while (opc != "parar") {
			System.out.println("Digite o número " + (cont + 1) + " ou digite parar");
			opc = scan.next();
			if (opc.equalsIgnoreCase("parar")) {
				break;
			}
			valores.add(Integer.parseInt(opc));
			cont++;
		}

		System.out.println("Digite o valor do alvo: ");
		alvo = scan.nextInt();
		System.out.println(sm.somaDupla(alvo, valores));

		scan.close();
	}

}
