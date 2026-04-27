package PrefeitoSimulator;
import java.util.*;

// Classe responsável por armazenar todos os Eventos presentes no Jogo
public class BancoDeEscolhas {
    // Eventos Normais
    public static List<Evento> eventosNormais() {
        List<Evento> eventos = new ArrayList<>();

        eventos.add(new Evento("Uma grande indústria quer se instalar às margens do principal rio da cidade.",

            new Escolha("Aprovar com regras ambientais", -1, +10, +6, +6,
            "A indústria opera com fiscalização. O crescimento vem acompanhado de responsabilidade ambiental.\n\n -1 de Meio Ambiente \n +10 de Fundos Econômicos \n +6 de População \n +6 de Aprovação Pública"),

            new Escolha("Aprovar sem restrições", -10, +12, +3, -8,
            "A economia cresce rapidamente, mas o rio começa a apresentar sinais graves de poluição. A população se divide entre emprego e saúde.\n\n -10 de Meio Ambiente \n +12 de Fundos Econômicos \n +3 de População \n -8 de Aprovação Pública"),


            new Escolha("Negar instalação", +8,0, -3, -2,
            "Você protege o rio, mas perde investimentos. Parte da população critica a decisão.\n\n +8 de Meio Ambiente\n -3 de População \n -2 de Aprovação Pública")
        ));

        eventos.add(new Evento("O sistema de saneamento está sobrecarregado e começa a falhar em várias regiões.",
            new Escolha("Reforma completa do sistema", +12, -8, +9, +7,
            "A cidade dá um salto em qualidade de vida, reduzindo doenças e poluição.\n\n +12 de Meio Ambiente \n -8 de Fundos Econômicos \n +9 de População \n +7 de Aprovação Pública"),

            new Escolha("Melhorias pontuais", +5, -5, +5, +3,
            "A situação melhora, mas ainda há áreas críticas.\n\n +5 de Meio Ambiente \n -5 de Fundos Econômicos \n +5 de População \n +3 de Aprovação Pública"),

            new Escolha("Adiar investimentos", -12, 0, -8, -8,
            "A crise se agrava e afeta diretamente a saúde da população.\n\n -12 de Meio Ambiente\n -8 de População \n -8 de Aprovação Pública")
        ));

        eventos.add(new Evento("O trânsito da cidade está ficando insustentável.",
            new Escolha("Expandir transporte sustentável", +8, -6, +5, +3,
            "Menos carros nas ruas e mais qualidade de vida. A cidade respira melhor.\n\n +8 de Meio Ambiente \n -6 de Fundos Econômicos \n +5 de População \n +3 de Aprovação Pública"),

            new Escolha("Construir mais avenidas", -6, -8, +6, +3,
            "O trânsito melhora por um tempo, mas o impacto ambiental cresce.\n\n -6 de Meio Ambiente \n -8 de Fundos Econômicos \n +6 de População \n +3 de Aprovação Pública"),

            new Escolha("Ignorar", -8, 0, -9, -7,
            "Congestionamentos pioram e a população perde produtividade.\n\n -8 de Meio Ambiente\n -9 de População \n -7 de Aprovação Pública")
        ));

        eventos.add(new Evento("Uma empresa oferece um acordo ilegal para ignorar leis ambientais.",
            new Escolha("Aceitar", -12, +12, -4, -12,
            "Você ganha recursos, mas sua reputação desmorona e o meio ambiente sofre.\n\n -12 de Meio Ambiente \n +12 de Fundos Econômicos \n -4 de População \n -12 de Aprovação Pública"),

            new Escolha("Recusar", +5, 0, +5, +6,
            "Você mantém sua integridade e ganha respeito público.\n\n +5 de Meio Ambiente\n +5 de População \n +6 de Aprovação Pública"),

            new Escolha("Denunciar", +7, 0, +6, +10,
            "A justiça é feita e sua popularidade cresce significativamente.\n\n +7 de Meio Ambiente\n +6 de População \n +10 de Aprovação Pública")
        ));

        eventos.add(new Evento("Uma crise econômica global começa a afetar sua cidade.",
            new Escolha("Cortar gastos ambientais", -8, +12, -6, -5,
            "A economia melhora no curto prazo, mas o impacto ambiental aumenta.\n\n -8 de Meio Ambiente \n +12 de Fundos Econômicos \n -6 de População \n -5 de Aprovação Pública"),

            new Escolha("Investir em economia verde", +6, +6, +6, +6,
            "Crescimento mais lento, porém sustentável e equilibrado.\n\n +6 de Meio Ambiente \n +6 de Fundos Econômicos \n +6 de População \n +6 de Aprovação Pública"),

            new Escolha("Não agir", 0, -10, -10, -10,
            "A crise se aprofunda e afeta todos os setores da cidade.\n -10 de Fundos Econômicos \n -10 de População \n -10 de Aprovação Pública")
        ));

        eventos.add(new Evento("Grupos organizam protestos exigindo ações ambientais imediatas.",
            new Escolha("Dialogar e propor soluções", +7, 0, +9, +10,
            "A população sente que foi ouvida e confia mais na gestão.\n\n +7 de Meio Ambiente \n +9 de População \n +10 de Aprovação Pública"),

            new Escolha("Reprimir", -4, 0, -12, -12,
            "A situação sai do controle e sua imagem piora drasticamente.\n\n -4 de Meio Ambiente\n -12 de População \n -12 de Aprovação Pública"),

            new Escolha("Ignorar", -7, 0, -9, -9,
            "Os protestos crescem e viram um problema maior.\n\n -7 de Meio Ambiente\n -9 de População \n -9 de Aprovação Pública")
        ));;

        eventos.add(new Evento("Um projeto de energia limpa é apresentado ao governo.",
            new Escolha("Investir totalmente", +10, -8, +8, +8,
            "A cidade avança rumo à sustentabilidade energética.\n\n +10 de Meio Ambiente \n -8 de Fundos Econômicos \n +8 de População \n +8 de Aprovação Pública"),

            new Escolha("Parceria privada", +6, +6, +7, +6,
            "O projeto avança com menor custo público.\n\n +6 de Meio Ambiente \n +6 de Fundos Econômicos \n +7 de População \n +6 de Aprovação Pública"),

            new Escolha("Rejeitar", -3, 0, -5, -5,
            "A cidade perde uma oportunidade de inovação.\n\n -3 de Meio Ambiente\n -5 de População \n -5 de Aprovação Pública")
        ));

        eventos.add(new Evento("Um desastre ambiental ameaça áreas da cidade.",
            new Escolha("Resposta rápida e eficiente", +12, -8, +7, +6,
            "A crise é controlada e os danos são minimizados.\n\n +12 de Meio Ambiente \n -8 de Fundos Econômicos \n +7 de População \n +6 de Aprovação Pública"),

            new Escolha("Resposta limitada", +4, -5, 0, -2,
            "Parte do problema é resolvida, mas consequências permanecem.\n\n +4 de Meio Ambiente \n -5 de Fundos Econômicos\n -2 de Aprovação Pública"),

            new Escolha("Ignorar", -12, 0, -10, -12,
            "A situação sai do controle e gera danos severos.\n\n -12 de Meio Ambiente\n -10 de População \n -12 de Aprovação Pública")
        ));

        eventos.add(new Evento("A cidade discute implementar coleta seletiva de lixo.",
            new Escolha("Implementar totalmente", +10, -6, +7, +8,
            "A cidade reduz drasticamente o lixo e melhora a reciclagem.\n\n +10 de Meio Ambiente \n -6 de Fundos Econômicos \n +7 de População \n +8 de Aprovação Pública"),

            new Escolha("Projeto piloto", +5, -3, +5, +4,
            "Algumas regiões já mostram resultados positivos.\n\n +5 de Meio Ambiente \n -3 de Fundos Econômicos \n +5 de População \n +4 de Aprovação Pública"),

            new Escolha("Ignorar", -8, 0, -5, -6,
            "O acúmulo de lixo se torna um problema crescente.\n\n -8 de Meio Ambiente\n -5 de População\n -6 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("Há uma proposta de incentivo à energia solar residencial.",
            new Escolha("Subsidiar instalação", +10, -8, +8, +8,
            "A cidade se torna referência em energia limpa.\n\n +10 de Meio Ambiente\n -8 de Fundos Econômicos\n +8 de População\n +8 de Aprovação Pública"),

            new Escolha("Incentivo leve", +6, -2, +6, +5,
            "Parte da população adere à ideia.\n\n +6 de Meio Ambiente\n -2 de Fundos Econômicos\n +6 de População\n +5 de Aprovação Pública"),

            new Escolha("Não incentivar", -5, 0, -4, -4,
            "A cidade fica para trás na transição energética.\n\n -5 de Meio Ambiente\n -4 de População\n -4 de Aprovação Pública")
        ));

        eventos.add(new Evento("O consumo de água está aumentando rapidamente.",
            new Escolha("Políticas de controle e reuso", +10, -5, +6, +7,
            "O consumo é controlado e o futuro hídrico é garantido.\n\n +10 de Meio Ambiente\n -5 de Fundos Econômicos\n +6 de População\n +7 de Aprovação Pública"),

            new Escolha("Campanhas educativas", +5, -1, +5, +5,
            "A população reduz o consumo parcialmente.\n\n +5 de Meio Ambiente\n -1 de Fundos Econômicos\n +5 de População\n +5 de Aprovação Pública"),

            new Escolha("Ignorar", -10, 0, -8, -8,
            "A cidade caminha para uma crise hídrica.\n\n -10 de Meio Ambiente\n -8 de População\n -8 de Aprovação Pública")
        ));

        eventos.add(new Evento("Um escândalo político envolvendo membros do seu governo vem à tona.",
            new Escolha("Investigar e punir os responsáveis", 0, -2, +5, +10,
            "Você mostra firmeza e transparência, recuperando a confiança da população, mesmo com custos políticos.\n\n -2 de Fundos Econômicos\n +5 de População\n +10 de Aprovação Pública"),

            new Escolha("Abafar o caso", 0, 0, -3, -10,
            "A verdade começa a vazar e sua credibilidade despenca rapidamente.\n\n -3 de População\n -10 de Aprovação Pública"),

            new Escolha("Negar envolvimento", 0, 0, -5, -8,
            "A população fica desconfiada e sua imagem é abalada.\n\n -5 de População\n -8 de Aprovação Pública")
        ));

        eventos.add(new Evento("Um grande investidor quer abrir diversos negócios na cidade.",
            new Escolha("Aceitar com incentivos fiscais", -8, +12, +8, +5,
            "A economia cresce rapidamente, mas há críticas sobre benefícios excessivos ao setor privado.\n\n -8 de Meio Ambiente\n +12 de Fundos Econômicos\n +8 de População\n +5 de Aprovação Pública"),

            new Escolha("Negociar condições equilibradas", -2, +10, +6, +7,
            "O investimento chega de forma controlada, beneficiando a cidade de forma justa.\n\n -2 de Meio Ambiente\n +10 de Fundos Econômicos\n +6 de População\n +7 de Aprovação Pública"),

            new Escolha("Recusar proposta", +3, 0, -4, -3,
            "Você evita riscos, mas perde uma grande oportunidade econômica.\n\n +3 de Meio Ambiente\n -4 de População\n -3 de Aprovação Pública")
        ));

        eventos.add(new Evento("A cidade pode sediar um grande festival cultural.",
            new Escolha("Investir pesado no evento", -5, -8, +10, +10,
            "O evento é um sucesso e aumenta a felicidade da população, mas gera custos altos.\n\n -5 de Meio Ambiente\n -8 de Fundos Econômicos\n +10 de População\n +10 de Aprovação Pública"),

            new Escolha("Evento moderado", -2, -3, +6, +6,
            "O festival agrada, sem comprometer tanto o orçamento.\n\n -2 de Meio Ambiente\n -3 de Fundos Econômicos\n +6 de População\n +6 de Aprovação Pública"),

            new Escolha("Cancelar", +3, +5, -6, -6,
            "A população fica decepcionada com a falta de iniciativas culturais.\n\n +3 de Meio Ambiente\n +5 Fundos econômicos \n -6 de População\n -6 de Aprovação Pública")
        ));

        eventos.add(new Evento("O sistema de saúde da cidade está sobrecarregado.",
            new Escolha("Investir fortemente na saúde", +3, -10, +10, +8,
            "A qualidade de atendimento melhora e a população se sente mais segura.\n\n -3 de Meio Ambiente\n -10 de Fundos Econômicos\n +10 de População\n +8 de Aprovação Pública"),

            new Escolha("Melhorias básicas", +1, -3, +5, +4,
            "A situação melhora parcialmente, mas ainda há filas e problemas.\n\n -1 de Meio Ambiente\n -3 de Fundos Econômicos\n +5 de População\n +4 de Aprovação Pública"),

            new Escolha("Ignorar o problema", -3, 0, -10, -10,
            "O sistema entra em colapso e gera revolta popular.\n\n -3 de Meio Ambiente\n -10 de População\n -10 de Aprovação Pública")
        ));

        return eventos;
    }

    // Evento aprovação Alta 
    public static List<Evento> eventoAprovacaoAlta() {
    List<Evento> eventoAprovacaoAlta = new ArrayList<>();

        eventoAprovacaoAlta.add(new Evento("URGENTE!!\n\nSua popularidade está em alta! A população confia na sua gestão e apoia novas iniciativas.",
        
            new Escolha("Lançar grandes projetos para a cidade", +4, -10, +10, +8,
            "Você aproveita o apoio popular para investir em melhorias. A população fica satisfeita, mas os custos são elevados.\n\n +4 de Meio Ambiente\n -10 de Fundos Econômicos \n +10 de População\n +8 de Aprovação Pública"),

            new Escolha("Aprovar reformas econômicas estratégicas", -1, +15, +5, +6,
            "Você utiliza o momento para fortalecer a economia, mantendo boa aprovação.\n\n -1 de Meio Ambiente\n +15 de Fundos Econômicos \n +5 de População\n +6 de Aprovação Pública"),

            new Escolha("Manter a estabilidade e evitar riscos", 0, +3, +2, +2,
            "Você opta por não arriscar, mantendo a cidade estável, mas sem grandes avanços.\n\n +3 de Fundos Econômicos \n +2 de População\n +2 de Aprovação Pública")
        ));

        return eventoAprovacaoAlta;
    }

    // Eventos Meio Ambiente alto
    public static List<Evento> eventoAmbienteAlto() {
    List<Evento> eventoAmbienteAlto = new ArrayList<>();

        eventoAmbienteAlto.add(new Evento("URGENTE!!\n\nSua cidade foi reconhecida internacionalmente como uma das mais sustentáveis do mundo.",

            new Escolha("Investir para se tornar referência global", +15, -12, +15, +15,
            "Você amplia políticas ambientais e transforma a cidade em referência mundial. O custo é alto, mas o prestígio cresce muito.\n\n +15 de Meio Ambiente\n -12 de Fundos Econômicos \n +15 de População\n +15 de Aprovação Pública"),

            new Escolha("Aproveitar o reconhecimento para atrair investimentos", +8, +15, +9, +10,
            "Empresas sustentáveis se interessam pela cidade, fortalecendo a economia sem perder o foco ambiental.\n\n +8 de Meio Ambiente\n +15 de Fundos Econômicos \n +9 de População\n +10 de Aprovação Pública"),

            new Escolha("Não investir mais e manter como está", 0, 0, -12, -15,
            "Sem novos esforços, a cidade começa a perder destaque ao longo do tempo.\n\n -12 de População\n -15 de Aprovação Pública")
        ));

        eventoAmbienteAlto.add(new Evento("URGENTE!!\n\nSua cidade se tornou referência ambiental e foi convidada para sediar um grande evento internacional sobre sustentabilidade.",
        
            new Escolha("Investir pesado para sediar o evento", +5, -12, +10, +10,
            "A cidade ganha visibilidade mundial e fortalece suas políticas ambientais. O investimento é alto, mas o prestígio compensa.\n\n +5 de Meio Ambiente\n -12 de Fundos Econômicos \n +10 de População\n +10 de Aprovação Pública"),

            new Escolha("Firmar parcerias e dividir os custos", +6, -5, +6, +8,
            "Você consegue sediar o evento com apoio externo, equilibrando ganhos ambientais e custos financeiros.\n\n +6 de Meio Ambiente\n -5 de Fundos Econômicos \n +6 de População\n +8 de Aprovação Pública"),

            new Escolha("Recusar e manter estabilidade", 0, 0, -2, -3,
            "Sem novos investimentos, a cidade mantém seus níveis, mas perde a chance de crescer como referência global.\n\n -2 de População\n -3 de Aprovação Pública")
        ));

        return eventoAmbienteAlto;
    }

   
    //Evento Economia Alta 
    public static List<Evento> eventoEconomiaAlta() {
    List<Evento> eventoEconommiaAlta = new ArrayList<>();

        eventoEconommiaAlta.add(new Evento("URGENTE!!\n\nSua cidade foi destaque nacional pelo forte crescimento econômico. Investidores e mídia elogiam sua gestão.",
        
            new Escolha("Expandir investimentos públicos", 0, -10, +12, +10,
            "Você reinveste na cidade, melhorando serviços e qualidade de vida. A população aprova, mas os cofres diminuem.\n\n -10 de Fundos Econômicos \n +12 de População\n +10 de Aprovação Pública"),

            new Escolha("Atrair mais empresas e ampliar a economia", -12, +20, +8, +7,
            "Novos negócios chegam à cidade, aumentando ainda mais a economia, mas, com impacto ambiental.\n\n -12 de Meio Ambiente\n +20 de Fundos Econômicos \n +8 de População\n +7 de Aprovação Pública"),

            new Escolha("Manter a situação atual", 0, +5, +2, +3,
            "Você mantém a estabilidade, garantindo crescimento moderado sem grandes riscos.\n\n +3 de Fundos Econômicos \n +2 de População\n +3 de Aprovação Pública")
        ));

        return eventoEconommiaAlta;

    }  
    
    //Evento Economia Baixa 
    public static List<Evento> eventoEconomiaBaixa() {
    List<Evento> eventoEconimiaBaixa = new ArrayList<>();

        eventoEconimiaBaixa.add(new Evento("URGENTE!!\n\nA economia da cidade entrou em colapso. Empresas estão fechando e o desemprego cresce rapidamente.",
        
            new Escolha("Plano agressivo de recuperação econômica", -12, +20, +5, +6,
            "Você toma medidas ousadas que reativam a economia rapidamente, mas com custos ambientais e riscos futuros.\n\n -12 de Meio Ambiente\n +20 de Fundos Econômicos \n +5 de População\n +6 de Aprovação Pública"),

            new Escolha("Aumentar impostos para recuperar os cofres", 0, +15, -8, -15,
            "A arrecadação melhora, mas a população e empresas reagem negativamente.\n\n +15 de Fundos Econômicos \n -8 de População\n -15 de Aprovação Pública"),

            new Escolha("Não intervir e esperar recuperação natural", 0, -12, -10, -12,
            "A crise se agrava e afeta todos os setores da cidade.\n -12 de Fundos Econômicos \n -10 de População\n -12 de Aprovação Pública")
        ));

        return eventoEconimiaBaixa;
    }
}