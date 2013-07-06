package ufla.monografia;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import lib.Celular;
import lib.Plano;
import lib.Promocao;

import org.junit.Before;
import org.junit.Test;

public class CelularTest {

	Celular smartPre;
	Celular regularPre;
	Celular smartPos;
	Celular regularPos;
	Plano pre;
	Plano pos;
	ArrayList<Promocao> promocoes;

	@Before
	public void inicializar(){
		promocoes = new ArrayList<Promocao>();
		promocoes.add(new Promocao("Uma Promocao de Minutos", new Date(), 0));
		promocoes.add(new Promocao("Uma Promocao de Internet", 0.5, 10, 0.125));
		promocoes.add(new Promocao("Uma Promocao de Bonus", new Date(), 300, 10));
		pre = new Plano(10, new GregorianCalendar(), new ArrayList<Promocao>());
		pos = new Plano(10, new ArrayList<Promocao>());
		smartPre = new Celular("Smartphone", pre, promocoes);
		regularPre = new Celular("Regularphone", pre, promocoes);
		regularPos = new Celular("Regularphone", pos, promocoes);
		smartPos = new Celular("Smartphone", pos, promocoes);
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

}
