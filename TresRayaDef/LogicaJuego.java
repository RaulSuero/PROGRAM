import java.util.Scanner;

public class LogicaJuego {
    Jugador [] jugadores;
    boolean win;
    boolean empate;
    boolean turn= true;
    Table table;
    Scanner sc= new Scanner(System.in);

    public LogicaJuego() {
        inicalizarJuego();
    }

    private void inicalizarJuego() {
        this.jugadores= new Jugador[2];
        this.win= false;
        this.empate= false;
        crearJugadores();
        seleccionarPrimerJugador();
        table.inicializarTablero();
        while (!win) {
            if (turn== jugadores[0].getTurno()) {
                turn= table.introduceFicha(turn, Jugador jugadores[0]);
            }else {
                turn= table.introduceFicha(turn, Jugador jugadores[1]);
            }
            
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
    }

    private void crearJugadores() {
        for (int i= 0; i< jugadores.length; i++) {
            System.out.print("Nombre jugador "+ i+ ": ");
            jugadores[i].setNombre(sc.nextLine());
            System.out.print("Ficha jugador "+ i+ ": ");
            jugadores[i].setFicha(sc.nextLine().charAt(0));
        }
    }

    private void seleccionarPrimerJugador() {
        System.out.println("Quien es el primer jugador");
        System.out.println("1. "+ jugadores[0]+ " || 2. "+ jugadores[1]);
        if (sc.nextInt()== 1) {
            jugadores[0].setTurno(true);
            jugadores[1].setTurno(false);
        }else {
            jugadores[0].setTurno(false);
            jugadores[1].setTurno(true);
        }
    }
}
