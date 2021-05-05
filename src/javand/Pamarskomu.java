package javand;

import java.util.Scanner;

/*
    Akmuo - popierius - zirkles

    Programa leidzia vartotojui pasirinkti:

    1. Akmuo
    2. Popierius
    3. Zirkles
    0. Pabaiga

    Jei ne pabaiga:
    Kompiuteris atsitiktinai pasirenka
    palyginam ir parasom kas laimejo

    ir vel spausdinam meniu
    jei vartotojas pasirinko ne 0..3 - pavadinikit vartotjoa mulkiu ir vel meniu

    ****
    Programa paklausia kiek kartu reikia suzaist

    Kompiuteris zaidzia su savim

    Pabaigoj atsapausdinti statistika:

    comp1 laimejo: XXXX
    comp2 laimejo: XXXX
    lygiosios: XXXX

    comp1:
    pasirino akmeni: XX
    pasirinko popieriu: XX
    pasirinko zirkles: XX

    comp2:
    pasirino akmeni: XX
    pasirinko popieriu: XX
    pasirinko zirkles: XX

 */
public class Pamarskomu {

    static String[] names = {"akmuo", "popierius", "zirkles"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("kas zais? 1 - tu pries kompa; 0 - kompas su savim");
        int who = sc.nextInt();

        if (who == 1) {
            meniu();

            int user = sc.nextInt();
            while (user != 0) {
                if (user > 3 || user < 0) {
                    System.out.println("skaicius turi buti  0...3");
                    break;
                }
                int comp1 = (int) (Math.random() * 3) + 1;

                pamarskomu(user, comp1);
                System.out.println("------------");
                meniu();
                user = sc.nextInt();
            }
        }

        if (who == 0) {
            System.out.println("Kiek kartu zais?");
            int k = sc.nextInt();
            int winner;
            int[] stats = new int[3];
            int[] player1Stats = new int[3];
            int[] player2Stats = new int[3];
            for (int i = 1; i <= k; i++) {
                System.out.println("PO " + i + " zaidimo:");
                int comp1 = (int) (Math.random() * 3) + 1;
                int comp2 = (int) (Math.random() * 3) + 1;
                winner = pamarskomu(comp1, comp2);
                switch (winner) {
                    case 0:
                        stats[0] += 1;
                        break;
                    case 1:
                        stats[1] += 1;
                        break;
                    default:
                        stats[2] += 1;
                        break;
                }
                playerStats(comp1, player1Stats);
                playerStats(comp2, player2Stats);

                System.out.println("--------");
                System.out.println("");
            }
            System.out.println("Statistika: ");
            System.out.println("Laimejo pirmas zaidejas: " + stats[1]);
            System.out.println("Laimejo antras zaidejas: " + stats[2]);
            System.out.println("Lygiosios: " + stats[0]);
            System.out.println("comp1:");
            System.out.println("pasirinko akmeni: " + player1Stats[0]);
            System.out.println("pasirinko popieriu: " + player1Stats[1]);
            System.out.println("pasirinko zirkles: " + player1Stats[2]);
            System.out.println("comp2:");
            System.out.println("pasirinko akmeni: " + player2Stats[0]);
            System.out.println("pasirinko popieriu: " + player2Stats[1]);
            System.out.println("pasirinko zirkles: " + player2Stats[2]);
        }
    }

    public static void meniu() {
        System.out.println("PAMARSKOMU: ivesk skaiciu, ka mesi?");
        System.out.println("1 - akmuo");
        System.out.println("2 - popierius");
        System.out.println("3 - zirkles");
        System.out.println("0 - pabaiga");
    }

    public static int pamarskomu(int firstPlayer, int secondPlayer) {
        /*
        0 - lygiosios; 
        1 - laimejo pirmas;
        2 - laimejo antras;
         */
        System.out.println(names[firstPlayer - 1] + " pries " + names[secondPlayer - 1]);
        int winner = 0;
        if (firstPlayer == secondPlayer) {
            winner = 0;
            System.out.println("LYGIOSIOS");
            return 0;
        }
        if ((firstPlayer) % 3 + 1 == secondPlayer) {
            winner = 2;
        } else {
            winner = 1;
        }
        System.out.println(winner == 1 ? "laimejo PIRMAS zaidejas" : "laimejo ANTRAS zaidejas");
        return winner;
    }

    public static int[] playerStats(int player, int[] playerStats) {
        switch (player) {
            case 1:
                playerStats[0] += 1;
                break;
            case 2:
                playerStats[1] += 1;
                break;
            default:
                playerStats[2] += 1;
                break;
        }
        return playerStats;
    }

}
