package Principal;
import java.util.ArrayList;
public class Carpeta {
	private static Carpeta carpeta;
	private ArrayList<Pokemon> arrayPokemon;
	private ArrayList<Item> arrayItem;
	private ArrayList<Supporter> arraySupporter;
	private ArrayList<Energy> arrayEnergy;
	
	private Carpeta () {
		//el constructor es privado ya que se hará un singleton en carpeta
	}
	
	public Carpeta getInstancia(){
		/* Aqui se hace para poder construir el singleton
		 * en caso de que no este instanciado se instancia, si ya esta instanciado retornara la misma instancia, 
		 * por lo que la instancia y este metodo son estaticos ya que pertenecen a la clase y se puede ejutar sin crear una instancia de estas
		 * @return Carpeta
		 */
		if (carpeta == null) {
			//si no hay una instancia de carpeta se crea una nueva
			Carpeta carpeta = new Carpeta();
			return carpeta;
		}else {
			//si ya hay una instancia se restringe la creacion y se devuelve la instancia
			return carpeta;
			
		}

	}
	
	public ArrayList<Pokemon> getArrayPokemon(){
		return this.arrayPokemon;	
		}
	public ArrayList<Item> getArrayItem(){
		return arrayItem;
	}
	
	public ArrayList<Supporter> getArraySupporter() {
		return arraySupporter;
	}
	
	public void setArraySupporter(ArrayList<Supporter> arraySupporter) {
		this.arraySupporter = arraySupporter;
	}
	
	public ArrayList<Energy> getArrayEnergy() {
		return arrayEnergy;
	}
	
	public void setArrayEnergy(ArrayList<Energy> arrayEnergy) {
		this.arrayEnergy = arrayEnergy;
	}
	
	public void setArrayPokemon(ArrayList<Pokemon> arrayPokemon) {
		this.arrayPokemon = arrayPokemon;
	}
	
	public void setArrayItem(ArrayList<Item> arrayItem) {
		this.arrayItem = arrayItem;
	}
	
	public void addPokemon(Pokemon pokemon) {
		arrayPokemon.add(pokemon);
	}
	public void addItem(Item item) {
		arrayItem.add(item);
	}
	public void addEnergy(Energy energy) {
		arrayEnergy.add(energy);
	}
	public void addSupporter(Supporter supporter) {
		arraySupporter.add(supporter);
	}
}
