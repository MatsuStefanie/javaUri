import java.util.Scanner;

public class VetorFull {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] vetor = new int[10];
        int leitura = s.nextInt();
        for (int i = 0; i < 10 ; i++) {
            if(i==0){
                vetor[i]= leitura;
            }else{
                vetor[i]=vetor[i-1]+vetor[i-1];
            }
            System.out.println("N["+ i +"] = "+vetor[i]);
        }
    }
}
