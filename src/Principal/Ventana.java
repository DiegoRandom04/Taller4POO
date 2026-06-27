package Principal;

import javax.swing.*;

public class Ventana extends JFrame {

    private VentanaAdministracion panelAdmin;
    private VentanaColeccion panelColeccion;

    public Ventana() {
        setTitle("Pokémon TCG - Gestor de Colección");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JTabbedPane pestañas = new JTabbedPane();
        panelAdmin = new VentanaAdministracion();
        panelColeccion = new VentanaColeccion();
        
        pestañas.addTab("Administración", panelAdmin);
        pestañas.addTab("Ver Colección", panelColeccion);

        pestañas.addChangeListener(e -> {
            if (pestañas.getSelectedIndex() == 1) {
                System.out.println("Cambiando a pestaña Colección. Actualizando vista...");
                VentanaColeccion v = new VentanaColeccion();
            }
        });

        add(pestañas);
    }
}