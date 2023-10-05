import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLoja extends JPanel {
    private DefaultListModel<String> listaDeJogosModel;
    private JList<String> listaDeJogos;
    private TelaBiblioteca telaBiblioteca;

    public TelaLoja(TelaBiblioteca telaBiblioteca) {
        this.telaBiblioteca = telaBiblioteca;
        setLayout(new BorderLayout());

        // Lista de nomes de jogos fictícios
        String[] jogos = {"Jogo 1", "Jogo 2", "Jogo 3", "Jogo 4", "Jogo 5"};

        listaDeJogosModel = new DefaultListModel<>();
        for (String jogo : jogos) {
            listaDeJogosModel.addElement(jogo);
        }

        listaDeJogos = new JList<>(listaDeJogosModel);
        JScrollPane scrollPane = new JScrollPane(listaDeJogos);
        add(scrollPane, BorderLayout.CENTER);

        listaDeJogos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    adicionarJogoSelecionado();
                }
            }
        });

        JLabel boasVindasLabel = new JLabel("<html><center>Bem-vindo à Vapor!<br>Para adicionar jogos à sua biblioteca, clique duas vezes no jogo desejado.</center></html>");
        boasVindasLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(boasVindasLabel, BorderLayout.NORTH);
    }

    private void adicionarJogoSelecionado() {
        String jogoSelecionado = listaDeJogos.getSelectedValue();
        if (jogoSelecionado != null) {
            telaBiblioteca.adicionarJogo(jogoSelecionado); // Adicione o jogo à biblioteca
            JOptionPane.showMessageDialog(null, "O jogo '" + jogoSelecionado + "' foi adicionado à sua biblioteca.");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um jogo para adicionar à biblioteca.");
        }
    }
}
