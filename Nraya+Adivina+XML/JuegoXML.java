import javax.xml.bind.annotation.*;


@XmlRootElement(name = "game")
@XmlType(propOrder = {"juego", "jugadores", "tamano"})
@XmlAccessorType(XmlAccessType.FIELD)

public class JuegoXML {

    @XmlElement(name = "type")
    private String juego;
    @XmlElement(name = "size")
    private int tamano;
    @XmlElementWrapper(name = "players")
    @XmlElement(name = "player")
    Jugador [] jugadores;
    @XmlTransient
    boolean win;

    public JuegoXML() {
        /* 
        this.jugadores= new Jugador[0];
        crearJugadores();
        seleccionarPrimerJugador();
        */
    }

    public JuegoXML(String juego, Jugador[] jugadores) {
        this.juego= juego;
        this.jugadores= jugadores;
    }

    public boolean getWin() {
        return win;
    }

    public String getJuego() {
        return juego;
    }

    public int getSize() {
        return tamano;
    }
}
