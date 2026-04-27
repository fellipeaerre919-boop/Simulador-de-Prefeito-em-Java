package PrefeitoSimulator;

// Classe responsável por Moldar os Eventos no Jogo
public class Evento {
    private String descricao;
    private Escolha[] escolhas;

    public Evento(String descricao, Escolha... escolhas) {
        this.descricao = descricao;
        this.escolhas = escolhas;
    }

    public String getDescricao() {
        return descricao;
    }

    public Escolha[] getEscolhas() {
        return escolhas;
    }
}