package negocio;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	Cliente cliente;
	Cliente cliente2;
	
	@Before
	public void setUp() throws Exception {
		cliente = new Cliente("Stefane Adna",5,"Ativo");
		cliente2 = new Cliente("João",8,"Inativo");
	}

	@Test
	public void testCliente() {
		assertEquals("Stefane Adna", cliente.nome);
		assertEquals(5, cliente.id);
	}
	@Test
	public void statusClienteTest() {
		//testa o status do cliente
		cliente2 = new Cliente("João",8,"Inativo");
		assertEquals(true, cliente2.statusCliente());
		assertEquals(false, cliente.statusCliente());
	}

}

