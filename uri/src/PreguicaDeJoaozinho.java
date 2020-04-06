import java.text.DecimalFormat;
import java.util.Scanner;

public class PreguicaDeJoaozinho {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        double tempo = leitura.nextDouble(),
                velocidade = leitura.nextDouble();
        double resultado = velocidade/12;
        resultado*=tempo;
        DecimalFormat df = new DecimalFormat("0.000");
        System.out.println(df.format(resultado));
    }
}
