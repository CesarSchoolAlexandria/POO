package school.cesar.q2;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Scanner;

public class ConversorMorse {
	static String[] portugues = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", " ", " "
	};
	
    static String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "-----", ".----", "..---", "...--", "....-",
            ".....", "-....", "--...", "---..", "----.", " ", ""};
    
    
	public static void converterPortugues(String p) {
    	try {
    		for(int i = 0; i < p.length(); i++) {
    			if(Arrays.stream(portugues).anyMatch(Character.toString(p.charAt(i)).toUpperCase() :: equals) == false) {
    				throw new InvalidParameterException("A string contem caracteres diferentes do padrão!");
    			}
    		}
    	}catch(InvalidParameterException e) {
    		System.out.println("InvalidParameterException foi jogada: ");
    		System.out.println(e);
    		System.exit(1);
    	}
    	
    	String resposta = new String();
    	int index;
    	
    	for(int i = 0; i < p.length(); i++) {
    		index = Arrays.asList(portugues).indexOf(Character.toString(p.charAt(i)).toUpperCase());
    		resposta += Arrays.asList(morse).get(index);
    		if(i != p.length()-1) resposta += " ";
    	}
    	System.out.println(resposta);
    }
    
	public static void converterMorse(String m) {
    	try {
    		int counter = 0;
    		for(int i = 0; i < m.length();i++) {
    			if(Character.toString(m.charAt(i)).equals(" ")) {
    				counter += 1;
    			}else {
    				if(counter == 2 || counter > 3) {
    					throw new InvalidParameterException("A string contem caracteres diferentes do padrão!");
    				}
    				counter = 0;
    			}
    		}
    		
    		String[] temp = m.split("\\s{1,2}");
    		
    		for(int i = 0; i < temp.length; i++) {
    			if(Arrays.stream(morse).anyMatch(temp[i] :: equals) == false) {
    				throw new InvalidParameterException("A string contem caracteres diferentes do padrão!");
    			}
    		}
    	}catch(InvalidParameterException e) {
    		System.out.println("InvalidParameterException foi jogada: ");
    		System.out.println(e);
    		System.exit(1);
    	}
    	
    	String resposta = new String();
    	String[] temp = m.split("\\s{1,2}");
    	int index;
    	
    	for(int i = 0; i < temp.length; i++) {
    		index = Arrays.asList(morse).indexOf(temp[i]);
    		resposta += Arrays.asList(portugues).get(index);
    	}
    	
    	System.out.println(resposta);
	}
	
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("Digite a frase para converter: ");
		
		String palavra = scan.nextLine();
		
		converterPortugues(palavra);
		
		
		System.out.println("Digite o código morse para converter: ");
		String codigo = scan.nextLine();
		
		converterMorse(codigo);
		
		scan.close();
    }
}
