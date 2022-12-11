
public class Gasto extends Dinero {

	//hereda m�todos y atributos de la clase Dinero
	
	public Gasto(double gasto, String description) {
		this.dinero = gasto; 
		this.description = description;
	}

	//toString es un m�todo de la clase Object, para usarlo en clases personalizadas indicar sobreescritura con @Override
	@Override
	public String toString() {
		//devuelve la descripci�n y cantidad del gasto
		return "Gasto en concepto de: " + this.description + " Importe gastado: " + this.dinero +"�"; 
	}
}
