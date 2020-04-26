package school.cesar.q1;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Scanner; 

public class TresLetras {
		
	public static void validate(String p, HashSet<String> resultado) {
		p = p.toLowerCase();
		try {
			if(p.length() != 5){
				throw new InvalidParameterException("A palavra não contém cinco caracteres!");
			}
			
			for(char c : p.toCharArray()) {
				
				if(Character.isLetter(c) == false) {
					throw new InvalidParameterException("A palavra contém caracteres que não são letras!");
				}
			}
		} catch(InvalidParameterException e) {
			System.out.println("InvalidParameterException lançada.");
			System.out.println(e);
			return;
		}

		Permutar("",p.substring(0, 3),resultado);
	}
	
    
    private static void Permutar(String permutation, String input, HashSet<String> resultado)
    {   
        if(input.length() == 0)
        {
            resultado.add(permutation);
        }
        else
        {
            for (int i = 0; i < input.length(); i++)
            {   
                Permutar(permutation+input.charAt(i), input.substring(0, i)+input.substring(i+1, input.length()), resultado);
            }
        }
        
    }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite uma palavra de cinco letras: ");
		
		String palavra = scan.nextLine();
		
		HashSet<String> resultado = new HashSet<String>();
		
		validate(palavra, resultado);
		System.out.println(resultado);
		scan.close();
	}
	
}
