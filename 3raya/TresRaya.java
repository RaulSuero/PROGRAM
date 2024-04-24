import java.util.Scanner;

public class TresRaya {
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
            win= comprobarGanador(table, win);
            if (!win) {
                empate= comprobarEmpate(table, empate);
                if (empate) {
                    System.out.println("Empate, juego reiniciado");
                    printTable(table);
                    empate= false;
                }
            }
        }
        decirGanador(turn);
    }

    public static void printTable(char table[][]) {
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

    public static boolean introduceFicha(Scanner sc, boolean turn, char table[][], char player1, char player2) {
        int fila;
        int columna;

        if (turn) { // player1
            System.out.println("Jugador 1 introduce ficha: ");
            System.out.print("Fila: ");
            fila= sc.nextInt()- 1;
            while (fila< 0 || fila>= table.length) {
                System.out.print("Error al introducir fila, introduce de nuevo: ");
                fila= sc.nextInt()- 1;
            }
            System.out.print("Columna: ");
            columna= sc.nextInt()- 1;
            while (columna< 0 || columna>= table.length) {
                System.out.print("Error al introducir columna, introduce de nuevo: ");
                columna= sc.nextInt()- 1;
            }
            comprobarFicha(sc, table, fila, columna, player1);
            turn= false;
        }else { // player2
            System.out.println("Jugador 2 introduce ficha: ");
            System.out.print("Fila: ");
            fila= sc.nextInt()- 1;
            while (fila< 0 || fila>= table.length) {
                System.out.print("Error al introducir fila, introduce de nuevo: ");
                fila= sc.nextInt()- 1;
            }
            System.out.print("Columna: ");
            columna= sc.nextInt()- 1;
            while (columna< 0 || columna>= table.length) {
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

    public static boolean comprobarGanador(char table[][], boolean win) {
        win= comprobarFila(table, win);
        if (!win) {
            win= comprobarColumna(table, win);
            if (!win) {
                win= comprobarDiagonalDrch(table, win);
                if (!win) {
                    win= comprobarDiagonalIzq(table, win);
                }
            }
        }
        return win;
    }

    public static boolean comprobarFila(char table[][], boolean win) {
        win= true;
        
        for (int i= 0; i< table.length; i++) {
            for (int j= 0; j< table.length- 1; j++) {
                if (table[i][j]!= table[i][j+ 1] || table[i][0]== ' ') {
                    win= false;
                }
            }
        }
        return win;
    }

    public static boolean comprobarColumna(char table[][], boolean win) {
        win= true;

        for (int j= 0; j< table.length; j++) {
            for (int i= 0; i< table.length- 1; i++) {
                if (table[i][j]!= table[i+ 1][j] || table[0][j]== ' ') {
                    win= false;
                }
            }
        }
        return win;
    }

    public static boolean comprobarDiagonalDrch(char table[][], boolean win) {
        win= true;
        
        for (int i= 0; i< table.length- 1; i++) {
            int j= i;
            if (table[i][j]!= table[i+ 1][j +1] || table[0][0]== ' ') {
                win= false;
            }
        }
        return win;
    }

    public static boolean comprobarDiagonalIzq(char table[][], boolean win) {
        win= true;

        for (int i= 0; i< table.length- 1; i++) {
            int j= (table.length- 1)- i;
            if (table[i][j]!= table[i+ 1][j- 1] || table[0][table.length- 1]== ' ') {
                win= false;
            }
        }
        return win;
    }

    public static void decirGanador(boolean turn) {
        if (turn) {
            System.out.println("JUGADOR 2 WINS!!");
        }else {
            System.out.println("JUGADOR 1 WINS!!");
        }
    }

    public static boolean comprobarEmpate(char table[][], boolean empate) {
        int contadorFichas= 0;
        boolean fin= false;

        for (int i= 0; i< table.length && !fin; i++) {
            for (int j= 0; j< table.length && !fin; j++) {
                if (table[i][j]!= ' ') {
                    contadorFichas++;
                } else {
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
