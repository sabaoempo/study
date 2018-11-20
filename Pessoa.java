
public abstract class Pessoa{
	//A classe pessoa deve ser abstrata porque ela contém os dados de uma pessoa, e não uma pessoa em si.
	//Uma pessoa nunca será implementada. Entretanto, uma pessoa física ou jurídica, que são filhas de pessoa, serão.
	//Ademais, para um cliente ser físico ou jurídico, ele precisa de parâmetros diferentes para o método overPessoa().
	protected int idade;
	protected String nome, endereco, sexo, telefone, cep, cidade, uf;

	public Pessoa() {
		this.idade = 0;
		this.nome = "indefinido";
		this.endereco = "indefinido";
		this.sexo = "indefinido";
		this.telefone = "xxxxx-xxxx";
		this.cep = "xxxxx-xxx";
		this.cidade = "indefinido";
		this.uf = "xx";
	}

	public Pessoa(int idade, String nome, String endereco, String sexo, String telefone, String cep, String cidade,
			String uf) {
		this.idade = idade;
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.telefone = telefone;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	public Pessoa(String nome, String endereco, String telefone) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public abstract Pessoa overPessoa();
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pessoa) {
			Pessoa p = (Pessoa) obj;
			if(this.nome.equals(p.getNome()) && this.endereco.equals(p.getEndereco()) && this.telefone.equals(p.getTelefone()))
					return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + "\nEndereço: " + this.endereco + "\nTelefone: " + this.telefone;
	}
}
