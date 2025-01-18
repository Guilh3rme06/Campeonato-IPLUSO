import javax.swing.*;
import javax.swing.text.*;

import Participantes.Arbitro;
import Participantes.Jogador;
import Partidas.PartidaSingulares;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Classe que representa a interface gráfica do sistema.
 */
public class GUI {
    private Campeonato campeonato;
    private String vencedorTorneioSingularEleminatorio;
    private String vencedorTorneioSingularPontos;
    private String vencedorTorneioDuplas;
    private String resultadosTorneioSingulares;
    private String resultadosTorneioDuplas;
    private String vencedorTorneioDuplasEliminatorio;
    private String vencedorTorneioDuplasPontos;

    /**
     * Construtor que inicializa a interface gráfica do sistema.
     */
    public GUI() {
        campeonato = new Campeonato();
        criarInterface();
    }

    /**
     * Cria a interface gráfica do sistema.
     */
    private void criarInterface() {
        JFrame frame = new JFrame("Campeonato de Xadrez - IPLUSO");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));

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

    /**
     * Abre a janela para registar um novo jogador.
     */
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
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(offset, string.replaceAll("[^a-zA-Z ]", ""), attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                fb.replace(offset, length, text.replaceAll("[^a-zA-Z ]", ""), attrs);
            }
        });

        ((AbstractDocument) txtIdade.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                fb.replace(offset, length, text.replaceAll("[^0-9]", ""), attrs);
            }
        });

        ((AbstractDocument) txtGenero.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                if (string.matches("[MFmf]") && fb.getDocument().getLength() + string.length() <= 1) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
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

    /**
     * Abre a janela para registar um novo árbitro.
     */
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
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(offset, string.replaceAll("[^a-zA-Z ]", ""), attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                fb.replace(offset, length, text.replaceAll("[^a-zA-Z ]", ""), attrs);
            }
        });

        ((AbstractDocument) txtIdade.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                fb.replace(offset, length, text.replaceAll("[^0-9]", ""), attrs);
            }
        });

        ((AbstractDocument) txtGenero.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                if (string.matches("[MFmf]") && fb.getDocument().getLength() + string.length() <= 1) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (text.matches("[MFmf]") && fb.getDocument().getLength() - length + text.length() <= 1) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        ((AbstractDocument) txtCertificacoes.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(offset, string.replaceAll("[^a-zA-Z ]", ""), attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
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

    /**
     * Abre a janela para gerar um novo torneio.
     */
    private void gerarTorneio() {
        JFrame frameTorneio = new JFrame("Gerar Torneio");
        frameTorneio.setSize(700, 600);
        frameTorneio.setLayout(new BorderLayout());

        JPanel panelTorneio = new JPanel();
        panelTorneio.setLayout(new GridLayout(11, 2, 10, 10));
        panelTorneio.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTipoTorneio = new JLabel("Tipo de Torneio:");
        String[] tiposTorneio = { "Singulares", "Duplas" };
        JComboBox<String> cbTipoTorneio = new JComboBox<>(tiposTorneio);

        JLabel lblGenero = new JLabel("Gênero:");
        String[] generos = { "Masculino", "Feminino" };
        JComboBox<String> cbGenero = new JComboBox<>(generos);

        JLabel lblNumEquipas = new JLabel("Número de Equipas:");
        String[] numEquipas = { "4", "8" };
        JComboBox<String> cbNumEquipas = new JComboBox<>(numEquipas);

        JLabel lblTipoCompeticao = new JLabel("Tipo de Competição:");
        String[] tiposCompeticao = { "Pontos", "Eliminatórias" };
        JComboBox<String> cbTipoCompeticao = new JComboBox<>(tiposCompeticao);

        JLabel lblJogadores = new JLabel("Jogadores Disponíveis:");
        JComboBox<String> cbJogadores = new JComboBox<>();

        // Preencher a combobox com os jogadores disponíveis
        updateJogadores(cbGenero, cbJogadores);

        ArrayList<String> jogadoresSelecionados = new ArrayList<>();
        JTextArea textAreaJogadoresSelecionados = new JTextArea();
        textAreaJogadoresSelecionados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaJogadoresSelecionados);

        JButton btnAdicionarJogador = new JButton("Adicionar");
        btnAdicionarJogador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jogadorSelecionado = (String) cbJogadores.getSelectedItem();
                int maxJogadores = Integer.parseInt((String) cbNumEquipas.getSelectedItem())
                        * (cbTipoTorneio.getSelectedItem().equals("Duplas") ? 2 : 1);
                if (!jogadoresSelecionados.contains(jogadorSelecionado)
                        && jogadoresSelecionados.size() < maxJogadores) {
                    jogadoresSelecionados.add(jogadorSelecionado);
                    textAreaJogadoresSelecionados.append(jogadorSelecionado + "\n");
                } else {
                    JOptionPane.showMessageDialog(frameTorneio, "Número máximo de jogadores atingido.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cbGenero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJogadores(cbGenero, cbJogadores);
            }
        });

        cbTipoTorneio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbTipoTorneio.getSelectedItem().equals("Duplas")) {
                    cbGenero.setEnabled(false);
                    updateJogadores(null, cbJogadores);
                } else {
                    cbGenero.setEnabled(true);
                    updateJogadores(cbGenero, cbJogadores);
                }
            }
        });

        // Adicionar JComboBox para selecionar o árbitro responsável
        JLabel lblArbitro = new JLabel("Árbitro Responsável:");
        JComboBox<String> cbArbitros = new JComboBox<>();
        for (Arbitro arbitro : Arbitro.getArbitros()) {
            cbArbitros.addItem(arbitro.getNome());
        }

        JButton btnCriar = new JButton("Criar Torneio");
        btnCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoTorneio = (String) cbTipoTorneio.getSelectedItem();
                String genero = cbGenero.isEnabled() ? (String) cbGenero.getSelectedItem() : null;
                int numEquipas = Integer.parseInt((String) cbNumEquipas.getSelectedItem());
                String tipoCompeticao = (String) cbTipoCompeticao.getSelectedItem();
                int minJogadores = numEquipas * (tipoTorneio.equals("Duplas") ? 2 : 1);
                String arbitroResponsavel = (String) cbArbitros.getSelectedItem();

                if (arbitroResponsavel == null || arbitroResponsavel.isEmpty()) {
                    JOptionPane.showMessageDialog(frameTorneio, "Por favor, selecione um árbitro responsável.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (jogadoresSelecionados.size() < minJogadores) {
                    JOptionPane.showMessageDialog(frameTorneio, "Número insuficiente de jogadores selecionados.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (tipoTorneio.equals("Singulares")) {
                    criarTorneioSingulares(genero, numEquipas, tipoCompeticao, jogadoresSelecionados,
                            arbitroResponsavel);
                } else {
                    criarTorneioDuplas(numEquipas, tipoCompeticao, jogadoresSelecionados, arbitroResponsavel);
                }

                frameTorneio.dispose();
            }
        });

        panelTorneio.add(lblTipoTorneio);
        panelTorneio.add(cbTipoTorneio);
        panelTorneio.add(lblGenero);
        panelTorneio.add(cbGenero);
        panelTorneio.add(lblNumEquipas);
        panelTorneio.add(cbNumEquipas);
        panelTorneio.add(lblTipoCompeticao);
        panelTorneio.add(cbTipoCompeticao);
        panelTorneio.add(lblJogadores);
        panelTorneio.add(cbJogadores);
        panelTorneio.add(new JLabel());
        panelTorneio.add(btnAdicionarJogador);
        panelTorneio.add(new JLabel("Jogadores Selecionados:"));
        panelTorneio.add(scrollPane);
        panelTorneio.add(lblArbitro);
        panelTorneio.add(cbArbitros);
        panelTorneio.add(new JLabel());
        panelTorneio.add(btnCriar);

        frameTorneio.add(panelTorneio, BorderLayout.CENTER);
        frameTorneio.setVisible(true);
    }

    /**
     * Atualiza a lista de jogadores disponíveis com base no gênero selecionado.
     *
     * @param cbGenero    JComboBox contendo as opções de gênero.
     * @param cbJogadores JComboBox onde os nomes dos jogadores serão adicionados.
     */
    private void updateJogadores(JComboBox<String> cbGenero, JComboBox<String> cbJogadores) {
        cbJogadores.removeAllItems();
        String generoSelecionado = cbGenero != null ? (String) cbGenero.getSelectedItem() : null;
        ArrayList<Jogador> jogadores = Jogador.getJogadores();
        for (Jogador jogador : jogadores) {
            if (generoSelecionado == null
                    || (generoSelecionado.equals("Masculino")
                            && (jogador.getGenero() == 'M' || jogador.getGenero() == 'm'))
                    || (generoSelecionado.equals("Feminino")
                            && (jogador.getGenero() == 'F' || jogador.getGenero() == 'f'))) {
                cbJogadores.addItem(jogador.getNome());
            }
        }
    }

    /**
     * Cria um torneio de singulares com base nos parâmetros fornecidos.
     *
     * @param genero                Gênero dos jogadores.
     * @param numEquipas            Número de equipas.
     * @param tipoCompeticao        Tipo de competição (Eliminatórias ou Pontos).
     * @param jogadoresSelecionados Lista de jogadores selecionados.
     * @param arbitroResponsavel    Nome do árbitro responsável.
     */
    private void criarTorneioSingulares(String genero, int numEquipas, String tipoCompeticao,
            ArrayList<String> jogadoresSelecionados, String arbitroResponsavel) {
        System.out.println("A criar um torneio de singulares " + genero + " com " + numEquipas + " equipas.");
        System.out.println("Tipo de competição: " + tipoCompeticao);
        System.out.println("Jogadores selecionados: " + jogadoresSelecionados);
        System.out.println("Árbitro responsável: " + arbitroResponsavel);

        TorneioSingulares torneioSingulares;
        if (tipoCompeticao.equals("Eliminatórias")) {
            torneioSingulares = new TorneioSingularesEleminatorio();
        } else {
            torneioSingulares = new TorneioSingularesPontos();
        }

        ArrayList<Jogador> jogadores = new ArrayList<>();
        for (String nomeJogador : jogadoresSelecionados) {
            for (Jogador jogador : Jogador.getJogadores()) {
                if (jogador.getNome().equals(nomeJogador)) {
                    jogadores.add(jogador);
                    break;
                }
            }
        }

        StringBuilder resultados = new StringBuilder();
        Jogador ultimoVencedor = null;
        // Adicionar partidas ao torneio
        if (tipoCompeticao.equals("Eliminatórias")) {
            while (jogadores.size() > 1) {
                ArrayList<Jogador> vencedoresRodada = new ArrayList<>();
                for (int i = 0; i < jogadores.size(); i += 2) {
                    if (i + 1 < jogadores.size()) {
                        PartidaSingulares partida = new PartidaSingulares(jogadores.get(i), jogadores.get(i + 1), null);
                        torneioSingulares.adicionarPartida(partida);
                        // Determinar vencedor da partida
                        Jogador vencedorPartida = partida.determinarVencedor();
                        vencedoresRodada.add(vencedorPartida);
                        ultimoVencedor = vencedorPartida;
                        resultados.append("O vencedor da Partida Singular é: ").append(vencedorPartida.getNome())
                                .append("\n");
                    }
                }
                jogadores = vencedoresRodada;
            }
            // Determinar vencedor do torneio
            if (ultimoVencedor != null) {
                vencedorTorneioSingularEleminatorio = ultimoVencedor.getNome();
                resultados.append("O vencedor do Torneio de Singulares é: ").append(ultimoVencedor.getNome())
                        .append("\n");
            }
        } else {
            for (int i = 0; i < jogadores.size(); i++) {
                for (int j = i + 1; j < jogadores.size(); j++) {
                    PartidaSingulares partida = new PartidaSingulares(jogadores.get(i), jogadores.get(j), null);
                    torneioSingulares.adicionarPartida(partida);
                    // Determinar vencedor da partida
                    Jogador vencedorPartida = partida.determinarVencedor();
                    resultados.append("O vencedor da Partida Singular é: ").append(vencedorPartida.getNome())
                            .append("\n");
                }
            }
            // Determinar vencedor do torneio
            Jogador vencedorTorneio = torneioSingulares.determinarVencedorTorneioSingulares();
            if (vencedorTorneio != null) {
                vencedorTorneioSingularPontos = vencedorTorneio.getNome();
                resultados.append("O vencedor do Torneio de Singulares é: ").append(vencedorTorneio.getNome())
                        .append("\n");
            }
        }

        campeonato.adicionarTorneioSingulares(torneioSingulares);
        resultadosTorneioSingulares = resultados.toString();
    }

    /**
     * Cria um torneio de duplas com base nos parâmetros fornecidos.
     *
     * @param numEquipas            Número de equipas.
     * @param tipoCompeticao        Tipo de competição (Eliminatórias ou Pontos).
     * @param jogadoresSelecionados Lista de jogadores selecionados.
     * @param arbitroResponsavel    Nome do árbitro responsável.
     */
    private void criarTorneioDuplas(int numEquipas, String tipoCompeticao, ArrayList<String> jogadoresSelecionados,
            String arbitroResponsavel) {
        System.out.println("A criar um torneio de duplas misto com " + numEquipas + " equipas.");
        System.out.println("Tipo de competição: " + tipoCompeticao);
        System.out.println("Jogadores selecionados: " + jogadoresSelecionados);
        System.out.println("Árbitro responsável: " + arbitroResponsavel);

        TorneioDuplas torneioDuplas;
        if (tipoCompeticao.equals("Eliminatórias")) {
            torneioDuplas = new TorneioDuplasEliminatorio(Arbitro.getArbitros());
        } else {
            torneioDuplas = new TorneioDuplasPontos();
        }

        ArrayList<Jogador> jogadores = new ArrayList<>();
        for (String nomeJogador : jogadoresSelecionados) {
            for (Jogador jogador : Jogador.getJogadores()) {
                if (jogador.getNome().equals(nomeJogador)) {
                    jogadores.add(jogador);
                    break;
                }
            }
        }

        ArrayList<Jogador[]> duplas = new ArrayList<>();
        for (int i = 0; i < jogadores.size(); i += 2) {
            if (i + 1 < jogadores.size()) {
                Jogador[] dupla = { jogadores.get(i), jogadores.get(i + 1) };
                duplas.add(dupla);
            }
        }

        if (tipoCompeticao.equals("Eliminatórias")) {
            ((TorneioDuplasEliminatorio) torneioDuplas).iniciarTorneio(duplas);
            Jogador[] vencedores = torneioDuplas.determinarVencedorTorneioDuplas();
            if (vencedores != null && vencedores.length == 2) {
                vencedorTorneioDuplasEliminatorio = vencedores[0].getNome() + " e " + vencedores[1].getNome();
            }
        } else {
            ((TorneioDuplasPontos) torneioDuplas).iniciarTorneio(duplas);
            Jogador[] vencedores = torneioDuplas.determinarVencedorTorneioDuplas();
            if (vencedores != null && vencedores.length == 2) {
                vencedorTorneioDuplasPontos = vencedores[0].getNome() + " e " + vencedores[1].getNome();
            }
        }

        campeonato.adicionarTorneioDuplas(torneioDuplas);
    }

    /**
     * Exibe a interface gráfica para visualizar o estado do campeonato.
     */
    private void visualizarCampeonato() {
        JFrame frameCampeonato = new JFrame("Visualizar Campeonato");
        frameCampeonato.setSize(800, 600);
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

        // Torneio de Singulares
        info.append("Torneio de Singulares:\n");
        if (vencedorTorneioSingularEleminatorio != null) {
            info.append("Vencedor do Torneio de Singulares (Eliminatórias): ")
                    .append(vencedorTorneioSingularEleminatorio).append("\n");
        }
        if (vencedorTorneioSingularPontos != null) {
            info.append("Vencedor do Torneio de Singulares (Pontos): ").append(vencedorTorneioSingularPontos)
                    .append("\n");
        }

        // Torneio de Duplas
        info.append("Torneio de Duplas:\n");
        if (vencedorTorneioDuplasEliminatorio != null) {
            info.append("Vencedor do Torneio de Duplas (Eliminatórias): ").append(vencedorTorneioDuplasEliminatorio)
                    .append("\n");
        }
        if (vencedorTorneioDuplasPontos != null) {
            info.append("Vencedor do Torneio de Duplas (Pontos): ").append(vencedorTorneioDuplasPontos).append("\n");
        }

        // Exibir rankings dos jogadores
        info.append("\nRankings dos Jogadores:\n");
        ArrayList<Jogador> jogadores = Jogador.getJogadores();
        for (Jogador jogador : jogadores) {
            info.append(jogador.getNome()).append(" - Ranking: ").append(jogador.getRankings())
                    .append(" - Partidas Jogadas: ").append(jogador.getPartidasJogadas()).append("\n");
        }

        // Jogadores com maior e pior ranking
        Jogador melhorMasculino = null;
        Jogador piorMasculino = null;
        Jogador melhorFeminino = null;
        Jogador piorFeminino = null;

        for (Jogador jogador : jogadores) {
            if (jogador.getGenero() == 'M' || jogador.getGenero() == 'm') {
                if (melhorMasculino == null || jogador.getRankings() > melhorMasculino.getRankings()) {
                    melhorMasculino = jogador;
                }
                if (piorMasculino == null || jogador.getRankings() < piorMasculino.getRankings()) {
                    piorMasculino = jogador;
                }
            } else if (jogador.getGenero() == 'F' || jogador.getGenero() == 'f') {
                if (melhorFeminino == null || jogador.getRankings() > melhorFeminino.getRankings()) {
                    melhorFeminino = jogador;
                }
                if (piorFeminino == null || jogador.getRankings() < piorFeminino.getRankings()) {
                    piorFeminino = jogador;
                }
            }
        }

        if (melhorMasculino != null) {
            info.append("\nMelhor Jogador Masculino: ").append(melhorMasculino.getNome()).append(" - Ranking: ")
                    .append(melhorMasculino.getRankings()).append("\n");
        }
        if (piorMasculino != null) {
            info.append("Pior Jogador Masculino: ").append(piorMasculino.getNome()).append(" - Ranking: ")
                    .append(piorMasculino.getRankings()).append("\n");
        }
        if (melhorFeminino != null) {
            info.append("Melhor Jogadora Feminina: ").append(melhorFeminino.getNome()).append(" - Ranking: ")
                    .append(melhorFeminino.getRankings()).append("\n");
        }
        if (piorFeminino != null) {
            info.append("Pior Jogadora Feminina: ").append(piorFeminino.getNome()).append(" - Ranking: ")
                    .append(piorFeminino.getRankings()).append("\n");
        }

        textArea.setText(info.toString());
        panelCampeonato.add(scrollPane, BorderLayout.CENTER);

        // Botão para exportar rankings
        JButton btnExportarRankings = new JButton("Export Rankings");
        btnExportarRankings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Campeonato.exportarRankingsParaFicheiro("rankings.txt");
            }
        });

        // Botão para atribuir prêmio
        JButton btnAtribuirPremio = new JButton("Atribuir Prémio");
        btnAtribuirPremio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atribuirPremio();
            }
        });

        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        panelBotoes.add(btnExportarRankings);
        panelBotoes.add(btnAtribuirPremio);

        panelCampeonato.add(panelBotoes, BorderLayout.SOUTH);

        frameCampeonato.add(panelCampeonato, BorderLayout.CENTER);
        frameCampeonato.setVisible(true);
    }

    /**
     * Exibe a interface gráfica para atribuir prêmios aos vencedores dos torneios.
     */
    private void atribuirPremio() {
        JFrame framePremio = new JFrame("Atribuir Prémio");
        framePremio.setSize(400, 400);
        framePremio.setLayout(new BorderLayout());

        JPanel panelPremio = new JPanel();
        panelPremio.setLayout(new GridLayout(0, 1, 10, 10));
        panelPremio.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        StringBuilder info = new StringBuilder();
        info.append("Vencedores e Prémios:\n");

        if (vencedorTorneioSingularPontos != null) {
            Premio premioSingularesPontos = new Premio("Singulares (Pontos)", 30000);
            info.append("Vencedor do Torneio de Singulares (Pontos): ").append(vencedorTorneioSingularPontos)
                    .append(" - Prémio: ").append(premioSingularesPontos.getValor()).append("\n");
        }
        if (vencedorTorneioSingularEleminatorio != null) {
            Premio premioSingularesEliminatorias = new Premio("Singulares (Eliminatórias)", 30000);
            info.append("Vencedor do Torneio de Singulares (Eliminatórias): ")
                    .append(vencedorTorneioSingularEleminatorio)
                    .append(" - Prémio: ").append(premioSingularesEliminatorias.getValor()).append("\n");
        }
        if (vencedorTorneioDuplasPontos != null) {
            Premio premioDuplasPontos = new Premio("Duplas (Pontos)", 40000);
            info.append("Vencedor do Torneio de Duplas (Pontos): ").append(vencedorTorneioDuplasPontos)
                    .append(" - Prémio: ").append(premioDuplasPontos.getValor()).append("\n");
        }
        if (vencedorTorneioDuplasEliminatorio != null) {
            Premio premioDuplasEliminatorias = new Premio("Duplas (Eliminatórias)", 40000);
            info.append("Vencedor do Torneio de Duplas (Eliminatórias): ").append(vencedorTorneioDuplasEliminatorio)
                    .append(" - Prémio: ").append(premioDuplasEliminatorias.getValor()).append("\n");
        }

        JTextArea textArea = new JTextArea(info.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        panelPremio.add(scrollPane);

        framePremio.add(panelPremio, BorderLayout.CENTER);
        framePremio.setVisible(true);
    }
}