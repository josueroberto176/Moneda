import java.util.*;
import java.lang.*;
import java.util.Random;

class Main {
  public static void main(String[] args) {
   // Definimos el experimento...
        int t = 50000; // número de lanzamientos
        int b = 1; // resultado que se anota: 0 es cara, 1 es cruz
        boolean verLanzamientos = true; // valor false si sólo se quiere ver el resultado final
        String [] caracruz = {"C","X"};
        System.out.println("Simulando " +  t + " lanzamientos de moneda...");
        System.out.print("El programa cuenta el número de '");
        System.out.println(caracruz[b] + "' que salen...");

        // nos preparamos para generar un número aleatorio...
        Random generator = new Random();
        
        // definimos un contador de lanzamientos y casos favorables
        double lanzamientos = 0;
        double favorables = 0;
        
        // empiezan los lanzamientos de moneda...
        for(int i=0;i<(t/10);i++) {
            for(int j=0;j<10;j++) {
                // lanzamos...
                int r = generator.nextInt( 2 );
                if(r == b) {
                    // si el lanzamiento es el resultado que esperábamos,
                    // lo mostramos y señalamos entre paréntesis
                    favorables++;
                    if(verLanzamientos)
                        System.out.print("(" + caracruz[r] + ") ");
                } else {
                    // si no, simplemente lo mostramos
                    if(verLanzamientos)
                        System.out.print(" " + caracruz[r] + "  ");
                }
            }
            // nuevo bloque de 10 lanzamientos...
            lanzamientos+=10;

            // mostramos la frecuencia relativa hasta el momento
            if(verLanzamientos)  {
                verLanzamiento(i,favorables,lanzamientos);
            }
            // la frecuencia relativa hasta el último lanzamiento
            // siempre se muestra
            if( i==((t/10)-1))  {
                 verLanzamiento(i,favorables,lanzamientos);
            }
        }
    }
    
    // Se muestran los detalles del lanzamiento y la frecuencia relativa
    public static void verLanzamiento(int i, double favorables, double lanzamientos) {
        // calculamos la frecuencia relativa
        double fr = favorables/lanzamientos;
        System.out.print("\t" + (int)favorables + "/" + (int)lanzamientos);
        System.out.println("\t= " + fr + "\t ");

  }
}