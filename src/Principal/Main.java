package Principal;

public class Main {
	public static void main(String[] args) {
		Sistema.getInstance();
		Sistema.getInstance().leerArchivo();
		Ventana ventana = new Ventana();
		ventana.setVisible(true);	
	}
}