import java.util.Random;

public class CDicionario {
	private CCelulaDicionario primeira, ultima;
	private int qtde;

	public CDicionario() {
		primeira = new CCelulaDicionario();
		ultima = primeira;
	}

	public boolean vazio() {
		return primeira == ultima;
	}

	public void adiciona(Object chave, CMorador valor) {
		if (primeira == ultima) {
			primeira.prox = new CCelulaDicionario(chave, valor);
			ultima = ultima.prox;
			qtde++;
		} else {
			boolean verifica = true;
			CCelulaDicionario aux = primeira.prox;
			while (aux.prox != null && verifica) {
				verifica = aux.key != chave;
				aux = aux.prox;
			}
			if (verifica) {
				ultima.prox = new CCelulaDicionario(chave, valor);
				ultima = ultima.prox;
				qtde++;
			}
		}

	}

	public void remove(Object chave) {
		if (primeira != ultima) {
			CCelulaDicionario aux = primeira;
			boolean achou = false;
			while (aux.prox != null && !achou) {
				achou = aux.prox.key.equals(chave);
				if (!achou)
					aux = aux.prox;
			}
			if (achou) {
				// achou o elemento
				aux.prox = aux.prox.prox;
				if (aux.prox == null)
					ultima = aux;
				qtde--;
			}
		}
	}

	public void imprime() {
		CCelulaDicionario aux = primeira.prox;
		while (aux != null) {
			System.out.println(aux.value);
			System.out.println(aux.key);
			aux = aux.prox;
		}
	}

	public Object recebeValor(Object chave) {
		boolean achou = false;
		for (CCelulaDicionario aux = primeira.prox; aux != null && !achou; aux = aux.prox) {
			achou = aux.key.equals(chave);
			if (achou) {
				return aux.value;
			}
		}
		return "Este endereço não pertence ao dicionário.";
	}

	public void imprimeSimples() {
		int instancias = 0;
		int pagina = 0;
		for (int i = 0; i < qtde; i++) {
			System.out.println(" LISTA DE MORADORES (PÁGINA " + pagina + 1 + ")");
			System.out.println(" ==============================");
			System.out.println("FAIXA 1");
			for (CCelulaDicionario d = primeira.prox; d != null; d = d.prox) {
				if (!d.value.getFaixa()) {

					System.out.println(d.value.toSimples());
					instancias++;
					if (instancias == 20) {
						instancias = 0;
						pagina++;
						System.out.println("Pressione a tecla enter para cotinuar...");
						try {
							System.in.read();
						} catch (Exception e) {

						}
						for (i = 0; i < 50; i++) {
							System.out.println();
						}
					}
				}
			}
			instancias = 0;
			System.out.println("FAIXA 2");
			for (CCelulaDicionario d = primeira.prox; d != null; d = d.prox) {
				if (d.value.getFaixa()) {

					System.out.println(d.value.toSimples());
					instancias++;
					if (instancias == 20) {
						instancias = 0;
						pagina++;
						System.out.println("Pressione a tecla enter para continuar...");
						try {
							System.in.read();
						} catch (Exception e) {

						}
						for (i = 0; i < 50; i++) {
							System.out.println();
						}
					}
				}
			}
		}

	}

	public void imprimeCompleto() {
		int instancias = 0;
		int pagina = 0;
		for (int i = 0; i < qtde; i++) {
			System.out.println(" LISTA DE MORADORES (PÁGINA " + pagina + 1 + ")");
			System.out.println(" ==============================");

			System.out.println("FAIXA 1");
			for (CCelulaDicionario d = primeira.prox; d != null; d = d.prox) {
				if (!d.value.getFaixa()) {

					System.out.println(d.value.toString());
					instancias++;
					if (instancias == 3) {
						instancias = 0;
						pagina++;
						System.out.println("Pressione a tecla enter para cotinuar...");
						try {
							System.in.read();
						} catch (Exception e) {

						}
						for (i = 0; i < 50; i++) {
							System.out.println();
						}
					}
				}
			}
			instancias = 0;
			System.out.println(" FAIXA 2");
			for (CCelulaDicionario d = primeira.prox; d != null; d = d.prox) {
				if (d.value.getFaixa()) {

					System.out.println(d.value.toString());
					instancias++;
					if (instancias == 3) {
						instancias = 0;
						pagina++;
						System.out.println("Pressione a tecla enter para continuar...");
						try {
							System.in.read();
						} catch (Exception e) {

						}
						for (i = 0; i < 50; i++) {
							System.out.println();
						}
					}
				}
			}
		}
	}

	public void peekFaixa1(int posicao) {
		if (posicao > qtde) {
			Random gerador = new Random();
			posicao = gerador.nextInt(qtde-1);
		}
		if (primeira != ultima) {
			CCelulaDicionario aux = primeira.prox;
			int i = 0;
			while (i < posicao) {
				aux = aux.prox;
				i++;
			}
			if (!aux.value.faixa) {
				System.out.println(aux.value);
				remove(aux.value.cpf);
			} else {
				peekFaixa1(posicao + 1);
			}
		}
	}

	public void peekFaixa2(int posicao) {
		if (posicao > qtde) {
			Random gerador = new Random();
			posicao = gerador.nextInt(qtde-1);
		}
		if (primeira != ultima) {
			CCelulaDicionario aux = primeira.prox;
			int i = 0;
			while (i < posicao) {
				aux = aux.prox;
				i++;
			}
			if (aux.value.faixa) {
				System.out.println(aux.value);
				remove(aux.value.cpf);
			} else {
				peekFaixa2(posicao+1);
			}
		}
	}

	public int qtde() {
		return qtde;
	}
}
