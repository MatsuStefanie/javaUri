import java.util.Scanner;

public class VetorTroca {
    public static void main (String [] args){
        Scanner s =new Scanner(System.in);
        int[] vetor= new int[20];
        for(int i =20;i!=0;i--){
            vetor[i-1]=s.nextInt();
        }
        for(int i=0;i!=20;i++){
            System.out.println("N["+i+"] = "+vetor[i]);
        }
    }
}