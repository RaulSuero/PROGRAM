import javax.xml.bind.annotation.*;

@XmlRootElement(name = "player")
@XmlType(propOrder = {"nombre", "ficha", "turno"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Jugador {
    @XmlElement(name = "name")
    private String nombre;
    @XmlElement(name = "token")
    private String ficha;
    @XmlElement(name = "turn")
    private boolean turno;

    public Jugador() {
        this.nombre= " ";
        this.ficha= " ";
        this.turno= false;
    }

    public Jugador(String nombre, String ficha, boolean turno) {
        this.nombre= nombre;
        this.ficha= ficha;
        this.turno= turno;
    }

    public String getFicha() {
        return ficha;
    }
    
    public void setFicha(String ficha) {
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
