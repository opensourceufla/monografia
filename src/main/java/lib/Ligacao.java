package lib;
import java.util.GregorianCalendar;

public class Ligacao {

	private double duracao;
	private double valorCobrado;
	private int numeroCelular;
	private String tipo;
	private GregorianCalendar data;
	
	public Ligacao(){
		
	}
	
	public Ligacao(double duracao, GregorianCalendar data){
		this.duracao = duracao;
		this.data = data;
		this.tipo = "Internet";
	}
	
	public Ligacao(int numeroCelular, double duracao, GregorianCalendar data){
		this.numeroCelular = numeroCelular;
		this.duracao = duracao;
		this.data = data;
		this.tipo = "Telefone";
	}
	

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
 
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public int getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(int numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public double getValorCobrado() {
		return valorCobrado;
	}

	public void setValorCobrado(double valorCobrado) {
		this.valorCobrado = valorCobrado;
	}
	
	
}
