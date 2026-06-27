package Principal;

public class FactoryCarta {
	public static Carta getCarta(String nombre, int rareza, String tipo, String extra1, String extra2)
	{
		if ("pokemon".equalsIgnoreCase(tipo)) return new Pokemon(nombre, rareza, tipo, Integer.parseInt(extra1),Integer.parseInt(extra2)) ;
		else if ("item".equalsIgnoreCase(tipo)) return new Items(nombre, rareza, tipo, Integer.parseInt(extra1));
		else if ("supporter".equalsIgnoreCase(tipo)) return new Soportes(nombre, rareza, tipo,Integer.parseInt(extra1));
		else if ("energy".equalsIgnoreCase(tipo)) return new Energia(nombre, rareza, tipo, extra1);
		else {
			return null;	
		}
	}

}