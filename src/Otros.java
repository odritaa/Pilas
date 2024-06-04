import java.util.ArrayList;
import java.util.Scanner;

public class Otros {
    Scanner scan = new Scanner(System.in);
    public Otros(){
        boolean es = false;
        System.out.println("Primero cree su pila dinamica." + "\n");
        Pila_Dinamica p1 = new Pila_Dinamica();
        p1.create();
        System.out.println("Bien hecho. Ahora cree su pila estatica." + "\n");
        Pila_Estatica p2 = new Pila_Estatica();
        p2.create();
        while(!es){
            System.out.println("""
                    Bienvenido. Ingrese una opcion para continuar.
                    1. Usar pila estatica.
                    2. Usar pila dinamica.
                    3. Usar otras operaciones.
                    4. Salir.""");
            String ans = scan.nextLine();
            switch (ans) {
                case "1" -> p2.interfaz();
                case "2" -> p1.interfaz();
                case "3" -> {
                    boolean es1 = false;
                    while (!es1) {
                        System.out.println("""
                                1. Buscar un elemento.
                                2. Ver las pilas. Con el orden de como se apilaron los elementos.
                                3. Salir""");
                        ans = scan.nextLine();
                        switch (ans) {
                            case "1" -> where(p1, p2);
                            case "2" -> imprimir(p1, p2);
                            case "3" -> es1 = true;
                            default -> System.out.println("No reconocido.");
                        }
                        if (!es1) {
                            System.out.println("Presione 'ENTER' para continuar.");
                            scan.nextLine();
                        }
                    }
                }
                case "4" -> {
                    es = true;
                    System.out.println("Hasta luego!");
                }
                default -> System.out.println("No se ingreso una opcion valida. Intente de nuevo.");
            }
            if(!es) {
                System.out.println("Presione enter para continuar.");
                scan.nextLine();
            }
        }
    }

    /**
     * Examinara las pilas dinamicas para ver si tienen un elemento.
     * @param p La pila dinamica.
     * @param n Numero pedido.
     * @return Devuelve true si se encuentra el numero, false en el caso contrario.
     */
    public boolean in_Dinamica(Pila_Dinamica p, int n){
        Pila_Dinamica aux = new Pila_Dinamica();
        aux.pila = new ArrayList<>();
        int f = p.pila.size();
        boolean es = false;
        for(int i = 0; i < f; i++){
            if(p.topePila() == n){
                es = true;
                break;
            } else{
                aux.apilarElemento(p.topePila());
                p.desapilarElemento();
            }
        }
        f = aux.pila.size();
        for(int i = 0; i < f; i++){
            p.apilarElemento(aux.topePila());
            aux.desapilarElemento();
        }

        return es;
    }

    /**
     * Examina las pilas estaticas para ver si tienen un elemento
     * @param p La pila estatica
     * @param n El elemento pedido
     * @return Devuelve true si la tiene, false de lo contrario
     */
    public boolean in_Estatica(Pila_Estatica p, int n){
        Pila_Estatica aux = new Pila_Estatica();
        aux.pila = new int[p.pila.length];
        boolean es = false;
        for(int i = 0; i < p.pila.length; i++){
            if(p.topePila() == n){
                es = true;
                break;
            } else{
                aux.apilarElemento(p.topePila());
                p.desapilarElemento();
            }
        }

        for(int i = 0; i < aux.pila.length; i++){
            if (aux.topePila() != 0) {
                p.apilarElemento(aux.topePila());
                aux.desapilarElemento();
            } else {
                break;
            }
        }

        return es;
    }

    /**
     * Indica cual de las dos pilas tiene el elemento si es que lo tienen.
     * @param p Pila dinamica
     * @param p1 Pila Estatica
     */
    public void where(Pila_Dinamica p, Pila_Estatica p1){
        System.out.println("Que numero desea buscar?: ");
        int n = scan.nextInt();
        scan.nextLine();
        if(in_Dinamica(p, n) && in_Estatica(p1, n)){
            System.out.println("El numero " + n + " se encuentra en ambas pilas.");
        } else if(in_Dinamica(p, n)){
            System.out.println("El numero " + n + " se encuentra en la pila dinamica: " + p.nombre);
        } else if(in_Estatica(p1, n)){
            System.out.println("El numero " + n + " se encuentra en la pila estatica: " + p1.nombre);
        } else{
            System.out.println("No se encontro en ninguna pila el numero " + n);
        }
    }
    public void imprimir(Pila_Dinamica p, Pila_Estatica p1){
        System.out.println("\n" + "Pila dinamica: " + p.nombre + "\n");
        int n = 1;
        for (int i = p.pila.size()-1; i >= 0; i--, n++){
            System.out.println(n + ". " + p.pila.get(i));
        }
        System.out.println("\n" + "Pila estatica: " + p1.nombre + "\n");
        n = 1;
        for (int i = p1.pila.length-1; i >= 0; i--){
            if (p1.pila[i] != -1){
                System.out.println(n + ". " + p1.pila[i]);
                n++;
            }
        }
    }
}