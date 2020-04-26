package metodoMain;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hospedagem.Albergues;
import hospedagem.AluguelCasaApt;
import hospedagem.Hoteis;
import hospedagem.Pousadas;
import veiculos.TipoVeiculo;
import veiculos.Veiculo;

public class ClassePrincipal {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);

		System.out.println("***Bem-vindo a Empresa de viagens!\n" + "Escolha o tipo de serviço que deseja:");


		int opc = 3;

		do {
			System.out.println("Digite 1 para aluguel de veículos ou 2 para aluguel de hospedagem");
			opc = scan.nextInt();

		} while (opc < 1 || opc > 2);

		// veículos
		if (opc == 1) {
			System.out.println("Opção selecionada: Veículos");

			int tipo = 8;
			do {
				System.out.println(
						"Informe qual o tipo de veículo que deseja alugar 1-BASICO; 2- COMUM; 3- EXECUTIVO; 4-LUXO:");
				tipo = scan.nextInt();

			} while (tipo < 1 || tipo > 4);
			
			try{
				int opc1;
				do {
					System.out.println("Digite 1 para ordenar essa lista por ano e 2 para ordenar por preço de diária");
					opc1 = scan.nextInt();
				} while (opc1 < 1 || opc1 > 2);
				
				while(true) {
					if (opc1 == 1) {
						if(Veiculo.listarVeiculos(TipoVeiculo.fromId(tipo)).size() == 0) {
							throw new IllegalStateException("Não Existem Veículos desse Tipo disponíveis");
						}
								
						List<Veiculo> veiculos = Veiculo.listarVeiculos(TipoVeiculo.fromId(tipo));
								
						Collections.sort(veiculos, Veiculo.comparaPorAno);
						
						System.out.println(veiculos);
						
						System.out.println("Deseja alugar que veículo? Digite o número corresponde a posição do mesmo na lista");
						
		                int opc2 = scan.nextInt();
		                
		                System.out.println(Veiculo.listarVeiculos(TipoVeiculo.fromId(tipo)).get(opc2).toString());
					} else {
						if(Veiculo.listarVeiculos(TipoVeiculo.fromId(tipo)).size() == 0) {
							throw new IllegalStateException("Não Existem Veículos desse Tipo disponíveis");
						}
						
						List<Veiculo> veiculos = Veiculo.listarVeiculos(TipoVeiculo.fromId(tipo));
						
						Collections.sort(veiculos, Veiculo.comparaDiaria);
						
						System.out.println(veiculos);
						
						System.out.println("Deseja alugar que veículo? Digite o número corresponde a posição do mesmo na lista");
						
		                int opc2 = scan.nextInt();
		                
		                System.out.println("Veiculo Selecionado:");
		                
		                System.out.println(Veiculo.listarVeiculos(TipoVeiculo.fromId(tipo)).get(opc2).toString());
					}
					
					System.out.println("Digite 1 para reservar o veículo ou qualquer outra coisa para voltar para a lista");
					
					int opc3 = scan.nextInt();
					
					if(opc3==1) {
						System.out.println("Veículo Alugado, Obrigado por usar o sistema.");
						break;
					}
				}
			}catch(IllegalStateException e) {
				System.out.println(e);
			}
		
		//Hospedagem
		} else {
			System.out.println("Opção selecionada: Hospedagem");

			int tipo = 8;
			do {
				System.out.println(
						"Informe qual o tipo de hospedagem que deseja alugar 1- Albergues; 2- Aluguel de casa ou apartamento"
						+ "; 3- Hoteis; 4- Pousadas:");
				tipo = scan.nextInt();

			} while (tipo < 1 || tipo > 4);
			
			
			if(tipo==1) {
				try {
					List<Albergues> albergues = Albergues.cadastrarAlbergues();
					if(albergues.size() == 0) {
						throw new IllegalStateException("Não Existe Hospedagem desse Tipo disponível");
					}
					
					while(true) {
						System.out.println(Albergues.listarHospedagem());
						System.out.println("Se desejar filtrar a lista por valor da diária digite -1");
						System.out.println("Se desejar alugar alguma hospedagem digite o número corresponde a posição do mesmo na lista");
						
						int opc2 = scan.nextInt();
						if(opc2 == -1) {
							while(true) {
								List<Albergues> sorted = Albergues.listarHospedagem();
								Collections.sort(sorted, Albergues.comparaDiaria);
								System.out.println(sorted);
								System.out.println("Se desejar remover o filtro digite -1");
								System.out.println("Se desejar alugar alguma hospedagem digite o número corresponde a posição do mesmo na lista");
								int opc3 = scan.nextInt();
								if(opc3 == -1) {
									System.out.println("Removendo o filtro");
									break;
								}else {
									System.out.println("Hospedagem Selecionada:");
						                
						            System.out.println(Albergues.listarHospedagem().get(opc3).toString());
						            System.out.println("Digite 1 para reservar o veículo ou qualquer outra coisa para voltar para a lista");
										
									int opc4 = scan.nextInt();
									
									if(opc4==1) {
										System.out.println("Hospedagem Alugada, Obrigado por usar o sistema.");
										return;
									}
								}	
							}
						}else {
							System.out.println("Hospedagem Selecionada:");
			                
				            System.out.println(Albergues.listarHospedagem().get(opc2).toString());
				            System.out.println("Digite 1 para reservar o veículo ou qualquer outra coisa para voltar para a lista");
								
							int opc4 = scan.nextInt();
							
							if(opc4==1) {
								System.out.println("Hospedagem Alugada, Obrigado por usar o sistema.");
								return;
							}
						}
					}					
				}catch(IllegalStateException e) {
					System.out.println(e);
				}
				
			}else if(tipo==2) {
				try {
					List<AluguelCasaApt> casaApt = AluguelCasaApt.cadastrarCasaApt();
					if(casaApt.size() == 0) {
						throw new IllegalStateException("Não Existe Hospedagem desse Tipo disponível");
					}
					

					while(true) {
						System.out.println(AluguelCasaApt.listarHospedagem());
						System.out.println("Se desejar filtrar a lista por valor da diária digite -1"
								+ " ou se desejar filtrar por numero de quartos digite -2");
						System.out.println("Se desejar alugar alguma hospedagem digite o número corresponde a posição do mesmo na lista");
						
						int opc2 = scan.nextInt();
						if(opc2 == -1) {
							while(true) {
								List<AluguelCasaApt> sorted = AluguelCasaApt.listarHospedagem();
								Collections.sort(sorted, AluguelCasaApt.comparaDiaria);
								System.out.println(sorted);
								System.out.println("Se desejar remover o filtro digite -1");
								System.out.println("Se desejar alugar alguma hospedagem digite o número corresponde a posição do mesmo na lista");
								int opc3 = scan.nextInt();
								if(opc3 == -1) {
									System.out.println("Removendo o filtro");
									break;
								}else {
									System.out.println("Hospedagem Selecionada:");
						                
						            System.out.println(AluguelCasaApt.listarHospedagem().get(opc3).toString());
						            System.out.println("Digite 1 para reservar o veículo ou qualquer outra coisa para voltar para a lista");
										
									int opc4 = scan.nextInt();
									
									if(opc4==1) {
										System.out.println("Hospedagem Alugada, Obrigado por usar o sistema.");
										return;
									}
								}	
							}
						}else if(opc2 == -2) {
							while(true) {
								List<AluguelCasaApt> sorted = AluguelCasaApt.listarHospedagem();
								Collections.sort(sorted, AluguelCasaApt.comparaQuartos);
								System.out.println(sorted);
								System.out.println("Se desejar remover o filtro digite -1");
								System.out.println("Se desejar alugar alguma hospedagem digite o número corresponde a posição do mesmo na lista");
								int opc3 = scan.nextInt();
								if(opc3 == -1) {
									System.out.println("Removendo o filtro");
									break;
								}else {
									System.out.println("Hospedagem Selecionada:");
						                
						            System.out.println(AluguelCasaApt.listarHospedagem().get(opc3).toString());
						            System.out.println("Digite 1 para reservar o veículo ou qualquer outra coisa para voltar para a lista");
										
									int opc4 = scan.nextInt();
									
									if(opc4==1) {
										System.out.println("Hospedagem Alugada, Obrigado por usar o sistema.");
										return;
									}
								}	
							}
							
						}else {
							System.out.println("Hospedagem Selecionada:");
			                
				            System.out.println(AluguelCasaApt.listarHospedagem().get(opc2).toString());
				            System.out.println("Digite 1 para reservar o veículo ou qualquer outra coisa para voltar para a lista");
								
							int opc4 = scan.nextInt();
							
							if(opc4==1) {
								System.out.println("Hospedagem Alugada, Obrigado por usar o sistema.");
								return;
							}
						}
					}	
					
					
					
					
				}catch(IllegalStateException e) {
					System.out.println(e);
				}
			}else if(tipo == 3) {
				try {
					List<Hoteis> hoteis = Hoteis.cadastrarHoteis();
					if(hoteis.size() == 0) {
						throw new IllegalStateException("Não Existe Hospedagem desse Tipo disponível");
					}
					while(true) {
						System.out.println(Hoteis.listarHospedagem());
						System.out.println("Se desejar filtrar a lista por valor da diária digite -1"
								+ " ou se desejar filtrar por numero de quartos digite -2");
						System.out.println("Se desejar alugar alguma hospedagem digite o número corresponde a posição do mesmo na lista");
						
						int opc2 = scan.nextInt();
						if(opc2 == -1) {
							while(true) {
								List<Hoteis> sorted = Hoteis.listarHospedagem();
								Collections.sort(sorted, Hoteis.comparaDiaria);
								System.out.println(sorted);
								System.out.println("Se desejar remover o filtro digite -1");
								System.out.println("Se desejar alugar alguma hospedagem digite o número corresponde a posição do mesmo na lista");
								int opc3 = scan.nextInt();
								if(opc3 == -1) {
									System.out.println("Removendo o filtro");
									break;
								}else {
									System.out.println("Hospedagem Selecionada:");
						                
						            System.out.println(Hoteis.listarHospedagem().get(opc3).toString());
						            System.out.println("Digite 1 para reservar o veículo ou qualquer outra coisa para voltar para a lista");
										
									int opc4 = scan.nextInt();
									
									if(opc4==1) {
										System.out.println("Hospedagem Alugada, Obrigado por usar o sistema.");
										return;
									}
								}	
							}
						}else if(opc2 == -2) {
							while(true) {
								List<Hoteis> sorted = Hoteis.listarHospedagem();
								Collections.sort(sorted, Hoteis.comparaEstrelas);
								System.out.println(sorted);
								System.out.println("Se desejar remover o filtro digite -1");
								System.out.println("Se desejar alugar alguma hospedagem digite o número corresponde a posição do mesmo na lista");
								int opc3 = scan.nextInt();
								if(opc3 == -1) {
									System.out.println("Removendo o filtro");
									break;
								}else {
									System.out.println("Hospedagem Selecionada:");
						                
						            System.out.println(Hoteis.listarHospedagem().get(opc3).toString());
						            System.out.println("Digite 1 para reservar o veículo ou qualquer outra coisa para voltar para a lista");
										
									int opc4 = scan.nextInt();
									
									if(opc4==1) {
										System.out.println("Hospedagem Alugada, Obrigado por usar o sistema.");
										return;
									}
								}	
							}
						}else {
							System.out.println("Hospedagem Selecionada:");
			                
				            System.out.println(Hoteis.listarHospedagem().get(opc2).toString());
				            System.out.println("Digite 1 para reservar o veículo ou qualquer outra coisa para voltar para a lista");
								
							int opc4 = scan.nextInt();
							
							if(opc4==1) {
								System.out.println("Hospedagem Alugada, Obrigado por usar o sistema.");
								return;
							}
						}
					}
					
				}catch(IllegalStateException e) {
					System.out.println(e);
				}
			}else {
				try {
					List<Pousadas> pousadas = Pousadas.cadastrarPousadas();
					if(pousadas.size() == 0) {
						throw new IllegalStateException("Não Existe Hospedagem desse Tipo disponível");
					}
					while(true) {
						System.out.println(Pousadas.listarHospedagem());
						System.out.println("Se desejar filtrar a lista por valor da diária digite -1");
						System.out.println("Se desejar alugar alguma hospedagem digite o número corresponde a posição do mesmo na lista");
						
						int opc2 = scan.nextInt();
						if(opc2 == -1) {
							while(true) {
								List<Pousadas> sorted = Pousadas.listarHospedagem();
								Collections.sort(sorted, Pousadas.comparaDiaria);
								System.out.println(sorted);
								System.out.println("Se desejar remover o filtro digite -1");
								System.out.println("Se desejar alugar alguma hospedagem digite o número corresponde a posição do mesmo na lista");
								int opc3 = scan.nextInt();
								if(opc3 == -1) {
									System.out.println("Removendo o filtro");
									break;
								}else {
									System.out.println("Hospedagem Selecionada:");
						                
						            System.out.println(Pousadas.listarHospedagem().get(opc3).toString());
						            System.out.println("Digite 1 para reservar o veículo ou qualquer outra coisa para voltar para a lista");
										
									int opc4 = scan.nextInt();
									
									if(opc4==1) {
										System.out.println("Hospedagem Alugada, Obrigado por usar o sistema.");
										return;
									}
								}	
							}
						}else {
							System.out.println("Hospedagem Selecionada:");
			                
				            System.out.println(Pousadas.listarHospedagem().get(opc2).toString());
				            System.out.println("Digite 1 para reservar o veículo ou qualquer outra coisa para voltar para a lista");
								
							int opc4 = scan.nextInt();
							
							if(opc4==1) {
								System.out.println("Hospedagem Alugada, Obrigado por usar o sistema.");
								return;
							}
						}
					}	
				}catch(IllegalStateException e) {
					System.out.println(e);
				}
			}
		}

		scan.close();
	}

}
