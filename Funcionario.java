
public class Funcionario extends PessoaFisica {
	
	private String cargo;
	private int salario;
	
	public Funcionario() {
		super();
		this.cargo = "indefinido";
		this.salario = 0;
	}
	public Funcionario(int idade, String nome, String endereco, String sexo, String telefone, String cep, String cidade,
			String uf, String cpf, String cargo, int salario) {
		super(idade, nome, endereco, sexo, telefone, cep, cidade, uf, cpf);
		this.cargo = cargo;
		this.salario = salario;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	
	
}
