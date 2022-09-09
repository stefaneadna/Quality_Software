package negocio;

import java.util.ArrayList;

public class Cliente {

	protected String nome;
	protected int id;
	protected String status;
	protected ArrayList<Filme> filmesFavoritos = new ArrayList<Filme>();
	
	public Cliente(String nome, int id,String status) {
		this.nome= nome;
		this.id= id;
		this.status = status;
	}
	public boolean statusCliente() {
		if(this.status=="Inativo") {
			return true;
		}
		else {
			return false;
		}
	}
	public void addFilmesFavoritos(Filme filme) {
		filmesFavoritos.add(filme);
	}
}
