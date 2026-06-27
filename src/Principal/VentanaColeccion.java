package Principal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaColeccion extends JPanel {

    private JPanel panelGrilla;
    private JButton btnOrdRareza, btnOrdNombre, btnOrdPoder;
	private ArrayList<Carta> cartas;
	public ArrayList<Carta> getCartas() {
	    return this.cartas; 
	}

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
        	panelGrilla.removeAll();
            actualizarVista();
        });

        btnOrdNombre.addActionListener(e -> {
            System.out.println("Botón: Ordenar por Nombre");
            Sistema.getInstance().ordenarCartasPorNombre();
        	panelGrilla.removeAll();
            actualizarVista();
        });

        btnOrdPoder.addActionListener(e -> {
            System.out.println("Botón: Ordenar por Poder");
            Sistema.getInstance().ordenarCartasPorPoder();
        	panelGrilla.removeAll();
            actualizarVista();
        });
    }

    public void actualizarVista() {
    	panelGrilla.removeAll();
        for (Carta carta : Sistema.getInstance().getCartas()) {
        	JTextArea tarjetaCarta = new JTextArea(carta.getNombre() + " - " + carta.getPoder());
        	tarjetaCarta.setEditable(false);
        	MostrarCarta m = new MostrarCarta(carta);
            panelGrilla.add(m);
        }
        panelGrilla.revalidate();
        panelGrilla.repaint();
    }
}