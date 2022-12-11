import java.util.ArrayList;
import java.util.List;

public class Cuenta {

	//atributos
	private double saldo;
	private Usuario usuario; 
	private List<Gasto> gastos; 
	private List<Ingreso> ingresos; 
	
	//constructor
	public Cuenta(Usuario usuario) {
		this.usuario = usuario; 
		this.saldo = 0;
		this.ingresos = new ArrayList<>(); 
		this.gastos = new ArrayList<>();  
	}
	
	//métodos get/set
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double addIngresos(String description, double cantidad) {
		
		//agregar un ingreso y añadir la cantidad a saldo
		ingresos.add(new Ingreso(cantidad,description));
		this.saldo = this.saldo + cantidad; 	
		return this.saldo;
	}

	public double addGastos(String description, double cantidad) throws GastoException {
		
		boolean condicionException = this.getSaldo()<cantidad;
		
		//comprobar si hay saldo suficiente
		if(condicionException) {
			throw new GastoException(); 
		}
		
		//agregar un gasto y restar la cantidad a saldo
		gastos.add(new Gasto(cantidad, description));
		this.saldo = this.saldo - cantidad; 
		return this.saldo;  
	}

	public List<Ingreso> getIngresos() {
		return ingresos;
	}
	
	public List<Gasto> getGastos() {
		return gastos;
	}
	
	//toString es un método de la clase Object, para usarlo en clases personalizadas indicar sobreescritura con @Override
	@Override
	public String toString() {
		return "El saldo actual de " + this.usuario.getNombre() + " es: " + this.saldo +"€"; //devuelve nombre de usuario y su saldo
	}
}
