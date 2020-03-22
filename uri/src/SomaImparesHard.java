import java.util.Scanner;

public class SomaImparesHard {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int casoDeTeste = s.nextInt();


        for (int i = 0; i < casoDeTeste; i++) {
            int iniciandoDe = s.nextInt(), arrayDe = s.nextInt();
            int[] array = new int[arrayDe];
            for (int cont = 0; cont < arrayDe; cont++) {
                if (cont == 0 && iniciandoDe % 2 == 0) {
                    iniciandoDe += 1;
                    array[cont] = iniciandoDe;
                } else if (cont == 0) {
                    array[cont] = iniciandoDe;
                } else {
                    array[cont] = array[cont - 1] + 2;
                }
            }
            int acc = 0;
            for (int i1 : array) {
                acc = acc + i1;
            }
            System.out.println(acc);
        }
    }
}
/*  Scanner ler = new Scanner(System.in);

        int qtdTestes = ler.nextInt();
        for (int i = qtdTestes; i != 0 ; i--) {
            int pontoinicial = ler.nextInt(),
                    qtdImpares = ler.nextInt(),
                    soma = 0;
            if (pontoinicial % 2 == 0) {
                pontoinicial++;
            }
            while (qtdImpares > 0){
                soma += pontoinicial;
                qtdImpares--;
                pontoinicial += 2;
            }
            System.out.print(soma);
        }*/