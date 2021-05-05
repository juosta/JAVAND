package javand;

public class Masyvas {

    public static void main(String[] args) {
        int[] m = {1, 2, 3, 4, 5};
        int[][] pirmas = new int[m.length][m.length];
        int[][] antras = new int[m.length][m.length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                pirmas[i][j] = m[(i + j) % m.length];
                System.out.print(pirmas[i][j]);
            }
            System.out.println("");
        }
        System.out.println("---------------");
        for (int i = m.length - 1; i >= 0; i--) {
            for (int j = 0; j < m.length; j++) {
                antras[i][j] = m[(i + j + 1) % m.length];
                System.out.print(antras[i][j]);
            }
            System.out.println("");
        }
        /*
        sukurti kvadratini masyva,
        kurio eiluciu kiekis lygus duoto masyvo elementu kiekiui

        uzpildyti kvadratini masyva tokiu budu:
        1, 2, 3, 4, 5
        2, 3, 4, 5, 1
        3, 4, 5, 1, 2
        4, 5, 1, 2, 3
        5, 1, 2, 3, 4
        atspausdinti

        uzpildyti kvadratini masyva tokiu budu:
        1, 2, 3, 4, 5
        5, 1, 2, 3, 4
        4, 5, 1, 2, 3
        3, 4, 5, 1, 2
        2, 3, 4, 5, 1
        atspausdinti
         */

    }
}
