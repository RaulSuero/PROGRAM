import java.util.Scanner;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "games")
@XmlType(propOrder = "juegos")
@XmlAccessorType(XmlAccessType.FIELD)

public class JuegoMain {
    @XmlElement(name = "game")
    JuegoXML[] juegos;
 
    public JuegoMain() {

    }

    public JuegoMain(JuegoXML[] juegos) {
        this.juegos= juegos;
    }
/* 
    private void crearMesas() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Cuantas mesas van a jugar: ");
        int mesas = sc.nextInt();
        juegos = new JuegoXML[mesas];
        for (int i = 0; i < juegos.length; i++) {
            System.out.println("Mesa " + (i + 1));
            System.out.println("A que quieres jugar?");
            System.out.println("1. N en raya || 2. Adivina el numero");
        
            if (sc.nextInt() == 1) {
                juegos[i] = new LogicaTresRaya();
            } else {
                juegos[i] = new LogicaAdivina();
            }
            
        }
    }
*/

}
