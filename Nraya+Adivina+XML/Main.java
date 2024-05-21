import java.io.File;
import javax.xml.bind.*;

public class Main {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context= JAXBContext.newInstance(JuegoMain.class);
        Unmarshaller um= context.createUnmarshaller();
        JuegoMain juego= (JuegoMain) um.unmarshal(new File("C:\\Users\\olicu\\Desktop\\DAW\\PROGRAM\\Nraya+Adivina+XML\\Datos.xml"));

        JuegoAbstract[] juegos = new JuegoAbstract[juego.juegos.length];

        for (int i = 0; i < juegos.length; i++) {
            if (juego.juegos[i].getJuego().compareTo("NEnRaya")== 0) {
                juegos[i] = new LogicaTresRaya(juego.juegos[i].getSize());
            }else {
                juegos[i] = new LogicaAdivina();
            }

            juegos[i].jugadores = new Jugador[juego.juegos[i].jugadores.length];
            
            for (int j= 0; j< juego.juegos[i].jugadores.length; j++) {
                juegos[i].jugadores[j]= new Jugador(juego.juegos[i].jugadores[j].getNombre(), juego.juegos[i].jugadores[j].getFicha(), juego.juegos[i].jugadores[j].getTurno());
            }
        }

        boolean terminarJuego = false;
        boolean romperBucle = false;
        int index = 0;

        while (!terminarJuego) {
            juegos[index].jugar();
            for (int i = 0; i < juegos.length && !romperBucle; i++) {
                if (!juegos[i].getWin()) {
                    romperBucle = true;
                }
            }
            if (!romperBucle) {
                terminarJuego = true;
            }
            index++;
            index %= juegos.length;
            romperBucle = false;
        }
        System.out.println("todos los juegos han terminado");
    }
}
