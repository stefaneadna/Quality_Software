package negocio;

public class Filme {

	protected String nome;
	protected int id;
	protected double valorCompra;
	protected Genero genero;

	public Filme(String nome, Genero genero) {
		this.nome = nome;
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorCompra);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Filme other = (Filme) obj;
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass() || genero != other.genero || id != other.id )
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(valorCompra) != Double.doubleToLongBits(other.valorCompra))
			return false;
		return true;
	}

}
