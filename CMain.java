import javax.swing.JOptionPane;
import java.util.Random;

public class CMain {

	static CDicionario moradores = new CDicionario();
	static CFila espera = new CFila();
	static int faixa1 = 0, faixa2 = 0;
	static final int MAX_CADA_FAIXA = 2;
	static final int MAX_LISTA_ESPERA = 2;

	// adiciona o morador no dicionário
	public static void cadastrarMorador() {
		int qtdeDependentes, numeroComplemento;
		String nomeCompleto, bairro, cidade, estado, cep, rua, cpf;
		float rendaFamiliar;
		long telefone;
		boolean faixa = false;
		// verifica se a fila de espera está cheia
		if (espera.quantidade() == MAX_LISTA_ESPERA) {
			JOptionPane.showMessageDialog(null,
					"A fila de espera está cheia. Por favor, espere um sorteio ou desistência de algum morador.");
		}

		nomeCompleto = JOptionPane.showInputDialog(null, "Informe os seguintes dados sobre o morador:\nNome:",
				"Dados do morador", JOptionPane.INFORMATION_MESSAGE);
		rendaFamiliar = Float.parseFloat(JOptionPane.showInputDialog(null, "Renda familiar:", "Dados do morador",
				JOptionPane.INFORMATION_MESSAGE));
		// System.out.println(rendaFamiliar);
		if (rendaFamiliar <= 954) {
			// false quer dizer que o morador é da faixa 1
			faixa = false;
			faixa1++;
		}
		if (rendaFamiliar >= 954 && rendaFamiliar <= 2862) {
			// true quer dizer que o morador é da faixa 2
			faixa = true;
			faixa2++;
		}
		if (rendaFamiliar > 2862) {
			JOptionPane.showMessageDialog(null,
					"Não é possível cadastrar um morador com renda familiar acima de três salários mínimos.");
		}

		cpf = JOptionPane.showInputDialog(null, "CPF:", "Dados do morador", JOptionPane.INFORMATION_MESSAGE);
		qtdeDependentes = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de dependentes:",
				"Dados do morador", JOptionPane.INFORMATION_MESSAGE));
		telefone = Long.parseLong(
				JOptionPane.showInputDialog(null, "Telefone:", "Dados do morador", JOptionPane.INFORMATION_MESSAGE));
		numeroComplemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Número do complemento:",
				"Dados do morador", JOptionPane.INFORMATION_MESSAGE));
		bairro = JOptionPane.showInputDialog(null, "Bairro:", "Dados do morador", JOptionPane.INFORMATION_MESSAGE);
		cidade = JOptionPane.showInputDialog(null, "Cidade:", "Dados do morador", JOptionPane.INFORMATION_MESSAGE);
		estado = JOptionPane.showInputDialog(null, "Estado:", "Dados do morador", JOptionPane.INFORMATION_MESSAGE);
		cep = JOptionPane.showInputDialog(null, "CEP:", "Dados do morador", JOptionPane.INFORMATION_MESSAGE);
		rua = JOptionPane.showInputDialog(null, "Rua:", "Dados do morador", JOptionPane.INFORMATION_MESSAGE);

		if (faixa1 == MAX_CADA_FAIXA + 1 || faixa2 == MAX_CADA_FAIXA + 1) {
			espera.enfileira(new CMorador(nomeCompleto, rendaFamiliar, cpf, qtdeDependentes, cidade, rua,
					numeroComplemento, cep, bairro, estado, telefone, faixa));
			JOptionPane.showMessageDialog(null, "O morador foi adicionado na fila de espera.");
			if (!faixa) {
				faixa1--;
			} else {
				faixa2--;
			}
		} else {
			moradores.adiciona(cpf, new CMorador(nomeCompleto, rendaFamiliar, cpf, qtdeDependentes, cidade, rua,
					numeroComplemento, cep, bairro, estado, telefone, faixa));
		}
	}

	public static void pesquisaMorador() {
		if (moradores.qtde() == 0) {
			JOptionPane.showMessageDialog(null, "Não há moradores cadastrados.");
		} else {
			String valor = JOptionPane.showInputDialog("Digite o CPF do morador:");
			JOptionPane.showMessageDialog(null, moradores.recebeValor(valor));
		}
	}

	public static void removeMorador() {
		System.out.println("Desiste");
		if (moradores.qtde() == 0) {
			JOptionPane.showMessageDialog(null, "Não há moradores cadastrados");
		} else {
			CMorador morador = new CMorador();
			String chave = JOptionPane.showInputDialog("Digite o CPF do morador:");
			int opcao = 0;
			morador = (CMorador) moradores.recebeValor(chave);

			JOptionPane.showMessageDialog(null, moradores.recebeValor(chave));
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
					"\"Realmente deseja fazer a exclusão/desistência deste morador?\n1 - Sim\n 2 - Não",
					"Exclusão/Desistência", JOptionPane.INFORMATION_MESSAGE));

			if (opcao == 1) {

				moradores.remove(chave);
				if (!morador.faixa) {
					faixa1--;
				} else {
					faixa2--;
				}
				// estou tirando da fila de espera e adicionando ao dicionario
				if (!espera.vazia()) {
					morador = (CMorador) espera.desenfileira();
					moradores.adiciona(morador.cpf, morador);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Exclusão cancelada.");
			}
			// apenas pra gente ver se ta funcionando
			// moradores.imprime();
		}
	}

	public static void sorteioMorador() {
		int opcao, quantidade;
		Random sorteia = new Random();
		opcao = Integer
				.parseInt(JOptionPane.showInputDialog(null,
						"Há " + moradores.qtde() + " morador(es): " + faixa1 + " da faixa 1 e " + faixa2
								+ " da faixa 2. Deseja sortear para qual faixa?",
						"Sorteio", JOptionPane.QUESTION_MESSAGE));

		if (opcao == 1 && faixa1 == 0) {
			JOptionPane.showMessageDialog(null, "Não há moradores desta faixa.");
		}

		if (opcao == 1 && faixa1 > 0) {
			quantidade = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Quantas casas deseja sortear para " + faixa1 + " morador(es) da faixa 1?"));
			if (quantidade == 0) {
				JOptionPane.showMessageDialog(null, "Nenhuma casa será sorteada.");
			}
			if (quantidade > faixa1) {
				JOptionPane.showInputDialog(null,
						"O número de casas a serem sorteadas é maior que o número de morador(es) da faixa 1.\nDeseja sortear casas para todos os moradores?\nDigite 1 para sim e 2 para não.",
						"Confirma", JOptionPane.INFORMATION_MESSAGE);
			} else {
				for (int i = 0; i < quantidade; i++) {
					moradores.peekFaixa1(sorteia.nextInt(moradores.qtde()));
				}
				faixa1 -= quantidade;
			}
		}

		if (opcao == 2 && faixa2 == 0) {
			JOptionPane.showMessageDialog(null, "Não há moradores desta faixa.");
		}

		if (opcao == 2 && faixa2 > 0) {
			quantidade = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Quantas casas deseja sortear para " + faixa2 + " morador(es) da faixa 2?"));
			if (quantidade == 0) {
				JOptionPane.showMessageDialog(null, "Nenhuma casa será sorteada.");
			}
			if (quantidade > faixa2) {
				JOptionPane.showInputDialog(null,
						"O número de casas a serem sorteadas é maior que o número de morador(es) da faixa 2.\nDeseja sortear casas para todos os moradores?\nDigite 1 para sim e 2 para não",
						"Confirma", JOptionPane.YES_NO_OPTION);
			} else {
				for (int i = 0; i < quantidade; i++) {
					moradores.peekFaixa2(sorteia.nextInt(moradores.qtde()));
				}
				faixa2 -= quantidade;
			}
		}

		if (opcao != 1 && opcao != 2) {
			JOptionPane.showMessageDialog(null, "Por favor, digite uma entrada válida.");
		}
	}

	/*
	 * =========MAIN===========
	 */

	public static void main(String[] args) {
		int escolha = 0;

		do {
			try {
				escolha = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1 - Cadastrar Morador\n2 - Listagem de Moradores\n3 - Imprimir lista de espera\n4 - Pesquisa de moradores\n5 - Desistência/exclusão\n6 - Sorteio\n7 - Parâmetros\n8 - Sair",
						"Menu", JOptionPane.PLAIN_MESSAGE));

				switch (escolha) {

				case 1:
					cadastrarMorador();
					break;

				case 2:
					if (moradores.qtde() == 0) {
						JOptionPane.showMessageDialog(null, "Não há moradores cadastrados.");
					} else {
						escolha = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Digite 1 para impressão completa e 2 para impressão simples"));
						if (escolha == 1) {
							moradores.imprimeCompleto();
						} else {
							moradores.imprimeSimples();
						}
					}
					break;

				case 3:
					if (espera.quantidade() == 0) {
						JOptionPane.showMessageDialog(null, "Não há moradores na fila de espera.");
					} else {
						espera.impressaoSimples();
					}
					break;

				case 4:
					pesquisaMorador();
					break;

				case 5:
					if (moradores.qtde() == 0) {
						JOptionPane.showMessageDialog(null, "Não há moradores cadastrados.");
					} else {
						removeMorador();
					}
					break;

				case 6:
					if (moradores.qtde() == 0) {
						JOptionPane.showMessageDialog(null, "Não há moradores cadastrados.");
					} else {
						sorteioMorador();
					}
					break;

				case 7:
					JOptionPane.showMessageDialog(null,
							"Limite de moradores em cada lista: 50\nLimite da fila de espera: 75", "Parâmetros",
							JOptionPane.INFORMATION_MESSAGE);
					break;

				case 8:
					JOptionPane.showMessageDialog(null,
							"O programa será encerrado.\nObrigado por usar o sorteio de moradores!", "Encerrar",
							JOptionPane.INFORMATION_MESSAGE);
					break;

				default:
					JOptionPane.showMessageDialog(null, "Por favor, digite uma entrada válida.", "Entrada inválida",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {

			}
		} while (escolha != 8);

	}

}
