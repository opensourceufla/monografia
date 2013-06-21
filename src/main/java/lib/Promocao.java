package lib;

import java.util.Date;

public class Promocao {

	private String nome;
	private double velocidade;
	private double franquia;
	private double velocidadeAlemDaFranquia;
	private Date validade;
	private double quantidade;
	private double limiteDiario;
	private String tipo;
	private Plano plano;

	//minutos
	public Promocao(String nome, Date validade, double quantidade){
		this.nome = nome;
		this.validade = validade;
		this.quantidade = quantidade;
		this.tipo = "Minutos";
	}
	
	//internet
	public Promocao(String nome, double velocidade, double franquia, double velocidadeAlemDaFranquia) {
		this.nome = nome;
		this.velocidade = velocidade;
		this.franquia = franquia;
		this.velocidadeAlemDaFranquia = velocidadeAlemDaFranquia;
		this.tipo = "Internet";
	}

	//bonus
	public Promocao(String nome, Date validade, double quantidade, double limiteDiario) {
		this.nome = nome;
		this.validade = validade;
		this.quantidade = quantidade;
		this.limiteDiario = limiteDiario;
		this.tipo = "Bonus";
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

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
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

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public boolean disponivelPara(Celular celular) {
		return celular.getTipo().equals("Smartphone") ? 
				true : (this.tipo.equals("Minutos") || this.tipo.equals("Bonus"));
	}	
	
}
