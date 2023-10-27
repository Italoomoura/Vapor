import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TelaLoja extends JPanel {
    private DefaultListModel<String> listaDeJogosModel = new DefaultListModel<String>();;
    private JList<String> listaDeJogos = new JList<>();
    JScrollPane scrollPane = new JScrollPane();
    private Map<String, String> jogoId = new HashMap<String, String>();

    public TelaLoja(VaporFrame frame, JTabbedPane tabs, TelaBiblioteca biblioteca) {
        setLayout(new BorderLayout());

        Connection conexao = null;
		String selectGame = "SELECT * FROM games";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost/vapor";
	        conexao = DriverManager.getConnection(url, "root", "root");
	
	        if (conexao != null) {
	        	PreparedStatement selectCon = conexao.prepareStatement(selectGame);
				ResultSet resultCon = selectCon.executeQuery(selectGame);
				
				while (resultCon.next()) { 
					listaDeJogosModel.addElement(resultCon.getString("nomeGame"));
				    jogoId.put(resultCon.getString("nomeGame"), Integer.toString(resultCon.getInt("idGame")));
				}
		        
				listaDeJogos.setModel(listaDeJogosModel);
				scrollPane.setViewportView(listaDeJogos);
				scrollPane.invalidate();
				scrollPane.revalidate();
				scrollPane.repaint();
				
		        add(scrollPane, BorderLayout.CENTER);

		        listaDeJogos.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                if (e.getClickCount() == 2) {
		                    adicionarJogoSelecionado(frame, tabs, biblioteca);
		                }
		            }
		        });
	        }
		}
		catch(SQLException e) {
			System.out.println("Erro ao conectar ao SQL Server: " + e.getMessage());
	        return;
		}
		catch (ClassNotFoundException e) {
	        System.out.println("Driver JDBC não encontrado: " + e.getMessage());
	        return;
	    } 
		
		String nome = TelaLogin.getUserName();
		System.out.println(nome);

        JLabel boasVindasLabel = new JLabel("<html><center>Bem-vindo à Vapor!<br>Para adicionar jogos à sua biblioteca, clique duas vezes no jogo desejado.</center></html>");
        boasVindasLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(boasVindasLabel, BorderLayout.NORTH);
    }
    
    void atualizarListaDeJogos() {
        listaDeJogosModel.clear(); 

        Connection conexao = null;
        String selectGame = "SELECT * FROM games";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/vapor";
            conexao = DriverManager.getConnection(url, "root", "root");

            if (conexao != null) {
                PreparedStatement selectCon = conexao.prepareStatement(selectGame);
                ResultSet resultCon = selectCon.executeQuery(selectGame);

                ArrayList<String> jogos = new ArrayList<String>();

                while (resultCon.next()) {
                    jogos.add(resultCon.getString("nomeGame"));
                    jogoId.put(resultCon.getString("nomeGame"), Integer.toString(resultCon.getInt("idGame")));
                }

                for (String jogo : jogos) {
                    listaDeJogosModel.addElement(jogo);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao SQL Server: " + e.getMessage());
            return;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
            return;
        }
    }

    private void adicionarJogoSelecionado(VaporFrame frame, JTabbedPane tabs, TelaBiblioteca biblioteca) {
        String jogoSelecionado = listaDeJogos.getSelectedValue();
        if (jogoSelecionado != null) {
        	TelaJogoComprar telaComprar = new TelaJogoComprar(Integer.parseInt(jogoId.get(jogoSelecionado)), frame, tabs, biblioteca);
        	frame.setContentPane(telaComprar);
        	telaComprar.setVisible(true);
        	tabs.setVisible(false);
        	frame.invalidate();
        	frame.validate();
        	frame.repaint();
        	
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um jogo para adicionar à biblioteca.");
        }
    }
}
