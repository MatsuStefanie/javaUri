import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int entradalinhas;
        entradalinhas = s.nextInt();
        int resultado=0;
        for(;entradalinhas!=0;entradalinhas--){
            int x = s.nextInt();
            int[] xArray;
            xArray = new int[x];
                for(int i =1;i<x;i++){
                    if(x%i==0){
                        xArray[i]=x/i;
                    }else{
                    }
                     resultado+=xArray[i];
                }
                resultado = resultado+1;
                resultado = resultado-x;
                if(resultado==x){
                    resultado=0;
                    System.out.println(x+" eh perfeito");
                }else{
                    resultado=0;
                    System.out.println(x+" nao eh perfeito");
                }
        }
        /*Cada uma das N linhas seguintes contém um valor inteiro X (1 ≤ X ≤ 108), que pode ser ou não, um número perfeito.*/
        /**/

    }
}
