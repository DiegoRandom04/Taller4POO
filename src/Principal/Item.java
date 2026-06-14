package Package1;

public class Item extends Carta{
	//clase hijo de carta
	
	private float bonificacion;
	public Item(String nombre, float rareza, String tipo, float bonificacion) {
		super(nombre, rareza, tipo);
		this.bonificacion = bonificacion;
	}
	
	public void calcularPuntaje() {
		this.poder = bonificacion*20;
		
	}
	
	
	
	
	
	
	
	
	
	
}
