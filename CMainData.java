import java.util.Random;

public class CMainData {

	public static void main(String[] args) {
		Random geraData = new Random();
		Data[] vetOrdenavel = new Data[10];
		for (int i = 0; i < 10; i++) {
			int ano = geraData.nextInt(2500);
			if (ano == 0)
				ano = 1;
			int mes = geraData.nextInt(12);
			if (mes == 0) 
				mes = 1;
			int dia = geraData.nextInt(28);
			if (dia == 0)
				dia = 1;
			vetOrdenavel[i] = new Data(ano, mes, dia);
		}
		Data[] vetRecebe = (Data[]) Ordenador.crescente(vetOrdenavel);
		for (int i = 0; i < 10; i++) {
			System.out.println(vetRecebe[i]);
		}
	}

}
