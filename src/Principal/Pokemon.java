package Principal;

public class Pokemon extends Carta {
	private float daño;
	private float cantEnergias;
	private float poder;
	public Pokemon(String nombre, float rareza, String tipo, float daño, float cantEnergias) {
		/* @param nombre es el nombre de la carta y se le asigna a la clase padre Carta
		 * @param rareza es la rareza de la carta y se le asigna a la clase padre Carta
		 * @param tipo es el tipo de carta y se le asigna a la clase padre Carta
		 * @param daño es el daño de este tipo de carta pokemon
		 * @param cantEnergias es otro parametro a utilzar para el calculo de poder de esta carta
		 */
		super(nombre,rareza,tipo);
		
		this.daño = daño;
		this.cantEnergias = cantEnergias;
	}
	public float calcularPuntaje() {
		/* @return void 
		 * calcularPuntaje no tiene parametros de entrada ya que son los que pertenecen a la misma instancia
		 * para calcular el puntaje en el caso de pokemon se usa (daño/cantEnergias)*100 segun lo informado
		 * en la descripción del taller. en caso de otros tipos tendran otro metodo de calcular puntaje
		 */
		this.poder = (daño/cantEnergias)*100; 
		return this.poder;
	}
	

}