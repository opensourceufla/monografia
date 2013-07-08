package ufla.monografia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import lib.Celular;
import lib.Ligacao;
import lib.Plano;
import lib.Promocao;

import org.junit.Before;
import org.junit.Test;

public class CelularTest {

	//testes gerais
	Celular smartPre;
	Celular regularPre;
	Celular smartPos;
	Celular regularPos;
	Plano pre;
	Plano pos;
	ArrayList<Promocao> promocoes;
	GregorianCalendar dataParaLigacoes;

	//testes especificos
	Ligacao ligacao;
	Ligacao ligacaoInternet;
	private Celular preMinutos;
	private ArrayList<Promocao> minutos;
	private Celular preBonus;
	private ArrayList<Promocao> bonus;
	private Celular preInternet;
	private ArrayList<Promocao> internet;
	private Celular preSemPromocao;

	@Before
	public void inicializar(){
		setPlanos();
		setPromocoes();
		setCelulares();
		
		ligacao = new Ligacao(1, 60, dataParaLigacoes);
		ligacaoInternet = new Ligacao(30, dataParaLigacoes);
		
	}

	private void setCelulares() {
		smartPre = new Celular("Smartphone", pre, promocoes);
		regularPre = new Celular("Regularphone", pre, promocoes);
		regularPos = new Celular("Regularphone", pos, promocoes);
		smartPos = new Celular("Smartphone", pos, promocoes);
		preMinutos = new Celular("Smartphone", new Plano(0.5, 100, new GregorianCalendar(), new ArrayList<Promocao>()), minutos);
		preBonus = new Celular("Smartphone", new Plano(0.5, 100, new GregorianCalendar(), new ArrayList<Promocao>()), bonus);
		preInternet = new Celular("Smartphone", new Plano(0.5, 100, new GregorianCalendar(), new ArrayList<Promocao>()), internet);
		preSemPromocao = new Celular("Smartphone", new Plano(0.5, 100, new GregorianCalendar(), new ArrayList<Promocao>()), new ArrayList<Promocao>());
	}

	private void setPlanos() {
		pre = new Plano(0.25, 10, new GregorianCalendar(), new ArrayList<Promocao>());
		pos = new Plano(10, new ArrayList<Promocao>());
	}

	private void setPromocoes() {
		dataParaLigacoes = new GregorianCalendar();
		dataParaLigacoes.add(Calendar.DAY_OF_MONTH, 100);
		promocoes = new ArrayList<Promocao>();
		promocoes.add(new Promocao("Uma Promocao de Minutos", dataParaLigacoes, 100));
		promocoes.add(new Promocao("Uma Promocao de Internet", 100, dataParaLigacoes, 0.5, 10, 0.125));
		promocoes.add(new Promocao("Uma Promocao de Bonus", dataParaLigacoes, 300, 100));
		
		minutos = new ArrayList<Promocao>();
		minutos.add(new Promocao("Uma Promocao de Minutos", dataParaLigacoes, 100));
		
		bonus = new ArrayList<Promocao>();
		bonus.add(new Promocao("Uma Promocao de Bonus", dataParaLigacoes, 300, 100));
		
		internet = new ArrayList<Promocao>();
		internet.add(new Promocao("Uma Promocao de Internet",100, dataParaLigacoes, 0.5, 10, 0.125));
	}
	
	@Test
	public void deveHabilitarQualquerCelularDeQualquerPlano() {
		assertTrue(smartPre.isHabilitado());
		assertTrue(smartPos.isHabilitado());
		assertTrue(regularPre.isHabilitado());
		assertTrue(regularPos.isHabilitado());
	}
	
	@Test
	public void deveAdicionarCreditosAoCelularCartao(){
		smartPre.adicionarCreditos(100);
		regularPre.adicionarCreditos(100);
		assertTrue(smartPre.getCreditos() > 10);
		assertTrue(regularPre.getCreditos() > 10);
		assertTrue(smartPre.getPlano().getValidade().after(new GregorianCalendar()));
		assertTrue(regularPre.getPlano().getValidade().after(new GregorianCalendar()));
	}
	
	@Test
	public void deveRegistrarLigacaoMinutosPre(){
		preMinutos.fazerLigacao(ligacao);
		assertFalse(preMinutos.getLigacoes().isEmpty());
	}
	
	@Test
	public void deveRegsitrarLigacaoBonusPre(){
		preBonus.fazerLigacao(ligacao);
		assertFalse(preBonus.getLigacoes().isEmpty());
	}
	
	@Test
	public void deveRegistrarLigacaoInternetPre(){
		preInternet.fazerLigacao(ligacaoInternet);
		assertFalse(preInternet.getLigacoes().isEmpty());
	}
	
	@Test
	public void deveRegistrarLigacaoSemPromocaoPre(){
		preSemPromocao.adicionarCreditos(1000);
		preSemPromocao.fazerLigacao(ligacao);
		assertFalse(preSemPromocao.getLigacoes().isEmpty());
	}
	
}
