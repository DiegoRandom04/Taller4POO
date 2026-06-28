package Principal;

import javax.swing.*;
import java.awt.*;

// clase Ventana Administracion

public class VentanaAdministracion extends JPanel {
	//atributos de ventana administrador
    private JComboBox<String> cbAccion;
    private JComboBox<String> cbTipo;
    private JButton btnEjecutar;
    //constructor de Ventana Administracion
    public VentanaAdministracion() {
    	//seteamos el layout
        setLayout(new BorderLayout());
    	//creamos el panel
        JPanel panelTop = new JPanel();
    	//agregamos las opciones
        cbAccion = new JComboBox<>(new String[]{"Agregar", "Modificar", "Eliminar"});
    	//agregamos la accion a modificar
        panelTop.add(new JLabel("Acción:"));
    	//agregamos el Jlabel de accion
        panelTop.add(cbAccion);
    	//agregamos el panel del norte
        add(panelTop, BorderLayout.NORTH);
    	//agregamos el panel central
        JPanel panelCentro = new JPanel(new GridLayout(4, 2));
    	//agregamos el tipo a modificar, sea pokemon, item, soporte o energia
        cbTipo = new JComboBox<>(new String[]{"Pokemon", "Item", "Supporter", "Energy"});
    	//agregamos el tipo a modificar
        panelCentro.add(new JLabel("Tipo:"));
    	//agregamos el Jlabel del tipo
        panelCentro.add(cbTipo);
    	//agregamos el Jlabel del tipo en el centro
        add(panelCentro, BorderLayout.CENTER);
    	//agregamos un boton
        JPanel panelBottom = new JPanel();
    	//agregamos el boton de ejecutar la accion
        btnEjecutar = new JButton("Ejecutar Acción");
    	//añadimos el boton
        panelBottom.add(btnEjecutar);
    	//agregamos el boton en el este
        add(panelBottom, BorderLayout.EAST);
    	//llamamos a configurar eventos
        configurarEventos();
    }
	//configuramos al mouse listener
    private void configurarEventos() {
    	//cambiamos el tipo
        cbTipo.addActionListener(e -> {
            String tipoSeleccionado = (String) cbTipo.getSelectedItem();
            System.out.println("Tipo cambiado a: " + tipoSeleccionado);
        });
    	//aqui el boton ejecutar para agregar modificar y eliminar
        btnEjecutar.addActionListener(e -> {
        	//seleccionamos el tipo
            String tipoSeleccionado = (String) cbTipo.getSelectedItem();
        	//filtramos la accion
            String accion = (String) cbAccion.getSelectedItem();
            System.out.println("Botón presionado. Acción a ejecutar: " + accion);
        	//si el tipo es pokemon
            if (tipoSeleccionado.equalsIgnoreCase("Pokemon")) {
            	//si la accion es agregar
                if (accion.equalsIgnoreCase("Agregar")) {
                	//creamos el nombre
                	String MostrarNombre = JOptionPane.showInputDialog("Nombre");
                    try {
                    	//si el nombre es diferente de null
    	                if (MostrarNombre != null) {
                        	//creamos la rareza
    	                	String rarezaTexto = JOptionPane.showInputDialog("Nivel de Rareza");
    	                	//convertimos de texto a entero
    	                    int rareza = Integer.parseInt(rarezaTexto);
                        	//si la rareza es mayor igual que cero
    	                    if (rareza >= 0) {
                            	//creamos el daño
    		                	String DañoTexto = JOptionPane.showInputDialog("Daño");
    		                	//convertimos de texto a entero
    		                    int daño = Integer.parseInt(DañoTexto);
                            	//si la rareza es mayor igual que cero
    	                        if (daño >= 0) {
    	                        	//creamos la energia
    	    	                	String EnergiaTexto = JOptionPane.showInputDialog("Cantidad de Energía");
    	                        	//convertimos texto a entero
    	    	                    int cant_energia = Integer.parseInt(EnergiaTexto);
    	                        	//si la energia es mayor igual que cero
    	                            if (cant_energia >= 0) {
    	                            	//agregamos
    	                            	Agregador.agregarPokemon(MostrarNombre,rareza,tipoSeleccionado,daño, cant_energia);	 
    	                            	//mostramos la ventana exitosa
    	                            	JOptionPane.showMessageDialog(null, "!" + MostrarNombre + " agregado con éxito!");
    	                            }
    	                        }
    	                    }
    	                }
    	            //en caso de error
                    } catch (Exception e1) {
                    	//imprimimos
                    	System.out.println("Error de Agregar " + e1);
                    }
                } 	
            }
            //si el tipo seleccionado es de item
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
            //si el tipo seleccionado es de soporte
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
            //si el tipo seleccionado es de energia
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