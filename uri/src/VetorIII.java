import java.text.DecimalFormat;
import java.util.Scanner;

public class VetorIII {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        double inicial = leitura.nextDouble();
        DecimalFormat df = new DecimalFormat("0.0000");
        DecimalFormat df2 = new DecimalFormat("0.00");
        double[] vetor =  new double[100];
        for (int i = 0; i != vetor.length; i++) {
            if (i == 0) {
                vetor[i] = inicial;
            }else{
                vetor[i] = vetor[i-1]/2;
            }
            System.out.println("N["+i+"] = "+ df.format(vetor[i]));
        }
    }
}