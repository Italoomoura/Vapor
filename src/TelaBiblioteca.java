import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

public class TelaBiblioteca extends JPanel {
    private DefaultListModel<String> bibliotecaModel;
    private JList<String> listaBiblioteca;
    private int idUser;

    public TelaBiblioteca() {
        setLayout(new BorderLayout());

        loadGames();

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
    
    public void loadGames() {
    	bibliotecaModel = new DefaultListModel<>();
        
        Connection conexao = null;
		String selectPossui = "SELECT * FROM possui WHERE idUser = ?";
		String selectGame  = "SELECT * FROM games WHERE idGame = ?";
		String selectUser = "SELECT * FROM users WHERE nickname = ?";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost/vapor";
	        conexao = DriverManager.getConnection(url, "root", "root");
	
	        if (conexao != null) {
	        	String user = TelaLogin.getUserName();
	        	
	        	PreparedStatement selectCon = conexao.prepareStatement(selectUser);
	        	selectCon.setString(1, user);
	        	
				ResultSet resultCon = selectCon.executeQuery();
				resultCon.next();
				
				idUser = resultCon.getInt("idUser");
		
				ArrayList<String> jogos = new ArrayList<String>();
				
				PreparedStatement selectConGames = conexao.prepareStatement(selectPossui);
				selectConGames.setInt(1, idUser);
				
				ResultSet resultConGames = selectConGames.executeQuery();
				
				PreparedStatement selectConGamesNomes = conexao.prepareStatement(selectGame);
				ResultSet resultConGamesNomes;
				
				while (resultConGames.next()) { 
					selectConGamesNomes.setInt(1, resultConGames.getInt("idGame"));
					
					resultConGamesNomes = selectConGamesNomes.executeQuery();
					resultConGamesNomes.next();
					
					jogos.add(resultConGamesNomes.getString("nomeGame"));
				}
				
				String jogo;
				int tamanho = jogos.size();
				
				for (int i = 0; i < tamanho; i++) {
				    jogo = jogos.get(i);
				    
				    bibliotecaModel.addElement(jogo);
				}
				
				listaBiblioteca = new JList<>(bibliotecaModel);
				
				JScrollPane scrollPane = new JScrollPane(listaBiblioteca);
		        add(scrollPane, BorderLayout.CENTER);
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
    }

    public void adicionarJogo(String jogo) {
        Connection conexao = null;
        String insertPossui = "INSERT INTO possui(idUser, idGame, dataCompra, valorCompra) VALUES (?,?,?,?);";
        String selectGameId = "SELECT * FROM games WHERE nomeGame = ?";
        String verificaJogo = "SELECT * FROM possui WHERE idUser = ? AND idGame = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/vapor";
            conexao = DriverManager.getConnection(url, "root", "root");

            if (conexao != null) {
                System.out.println("Conexão com o SQL Server estabelecida com sucesso!");

                PreparedStatement selectConGameId = conexao.prepareStatement(selectGameId);
                selectConGameId.setString(1, jogo);
                ResultSet resultGameId = selectConGameId.executeQuery();

                if (resultGameId.next()) {
                    int idGame = resultGameId.getInt("idGame");

                    
                    PreparedStatement verificaJogoCon = conexao.prepareStatement(verificaJogo);
                    verificaJogoCon.setInt(1, idUser);
                    verificaJogoCon.setInt(2, idGame);
                    ResultSet resultVerificaJogo = verificaJogoCon.executeQuery();

                    if (resultVerificaJogo.next()) {
                        JOptionPane.showMessageDialog(this, "O jogo " + jogo + " já está na sua biblioteca!");
                    } else {
                        PreparedStatement insertCon = conexao.prepareStatement(insertPossui);
                        insertCon.setInt(1, idUser);
                        insertCon.setInt(2, idGame);
                        insertCon.setDate(3, Date.valueOf(LocalDate.now()));

                        float preco = resultGameId.getInt("preco");
                        insertCon.setFloat(4, preco);

                        insertCon.executeUpdate();
                        
                        
                        bibliotecaModel.addElement(jogo);
                        
                        
                        listaBiblioteca.revalidate();
                        
                        JOptionPane.showMessageDialog(this, "O jogo " + jogo + " foi adicionado à sua biblioteca!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "O jogo " + jogo + " não foi encontrado no banco de dados.");
                }
            } else {
                System.out.println("Falha ao conectar ao SQL Server.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao SQL Server: " + e.getMessage());

        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void removerJogoSelecionado() {
        int selectedIndex = listaBiblioteca.getSelectedIndex();

        if (selectedIndex != -1) {
            String jogoSelecionado = bibliotecaModel.getElementAt(selectedIndex);

            int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover o jogo " + jogoSelecionado + "?",
                "Confirmação de Remoção",
                JOptionPane.YES_NO_OPTION
            );

            if (resposta == JOptionPane.YES_OPTION) {
                Connection conexao = null;
                String deletePossui = "DELETE FROM possui WHERE idUser = ? AND idGame = ?";
                String selectGameId = "SELECT idGame FROM games WHERE nomeGame = ?";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost/vapor";
                    conexao = DriverManager.getConnection(url, "root", "root");

                    if (conexao != null) {
                        System.out.println("Conexão com o SQL Server estabelecida com sucesso!");

                        
                        PreparedStatement selectConGameId = conexao.prepareStatement(selectGameId);
                        selectConGameId.setString(1, jogoSelecionado);
                        ResultSet resultGameId = selectConGameId.executeQuery();

                        if (resultGameId.next()) {
                            int idGame = resultGameId.getInt("idGame");

                            
                            PreparedStatement deleteCon = conexao.prepareStatement(deletePossui);
                            deleteCon.setInt(1, idUser);
                            deleteCon.setInt(2, idGame);
                            deleteCon.executeUpdate();

                            
                            bibliotecaModel.remove(selectedIndex);

                            
                            listaBiblioteca.revalidate();

                            JOptionPane.showMessageDialog(this, "O jogo " + jogoSelecionado + " foi removido da sua biblioteca!");
                        } else {
                            JOptionPane.showMessageDialog(this, "O jogo " + jogoSelecionado + " não foi encontrado no banco de dados.");
                        }
                    } else {
                        System.out.println("Falha ao conectar ao SQL Server.");
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("Driver JDBC não encontrado: " + e.getMessage());
                } catch (SQLException e) {
                    System.out.println("Erro ao conectar ao SQL Server: " + e.getMessage());
                } finally {
                    if (conexao != null) {
                        try {
                            conexao.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


}
