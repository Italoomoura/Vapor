import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

public class TelaBiblioteca extends javax.swing.JPanel {


    public TelaBiblioteca(TelaPerfil perfil, int id) {
    	
        setPerfil(perfil);
        setId(id);
        loadGames();
    	
    	bibliotecaLabel1 = new javax.swing.JLabel();
        bibliotecaLabel2 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        gamePanel = new javax.swing.JPanel();
        gameImage = new javax.swing.JLabel();
        jogarButton = new javax.swing.JButton();
        nomeGameLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();

        bibliotecaLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bibliotecaLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bibliotecaLabel1.setText("Sua biblioteca de jogos. ");
        bibliotecaLabel1.setVerifyInputWhenFocusTarget(false);

        bibliotecaLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bibliotecaLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bibliotecaLabel2.setText("Clique em um jogo duas vezes para removê-lo.");
        bibliotecaLabel2.setVerifyInputWhenFocusTarget(false);

        scrollPane.setViewportView(listaBiblioteca);
        
        infoLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        infoLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        infoLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        infoLabel.setMaximumSize(new java.awt.Dimension(200, 245));
        infoLabel.setMinimumSize(new java.awt.Dimension(200, 245));
        infoLabel.setPreferredSize(new java.awt.Dimension(200, 245));
        infoLabel.setRequestFocusEnabled(false);
        infoLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jogarButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jogarButton.setText("Jogar");
        jogarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jogarButtonActionPerformed(evt);
            }
        });

        nomeGameLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        nomeGameLabel.setText("Título do jogo");
        
        gameImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        gamePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(gameImage, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jogarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nomeGameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(nomeGameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jogarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(gameImage, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bibliotecaLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bibliotecaLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bibliotecaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bibliotecaLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        listaBiblioteca.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    removerJogoSelecionado();
                } 
            }
        });
        
        gamePanel.setVisible(false);
        
    }    
    
    private void jogarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        abrirJogo();
    }  
    
    public void loadGames() {
        Connection conexao = null;
		String selectPossui = "SELECT * FROM possui WHERE idUser = ?";
		String selectGame  = "SELECT * FROM games WHERE idGame = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost/vapor";
	        conexao = DriverManager.getConnection(url, "root", "root");
	
	        if (conexao != null) {
				ArrayList<String> jogos = new ArrayList<String>();
				
				PreparedStatement selectConGames = conexao.prepareStatement(selectPossui);
				selectConGames.setInt(1, id);
				
				ResultSet resultConGames = selectConGames.executeQuery();
				
				PreparedStatement selectConGamesNomes = conexao.prepareStatement(selectGame);
				ResultSet resultConGamesNomes;
				int i =0;
				while (resultConGames.next()) { 
					selectConGamesNomes.setInt(1, resultConGames.getInt("idGame"));
					System.out.println(resultConGames.getInt("idGame"));
					resultConGamesNomes = selectConGamesNomes.executeQuery();
					resultConGamesNomes.next();
					System.out.println(resultConGamesNomes.getString("nomeGame"));
					jogos.add(resultConGamesNomes.getString("nomeGame"));
					bibliotecaModel.addElement(resultConGamesNomes.getString("nomeGame"));
					System.out.println("Isso:" + bibliotecaModel.getElementAt(i));
					i++;
				}
				
				
				listaBiblioteca.setModel(bibliotecaModel);
				
				scrollPane.setViewportView(listaBiblioteca);
		        
	        }
		} 
		
		catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
		
		finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        listaBiblioteca.addListSelectionListener(e -> showGameInfo());
    }
    
    public void showGameInfo() {
    	gamePanel.setVisible(true);
        int selectedIndex = listaBiblioteca.getSelectedIndex();

        if (selectedIndex != -1) {
            String jogoSelecionado = bibliotecaModel.getElementAt(selectedIndex);

            Connection conexao = null;
            String selectGameInfo = "SELECT * FROM games WHERE nomeGame = ?";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost/vapor";
                conexao = DriverManager.getConnection(url, "root", "root");

                if (conexao != null) {
                    PreparedStatement selectConGameInfo = conexao.prepareStatement(selectGameInfo);
                    selectConGameInfo.setString(1, jogoSelecionado);
                    ResultSet resultGameInfo = selectConGameInfo.executeQuery();

                    if (resultGameInfo.next()) {
                        String descricao = resultGameInfo.getString("info");
                        String nome = resultGameInfo.getString("nomeGame");
                        nomeGameLabel.setText(nome);
                        
                        String caminhoImagem = resultGameInfo.getString("caminhoImagem");
    	            	if (caminhoImagem != null && !caminhoImagem.isEmpty()) {
    	            	    ImageIcon iconImg = new ImageIcon(caminhoImagem);
    	            	    Image imageImg = iconImg.getImage();
    	            	    Image finalImg = imageImg.getScaledInstance(240, 400, Image.SCALE_SMOOTH);
    	            	    ImageIcon capa = new ImageIcon(finalImg);
    	            	    gameImage.setIcon(capa);
    	            	    gameImage.setVisible(true);
    	            	} else {
    	            	    gameImage.setVisible(false);
    	            	}
    	            	
                        infoLabel.setText("<html>" + descricao + "</html>");
                        jogarButton.setEnabled(true);
                    }
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
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

    public void abrirJogo() {
        int selectedIndex = listaBiblioteca.getSelectedIndex();

        if (selectedIndex != -1) {
            String jogoSelecionado = bibliotecaModel.getElementAt(selectedIndex);
            Connection conexao = null;
            String selectCaminhoArquivo = "SELECT download FROM games WHERE nomeGame = ?";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost/vapor";
                conexao = DriverManager.getConnection(url, "root", "root");

                if (conexao != null) {
                    PreparedStatement selectCaminhoStmt = conexao.prepareStatement(selectCaminhoArquivo);
                    selectCaminhoStmt.setString(1, jogoSelecionado);
                    ResultSet resultado = selectCaminhoStmt.executeQuery();

                    if (resultado.next()) {
                        String caminhoArquivo = resultado.getString("download");
                        try {
                            File arquivo = new File(caminhoArquivo);
                            System.out.println(caminhoArquivo);

                            if (arquivo.exists()) {
                                Desktop.getDesktop().open(arquivo);
                            } else {
                                System.out.println("O arquivo não foi encontrado.");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
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
                    verificaJogoCon.setInt(1, id);
                    verificaJogoCon.setInt(2, idGame);
                    ResultSet resultVerificaJogo = verificaJogoCon.executeQuery();

                    if (resultVerificaJogo.next()) {
                        JOptionPane.showMessageDialog(this, "O jogo " + jogo + " já está na sua biblioteca!");
                    } else {
                        PreparedStatement insertCon = conexao.prepareStatement(insertPossui);
                        insertCon.setInt(1, id);
                        insertCon.setInt(2, idGame);
                        insertCon.setDate(3, Date.valueOf(LocalDate.now()));

                        float preco = resultGameId.getInt("preco");
                        insertCon.setFloat(4, preco);

                        insertCon.executeUpdate();
                        
                        
                        bibliotecaModel.addElement(jogo);
                        
                        
                        listaBiblioteca.revalidate();
                        
                        JOptionPane.showMessageDialog(this, "O jogo " + jogo + " foi adicionado à sua biblioteca!");
                        this.perfil.loadQtdeJogos(id);
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
                            deleteCon.setInt(1, id);
                            deleteCon.setInt(2, idGame);
                            deleteCon.executeUpdate();

                            
                            bibliotecaModel.remove(selectedIndex);

                            
                            listaBiblioteca.revalidate();
                            this.perfil.loadQtdeJogos(id);
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
    
    public TelaPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(TelaPerfil perfil) {
		this.perfil = perfil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	private TelaPerfil perfil;
	private int id;
    private DefaultListModel<String> bibliotecaModel = new DefaultListModel<>();
    private javax.swing.JLabel bibliotecaLabel1;
    private javax.swing.JLabel bibliotecaLabel2;
    private javax.swing.JLabel gameImage;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JButton jogarButton;
    private javax.swing.JList<String> listaBiblioteca = new JList<>();
    private javax.swing.JLabel nomeGameLabel;
    private javax.swing.JScrollPane scrollPane = new JScrollPane();                
}
