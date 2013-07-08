package ufla.monografia;

import static org.junit.Assert.*;
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
	Celular preBonus;
	Celular preMinutos;
	Celular preSemPromocao;
	ArrayList<Promocao> minutos;
	ArrayList<Promocao> bonus;
	Ligacao ligacao;
	Ligacao ligacaoInternet;

	@Before
	public void inicializar(){
		setPromocoes();
		setPlanos();
		setCelularesTestesGerais();
		setPromocoesTestesEspecificos();
		
		ligacao = new Ligacao(1, 60, dataParaLigacoes);
		ligacaoInternet = new Ligacao(30, dataParaLigacoes);
		preBonus = new Celular("Smartphone", pre, bonus);
		preMinutos = new Celular("Regularphone", pre, minutos);
		preSemPromocao = new Celular("Regularphone", pre, new ArrayList<Promocao>());
		
	}

	private void setPromocoesTestesEspecificos() {
		minutos = new ArrayList<Promocao>();
		minutos.add(new Promocao("Uma Promocao de Minutos", dataParaLigacoes, 100));
		bonus = new ArrayList<Promocao>();
		bonus.add(new Promocao("Uma Promocao de Bonus", dataParaLigacoes, 300, 100));
		
	}

	private void setCelularesTestesGerais() {
		smartPre = new Celular("Smartphone", pre, promocoes);
		regularPre = new Celular("Regularphone", pre, promocoes);
		regularPos = new Celular("Regularphone", pos, promocoes);
		smartPos = new Celular("Smartphone", pos, promocoes);
	}

	private void setPlanos() {
		pre = new Plano(0.25, 10, new GregorianCalendar(), new ArrayList<Promocao>());
		pos = new Plano(10, new ArrayList<Promocao>());
	}

	private void setPromocoes() {
		dataParaLigacoes = new GregorianCalendar();
		dataParaLigacoes.add(Calendar.DAY_OF_MONTH, 100);
		promocoes = new ArrayList<Promocao>();
		promocoes.add(new Promocao("Uma Promocao de Minutos", dataParaLigacoes, 0));
		promocoes.add(new Promocao("Uma Promocao de Internet", 0.5, 10, 0.125));
		promocoes.add(new Promocao("Uma Promocao de Bonus", dataParaLigacoes, 300, 100));
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
	public void deveRegistrarLigacaoDeCelularPre(){
		preBonus.fazerLigacao(ligacao);
		preMinutos.fazerLigacao(ligacao);
		preSemPromocao.adicionarCreditos(1000);
		preSemPromocao.fazerLigacao(ligacao);
		assertFalse(preBonus.getLigacoes().isEmpty());
		assertFalse(preMinutos.getLigacoes().isEmpty());
		assertFalse(preSemPromocao.getLigacoes().isEmpty());
	}
		
	@Test
	public void deveRegistrarLigacaoDeInternet(){
		smartPre.fazerLigacaoInternet(ligacaoInternet);
		assertFalse(smartPre.getLigacoes().isEmpty());
	}
	
}
