import java.util.ArrayList;


public class Plano {

	private String nome;	
	private double valorMinuto;
	private ArrayList<Promocao> promocoes;

	public ArrayList<Promocao> getPromocoes() {
		return promocoes;
	}

	public void setPromocoes(ArrayList<Promocao> promocoes) {
		this.promocoes = promocoes;
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
	
	
}
