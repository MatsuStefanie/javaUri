import java.util.Scanner;

public class PreencerVetor {
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        int entrada = s.nextInt();
        int[] vetor = new int[1000];

        for (int i=0, cont=0; i!=1000;i++){
           if(cont<entrada){
               vetor[i]= cont;
               System.out.println("N["+i+"] = "+vetor[i]);
               cont++;
           }else{
               cont=0;
               i--;
           }
        }
    }
}