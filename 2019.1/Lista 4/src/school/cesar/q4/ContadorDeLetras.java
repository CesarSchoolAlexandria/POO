package school.cesar.q4;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContadorDeLetras {
	
	static String[] padrao = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", " "};
	
	public static void contar(String parametro) {
		try {
    		for(int i = 0; i < parametro.length(); i++) {
    			if(Arrays.stream(padrao).anyMatch(Character.toString(parametro.charAt(i)).toUpperCase() :: equals) == false) {
    				throw new InvalidParameterException("A string contem caracteres diferentes do padrão!");
    			}
    		}
    	}catch(InvalidParameterException e) {
    		System.out.println("InvalidParameterException foi jogada: ");
    		System.out.println(e);
    		System.exit(1);
    	}
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		for (int i = 0; i < parametro.length(); i++) {
		  String c = Character.toString(parametro.charAt(i)).toUpperCase();
		  if (map.containsKey(c)) {
		    int cnt = map.get(c);
		    map.put(c, ++cnt);
		  } else {
		    map.put(c, 1);
		  }
		}
		
		System.out.println(map);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite a frase para contar as ocorrências");
		String frase = scan.nextLine();
		
		contar(frase);
		
		scan.close();
	}
}
