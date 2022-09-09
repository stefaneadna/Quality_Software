package negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LocacaoTest {
	Transacao transacao;
	Locacao locacao1;
	Filme filme1;
	Cliente cliente1;
	@Before
	public void setUp() throws Exception {
		transacao = new Transacao();
		locacao1 = new Locacao();
		filme1 = new Filme("Java", Genero.ROMANCE);
		filme1.valorCompra = 100;

		
		Horario horario1 = new Horario("07/09/2022","19:07");		
		cliente1 = new Cliente("Izaias", 2,"Ativo");	
		
		if(!cliente1.statusCliente()) {
			locacao1.alugar(cliente1, filme1,horario1);
		}
		
	}

	
	@Test
	public void horarioTest() {
		assertEquals("07/09/2022", locacao1.horario.data); 
		assertEquals("19:07", locacao1.horario.hora); 
	}
}
