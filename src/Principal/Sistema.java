package Package1;

public class Sistema implements FactoryCarta {
	private static Sistema instancia; //estático ya que pertenece a la clase, no es instanciable
	//la variable instancia queda reservada a la clase por lo que es visible por todo hacia abajo jerárquicamente y eso significa que no se podra usar la misma variable como solo local en alguna parte
	private Sistema() {};
	
	public static Sistema getInstancia() {
		/* Esta variable es para el singleton de Sistema;
		 * @return Sistema
		 */
		if (instancia == null) {// si la instancia no se ha creado, se procede a crear y posterior se retorna
			instancia = new Sistema();
			return instancia;
		}
		else {
			return instancia;// como la instancia ya esta creada que retorne esta
		}
	}

	@Override
	public Pokemon crearPokemon(String nombre, float rareza, String tipo, float daño, float cantEnergias) {
		/* Es parte del factory, se crea dentro de sistema y factory es una interfaz
		 * @return Pokemon
		 */
		
		Pokemon pokemon = new Pokemon (nombre, rareza , tipo, daño, cantEnergias);
		
		return pokemon;
	}

	@Override
	public Item crearItem(String nombre, float rareza, String tipo, float bonificacion) {
		/* Parte del factory
		 * @return Item
		 */
		Item item = new Item(nombre, rareza, tipo, bonificacion);
		return item;
	}

	@Override
	public Supporter crearSupporter(String nombre, float rareza, String tipo, float efectosPorTurno) {
		/* Parte del factory
		 * @return Supporter
		 */  
		Supporter supporter = new Supporter (nombre, rareza, tipo, efectosPorTurno);
		
		return supporter;
	}
	
	
	
	
}
