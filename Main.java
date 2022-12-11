import java.util.List;
import java.util.Scanner;


public class Main {
	
	private static Scanner lectura = new Scanner(System.in); //lectura de datos por teclado
	private static int opcionElegida=-1;
	
	//variables del usuario donde almacenaremos lo ingresado en Consola
	private static String nombreUsuario="";
	private static String edadUsu="";
	private static int edadUsuario=0;
	private static String DNIUsuario="";
	private static boolean DNIValido=false;
	
	//usuario y cuenta
	private static Usuario nuevoUsuario = new Usuario();
	private static Cuenta nuevaCuenta;
	
	private static void introducirUsuario() {
		
		System.out.println("Introduce el nombre de usuario: "); 
		nombreUsuario = lectura.nextLine();
		
		System.out.println("Introduce la edad del usuario: "); 
		edadUsu = lectura.nextLine(); 
		edadUsuario = Integer.parseInt(edadUsu);
		
		System.out.println("Introduce el DNI de usuario: "); 
		do {
			
			DNIUsuario = lectura.nextLine();
			
			if(nuevoUsuario.setDNI(DNIUsuario)) {
				DNIValido = true;
			}
			
			else {
				System.out.println("DNI introducido incorrecto \nIntroduce el DNI del usuario v�lido");
			}
			
			} while (!DNIValido);
	}
	
	//creamos el m�todo del men� de opciones
	private static void visualizarMenu() {
		
		System.out.println("Realiza una nueva acci�n");
		System.out.println("1 Introduce un nuevo gasto");
		System.out.println("2 Introduce un nuevo ingreso");
		System.out.println("3 Mostrar gastos");
		System.out.println("4 Mostrar ingresos");
		System.out.println("5 Mostrar saldo");
		System.out.println("0 Salir");
	}
    
	private static void introducirGastos(){
         
		System.out.println("Introduce la descripci�n del gasto: "); 
		//@SuppressWarnings("resource") //te pide Eclipse que lo a�adas para evitar el warning, no lo hago
		Scanner scanner = new Scanner(System.in);
		String description = scanner.next();
		
		System.out.println("Introduce el importe del gasto: "); 
		double cantidad = scanner.nextDouble(); 
		
		//no existe saldo suficiente, salta error 
		try {
			double saldo = nuevaCuenta.addGastos(description,cantidad);
			System.out.println("Saldo restante:" + saldo);
		} catch (GastoException e) {
			System.out.println(e.getMessage()); //usamos getMessage, m�todo que nuestra clase hereda de Exception
		}
    }
	
	private static void introducirIngresos(){
	        
		System.out.println("Introduce la descripci�n del ingreso: "); 
		//@SuppressWarnings("resource") //te pide Eclipse que lo a�adas para evitar el warning, no lo hago
		Scanner scanner = new Scanner(System.in);
		String description = scanner.next();
		
		System.out.println("Introduce el importe del ingreso: "); 
		double cantidad = scanner.nextDouble(); 
		double saldo = nuevaCuenta.addIngresos(description,cantidad);
		System.out.println("Saldo restante:" + saldo);
		
		
	}
	
	private static void mostrarGastos(){
		List<Gasto> listaGastos = nuevaCuenta.getGastos(); 
		
		//vemos los gastos si se han hecho, si no, sale mensaje conforme no se han hecho
		if(!listaGastos.isEmpty()){
			for (int i = 0; i < listaGastos.size(); i++) {
				System.out.println(listaGastos.get(i));
			}
		}
		else {
			System.out.println("No se han realizado gastos");
	       }
	}
	
	
	private static void mostrarIngresos() {
		List<Ingreso> listaIngresos = nuevaCuenta.getIngresos(); 
		//vemos los ingresos si se han hecho, si no, sale mensaje conforme no se han hecho
		if(!listaIngresos.isEmpty()){
			for (int i = 0; i < listaIngresos.size(); i++) {
				System.out.println(listaIngresos.get(i));
			}
		}
			else {
				System.out.println("No se han realizado ingresos");
		       }
	}

	public static void main(String[] args){
		
		
		introducirUsuario();
		nuevoUsuario.setNombre(nombreUsuario);
		nuevoUsuario.setEdad(edadUsuario);
		System.out.println("Usuario creado correctamente:\n" + nuevoUsuario.toString()); //mostramos datos del usuario creado
		
		nuevaCuenta = new Cuenta(nuevoUsuario);
		
		boolean Menu = true;
		do { 
			visualizarMenu();
			opcionElegida = lectura.nextInt(); 
		
			switch (opcionElegida) {
				case 1:
					introducirGastos();
					break;
				case 2:
					introducirIngresos();
					break;
				case 3:
					mostrarGastos();
					break;
				case 4:
					mostrarIngresos();
					break;
				case 5:
					System.out.println(nuevaCuenta.toString());	
					break;
				case 0:
					System.out.println("Fin del programa.\nGracias por utilizar la aplicaci�n.");
					Menu = false; //para que el bucle while termine y salga al elegir 0
					break;
				default:
					System.out.println("El valor introducido no es v�lido.");
					continue;
				}		
			}
		while(Menu);
	}

}