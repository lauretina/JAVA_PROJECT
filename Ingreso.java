public class Ingreso extends Dinero{
	
	//hereda métodos y atributos de la clase Dinero
	
	public Ingreso(double ingreso, String description) {
		this.dinero = ingreso; 
		this.description = description;
	}

	//toString es un método de la clase Object, para usarlo en clases personalizadas indicar sobreescritura con @Override
	@Override
	public String toString() {
		//devuelve la descripción y cantidad del ingreso
		return "Ingreso en concepto de: " + this.description + " Importe ingresado: " + this.dinero +"€"; 
	}
	
}
