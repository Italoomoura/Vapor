import javax.swing.*;
import java.awt.*;

public class VaporFrame extends JFrame {
    private JTabbedPane tabbedPane;

    public VaporFrame(TelaLogin login) {
    	
        setTitle("Vapor");
        setPreferredSize(new Dimension(800, 535));
        setResizable(false);

        tabbedPane = new JTabbedPane();
        
        TelaBiblioteca telaBiblioteca = new TelaBiblioteca();
        TelaLoja telaLoja = new TelaLoja(this, tabbedPane, telaBiblioteca);
        @SuppressWarnings("static-access")
	TelaPerfil telaPerfil = new TelaPerfil(login.getUserName());

        tabbedPane.addTab("Loja", telaLoja);
        tabbedPane.addTab("Biblioteca", telaBiblioteca);
        tabbedPane.addTab("Meu perfil", telaPerfil);

        add(tabbedPane);

        pack();
        setLocationRelativeTo(null);
    }
    
}
