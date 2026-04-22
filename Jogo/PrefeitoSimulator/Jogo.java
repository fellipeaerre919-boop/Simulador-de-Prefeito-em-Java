package PrefeitoSimulator;
import java.util.*;

// Classe com os Funcionamentos do Jogo
public class Jogo {
    private int ambiente = 50;
    private int economia = 50;
    private int populacao = 50;
    private int aprovacao = 70;

    private int rodada = 0;
    private final int MAX_RODADAS = 20;

    private Random random = new Random();

    public int getAmbiente() {
        return ambiente;
    }

    public int getEconomia() {
        return economia;
    }  

    public int getPopulacao() {
        return populacao;
    }

    public int getAprovacao() {
        return aprovacao;
    }

    // Limita os Valores dos Atributos 
    private void limitarValores() {
        ambiente = Math.max(0, Math.min(100, ambiente));
        economia = Math.max(0, Math.min(100, economia));
        populacao = Math.max(0, Math.min(100, populacao));
        aprovacao = Math.max(0, Math.min(100, aprovacao));
    }

    // Calcula a Rodada Atual
    public String statusRodada() {
        int rodadaExibida = Math.min(rodada, MAX_RODADAS);
        return "Rodada: " + rodadaExibida + " / " + MAX_RODADAS;
    }    

    // Variáveis para guardar as Listas com os Eventos do Jogo
    private List<Evento> eventos;
    private List<Evento> eventosAprovacaoBaixa;

    // Chama os métodos na classe "BancoDeEscolhas" para inicializar todos os Eventos Normais que existem no Jogo e armazenarem nas variáveis já criadas anteriormente
    public Jogo() {
        eventos = BancoDeEscolhas.eventosNormais();
        eventosAprovacaoBaixa = BancoDeEscolhas.eventoAprovacaoBaixa();
    }
    
    // Aplica as Consequências da Escolha do Jogador
    public void aplicarEscolha(Escolha e) {
        ambiente += e.ambiente;
        economia += e.economia;
        populacao += e.populacao;
        aprovacao += e.aprovacao;
        limitarValores();
        rodada++;
    }

    // Método para Calcular qual será o próximo Evento
    public Evento proximoEvento() {
        // Gatilho para sorteio de Eventos Especiais Baseados em Aprovação Pública
        if (rodada % 5 == 0 && aprovacao < 30 && random.nextInt(100) < 30) {
            return eventosAprovacaoBaixa.get(random.nextInt(eventosAprovacaoBaixa.size()));
        }
        // Sorteio para Eventos Normais na próxima Rodada
        return eventos.get(random.nextInt(eventos.size()));
    }

    // Define os Requerimentos para o Fim de Jogo 
    public boolean isFimDeJogo() {
        return ambiente <= 0 || economia <= 0 || populacao <= 0 || aprovacao <= 0 || rodada > MAX_RODADAS;
    }  
}