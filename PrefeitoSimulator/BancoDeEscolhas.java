package PrefeitoSimulator;
import java.util.*;

// Classe responsável por armazenar todos os Eventos presentes no Jogo
public class BancoDeEscolhas {
    // Eventos Normais
    public static List<Evento> eventosNormais() {
        List<Evento> eventos = new ArrayList<>();

        eventos.add(new Evento("Uma indústria deseja se instalar próxima a um rio da cidade.",
            new Escolha("Aprovar sem restrições", -10, +15, +5, -10,
            "A indústria gerou empregos e aumentou a arrecadação, mas contaminou o rio, afetando o ecossistema.\n\n-10 de Meio Ambiente\n+15 de Fundos\n+5 de População\n-10 de Aprovação Pública"),

            new Escolha("Aprovar com regulamentação ambiental", +5, +8, +8, +5,
            "A empresa operou com responsabilidade, gerando lucro sem causar danos graves ao meio ambiente.\n\n+5 de Meio Ambiente\n+8 de Fundos\n+8 de População\n+5 de Aprovação Pública"),

            new Escolha("Negar instalação", +8, -5, -3, -5,
            "Você protegeu o meio ambiente, mas perdeu uma oportunidade econômica importante.\n\n+8 de Meio Ambiente\n-5 de Fundos\n-3 de População\n-5 de Aprovação Pública")
        ));

        eventos.add(new Evento("O sistema de saneamento da cidade está em colapso.",
            new Escolha("Investir fortemente em saneamento", +10, -15, +12, +5,
            "A qualidade de vida melhorou drasticamente e doenças diminuíram.\n\n+10 de Meio Ambiente\n-15 de Fundos\n+12 de População\n+5 de Aprovação Pública"),

            new Escolha("Fazer melhorias básicas", +5, -7, +6, +2,
            "A situação melhorou parcialmente, mas ainda há problemas.\n\n+5 de Meio Ambiente\n-7 de Fundos\n+6 de População\n+2 de Aprovação Pública"),

            new Escolha("Ignorar o problema", -15, 0, -12, -10,
            "A poluição aumentou e doenças começaram a surgir.\n\n-15 de Meio Ambiente\n-12 de População\n-10 de Aprovação Pública")
        ));

        eventos.add(new Evento("O trânsito está cada vez pior na cidade.",
            new Escolha("Construir mais vias", -8, -10, +6, +2,
            "O trânsito melhorou, mas o desmatamento e poluição aumentaram.\n\n-8 de Meio Ambiente\n-10 de Fundos\n+6 de População\n+2 de Aprovação Pública"),

            new Escolha("Investir em transporte público sustentável", +8, -8, +10, +6,
            "A cidade ficou mais eficiente e menos poluente.\n\n+8 de Meio Ambiente\n-8 de Fundos\n+10 de População\n+6 de Aprovação Pública"),

            new Escolha("Não fazer nada", -10, 0, -10, -8,
            "O trânsito virou um caos e a qualidade de vida caiu.\n\n-10 de Meio Ambiente\n-10 de População\n-8 de Aprovação Pública")
        ));

        eventos.add(new Evento("Uma empresa oferece propina para ignorar regras ambientais.",
            new Escolha("Aceitar propina", -15, +20, +3, -20,
            "Você lucrou, mas causou danos ambientais e perdeu a confiança da população.\n\n-15 de Meio Ambiente\n+20 de Fundos\n+3 de População\n-20 de Aprovação Pública"),

            new Escolha("Recusar", +5, -5, +5, +5,
            "Você manteve sua integridade e ganhou respeito público.\n\n+5 de Meio Ambiente\n-5 de Fundos\n+5 de População\n+5 de Aprovação Pública"),

            new Escolha("Denunciar a empresa", +8, -8, +8, +10,
            "A justiça foi feita e a população reconheceu sua atitude.\n\n+8 de Meio Ambiente\n-8 de Fundos\n+8 de População\n+10 de Aprovação Pública")
        ));

        eventos.add(new Evento("Uma crise econômica atinge a cidade.",
            new Escolha("Cortar gastos ambientais", -10, +10, -8, -5,
            "A economia respirou, mas o meio ambiente sofreu.\n\n-10 de Meio Ambiente\n+10 de Fundos\n-8 de População\n-5 de Aprovação Pública"),

            new Escolha("Investir em economia sustentável", +5, +8, +6, +5,
            "A economia cresceu de forma equilibrada.\n\n+5 de Meio Ambiente\n+8 de Fundos\n+6 de População\n+5 de Aprovação Pública"),

            new Escolha("Não agir", -12, -10, -10, -10,
            "A crise piorou e afetou todos os setores.\n\n-12 de Meio Ambiente\n-10 de Fundos\n-10 de População\n-10 de Aprovação Pública")
        ));

        eventos.add(new Evento("Protestos exigem mais ações ambientais.",
            new Escolha("Reprimir protestos", -10, +2, -15, -15,
            "A repressão gerou revolta e piorou sua imagem.\n\n-10 de Meio Ambiente\n+2 de Fundos\n-15 de População\n-15 de Aprovação Pública"),

            new Escolha("Dialogar com a população", +6, -3, +10, +10,
            "O diálogo trouxe confiança e melhorias.\n\n+6 de Meio Ambiente\n-3 de Fundos\n+10 de População\n+10 de Aprovação Pública"),

            new Escolha("Ignorar", -8, 0, -10, -10,
            "A situação saiu do controle.\n\n-8 de Meio Ambiente\n-10 de População\n-10 de Aprovação Pública")
        ));

        eventos.add(new Evento("Um projeto de energia renovável é proposto.",
            new Escolha("Investir no projeto", +12, -12, +10, +8,
            "A cidade se tornou mais sustentável e moderna.\n\n+12 de Meio Ambiente\n-12 de Fundos\n+10 de População\n+8 de Aprovação Pública"),

            new Escolha("Parceria privada", +6, +5, +8, +6,
            "O projeto avançou com custos reduzidos.\n\n+6 de Meio Ambiente\n+5 de Fundos\n+8 de População\n+6 de Aprovação Pública"),

            new Escolha("Rejeitar", -6, 0, -5, -5,
            "A cidade perdeu uma oportunidade sustentável.\n\n-6 de Meio Ambiente\n-5 de População\n-5 de Aprovação Pública")
        ));

        eventos.add(new Evento("Um desastre ambiental ameaça a cidade.",
            new Escolha("Ação imediata", +15, -15, +8, +5,
            "A crise foi controlada com sucesso.\n\n+15 de Meio Ambiente\n-15 de Fundos\n+8 de População\n+5 de Aprovação Pública"),

            new Escolha("Resposta lenta", +5, -5, 0, -2,
            "A situação melhorou parcialmente.\n\n+5 de Meio Ambiente\n-5 de Fundos\n-2 de Aprovação Pública"),

            new Escolha("Ignorar", -20, 0, -12, -15,
            "O desastre se agravou drasticamente.\n\n-20 de Meio Ambiente\n-12 de População\n-15 de Aprovação Pública")
        ));
        return eventos;
    }

    // Eventos de Aprovação Baixa
    public static List<Evento> eventoAprovacaoBaixa() {
        List<Evento> eventosAprovacaoBaixa = new ArrayList<>();

        eventosAprovacaoBaixa.add(new Evento("Sua gestão é criticada por negligência ambiental.",
        
            new Escolha("Implementar políticas sustentáveis", +12, -5, +10, +15,
            "Você recupera a confiança pública com ações concretas.\n\n+12 de Meio Ambiente\n-5 de Fundos\n+10 de População\n+15 de Aprovação Pública"),

            new Escolha("Prometer sem agir", -5, 0, +3, -15,
            "A população percebe a falta de ação e perde confiança.\n\n-5 de Meio Ambiente\n+3 de População\n-15 de Aprovação Pública"),

            new Escolha("Ignorar críticas", -10, 0, -10, -20,
            "A situação piora e sua popularidade despenca.\n\n-10 de Meio Ambiente\n-10 de População\n-20 de Aprovação Pública")
        ));

        return eventosAprovacaoBaixa;
    }

    // Eventos de Aprovaçao Alta(Ainda não implementados)
    // ...
}