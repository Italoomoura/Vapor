import javax.swing.*;
import java.awt.*;

public class VaporFrame extends JFrame {
    private JTabbedPane tabbedPane;

    @SuppressWarnings("static-access")
	public VaporFrame(TelaLogin login) {
    	
        setTitle("Vapor");
        setPreferredSize(new Dimension(800, 570));
        setResizable(false);

        tabbedPane = new JTabbedPane();
        
        TelaBiblioteca telaBiblioteca = new TelaBiblioteca();
        TelaLoja telaLoja = new TelaLoja(this, tabbedPane, telaBiblioteca);
        @SuppressWarnings("static-access")
		TelaPerfil telaPerfil = new TelaPerfil(login.getUserName(), login.getID());
        TelaDev telaDev = new TelaDev(login.getUserName(), login.getID());

        tabbedPane.addTab("Loja", telaLoja);
        tabbedPane.addTab("Biblioteca", telaBiblioteca);
        tabbedPane.addTab("Meu perfil", telaPerfil);
        
        if(TelaLogin.getIsDev() == 1) {
        	tabbedPane.addTab("Painel Dev", telaDev);
        }

        add(tabbedPane);

        pack();
        setLocationRelativeTo(null);
    }
    
}

