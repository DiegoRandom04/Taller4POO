package Principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
	private ArrayList<Carta> cartas = new ArrayList<>(); 
	private static Sistema sis;
	private Sistema() {
	}
	public static Sistema getInstance() {
		if (sis == null) {
			sis = new Sistema();
		}
		return sis;
	}
	public ArrayList<Carta> getCartas() {
	    return this.cartas; 
	}
	public ArrayList<Carta> leerArchivo() {
		try {
			if (cartas != null) {
	            cartas.clear(); 
	        } else {
	            cartas = new ArrayList<>();
	        }
			Scanner lector = new Scanner(new File("Sobres.txt"));
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] partes = linea.split(";");
				String nombre = partes[0];
				int rareza = Integer.parseInt(partes[1]);
				String tipo = partes[2];
				String extra1 = partes[3];
				if (tipo.equalsIgnoreCase("pokemon")) {
					String extra2 = partes[4];
					Carta c = FactoryCarta.getCarta(nombre, rareza, tipo, extra1, extra2);
					cartas.add(c);
				} else {
					Carta c = FactoryCarta.getCarta(nombre, rareza, tipo, extra1, null);
					cartas.add(c);
				}
			}	
			lector.close();
			return cartas;
		} catch (Exception e) {
			System.out.println("Error de Leer Archivo de Sobres " + e);
		}
		return null;
	}
	public ArrayList<Carta> ordenarCartasPorRareza() {
        int n = cartas.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (cartas.get(j).getRareza() < cartas.get(j + 1).getRareza()) {
                    Carta temp = cartas.get(j);
                    cartas.set(j, cartas.get(j + 1));
                    cartas.set(j + 1, temp);
                }
            }
        }
        return cartas;
	}
	public ArrayList<Carta> ordenarCartasPorPoder() {
        int n = cartas.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (cartas.get(j).calcularPoder() < cartas.get(j + 1).calcularPoder()) {
                    Carta temp = cartas.get(j);
                    cartas.set(j, cartas.get(j + 1));
                    cartas.set(j + 1, temp);
                }
            }
        }
        return cartas;
	}
	public  ArrayList<Carta> ordenarCartasPorNombre() {
	    int n = cartas.size();
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < n - i - 1; j++) {
	            if (cartas.get(j).getNombre().compareToIgnoreCase(cartas.get(j + 1).getNombre()) > 0) {
	                Carta temp = cartas.get(j);
	                cartas.set(j, cartas.get(j + 1));
	                cartas.set(j + 1, temp);
	            }
	        }
	    }
	    return cartas;
	}
	public int CantLineas(String Archivo) {
		int cantidad = 0;
		try {
			Scanner lector = new Scanner(new File("Sobres.txt"));
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] partes = linea.split(";");
				String nombre = partes[0];
				String tipo = partes[2];
				String extra1 = partes[3];
				if (nombre != null && tipo != null && extra1 != null) {
					cantidad += 1;
				}
			}	
			lector.close();
		} catch (Exception e) {
			System.out.println("Error de Leer Archivo de Sobres " + e);
		}
		return cantidad;
	}
	public void agregarItem(String nombre,int raro, String string,int daño, int cant_energia) {
	    try {
	    	FileWriter archivoUsuarios = new FileWriter("Sobres.txt", true);
	        BufferedWriter escritorBuffer = new BufferedWriter(archivoUsuarios);
	        escritorBuffer.newLine();
	        escritorBuffer.write(nombre + ";" + raro + ";" + string + ";" + daño + ";" + cant_energia);
	        escritorBuffer.close();
	        System.out.println("Ítem añadido correctamente.");
			Sistema.getInstance().leerArchivo();
	    } catch (Exception e) {
	        System.out.println("Error al escribir en el Archivo de Sobres: " + e.getMessage());
	    }
	}
}