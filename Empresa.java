import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;

public class Empresa extends Pessoa{
	
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	Set<Cliente> clientesOrdenados = new TreeSet<Cliente>(clientes);
	Set<Funcionario> funcionariosOrdenados = new TreeSet<Funcionario>(funcionarios);
	
	@Override
	public Pessoa overPessoa() {
		return new Cliente();
	}
	
}
