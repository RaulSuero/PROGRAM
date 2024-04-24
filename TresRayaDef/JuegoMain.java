import java.util.Scanner;

public class JuegoMain {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Table table;
        int tamano;
        Jugador p1;
        Jugador p2;
        String n1;
        String n2;
        boolean turn= true;
        boolean win= false;
        boolean empate= false;

        System.out.print("Elige tamano del tablero: ");
        tamano= sc.nextInt();
        table= new Table(tamano);
        System.out.print("Nombre jugador 1: ");
        n1= sc.next();
        System.out.print("Nombre jugador 2: ");
        n2= sc.next();
        System.out.println("Primer jugador: 1. "+ n1+ "  || 2. "+ n2);
        if (sc.nextInt()== 1) {
            p1= new Jugador(n1);
            p2= new Jugador(n2);
        }else {
            p1= new Jugador(n2);
            p2= new Jugador(n1);
        }
        table.printTable();
        while (!win) {
            turn= table.introduceFicha(turn, p1, p2);
            table.mostrarTablero();
            win= table.comprobarGanador(win);
            if (!win) {
                empate= table.comprobarEmpate(empate);
                if (empate) {
                    System.out.println("Empate, juego reiniciado");
                    table.printTable();
                    empate= false;
                }
            }
        }
        table.decirGanador(turn, p1, p2);
    }
}
