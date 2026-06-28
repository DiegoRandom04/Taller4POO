package Principal;

//clase tipo energía

public class Energia extends Carta {
	//atributos de Energía
	private String elemento;
	@Override
	//Calculo del puntaje para tipo energía (por defecto 1)
	public float calcularPuntaje() {
		return 1;
	}
	public Energia(String nombre, int rareza, String tipo, String elemento) {
		super(nombre, rareza, tipo);
		// TODO Auto-generated constructor stub
	}
	

}