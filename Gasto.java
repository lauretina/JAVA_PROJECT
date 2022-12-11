
public class Gasto extends Dinero {

	//hereda métodos y atributos de la clase Dinero
	
	public Gasto(double gasto, String description) {
		this.dinero = gasto; 
		this.description = description;
	}

	//toString es un método de la clase Object, para usarlo en clases personalizadas indicar sobreescritura con @Override
	@Override
	public String toString() {
		//devuelve la descripción y cantidad del gasto
		return "Gasto en concepto de: " + this.description + " Importe gastado: " + this.dinero +"€"; 
	}
}
