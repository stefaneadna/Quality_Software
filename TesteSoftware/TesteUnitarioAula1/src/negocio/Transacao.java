package negocio;

import java.util.ArrayList;
import java.util.HashMap;

public class Transacao {

	protected  ArrayList<Locacao> alugueis;
	protected HashMap<Genero, Integer> descontoGenero = new HashMap<Genero, Integer>();
	
	public Transacao() {
		
		alugueis= new ArrayList<Locacao>();
	}
	
	public double valorLocacaoTotal() { 
	    double valor=0;
		for (Locacao locacao : alugueis) {
			valor += locacao.filme.valorCompra;
		}
		return valor;
	}
	
	public Cliente buscaCliente(int id) {
		for (Locacao locacao : alugueis) {
			if(locacao.cliente.id==id) { 
				return locacao.cliente;
			}
			
		}
		return null;
	}
	public double calculoLucro(int filmeId) {
		double valor=0;
		Filme aux = null;
		for (Locacao locacao : alugueis) {
			if(locacao.filme.id==filmeId) {
				valor += locacao.valorAluguel;
				aux = locacao.filme;
			}
			
		}
		return (valor*100)/aux.valorCompra;
	}
	public Genero contGenero() {
		HashMap<Genero, Integer> cont_genero = new HashMap<Genero, Integer>();
		int cont = 1;
		int maiorValor = 0;
		Genero generoMaiorValor = null;
		for (Locacao locacao : alugueis) {
			if(cont_genero.get(locacao.filme.genero)==null) {
				cont_genero.put(locacao.filme.genero, cont);
			}else {
				cont = cont_genero.get(locacao.filme.genero);
				cont++;
				cont_genero.put(locacao.filme.genero, cont);
				if(cont>maiorValor) {
					generoMaiorValor = locacao.filme.genero;
					maiorValor = cont;
				}
			}
		}
		return generoMaiorValor;
	}
	public void valorDescontoGenero(Genero genero, int desconto) {
		descontoGenero.put(genero,desconto);
	}
	
	
}
