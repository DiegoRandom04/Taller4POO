package Principal;

//Clase Principal a Ejecutar el Programa

public class Main {
	public static void main(String[] args) {
		//patron singleton, una única instancia, documentado en sistema
		Sistema.getInstance();
		//leer el archivo antes de la Ventana
		Sistema.getInstance().leerArchivo();
		//crear Ventana
		Ventana ventana = new Ventana();
		//ver la ventana
		ventana.setVisible(true);	
	}
}