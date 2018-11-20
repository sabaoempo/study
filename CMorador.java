
public class CMorador {

	public String nomeCompleto;
	public float rendaFamiliar;
	public String cpf;
	public int qtdeDependentes;
	public String cidade;
	public String rua;
	public int numeroComplemento;
	public String cep;
	public String bairro;
	public String estado;
	public long telefone;
	public boolean faixa;

	// public final int MAX_MORADORES = 50;
	// public final int MAX_ESPERA = 75;

	public CMorador(String nomeCompleto, float rendaFamiliar, String cpf, int qtdeDependentes, String cidade,
			String rua, int numeroComplemento, String cep, String bairro, String estado, long telefone, boolean faixa) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.rendaFamiliar = rendaFamiliar;
		this.cpf = cpf;
		this.qtdeDependentes = qtdeDependentes;
		this.cidade = cidade;
		this.rua = rua;
		this.numeroComplemento = numeroComplemento;
		this.cep = cep;
		this.bairro = bairro;
		this.estado = estado;
		this.telefone = telefone;
		this.faixa = faixa;
	}

	public CMorador() {

	}

	public CMorador(String cpf, String nomeCompleto, float rendaFamiliar, boolean faixa) {
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.rendaFamiliar = rendaFamiliar;
		this.faixa = faixa;
	}

	// getters e setters

	public boolean isFaixa() {
		return faixa;
	}

	public void setFaixa(boolean faixa) {
		this.faixa = faixa;
	}

	public int getQtdeDependentes() {
		return qtdeDependentes;
	}

	public void setQtdeDependentes(int qtdeDependentes) {
		this.qtdeDependentes = qtdeDependentes;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public int getNumeroComplemento() {
		return numeroComplemento;
	}

	public void setNumeroComplemento(int numeroComplemento) {
		this.numeroComplemento = numeroComplemento;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public float getRendaFamiliar() {
		return rendaFamiliar;
	}

	public void setRendaFamiliar(float rendaFamiliar) {
		this.rendaFamiliar = rendaFamiliar;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public boolean getFaixa() {
		return faixa;
	}
	
	public void getFaixa(boolean faixa) {
		this.faixa = faixa;
	}

	// método que imprime os dados do morador de forma simples

	public String toSimples() {
		return "CPF: " + this.cpf + ", Nome: " + this.nomeCompleto + ", Renda Familiar: " + this.rendaFamiliar;
	}

	// toString para a impressão completa de cada morador

	@Override
	public String toString() {
		return "CPF: " + this.cpf + ", Nome: " + this.nomeCompleto + "\nQtde. Dependentes: " + this.qtdeDependentes
				+ ", Renda Familiar: " + this.rendaFamiliar + "\nTelefone: " + this.telefone + "\nRua: " + this.rua
				+ ", " + " " + this.numeroComplemento + ", Bairro: " + this.bairro + "\nCidade: " + this.cidade
				+ ", Estado: " + this.estado + ", CEP: " + this.cep + "\n\n";
	}

}
