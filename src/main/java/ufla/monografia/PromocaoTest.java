package ufla.monografia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import lib.Celular;
import lib.Promocao;

import org.junit.Before;
import org.junit.Test;

public class PromocaoTest {

	Promocao internet;
	Promocao bonus;
	Promocao minutos;
	Celular celular;
	
	@Before
	public void inicializar(){
		minutos = new Promocao("Uma Promocao de Minutos", new Date(), 0);
		internet = new Promocao("Uma Promocao de Internet", 0.5, 10, 0.125);
		bonus = new Promocao("Uma Promocao de Bonus", new Date(), 300, 10);
		celular = new Celular();
	}
	
	@Test
	public void deveCriarPromocaoDoTipoMinutos() {
		assertEquals(minutos.getTipo(), "Minutos");
	}
	
	@Test
	public void deveCriarPromocaoDoTipoInternet(){
		assertEquals(internet.getTipo(), "Internet");
	}
	
	@Test
	public void deveCriarPromocaoDoBonus(){
		assertEquals(bonus.getTipo(), "Bonus");
	}
	
	@Test
	public void deveCriarPromocaoValidaParaSmartPhone(){
		celular.setTipo("Smartphone");
		assertTrue(internet.disponivelPara(celular));
		assertTrue(minutos.disponivelPara(celular));
		assertTrue(bonus.disponivelPara(celular));
	}
	
	@Test
	public void deveCriarPromocaoValidaParaRegularPhone(){
		celular.setTipo("Regularphone");
		assertTrue(minutos.disponivelPara(celular));
		assertTrue(bonus.disponivelPara(celular));
	}
	

}
