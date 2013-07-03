package lib;
import java.util.ArrayList;
import java.util.Random;

public class Celular {

	private Cliente cliente;
	
	private int numero;
	
	private Plano plano;
	
	private ArrayList<Ligacao> ligacoes;
	
	private String tipo;
	
	private boolean habilitado;

	public Celular(String tipo, Plano plano, ArrayList<Promocao> promocoes) {
		this.tipo = tipo;
		this.plano = plano;
		for (Promocao p : promocoes) {
			if (p.disponivelPara(this))
				this.plano.getPromocoes().add(p);
		}
		this.randomizarNumero();
		this.habilitado = true;
	}
	
	public Celular(){
	}
	
	private void randomizarNumero() {
		Random gerador = new Random();
		this.setNumero(gerador.nextInt(10000000));
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public ArrayList<Ligacao> getLigacoes() {
		return ligacoes;
	}

	public void setLigacoes(ArrayList<Ligacao> ligacoes) {
		this.ligacoes = ligacoes;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}


	
}
