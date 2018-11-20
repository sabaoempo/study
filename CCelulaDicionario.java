
public class CCelulaDicionario {
	public Object key;
	public CMorador value;
	public CCelulaDicionario prox;
	
	public CCelulaDicionario() {
		
	}
	
	public CCelulaDicionario(Object chave, CMorador valor) {
		key = chave;
		value = valor;
		prox = null;
	}
	
	public CCelulaDicionario(Object chave, CMorador valor, CCelulaDicionario proxima) {
		key = chave;
		value = valor;
		prox = proxima;
	}
	
}
