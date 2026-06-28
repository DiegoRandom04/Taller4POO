package Principal;

//clase tipo Item

public class Items extends Carta {
	//Atributos de Item
	private int bonificacion;
	@Override
	//Calculo del puntaje para tipo Item (bonificacion * 20)
	public float calcularPuntaje() {
		return bonificacion * 20;
	}
	//creamos el constructor para items
	public Items(String nombre, int rareza, String tipo, int bonificacion ) {
		super(nombre, rareza, tipo);
	}
}