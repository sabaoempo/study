
public class Cliente extends Pessoa {
	private Pessoa tipoDePessoa;
	private double limiteCredito;
	
	public Cliente() {
		
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	public void setTipoDePessoa() {
		this.tipoDePessoa = tipoDePessoa.overPessoa();
	}
	
	public Cliente(double limiteCredito, Pessoa tipoDePessoa) {
		this.setLimiteCredito(limiteCredito);
		this.tipoDePessoa = tipoDePessoa;
		
	}
	
	//O construtor de cliente instancia tipos diferentes de pessoa dependendo da assinatura fornecida para o método
	
	@Override
	public Pessoa overPessoa() {
		return new Cliente(this.limiteCredito, this.tipoDePessoa);
	}
	
}
