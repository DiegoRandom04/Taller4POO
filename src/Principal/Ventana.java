package Principal;

import javax.swing.*;

//creamos la clase ventana

public class Ventana extends JFrame {
	//atributos de ventana
    private VentanaAdministracion panelAdmin;
    private VentanaColeccion panelColeccion;
    //contructor de ventana
    public Ventana() {
    	//forzamos a cambiar el nombre del titulo
        setTitle("Pokémon TCG - Gestor de Colección");
    	//forzamos el tamaño de la ventana principal
        setSize(800, 600);
    	//en caso de cerrar el programa, no se sigue corriendo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//poner en el centro de la pantalla
        setLocationRelativeTo(null);
    	//crear pestaña
        JTabbedPane pestañas = new JTabbedPane();
    	//crear panel administrador
        panelAdmin = new VentanaAdministracion();
    	//crear panel coleccionista
        panelColeccion = new VentanaColeccion();
    	//añadimos ambos paneles
        pestañas.addTab("Administración", panelAdmin);
        pestañas.addTab("Ver Colección", panelColeccion);
    	//capturamos con el mouse
        pestañas.addChangeListener(e -> {
            if (pestañas.getSelectedIndex() == 1) {
            	//cambia a pestaña coleccion
                System.out.println("Cambiando a pestaña Colección. Actualizando vista...");
            	//creamos la ventana coleccion
                VentanaColeccion v = new VentanaColeccion();
            }
        });
    	//añadimos las pestañas
        add(pestañas);
    }
}