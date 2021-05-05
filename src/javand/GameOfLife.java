/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javand;

/**
 *
 * @author tbulo
 */
public class GameOfLife {

    public static void main(String[] args) {
//        char[][] field = {
//            {'.', 'X', '.', 'X', '.'},
//            {'.', '.', 'X', 'X', '.'},
//            {'.', 'X', 'X', 'X', '.'},
//            {'.', '.', '.', '.', '.'},
//            {'X', 'X', '.', 'X', '.'}
//        };

//        int[][] field = {
//            {0, 1, 0, 1, 0},
//            {0, 0, 1, 1, 0},
//            {0, 1, 1, 1, 0},
//            {0, 0, 0, 0, 0},
//            {1, 1, 0, 1, 0}
//        };
        char[][] field = new char[15][50];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (Math.random() < 0.25) {
                    field[i][j] = 'X';
                } else {
                    field[i][j] = '.';
                }
            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------------");
        int len = field.length;
        int lenj = field[0].length;
        int[][] neighbours = new int[len][lenj];

        for (int k = 1; k <= 50; k++) {
            for (int i = 0; i < len; i++) {

                for (int j = 0; j < lenj; j++) {
                    int nuo1 = 0, nuo2 = 0, iki1 = 0, iki2 = 0;

                    if (field[i][j] == 'X') {
                        neighbours[i][j] = -1;
                    }
                    // Visiems ne krastuose esantiems skaiciams
                    if ((i != 0 && j != 0) && (i != len - 1 && j != lenj - 1)) {
                        nuo1 = -1;
                        nuo2 = -1;
                        iki1 = 1;
                        iki2 = 1;
                    }

                    if (i == 0 && j != 0 && i != len - 1 && j != lenj - 1) {
                        nuo1 = 0;
                        nuo2 = -1;
                        iki1 = 1;
                        iki2 = 1;
                    }

                    if (j == 0 && i != 0 && i != len - 1 && j != lenj - 1) {
                        nuo1 = -1;
                        nuo2 = 0;
                        iki1 = 1;
                        iki2 = 1;
                    }

                    if (i == len - 1 && j != lenj - 1 && i != 0 && j != 0) {
                        nuo1 = -1;
                        nuo2 = -1;
                        iki1 = 0;
                        iki2 = 1;
                    }

                    if (j == lenj - 1 && i != len - 1 && i != 0 && j != 0) {
                        nuo1 = -1;
                        nuo2 = -1;
                        iki1 = 1;
                        iki2 = 0;
                    }

                    //kampai
                    if (i == 0 && j == 0) {
                        nuo1 = 0;
                        nuo2 = 0;
                        iki1 = 1;
                        iki2 = 1;

                    }
                    if (j == 0 && i == len - 1) {
                        nuo1 = -1;
                        nuo2 = 0;
                        iki1 = 0;
                        iki2 = 1;
                    }
                    if (i == 0 && j == lenj - 1) {
                        nuo1 = 0;
                        nuo2 = -1;
                        iki1 = 1;
                        iki2 = 0;
                    }
                    if (j == lenj - 1 && i == len - 1) {
                        nuo1 = -1;
                        nuo2 = -1;
                        iki1 = 0;
                        iki2 = 0;
                    }

                    for (int a = nuo1; a <= iki1; a++) {
                        for (int b = nuo2; b <= iki2; b++) {

                            if (field[i + a][j + b] == 'X') {
                                neighbours[i][j] += 1;
                            }
                        }
                    }

                    //System.out.print(field[i][j]);
                    // System.out.print(neighbours[i][j]);
                }

            }
            //  }

            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] == '.') {
                        if (neighbours[i][j] == 3) {
                            field[i][j] = 'X';
                        }
                        if (neighbours[i][j] < 3 || neighbours[i][j] > 3) {
                            field[i][j] = '.';
                        }
                    }
                    if (field[i][j] == 'X') {
                        if (neighbours[i][j] == 2 || neighbours[i][j] == 3) {
                            field[i][j] = 'X';
                        }
                        if (neighbours[i][j] < 2 || neighbours[i][j] > 3) {
                            field[i][j] = '.';
                        }
                    }
                }

            }

            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println("");
            }
        }
        /*
        Game Of Life

        Turim pradine lenta

        kiekvienam langeliui paskaiciuojam kaimynu kieki
        jei langelis buvo tuscias:
            jei kaimynu kiekis 3 - naujoj iteracijoj gyventojas atsiras
            jei kaimynu kiekis <3 arba >3 - naujoj iteracijoj gyventojas neatsiras
        jei langelis buvo gyvenamas:
            jei kaimynu kiekis 2 arba 3 - naujoj iteracijoj gyventojas liks gyventi
            jei kaimynu kiekis <2 arba >3 - naujoj iteracijoj gyventojas mirs

        1. atspausdinti 50 iteraciju
        2. nutraukti spausdinima, jei nauja iteracija yra tokia pati, kaip ir pries tai buvusi
        3. nutraukti spausdinima, jei istorijoje yra tokia pati iteracija

         */
    }
}
