package Principal;


import Principal.Carta;
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
        String rutaImagen = carta.getNombre() + ".jpg";
        for (String ext : extensiones) {
            File archivo = new File(carta.getNombre() + ext);
            if (archivo.exists()) {
                rutaImagen = carta.getNombre() + ext; 
                break;
            }
        }
        ImageIcon icono = new ImageIcon(rutaImagen);
        JLabel lblImagen = new JLabel(icono, SwingConstants.CENTER); 
        add(lblImagen, BorderLayout.CENTER); 
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
}