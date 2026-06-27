package Principal;

public class Energia extends Carta{
	private String elemento;
	@Override
	public float calcularPuntaje() {
		return 1f;
	}
	public Energia(String nombre, int rareza, String tipo, String elemento) {
		super(nombre, rareza, tipo);
		// TODO Auto-generated constructor stub
	}
	

}