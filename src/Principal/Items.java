package Principal;

public class Items extends Carta {
	private int bonificacion;
	@Override
	public float calcularPuntaje() {
		return bonificacion * 20f;
	}
	public Items(String nombre, int rareza, String tipo, int bonificacion ) {
		super(nombre, rareza, tipo);
		// TODO Auto-generated constructor stub
	}
}