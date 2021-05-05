package javand;

import java.util.Scanner;

public class Sezonai {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite menesio numeri:");
        int sezonoNr = sc.nextInt();

        switch (sezonoNr) {
            case 12, 1 , 2:
                System.out.println("Ziema");
                break;
            case 3, 4, 5:
                System.out.println("Pavasaris");
                break;
            case 6, 7, 8:
                System.out.println("Vasara");
                break;
            case 9, 10, 11:
                System.out.println("Ruduo");
                break;
            default: 
                System.out.println("Ivestas neteisingas menesio numeris");
        }
    }
}
