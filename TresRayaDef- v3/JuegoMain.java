import java.util.Scanner;

public class JuegoMain {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean terminarJuego= false;
        boolean romperBucle= false;
        int index= 0;
        LogicaTresRaya juegos[]; //

        System.out.print("Cuantas mesas van a jugar: ");
        int mesas= sc.nextInt();
        juegos= new LogicaTresRaya[mesas];
        for (int i = 0; i < juegos.length; i++) {
            System.out.println("Mesa "+ (i+ 1));
            juegos[i]= new LogicaTresRaya();
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
