public class Jugador {
    public String nombre;
    char ficha;
    boolean turno;

    public Jugador(String nombre, char ficha, boolean turno) {
        this.nombre= nombre;
        this.ficha= ficha;
        this.turno= turno;
    }

    public char getFicha() {
        return ficha;
    }
    
    public void setFicha(char ficha) {
        this.ficha= ficha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre= nombre;
    }

    public void setTurno(boolean turno) {
        this.turno= turno;
    }

    public boolean getTurno() {
        return turno;
    }
}
