package Package1;

public class FactoryCarta {
	private static FactoryCarta instanciaFactory;
		// solo debe haber una sola instancai Factory por lo que se hace una mezcla entre Factory y singleton al mismo timepo
		private FactoryCarta () {
			// constructror privado para restringir la creacion a1 sola con el metodo getInstancia();
		}
	public static FactoryCarta getInstancia() {
		if (instanciaFactory == null) {
			instanciaFactory = new FactoryCarta();
			return instanciaFactory;
		}else {
			return instanciaFactory;// el unico caso posible es o que sea nulo o no nulo por lo que si no es nulo(que si existe la instancia) se retorne la instancia
		}
	}
	
	public Pokemon crearPokemon(String nombre, float rareza, String tipo, float daño, float cantEnergias) {
		Pokemon pokemon = new Pokemon(nombre, rareza,tipo,daño,cantEnergias);
		return pokemon;
	}
	
	public Item crearItem(String nombre, float rareza, String tipo, float bonificacion) {
		Item item = new Item(nombre,rareza,tipo,bonificacion);
		return item;
		
	}
	
	public Supporter crearSupporter(String nombre, float rareza, String tipo, float efectosPorTurno) {
		Supporter supporter = new Supporter(nombre, rareza, tipo, efectosPorTurno);
		return supporter;
		
	}
	
	
}	
