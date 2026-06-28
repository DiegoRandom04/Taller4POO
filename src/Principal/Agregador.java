package Principal;

import java.io.BufferedWriter;
import java.io.FileWriter;

//para agregar cosas

interface Agregador {
	//para agregar de tipo Pokemon
	public static void agregarPokemon(String nombre,int raro, String string,int daño, int cant_energia) {
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
	//para agregar de tipo energia
	public static void agregarEnergia(String nombre,int raro, String string,String elemento) {
	    try {
	    	FileWriter archivoUsuarios = new FileWriter("Sobres.txt", true);
	        BufferedWriter escritorBuffer = new BufferedWriter(archivoUsuarios);
	        escritorBuffer.newLine();
	        escritorBuffer.write(nombre + ";" + raro + ";" + string + ";" + elemento);
	        escritorBuffer.close();
	        System.out.println("Ítem añadido correctamente.");
			Sistema.getInstance().leerArchivo();
	    } catch (Exception e) {
	        System.out.println("Error al escribir en el Archivo de Sobres: " + e.getMessage());
	    }
	}
	//para agregar items
	public static void agregarItems(String nombre,int raro, String string,float bonificacion) {
	    try {
	    	FileWriter archivoUsuarios = new FileWriter("Sobres.txt", true);
	        BufferedWriter escritorBuffer = new BufferedWriter(archivoUsuarios);
	        escritorBuffer.newLine();
	        escritorBuffer.write(nombre + ";" + raro + ";" + string + ";" + bonificacion);
	        escritorBuffer.close();
	        System.out.println("Ítem añadido correctamente.");
			Sistema.getInstance().leerArchivo();
	    } catch (Exception e) {
	        System.out.println("Error al escribir en el Archivo de Sobres: " + e.getMessage());
	    }
	}
	//para agregar soportes
	public static void agregarSoporte(String nombre,int raro, String string,int EfectoPorTurno) {
	    try {
	    	FileWriter archivoUsuarios = new FileWriter("Sobres.txt", true);
	        BufferedWriter escritorBuffer = new BufferedWriter(archivoUsuarios);
	        escritorBuffer.newLine();
	        escritorBuffer.write(nombre + ";" + raro + ";" + string + ";" + EfectoPorTurno);
	        escritorBuffer.close();
	        System.out.println("Ítem añadido correctamente.");
			Sistema.getInstance().leerArchivo();
	    } catch (Exception e) {
	        System.out.println("Error al escribir en el Archivo de Sobres: " + e.getMessage());
	    }
	}
}
