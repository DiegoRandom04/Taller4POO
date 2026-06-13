package Principal;

public class Carta {
	private String nombre;
	private float rareza;
	private String tipo;
	private float poder;
	
	public float getPoder() {
		return poder;
	}
	public Carta (String nombre, float rareza, String tipo) {
		this.nombre = nombre;
		this.rareza = rareza;
		this.tipo = tipo;
	}
	public String getNombre() {
		/* @return String
		 * se usa para obtener el nombre
		 */
		
		return nombre;
	}
	public void setNombre(String nombre) {
		/*@ return void
		 *  se usa para reasignar el nombre
		 */
		this.nombre = nombre;
	}
	public float getRareza() {
		/* @ return float
		 * se usa para obtener rareza
		 */
		return rareza;
	}
	public void setRareza(float rareza) {
		/* @return void
		 * se usa para reasignara rareza;
		 */
		
		this.rareza = rareza;
	}
	public String getTipo() {
		/*@return String
		 * se usa para obtener el tipo
		 */
		return tipo;
	}
	public void setTipo(String tipo) {
		/* @return void
		 * se usa para reasignar el tipo
		 */
		this.tipo = tipo;
	}
}