import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        panelJogador.setLayout(new GridLayout(6, 2, 10, 10)); // Alterado para 8 linhas
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
                fb.insertString(offset, string.replaceAll("[^a-zA-Z ]", ""), attr);
            }
    
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                fb.replace(offset, length, text.replaceAll("[^a-zA-Z ]", ""), attrs);
            }
        });
    
        ((AbstractDocument) txtIdade.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
            }
    
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                fb.replace(offset, length, text.replaceAll("[^0-9]", ""), attrs);
            }
        });
    
        ((AbstractDocument) txtGenero.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[MFmf]") && fb.getDocument().getLength() + string.length() <= 1) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[MFmf]") && fb.getDocument().getLength() - length + text.length() <= 1) {
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
                Jogador.adicionarJogador(jogador);
                System.out.println(jogador.toString());
                frameJogador.dispose();
            }
        });
    
        panelJogador.add(new JLabel());
        panelJogador.add(btnSalvar);
    
        frameJogador.add(panelJogador, BorderLayout.CENTER);
        frameJogador.setVisible(true);
    }

    private void registarArbitro() {
        JFrame frameArbitro = new JFrame("Registar Árbitro");
        frameArbitro.setSize(400, 300);
        frameArbitro.setLayout(new BorderLayout());
    
        JPanel panelArbitro = new JPanel();
        panelArbitro.setLayout(new GridLayout(6, 2, 10, 10));
        panelArbitro.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        JTextField txtNome = new JTextField();
        JTextField txtIdade = new JTextField();
        JTextField txtGenero = new JTextField();
        JTextField txtCertificacoes = new JTextField();
    
        // Configurar filtros de entrada
        ((AbstractDocument) txtNome.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                fb.insertString(offset, string.replaceAll("[^a-zA-Z ]", ""), attr);
            }
    
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                fb.replace(offset, length, text.replaceAll("[^a-zA-Z ]", ""), attrs);
            }
        });
    
        ((AbstractDocument) txtIdade.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
            }
    
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                fb.replace(offset, length, text.replaceAll("[^0-9]", ""), attrs);
            }
        });
    
        ((AbstractDocument) txtGenero.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[MFmf]") && fb.getDocument().getLength() + string.length() <= 1) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[MFmf]") && fb.getDocument().getLength() - length + text.length() <= 1) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    
        ((AbstractDocument) txtCertificacoes.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                fb.insertString(offset, string.replaceAll("[^a-zA-Z ]", ""), attr);
            }
    
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                fb.replace(offset, length, text.replaceAll("[^a-zA-Z ]", ""), attrs);
            }
        });
    
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
    
                Arbitro arbitro = new Arbitro(nome, idade, genero, certificacoes);
                Arbitro.adicionarArbitro(arbitro);
                System.out.println(arbitro.toString());
                frameArbitro.dispose();
            }
        });
    
        panelArbitro.add(new JLabel());
        panelArbitro.add(btnSalvar);
    
        frameArbitro.add(panelArbitro, BorderLayout.CENTER);
        frameArbitro.setVisible(true);
    }

    private void gerarTorneio() {
        // Implementar lógica para gerar torneio
    }

    private void visualizarCampeonato() {
        JFrame frameCampeonato = new JFrame("Visualizar Campeonato");
        frameCampeonato.setSize(600, 400);
        frameCampeonato.setLayout(new BorderLayout());
    
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
        ArrayList<Jogador> jogadores = Jogador.getJogadores();
        for (Jogador jogador : jogadores) {
            info.append(jogador.toString()).append("\n");
        }
    
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
        ArrayList<Jogador> jogadores = Jogador.getJogadores();
        String[] nomes = new String[jogadores.size()];
        for (int i = 0; i < jogadores.size(); i++) {
            nomes[i] = jogadores.get(i).getNome();
        }
        return nomes;
    }

    private String[] getNomesArbitros() {
        ArrayList<Arbitro> arbitros = Arbitro.getArbitros();
        String[] nomes = new String[arbitros.size()];
        for (int i = 0; i < arbitros.size(); i++) {
            nomes[i] = arbitros.get(i).getNome();
        }
        return nomes;
    }
}