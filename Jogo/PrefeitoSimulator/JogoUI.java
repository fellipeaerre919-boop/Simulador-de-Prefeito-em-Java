package PrefeitoSimulator;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

// Classe que define como é a Interface(UI) do Jogo
public class JogoUI {
    private Jogo jogo;
    private JFrame janela;

    private JLabel labelStatus;
    private JTextArea textoEvento;

    private JProgressBar barAmbiente;
    private JProgressBar barEconomia;
    private JProgressBar barPopulacao;
    private JProgressBar barAprovacao;

    private JButton[] botoes;
    private JButton botaoProximo;

    private Evento eventoAtual;

    // Construtor dependente, ele recebe Jogo como parâmetro, fazendo com que essa Classe UI acesse a Classe Jogo e utilize seus dados
    public JogoUI(Jogo jogo) {
        this.jogo = jogo;
    }

    // Inicializa a UI, usado no Main
    public void iniciar() {
        janela = new JFrame("Prefeito Simulator");
        UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
        UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
        janela.setSize(600, 650);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BorderLayout());
        janela.getContentPane().setBackground(new Color(30, 30, 30));
        
        // TOPO (Barras + Rodadas)
        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.setBackground(new Color(30, 30, 30));

        JPanel statsPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        statsPanel.setBackground(new Color(30, 30, 30));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        barAmbiente = criarBarra("");
        barEconomia = criarBarra("");
        barPopulacao = criarBarra("");
        barAprovacao = criarBarra("");

        statsPanel.add(barAmbiente);
        statsPanel.add(barEconomia);
        statsPanel.add(barPopulacao);
        statsPanel.add(barAprovacao);

        labelStatus = new JLabel("", SwingConstants.CENTER);
        labelStatus.setForeground(Color.WHITE);
        labelStatus.setFont(new Font("Arial", Font.BOLD, 14));
        labelStatus.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

        topContainer.add(statsPanel, BorderLayout.NORTH);
        topContainer.add(labelStatus, BorderLayout.CENTER);

        janela.add(topContainer, BorderLayout.NORTH);

        // CENTRO (Evento)
        textoEvento = new JTextArea();
        textoEvento.setEditable(false);
        textoEvento.setLineWrap(true);
        textoEvento.setWrapStyleWord(true);
        textoEvento.setFont(new Font("Arial", Font.BOLD, 18));
        textoEvento.setBackground(new Color(45, 45, 45));
        textoEvento.setForeground(Color.WHITE);
        textoEvento.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        janela.add(textoEvento, BorderLayout.CENTER);

        // BASE (Botões)
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBackground(new Color(30, 30, 30));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        botoes = new JButton[3];

        botaoProximo = new JButton("Próxima Rodada");
        estilizarBotao(botaoProximo);
        botaoProximo.setVisible(false);

        botaoProximo.addActionListener(e -> carregarEvento());

        buttonPanel.add(botaoProximo);

        for (int i = 0; i < botoes.length; i++) {
            int index = i;
            botoes[i] = new JButton();
            estilizarBotao(botoes[i]);
            botoes[i].addActionListener(e -> escolher(index));
            buttonPanel.add(botoes[i]);
        }

        janela.add(buttonPanel, BorderLayout.SOUTH);

        carregarEvento();
        janela.setVisible(true);
    }

    // Carrega o próximo Evento na tela
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
        botaoProximo.setVisible(false);
    }

    // Aplica Lógica por meio de outras classes e Mostra a Escolha e suas Consequências na tela
    private void escolher(int index) {
        Escolha escolha = eventoAtual.getEscolhas()[index];

        jogo.aplicarEscolha(escolha);
        textoEvento.setText(escolha.consequencia);
        // Esconde os botões de Escolha após a decisão
        for (JButton b : botoes) {
            b.setVisible(false);
        }
        // Exibe o botão "Próximo" para ir a próxima rodada
        botaoProximo.setVisible(true);
        atualizarBarras();

        if (jogo.isFimDeJogo()) {
            JOptionPane.showMessageDialog(janela,
                    "🏁 Fim de jogo!\n\n" + jogo.statusRodada(),
                    "GAME OVER.",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    // Cria a Barra para os Atributos
    private JProgressBar criarBarra(String titulo) {
        JProgressBar bar = new JProgressBar(0, 100);
        bar.setStringPainted(true);
        bar.setString(titulo);
        bar.setFont(new Font("Arial", Font.BOLD, 12));
        return bar;
    }

    // Define o nome das Barras de Atributos
    private void atualizarBarras() {
        atualizarBarra(barAmbiente, jogo.getAmbiente(), "Sustentabilidade e Meio Ambiente");
        atualizarBarra(barEconomia, jogo.getEconomia(), "Fundos Disponíveis");
        atualizarBarra(barPopulacao, jogo.getPopulacao(), "Satisfação da População");
        atualizarBarra(barAprovacao, jogo.getAprovacao(), "Aprovação Pública");
    }

    // Atualiza o valor numérico das Barras, independente uma da outra na tela
    private void atualizarBarra(JProgressBar bar, int valor, String nome) {
        bar.setValue(valor);
        bar.setString(nome + ": " + valor);

        if (valor > 70) {
            bar.setForeground(Color.GREEN);
        } else if (valor > 30) {
            bar.setForeground(Color.YELLOW);
        } else {
            bar.setForeground(Color.RED);
        }
    }

    // Estiliza os Botões de Escolha e o botão "Próximo"
    private void estilizarBotao(JButton botao) {
        botao.setFocusPainted(false);
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setBackground(new Color(70, 130, 180));
        botao.setForeground(Color.WHITE);
    } 
}