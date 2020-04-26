package exercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComparadorDeStrings {

	public static boolean ComparaStringsBollean(String p1, String p2) {
		StringBuilder sb = new StringBuilder(p1);
		sb.reverse();
		String p3 = sb.toString();
		if (p2.compareTo(p3) == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a primeira String:");
		String p1 = scan.next();
		System.out.println("Digite a segunda String:");
		String p2 = scan.next();

		System.out.println();
		System.out.println(ComparaStringsBollean(p1, p2));
		// System.out.println(ComparaStringsBollean("ana", "ama"));
		scan.close();
	}

}
