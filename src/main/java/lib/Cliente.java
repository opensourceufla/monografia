package lib;
import java.util.ArrayList;


public class Cliente {

	private String nome;
	private Endereco endereco;
	private ArrayList<Celular> celulares;
	
	public Cliente(){

	}
	
	public Cliente(ArrayList<Celular> celulares, String nome, Endereco endereco){
		this.celulares = celulares;
		this.nome = nome;
		this.endereco = endereco;
	}
	
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
	
	public String toString(){
		String retorno = "Nome: " + nome + "\nEndereco: " + endereco.toString() + "\n";
		for (Celular celular : celulares) {
			retorno += celular.toString();
		}
		return retorno;
	}
}
