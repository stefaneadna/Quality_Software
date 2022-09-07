package negocio;

public class Locacao {

	protected Cliente cliente;
	protected Filme filme;
	protected double valorAluguel;
	protected Horario horario;
	
	public void alugar(Cliente c, Filme f,Horario h) {
		this.cliente = c;
		this.filme = f;
		this.horario = h;
	}
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel=valorAluguel;
	}
}
