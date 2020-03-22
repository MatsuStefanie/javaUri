import java.util.Scanner;

public class Fibovetor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nCasoDeteste = s.nextInt();
        for(int cont = 0; cont<nCasoDeteste;cont++) {
            int entrada = s.nextInt();
            long[] fibo = new long[entrada+1];
            for (int i = 0; i <= entrada; i++) {
                if (i == 0) {
                    fibo[i] = 0;
                } else if (i == 1) {
                    fibo[i] = 1;
                } else {
                    fibo[i] = fibo[i - 1] + fibo[i - 2];
                }
            }
            System.out.println("Fib(" + entrada + ") = " + fibo[entrada]);
        }
    }
}
