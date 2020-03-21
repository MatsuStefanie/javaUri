import java.util.Scanner;

public class FatorialSimples {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        int leitura = s.nextInt();
        int[] conta = new int[leitura];
        int resultado =1;
        for(int i=0;i!=conta.length;i++) {
            conta[i] = i + 1;
            resultado *= conta[i];
        }
        System.out.println( resultado);
    }
}
