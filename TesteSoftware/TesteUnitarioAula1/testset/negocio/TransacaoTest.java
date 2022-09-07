package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import negocio.Cliente;
import negocio.Filme;
import negocio.Genero;
import negocio.Locacao;
import negocio.Transacao;

public class TransacaoTest {

	Transacao transacao;
	Locacao locacao1;
	Locacao locacao2;
	Filme filme1;
	Filme filme2;

	@Before
	public void setUp() throws Exception {
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		filme1 = new Filme("Java", Genero.ROMANCE);
		filme1.valorCompra = 100;

		filme2 = new Filme("JavaScript", Genero.ROMANCE);
		filme2.valorCompra = 50;
		filme2.id=20;
		
		Horario horario1 = new Horario("07/09/2022","19:07");
		Horario horario2 = new Horario("16/01/2022","20:07");
		
		Cliente cliente1 = new Cliente("Izaias", 2,"Ativo");
		Cliente cliente2 = new Cliente("Thiago", 3,"Ativo");
		Cliente cliente3 = new Cliente("Thiago", 4,"Inativo");
		
		//testa o status do cliente
		assertEquals(true, cliente3.statusCliente());
		assertEquals(false, cliente2.statusCliente());
		
		//assertEquals(true,loca)
		if(!cliente1.statusCliente()) {
			locacao1.alugar(cliente1, filme1,horario1);
		}
		if(!cliente2.statusCliente()) {
			locacao2.alugar(cliente2, filme2,horario2);
		}
		if(!cliente3.statusCliente()) {
			locacao2.alugar(cliente3, filme2,horario2);
		}
		
		
		//teste do horário
		assertEquals("07/09/2022", locacao1.horario.data); 
		assertEquals("20:07", locacao2.horario.hora); 
		

		transacao = new Transacao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void valorLocacaoTotalTest() {

		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		assertEquals(transacao.alugueis.get(0).cliente.nome, "Izaias");
		assertTrue("Filme deveria ser selecionado corretamente",transacao.alugueis.get(1).filme.id==20);
		assertEquals(150, transacao.valorLocacaoTotal(), 0.1);
	}

	@Test
	public void valorLocacaoTotalTest2() {

		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		transacao.alugueis.add(locacao2);
		assertEquals(200, transacao.valorLocacaoTotal(), 0.1);
	}

	@Test 
	public void buscaClienteIdTest() {
		
		transacao.alugueis.add(locacao2);
		assertEquals("Thiago",transacao.buscaCliente(3).nome);
	}
	
	@Test 
	public void calculoLucroTest() {
		
		locacao2.setValorAluguel(25);
		transacao.alugueis.add(locacao2);
		
		assertEquals(50,transacao.calculoLucro(20),0.01);
	}
	public void test1() {

		assertEquals(Math.PI, 3.14, 0.01); 
		assertTrue("java".equalsIgnoreCase("Java"));
		Filme f =new Filme("a", Genero.ROMANCE);
		assertNull(f); // assertNotNull();
		Filme f2 =new Filme("a", Genero.ROMANCE);

		assertTrue(f==f2);
		
		assertSame(f, f2); // asserNotSame)();

		assertTrue("Comparacao de objetos", f == f2);

	}

}
