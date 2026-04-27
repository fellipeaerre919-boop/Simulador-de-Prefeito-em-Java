package PrefeitoSimulator;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

public class JogoUI {

    // ─── Constantes ───────────────────────────────────────────────
    private static final Color COR_BLOCO       = new Color(30, 30, 30, 210); // alpha tratado via paintComponent
    private static final Color COR_EVENTO      = new Color(45, 45, 45);      // sem alpha — evita ghosting
    private static final Color COR_BOTAO       = new Color(70, 130, 180);
    private static final int   LIMITE_VERDE    = 70;
    private static final int   LIMITE_AMARELO  = 30;
    private static final int   LARGURA_LATERAL = 250;

    // ─── Dependências ─────────────────────────────────────────────
    private Jogo jogo;

    // ─── Componentes ──────────────────────────────────────────────
    private JFrame       janela;
    private JLabel       labelStatus;
    private JTextArea    textoEvento;
    private JProgressBar barAmbiente, barEconomia, barPopulacao, barAprovacao;
    private JButton[]    botoes;
    private JButton      botaoProximo;
    private Evento       eventoAtual;

    // ─── CardLayout — alterna entre botões de escolha e botão próximo ───
    private CardLayout cardBotoes;
    private JPanel     painelBotoes;

    // ─── Construtor ───────────────────────────────────────────────
    public JogoUI(Jogo jogo) {
        this.jogo = jogo;
    }

    // ─── Inicialização ────────────────────────────────────────────
    public void iniciar() {
        janela = new JFrame("Prefeito Simulator");
        UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
        UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
        janela.setMinimumSize(new Dimension(800, 600));
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // FUNDO — imagem cobre a janela inteira
        JPanel fundoPainel = new JPanel(new BorderLayout()) {
            Image img = new ImageIcon("PrefeitoSimulator/imagens/cidade.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Espaçadores laterais — transparentes, deixam a imagem aparecer
        JPanel espacoEsquerda = new JPanel();
        espacoEsquerda.setOpaque(false);
        espacoEsquerda.setPreferredSize(new Dimension(LARGURA_LATERAL, 0));

        JPanel espacoDireita = new JPanel();
        espacoDireita.setOpaque(false);
        espacoDireita.setPreferredSize(new Dimension(LARGURA_LATERAL, 0));

        // Bloco central — vai do NORTH ao SOUTH, contém tudo do jogo
        // setOpaque(false) + paintComponent manual = alpha sem ghosting
        JPanel blocoJogo = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(COR_BLOCO);
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        blocoJogo.setOpaque(false);
        blocoJogo.add(criarPainelTopo(),   BorderLayout.NORTH);
        blocoJogo.add(criarPainelEvento(), BorderLayout.CENTER);
        blocoJogo.add(criarPainelBotoes(), BorderLayout.SOUTH);

        fundoPainel.add(espacoEsquerda, BorderLayout.WEST);
        fundoPainel.add(blocoJogo,      BorderLayout.CENTER);
        fundoPainel.add(espacoDireita,  BorderLayout.EAST);

        janela.setContentPane(fundoPainel);
        carregarEvento();
        janela.setVisible(true);
    }

    // ─── Painel topo (barras + status) ───────────────────────────
    private JPanel criarPainelTopo() {
        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.setOpaque(false);

        JPanel statsPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        statsPanel.setOpaque(false);
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        barAmbiente  = criarBarra();
        barEconomia  = criarBarra();
        barPopulacao = criarBarra();
        barAprovacao = criarBarra();

        statsPanel.add(barAmbiente);
        statsPanel.add(barEconomia);
        statsPanel.add(barPopulacao);
        statsPanel.add(barAprovacao);

        labelStatus = new JLabel("", SwingConstants.CENTER);
        labelStatus.setForeground(Color.WHITE);
        labelStatus.setFont(new Font("Arial", Font.BOLD, 14));
        labelStatus.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

        topContainer.add(statsPanel,  BorderLayout.NORTH);
        topContainer.add(labelStatus, BorderLayout.CENTER);

        return topContainer;
    }

    // ─── Painel centro (texto do evento) ─────────────────────────
    private JTextArea criarPainelEvento() {
        textoEvento = new JTextArea();
        textoEvento.setEditable(false);
        textoEvento.setLineWrap(true);
        textoEvento.setWrapStyleWord(true);
        textoEvento.setFont(new Font("Arial", Font.BOLD, 18));
        textoEvento.setBackground(COR_EVENTO);
        textoEvento.setForeground(Color.WHITE);
        textoEvento.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return textoEvento;
    }

    // ─── Painel sul (botões) ──────────────────────────────────────
    private JPanel criarPainelBotoes() {
        cardBotoes   = new CardLayout();
        painelBotoes = new JPanel(cardBotoes);
        painelBotoes.setOpaque(false);

        // ── CARD 1: três botões de escolha ──
        JPanel cardEscolha = new JPanel(new GridLayout(3, 1, 10, 10));
        cardEscolha.setOpaque(false);
        cardEscolha.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        botoes = new JButton[3];
        for (int i = 0; i < botoes.length; i++) {
            int index = i;
            botoes[i] = new JButton();
            estilizarBotao(botoes[i]);
            botoes[i].addActionListener(e -> escolher(index));
            cardEscolha.add(botoes[i]);
        }

        // ── CARD 2: botão próximo centralizado no meio ──
        JPanel cardProximo = new JPanel(new GridLayout(3, 1, 10, 10));
        cardProximo.setOpaque(false);
        cardProximo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        botaoProximo = new JButton("Próxima Rodada");
        estilizarBotao(botaoProximo);
        botaoProximo.addActionListener(e -> carregarEvento());

        // painéis vazios acima e abaixo deixam o botão no meio
        JPanel vazio1 = new JPanel(); vazio1.setOpaque(false);
        JPanel vazio2 = new JPanel(); vazio2.setOpaque(false);

        cardProximo.add(vazio1);
        cardProximo.add(botaoProximo);
        cardProximo.add(vazio2);

        painelBotoes.add(cardEscolha, "ESCOLHA");
        painelBotoes.add(cardProximo, "PROXIMO");

        return painelBotoes;
    }

    // ─── Lógica de tela ──────────────────────────────────────────
    private void carregarEvento() {
        eventoAtual = jogo.proximoEvento();
        textoEvento.setText(eventoAtual.getDescricao());

        Escolha[] escolhas = eventoAtual.getEscolhas();
        for (int i = 0; i < botoes.length; i++) {
            if (i < escolhas.length) {
                botoes[i].setText(escolhas[i].texto);
                botoes[i].setVisible(true);
            } else {
                botoes[i].setVisible(false);
            }
        }

        labelStatus.setText(jogo.statusRodada());
        atualizarBarras();
        cardBotoes.show(painelBotoes, "ESCOLHA");
        // Atualiza a tela para apagar o que estava antes e mostrar o novo conteúdo
        janela.repaint();
    }

    private void escolher(int index) {
        Escolha escolha = eventoAtual.getEscolhas()[index];
        jogo.aplicarEscolha(escolha);
        textoEvento.setText(escolha.consequencia);

        atualizarBarras();
        cardBotoes.show(painelBotoes, "PROXIMO");
        // Atualiza a tela para apagar o que estava antes e mostrar o novo conteúdo
        janela.repaint();
        verificarFimDeJogo();
    }

    private void verificarFimDeJogo() {
        if (!jogo.isFimDeJogo()) return;
        JOptionPane.showMessageDialog(janela,
                "🏁 Fim de jogo!\n\n" + jogo.statusRodada(),
                "GAME OVER.",
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    // ─── Barras ───────────────────────────────────────────────────
    private JProgressBar criarBarra() {
        JProgressBar bar = new JProgressBar(0, 100);
        bar.setStringPainted(true);
        bar.setFont(new Font("Arial", Font.BOLD, 12));
        return bar;
    }

    private void atualizarBarras() {
        atualizarBarra(barAmbiente,  jogo.getAmbiente(),  "Sustentabilidade e Meio Ambiente");
        atualizarBarra(barEconomia,  jogo.getEconomia(),  "Fundos Disponíveis");
        atualizarBarra(barPopulacao, jogo.getPopulacao(), "Satisfação da População");
        atualizarBarra(barAprovacao, jogo.getAprovacao(), "Aprovação Pública");
    }

    private void atualizarBarra(JProgressBar bar, int valor, String nome) {
        bar.setValue(valor);
        bar.setString(nome + ": " + valor);
        bar.setForeground(corPorValor(valor));
    }

    // ─── Utilitários ─────────────────────────────────────────────
    private Color corPorValor(int valor) {
        if (valor > LIMITE_VERDE)   return Color.GREEN;
        if (valor > LIMITE_AMARELO) return Color.YELLOW;
        return Color.RED;
    }

    private void estilizarBotao(JButton botao) {
        botao.setFocusPainted(false);
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setBackground(COR_BOTAO);
        botao.setForeground(Color.WHITE);
    }
}