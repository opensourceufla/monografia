package lib;
import java.util.ArrayList;
import java.util.Date;


public class Plano {

	private String nome;	
	private double valorMinuto;
	private double creditos;
	private Date validade;
	private int diaVencimento;
	private ArrayList<Promocao> promocoes;
	private String tipo;
	
	public Plano(){
		
	}
	
	//pre
	public Plano(double creditos, Date validade, ArrayList<Promocao> promocoes){
		this.creditos = creditos;
		this.validade = validade;
		this.promocoes = promocoes;
		this.tipo = "Pre-pago";
	}
	
	//pos
	public Plano(int diaVencimento, ArrayList<Promocao> promocoes){
		this.diaVencimento = diaVencimento;
		this.promocoes = promocoes;
		this.tipo = "Pos-pago";
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getValorMinuto() {
		return valorMinuto;
	}
	
	public void setValorMinuto(double valorMinuto) {
		this.valorMinuto = valorMinuto;
	}
	
	public double getCreditos() {
		return creditos;
	}
	
	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}
	
	public Date getValidade() {
		return validade;
	}
	
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	
	public int getDiaVencimento() {
		return diaVencimento;
	}
	
	public void setDiaVencimento(int diaVencimento) {
		this.diaVencimento = diaVencimento;
	}
	
	public ArrayList<Promocao> getPromocoes() {
		return promocoes;
	}
	
	public void setPromocoes(ArrayList<Promocao> promocoes) {
		this.promocoes = promocoes;
	}
		
}
