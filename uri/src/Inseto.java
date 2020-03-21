import java.util.Scanner;

public class Inseto {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int entradalinhas;
        entradalinhas = s.nextInt();

        while (entradalinhas > 0 ){
            int teste = s.nextInt();
            if(teste<=8000){
                System.out.println("Inseto!");
            }else {
                System.out.println("Mais de 8000!");
            }
            entradalinhas--;
        }
    }
}
