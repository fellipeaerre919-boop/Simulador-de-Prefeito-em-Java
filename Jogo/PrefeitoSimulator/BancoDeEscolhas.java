package PrefeitoSimulator;
import java.util.*;

// Classe responsável por armazenar todos os Eventos presentes no Jogo
public class BancoDeEscolhas {
    // Eventos Normais
    public static List<Evento> eventosNormais() {
        List<Evento> eventos = new ArrayList<>();

        eventos.add(new Evento("Uma grande indústria de montagem de carros elétricos quer se instalar às margens do principal rio da cidade, a montadora estima que vai ter que contratar até 3% da população, só com essa notícia pessoas das cidades vizinhas já começam a vir para sua cidade em busca dos futuros empregos existe uma parte da população que teme que essa montadora polua de alguma forma o rio, um grupo de analistas ambientais contratados pela montadora diz que o impacto ambiental vai ser baixo e ativistas ambientais são contra a instalação da montadora alegando que a montadora vai despejar químicos nos rios.",

            new Escolha("Aprovar com regras ambientais especiais", -1, +15, +4, +5,
            "A montadora é instalada com sucesso, a regulação se faz presente, isso aumenta o custo de produção e a montadora diminuiu o tamanho da construção originalmente prevista o que diminui a quantidade de empregos originalmente previstos, a respeito ao meio ambiente como a empresa é uma montadora naturalmente poucos resíduos são formados, a regulação se demonstra redundante.\n\n -1 de Meio Ambiente \n +15 de Fundos Econômicos \n +4 de População \n +5 de Aprovação Pública"),

            new Escolha("Aprovar com o regimento padrão", -2, +15, +4, +5,
            "A economia cresce快速mente, 3% da população foi contratada, ao contrário do que os críticos diziam a montadora sequer mexe com químicos, uma montadora apenas monta e seus resíduos são poucos e pontuais .\n\n -2 de Meio Ambiente \n +15 de Fundos Econômicos \n +4 de População \n +5 de Aprovação Pública"),

            new Escolha("Negar instalação", 0, 0, -8, -10,
            "Você nega a montadora, perde investimentos. Parte da população critica a decisão.\n\n 0 de fundos econômicos\n -8 de População \n -10 de Aprovação Pública")
        ));

        eventos.add(new Evento("O sistema de saneamento está sobrecarregado e começa a falhar em várias regiões, as falhas estão focadas em áreas específicas e tem algumas poucas falhas que se demonstram estruturais.",
            new Escolha("Reforma completa do sistema, sem se preocupar com o orçamento", +12, -8, +9, +7,
            "A cidade dá um salto em qualidade de vida, reduzindo doenças e poluição.\n\n +12 de Meio Ambiente \n -8 de Fundos Econômicos \n +9 de População \n +7 de Aprovação Pública"),

            new Escolha("Melhorias pontuais focando nas áreas com defeitos não estruturais", +5, -5, +5, +3,
            "A situação melhora, mas ainda há áreas críticas que estão ligadas com a parte estrutural do sistema de esgoto.\n\n +5 de Meio Ambiente \n -5 de Fundos Econômicos \n +5 de População \n +3 de Aprovação Pública"),

            new Escolha("Adiar investimentos", -12, 0, -8, -8,
            "A crise se agrava, afetando diretamente o meio ambiente e a saúde da população, fazendo com que muitos saiam da sua cidade.\n\n -12 de Meio Ambiente\n -8 de População \n -8 de Aprovação Pública")
        ));

        eventos.add(new Evento("O trânsito da cidade está ficando insustentável.",
            new Escolha("Expandir transporte sustentável", +8, -6, +5, +3,
            "Menos carros nas ruas e mais qualidade de vida. A cidade respira melhor.\n\n +8 de Meio Ambiente \n -6 de Fundos Econômicos \n +5 de População \n +3 de Aprovação Pública"),

            new Escolha("Construir mais avenidas", -10, -2, +6, +3,
            "O trânsito melhora por um tempo, mas o impacto ambiental cresce.\n\n -10 de Meio Ambiente \n -2 de Fundos Econômicos \n +6 de População \n +3 de Aprovação Pública"),

            new Escolha("Ignorar", -4, -2, -9, -7,
            "Congestionamentos pioram e a população perde produtividade.\n\n -4 de Meio Ambiente \n -2 de Fundos Econômicos \n -9 de População \n -7 de Aprovação Pública")
        ));

        eventos.add(new Evento("Uma empresa oferece um acordo ilegal para ignorar leis ambientais que esta empresa já vem quebrando há um tempo.",
            new Escolha("Aceitar", -12, +20, 0, -12,
            "Você ganha recursos, mas sua reputação desmorona e o meio ambiente sofre.\n\n -12 de Meio Ambiente \n +20 de Fundos Econômicos \n -12 de Aprovação Pública"),

            new Escolha("Recusar e chantagear a empresa ameaçando fazer uma denúncia", +5, +10, 0, 0,
            "Você mantém sua integridade, a empresa para com suas atividades ilegais e o seu governo recebe um bom valor da sua chantagem e ninguém sabe da sua recusa.\n\n +5 de Meio Ambiente \n +10 de Fundos Econômicos"),

            new Escolha("Recusar e denunciar", +5, 0, +3, +5,
            "A justiça é feita e sua popularidade cresce.\n\n +5 de Meio Ambiente\n +3 de População \n +5 de Aprovação Pública")
        ));

        eventos.add(new Evento("Uma crise econômica global voltada à escassez de petróleo refinado começa a afetar sua cidade.",
            new Escolha("Cortar gastos ambientais", -8, +4, -6, -10,
            "A economia melhora no curto prazo, mas o impacto ambiental aumenta, as pessoas saem da sua cidade em busca de emprego.\n\n -8 de Meio Ambiente \n +4 de Fundos Econômicos \n -6 de População \n -10 de Aprovação Pública"),

            new Escolha("Investir em economia verde", +6, +6, +6, +6,
            "Crescimento mais lento, porém sustentável e equilibrado.\n\n +6 de Meio Ambiente \n +6 de Fundos Econômicos \n +6 de População \n +6 de Aprovação Pública"),

            new Escolha("Criar refinarias de petróleo, de um jeito que pouco afete o meio ambiente", -4, +15, +6, +10,
            "A crise quase não afeta a sua cidade, o meio ambiente é parcialmente afetado e a população consegue mais empregos devido à refinaria.\n -4 de Meio Ambiente\n +15 de Fundos Econômicos \n +6 de População \n +10 de Aprovação Pública")
        ));

        eventos.add(new Evento("Grupos organizam protestos exigindo ações ambientais imediatas.",
            new Escolha("Dialogar e seguir suas exigências", +3, -6, +9, +10,
            "A população sente que foi ouvida e confia mais na gestão.\n\n +3 de Meio Ambiente \n -6 de Fundos Econômicos \n +9 de População \n +10 de Aprovação Pública"),

            new Escolha("Reprimir para que não aumente", -4, 0, -2, -12,
            "Os protestos são dispersados à força e sua imagem piora drasticamente.\n\n -4 de Meio Ambiente \n -2 de População \n -12 de Aprovação Pública"),

            new Escolha("Ignorar, uma hora os protestos vão dispersar", 0, 0, -9, -9,
            "Os protestos crescem, algumas pessoas saem da sua cidade e os protestos se dispersam.\n\n -9 de População \n -9 de Aprovação Pública")
        ));

        eventos.add(new Evento("Sua cidade sofre com uma crise energética, você tem que construir uma nova fonte de energia trocando as antigas termoelétricas da sua cidade, levando em conta o custo, meio ambiente e a área que cada fonte energética precisa para gerar energia você escolherá a que melhor cabe para sua cidade.",
            new Escolha("Energia solar, uma grande fazenda solar", -5, -10, 0, +8,
            "Você constrói uma grande fazenda solar, cerca de 10 km² são desmatados para que ela fosse construída, os custos são altíssimos, tem poucos retornos, a fazenda solar vai demorar 4 anos para se pagar, o que é mais do que o seu mandato\n\n -5 de Meio Ambiente \n -10 de Fundos Econômicos \n +8 de Aprovação Pública"),

            new Escolha("Energia hidrelétrica, uma pequena represa, opção mais barata", +7, +3, +3, +10,
            "Você constrói a represa, uma grande área é engolida pela água, tornando-a inabitável para a flora original, porém é pouco poluente, cara mas não tanto quanto as outras e seu custo de manutenção é baixo\n\n +7 de Meio Ambiente \n +3 de Fundos Econômicos \n +3 de População \n +10 de Aprovação Pública"),

            new Escolha("Energia nuclear e compartilhar a energia e custos para outras cidades, ainda muito caro", +20, -15, +20, +20, 
            "Você constrói a usina nuclear, divide o preço da construção entre 30 outras cidades, energia tão barata e em abundância que você consegue aposentar todas as termoelétricas da região. Mesmo dividindo os custos de construção a usina foi absurdamente cara, porém a longo prazo será a fonte de energia mais barata de se manter. A população aprova e agora sua cidade pode comportar mais pessoas.\n\n +20 de Meio Ambiente \n -15 de Fundos Econômicos \n +20 de População \n +20 de Aprovação Pública")
        ));

        eventos.add(new Evento("Um desastre ambiental ameaça áreas da cidade.",
            new Escolha("Resposta rápida, priorizar vidas a todo o custo ", +12, -3, -6, +30,
            "Quase ninguém foi diretamente afetado, vidas foram salvas, as pessoas perderam suas casas, o custo foi alto e você vira um herói da cidade.\n\n +12 de Meio Ambiente \n -3 de Fundos Econômicos \n -6 de População \n +30 de Aprovação Pública"),

            new Escolha("Resposta eficiente, salvar o máximo possível de tudo", +5, -5, -3, +10,
            "A infraestrutura da cidade é salva, as pessoas também, mas nem todas.\n\n +5 de Meio Ambiente \n -5 de Fundos Econômicos \n -3 de População \n +10 de Aprovação Pública"),

            new Escolha("Resposta econômica, focando no pós-desastre", -12, 0, -10, -20,
            "A situação sai do controle, dezenas de pessoas morrem e centenas ficam feridas, a reconstrução da cidade é coberta pelo seguro, a aprovação despenca.\n\n -12 de Meio Ambiente\n -10 de População \n -20 de Aprovação Pública")
        ));

        eventos.add(new Evento("A cidade discute implementar coleta seletiva de lixo.",
            new Escolha("Implementar totalmente", +10, -6, +7, +8,
            "A cidade reduces drasticamente o lixo e melhora a reciclagem.\n\n +10 de Meio Ambiente \n -6 de Fundos Econômicos \n +7 de População \n +8 de Aprovação Pública"),

            new Escolha("Projeto piloto", +5, -3, +5, +4,
            "Algumas regiões já mostram resultados positivos.\n\n +5 de Meio Ambiente \n -3 de Fundos Econômicos \n +5 de População \n +4 de Aprovação Pública"),

            new Escolha("Ignorar", -8, 0, -5, -6,
            "O acúmulo de lixo se torna um problema crescente.\n\n -8 de Meio Ambiente\n -5 de População\n -6 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("Há uma proposta de incentivo à energia solar residencial.",
            new Escolha("Bancar instalação", +10, -10, +8, +8,
            "A cidade se torna referência em energia limpa.\n\n +10 de Meio Ambiente\n -10 de Fundos Econômicos\n +8 de População\n +8 de Aprovação Pública"),

            new Escolha("Incentivo, removendo dificuldades", +6, -2, +6, +5,
            "Parte da população adere à ideia.\n\n +6 de Meio Ambiente\n -2 de Fundos Econômicos\n +6 de População\n +5 de Aprovação Pública"),

            new Escolha("Não incentivar", -5, 0, -4, -4,
            "A cidade fica para trás na transição energética.\n\n -5 de Meio Ambiente\n -4 de População\n -4 de Aprovação Pública")
        ));

        eventos.add(new Evento("O consumo de água está aumentando rapidamente.",
            new Escolha("Políticas de controle e reúso", +10, +5, +2, +2,
            "O consumo é controlado e o futuro hídrico é garantido.\n\n +10 de Meio Ambiente\n +5 de Fundos Econômicos\n +2 de População\n +2 de Aprovação Pública"),

            new Escolha("Campanhas educativas", +5, -1, +5, +5,
            "A população reduz o consumo parcialmente.\n\n +5 de Meio Ambiente\n -1 de Fundos Econômicos\n +5 de População\n +5 de Aprovação Pública"),

            new Escolha("Aumentar os reservatórios", +5, -5, +10, +10,
            "A longo prazo a solução não funcionou. A cidade caminha para uma crise hídrica.\n\n +5 de Meio Ambiente \n -5 de Fundos Econômicos \n +10 de População \n +10 de Aprovação Pública")
        ));

        eventos.add(new Evento("Um escândalo político envolvendo membros do seu governo vem à tona.",
            new Escolha("Investigar e punir os responsáveis", 0, -3, +5, +10,
            "Você mostra firmeza e transparência, recuperando a confiança da população, mesmo com custos políticos.\n\n -3 de Fundos Econômicos\n +5 de População\n +10 de Aprovação Pública"),

            new Escolha("Abafar o caso com suborno", 0, -5, -3, -10,
            "A verdade começa a vazar e sua credibilidade despenca rapidamente.\n\n -5 de Fundos Econômicos \n -3 de População \n -10 de Aprovação Pública"),

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
            "A população fica decepcionada com a falta de iniciativas culturais.\n\n +3 de Meio Ambiente\n +5 de Fundos Econômicos\n -6 de População\n -6 de Aprovação Pública")
        ));

        eventos.add(new Evento("O sistema de saúde da cidade está sobrecarregado.",
            new Escolha("Investir fortemente na saúde", -3, -10, +10, +8,
            "A qualidade de atendimento melhora e a população se sente mais segura.\n\n -3 de Meio Ambiente\n -10 de Fundos Econômicos\n +10 de População\n +8 de Aprovação Pública"),

            new Escolha("Melhorias básicas", -1, -3, +5, +4,
            "A situação melhora parcialmente, mas ainda há filas e problemas.\n\n -1 de Meio Ambiente\n -3 de Fundos Econômicos\n +5 de População\n +4 de Aprovação Pública"),

            new Escolha("Incentivar fiscalmente a saúde privada", -3, +15, -5, +4,
            "A saúde melhora, a economia também, porém nem todos podem pagar.\n\n -3 de Meio Ambiente \n  +15 de Fundos Econômicos \n -5 de População \n +4 de Aprovação Pública")
        ));

        eventos.add(new Evento("O governo lhe faz um repasse equivalente a 15 pontos de fundos econômicos, o que fazer?",
            new Escolha("Pagar um show de música", 0, 0, 0, +15,
            "A aprovação sobe.\n\n +15 de Aprovação Pública"),

            new Escolha("Investir em corte de poluentes", +15, 0, 0, 0,
            "O meio ambiente agradece.\n\n +15 de Meio Ambiente"),

            new Escolha("Manter a verba", 0, +15, 0, 0,
            "A verba foi guardada para depois.\n\n +15 de Fundos Econômicos")
        ));

        return eventos;
    }

    // Evento Aprovação Alta 
    public static List<Evento> eventoAprovacaoAlta() {
        List<Evento> eventoAprovacaoAlta = new ArrayList<>();

        eventoAprovacaoAlta.add(new Evento("URGENTE!!\n\nSua popularidade está em alta! A população confia na sua gestão e apoia novas iniciativas.",
        
            new Escolha("Lançar grandes projetos para a cidade", +4, -10, +10, +8,
            "Você aproveita o apoio popular para investir em melhorias. A população fica satisfeita, mas os custos são elevados.\n\n +4 de Meio Ambiente\n -10 de Fundos Econômicos\n +10 de População\n +8 de Aprovação Pública"),

            new Escolha("Aprovar reformas econômicas estratégicas", -1, +15, +5, +6,
            "Você utiliza o momento para fortalecer a economia, mantendo boa aprovação.\n\n -1 de Meio Ambiente\n +15 de Fundos Econômicos\n +5 de População\n +6 de Aprovação Pública"),

            new Escolha("Manter a estabilidade e evitar riscos", 0, +3, +2, +2,
            "Você opta por não arriscar, mantendo a cidade estável, mas sem grandes avanços.\n\n +3 de Fundos Econômicos\n +2 de População\n +2 de Aprovação Pública")
        ));

        return eventoAprovacaoAlta;
    }

    // Evento Aprovação Baixa
    public static List<Evento> eventoAprovacaoBaixa() {
        List<Evento> eventoAprovacaoBaixa = new ArrayList<>();

        eventoAprovacaoBaixa.add(new Evento("URGENTE!!\n\nA população perdeu a fé no seu mandato. Protestos pedindo sua saída começam a ganhar força nas ruas!",
        
            new Escolha("Fazer um pronunciamento oficial prometendo bônus e auxílios", 0, -10, 0, +15,
            "Você acalma os ânimos distribuindo recursos públicos. A aprovação sobe temporariamente, mas os cofres sofrem.\n\n -10 de Fundos Econômicos\n +15 de Aprovação Pública"),

            new Escolha("Iniciar um grande mutirão de obras públicas para gerar empregos", -5, -8, +6, +10,
            "A resposta prática agrada o povo e traz pessoas de volta para a economia ativa, embora agrida o meio ambiente.\n\n -5 de Meio Ambiente\n -8 de Fundos Econômicos\n +6 de População\n +10 de Aprovação Pública"),

            new Escolha("Ignorar e focar em alianças políticas nos bastidores", 0, +5, -4, -5,
            "Você garante apoio financeiro dos deputados, mas o povo continua revoltado e alguns abandonam a cidade.\n\n +5 de Fundos Econômicos\n -4 de População\n -5 de Aprovação Pública")
        ));

        return eventoAprovacaoBaixa;
    }

    // Eventos Meio Ambiente Alto
    public static List<Evento> eventoAmbienteAlto() {
        List<Evento> eventoAmbienteAlto = new ArrayList<>();

        eventoAmbienteAlto.add(new Evento("URGENTE!!\n\nSua cidade foi reconhecida internacionalmente como uma das mais sustentáveis do mundo.",

            new Escolha("Investir para se tornar referência global", +15, -12, +15, +15,
            "Você amplia políticas ambientais e transforma a cidade em referência mundial. O custo é alto, mas o prestígio cresce muito.\n\n +15 de Meio Ambiente\n -12 de Fundos Econômicos\n +15 de População\n +15 de Aprovação Pública"),

            new Escolha("Aproveitar o reconhecimento para atrair investimentos", +8, +15, +9, +10,
            "Empresas sustentáveis se interessam pela cidade, fortalecendo a economia sem perder o foco ambiental.\n\n +8 de Meio Ambiente\n +15 de Fundos Econômicos\n +9 de População\n +10 de Aprovação Pública"),

            new Escolha("Não investir mais e manter como está", 0, 0, -12, -15,
            "Sem novos esforços, a cidade começa a perder destaque ao longo do tempo.\n\n -12 de População\n -15 de Aprovação Pública")
        ));

        eventoAmbienteAlto.add(new Evento("URGENTE!!\n\nSua cidade se tornou referência ambiental e foi convidada para sediar um grande evento internacional sobre sustentabilidade.",
        
            new Escolha("Investir pesado para sediar o evento", +5, -12, +10, +10,
            "A cidade ganha visibilidade mundial e fortalece suas políticas ambientais. O investimento é alto, mas o prestígio compensa.\n\n +5 de Meio Ambiente\n -12 de Fundos Econômicos\n +10 de População\n +10 de Aprovação Pública"),

            new Escolha("Firmar parcerias e dividir os custos", +6, -5, +6, +8,
            "Você consegue sediar o evento com apoio externo, equilibrando ganhos ambientais e custos financeiros.\n\n +6 de Meio Ambiente\n -5 de Fundos Econômicos\n +6 de População\n +8 de Aprovação Pública"),

            new Escolha("Recusar e manter estabilidade", 0, 0, -2, -3,
            "Sem novos investimentos, a cidade mantém seus níveis, mas perde a chance de crescer como referência global.\n\n -2 de População\n -3 de Aprovação Pública")
        ));

        return eventoAmbienteAlto;
    }

    // Eventos Meio Ambiente Baixo
    public static List<Evento> eventoAmbienteBaixo() {
        List<Evento> eventoAmbienteBaixo = new ArrayList<>();

        eventoAmbienteBaixo.add(new Evento("URGENTE!!\n\nA poluição atingiu níveis críticos! Uma nuvem de fumaça tóxica cobre a cidade e os hospitais estão cheios.",

            new Escolha("Decretar lockdown industrial e multar severamente os poluidores", +15, -12, -4, +8,
            "O ar melhora drasticamente, mas indústrias param, gerando desemprego e fazendo trabalhadores saírem da cidade.\n\n +15 de Meio Ambiente\n -12 de Fundos Econômicos\n -4 de População\n +8 de Aprovação Pública"),

            new Escolha("Implementar um plano emergencial de arborização e filtros urbanos", +8, -6, +2, +5,
            "Uma solução moderada que começa a limpar o ecossistema sem quebrar as pernas da economia local.\n\n +8 de Meio Ambiente\n -6 de Fundos Econômicos\n +2 de População\n +5 de Aprovação Pública"),

            new Escolha("Maquiar os dados e focar em remédios para a população", -10, -3, -8, -12,
            "A crise de saúde piora, o meio ambiente é destruído e as pessoas fogem da cidade doente.\n\n -10 de Meio Ambiente\n -3 de Fundos Econômicos\n -8 de População\n -12 de Aprovação Pública")
        ));

        return eventoAmbienteBaixo;
    }

    // Evento Economia Alta 
    public static List<Evento> eventoEconomiaAlta() {
        List<Evento> eventoEconommiaAlta = new ArrayList<>();

        eventoEconommiaAlta.add(new Evento("URGENTE!!\n\nSua cidade foi destaque nacional pelo forte crescimento econômico. Investidores e mídia elogiam sua gestão.",
        
            new Escolha("Expandir investimentos públicos", 0, -10, +12, +10,
            "Você reinveste na cidade, melhorando serviços e qualidade de vida. A população aprova, mas os cofres diminuem.\n\n -10 de Fundos Econômicos\n +12 de População\n +10 de Aprovação Pública"),

            new Escolha("Atrair mais empresas e ampliar a economia", -12, +20, +8, +7,
            "Novos negócios chegam à cidade, aumentando ainda mais a economia, mas com impacto ambiental.\n\n -12 de Meio Ambiente\n +20 de Fundos Econômicos\n +8 de População\n +7 de Aprovação Pública"),

            new Escolha("Manter a situação atual", 0, +5, +2, +3,
            "Você mantém a estabilidade, garantindo crescimento moderado sem grandes riscos.\n\n +5 de Fundos Econômicos\n +2 de População\n +3 de Aprovação Pública")
        ));

        return eventoEconommiaAlta;
    }  
    
    // Evento Economia Baixa 
    public static List<Evento> eventoEconomiaBaixa() {
        List<Evento> eventoEconimiaBaixa = new ArrayList<>();

        eventoEconimiaBaixa.add(new Evento("URGENTE!!\n\nA economia da cidade entrou em colapso. Empresas estão fechando e o desemprego cresce rapidamente.",
        
            new Escolha("Plano agressivo de recuperação econômica", -12, +20, +5, +6,
            "Você toma medidas ousadas que reativam a economia rapidamente, mas com custos ambientais e riscos futuros.\n\n -12 de Meio Ambiente\n +20 de Fundos Econômicos\n +5 de População\n +6 de Aprovação Pública"),

            new Escolha("Aumentar impostos para recuperar os cofres", 0, +15, -8, -15,
            "A arrecadação melhora, mas a população e empresas reagem negativamente.\n\n +15 de Fundos Econômicos\n -8 de População\n -15 de Aprovação Pública"),

            new Escolha("Não intervir e esperar recuperação natural", 0, -12, -10, -12,
            "A crise se agrava e afeta todos os setores da cidade.\n\n -12 de Fundos Econômicos\n -10 de População\n -12 de Aprovação Pública")
        ));

        return eventoEconimiaBaixa;
    }

    // Evento População Alta
    public static List<Evento> eventoPopulacaoAlta() {
        List<Evento> eventoPopulacaoAlta = new ArrayList<>();

        eventoPopulacaoAlta.add(new Evento("URGENTE!!\n\nA explosão demográfica sobrecarregou a infraestrutura urbana. Transporte e habitação estão em colapso!",
        
            new Escolha("Construir conjuntos habitacionais verticais rápidos", -8, -6, +10, +5,
            "Você abriga as novas famílias, expandindo a capacidade urbana, mas o impacto ambiental nas áreas periféricas é alto.\n\n -8 de Meio Ambiente\n -6 de Fundos Econômicos\n +10 de População\n +5 de Aprovação Pública"),

            new Escolha("Cobrar uma taxa de imigração e novos moradores", 0, +12, -10, -8,
            "A arrecadação sobe e o crescimento da população é freado à força, mas a medida é vista como autoritária.\n\n +12 de Fundos Econômicos\n -10 de População\n -8 de Aprovação Pública"),

            new Escolha("Expandir o perímetro urbano sobre áreas verdes", -15, -4, +15, +8,
            "A cidade cresce sem barreiras acomodando todo mundo, mas destrói completamente as reservas ambientais locais.\n\n -15 de Meio Ambiente\n -4 de Fundos Econômicos\n +15 de População\n +8 de Aprovação Pública")
        ));

        return eventoPopulacaoAlta;
    }

    // Evento População Baixa
    public static List<Evento> eventoPopulacaoBaixa() {
        List<Evento> eventoPopulacaoBaixa = new ArrayList<>();

        eventoPopulacaoBaixa.add(new Evento("URGENTE!!\n\nA cidade está virando uma 'cidade fantasma'. A falta de mão de obra ameaça fechar o comércio local.",
        
            new Escolha("Oferecer isenção de impostos e moradia grátis para novos imigrantes", -4, -10, +20, +8,
            "Uma enxurrada de novas pessoas chega atraída pelos benefícios, reaquecendo as ruas e mudando a dinâmica da cidade.\n\n -4 de Meio Ambiente\n -10 de Fundos Econômicos\n +20 de População\n +8 de Aprovação Pública"),

            new Escolha("Investir em automação e tecnologia para suprir a falta de pessoas", 0, -15, -2, +5,
            "Os cofres esvaziam com tecnologia cara. As empresas continuam funcionando com robôs, mas a cidade continua vazia.\n\n -15 de Fundos Econômicos\n -2 de População\n +5 de Aprovação Pública"),

            new Escolha("Não fazer nada e reduzir o tamanho dos serviços públicos", +5, +5, -6, -10,
            "O ecossistema se recupera sem humanos por perto e o custo de manutenção cai, mas o comércio entra em depressão.\n\n +5 de Meio Ambiente\n +5 de Fundos Econômicos\n -6 de População\n -10 de Aprovação Pública")
        ));

        return eventoPopulacaoBaixa;
    }
}