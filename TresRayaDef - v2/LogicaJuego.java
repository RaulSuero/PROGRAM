import java.util.Scanner;

public class LogicaJuego {
    Jugador [] jugadores;
    boolean win;
    boolean empate;
    boolean turn= true;
    boolean cambioMesa;
    Table table;
    Scanner sc= new Scanner(System.in);

    public LogicaJuego() {
        inicalizarJuego();
    }

    public boolean getWin() {
        return win;
    }

    private void inicalizarJuego() {
        this.jugadores= new Jugador[2];
        this.win= false;
        this.empate= false;
        this.cambioMesa= false;
        crearJugadores();
        seleccionarPrimerJugador();
        table= new Table();
    }

    public void jugar() {
        int i= 0;
        cambioMesa= false;

        while (!win && !cambioMesa) {
            table.mostrarTablero();
            if (turn== jugadores[0].getTurno()) {
                turn= table.introduceFicha(turn, jugadores[0]);
            }else {
                turn= table.introduceFicha(turn, jugadores[1]);
            }
            table.mostrarTablero();
            win= table.comprobarGanador(win);
            if (!win) {
                empate= table.comprobarEmpate(empate);
                if (empate) {
                    System.out.println("Empate, juego reiniciado");
                    table.resetTable();
                    empate= false;
                }
            }
            i++;
            if (i% 2== 0) {
                cambioMesa= true;
            }
        }
        if (win) {
            table.decirGanador(turn, jugadores);
        }
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
}
