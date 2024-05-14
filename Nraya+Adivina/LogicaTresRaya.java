import java.util.Scanner;

public class LogicaTresRaya extends Juego {
    boolean win;
    boolean empate;
    boolean turn= true;
    boolean cambioMesa;
    Table table;
    Scanner sc= new Scanner(System.in);

    public LogicaTresRaya() {
        super();
        inicalizarJuego();
    }

    public boolean getWin() {
        return win;
    }

    private void inicalizarJuego() {
        this.win= false;
        this.empate= false;
        this.cambioMesa= false;
        table= new Table();
    }

    public void jugar() {
        int i= 0;
        cambioMesa= false;

        while (!win && !cambioMesa) {
            System.out.println();
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
}
