
public class PessoaFisica extends Pessoa{
	
	private String cpf;
	
	public PessoaFisica() {
		super();
		this.cpf = "indefinido";
	}

	public PessoaFisica(int idade, String nome, String endereco, String sexo, String telefone, String cep,
			String cidade, String uf, String cpf) {
		super(idade, nome, endereco, sexo, telefone, cep, cidade, uf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public Pessoa overPessoa() {
		return new PessoaFisica(this.idade, this.nome, this.endereco, this.sexo, this.telefone, this.cep,
				this.cidade, this.uf, this.cpf);
	}

}
