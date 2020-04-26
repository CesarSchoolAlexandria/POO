package school.cesar.q1.utils;

import java.util.Scanner;

import school.cesar.q1.domain.Matriz;

public class Matrizes {

	public static Matriz multiplicar(Matriz m1, Matriz m2) {

		if (m1.getColunas() != m2.getLinhas()) {
			System.out.println("Multiplicação não pode ser feita");
			return null;
		} else {
			Matriz resultado = new Matriz(m1.getLinhas(), m2.getColunas());

			for (int a = 0; a < resultado.matriz.length; a++) {
				for (int b = 0; b < resultado.matriz[0].length; b++) {
					resultado.matriz[a][b] = 0;
				}
			}

			for (int i = 0; i < m1.getLinhas(); i++) {
				System.out.println("");
				for (int j = 0; j < m2.getColunas(); j++) {
					for (int k = 0; k < m1.getLinhas(); k++) {
						resultado.matriz[i][j] += m1.matriz[i][k] * m2.matriz[k][j];
					}
					System.out.print(resultado.matriz[i][j]);
					System.out.print(" ");
				}
			}

			System.out.println();
			System.out.println();
			return resultado;
		}
	}
	
	@Override
	public String toString() {
		return "Matrizes [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int linhas, colunas;

		System.out.println("Criando a primeira matriz para a operação: ");

		System.out.println("Digite o número de linhas da matriz");
		linhas = scan.nextInt();
		System.out.println("Digite o número de colunas da matriz");
		colunas = scan.nextInt();
		Matriz matriz = new Matriz(linhas, colunas);

		System.out.println("Criando a segunda matriz para a operação: ");

		System.out.println("Digite o número de linhas da matriz 2");
		linhas = scan.nextInt();
		System.out.println("Digite o número de colunas da matriz 2");
		colunas = scan.nextInt();
		Matriz matriz2 = new Matriz(linhas, colunas);

		
		
		System.out.println(multiplicar(matriz, matriz2).matriz[0][0]);
		
		scan.close();

	}

}
