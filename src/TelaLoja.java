import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelaLoja extends JPanel {
    private DefaultListModel<String> listaDeJogosModel;
    private JList<String> listaDeJogos;
    private TelaBiblioteca telaBiblioteca;

    public TelaLoja(TelaBiblioteca telaBiblioteca) {
        this.telaBiblioteca = telaBiblioteca;
        setLayout(new BorderLayout());

        // Lista de nomes de jogos fictícios
        Connection conexao = null;
		String selectGame = "SELECT idGame, nomeGame FROM games";
		//String qtdGames = "SELECT COUNT(idGame) FROM games";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost/vapor";
	        conexao = DriverManager.getConnection(url, "root", "root");
	
	        if (conexao != null) {
	        	PreparedStatement selectCon = conexao.prepareStatement(selectGame);
				//PreparedStatement selectQtd = conexao.prepareStatement(qtdGames);
				//ResultSet resultQtd = selectQtd.executeQuery();
				
				//int qtd =  resultQtd.getInt("idGame");
				//String[] jogos = new String[qtd];
				ResultSet resultCon = selectCon.executeQuery(selectGame);
				
				ArrayList<String> jogos = new ArrayList<String>();

				while (resultCon.next()) { 
				    jogos.add(resultCon.getString("nomeGame"));				    
				}
				
				/*
				int i = 0;
				while(resultCon.next()) {
					jogos[i] = resultCon.getString("nomeGame");
					i++;
				}
				*/
				
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
