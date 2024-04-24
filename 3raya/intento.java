import java.util.Scanner;


public class intento {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        char table[][]= new char[3][3];
        char player1= 'x';
        char player2= 'o';
        boolean turn= true;
        boolean win= false;
        boolean empate= false;

        printTable(table);
        while (!win) {
            turn= introduceFicha(sc, turn, table, player1, player2);
            mostrarTablero(table);
            win= comprobarGanador(table, player1, player2, win);
            if (!win) {
                empate= comprobarEmpate(table, player1, player2, empate);
                if (empate) {
                    System.out.println("Empate, juego reiniciado");
                    printTable(table);
                }
            }
        }
        decirGanador(turn, player1, player2);
    }

    public static void printTable(char table[][]) {
        for (int i= 0; i< table.length; i++) {
            for (int j= 0; j< table.length; j++) {
                table [i][j]= ' ';
                if (j== table.length- 1) {
                    System.out.print(table[i][j]);
                }else {
                    System.out.print(table[i][j]+ " | ");
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

    public static boolean introduceFicha(Scanner sc, boolean turn, char table[][], char player1, char player2) {
        int fila;
        int columna;

        if (turn) { //player1
            System.out.println("Jugador 1 introduce ficha: ");
            System.out.print("Fila: ");
            fila= sc.nextInt()- 1;
            while (fila< 0 || fila> table.length) {
                System.out.print("Error al introducir fila, introduce de nuevo: ");
                fila= sc.nextInt()- 1;
            }
            System.out.print("Columna: ");
            columna= sc.nextInt()- 1;
            while (columna< 0 || columna> table.length) {
                System.out.print("Error al introducir columna, introduce de nuevo: ");
                columna= sc.nextInt()- 1;
            }
            comprobarFicha(sc, table, fila, columna, player1);
            turn= false;
        }else { //player2
            System.out.println("Jugador 2 introduce ficha: ");
            System.out.print("Fila: ");
            fila= sc.nextInt()- 1;
            while (fila< 0 || fila> table.length) {
                System.out.print("Error al introducir fila, introduce de nuevo: ");
                fila= sc.nextInt()- 1;
            }
            System.out.print("Columna: ");
            columna= sc.nextInt()- 1;
            while (columna< 0 || columna> table.length) {
                System.out.print("Error al introducir columna, introduce de nuevo: ");
                columna= sc.nextInt()- 1;
            }
            comprobarFicha(sc, table, fila, columna, player2);
            turn= true;
        }
        return turn;
    }

    public static void comprobarFicha(Scanner sc, char table[][], int fila, int columna, char player) {
        while (table[fila][columna]!= ' ') {
            System.out.println("Casilla ocupada, elija una nueva: ");
            System.out.print("Fila: ");
            fila= sc.nextInt()- 1;
            System.out.print("Columna: ");
            columna= sc.nextInt()- 1;
        }
        table[fila][columna]= player;
    }

    public static void mostrarTablero(char table[][]) {
        for (int i= 0; i< table.length; i++) {
            for (int j= 0; j< table.length; j++) {
                if (j== table.length- 1) {
                    System.out.print(table[i][j]);
                }else {
                    System.out.print(table[i][j]+ " | ");
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

    public static boolean comprobarGanador(char table[][], char player1, char player2, boolean win) {
        win= comprobarFila(table, player1, player2, win);
        if (!win) {
            win= comprobarColumna(table, player1, player2, win);
            if (!win) {
                win= comprobarDiaDrch(table, player1, player2, win);
                if (!win) {
                    win= comprobarDiaIzq(table, player1, player2, win);
                }
            }
        }
        return win;
    }

    public static boolean comprobarFila(char table[][], char player1, char player2, boolean win) {
        boolean fin= false;
        int contadorX= 0;
        int contadorO= 0;

        for (int i= 0; i< table.length && (contadorX< 2 || contadorO< 2) ; i++) {
            if (fin) {
                fin= false;
            }
            for (int j= 0; j< table.length- 1 && !fin; j++) {
                if (table[i][j]== player1) {
                    if (table[i][j]== table[i][j+ 1] && table[i][j]!= ' ') {
                        contadorX++;
                    }
                }else if (table[i][j]== player2) {
                    if (table[i][j]== table[i][j+ 1] && table[i][j]!= ' ') {
                        contadorO++;
                    }
                }else {
                    fin= true;
                }
            }
        }
        if (contadorX== 2 || contadorO== 2) {
            win= true;
        }
        return win;
    }

    public static boolean comprobarColumna(char table[][], char player1, char player2, boolean win) {
        boolean fin= false;
        int contadorX= 0;
        int contadorO= 0;
        
        for (int i= 0; i< table.length- 1 && (contadorX< 2 || contadorO< 2); i++) {
            if (fin) {
                fin= false;
            }
            for (int j= 0; j< table.length && !fin; j++) {
                if (table[i][j]== player1) {
                    if (table[i][j]== table[i+ 1][j] && table[i][j]!= ' ') {
                        contadorX++;
                    }
                }else if (table[i][j]== player2) {
                    if (table[i][j]== table[i+ 1][j] && table[i][j]!= ' ') {
                        contadorO++;
                    }
                }else {
                    fin= true;
                }
            }
        }
        if (contadorX== 2 || contadorO== 2) {
            win= true;
        }
        return win;
    }

    public static boolean comprobarDiaDrch(char table[][], char player1, char player2, boolean win) {
        int contadorX= 0;
        int contadorO= 0;

        for (int i= 0; i< table.length- 1; i++) {
            int j= i;
            if (table[i][j]== player1) {
                if (table[i][j]== table[i+ 1][j+ 1] && table[i][j]!= ' ') {
                    contadorX++;
                }
            }else if (table[i][j]== player2) {
                if (table[i][j]== table[i+ 1][j+ 1] && table[i][j]!= ' ') {
                    contadorO++;
                }
            }
        }
        if (contadorX== 2 || contadorO== 2) {
            win= true;
        }
        return win;
    }

    public static boolean comprobarDiaIzq(char table[][], char player1, char player2, boolean win) {
        int contadorX= 0;
        int contadorO= 0;
 
        for (int i= 0; i< table.length- 1; i++) {
            int j= (table.length- 1)- i;
            if (table[i][j]== player1) {
                if (table[i][j]== table[i+ 1][j- 1] && table[i][j]!= ' ') {
                    contadorX++;
                }
            }else if (table[i][j]== player2) {
                if (table[i][j]== table[i+ 1][j- 1] && table[i][j]!= ' ') {
                    contadorO++;
                }
            }
        }
        if (contadorX== 2 || contadorO== 2) {
            win= true;
        }
        return win;
    }

    public static void decirGanador(boolean turn, char player1, char player2) {
        if (turn) {
            System.out.println("JUGADOR 2 WINS!!");
        }else {
            System.out.println("JUGADOR 1 WINS!!");
        }
    }

    public static boolean comprobarEmpate(char table[][], char player1, char player2, boolean empate) {
        int contadorFichas= 0;
        boolean fin= false;
        
        for (int i= 0; i< table.length && !fin; i++) {
            for (int j= 0; j< table.length && !fin; j++) {
                if (table[i][j]!= ' ') {
                    contadorFichas++;
                }else {
                    fin= true;
                }
            }
        }
        if (contadorFichas== 9) {
            empate= true;
        }

        return empate;
    }
}
