import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jogador> jogadores = new ArrayList<>();
        ArrayList<Arbitro> arbitros = new ArrayList<>();

        
        JFrame frame = new JFrame("Campeonado Xadrez- IPLUSO");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlowLayout layout = new FlowLayout();

        //Registro Jogador
        JButton Jogador = new JButton("Registar Jogador");
        Jogador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Jogador jogador = new Jogador("", 0, ' ', 0, 0);
                //System.out.println("\nRegistro do Jogador");
                //jogador.registro(scanner);
                //jogador.exibirJogador();
                //jogadores.add(jogador);
                //Criar nova janela para inserir informação
                JFrame frame = new JFrame("Registar Jogador");
                frame.setSize(300, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                FlowLayout layout = new FlowLayout();

                //Caixa de texto
                JTextField textField = new JTextField();
                textField.setEditable(true);
                textField.setPreferredSize(new Dimension(150, 20));

                frame.add(textField);

                frame.setLayout(layout);
                frame.setVisible(true);
            }
        });

        //Registro Arbitro
        JButton Arbitro = new JButton("Registar Arbitro");
        Arbitro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //
            }
        });

        // Criar Torneio
        JButton Torneio = new JButton("Criar Torneios");
        Torneio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //
            }
        });

        // Ver Campeonato 
        JButton Campeonado = new JButton("Visualizar Campeonados");
        Campeonado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //
            }
        });

        //Registro Jogador
        frame.add(Jogador);

        //Registro Arbitro
        frame.add(Arbitro);

        //Criar Torneio
        frame.add(Torneio);

        //Ver Campeonato
        frame.add(Campeonado);

        frame.setLayout(layout);
        frame.setVisible(true);
    }

}
