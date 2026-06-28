package Principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    //creamos los parametros para sistema
	private ArrayList<Carta> cartas = new ArrayList<>(); 
	private static Sistema sis;
    //singleton (única instancia)
	private Sistema() {
	}
    //singleton (única instancia)
	public static Sistema getInstance() {
		if (sis == null) {
			sis = new Sistema();
		}
		return sis;
	}
    //obtenemos las cartas
	public ArrayList<Carta> getCartas() {
	    return this.cartas; 
	}
	//leemos el archivo
	public ArrayList<Carta> leerArchivo() {
		//usamos el try and catch para leer el archivo
		try {
			//si contiene cartas, lo vaciamos
			if (cartas != null) {
				//vaciamos las cartas
	            cartas.clear(); 
			//si es null el arraylist
	        } else {
				//creamos el arraylist
	            cartas = new ArrayList<>();
	        }
			//abrimos el archivo
			Scanner lector = new Scanner(new File("Sobres.txt"));
			//si el archivo tiene lineas siguientes
			while (lector.hasNextLine()) {
				//adelantamos las linea
				String linea = lector.nextLine();
				//separamos la linea (";")
				String[] partes = linea.split(";");
				//nombre va a ser igual a la primera separacion
				String nombre = partes[0];
				//rareza va a ser igual a la segunda separacion
				int rareza = Integer.parseInt(partes[1]);
				//tipo va a ser igual a la tercera separacion
				String tipo = partes[2];
				//extra1 va a ser igual a la cuarta separacion
				String extra1 = partes[3];
				//si el tipo es igual a pokemon
				if (tipo.equalsIgnoreCase("pokemon")) {
					//extra2 va a ser igual a la quinta separacion
					String extra2 = partes[4];
					//creamos la carta
					Carta c = FactoryCarta.getCarta(nombre, rareza, tipo, extra1, extra2);
					//añadimos la carta al arraylist
					cartas.add(c);
				//si el tipo es diferente a pokemon
				} else {
					//creamos la carta
					Carta c = FactoryCarta.getCarta(nombre, rareza, tipo, extra1, null);
					//añadimos la carta al arraylist
					cartas.add(c);
				}
			}	
			//cerramos el lector
			lector.close();
			//retornamos las cartas
			return cartas;
		//añadimos la excepcion en caso de encontrar
		} catch (Exception e) {
			//printeamos
			System.out.println("Error de Leer Archivo de Sobres " + e);
		}
		//retornamos null
		return null;
	}
	//ordenar cartas por rareza
	public ArrayList<Carta> ordenarCartasPorRareza() {
		//leemos de nuevo el archivo
		Sistema.getInstance().leerArchivo();
		//ordenamos por la rareza (ordenamiento burbuja)
        int n = cartas.size();
        //recorremos la lista de n
        for (int i = 0; i < n - 1; i++) {
            //recorremos la lista de n
            for (int j = 0; j < n - i - 1; j++) {
                //si la rareza de la carta anterior es menor
                if (cartas.get(j).getRareza() < cartas.get(j + 1).getRareza()) {
                    //ordenamos las cartas
                    Carta temp = cartas.get(j);
                    cartas.set(j, cartas.get(j + 1));
                    cartas.set(j + 1, temp);
                }
            }
        }
        //retornamos las cartas modificadas
        return cartas;
	}
	//ordenar cartas por poder
	public ArrayList<Carta> ordenarCartasPorPoder() {
		//leemos de nuevo el archivo
		Sistema.getInstance().leerArchivo();
		//ordenamos por la rareza (ordenamiento burbuja)
        int n = cartas.size();
        //recorremos la lista de n
        for (int i = 0; i < n - 1; i++) {
            //recorremos la lista de n
            for (int j = 0; j < n - i - 1; j++) {
                //si el poder de la carta anterior es menor
                if (cartas.get(j).calcularPoder() < cartas.get(j + 1).calcularPoder()) {
                	//ordenamos las cartas
                    Carta temp = cartas.get(j);
                    cartas.set(j, cartas.get(j + 1));
                    cartas.set(j + 1, temp);
                }
            }
        }
        //retornamos las cartas modificadas
        return cartas;
	}
	//ordenar cartas por nombre
	public ArrayList<Carta> ordenarCartasPorNombre() {
		//leemos de nuevo el archivo
		Sistema.getInstance().leerArchivo();
		//ordenamos por la rareza (ordenamiento burbuja)
	    int n = cartas.size();
        //recorremos la lista de n
	    for (int i = 0; i < n - 1; i++) {
	        //recorremos la lista de n
	        for (int j = 0; j < n - i - 1; j++) {
	        	//si el nombre de las cartas empieza segun abedecedario con el siguiente,a,b y asi
	            if (cartas.get(j).getNombre().compareToIgnoreCase(cartas.get(j + 1).getNombre()) > 0) {
                	//ordenamos las cartas
	                Carta temp = cartas.get(j);
	                cartas.set(j, cartas.get(j + 1));
	                cartas.set(j + 1, temp);
	            }
	        }
	    }
        //retornamos las cartas modificadas
	    return cartas;
	}
	//cantidad de lineas
	public int CantLineas(String Archivo) {
		//inicializamos la cantidad
		int cantidad = 0;
		try {
			//leer el archivo
			Scanner lector = new Scanner(new File("Sobres.txt"));
			//si el archivo posee linea siguiente
			while (lector.hasNextLine()) {
				//linea es igual al archivo siguiente linea
				String linea = lector.nextLine();
				//separamos la linea en (";")
				String[] partes = linea.split(";");
				//nombre es igual a el primer separador
				String nombre = partes[0];
				//tipo es igual a el tercer separador
				String tipo = partes[2];
				//tipo es igual a el cuarto separador
				String extra1 = partes[3];
				//si algunos de los strings es diferente de nulo
				if (nombre != null && tipo != null && extra1 != null) {
					//sumamos la cantidad de lineas
					cantidad += 1;
				}
			}	
			//cerramos el archivo
			lector.close();
		//excepcion en caso de no encontrar el archivo
		} catch (Exception e) {
			//printeamos
			System.out.println("Error de Leer Archivo de Sobres " + e);
		}
		//retornamos la cantidad
		return cantidad;
	}
}