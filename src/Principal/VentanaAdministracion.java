package Principal;

import javax.swing.*;
import java.awt.*;

public class VentanaAdministracion extends JPanel {
    private JComboBox<String> cbAccion;
    private JComboBox<String> cbTipo;
    private JButton btnEjecutar;
    public VentanaAdministracion() {
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
        add(panelBottom, BorderLayout.SOUTH);
        configurarEventos();
    }

    private void configurarEventos() {
        cbTipo.addActionListener(e -> {
            String tipoSeleccionado = (String) cbTipo.getSelectedItem();
            System.out.println("Tipo cambiado a: " + tipoSeleccionado);
            // TODO: Ocultar o mostrar campos extra dependiendo del tipo
        });

        btnEjecutar.addActionListener(e -> {
            String accion = (String) cbAccion.getSelectedItem();
            System.out.println("Botón presionado. Acción a ejecutar: " + accion);
            
        });
    }
}