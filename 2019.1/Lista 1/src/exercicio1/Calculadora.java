package exercicio1;

import java.util.Scanner;

public class Calculadora {

	public static double somar(double n1, double n2) {
		return n1 + n2;
	}

	public static double subtrair(double n1, double n2) {
		return n1 - n2;
	}

	public static double multiplicar(double n1, double n2) {
		return n1 * n2;
	}

	public static double dividir(double n1, double n2) {
		return n1 / n2;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char opc = '5';

		while (opc <= '5') {
			System.out.println("*******Calculadora*******+\n");
			System.out.println("Insira o caracter da operação a se realizar:");
			System.out.println("+ - Para somar");
			System.out.println("/ - Para dividir");
			System.out.println("- - Para subtrair");
			System.out.println("* - Para multiplicar");
			System.out.println("5 - Para sair");

			opc = scan.next().charAt(0);
			
			if (opc == '+' || opc == '/' || opc == '-' || opc == '*') {

				System.out.println("Entre com o primeiro número:");
				double n1 = scan.nextDouble();
				System.out.println("Entre com o segundo número:");
				double n2 = scan.nextDouble();

				switch (opc) {
				case '+':
					System.out.println("O resultado da soma é: " + somar(n1, n2) + "\n");
					break;
				case '/':
					System.out.println("O resultado da divisão é: " + dividir(n1, n2) + "\n");
					break;
				case '-':
					System.out.println("O resultado da subtração é: " + subtrair(n1, n2) + "\n");
					break;
				case '*':
					System.out.println("O resultado da multiplicação é: " + multiplicar(n1, n2) + "\n");
					break;
				}
			} else if (opc == '5') {
				System.out.println("Programa encerrado.");
				System.exit(0);
			} else {
				System.out.println("Opção inválida, digite um opção válida \n");
				main(args);
			}

		}
		scan.close();
	}

}
