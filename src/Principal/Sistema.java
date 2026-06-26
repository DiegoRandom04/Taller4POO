package Package1;

public class Sistema implements FactoryCarta {
	private static Sistema instancia; //estático ya que pertenece a la clase, no es instanciable
	//la variable instancia queda reservada a la clase por lo que es visible por todo hacia abajo jerárquicamente y eso significa que no se podra usar la misma variable como solo local en alguna parte
	private Sistema() {};
	
	public static Sistema getInstancia() {
		/* Esta variable es para el singleton de Sistema;
		 * @return Sistema
		 */
		if (instancia == null) {// si la instancia no se ha creado, se procede a crear y posterior se retorna
			instancia = new Sistema();
			return instancia;
		}
		else {
			return instancia;// como la instancia ya esta creada que retorne esta
		}
	}

	@Override
	public Pokemon crearPokemon(String nombre, float rareza, String tipo, float daño, float cantEnergias) {
		/* Es parte del factory, se crea dentro de sistema y factory es una interfaz
		 * @return Pokemon
		 */
		
		Pokemon pokemon = new Pokemon (nombre, rareza , tipo, daño, cantEnergias);
		
		return pokemon;
	}

	@Override
	public Item crearItem(String nombre, float rareza, String tipo, float bonificacion) {
		/* Parte del factory
		 * @return Item
		 */
		Item item = new Item(nombre, rareza, tipo, bonificacion);
		return item;
	}

	@Override
	public Supporter crearSupporter(String nombre, float rareza, String tipo, float efectosPorTurno) {
		/* Parte del factory
		 * @return Supporter
		 */  
		Supporter supporter = new Supporter (nombre, rareza, tipo, efectosPorTurno);
		
		return supporter;
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
				int rareza = Integer.parseInt(partes[1]);
				String tipo = partes[2];
				String extra1 = partes[3];
				if (nombre != null && tipo != null && extra1 != null) {
					cantidad += 1;
				}
			}	
		} catch (Exception e) {
			System.out.println("Error de Leer Archivo de Sobres " + e);
		}
		return cantidad;
	}
	public void agregarItem(String nombre,int raro, String string,int daño, int cant_energia) {
		if (!string.equalsIgnoreCase("Pokemon")) {
	        return; 
	    }
	    try {
	    	FileWriter archivoUsuarios = new FileWriter("Sobres.txt", true);
	        BufferedWriter escritorBuffer = new BufferedWriter(archivoUsuarios);
	        escritorBuffer.write(nombre + ";" + raro + ";" + string + ";" + daño + ";" + cant_energia);
	        System.out.println("Ítem añadido correctamente.");
	    } catch (Exception e) {
	        System.out.println("Error al escribir en el Archivo de Sobres: " + e.getMessage());
	    }
	}
}
