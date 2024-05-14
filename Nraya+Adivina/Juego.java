import java.util.Scanner;

public abstract class Juego {
    Scanner sc= new Scanner(System.in);
    Jugador [] jugadores;
    boolean win;

    public Juego() {
        this.jugadores= new Jugador[2];
        crearJugadores();
        seleccionarPrimerJugador();
    }

    private void crearJugadores() {
        for (int i= 0; i< jugadores.length; i++) {
            this.jugadores[i]= new Jugador();
            System.out.print("Nombre jugador "+ (i+ 1)+ ": ");
            jugadores[i].setNombre(sc.nextLine());
            System.out.print("Ficha jugador "+ (i+ 1)+ ": ");
            jugadores[i].setFicha(sc.nextLine().charAt(0));
        }
    }

    private void seleccionarPrimerJugador() {
        System.out.println("Quien es el primer jugador");
        System.out.println("1. "+ jugadores[0].getNombre()+ " || 2. "+ jugadores[1].getNombre());
        if (sc.nextInt()== 1) {
            jugadores[0].setTurno(true);
            jugadores[1].setTurno(false);
        }else {
            jugadores[0].setTurno(false);
            jugadores[1].setTurno(true);
        }
    }

    abstract void jugar();

    abstract boolean getWin();
    
}
