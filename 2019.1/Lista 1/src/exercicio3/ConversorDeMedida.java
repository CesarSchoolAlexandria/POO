package exercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversorDeMedida {

	public static void converterMassa(Medidas m1, Medidas m2) {

		if (m1.getUnidadeDeMassa().equals(m2.getUnidadeDeMassa())) {
			System.out.println("Não é possível realizar a conversão, os objetos tem a mesma unidade de massa");
			return;
		}

		if (m1.getUnidadeDeMassa().equals("kg")) {
			System.out.println("Convertendo de kg->lb");
			m2.setMassa(m1.getMassa() * 2.2064);
			m2.setUnidadeDeMassa("lb");

		} else if (m1.getUnidadeDeMassa().equals("lb")) {
			System.out.println("Convertendo de lb->kg");
			m2.setMassa(m1.getMassa() / 2.2064);
			m2.setUnidadeDeMassa("kg");

		}
		System.out.println("Resultado:" + m2.getMassa() + m2.getUnidadeDeMassa());
	}

	public static void converterTemperatura(Medidas m1, Medidas m2) {

		if (m1.getUnidadeDeTemperatura().equals(m2.getUnidadeDeTemperatura())) {
			System.out.println("Não é possível realizar a conversão, os objetos tem a mesma unidade de temperatura");
			return;
		}

		if (m1.getUnidadeDeTemperatura().equals("c")) {
			System.out.println("Convertendo de c->f");
			m2.setTemperatura((m1.getTemperatura() *1.8) + 32);
			m2.setUnidadeDeTemperatura("f");

		} else if (m1.getUnidadeDeMassa().equals("f")) {
			System.out.println("Convertendo de f->c");
			m2.setTemperatura((m1.getTemperatura() -32) * 5/9);
			m2.setUnidadeDeTemperatura("c");

		}
		System.out.println("Resultado:" + m2.getTemperatura() + m2.getUnidadeDeTemperatura());

	}

	public static void converterDistancia(Medidas m1, Medidas m2) {
		
		if (m1.getUnidadeDeDistancia().equals(m2.getUnidadeDeDistancia())) {
			System.out.println("Não é possível realizar a conversão, os objetos tem a mesma unidade de distancia");
			return;
		}

		if (m1.getUnidadeDeDistancia().equals("km")) {
			System.out.println("Convertendo de km->mi");
			m2.setDistancia(m1.getDistancia() / 1.609);
			m2.setUnidadeDeDistancia("mi");

		} else if (m1.getUnidadeDeMassa().equalsIgnoreCase("mi")) {
			System.out.println("Convertendo de mi->km");
			m2.setDistancia(m1.getDistancia() * 1.609);
			m2.setUnidadeDeDistancia("km");

		}
		System.out.println("Resultado:" + m2.getDistancia() + m2.getUnidadeDeDistancia());

	}

	static List<Medidas> obj = new ArrayList<>();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String unidMassa, unidTemp, unidDist;
		double RealDist = 0, RealMassa = 0, RealTemp = 0;

		int opc = 0;

		while (opc == 0) {
			System.out.println("Menu Conversor de medidas");
			System.out.println("1 - para cadastrar um novo objeto");
			System.out.println("2 - para imprimir os objetos cadastrados");
			System.out.println("3 - para converter a massa dos objetos");
			System.out.println("4 - para converter a temperatura dos objetos");
			System.out.println("5 - para converter a distância dos objetos");
			System.out.println("6 - para sair da aplicação");

			opc = scan.nextInt();

			switch (opc) {
			case 1:
				System.out.println("1 - Cadastrando um novo objeto...");
				scan.nextLine();
				System.out.println("Digite a unidade de distancia em km ou mi");
				unidDist = scan.nextLine().toLowerCase();
				if (unidDist.equals("km") || unidDist.equals("mi")) {
					System.out.println("Digite o valor da medida");
					RealDist = scan.nextDouble();

				} else {
					System.out.println("Unidade de medida inválida, favor digitar novamente");
					main(args);
				}
				scan.nextLine();
				System.out.println("Digite a unidade de massa em kg ou lb");
				unidMassa = scan.nextLine().toLowerCase();

				if (unidMassa.equals("kg") || unidMassa.equals("lb")) {
					System.out.println("Digite o valor da massa");
					RealMassa = scan.nextDouble();
				} else {
					System.out.println("Unidade de massa inválida, favor digitar novamente");
					main(args);
				}
				scan.nextLine();
				System.out.println("Digite a unidade de temperatura em c ou f");
				unidTemp = scan.nextLine().toLowerCase();

				if (unidTemp.equals("c") || unidTemp.equals("f")) {

					System.out.println("Digite o valor da temperatura");
					RealTemp = scan.nextDouble();
				} else {
					System.out.println("Unidade de temperatura inválida, favor digitar novamente");
					main(args);
				}

				Medidas m = new Medidas(unidDist, RealDist, unidMassa, RealMassa, unidTemp, RealTemp);
				obj.add(m);

				main(args);

			case 2:
				System.out.println("2 - Imprimindo todos os objetos...");
				for (Medidas objetos : obj) {
					System.out.println(objetos);
				}

				main(args);
			case 3:
				System.out.println("Convertendo a massa...");
				System.out.println("Digite o index do objeto  que se deseja converter");
				int ind1 = scan.nextInt();
				System.out.println("Digite o index do objeto que irá receber a conversão");
				int ind2 = scan.nextInt();
				
				converterMassa(obj.get(ind1), obj.get(ind2));
				

				main(args);
				;
			case 4:
				System.out.println("Convertendo a temperatura...");
				
				System.out.println("Digite o index do objeto  que se deseja converter");
				int ind3 = scan.nextInt();
				System.out.println("Digite o index do objeto que irá receber a conversão");
				int ind4 = scan.nextInt();
				
				converterTemperatura(obj.get(ind3), obj.get(ind4));
				
				main(args);
				
			case 5:
				System.out.println("Convertendo a distância...");
				
				System.out.println("Digite o index do objeto  que se deseja converter");
				int ind5 = scan.nextInt();
				System.out.println("Digite o index do objeto que irá receber a conversão");
				int ind6 = scan.nextInt();
				
				converterDistancia(obj.get(ind5), obj.get(ind6));
				
				main(args);
			case 6:
				System.out.println("Aplicação encerrada");
				System.exit(0);
				break;

			}
		}
		scan.close();
	}
}
