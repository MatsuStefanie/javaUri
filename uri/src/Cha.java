import java.util.Scanner;

public class Cha {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int cha = ler.nextInt(),
                acertaram =0;
        for (int i = 0; i<5; i++) {
            int a = ler.nextInt();
            if (a==cha) {
                acertaram++;
            }
        }
        System.out.println(acertaram);
    }
}
