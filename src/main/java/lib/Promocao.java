package lib;

import java.util.GregorianCalendar;

public class Promocao {

	private String nome;
	
	//internet
	private double franquia;
	private double velocidade;
	private double velocidadeAlemDaFranquia;
	private double velocidadeAtual;
	
	//Geral
	private GregorianCalendar validade;
	private double quantidade;
	private String tipo;

	//Bonus
	private double limiteDiario;

	//minutos
	public Promocao(String nome, GregorianCalendar validade, double quantidade){
		this.nome = nome;
		this.validade = validade;
		this.quantidade = quantidade;
		this.tipo = "Minutos";
	}
	
	//internet
	public Promocao(String nome, double quantidade, GregorianCalendar validade, double velocidade, double franquia, double velocidadeAlemDaFranquia) {
		this.quantidade = quantidade;
		this.validade = validade;
		this.nome = nome;
		this.velocidade = velocidade;
		this.franquia = franquia;
		this.velocidadeAlemDaFranquia = velocidadeAlemDaFranquia;
		this.velocidadeAtual = velocidade;
		this.tipo = "Internet";
	}

	//bonus
	public Promocao(String nome, GregorianCalendar validade, double quantidade, double limiteDiario) {
		this.nome = nome;
		this.validade = validade;
		this.quantidade = quantidade;
		this.limiteDiario = limiteDiario;
		this.tipo = "Bonus";
	}

	public boolean disponivelPara(Celular celular) {
		return celular.getTipo().equals("Smartphone") ? 
				true : (this.tipo.equals("Minutos") || this.tipo.equals("Bonus"));
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}

	public double getFranquia() {
		return franquia;
	}

	public void setFranquia(double franquia) {
		this.franquia = franquia;
	}

	public double getVelocidadeAlemDaFranquia() {
		return velocidadeAlemDaFranquia;
	}

	public void setVelocidadeAlemDaFranquia(double velocidadeAlemDaFranquia) {
		this.velocidadeAlemDaFranquia = velocidadeAlemDaFranquia;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getLimiteDiario() {
		return limiteDiario;
	}

	public void setLimiteDiario(double limiteDiario) {
		this.limiteDiario = limiteDiario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public GregorianCalendar getValidade() {
		return validade;
	}

	public void setValidade(GregorianCalendar validade) {
		this.validade = validade;
	}

	public double getVelocidadeAtual() {
		return velocidadeAtual;
	}

	public void setVelocidadeAtual(double velocidadeAtual) {
		this.velocidadeAtual = velocidadeAtual;
	}
	
	public String toString(){
		return "Nome: " + nome + "\nTipo: " + tipo + "\n";
	}

}
