package PrefeitoSimulator;

// Classe responsável para ser o Molde das Escolhas e Consequências que surgirão a partir dos Eventos
public class Escolha {
    private String texto;
    private int ambiente;
    private int economia;
    private int populacao;
    private int aprovacao;
    private String consequencia;

    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public int getAmbiente() {
        return ambiente;
    }
    public void setAmbiente(int ambiente) {
        this.ambiente = ambiente;
    }
    public int getEconomia() {
        return economia;
    }
    public void setEconomia(int economia) {
        this.economia = economia;
    }
    public int getPopulacao() {
        return populacao;
    }
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
    public int getAprovacao() {
        return aprovacao;
    }
    public void setAprovacao(int aprovacao) {
        this.aprovacao = aprovacao;
    }
    public String getConsequencia() {
        return consequencia;
    }
    public void setConsequencia(String consequencia) {
        this.consequencia = consequencia;
    }

    public Escolha(String texto, int ambiente, int economia, int populacao, int aprovacao, String consequencia) {
        this.texto = texto;
        this.ambiente = ambiente;
        this.economia = economia;
        this.populacao = populacao;
        this.aprovacao = aprovacao;
        this.consequencia = consequencia;
    }
}