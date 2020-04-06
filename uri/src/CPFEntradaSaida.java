import java.util.Scanner;

public class CPFEntradaSaida {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String ler = leitura.next();
        String[] arrayDeLeitura = ler.split("[^0-9]");
        for (int i = 0; i < 4; i++) {
            System.out.println(arrayDeLeitura[i]);
        }
    }
}
