import java.util.regex.Pattern;

public class Usuario {

	private String nombre;
	private int edad;
	private String DNI;

	public Usuario() {
	}

	//metodos get/set 
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getDNI() {
		return DNI;
	}
	
	//validar DNI (booleano, Pattern y la expresión regular)
	public boolean setDNI(String DNI) {
		final String patron = "^\\d{8}-?[A-Za-z]$"; 
		this.DNI = DNI ;
		return Pattern.matches(patron,DNI);
	}
	
	//toString es un método de la clase Object, para usarlo en clases personalizadas indicar sobreescritura con @Override
	@Override
	public String toString() {
		return "Nombre:" + this.nombre + " Edad:" + this.edad + " DNI:" + this.DNI +"\n"; //devuelve usuario creado
	}
}
