import java.util.Scanner;

public class JuegoMain {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean terminarJuego= false;
        boolean romperBucle= false;
        int index= 0;
        LogicaJuego juegos[]; //

        System.out.print("Cuantos mesas van a jugar: ");
        int mesas= sc.nextInt();
        juegos= new LogicaJuego[mesas];
        for (int i = 0; i < juegos.length; i++) {
            juegos[i]= new LogicaJuego();
        }
        while (!terminarJuego) {
            juegos[index].jugar();
            for (int i= 0; i< juegos.length && !romperBucle; i++) {
                if (!juegos[i].getWin()) {
                    romperBucle= true;
                }
            }
            if (!romperBucle) {
                terminarJuego= true;
            }
            index++;
            index%= juegos.length;
            romperBucle= false;
        }
        System.out.println("todos los juegos han terminado");
    }
}
