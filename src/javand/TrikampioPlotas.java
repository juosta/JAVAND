package javand;

import java.util.Scanner;

public class TrikampioPlotas {

    //kintamieji
    static double a = 4;
    static double b = 4;
    static double c = 8;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite visu trikampio krastiniu ilgius:");
        
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        System.out.println("a = " + a + "; b = " + b + "; c = " + c + ".");

        double s = trikampioS(a, b, c);
        System.out.println(s == -1.0 ? "Trikampis nesusidaro" : "Trikampio plotas = " + s);
    }

    public static double trikampioS(double a, double b, double c) {
        double p = (a + b + c) / 2; //pusperimetris
        return arNormalusTrikampis(a, b, c) ? Math.sqrt(p * (p - a) * (p - b) * (p - c)) : -1.0;
    }

    public static boolean arNormalusTrikampis(double a, double b, double c) {
        return (a > 0 || b > 0 || c > 0) || (a + b > c || b + c > a || a + c > b);
    }
}
