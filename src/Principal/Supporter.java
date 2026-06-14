package Package1;

public class Supporter extends Carta{
	//clase hijo de carta
	
	private float efectosPorTurno;
	public Supporter(String nombre, float rareza, String tipo, float efectosPorTurno) {
		super(nombre, rareza, tipo);
		this.efectosPorTurno = efectosPorTurno;
	}
	
	public void calcularPuntaje() {
		this.poder = efectosPorTurno*50;
		
		
	}
	
}
