package school.cesar.q1.domain;

import java.util.Random;
import java.util.Scanner;

public class Matriz {

	public int[][] matriz;

	// construtor para matriz quadrada
	public Matriz(int linhas) {
		
		this.matriz = new int[linhas][linhas];
		Random random = new Random();
		System.out.println("Criando a matriz...");
		for (int i = 0; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz[i].length; j++) {
				System.out.print((this.matriz[i][j] = (random.nextInt(101))) + " ");
			}
			System.out.println();
		}
	}

	// construtor para matriz irregular
	public Matriz(int linhas, int colunas) {
		this.matriz = new int[linhas][colunas];

		Random random = new Random();
		System.out.println("Criando a matriz...");
		for (int i = 0; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz[i].length; j++) {
				System.out.print((this.matriz[i][j] = (random.nextInt(101))) + " ");
			}
			System.out.println();
		}
	}
	
	
	public int getLinhas() {
		return matriz.length;
	}

	public int getColunas() {
		return matriz[0].length;
	}


	public void getDiagonal(Matriz matriz) {

		int[] diagonal = new int[this.matriz.length];

		System.out.println("Imprimindo a diagonal...");
		for (int i = 0; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz[i].length; j++) {
				if (i == j) {
					diagonal[i] = this.matriz[i][j];
				}
			}
		}
		for (int i = 0; i < diagonal.length; i++) {
			System.out.print(diagonal[i] + " ");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int opc = 0;
		int linhas, colunas;

		while (opc != 3) {

			System.out.println("**** Menu Matriz ****");
			System.out.println("1 - Para criar uma matriz quadrada");
			System.out.println("2 - Para criar uma matriz retangular");
			System.out.println("3 - Para sair");

			opc = scan.nextInt();

			switch (opc) {
			case 1:
				System.out.println("Digite a ordem da matriz");
				linhas = scan.nextInt();

				Matriz matriz = new Matriz(linhas);

				System.out.println();
				matriz.getDiagonal(matriz);

				break;
			case 2:
				System.out.println("Digite o número de linhas da matriz");
				linhas = scan.nextInt();
				System.out.println("Digite o número de colunas da matriz");
				colunas = scan.nextInt();

				Matriz matriz2 = new Matriz(linhas, colunas);

				matriz2.getDiagonal(matriz2);

				break;
			case 3:
				System.out.println("Programa encerrado");
				System.exit(0);

			}
		}

		scan.close();
	}

}
