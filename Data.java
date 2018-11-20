import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class Data extends Ordenador implements Ordenavel{

	private int dia, mes, ano;

	public Data(int ano, int mes, int dia) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		if (dia < 32 && dia > 0)
			this.dia = dia;
		else
			System.out.println("Não é possível inserir dias maiores que 31.");
		// melhorar teste
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		if (mes < 13 && mes > 0)
			this.mes = mes;
		else
			System.out.println("Não é possível inserir meses maiores que 12.");
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Data() {
		this.dia = 14;
		this.mes = 1;
		this.ano = 2000;
	}

	public void adicionaDias(int dias) {
		for (int i = 0; i < dias; i++)
			proximoDia();
	}

	public int diasNoMes() {
		if (this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10
				|| this.mes == 12)
			return 31;
		if (this.mes == 2 && eAnoBisexto())
			return 29;
		if (this.mes == 2 && !eAnoBisexto())
			return 28;
		else
			return 30;

	}

	public String diaDaSemana() {
		String extenso = dia + "/" + mes + "/" + ano;
		String dia;
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;
		try {
			data = formatar.parse(extenso);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat formato = new SimpleDateFormat("EEEE");
		dia = formato.format(data);
		return dia;
	}

	public boolean eAnoBisexto() {
		return this.ano % 4 == 0 ? true : false;
	}

	public void proximoDia() {
		if (this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8
				|| this.mes == 10 && dia == 31) {
			this.mes++;
			this.dia = 1;
		} else if (this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11 && dia == 30) {
			this.mes++;
			this.dia = 1;
		} else if (this.mes == 2 && eAnoBisexto() && dia == 29) {
			this.mes++;
			this.dia = 1;
		} else if (this.mes == 2 && dia == 28) {
			this.mes++;
			this.dia = 1;
		} else if (this.mes == 12 && dia == 31) {
			this.ano++;
			this.mes = 1;
			this.dia = 1;
		} else
			this.dia = dia++;
	}
	
	public String porExtenso() {
		String escrever = "";
		switch(this.mes) {
		case 1:
			escrever = "janeiro";
			break;
		case 2:
			escrever = "fevereiro";
			break;
		case 3:
			escrever = "março";
			break;
		case 4:
			escrever = "abril";
			break;
		case 5:
			escrever = "maio";
			break;
		case 6:
			escrever = "junho";
			break;
		case 7:
			escrever = "julho";
			break;
		case 8:
			escrever = "agosto";
			break;
		case 9:
			escrever = "setembro";
			break;
		case 10:
			escrever = "outubro";
			break;
		case 11:
			escrever = "novembro";
			break;
		case 12:
			escrever = "dezembro";
			break;
		}
		return this.dia + "de " + escrever + " de" + this.ano;
	}
	
	@Override
	public String toString() {
		return "Dia: " + this.dia + "\nMês: " + this.mes + "\nAno: " + this.ano + "\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		Data novaData = (Data) obj;
		return this.dia == novaData.dia && this.mes == novaData.mes && this.ano == novaData.ano;
	}
	
	@Override
	public boolean menorQue(Ordenavel o) {
		Data novaData = (Data) o;
		if (novaData.getAno() > this.ano)
			return true;
		else if (novaData.ano == this.ano && novaData.mes > this.mes)
			return true;
		else if (novaData.ano == this.ano && novaData.mes == this.mes && novaData.dia > this.dia)
			return true;
		else
			return false;
	}

}
