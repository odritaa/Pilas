import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Pila_Dinamica {
    // Valores
    ArrayList<Integer> pila;
    String nombre; // Nombre de la pila.
    Scanner scan = new Scanner(System.in);

    /*
    Metodos
    */

    /**
     * Metodo para instanciar la pila.
     */
    public Pila_Dinamica(){}

    /**
     * Metodo que pregunta y asigna el nombre y crea la pila.
     */
    public void create() {
        System.out.println("¿Cual es el nombre de la pila?");
        this.nombre = scan.nextLine();
        pila = new ArrayList<>();
    }

    /**
     * Se usa para ingresar un elemento en la pila
     * @param x Elemento pedido al usuario.
     */
    public void apilarElemento(Integer x){
        pila.add(0,x);
    }

    /**
     * Quita el primer elemento de la pila.
     */
    public void desapilarElemento(){
        pila.remove(0);
    }

    /**
     * @return Da el elemento en el tope de la pila.
     */
    public int topePila(){
        return pila.get(0);
    }

    /**
     * @return Si devuelve true la pila esta vacia, de lo contrario esta vacia.
     */
    public boolean pilaVacia(){
        return pila.size() == 0;
    }
    public void interfaz(){
        boolean es = false;
        while(!es){
            System.out.println("""
                    1. Apilar un elemento.
                    2. Desapilar un elemento.
                    3. Ver el tope de la pila.
                    4. Ver si la pila esta vacia.
                    5. Imprimir la pila.
                    6. Volver al menu principal.
                    """);
            String res = scan.nextLine();
            switch (res){
                case "1":
                    System.out.println("Ingrese el valor que quiere apilar: ");
                    int a = scan.nextInt();
                    scan.nextLine();
                    apilarElemento(a);
                    System.out.println("Apilado!");
                    break;
                case "2":
                    desapilarElemento();
                    System.out.println("Desapilado!");
                    break;
                case "3":
                    System.out.println("El tope de la pila es: " + topePila());
                    break;
                case "4":
                    if(pilaVacia()){
                        System.out.println("Su pila se encuentra vacia.");
                    } else{
                        System.out.println("La pila no esta vacia.");
                    }
                    break;
                case "5":
                    System.out.println("\n");
                    for (int i = 0; i < pila.size(); i++){
                        System.out.println(pila.get(i));
                    }
                    System.out.println("\n" + nombre + "\n");
                    break;
                case "6":
                    es = true;
                    break;
                default:
                    System.out.println("Valor ingresado no valido.");
            }
            if (!es){
                System.out.println("Presione 'ENTER' para continuar.");
                scan.nextLine();
            }

        }
    }

    @Override
    public String toString() {
        return "Pila_Dinamica{" +
                "pila=" + pila +
                '}';
    }
}
