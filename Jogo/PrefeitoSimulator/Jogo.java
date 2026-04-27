package PrefeitoSimulator;
import java.util.*;

// Classe com os Funcionamentos do Jogo
public class Jogo {
    private int totalEvento = 0;
    private int ambiente = 50;
    private int economia = 50;
    private int populacao = 50;
    private int aprovacao = 50;

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
    private List<Evento> eventoAprovacaoAlta;
    private List<Evento> eventoAmbienteAlto;
    private List<Evento> eventoEconimiaAlta;
    private List<Evento> eventoEconimiaBaixa;

    // Chama os métodos na classe "BancoDeEscolhas" para inicializar todos os Eventos Normais que existem no Jogo e armazenarem nas variáveis já criadas anteriormente
    public Jogo() {
        eventos = BancoDeEscolhas.eventosNormais();
        eventoAprovacaoAlta = BancoDeEscolhas.eventoAprovacaoAlta();
        eventoAmbienteAlto = BancoDeEscolhas.eventoAmbienteAlto();
        eventoEconimiaAlta = BancoDeEscolhas.eventoEconomiaAlta();
        eventoEconimiaBaixa = BancoDeEscolhas.eventoEconomiaBaixa();
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

    List<Evento> eventosPossiveis = new ArrayList<>();

        // Eventos especiais

        // Evento Especial Aprovação alta
        if (rodada % 3 == 0 && aprovacao >= 70) {
            eventosPossiveis.addAll(eventoAprovacaoAlta);
        }

        //Eventos Especial Meio Ambiente Alto
        if (rodada % 2 == 0 && ambiente >= 70) {
            eventosPossiveis.addAll(eventoAmbienteAlto);
        }

        //Evento Especial Economia Alta
        if (rodada % 3 == 0 && economia >= 70) {
            eventosPossiveis.addAll(eventoEconimiaAlta);
        }

        //Evento Especial Economia Baixa
        if (rodada % 2 == 0 && economia <= 45) {
            eventosPossiveis.addAll(eventoEconimiaBaixa);
        }

        // Sorteia evento especial
        if (!eventosPossiveis.isEmpty() && random.nextInt(100) < 45) {
            return eventosPossiveis.get(random.nextInt(eventosPossiveis.size()));
        }

        // Eventos normais sem repetição
        if (totalEvento >= eventos.size()) {
            Collections.shuffle(eventos);
            totalEvento = 0;
        }

        return eventos.get(totalEvento++);
    }

    // Define os Requerimentos para o Fim de Jogo 
    public boolean isFimDeJogo() {
        return ambiente <= 0 || economia <= 0 || populacao <= 0 || aprovacao <= 0 || rodada > MAX_RODADAS;
    }  
}