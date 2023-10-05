import javax.swing.*;
import java.awt.*;

public class VaporFrame extends JFrame {
    private JTabbedPane tabbedPane;

    public VaporFrame() {
        setTitle("Vapor");
        setPreferredSize(new Dimension(800, 500));

        tabbedPane = new JTabbedPane();

        TelaBiblioteca telaBiblioteca = new TelaBiblioteca();
        TelaLoja telaLoja = new TelaLoja(telaBiblioteca); // Passa a instância de TelaBiblioteca para TelaLoja

        tabbedPane.addTab("Loja", telaLoja);
        tabbedPane.addTab("Biblioteca", telaBiblioteca); // Usa a mesma instância para a tela da biblioteca

        add(tabbedPane);

        pack();
        setLocationRelativeTo(null);
    }
}
