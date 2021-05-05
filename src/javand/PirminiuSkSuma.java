
package javand;

public class PirminiuSkSuma {

    public static void main(String[] args) {
        int nuo = 4;
        int iki = 2000;
        for (int i = nuo; i <= iki; i += 2) {
            prime(i);
        }
    }

    public static boolean isPrime(int n) {
        int i, m;
        m = n / 2;
        if (n == 0 || n == 1) {
            return false;
        } else {
            for (i = 2; i <= m; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void prime(int n) {
        int prime1 = n - 2, prime2 = n - prime1;
        boolean found = false;
        while (!found && prime1 > 1) {
            if (!isPrime(prime1) || !isPrime(prime2)) {
                prime1--;
                prime2 = n - prime1;
            } else {
                System.out.println(n + " = " + prime1 + " + " + prime2);
                found = true;
            }
        }
    }
}
