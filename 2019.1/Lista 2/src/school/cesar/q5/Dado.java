package school.cesar.q5;

import java.util.Random;

public class Dado {

	private int lado;
	

//	public Dado() {
//		Random random = new Random();
//		this.lado = random.nextInt(7);
//	}

	public int getLado() {
		Random random = new Random();
		this.lado = (random.nextInt(6) + 1);
		return lado;
	}

}
