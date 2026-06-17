package Principal;

import javax.swing.*;
import java.awt.*;

public class VentanaColeccion extends JPanel {

    private JPanel panelGrilla;
    private JButton btnOrdRareza, btnOrdNombre, btnOrdPoder;

    public VentanaColeccion() {
        setLayout(new BorderLayout());
        JPanel panelBotones = new JPanel();
        btnOrdRareza = new JButton("Ordenar por Rareza");
        btnOrdNombre = new JButton("Ordenar por Nombre");
        btnOrdPoder = new JButton("Ordenar por Poder");

        panelBotones.add(btnOrdRareza);
        panelBotones.add(btnOrdNombre);
        panelBotones.add(btnOrdPoder);
        add(panelBotones, BorderLayout.NORTH);

        panelGrilla = new JPanel(new GridLayout(0, 4, 10, 10)); 
        JScrollPane scroll = new JScrollPane(panelGrilla);
        add(scroll, BorderLayout.CENTER);
        configurarEventos();
    }

    private void configurarEventos() {
        btnOrdRareza.addActionListener(e -> {
            System.out.println("Botón: Ordenar por Rareza");
            Sistema.getInstance().ordenarCartasPorRareza();
            actualizarVista();
        });

        btnOrdNombre.addActionListener(e -> {
            System.out.println("Botón: Ordenar por Nombre");
            Sistema.getInstance().ordenarCartasPorNombre();
            actualizarVista();
        });

        btnOrdPoder.addActionListener(e -> {
            System.out.println("Botón: Ordenar por Poder");
            Sistema.getInstance().ordenarCartasPorPoder();
            actualizarVista();
        });
    }

    public void actualizarVista() {
    	panelGrilla.removeAll(); 
        for (Carta carta : Sistema.getInstance().leerArchivo()) {
            JButton tarjetaCarta = new JButton(carta.getNombre() + " - " + carta.getPoder());
            panelGrilla.add(tarjetaCarta);
        }
        panelGrilla.revalidate();
        panelGrilla.repaint();
    }
}