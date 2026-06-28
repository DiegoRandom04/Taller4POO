package Principal;

public class FactoryCarta {
	//para generar la carta
	public static Carta getCarta(String nombre, int rareza, String tipo, String extra1, String extra2)
	{
		//si es de tipo Pokemon, agregamos un nuevo pokemon
		if ("pokemon".equalsIgnoreCase(tipo)) return new Pokemon(nombre, rareza, tipo, Integer.parseInt(extra1),Integer.parseInt(extra2));
		//si es de tipo Item, agregamos un nuevo Item
		else if ("item".equalsIgnoreCase(tipo)) return new Items(nombre, rareza, tipo, Integer.parseInt(extra1));
		//si es de tipo Soporte (Supporter), agregamos un nuevo Soporte (Supporter)
		else if ("supporter".equalsIgnoreCase(tipo)) return new Soportes(nombre, rareza, tipo,Integer.parseInt(extra1));
		//si es de tipo Energía, agregamos un nuevo pokemon
		else if ("energy".equalsIgnoreCase(tipo)) return new Energia(nombre, rareza, tipo, extra1);
		//si es de otro tipo, retornamos null.
		else {
			return null;	
		}
	}

}