package school.cesar.q4.domain;

public class Data implements Comparable<DiasSemana> {

	private int dia;
	private int mes;
	private int ano;
	private DiasSemana diasSemana;

	//construtor
	public Data(int dia, int mes, int ano, DiasSemana diasSemana) {

		if (mes >= 1 && mes <= 12) {
			if (mes == 1 && mes == 3 && mes == 5 && mes == 7 && mes == 8 && mes == 10 && mes == 12) {
				if (dia < 1) {
					this.dia = 1;
				} else if (dia >= 1 && dia <= 31) {
					this.dia = dia;
				} else {
					this.dia = 31;
				}
			} else if (mes == 2) {
				if (dia < 1) {
					this.dia = 1;
				} else if (dia >= 1 && dia <= 29) {
					this.dia = dia;
				} else {
					this.dia = 29;
				}
			} else {
				if (dia < 1) {
					this.dia = 1;
				} else if (dia >= 1 && dia <= 30) {
					this.dia = dia;
				} else {
					this.dia = 30;
				}
			}

			this.mes = mes;
		} else if (mes < 1) {
			if (dia < 1) {
				this.dia = 1;
			} else if (dia >= 1 && dia <= 31) {
				this.dia = dia;
			} else {
				this.dia = 31;

			}
			this.mes = 1;
		} else if (mes >= 13) {

			if (dia < 1) {
				this.dia = 1;
			} else if (dia >= 1 && dia <= 31) {
				this.dia = dia;
			} else {
				this.dia = 31;

			}

			this.mes = 12;
		}

		this.ano = ano;

		this.diasSemana = diasSemana;
	}

	@Override
	public int compareTo(DiasSemana o) {

		// dia da semana da data versus o dia da semana que estou passando
		if (this.diasSemana.getValor() < o.getValor()) {
			return -1;
		} else if (this.diasSemana.getValor() > o.getValor()) {
			return 1;
		} else {
			return 0;
		}
	}
//compara a data passada com outra
	public String comparaDatas(Data date) {

		if (this.ano == date.ano && this.mes == date.mes && this.dia == date.dia) {
			return "As datas são iguais";
		}
		// se o ano atual é maior que o ano passado..
		if (this.ano > date.ano) {
			return "Data atual é maior";
		} else if (this.ano < date.ano) {
			return "Data atual é menor";

		} else if (this.ano == date.ano) {
			if (this.mes > date.mes) {
				return "Data atual é maior";
			} else if (this.mes < date.mes) {
				return "Data atual é menor";
			} else if (this.mes == date.mes) {
				if (this.dia > date.dia) {
					return "Data atual é maior";
				} else {
					return "Data atual é menor";
				}
			}
		}
		return "Data atual é menor";

	}

//compara dias da semana
	public String comparaDatas(DiasSemana dt2) {

		if (this.diasSemana.compareTo(dt2) == 0) {
			return "As datas são as mesmas";
		} else if (this.diasSemana.compareTo(dt2) < 0) {
			return "A data atual tem o dia da semana antes do dia da semana da variável";
		} else {
			return "A data atual tem o dia da semana depois do dia da semana da variável";
		}

	}

	public static void main(String[] args) {

		Data data = new Data(1, 10, 2019, DiasSemana.DOMINGO);
		System.out.println(data);

		Data data2 = new Data(-1, 15, 2018, DiasSemana.SEGUNDA);
		System.out.println(data2);

		Data data3 = new Data(25, 4, 2019, DiasSemana.QUINTA);

		System.out.println(data.comparaDatas(data3));
		System.out.println(data3.comparaDatas(data));
		System.out.println(data2.comparaDatas(data3));
		System.out.println(data3.comparaDatas(data2));
		System.out.println();

		// quinta vem depois de segunda
		System.out.println(data3.comparaDatas(DiasSemana.SEGUNDA));
		// domingo vem antes de segunda
		System.out.println(data.comparaDatas(DiasSemana.SEGUNDA));
	}

	@Override
	public String toString() {
		return "Data: [" + dia + "/" + mes + "/" + ano + " -  Dia da semana= " + diasSemana + "]";
	}

}
