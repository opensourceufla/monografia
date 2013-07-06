package ufla.monografia;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import lib.Plano;
import lib.Promocao;

import org.junit.Test;

public class PlanoTest {

	Plano plano;
	ArrayList<Promocao> promocoes;
	
	
	@Test
	public void deveCriarPlanoPrePago() {
		plano = new Plano(0.25, 10, new GregorianCalendar(), promocoes);
		assertEquals(plano.getTipo(), "Pre-pago");
	}

	@Test
	public void deveCriarPlanoPosPago() {
		plano = new Plano(10, promocoes);
		assertEquals(plano.getTipo(), "Pos-pago");
	}
	
}
