/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javand;
public class Fibonacci {

    public static void main(String[] args) {
        fib(0, 1, 5000);
    }

    public static void fib(long s1, long s2, long max) {
        long nextFib = s1 + s2;
        System.out.print(nextFib + " ");
        if (nextFib < max) {
            fib(s2, nextFib, max);
        }
    }
}
