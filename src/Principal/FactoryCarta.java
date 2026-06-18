package Package1;

public interface FactoryCarta {
	public Pokemon crearPokemon(String nombre, float rareza, String tipo, float daño, float cantEnergias);
	
	public Item crearItem(String nombre, float rareza, String tipo, float bonificacion);
	
	public Supporter crearSupporter(String nombre, float rareza, String tipo, float efectosPorTurno);
}	
