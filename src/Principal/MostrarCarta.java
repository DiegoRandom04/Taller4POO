package Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class MostrarCarta extends JPanel {

    private Carta cartaRepresentada;
    String[] extensiones = {".jpg", ".png", ".jpeg", ".webp"};
    
    public MostrarCarta(Carta carta) {
        this.cartaRepresentada = carta;
        
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(120, 180));
        String rutaImagen = "default.png";
        for (String ext : extensiones) {
            File archivo = new File(carta.getNombre() + ext);
            if (archivo.exists()) {
                rutaImagen = carta.getNombre() + ext; 
                break;
            }
        }
        ImageIcon iconoOriginal = new ImageIcon(rutaImagen);
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(120, 150, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
        JLabel lblImagen = new JLabel(iconoRedimensionado, SwingConstants.CENTER); 
        add(lblImagen, BorderLayout.CENTER);  
        JLabel lblNombre = new JLabel(carta.getNombre(), SwingConstants.CENTER);
        add(lblNombre, BorderLayout.SOUTH);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Clic en la carta: " + cartaRepresentada.getNombre());
                VentanaOtra dialog = new VentanaOtra(cartaRepresentada);
                dialog.setVisible(true);
            }
        });
    }
    public String RetornoNombre(Carta carta) {
    	String resultado = "default.png";
        String[] extensiones = {".jpg", ".png", ".jpeg", ".webp"};
        for (String ext : extensiones) {
            File archivo = new File(carta.getNombre() + ext);
            if (archivo.exists()) {
                resultado = carta.getNombre() + ext; 
                return resultado;
            }
        }
    	return resultado;
    }
}