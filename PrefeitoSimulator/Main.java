package PrefeitoSimulator;

// Arquivo de Execução do Jogo
public class Main {
    public static void main(String[] args) {
        Jogo game = new Jogo();
        JogoUI ui = new JogoUI(game);
        ui.iniciar();
    }
}