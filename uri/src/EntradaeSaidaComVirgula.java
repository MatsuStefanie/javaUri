import java.util.Scanner;

public class EntradaeSaidaComVirgula {
        public static void main (String[] args){

            Scanner s = new Scanner(System.in);

            String frase = s.nextLine();
            String[] corte;
            corte = frase.split(",");

            System.out.println(corte[0]);
            System.out.println(corte[1]);

        }
}
