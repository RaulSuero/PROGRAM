public class Jugador {
    private String nombre;
    private char ficha;
    private boolean turno;

    public Jugador() {
        this.nombre= " ";
        this.ficha= ' ';
        this.turno= false;
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
