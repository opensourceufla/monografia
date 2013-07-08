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

	public void fazerLigacao(Ligacao ligacao) {
		Promocao promocao = this.verificarSaldoDePromocao(ligacao);
		if (promocao == null) fazerLigacaoSemPromocao(ligacao);
		if (promocao.getTipo().equals("Minutos") || promocao.getTipo().equals("Internet")) fazerLigacaoUsandoMinutosOuInternet(promocao, ligacao);
		if (promocao.getTipo().equals("Bonus"))	fazerLigacaoUsandoBonus(promocao, ligacao);
	}

	private Promocao verificarSaldoDePromocao(Ligacao ligacao){
		for (Promocao p : this.plano.getPromocoes()) {
			if (new GregorianCalendar().before(p.getValidade())){
				if (p.getTipo().equals(ligacao.getTipo())){ //verifica se a ligacao eh do tipo Internet
					return p;
				}else{
					if (!p.getTipo().equals("Internet")){
						return p;
					}
				}
			}
		}
		
		return null;
	}
	
	public void fazerLigacaoUsandoMinutosOuInternet(Promocao promocao, Ligacao ligacao) {
		if(promocao.getQuantidade() >= ligacao.getDuracao()){
			promocao.setQuantidade(promocao.getQuantidade() - ligacao.getDuracao());
			this.ligacoes.add(ligacao);
		}else{
			fazerLigacaoSemPromocao(ligacao);
		}		
	}
	
	private void fazerLigacaoUsandoBonus(Promocao promocao, Ligacao ligacao) {
		if ((promocao.getLimiteDiario() >= ligacao.getDuracao()) && (promocao.getQuantidade() >= (ligacao.getDuracao() * this.plano.getValorMinuto()))){
			promocao.setQuantidade(promocao.getQuantidade() - (ligacao.getDuracao() * this.plano.getValorMinuto()));
			this.ligacoes.add(ligacao);
		}else{
			fazerLigacaoSemPromocao(ligacao);
		}
	}

	private void fazerLigacaoSemPromocao(Ligacao ligacao) {
		if (this.creditos > ligacao.getDuracao() * this.plano.getValorMinuto()){
			this.creditos -= (ligacao.getDuracao() * this.plano.getValorMinuto());
			this.ligacoes.add(ligacao);
		}
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
