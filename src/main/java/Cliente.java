import java.util.ArrayList;


public class Cliente {

	private String nome;
	private Endereco endereco;
	private ArrayList<Celular> celulares;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public ArrayList<Celular> getCelulares() {
		return celulares;
	}
	
	public void setCelulares(ArrayList<Celular> celulares) {
		this.celulares = celulares;
	}
	
	
}
