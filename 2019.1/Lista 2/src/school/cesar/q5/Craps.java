package school.cesar.q5;

public class Craps {

	private Dado dado1;
	private Dado dado2;

	public Craps(Dado dado1, Dado dado2) {
		this.dado1 = dado1;
		this.dado2 = dado2;

	}

	public Craps() {
		super();
	}

	public int jogada() {

		int a = dado1.getLado();
		int b = dado2.getLado();

		return a + b;

	}

	public void resultJogada() {
		int soma = 0;

		int resultado = jogada();
		System.out.println("A pontuação da primeira jogada foi de: " + resultado);
		if (resultado == 7 || resultado == 11) {
			System.out.println("Você venceu!");
			return;
		} else if (resultado == 2 || resultado == 3 || resultado == 12) {
			System.out.println("Você perdeu tudo!");
			return;
		} else {
			System.out.println("A pontuação da primeira jogada foi de " + resultado
					+ ", para ganhar é necessário repetir essa pontuação..");
			while (soma != resultado) {
				soma = jogada();
				System.out.println("A pontuação da jogada foi de: " + soma);
				if (soma == 7) {
					System.out.println("Você perdeu tudo!");
					return;
				} else if (soma != resultado) {
					System.out.println("Realizando uma nova jogada!");
				}
			}
			System.out.println("Você venceu!");
		}

	}

	public static void main(String[] args) {
		Dado d1 = new Dado();
		Dado d2 = new Dado();

		Craps crap = new Craps(d1, d2);

		for (int i = 1; i <= 30; i++) {
			System.out.println("Jogando Partida " + i);
			crap.resultJogada();
		}
	}

}
