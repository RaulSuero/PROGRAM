public class LogicaAdivina extends Juego {
    boolean win;
    boolean turn= true;
    boolean cambioMesa;
    int numAleatorio;
    int rango;
    int intento;

    public LogicaAdivina() {
        super();
        this.win= false;
        this.cambioMesa= false;
        this.rango= crearRango();
        this.numAleatorio= (int) (Math.random()* rango);
    }

    public boolean getWin() {
        return win;
    }

    public int crearRango() {
        System.out.print("Entre que rango de numeros quieres jugar? ");
        rango= sc.nextInt();
        return rango;
    }

    public void jugar() {
        int i= 0;
        cambioMesa= false;

        while (!win && !cambioMesa) {
            if (turn== jugadores[0].getTurno()) {
                win= introducirIntento(jugadores[0]);
            }else {
                win= introducirIntento(jugadores[1]);
            }
            i++;
            if (i% 2== 0) {
                cambioMesa= true;
            }

            if (!win) {
                if (turn) {
                    turn= false;
                }else {
                    turn= true;
                }
            }
        }
        if (win) {
            decirGanador(turn, jugadores);
        }
    }

    private boolean introducirIntento(Jugador jugador) {
        System.out.println(jugador.getNombre()+ " Introduce tu intento: ");
        if (numAleatorio== sc.nextInt()) {
            win= true;
        }else {
            System.out.println("No es ese numero");
        }

        return win;
    }

    public void decirGanador(boolean turn, Jugador jugadores[]) {
        if (turn== jugadores[1].getTurno()) {
            System.out.println(jugadores[1].getNombre()+ " WINS!!");
        }else {
            System.out.println(jugadores[0].getNombre()+ " WINS!!");
        }
    }
}
