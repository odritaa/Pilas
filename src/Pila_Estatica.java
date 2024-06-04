import java.util.Arrays;
import java.util.Scanner;

public class Pila_Estatica {
	int[] pila; // Array de la pila.
	String nombre; // Nombre de la pila.
	Scanner scan = new Scanner(System.in); // Scanner para ingresar datos.

	/*
	Metodos
	 */

	/**
	 * Metodo para instanciar la pila.
	 */
	public Pila_Estatica() {
	}

	/**
	 * Metodo que pregunta y asigna los valores
	 */
	public void create() {
		System.out.println("Cual es el nombre de la pila?");
		this.nombre = scan.nextLine();
		System.out.println("Que tamanio quiere darle a su pila?");
		this.pila = new int[scan.nextInt()];
		scan.nextLine();
		for(int i = 0; i < pila.length; i++){
			pila[i] = -1;
		}
	}

	/**
	 * Apilar elemento pedido en la pila.
	 * @param n Numero solicitado.
	 */
	public void apilarElemento(int n) {
		for(int i = pila.length-1; i >= 0; i--){
			if (i == 0){
				pila[i] = n;
			} else{
				int a = pila[i];
				pila[i] = pila[i-1];
				pila[i-1] = a;
			}
		}
	}

	/**
	 * Se quita el primer elemento y se corren los demas. En la ultima posicion se coloca un 0 para indicar que esta vacio.
	 */
	public void desapilarElemento() {
		for(int i = 0; i < pila.length; i++){
			if (i == pila.length-1){
				pila[i] = 0;
			} else{
				pila[i] = pila[i+1];
			}
		}
		pila[pila.length-1] = -1;
	}

	/**
	 * Usado para saber que numero esta arriba del todo
	 * @return Se devuelve el valor en el tope
	 */
	public int topePila() {
		return pila[0];
	}

	/**
	 * Usado para saber si la pila esta vacia.
	 * @return Devuelve un valor booleano. True es que esta vacia. False es que tiene algun elemento.
	 */
	public boolean pilaVacia() {
		for(int i = 0; i < pila.length; i++){
			if (pila[i] != -1){
				return false;
			}
		}
		return true;
	}

	/**
	 * Usado para saber si la pila esta llena.
	 * @return Devuelve true si esta llena. False si no lo esta.
	 */
	public boolean pilaLlena(){
		return pila[pila.length - 1] != -1;
	}
	public void interfaz(){
		boolean es = false;
		while (!es){
			System.out.println("""
					1. Apilar elemento.
					2. Desapilar elemento.
					3. Ver el tope de la pila.
					4. Ver si la pila esta vacia.
					5. Ver si la pila esta llena.
					6. Ver la pila.
					7. Volver al menu principal.""");
			String ans = scan.nextLine();
			switch (ans){
				case "1":
					if (pilaLlena()){
						System.out.println("Lo siento la pila " + nombre + " se encuentra llena.");
					} else {
						System.out.println("Que numero quiere ingresar?");
						int n = scan.nextInt();
						scan.nextLine();
						apilarElemento(n);
						System.out.println("Apilado!");
					}
					break;
				case "2":
					if(!pilaVacia()) {
						desapilarElemento();
						System.out.println("Desapilado!");
					} else {
						System.out.println("No hay ningun elemento para desapilar en la pila.");
					}
					break;
				case "3":
					System.out.println("El tope de la pila es: " + topePila());
					break;
				case "4":
					if(pilaVacia()){
						System.out.println("La pila esta vacia.");
					} else {
						System.out.println("La pila no esta vacia.");
					}
					break;
				case "5":
					if(pilaLlena()){
						System.out.println("La pila esta llena.");
					} else {
						System.out.println("La pila no esta llena.");
					}
					break;
				case "6":
					System.out.println("\n");
					for (int i = 0; i < pila.length; i++){
						if (pila[i] != -1){
							System.out.println(pila[i]);
						}
					}
					System.out.println("\n" + nombre + "\n");
					break;
				case "7":
					es = true;
					break;
				default:
					System.out.println("No reconocido.");
			}
			if (!es){
				System.out.println("Presione 'ENTER' para continuar.");
				scan.nextLine();
			}
		}

	}



	@Override
	public String toString() {
		return "pilaEstatica{" + "Nombre:'" + nombre + '\'' +
		"Pila: " + Arrays.toString(pila) +
				'}';
	}
}


