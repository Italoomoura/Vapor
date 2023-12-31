import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class TelaJogoComprar extends javax.swing.JPanel {

    public TelaJogoComprar(int idGame, VaporFrame frame, JTabbedPane tabs, TelaBiblioteca biblioteca) {
    	mainPanelComprar = new javax.swing.JPanel();
    	generoLabel = new javax.swing.JLabel();
        gameNomeLabel = new javax.swing.JLabel();
        gameDistribuidoraLabel = new javax.swing.JLabel();
        gameInfoLabel = new javax.swing.JLabel();
        gamePrecoLabel = new javax.swing.JLabel();
        gameDescontoLabel = new javax.swing.JLabel();
        gameLancamentoLabel = new javax.swing.JLabel();
        gameImageLabel = new javax.swing.JLabel();
        gameDevLabel = new javax.swing.JLabel();
        buttonVoltar = new javax.swing.JButton();
        buttonComprar = new javax.swing.JButton();

        gameNomeLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        gameDistribuidoraLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        gameInfoLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        gameInfoLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        gamePrecoLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        gameDescontoLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        gameLancamentoLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        gameDevLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        
        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt, frame, tabs);
            }
        });

        buttonComprar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        buttonComprar.setText("Comprar");
        buttonComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonComprarActionPerformed(evt, biblioteca, nomeGame);
            }
        });
        
        gameImageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        generoLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        generoLabel.setText("Gênero: ");

        javax.swing.GroupLayout mainPanelComprarLayout = new javax.swing.GroupLayout(mainPanelComprar);
        mainPanelComprar.setLayout(mainPanelComprarLayout);
        mainPanelComprarLayout.setHorizontalGroup(
            mainPanelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelComprarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(mainPanelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gameImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gameLancamentoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(mainPanelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(mainPanelComprarLayout.createSequentialGroup()
                            .addGroup(mainPanelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelComprarLayout.createSequentialGroup()
                                    .addComponent(gamePrecoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(gameDescontoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(buttonComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(121, 121, 121))
                        .addComponent(gameInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gameNomeLabel)
                    .addGroup(mainPanelComprarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(mainPanelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gameDistribuidoraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gameDevLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(generoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53))
        );
        mainPanelComprarLayout.setVerticalGroup(
            mainPanelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelComprarLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(gameNomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameDevLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameDistribuidoraLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generoLabel)
                .addGap(10, 10, 10)
                .addComponent(gameInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gamePrecoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameDescontoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(buttonComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(mainPanelComprarLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(gameImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(mainPanelComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameLancamentoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanelComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanelComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        nomeGame = setComponents(idGame); 
    }    
    
	private String setComponents(int idGame) {
    	Connection conexao = null;
		String selectGames = "SELECT * FROM games WHERE idGame = ?";
	
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost/vapor";
	        conexao = DriverManager.getConnection(url, "root", "root");
	
	        if (conexao != null) {
	            System.out.println("Conexão com o SQL Server estabelecida com sucesso!");

				PreparedStatement selectCon = conexao.prepareStatement(selectGames);
				selectCon.setInt(1, idGame);
	            ResultSet resultado = selectCon.executeQuery();
	            
	            while(resultado.next()) {
	            	int isDesconto = resultado.getInt("isDesconto");
	            	DecimalFormat formatPreco = new DecimalFormat("#0.00");
	            	String preco = formatPreco.format(resultado.getDouble("preco"));
	            	
	            	gameNomeLabel.setText(resultado.getString("nomeGame"));
	            	gameDistribuidoraLabel.setText("Distribuidora: " + resultado.getString("nomeDistribuidora"));
	            	gameDevLabel.setText("Desenvolvedora: " + resultado.getString("nomeDev"));
	            	
	            	gameLancamentoLabel.setText("Data de lançamento: " + resultado.getString("lancamento"));
	            	gameInfoLabel.setText("<html>" + resultado.getString("info") + "<html>");
	            	
	            	generoLabel.setText("Gênero: " + resultado.getString("genero"));
	            	
	            	if(isDesconto == 1) {
	            		gameDescontoLabel.setText("R$"+formatPreco.format(resultado.getFloat("precoDesconto")));
	            		gameDescontoLabel.setVisible(true);
	            		gamePrecoLabel.setText("<html><s>R$" + preco + "</s></html>");
	            	}
	            	else {
	            		gamePrecoLabel.setText("R$" + preco);
	            		gameDescontoLabel.setVisible(false);
	            	}
	            	
	            	String caminhoImagem = resultado.getString("caminhoImagem");
	            	if (caminhoImagem != null && !caminhoImagem.isEmpty()) {
	            	    ImageIcon iconImg = new ImageIcon(caminhoImagem);
	            	    Image imageImg = iconImg.getImage();
	            	    Image finalImg = imageImg.getScaledInstance(240, 400, Image.SCALE_SMOOTH);
	            	    ImageIcon capa = new ImageIcon(finalImg);
	            	    gameImageLabel.setIcon(capa);
	            	    gameImageLabel.setVisible(true);
	            	} else {
	            	    gameImageLabel.setVisible(false); // Esconde a label se o caminho da imagem estiver vazio
	            	}

	            	
	            	return resultado.getString("nomeGame");
	            }
	            
	        } 
	        
	        else {
	            System.out.println("Conexão falhou");
	        } 
	    } 
	    
	    catch (ClassNotFoundException e) {
	        System.out.println("Driver JDBC não encontrado: " + e.getMessage());
	    } 
	    
	    catch (SQLException e) {
	        System.out.println("Erro ao conectar ao SQL Server: " + e.getMessage());
	    }
	    
	    finally {
	        if (conexao != null) {
	            try {
	                conexao.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		return "";
    }

    private void buttonComprarActionPerformed(java.awt.event.ActionEvent evt, TelaBiblioteca biblioteca, String nomeGame) {                                              
        biblioteca.adicionarJogo(nomeGame);
    }                                             

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt, VaporFrame frame, JTabbedPane tabs) {                                             
    	frame.setContentPane(tabs);
    	tabs.setVisible(true);
    	this.setVisible(false);
    	this.invalidate();
    	tabs.validate();
    	tabs.repaint();
    }                                            
                   
    private javax.swing.JButton buttonComprar;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JLabel gameDescontoLabel;
    private javax.swing.JLabel gameDistribuidoraLabel;
    private javax.swing.JLabel gameInfoLabel;
    private javax.swing.JLabel gameLancamentoLabel;
    private javax.swing.JLabel gameNomeLabel;
    private javax.swing.JLabel gamePrecoLabel;
    private javax.swing.JLabel gameImageLabel;
    private javax.swing.JLabel gameDevLabel;
    private javax.swing.JPanel mainPanelComprar; 
    private javax.swing.JLabel generoLabel;
    private String nomeGame;
}
