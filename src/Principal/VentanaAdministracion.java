package Principal;

import javax.swing.*;
import java.awt.*;

public class VentanaAdministracion extends JPanel {
    private JComboBox<String> cbAccion;
    private JComboBox<String> cbTipo;
    private JButton btnEjecutar;
    public VentanaAdministracion() {
    	BorderLayout orden = new BorderLayout();
        setLayout(new BorderLayout());
        JPanel panelTop = new JPanel();
        cbAccion = new JComboBox<>(new String[]{"Agregar", "Modificar", "Eliminar"});
        panelTop.add(new JLabel("Acción:"));
        panelTop.add(cbAccion);
        add(panelTop, BorderLayout.NORTH);
        JPanel panelCentro = new JPanel(new GridLayout(4, 2));
        cbTipo = new JComboBox<>(new String[]{"Pokemon", "Item", "Supporter", "Energy"});
        panelCentro.add(new JLabel("Tipo:"));
        panelCentro.add(cbTipo);
        add(panelCentro, BorderLayout.CENTER);
        JPanel panelBottom = new JPanel();
        btnEjecutar = new JButton("Ejecutar Acción");
        panelBottom.add(btnEjecutar);
        add(panelBottom, BorderLayout.EAST);
        configurarEventos();
    }

    private void configurarEventos() {
        cbTipo.addActionListener(e -> {
            String tipoSeleccionado = (String) cbTipo.getSelectedItem();
            System.out.println("Tipo cambiado a: " + tipoSeleccionado);
        });

        btnEjecutar.addActionListener(e -> {
            String accion = (String) cbAccion.getSelectedItem();
            System.out.println("Botón presionado. Acción a ejecutar: " + accion);
            if (accion.equalsIgnoreCase("Agregar")) {
            	String MostrarNombre = JOptionPane.showInputDialog("Nombre");
                try {
	                if (MostrarNombre != null) {
	                	String rarezaTexto = JOptionPane.showInputDialog("Nivel de Rareza");
	                    int rareza = Integer.parseInt(rarezaTexto);
	                    if (rareza >= 0) {
		                	String DañoTexto = JOptionPane.showInputDialog("Daño");
		                    int daño = Integer.parseInt(DañoTexto);
	                        if (daño >= 0) {
	    	                	String EnergiaTexto = JOptionPane.showInputDialog("Cantidad de Energía");
	    	                    int cant_energia = Integer.parseInt(EnergiaTexto);
	                            if (cant_energia >= 0) {
	                            	Sistema.getInstance().agregarItem(MostrarNombre,rareza,"Pokemon",daño, cant_energia);	     
	                            	JOptionPane.showMessageDialog(null, "!" + MostrarNombre + " agregado con éxito!");
	                            }
	                        }
	                    }
	                }
                } catch (Exception e1) {
                	System.out.println("Error de Agregar " + e1);
                }
            } 
        });
    }
}