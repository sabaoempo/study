
public class PessoaJuridica extends Pessoa{

	private String cnpj;
	
	public PessoaJuridica() {
		super();
		this.cnpj = "indefinido";
	}

	public PessoaJuridica(int idade, String nome, String endereco, String sexo, String telefone, String cep,
			String cidade, String uf, String cnpj) {
		super(idade, nome, endereco, sexo, telefone, cep, cidade, uf);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public Pessoa overPessoa() {
		return new PessoaJuridica(this.idade, this.nome, this.endereco, this.sexo, this.telefone, this.cep,
				this.cidade, this.uf, this.cnpj);
	}
	
	
	
}
