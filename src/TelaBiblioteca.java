package tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaBiblioteca extends JPanel {
    private DefaultListModel<String> bibliotecaModel;
    private JList<String> listaBiblioteca;

    public TelaBiblioteca() {
        setLayout(new BorderLayout());

        bibliotecaModel = new DefaultListModel<>();
        listaBiblioteca = new JList<>(bibliotecaModel);
        JScrollPane scrollPane = new JScrollPane(listaBiblioteca);
        add(scrollPane, BorderLayout.CENTER);

        listaBiblioteca.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    removerJogoSelecionado();
                }
            }
        });

        JLabel boasVindasLabel = new JLabel("<html><center>Sua Biblioteca de Jogos<br>Clique duas vezes em um jogo para removê-lo.</center></html>");
        boasVindasLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(boasVindasLabel, BorderLayout.NORTH);
    }

    public void adicionarJogo(String jogo) {
        bibliotecaModel.addElement(jogo); // Adicione o jogo ao modelo da lista
    }

    private void removerJogoSelecionado() {
        int selectedIndex = listaBiblioteca.getSelectedIndex();
        if (selectedIndex != -1) {
            bibliotecaModel.remove(selectedIndex); // Remova o jogo do modelo da lista
        }
    }
}
