package lib;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Celular {

	private Cliente cliente;
	private int numero;
	private Plano plano;
	private ArrayList<Ligacao> ligacoes;
	private String tipo;
	private boolean habilitado;
	private double creditos;

	public Celular(){
		this.ligacoes = new ArrayList<Ligacao>();
	}

	public Celular(String tipo, Plano plano, ArrayList<Promocao> promocoes) {
		this.tipo = tipo;
		this.plano = plano;
		adicionarPromocoes(promocoes);
		randomizarNumero();
		this.ligacoes = new ArrayList<Ligacao>();
		this.habilitado = true;
	}

	private void adicionarPromocoes(ArrayList<Promocao> promocoes) {
		for (Promocao p : promocoes) {
			if (p.disponivelPara(this) && (!this.plano.getPromocoes().contains(p)))
				this.plano.getPromocoes().add(p);
		}
	}
	
	private void randomizarNumero() {
		Random gerador = new Random();
		this.setNumero(gerador.nextInt(100000000));
	}
	
	public void adicionarCreditos(double quantidade){
		if (this.plano.getTipo().equals("Pre-pago")){
			GregorianCalendar gc = new GregorianCalendar();
			gc.add(Calendar.DAY_OF_MONTH, 180);
			this.creditos += quantidade;
			this.plano.setValidade(gc);
		}
	}

	public void fazerLigacaoTelefone(Ligacao ligacao) {
		Promocao promocao = this.verificarSaldoDePromocao();
		if (promocao.getTipo().equals("Minutos"))
			this.fazerLigacaoUsandoMinutos(promocao, ligacao);
		if (promocao.getTipo().equals("Bonus"))
			this.fazerLigacaoUsandoBonus(promocao, ligacao);
		if (promocao.getTipo().equals("Nenhum"))
			this.fazerLigacaoSemPromocao(ligacao);
	}

	public void fazerLigcaoInternet(Ligacao ligacaoInternet) {
		Promocao promocao = temPromocaoInternet();
		if (promocao != null){
			if(promocao.getQuantidade() >= ligacaoInternet.getDuracao()){
				promocao.setQuantidade(promocao.getQuantidade() - ligacaoInternet.getDuracao());
			}else{
				fazerLigacaoSemPromocao(ligacaoInternet);
			}
		}
		
	}

	private Promocao temPromocaoInternet() {
		for (Promocao p : this.plano.getPromocoes()) {
			if (p.getTipo().equals("Internet")){
				if (new GregorianCalendar().before(p.getValidade()))
					return p;
			}
		}
		return null;
	}
	
	private void fazerLigacaoUsandoBonus(Promocao promocao, Ligacao ligacao) {
		double quantidadeFinal = promocao.getQuantidade() - (ligacao.getDuracao() * this.plano.getValorMinuto());
		double limite = promocao.getLimiteDiario() - ligacao.getDuracao();
		if (quantidadeFinal < 0){
			promocao.setQuantidade(0);
			fazerLigacaoSemPromocao(new Ligacao(ligacao.getNumeroCelular(), (-1 * quantidadeFinal), ligacao.getData()));
		}
		if (limite < 0){
			promocao.setQuantidade(quantidadeFinal);
			fazerLigacaoSemPromocao(new Ligacao(ligacao.getNumeroCelular(), (-1 * limite), ligacao.getData()));
		}
		if (limite > 0 && quantidadeFinal > 0){
			promocao.setQuantidade(quantidadeFinal);
			this.ligacoes.add(ligacao);
		}
	}

	private void fazerLigacaoSemPromocao(Ligacao ligacao) {
		if (this.creditos > ligacao.getDuracao() * this.plano.getValorMinuto()){
			this.creditos -= (ligacao.getDuracao() * this.plano.getValorMinuto());
			this.ligacoes.add(ligacao);
		}
	}

	private void fazerLigacaoUsandoMinutos(Promocao promocao, Ligacao ligacao) {
		double quantidadeFinal = promocao.getQuantidade() - ligacao.getDuracao();
		if (quantidadeFinal < 0){
			promocao.setQuantidade(0);
			fazerLigacaoSemPromocao(new Ligacao(ligacao.getNumeroCelular(), (-1 * quantidadeFinal), ligacao.getData()));
		}else{
			promocao.setQuantidade(quantidadeFinal);
			this.ligacoes.add(ligacao);
		}
	}

	private Promocao verificarSaldoDePromocao(){
		for (Promocao p : this.plano.getPromocoes()) {
			if (!p.getTipo().equals("Internet")){
				if (new GregorianCalendar().before(p.getValidade()))
					return p;
			}
		}
		return null;
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

	public double getCreditos() {
		return creditos;
	}

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}
	
}
