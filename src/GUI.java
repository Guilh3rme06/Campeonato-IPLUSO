package src;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Classe que representa a interface gráfica do sistema.
 */
public class GUI {
    private Campeonato campeonato;

    public GUI() {
        campeonato = new Campeonato();
        criarInterface();
    }

    private void criarInterface() {
        JFrame frame = new JFrame("Campeonato de Xadrez - IPLUSO");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));

        // Título
        JLabel titulo = new JLabel("Campeonato de Xadrez", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        frame.add(titulo, BorderLayout.NORTH);

        // Painel de controlo
        JPanel panelControlo = new JPanel();
        panelControlo.setLayout(new GridLayout(4, 1, 10, 10));
        panelControlo.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));

        // Botões
        JButton btnRegistarJogador = new JButton("Registar Jogador");
        JButton btnRegistarArbitro = new JButton("Registar Árbitro");
        JButton btnGerarTorneio = new JButton("Gerar/Controlar Torneios");
        JButton btnVisualizarCampeonato = new JButton("Visualizar Campeonato");

        // Ações dos botões
        btnRegistarJogador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registarJogador();
            }
        });

        btnRegistarArbitro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registarArbitro();
            }
        });

        btnGerarTorneio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarTorneio();
            }
        });

        btnVisualizarCampeonato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarCampeonato();
            }
        });

        // Adicionar botões ao painel de controlo
        panelControlo.add(btnRegistarJogador);
        panelControlo.add(btnRegistarArbitro);
        panelControlo.add(btnGerarTorneio);
        panelControlo.add(btnVisualizarCampeonato);

        // Adicionar painel de controlo ao frame
        frame.add(panelControlo, BorderLayout.WEST);

        frame.setVisible(true);
    }

    private void registarJogador() {
        JFrame frameJogador = new JFrame("Registar Jogador");
        frameJogador.setSize(400, 300);
        frameJogador.setLayout(new BorderLayout());

        JPanel panelJogador = new JPanel();
        panelJogador.setLayout(new GridLayout(6, 2, 10, 10));
        panelJogador.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField txtNome = new JTextField();
        JTextField txtIdade = new JTextField();
        JTextField txtGenero = new JTextField();
        JTextField txtRankings = new JTextField("0");
        JTextField txtPartidasJogadas = new JTextField("0");

        // Configurar filtros de entrada
        ((AbstractDocument) txtNome.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[a-zA-Z]+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z]+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        ((AbstractDocument) txtIdade.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        ((AbstractDocument) txtGenero.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[MFmf]")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[MFmf]")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        // Configurar campos de rankings e partidas jogadas como não editáveis
        txtRankings.setEditable(false);
        txtPartidasJogadas.setEditable(false);

        panelJogador.add(new JLabel("Nome:"));
        panelJogador.add(txtNome);
        panelJogador.add(new JLabel("Idade:"));
        panelJogador.add(txtIdade);
        panelJogador.add(new JLabel("Género:"));
        panelJogador.add(txtGenero);
        panelJogador.add(new JLabel("Rankings:"));
        panelJogador.add(txtRankings);
        panelJogador.add(new JLabel("Partidas Jogadas:"));
        panelJogador.add(txtPartidasJogadas);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                int idade = Integer.parseInt(txtIdade.getText());
                char genero = txtGenero.getText().charAt(0);
                int rankings = Integer.parseInt(txtRankings.getText());
                int partidasJogadas = Integer.parseInt(txtPartidasJogadas.getText());

                Jogador jogador = new Jogador(nome, idade, genero, rankings, partidasJogadas);
                campeonato.adicionarJogador(jogador);
                frameJogador.dispose();
            }
        });

        panelJogador.add(new JLabel()); // Adiciona um espaço vazio para alinhar o botão
        panelJogador.add(btnSalvar);

        frameJogador.add(panelJogador, BorderLayout.CENTER);
        frameJogador.setVisible(true);
    }

    private void registarArbitro() {
        JFrame frameArbitro = new JFrame("Registar Árbitro");
        frameArbitro.setSize(400, 200);
        frameArbitro.setLayout(new BorderLayout());

        JPanel panelArbitro = new JPanel();
        panelArbitro.setLayout(new GridLayout(4, 2, 10, 10));
        panelArbitro.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField txtNome = new JTextField();
        JTextField txtIdade = new JTextField();
        JTextField txtGenero = new JTextField();
        JTextField txtCertificacoes = new JTextField();

        panelArbitro.add(new JLabel("Nome:"));
        panelArbitro.add(txtNome);
        panelArbitro.add(new JLabel("Idade:"));
        panelArbitro.add(txtIdade);
        panelArbitro.add(new JLabel("Género:"));
        panelArbitro.add(txtGenero);
        panelArbitro.add(new JLabel("Certificações:"));
        panelArbitro.add(txtCertificacoes);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                int idade = Integer.parseInt(txtIdade.getText());
                char genero = txtGenero.getText().charAt(0);
                String certificacoes = txtCertificacoes.getText();

                Arbitro arbitro = new Arbitro(nome, idade, genero, 0, certificacoes);
                campeonato.adicionarArbitro(arbitro);
                frameArbitro.dispose();
            }
        });

        panelArbitro.add(new JLabel()); // Adiciona um espaço vazio para alinhar o botão
        panelArbitro.add(btnSalvar);

        frameArbitro.add(panelArbitro, BorderLayout.CENTER);
        frameArbitro.setVisible(true);
    }

    private void gerarTorneio() {
        JFrame frameTorneio = new JFrame("Gerar/Controlar Torneio");
        frameTorneio.setSize(400, 300);
        frameTorneio.setLayout(new BorderLayout());

        JPanel panelTorneio = new JPanel();
        panelTorneio.setLayout(new GridLayout(5, 2, 10, 10));
        panelTorneio.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblEscolhaGenero = new JLabel("Escolha o género:");
        JComboBox<String> comboGenero = new JComboBox<>(new String[]{"Masculino", "Feminino"});

        JLabel lblJogador1 = new JLabel("Jogador 1:");
        JComboBox<String> comboJogador1 = new JComboBox<>(getNomesJogadores());

        JLabel lblJogador2 = new JLabel("Jogador 2:");
        JComboBox<String> comboJogador2 = new JComboBox<>(getNomesJogadores());

        JLabel lblArbitro = new JLabel("Árbitro:");
        JComboBox<String> comboArbitro = new JComboBox<>(getNomesArbitros());

        JButton btnGerar = new JButton("Gerar Torneio");

        btnGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String generoSelecionado = (String) comboGenero.getSelectedItem();
                String nomeJogador1 = (String) comboJogador1.getSelectedItem();
                String nomeJogador2 = (String) comboJogador2.getSelectedItem();
                String nomeArbitro = (String) comboArbitro.getSelectedItem();

                Jogador jogador1 = campeonato.getJogadorPorNome(nomeJogador1);
                Jogador jogador2 = campeonato.getJogadorPorNome(nomeJogador2);
                Arbitro arbitro = campeonato.getArbitroPorNome(nomeArbitro);

                if (jogador1 != null && jogador2 != null && arbitro != null) {
                    PartidaSingulares partida = new PartidaSingulares(jogador1, jogador2, arbitro);
                    Jogador vencedor = partida.determinarVencedor();
                    double duracao = partida.tempoPartida();

                    mostrarDetalhesTorneio(generoSelecionado, jogador1, jogador2, vencedor, duracao, arbitro);
                } else {
                    JOptionPane.showMessageDialog(frameTorneio, "Jogadores ou árbitro não encontrados.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panelTorneio.add(lblEscolhaGenero);
        panelTorneio.add(comboGenero);
        panelTorneio.add(lblJogador1);
        panelTorneio.add(comboJogador1);
        panelTorneio.add(lblJogador2);
        panelTorneio.add(comboJogador2);
        panelTorneio.add(lblArbitro);
        panelTorneio.add(comboArbitro);
        panelTorneio.add(new JLabel()); // Espaço vazio
        panelTorneio.add(btnGerar);

        frameTorneio.add(panelTorneio, BorderLayout.CENTER);
        frameTorneio.setVisible(true);
    }

    private void mostrarDetalhesTorneio(String genero, Jogador jogador1, Jogador jogador2, Jogador vencedor, double duracao, Arbitro arbitro) {
        JFrame frameDetalhes = new JFrame("Detalhes do Torneio");
        frameDetalhes.setSize(500, 400);
        frameDetalhes.setLayout(new BorderLayout());

        JPanel panelDetalhes = new JPanel();
        panelDetalhes.setLayout(new GridLayout(6, 2, 10, 10));
        panelDetalhes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelDetalhes.add(new JLabel("Género:"));
        panelDetalhes.add(new JLabel(genero));
        panelDetalhes.add(new JLabel("Jogador 1:"));
        panelDetalhes.add(new JLabel(jogador1.getNome()));
        panelDetalhes.add(new JLabel("Jogador 2:"));
        panelDetalhes.add(new JLabel(jogador2.getNome()));
        panelDetalhes.add(new JLabel("Vencedor:"));
        panelDetalhes.add(new JLabel(vencedor.getNome()));
        panelDetalhes.add(new JLabel("Duração:"));
        panelDetalhes.add(new JLabel(duracao + " minutos"));
        panelDetalhes.add(new JLabel("Árbitro:"));
        panelDetalhes.add(new JLabel(arbitro.getNome()));

        frameDetalhes.add(panelDetalhes, BorderLayout.CENTER);
        frameDetalhes.setVisible(true);
    }

    private void visualizarCampeonato() {
        JFrame frameCampeonato = new JFrame("Visualizar Campeonato");
        frameCampeonato.setSize(600, 400);
        frameCampeonato.setLayout(new BorderLayout(10, 10));

        JPanel panelCampeonato = new JPanel();
        panelCampeonato.setLayout(new BorderLayout(10, 10));
        panelCampeonato.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Adicionar informações sobre o campeonato
        StringBuilder info = new StringBuilder();
        info.append("Estado dos Torneios:\n");
        // Adicionar lógica para exibir o estado dos torneios

        info.append("\nRankings dos Jogadores:\n");
        // Adicionar lógica para exibir os rankings dos jogadores

        textArea.setText(info.toString());

        panelCampeonato.add(scrollPane, BorderLayout.CENTER);

        JButton btnAtribuirPremio = new JButton("Atribuir Prémio");
        btnAtribuirPremio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para atribuir prémio
            }
        });

        panelCampeonato.add(btnAtribuirPremio, BorderLayout.SOUTH);
        frameCampeonato.add(panelCampeonato, BorderLayout.CENTER);
        frameCampeonato.setVisible(true);
    }

    private String[] getNomesJogadores() {
        List<Jogador> jogadores = campeonato.getJogadores();
        String[] nomes = new String[jogadores.size()];
        for (int i = 0; i < jogadores.size(); i++) {
            nomes[i] = jogadores.get(i).getNome();
        }
        return nomes;
    }

    private String[] getNomesArbitros() {
        List<Arbitro> arbitros = campeonato.getArbitros();
        String[] nomes = new String[arbitros.size()];
        for (int i = 0; i < arbitros.size(); i++) {
            nomes[i] = arbitros.get(i).getNome();
        }
        return nomes;
    }
}