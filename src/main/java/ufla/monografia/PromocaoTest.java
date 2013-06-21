package ufla.monografia;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import lib.Promocao;

import org.junit.Test;

public class PromocaoTest {

	Promocao promo;
	
	@Test
	public void deveCriarPromocaoDoTipoMinutos() {
		promo = new Promocao("Uma Promocao de Minutos", new Date(), 0);
		assertEquals(promo.getTipo(), "Minutos");
	}
	
	@Test
	public void deveCriarPromocaoDoTipoInternet(){
		promo = new Promocao("Uma Promocao de Internet", 0.5, 10, 0.125);
		assertEquals(promo.getTipo(), "Internet");
	}
	
	@Test
	public void deveCriarPromocaoDoBonus(){
		promo = new Promocao("Uma Promocao de Bonus", new Date(), 300, 10);
		assertEquals(promo.getTipo(), "Bonus");
	}

}
