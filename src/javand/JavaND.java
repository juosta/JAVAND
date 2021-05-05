/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javand;

import java.util.Scanner;

public class JavaND {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite pirma skaiciu:");
        int firstNum = sc.nextInt();
        System.out.println("Iveskite pirma skaiciu:");
        int secondNum = sc.nextInt();

        int higher, lower, sum = 0;

        if (firstNum == secondNum) {
            System.out.println("Abu skaiciai yra lygus.");
            return;
        }

        if (firstNum > secondNum) {
            higher = firstNum;
            lower = secondNum;
        } else {
            lower = firstNum;
            higher = secondNum;
        }

//        System.out.println("Duotu dvieju skaiciu intervalo visu skaiciu suma: "); 
//        while (lower <= higher){
//            sum += lower;
//            lower++;
//        }
//        System.out.println(sum);


//        int odd;
//        System.out.println("Visi nelyginiai skaiciai ivestame intervale: ");
//
//        while (lower <= higher) {
//            odd = lower % 2;
//
//            if (odd != 0) {
//                System.out.print(lower + " ");
//            }
//
//            lower++;
//        }

        int daugyba = 0;
        System.out.println("Ivestu dvieju skaiciu daugybos lentele: ");
        for (int i = lower; i <= higher; i++) {
            for (int j = lower; j <= higher; j++) {
                daugyba = j * i;
                System.out.print(daugyba + " ");
            }
            System.out.println("");
        }

    }

}
