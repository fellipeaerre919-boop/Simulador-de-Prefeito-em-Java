package PrefeitoSimulator;
 
import javax.swing.*;
import java.awt.*;
 
public class JogoUI {
 
    // ─── Constantes ───────────────────────────────────────────────
    private static final Color COR_BLOCO        = new Color(0, 68, 148, 210);
    private static final Color COR_BORDA        = new Color(255, 255, 255);
    private static final Color COR_EVENTO       = new Color(82, 131, 178);
    private static final Color COR_BOTAO        = new Color(42, 65, 84);
    private static final int   LIMITE_VERDE     = 70;
    private static final int   LIMITE_AMARELO   = 30;
    private static final int   LARGURA_LATERAL  = 400;
    private static final int   RAIO_PAINEL      = 40;
    private static final int   RAIO_CONTEUDO    = 30;
    private static final int   RAIO_BARRA       = 20;
    private static final int   RAIO_BOTAO       = 30;
 
    // ─── Dependências ─────────────────────────────────────────────
    private Jogo jogo;
 
    // ─── Componentes ──────────────────────────────────────────────
    private JFrame       janela;
    private JLabel       labelStatus;
    private JTextArea    textoEvento;
    private JLabel       imagemEvento;
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
 
        // Bloco central — arredondado com borda colorida
        JPanel blocoJogo = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // fundo arredondado
                g2.setColor(COR_BLOCO);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), RAIO_PAINEL, RAIO_PAINEL);
                // borda colorida arredondada
                g2.setColor(COR_BORDA);
                g2.setStroke(new BasicStroke(4));
                g2.drawRoundRect(2, 2, getWidth() - 4, getHeight() - 4, RAIO_PAINEL, RAIO_PAINEL);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        blocoJogo.setOpaque(false);
        blocoJogo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        blocoJogo.add(criarPainelTopo(),     BorderLayout.NORTH);
        blocoJogo.add(criarPainelConteudo(), BorderLayout.CENTER);
 
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
        labelStatus.setFont(new Font("Arial", Font.BOLD, 24));
        labelStatus.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
 
        topContainer.add(statsPanel,  BorderLayout.NORTH);
        topContainer.add(labelStatus, BorderLayout.CENTER);
 
        return topContainer;
    }
 
    // ─── Painel conteúdo (texto + imagem + botões) ───────────────
    private JPanel criarPainelConteudo() {
        // painel arredondado que agrupa texto, imagem e botões
        JPanel painel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(COR_EVENTO);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), RAIO_CONTEUDO, RAIO_CONTEUDO);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        painel.setOpaque(false);
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
 
        // texto do evento
        textoEvento = new JTextArea();
        textoEvento.setEditable(false);
        textoEvento.setLineWrap(true);
        textoEvento.setWrapStyleWord(true);
        textoEvento.setFont(new Font("Arial", Font.BOLD, 18));
        textoEvento.setBackground(COR_EVENTO);
        textoEvento.setForeground(Color.WHITE);
        textoEvento.setOpaque(true);
        textoEvento.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
 
        // imagem do evento — centralizada no meio
        imagemEvento = new JLabel();
        imagemEvento.setHorizontalAlignment(SwingConstants.CENTER);
 
        painel.add(textoEvento,        BorderLayout.NORTH);
        painel.add(imagemEvento,       BorderLayout.CENTER);
        painel.add(criarPainelBotoes(), BorderLayout.SOUTH);
 
        return painel;
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
 
        // Para adicionar imagem por evento, use:
        // imagemEvento.setIcon(new ImageIcon("PrefeitoSimulator/imagens/" + eventoAtual.getImagem()));
        imagemEvento.setIcon(null);
 
        Escolha[] escolhas = eventoAtual.getEscolhas();
        for (int i = 0; i < botoes.length; i++) {
            if (i < escolhas.length) {
                botoes[i].setText(escolhas[i].getTexto());
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
        textoEvento.setText(escolha.getConsequencia());
 
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
 
    // ─── Barras arredondadas ──────────────────────────────────────
    private JProgressBar criarBarra() {
        JProgressBar bar = new JProgressBar(0, 100) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // fundo da barra
                g2.setColor(new Color(60, 60, 60));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), RAIO_BARRA, RAIO_BARRA);
                // preenchimento proporcional ao valor
                int largura = (int) (getWidth() * (getValue() / 100.0));
                g2.setColor(getForeground());
                g2.fillRoundRect(0, 0, largura, getHeight(), RAIO_BARRA, RAIO_BARRA);
                // texto centralizado
                g2.setColor(Color.WHITE);
                g2.setFont(getFont());
                FontMetrics fm = g2.getFontMetrics();
                String texto = getString();
                int x = (getWidth() - fm.stringWidth(texto)) / 2;
                int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
                g2.drawString(texto, x, y);
                g2.dispose();
            }
        };
        bar.setStringPainted(false);
        bar.setFont(new Font("Arial", Font.BOLD, 14)); // texto da barra
        bar.setPreferredSize(new Dimension(0, 30)); // 40 = altura em pixels
        return bar;
    }
 
    private void atualizarBarras() {
        atualizarBarra(barAmbiente,  jogo.getAmbiente(),  "Meio Ambiente");
        atualizarBarra(barEconomia,  jogo.getEconomia(),  "Fundos Disponíveis");
        atualizarBarra(barPopulacao, jogo.getPopulacao(), "Satisfação Popular");
        atualizarBarra(barAprovacao, jogo.getAprovacao(), "Aprovação Pública");
    }
 
    private void atualizarBarra(JProgressBar bar, int valor, String nome) {
        bar.setValue(valor);
        bar.setString(nome + ": " + valor);
        bar.setForeground(corPorValor(valor));
    }
 
    // ─── Utilitários ─────────────────────────────────────────────
    private Color corPorValor(int valor) {
        if (valor > LIMITE_VERDE)   return new Color(0, 224, 76);
        if (valor > LIMITE_AMARELO) return Color.ORANGE;
        return Color.RED;
    }
 
    // Botões arredondados via UI customizada
    private void estilizarBotao(JButton botao) {
        botao.setFocusPainted(false);
        botao.setFont(new Font("Arial", Font.BOLD, 22));
        botao.setForeground(Color.WHITE);
        botao.setContentAreaFilled(false);
        botao.setBorderPainted(false);
        botao.setOpaque(false);
 
        botao.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(COR_BOTAO);
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), RAIO_BOTAO, RAIO_BOTAO);
                g2.dispose();
                super.paint(g, c);
            }
        });
    }
}