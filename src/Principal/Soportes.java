package Principal;

public class Soportes extends Carta{
	private int efectosPorTurno;
	public Soportes(String nombre, int rareza, String tipo, int efectosPorTurno) {
		super(nombre, rareza, tipo);
		// TODO Auto-generated constructor stub
	}
	@Override
	public float calcularPuntaje() {
		return efectosPorTurno * 50f;
	}
	
}