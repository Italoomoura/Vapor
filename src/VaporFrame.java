package tela;

import javax.swing.*;
import java.awt.*;

public class VaporFrame extends JFrame {
    private JTabbedPane tabbedPane;

    @SuppressWarnings("static-access")
	public VaporFrame(TelaLogin login) {
    	
        setTitle("Vapor");
        setPreferredSize(new Dimension(800, 570));
        setResizable(false);
        
        ImageIcon icon = new ImageIcon("C:\\Users\\gusta\\OneDrive\\Área de Trabalho\\vaporicone.jpeg");
        this.setIconImage(icon.getImage());
        
        tabbedPane = new JTabbedPane();
        
        TelaPerfil telaPerfil = new TelaPerfil(login.getUserName(), login.getID());
        TelaBiblioteca telaBiblioteca = new TelaBiblioteca(telaPerfil, login.getID());
        TelaLoja telaLoja = new TelaLoja(this, tabbedPane, telaBiblioteca);
        TelaDev telaDev = new TelaDev(login.getUserName(), login.getID(), telaLoja);

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