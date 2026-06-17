package Principal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BuscadorImagen {
	public void buscarImagen(Carta carta) {
		try {
			URL carpetaRecursos = BuscadorImagen.class.getResource("/");
			if (carpetaRecursos == null) {
				System.out.println("No se pudo acceder a la carpeta de recursos.");
				return;
			}

			File directorio = new File(carpetaRecursos.getPath());
			File[] archivosEncontrados = directorio.listFiles((dir, nombre) -> {
				return nombre.toLowerCase().startsWith(carta.getNombre().toLowerCase() + ".");
			});
			if (archivosEncontrados != null && archivosEncontrados.length > 0) {
				File archivoImagen = archivosEncontrados[0];
				System.out.println("Imagen encontrada: " + archivoImagen.getName());
				BufferedImage imagen = ImageIO.read(archivoImagen);
			} else {
				System.out.println("No se encontró ninguna imagen llamada: " + carta.getNombre());
			}
		} catch (IOException e) {
			System.out.println("Error al leer la imagen.");
			e.printStackTrace();
		}
	}
}