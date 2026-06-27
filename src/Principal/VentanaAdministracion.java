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
            String tipoSeleccionado = (String) cbTipo.getSelectedItem();
            String accion = (String) cbAccion.getSelectedItem();
            System.out.println("Botón presionado. Acción a ejecutar: " + accion);
            if (tipoSeleccionado.equalsIgnoreCase("Pokemon")) {
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
    	                            	Agregador.agregarPokemon(MostrarNombre,rareza,tipoSeleccionado,daño, cant_energia);	     
    	                            	JOptionPane.showMessageDialog(null, "!" + MostrarNombre + " agregado con éxito!");
    	                            }
    	                        }
    	                    }
    	                }
                    } catch (Exception e1) {
                    	System.out.println("Error de Agregar " + e1);
                    }
                } 	
            }
            if (tipoSeleccionado.equalsIgnoreCase("Item")) {
                if (accion.equalsIgnoreCase("Agregar")) {
                	String MostrarNombre = JOptionPane.showInputDialog("Nombre");
                    try {
    	                if (MostrarNombre != null) {
    	                	String rarezaTexto = JOptionPane.showInputDialog("Nivel de Rareza");
    	                    int rareza = Integer.parseInt(rarezaTexto);
    	                    if (rareza >= 0) {
    		                	String BonTexto = JOptionPane.showInputDialog("Bonificacion");
    		                    float daño = Float.parseFloat(BonTexto);
    	                        if (daño >= 0) {
	                            	Agregador.agregarItems(MostrarNombre,rareza,tipoSeleccionado,daño);	     
	                            	JOptionPane.showMessageDialog(null, "!" + MostrarNombre + " agregado con éxito!");
    	                        }
    	                    }
    	                }
                    } catch (Exception e1) {
                    	System.out.println("Error de Agregar " + e1);
                    }
                } 	
            }
            if (tipoSeleccionado.equalsIgnoreCase("Supporter")) {
                if (accion.equalsIgnoreCase("Agregar")) {
                	String MostrarNombre = JOptionPane.showInputDialog("Nombre");
                    try {
    	                if (MostrarNombre != null) {
    	                	String rarezaTexto = JOptionPane.showInputDialog("Nivel de Rareza");
    	                    int rareza = Integer.parseInt(rarezaTexto);
    	                    if (rareza >= 0) {
    		                	String EfectoTexto = JOptionPane.showInputDialog("Efectos Por Turno");
    		                    int efecto = Integer.parseInt(EfectoTexto);
    	                        if (efecto >= 0) {
	                            	Agregador.agregarItems(MostrarNombre,rareza,tipoSeleccionado,efecto);	     
	                            	JOptionPane.showMessageDialog(null, "!" + MostrarNombre + " agregado con éxito!");
    	                        }
    	                    }
    	                }
                    } catch (Exception e1) {
                    	System.out.println("Error de Agregar " + e1);
                    }
                } 	
            }
            if (tipoSeleccionado.equalsIgnoreCase("Energy")) {
                if (accion.equalsIgnoreCase("Agregar")) {
                	String MostrarNombre = JOptionPane.showInputDialog("Nombre");
                    try {
    	                if (MostrarNombre != null) {
    	                	String rarezaTexto = JOptionPane.showInputDialog("Nivel de Rareza");
    	                    int rareza = Integer.parseInt(rarezaTexto);
    	                    if (rareza >= 0) {
    		                	String EleTexto = JOptionPane.showInputDialog("Elemento");
    		                    String elemento = EleTexto;
    	                        if (elemento != null) {
	                            	Agregador.agregarEnergia(MostrarNombre,rareza,tipoSeleccionado,elemento);	     
	                            	JOptionPane.showMessageDialog(null, "!" + MostrarNombre + " agregado con éxito!");
    	                        }
    	                    }
    	                }
                    } catch (Exception e1) {
                    	System.out.println("Error de Agregar " + e1);
                    }
                } 	
            }
        });
    }
}