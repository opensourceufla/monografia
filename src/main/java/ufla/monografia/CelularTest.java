package ufla.monografia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import lib.Celular;
import lib.Plano;
import lib.Promocao;

import org.junit.Before;
import org.junit.Test;

public class CelularTest {

	Celular smart;
	Celular regular;
	Plano pre;
	Plano pos;
	ArrayList<Promocao> promocoes;

	@Before
	public void inicializar(){
		promocoes = new ArrayList<Promocao>();
		promocoes.add(new Promocao("Uma Promocao de Minutos", new Date(), 0));
		promocoes.add(new Promocao("Uma Promocao de Internet", 0.5, 10, 0.125));
		promocoes.add(new Promocao("Uma Promocao de Bonus", new Date(), 300, 10));
		pre = new Plano(10, new Date(), new ArrayList<Promocao>());
	}
	
	@Test
	public void deveRandomizarNumero(){
		smart = new Celular("Smartphone", pre, promocoes);
		assertTrue(smart.getNumero() != 0);
	}
	
	@Test
	public void deveHabilitarSmartphoneTipoCartao() {
		smart = new Celular("Smartphone", pre, promocoes);
		assertTrue(smart.isHabilitado());
	}

}
