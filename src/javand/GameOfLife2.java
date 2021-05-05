package javand;

public class GameOfLife2 {

    static char[][] field = new char[15][50];
//    static char[][] field = {
//        {'.', 'X', '.', 'X', '.'},
//        {'.', '.', 'X', 'X', '.'},
//        {'.', 'X', 'X', 'X', '.'},
//        {'.', '.', '.', '.', '.'},
//        {'X', 'X', '.', 'X', '.'}
//    };

    public static void main(String[] args) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (Math.random() < 0.6) {
                    field[i][j] = 'X';
                } else {
                    field[i][j] = '.';
                }
            }
        }
        int iterations = 50; //iteraciju kiekis
        String[] history = new String[iterations + 1];
        int[][] neighbours = new int[field.length][field[0].length];
        for (int k = 1; k <= iterations; k++) {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    int countNeighbour = isNeighbour(i - 1, j - 1)
                            + isNeighbour(i - 1, j)
                            + isNeighbour(i - 1, j + 1)
                            + isNeighbour(i, j - 1)
                            + isNeighbour(i, j + 1)
                            + isNeighbour(i + 1, j - 1)
                            + isNeighbour(i + 1, j)
                            + isNeighbour(i + 1, j + 1);
                    neighbours[i][j] = countNeighbour;
                }
            }
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
                System.out.println();
            }
            history[k] = getString();
            for (int h = 0; h < k; h++) {
                if (history[k].equals(history[h])) {
                    return;
                }
            }
            System.out.println(k + "-----------------");

        }
    }

    static int isNeighbour(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (i >= field.length || j >= field[0].length) {
            return 0;
        }

        return field[i][j] == 'X' ? 1 : 0;
    }

    static String getString() {
        String result = "";

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                result += field[i][j];
            }
        }

        return result;
    }
}
