import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;

public class TelaDev extends javax.swing.JPanel {

    public TelaDev(String username, int id) {
    	this.username = username;
    	this.id = id;
    	
    	imagemGameLabel = new javax.swing.JLabel();
        devLabel = new javax.swing.JLabel();
        devLabelBD = new javax.swing.JLabel();
        distribuidoraLabel = new javax.swing.JLabel();
        distribuidoraField = new javax.swing.JTextField();
        precoLabel = new javax.swing.JLabel();
        precoField = new javax.swing.JTextField();
        descontoButton = new javax.swing.JRadioButton();
        descontoLabel = new javax.swing.JLabel();
        descontoField = new javax.swing.JTextField();
        arquivoLabel = new javax.swing.JLabel();
        arquivoButton = new javax.swing.JButton();
        generoLabel = new javax.swing.JLabel();
        generoBox = new javax.swing.JComboBox<>();
        nomeLabel = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        capaButton = new javax.swing.JButton();
        jogosLabel = new javax.swing.JLabel();
        lancarButton = new javax.swing.JButton();
        infoLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        infoField = new javax.swing.JTextArea();
        errorLabel = new javax.swing.JLabel();
        panelList = new javax.swing.JPanel();
        scrollPaneList = new javax.swing.JScrollPane();
        jogosList = new javax.swing.JList<>();

        imagemGameLabel.setMaximumSize(new java.awt.Dimension(240, 400));
        imagemGameLabel.setMinimumSize(new java.awt.Dimension(240, 400));
        imagemGameLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        devLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        devLabel.setText("Desenvolvedor:");

        devLabelBD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        devLabelBD.setText("Nome do dev");

        distribuidoraLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        distribuidoraLabel.setText("Distribuidora:");

        distribuidoraField.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        precoLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        precoLabel.setText("Preço:");

        precoField.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        descontoButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        descontoButton.setText("Desconto");
        descontoButton.setToolTipText("Clique aqui caso queira colocar seu jogo em desconto. Na página do jogo, o preço antigo aparecerá riscado e o preço de desconto em destaque.");
        descontoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descontoButtonActionPerformed(evt);
            }
        });

        descontoLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        descontoLabel.setText("Desconto:");

        descontoField.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        arquivoLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        arquivoLabel.setText("Arquivo:");
        arquivoLabel.setToolTipText("Arquivo do seu jogo.");

        arquivoButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        arquivoButton.setText("Importar");
        arquivoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					arquivoButtonActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        generoLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        generoLabel.setText("Gênero:");

        generoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiro", "Aventura", "Sandbox", "RPG", "MMO", "Esporte", "Corrida", "Terror", "Horror" }));

        nomeLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nomeLabel.setText("Nome do jogo:");

        nomeField.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        capaButton.setText("Capa");
        capaButton.setToolTipText("Define a imagem da capa do seu jogo.");
        capaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					capaButtonActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jogosLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jogosLabel.setText("Seus jogos: ");

        lancarButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lancarButton.setText("Lançar");
        lancarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lancarButtonActionPerformed(evt);
            }
        });

        infoLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        infoLabel.setText("Info:");

        infoLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        infoLabel.setText("Info:");

        infoField.setColumns(20);
        infoField.setRows(5);
        jScrollPane3.setViewportView(infoField);

        errorLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("errorLabel");
        errorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        scrollPaneList.setViewportView(jogosList);

        javax.swing.GroupLayout panelListLayout = new javax.swing.GroupLayout(panelList);
        panelList.setLayout(panelListLayout);
        panelListLayout.setHorizontalGroup(
            panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollPaneList, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
        );
        panelListLayout.setVerticalGroup(
            panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelListLayout.createSequentialGroup()
                    .addComponent(scrollPaneList, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jogosLabel)
                    .addComponent(imagemGameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(panelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(errorLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(devLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(distribuidoraLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(precoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(descontoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(arquivoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(generoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(devLabelBD, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(distribuidoraField)
                                    .addComponent(precoField)
                                    .addComponent(descontoField)
                                    .addComponent(arquivoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(generoBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nomeField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(descontoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                    .addComponent(capaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lancarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(errorLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(devLabelBD)
                    .addComponent(devLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lancarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(distribuidoraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(distribuidoraField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(descontoButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(precoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descontoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descontoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(generoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(generoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(arquivoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arquivoButton))))
                .addGap(18, 18, 18)
                .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagemGameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jogosLabel)
                .addGap(5, 5, 5)
                .addComponent(panelList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        
        sql(0, username, id);
        errorLabel.setVisible(false);
        descontoLabel.setVisible(false);
        descontoField.setVisible(false);
        descontoButton.setSelected(false);
        devLabelBD.setText(username);
    }   
    
    private boolean verifyFields() {
    	
    	if(nomeText.isEmpty() || nomeText.length() < 5 || nomeText.length() > 255) {
    		errorLabel.setText("O nome do jogo precisa ter entre 5 e 255 caracteres.");
    		errorLabel.setVisible(true);
    		return false;
    	}
    	
    	if(distribuidoraText.isEmpty() || distribuidoraText.length() < 5 || distribuidoraText.length() > 255) {
    		errorLabel.setText("O nome da distribuidora precisa ter entre 5 e 255 caracteres.");
    		errorLabel.setVisible(true);
    		return false;
    	}
    	
    	if(precoText.isEmpty() || Float.parseFloat(precoText) < 0) {
    		errorLabel.setText("O campo do preço precisa estar preenchido e com valor maior que 0.");
    		errorLabel.setVisible(true);
    		return false;
    	}
    	
    	if(descontoText.isEmpty() || Float.parseFloat(descontoText) < 0) {
    		descontoText = "0";
    	}
    	
    	if(infoText.length() > 1000) {
    		errorLabel.setText("Mantenha a info abaixo de 1000 caracteres");
    		errorLabel.setVisible(true);
    		return false;
    	}
    	
    	if(pathImagem == "") {
    		errorLabel.setText("Nenhuma capa foi selecionada.");
    		errorLabel.setVisible(true);
    		return false;
    	}
    	
    	if(pathArquivo == "") {
    		errorLabel.setText("Nenhum arquivo de jogo foi selecionado.");
    		errorLabel.setVisible(true);
    		return false;
    	}
    	
    	errorLabel.setVisible(false);
    	return true;
    }
    
    private boolean sql(int tipo, String username, int id) {
    	
    	Connection conexao = null;
		String insertGame = "INSERT INTO games (nomeGame, nomeDistribuidora, nomeDev, preco, precoDesconto, lancamento, isDesconto, download, info, genero, caminhoImagem) VALUES"
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String selectGame = "SELECT nomeGame FROM games WHERE nomeGame = ?";
		String selectGameUser = "SELECT nomeGame FROM games WHERE nomeDev = ?";
		
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost/vapor";
	        conexao = DriverManager.getConnection(url, "root", "root");
	
	        if (conexao != null) {
	            System.out.println("Conexão com o SQL Server estabelecida com sucesso!");
	            
	            if (tipo == 0) {
	            	PreparedStatement selectCon = conexao.prepareStatement(selectGameUser);
					selectCon.setString(1, username);
					ResultSet resultado = selectCon.executeQuery();
					
					while(resultado.next()) {
						listaDeJogos.addElement(resultado.getString("nomeGame"));
					}
										
					jogosList.setModel(listaDeJogos);
					scrollPaneList.setViewportView(jogosList);
	            }
	            
				if (tipo == 1) {
					PreparedStatement selectCon = conexao.prepareStatement(selectGame);
					selectCon.setString(1, nomeText);
					ResultSet resultado = selectCon.executeQuery();
					
					if (resultado.next()) {
						errorLabel.setText("O nome do jogo já está sendo utilizado.");
						errorLabel.setVisible(true);
						return false;
					}
					
					PreparedStatement insertCon = conexao.prepareStatement(insertGame);
					insertCon.setString(1, nomeText);
					insertCon.setString(2, distribuidoraText);
					insertCon.setString(3, username);
					insertCon.setFloat(4, Float.parseFloat(precoText));
					insertCon.setFloat(5, Float.parseFloat(descontoText));
					
					java.util.Date date = new java.util.Date();
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					insertCon.setDate(6, sqlDate);
					
					insertCon.setInt(7, descontoState?1:0);
					insertCon.setString(8, pathArquivo);
					insertCon.setString(9, infoText);
					insertCon.setString(10, generoText);
					insertCon.setString(11, pathImagem);
		            insertCon.executeUpdate();
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
	            } 
	            catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return true;
    }

    private boolean lancarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        nomeText = nomeField.getText().trim();
        distribuidoraText = distribuidoraField.getText().trim();
        precoText = precoField.getText().trim();
        descontoText = descontoField.getText().trim();
        generoText = generoBox.getSelectedItem().toString();
        infoText = infoField.getText().trim();
        
        if (!verifyFields()) {
        	return false;
        }
        
        String confirmText = "Tem certeza que quer lançar o jogo " + nomeText + "?\n"
        		+ "Confirme os dados:\n"
        		+ "Distribuidora: " + distribuidoraText + "\n"
        		+ "Preço: " + precoText + (descontoState?". Desconto " + descontoText:"") + "\n"
        		+ "Gênero: " + generoText + "\n";
        
        int input = JOptionPane.showConfirmDialog(this, confirmText, TOOL_TIP_TEXT_KEY, JOptionPane.YES_NO_OPTION);
        
        if (input != 0) {
        	return false;
        }
        
        if(sql(1, username, id)) {
        	JOptionPane.showMessageDialog(this, "Jogo " + nomeText + " lançado com sucesso.");
        }
        
        return true;
    }                                            

    private void descontoButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        descontoState = !descontoState;
        descontoLabel.setVisible(descontoState);
        descontoField.setVisible(descontoState);
    }                                              

    private boolean arquivoButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException { 
    	String nomeGame = nomeField.getText().trim();
    	if(nomeGame.isEmpty()) {
    		errorLabel.setText("É necessário colocar um nome no joga antes de mandar o arquivo.");
    		errorLabel.setVisible(true);
    		return false;
    	}
    	JFileChooser arquivo = new JFileChooser();
    	arquivo.setFileFilter(new FileNameExtensionFilter("Text File", "txt"));
    	arquivo.showDialog(this, "Escolha seu arquivo do jogo.");
        arquivo.setVisible(true);
    	FileUtils.copyFile(arquivo.getSelectedFile(), new File("C:\\Vapor\\Arquivos\\ " + nomeGame + ".txt"));
    	pathArquivo = "C:\\Vapor\\Arquivos\\" + nomeGame + ".txt";
    	arquivoButton.setText(arquivo.getSelectedFile().getName());
    	
    	errorLabel.setVisible(false);
    	return true;
    }                                             

    private boolean capaButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {  
    	String nomeGame = nomeField.getText().trim();
    	if(nomeGame.isEmpty()) {
    		errorLabel.setText("É necessário colocar um nome no joga antes de mandar a capa.");
    		errorLabel.setVisible(true);
    		return false;
    	}
    	
    	JFileChooser arquivo = new JFileChooser();
    	arquivo.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));
    	arquivo.showDialog(this, "Escolha seu arquivo de imagem.");
        arquivo.setVisible(true);
        
        String path = arquivo.getSelectedFile().getAbsoluteFile().toString();
        String ext = path.substring(path.lastIndexOf("."), path.length());
        
        FileUtils.copyFile(arquivo.getSelectedFile(), new File("C:\\Vapor\\Game Picture\\ " + nomeGame + ext));
    	pathImagem = "C:\\Vapor\\Game Picture\\ " + nomeGame + ext;
    	
    	ImageIcon iconImg = new ImageIcon(pathImagem);
	    Image imageImg = iconImg.getImage();
	    Image finalImg = imageImg.getScaledInstance(240, 400, Image.SCALE_SMOOTH);
	    ImageIcon capa = new ImageIcon(finalImg);
	    imagemGameLabel.setIcon(capa);
	    imagemGameLabel.setVisible(true);
    	
    	errorLabel.setVisible(false);
    	return true;
    }                                          

               
    private javax.swing.JButton arquivoButton;
    private javax.swing.JLabel arquivoLabel;
    private javax.swing.JButton capaButton;
    private javax.swing.JRadioButton descontoButton;
    private javax.swing.JTextField descontoField;
    private javax.swing.JLabel descontoLabel;
    private javax.swing.JLabel devLabel;
    private javax.swing.JLabel devLabelBD;
    private javax.swing.JTextField distribuidoraField;
    private javax.swing.JLabel distribuidoraLabel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JComboBox<String> generoBox;
    private javax.swing.JLabel generoLabel;
    private javax.swing.JLabel imagemGameLabel;
    private javax.swing.JTextArea infoField;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JScrollPane scrollPaneList;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jogosLabel;
    private JList<String> jogosList;
    private javax.swing.JButton lancarButton;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField precoField;
    private javax.swing.JLabel precoLabel;
    private javax.swing.JPanel panelList;
    
    private boolean descontoState = false;
    private String pathImagem = "";
    private String pathArquivo = "";
    
    private String nomeText;
    private String distribuidoraText;
    private String precoText;
    private String descontoText;
    private String generoText;
    private String infoText;
    
    private DefaultListModel<String> listaDeJogos = new DefaultListModel<>();
    
    private String username;
    private int id;
}
