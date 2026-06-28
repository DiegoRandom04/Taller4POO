package Principal;

//clase tipo soportes

public class Soportes extends Carta {
	//Atributos de soporte
	private int efectosPorTurno;
	//creamos el constructor para soportes
	public Soportes(String nombre, int rareza, String tipo, int efectosPorTurno) {
		super(nombre, rareza, tipo);
	}
	@Override
	//Calculo del puntaje para tipo soporte (efectos por turno * 50)
	public float calcularPuntaje() {
		return efectosPorTurno * 50;
	}
	
}