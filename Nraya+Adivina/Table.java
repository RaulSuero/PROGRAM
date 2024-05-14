import java.util.Scanner;

public class Table {
    Scanner sc= new Scanner(System.in);
    char [][] table;

    public Table() {
        inicializarTablero();
    }

    public void inicializarTablero() {
        tableSize();
    }

    private void tableSize() {
        int size;
        
        System.out.print("Elige tamano del tablero: ");
        size= sc.nextInt();
        table= new char[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j]=' ';
            }
        }
    }

    public void resetTable() { //
        for (int i= 0; i< table.length; i++) {
            for (int j= 0; j< table.length; j++) {
                table[i][j]= ' ';
                if (j== table.length - 1) {
                    System.out.print(table[i][j]);
                }else {
                    System.out.print(table[i][j] + " | ");
                }
            }
            if (i== table.length- 1) {
                System.out.println();
            }else {
                System.out.println();
                System.out.println("- - - - -");
            }
        }
    }

    public boolean introduceFicha(boolean turn, Jugador jugador) {
        int fila;
        int columna;

        System.out.println(jugador.getNombre()+ " introduce ficha: ");
        System.out.print("Fila: ");
        fila= sc.nextInt() - 1;
        while (fila< 0 || fila>= table.length) {
            System.out.print("Error al introducir fila, introduce de nuevo: ");
            fila= sc.nextInt() - 1;
        }
        System.out.print("Columna: ");
        columna= sc.nextInt() - 1;
        while (columna< 0 || columna>= table.length) {
            System.out.print("Error al introducir columna, introduce de nuevo: ");
            columna= sc.nextInt() - 1;
        }
        comprobarFicha(fila, columna, jugador);
        if (turn) {
            turn= false;
        }else {
            turn= true;
        }
        
        return turn;
    }

    private void comprobarFicha(int fila, int columna, Jugador jugador) {
        while (table[fila][columna]!= ' ') {
            System.out.println("Casilla ocupada, elija una nueva casilla: ");
            System.out.print("Fila: ");
            fila= sc.nextInt()- 1;
            System.out.print("Columna: ");
            columna= sc.nextInt()- 1;
        }
        table[fila][columna]= jugador.getFicha();
    }

    public void mostrarTablero() {
        for (int i= 0; i< table.length; i++) {
            for (int j= 0; j < table.length; j++) {
                if (j== table.length- 1) {
                    System.out.print(table[i][j]);
                }else {
                    System.out.print(table[i][j] + " | ");
                }
            }
            if (i== table.length- 1) {
                System.out.println();
            }else {
                System.out.println();
                System.out.println("- - - - -");
            }
        }
    }

    public boolean comprobarGanador(boolean win) {
        win= comprobarFila(win);
        if (!win) {
            win= comprobarColumna(win);
            if (!win) {
                win= comprobarDiagonalDrch(win);
                if (!win) {
                    win= comprobarDiagonalIzq(win);
                }
            }
        }
        return win;
    }
    
    private boolean comprobarFila(boolean win) {
        boolean fin= false;
        
        for (int i= 0; i< table.length && !win; i++) {
            if (table[i][0]!= ' ') {
                win= true;
                fin= false;
                for (int j= 0; j< table.length- 1 && !fin; j++) {
                    if (table[i][j]!= table[i][j+ 1]) {
                        win= false;
                        fin= true;
                    }
                }
            }  
        }
        return win;
    }

    private boolean comprobarColumna(boolean win) {
        boolean fin= false;

        for (int j= 0; j< table.length && !win; j++) {
            if (table[0][j]!= ' ') {
                win= true;
                fin= false;
                for (int i= 0; i< table.length- 1 && !fin; i++) {
                    if (table[i][j]!= table[i+ 1][j]) {
                        win= false;
                        fin= true;
                    }
                }
            }  
        }
        return win;
    }

    private boolean comprobarDiagonalDrch(boolean win) {
        if (table[0][0]!= ' ') {
            win= true;
            for (int i= 0; i< table.length- 1; i++) {
                int j= i;
                if (table[i][j]!= table[i+ 1][j+ 1]) {
                    win= false;
                }
            }
        }  
        return win;
    }

    private boolean comprobarDiagonalIzq(boolean win) {
        if (table[0][table.length- 1]!= ' ') {
            win= true;
            for (int i= 0; i< table.length- 1; i++) {
                int j= (table.length- 1)- i;
                if (table[i][j]!= table[i+ 1][j- 1]) {
                    win= false;
                }
            }
        }    
        return win;
    }

    public boolean comprobarEmpate(boolean empate) {
        int contadorEspacios= 0;
        boolean fin= false;

        for (int i= 0; i< table.length; i++) {
            for (int j= 0; j< table.length; j++) {
                if (table[i][j]== ' ') {
                    contadorEspacios++;
                }
            }
        }
        if (contadorEspacios== 0) {
            empate= true;
        }
        return empate;
    }

    public void decirGanador(boolean turn, Jugador jugadores[]) {
        if (turn== jugadores[0].getTurno()) {
            System.out.println(jugadores[1].getNombre()+ " WINS!!");
        }else {
            System.out.println(jugadores[0].getNombre()+ " WINS!!");
        }
    }
}
