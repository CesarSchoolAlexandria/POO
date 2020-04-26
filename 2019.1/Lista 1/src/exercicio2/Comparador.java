package exercicio2;

import java.util.Scanner;

public class Comparador {

	private static int n1;
	private static int n2;
	private static int n3;

	public static int getN1() {
		return n1;
	}

	public static void setN1(int n1) {
		Comparador.n1 = n1;
	}

	public static int getN2() {
		return n2;
	}

	public static void setN2(int n2) {
		Comparador.n2 = n2;
	}

	public static int getN3() {
		return n3;
	}

	public static void setN3(int n3) {
		Comparador.n3 = n3;
	}

	public static int getMaior(int n1, int n2, int n3) {
						
		int maior = 0;
		if (n1 > n2) {
			maior = n1;
		} else {
			maior = n2;
		} 
		if (n3 > maior) {
			maior = n3;
		}
		return maior;
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*********Comparador**********\n");
		System.out.println("Digite o primeiro número:");
		setN1(scan.nextInt());
		System.out.println("Digite o segundo número:");
		setN2(scan.nextInt());
		System.out.println("Digite o terceiro número:");
		setN3(scan.nextInt());
		
		System.out.println("O maior número é: "+getMaior(getN1(), getN2(), getN3()));

		scan.close();
	}

}
