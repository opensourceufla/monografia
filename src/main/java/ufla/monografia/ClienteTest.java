package ufla.monografia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import lib.Celular;
import lib.Cliente;
import lib.Endereco;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	ArrayList<Celular> celulares;
	Endereco endereco;
	
	@Before
	public void initialize(){
		celulares = new ArrayList<Celular>();
		celulares.add(new Celular());
		celulares.add(new Celular());
		endereco = new Endereco();
	}
	
	@Test
	public void deveCriarNovoCliente() {
		Cliente cliente = new Cliente();
		assertNotNull(cliente);
	}
	
	@Test
	public void deveCriarNovoClienteComCelulares(){
		Cliente cliente = new Cliente(celulares, "Julio", endereco);
		assertNotNull(cliente);
		assertFalse(cliente.getCelulares().isEmpty());
	}

}
