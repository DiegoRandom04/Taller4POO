package Package1;

public class Energy	extends Carta {
	//clase hijo de carta
	
	private String elemento;
	public Energy(String nombre, float rareza, String tipo, String elemento) {
		super(nombre, rareza, tipo);
		this.elemento = elemento;
	}
	public void calcularPuntaje() {
		this.poder = 1;
	}
	
	
	
}
