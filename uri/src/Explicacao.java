public class Explicacao {
    public static Integer config = 0;

    private String nome;

    public Explicacao(String nome) {
        super();
        this.nome = nome +  " : " + this.hashCode();
    }

    public String getNome() {
        return config == 1 ? nome: "BAKA";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String buscarHashConfig() {
        return String.valueOf(config.hashCode());
    }

}


class ExplicacaoFilha extends Explicacao {

    private String nome;
    public ExplicacaoFilha(String nome) {
        super(nome);
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return ExplicacaoFilha.config == 1 ? super.getNome() : this.nome;
    }

    public void easterEgg(){
        System.exit(0);
    }
}

class Run {
    public static void main(String[] args) {
        Explicacao matsu = new Explicacao("Matsu");
        ExplicacaoFilha kito = new ExplicacaoFilha("Kito");

        ExplicacaoFilha.config = 0;

        kito.easterEgg();


        System.out.println(matsu.getNome());
        System.out.println(kito.getNome());
    }
}
