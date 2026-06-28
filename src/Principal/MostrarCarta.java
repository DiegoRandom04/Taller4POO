package Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

//clase Mostrar Carta

public class MostrarCarta extends JPanel {

    private Carta cartaRepresentada;
	//Mostrar las extensiones disponibles (.jpg, .png, .jpeg y .webp)
    String[] extensiones = {".jpg", ".png", ".jpeg", ".webp"};
	//crear constructor de Mostrar Carta
    public MostrarCarta(Carta carta) {
        this.cartaRepresentada = carta;
        //poner el layout
        setLayout(new BorderLayout());
        //poner los bordes a negro
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//poner dimensiones a 120 x 180 por carta
        setPreferredSize(new Dimension(120, 180));
		//la ruta por defecto de la imagen es default.png, esa imagen por defecto
        String rutaImagen = "default.png";
        //recorre ciclo for para ver las extenciones
        for (String ext : extensiones) {
            //abre el archivo
            File archivo = new File(carta.getNombre() + ext);
            //si existe el archivo
            if (archivo.exists()) {
                //se sobreescribe la ruta imagen por esta
                rutaImagen = carta.getNombre() + ext; 
                //como encontramos una imagen, rompemos
                break;
            }
        }
        //se crea el Icono
        ImageIcon iconoOriginal = new ImageIcon(rutaImagen);
        //se escala el Icono
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(120, 150, Image.SCALE_SMOOTH);
        //se redimensiona el icono
        ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
        //se agrega la imagen al JLabel
        JLabel lblImagen = new JLabel(iconoRedimensionado, SwingConstants.CENTER);
        //se agrega la imagen
        add(lblImagen, BorderLayout.CENTER);  
        //se agrega el Nombre al JLabel
        JLabel lblNombre = new JLabel(carta.getNombre(), SwingConstants.CENTER);
        //se agrega el nombre
        add(lblNombre, BorderLayout.SOUTH);
        //escucha el mouse (si hace click)
        addMouseListener(new MouseAdapter() {
            @Override
            //si hace click
            public void mouseClicked(MouseEvent e) {
            	//ver la carta pero en grande con sus propiedades
                System.out.println("Clic en la carta: " + cartaRepresentada.getNombre());
                //ver en otra ventana
                VentanaOtra dialog = new VentanaOtra(cartaRepresentada);
                //ser visible
                dialog.setVisible(true);
            }
        });
    }
    //para ver el nombre por carta
    public String RetornoNombre(Carta carta) {
        //variable inicial al resultado
    	String resultado = "default.png";
        //sus extensiones
        String[] extensiones = {".jpg", ".png", ".jpeg", ".webp"};
        //recorrer las extensiones
        for (String ext : extensiones) {
            //crear el archivo
            File archivo = new File(carta.getNombre() + ext);
            //si existe el archivo
            if (archivo.exists()) {
                //sobreescribimos el resultado
                resultado = carta.getNombre() + ext; 
                //retornamos resultado como un string
                return resultado;
            }
        }
        //retornamos el resultado
    	return resultado;
    }
}