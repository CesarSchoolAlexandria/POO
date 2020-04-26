package school.cesar.q2;

import java.util.Scanner;

public class EquacaoSegundoGrau {

	private double a;
	private double b;
	private double c;
	private double x1;
	private double x2;

	public EquacaoSegundoGrau(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;

	}

	public double[] getRaizes(double a, double b, double c) {

		double[] result = new double[2];
		double delta;

		delta = ((b * b) - 4 * a * c);

		if (delta < 0) {

			result[0] = 0;
			return result;
		} else if (delta == 0) {
			x1 = (-b) / (2 * a);
			result[0] = x1;
			return result;

		} else {
			x1 = (-b + Math.sqrt(delta)) / 2 * a;
			x2 = (-b - Math.sqrt(delta)) / 2 * a;

			result[0] = x1;
			result[1] = x2;
			return result;
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(a);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(b);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(c);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x2);
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
		EquacaoSegundoGrau other = (EquacaoSegundoGrau) obj;
		if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
			return false;
		if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
			return false;
		if (Double.doubleToLongBits(c) != Double.doubleToLongBits(other.c))
			return false;
		if (Double.doubleToLongBits(x1) != Double.doubleToLongBits(other.x1))
			return false;
		if (Double.doubleToLongBits(x2) != Double.doubleToLongBits(other.x2))
			return false;
		return true;
	}

	@Override
	public String toString() {

		StringBuilder s = new StringBuilder();
		double[] resultado = new double[2];
		s.append(a + "x^2 " + b + "x " + c);
		s.append("\n");
		double delta = ((b * b) - 4 * a * c);
		if (delta < 0) {
			s.append("A equação não possui raízes reais");
		} else if (delta == 0) {
			s.append("A equação possui uma única raíz real: " );
			resultado = getRaizes(a, b, c);
			s.append(resultado[0]);
		} else {
			s.append("A equação possui 2 raízes reais: \n");
			resultado = getRaizes(a,b,c);
			s.append("Raíz 1: " + resultado[0] + "; ");
			s.append("Raíz 2: " + resultado[1]);
		}

		return s.toString();
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Digite um valor para a");
		double a = scan.nextDouble();
		System.out.println("Digite um valor para b");
		double b = scan.nextDouble();
		System.out.println("Digite um valor para c");
		double c = scan.nextDouble();

		EquacaoSegundoGrau eq = new EquacaoSegundoGrau(a, b, c);
		System.out.println();
		System.out.println(eq.toString());

		scan.close();
	}

}
