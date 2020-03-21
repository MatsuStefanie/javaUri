import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static int COLUNA_X = 0;
    private static int COLUNA_Y = 1;
    public static List<Cordenada> cordenadas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // declarando variaveis
        Scanner ler = new Scanner(System.in);
        Integer quantidadePontos;

        // bloco principal
        do {
            cordenadas.clear();

            quantidadePontos = getQuantidadePontos(ler); // buscando quantidade de pontos cartezianos

            Integer[][] pontos = buscarMatrixParametros(ler, quantidadePontos);  // buscando os pontos

            Integer[][] cartesiano = montarPlanoCartesiano(pontos); // montar Plano cartesiano

            montarJogo(cartesiano, pontos);

            calcularQuantidadeVerticeMaximo(cartesiano, pontos);


        } while (!quantidadePontos.equals(0));


    }

    private static void calcularQuantidadeVerticeMaximo(Integer[][] cartesiano, Integer[][] pontos) {

        Integer qtdVertices = 0;

        for (Cordenada cordenada : cordenadas.stream().sorted((o1, o2) -> o2.getX().compareTo(o1.getX())).collect(Collectors.toList())) {
            Integer vertices = calcularVertices(cordenada);
            if (vertices > qtdVertices) {
                qtdVertices = vertices ;
            }
        }

        System.out.println(qtdVertices);

    }

    private static Integer calcularVertices(Cordenada cordenada) {

        List<Cordenada> filtro = cordenadas.stream()
                .filter(cordenadaFilter -> cordenadaFilter.getX() <= cordenada.getX())
                .sorted((o1, o2) -> o2.getX().compareTo(o1.getX()))
                .collect(Collectors.toList());

        List<Cordenada> poligono = filtro.stream()
                .filter(cordenadaFilter -> cordenadaFilter.getX().equals(cordenada.getX())).collect(Collectors.toList());

        filtro.removeAll(poligono);

        var ref = new Object() {
            Integer maiorY = poligono.stream().map(Cordenada::getY).max(Integer::compareTo).orElse(0);
            Integer menorY = poligono.stream().map(Cordenada::getY).min(Integer::compareTo).orElse(0);
        };
        while (filtro.size() > 0) {
            Cordenada atual = filtro.stream().findFirst().orElse(new Cordenada(0, 0));

            if (atual.getY() >= ref.maiorY) {
                if (atual.getY() > ref.maiorY && poligono.stream().filter(cor -> ( !cor.getY().equals(cordenada.getY() )&& cor.getY().equals(ref.maiorY))).collect(Collectors.toList()).size() > 1) {
                    Cordenada pontosMaiorY = poligono.stream()
                            .filter(cordenada1 -> cordenada.getY()
                                    .equals(ref.maiorY)).min(Comparator.comparing(Cordenada::getX))
                            .orElse(null);
                    poligono.remove(pontosMaiorY);
                }

                poligono.add(atual);
                ref.maiorY = atual.getY();

            } else if (atual.getY() <= ref.menorY) {
                if (atual.getY() < ref.menorY && poligono.stream().filter(cor -> cor.getY().equals(ref.menorY)).collect(Collectors.toList()).size() > 1) {
                    Cordenada pontosMenorY = poligono.stream()
                            .filter(cordenada1 -> cordenada.getY()
                                    .equals(ref.menorY)).min(Comparator.comparing(Cordenada::getX))
                            .orElse(null);
                    poligono.remove(pontosMenorY);
                }

                poligono.add(atual);
                ref.menorY = atual.getY();
            }

            filtro.remove(atual);
            // se o Y é igual ao do maior eu só o adciono
            // se o Y é maior eu verifico todos os anteriore iguais ao maior e removo do poligono
            // em caso de alteração se tiver alguem com o mesmo Y remover do poligono

        }

        return poligono.size();
    }


    private static Integer[][] montarPlanoCartesiano(Integer[][] pontos) {
        Integer maximoX = calcularTamanhoMaximoX(pontos, COLUNA_X);
        Integer maximoY = calcularTamanhoMaximoX(pontos, COLUNA_Y);

        Integer[][] cartesiano = iniciarCartesiano(maximoX, maximoY);


        return cartesiano;
    }

    private static void montarJogo(Integer[][] cartesiano, Integer[][] pontos) {
        for (int i = 0; i < pontos.length; i++) {
            Integer x = pontos[i][COLUNA_X];
            Integer y = pontos[i][COLUNA_Y];
            cartesiano[x][y] = 1;
        }

        apresentarMatriz(cartesiano);
    }

    private static Integer[][] iniciarCartesiano(Integer maximoX, Integer maximoY) {
        Integer[][] cartesiano = new Integer[maximoX + 1][maximoY + 1];

        for (int linha = 0; linha < cartesiano.length; linha++) {
            for (int coluna = 0; coluna < cartesiano[0].length; coluna++) {
                cartesiano[linha][coluna] = 0;
            }
        }

        return cartesiano;
    }

    private static Integer calcularTamanhoMaximoX(Integer[][] pontos, Integer qualColuna) {

        Integer maximo = 0;

        for (int i = 0; i < pontos.length; i++) {
            if (pontos[i][qualColuna] > maximo) {
                maximo = pontos[i][qualColuna];
            }
        }

        return maximo;
    }

    private static Integer[][] buscarMatrixParametros(Scanner ler, Integer quantidadePontos) {
        Integer[][] pontos = new Integer[quantidadePontos + 1][2];

        pontos[0][0] = 0;
        pontos[0][1] = 0;

        cordenadas.clear();
        cordenadas.add(new Cordenada(0, 0));

        for (Integer i = 1; i <= quantidadePontos; i++) {
            pontos[i][0] = ler.nextInt();
            pontos[i][1] = ler.nextInt();
            cordenadas.add(new Cordenada(pontos[i][0], pontos[i][1]));
        }

//        apresentarMatriz(pontos);

        return pontos;
    }

    private static void apresentarMatriz(Integer[][] pontos) {

        //linhas
        for (int linha = pontos.length - 1; linha >= 0; linha--) {
            System.out.print("[ ");
            for (int coluna = 0; coluna < pontos[0].length; coluna++) {
                System.out.print(pontos[linha][coluna] + " ");
            }
            System.out.println(" ]");
        }
    }

    private static int getQuantidadePontos(Scanner ler) {
        return ler.nextInt();
    }
}

class Cordenada {
    private Integer x;
    private Integer y;

    public Cordenada(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getY() {
        return y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cordenada cordenada = (Cordenada) o;
        return Objects.equals(x, cordenada.x) &&
                Objects.equals(y, cordenada.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
