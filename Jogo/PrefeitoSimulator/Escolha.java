package PrefeitoSimulator;

// Classe responsável para ser o Molde das Escolhas e Consequências que surgirão a partir dos Eventos
public class Escolha {
    public String texto;
    public int ambiente;
    public int economia;
    public int populacao;
    public int aprovacao;
    public String consequencia;

    public Escolha(String texto, int ambiente, int economia, int populacao, int aprovacao, String consequencia) {
        this.texto = texto;
        this.ambiente = ambiente;
        this.economia = economia;
        this.populacao = populacao;
        this.aprovacao = aprovacao;
        this.consequencia = consequencia;
    }
}
