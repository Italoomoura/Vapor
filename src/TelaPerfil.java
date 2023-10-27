import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

public class TelaPerfil extends javax.swing.JPanel {

    public TelaPerfil(String username, int ID) {
    	
    	buttonDev = new javax.swing.JButton();
        buttonDeleteAccount = new javax.swing.JButton();
    	userImagem = new javax.swing.JLabel();
        buttonAlterarFoto = new javax.swing.JButton();
        userNomeLabel = new javax.swing.JLabel();
        userEmailLabel = new javax.swing.JLabel();
        userIdadeLabel = new javax.swing.JLabel();
        buttonAlterarDados = new javax.swing.JButton();
        qtdJogosLabel = new javax.swing.JLabel();
        panelAlteraDados = new javax.swing.JPanel();
        userAlteraSenha = new javax.swing.JLabel();
        userAlteraNome = new javax.swing.JLabel();
        userAlteraEmail = new javax.swing.JLabel();
        userAlteraIdade = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        textFieldEmail = new javax.swing.JTextField();
        textFieldSenhaConfirmar = new javax.swing.JPasswordField();
        textFieldIdade = new javax.swing.JTextField();
        textFieldSenha = new javax.swing.JPasswordField();
        buttonSalvarDados = new javax.swing.JButton();
        radioButtonSenha = new javax.swing.JRadioButton();
        errorLabel = new javax.swing.JLabel();

        userNomeLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        userNomeLabel.setText("Nome de usuário");
        userNomeLabel.setName(""); // NOI18N

        userEmailLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        userEmailLabel.setText("Email do usuário");

        userIdadeLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        userIdadeLabel.setText("Idade: ");

        buttonAlterarDados.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonAlterarDados.setText("Alterar dados");
        buttonAlterarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarDadosActionPerformed(evt);
            }
        });

        qtdJogosLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        qtdJogosLabel.setText("Quntidade de jogos:");

        userAlteraSenha.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        userAlteraSenha.setText("Alterar senha: ");

        userAlteraNome.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        userAlteraNome.setText("Alterar nome: ");

        userAlteraEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        userAlteraEmail.setText("Alterar email: ");

        userAlteraIdade.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        userAlteraIdade.setText("Alterar idade: ");

        textFieldNome.setText("User");

        textFieldEmail.setText("Email");

        textFieldSenhaConfirmar.setText("Senha Confirmar");

        textFieldIdade.setText("Idade");

        textFieldSenha.setText("Senha");

        buttonSalvarDados.setText("Salvar dados");
        buttonSalvarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarDadosActionPerformed(evt, username, ID);
            }
        });

        radioButtonSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonSenhaActionPerformed(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 51, 51));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("Error label");

        javax.swing.GroupLayout panelAlteraDadosLayout = new javax.swing.GroupLayout(panelAlteraDados);
        panelAlteraDados.setLayout(panelAlteraDadosLayout);
        panelAlteraDadosLayout.setHorizontalGroup(
            panelAlteraDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlteraDadosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelAlteraDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userAlteraNome, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userAlteraSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldSenhaConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAlteraDadosLayout.createSequentialGroup()
                        .addComponent(textFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButtonSenha)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAlteraDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userAlteraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userAlteraIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldEmail)
                    .addComponent(textFieldIdade)
                    .addComponent(buttonSalvarDados, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlteraDadosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelAlteraDadosLayout.setVerticalGroup(
            panelAlteraDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlteraDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlteraDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userAlteraNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userAlteraEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlteraDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panelAlteraDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userAlteraSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userAlteraIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAlteraDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAlteraDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelAlteraDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlteraDadosLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(textFieldSenhaConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlteraDadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSalvarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        userImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        userImagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userImagem.setMaximumSize(new java.awt.Dimension(160, 126));
        userImagem.setMinimumSize(new java.awt.Dimension(160, 126));
        userImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userImagemMouseEntered(evt);
            }
        });

        buttonAlterarFoto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        buttonAlterarFoto.setText("Alterar foto");
        buttonAlterarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					buttonAlterarFotoActionPerformed(evt, username, ID);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        buttonDev.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        buttonDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDevActionPerformed(evt, username, ID);
            }
        });

        buttonDeleteAccount.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        buttonDeleteAccount.setText("Deletar conta");
        buttonDeleteAccount.setToolTipText("");
        buttonDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteAccountActionPerformed(evt, username, ID);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelAlteraDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 72, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAlterarFoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(qtdJogosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(90, 90, 90))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userNomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(userEmailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(userIdadeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(buttonAlterarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(buttonDeleteAccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(buttonDev, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                                        .addGap(64, 64, 64))))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userNomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAlterarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonDev))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userIdadeLabel)
                            .addComponent(buttonDeleteAccount))
                        .addGap(18, 18, 18)
                        .addComponent(qtdJogosLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAlterarFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(panelAlteraDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        
        radioButtonSenha.setSelected(true);
        buttonDev.setVisible(false);
        buttonDeleteAccount.setVisible(false);
        panelAlteraDados.setVisible(false);
        buttonAlterarFoto.setVisible(false);
        errorLabel.setVisible(false);
        sql(0, username, ID);
    }
    
    private boolean sql(int tipo, String username, int ID) {
    	Connection conexao = null;
		String selectUsers = "SELECT * FROM users WHERE nickname = ? ";
		String updateUsers = "UPDATE users SET senha = ?, nickname = ?, idade = ?, email = ? WHERE idUser = ? ";
		String selectPossui = "SELECT COUNT(idGame) AS qtd FROM possui WHERE idUser = ?";
	
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost/vapor";
	        conexao = DriverManager.getConnection(url, "root", "root");
	
	        if (conexao != null) {
	            System.out.println("Conexão com o SQL Server estabelecida com sucesso!");
	            
				if (tipo == 0) {
					PreparedStatement selectCon = conexao.prepareStatement(selectUsers);
					selectCon.setString(1, username);
		            ResultSet resultado = selectCon.executeQuery();
		            
		            PreparedStatement selectPos = conexao.prepareStatement(selectPossui);
		            selectPos.setInt(1, ID);
		            ResultSet resultadoPos = selectPos.executeQuery();
		            
		            while(resultadoPos.next()) {
		            	qtdJogosLabel.setText("Quantidade de jogos: " + resultadoPos.getInt("qtd"));
		            }
		            
		            while(resultado.next()) {
		            	userNomeLabel.setText(resultado.getString("nickname"));
		            	userEmailLabel.setText(resultado.getString("email"));
		            	userIdadeLabel.setText("Idade: " + Integer.toString(resultado.getInt("Idade")));
		            	textFieldNome.setText(resultado.getString("nickname"));
		            	textFieldEmail.setText(resultado.getString("email"));
		            	textFieldIdade.setText(Integer.toString(resultado.getInt("idade")));
		            	textFieldSenha.setText(resultado.getString("senha"));
		            	textFieldSenha.setEchoChar('*');
		            	textFieldSenhaConfirmar.setEchoChar('*');
		            	
		            	if(resultado.getInt("isDev") == 0) {
		            		stateButtonDev = false;
		            	}
		            	else {
		            		stateButtonDev = true;
		            	}
		            	buttonDev.setText((!stateButtonDev?"Ativar":"Desativar") + " modo desenvolvedor");
		            	
		            	String caminhoImagem = resultado.getString("profile_picture");
		            	if (caminhoImagem != null && !caminhoImagem.isEmpty()) {
		            	    ImageIcon iconImg = new ImageIcon(caminhoImagem);
		            	    Image imageImg = iconImg.getImage();
		            	    Image finalImg = imageImg.getScaledInstance(160, 126, Image.SCALE_SMOOTH);
		            	    ImageIcon capa = new ImageIcon(finalImg);
		            	    userImagem.setIcon(capa);
		            	    userImagem.setVisible(true);
		            	} 
		            return true;
		            }
				}
				
				if (tipo == 1) {
					String nome = textFieldNome.getText().trim();
					String select = "SELECT nickname FROM users WHERE nickname = ?";
					PreparedStatement selectCon = conexao.prepareStatement(select);
					selectCon.setString(1, nome);
					ResultSet resultado = selectCon.executeQuery();
					if(resultado.next() && !resultado.getString("nickname").equals(username)) {
						return false;
					}
					
					String nomeUser, idade, email;
					nomeUser = textFieldNome.getText().trim();
					idade = textFieldIdade.getText().trim();
					email = textFieldEmail.getText().trim();
					
					PreparedStatement updateCon = conexao.prepareStatement(updateUsers);
					String senhaText = new String(textFieldSenha.getPassword());
					updateCon.setString(1, senhaText.trim());
					updateCon.setString(2, nomeUser);
					updateCon.setInt(3, Integer.parseInt(idade));
					updateCon.setString(4, email);
					updateCon.setInt(5, ID);
		            		updateCon.executeUpdate();
		            
		            		userNomeLabel.setText(nomeUser);
	               			userIdadeLabel.setText("Idade: " + idade);
	                		userEmailLabel.setText(email);
		            		return true;
				}
				
				if (tipo == 2) {
					String updateDev = "UPDATE users SET isDev = ? WHERE idUser = ?";
					PreparedStatement updateCon = conexao.prepareStatement(updateDev);
					updateCon.setInt(2, ID);
					if(!stateButtonDev) {
						updateCon.setInt(1, 1);
					}
					else {
						updateCon.setInt(1, 0);
					}
					
					updateCon.executeUpdate();
				}
				
				if (tipo == 3) {
					String deleteUser = "DELETE FROM users WHERE idUser = ?";
					String deletePossui = "DELETE FROM possui WHERE idUser = ?";
					
					PreparedStatement deletePos = conexao.prepareStatement(deletePossui);
					deletePos.setInt(1, ID);
					deletePos.executeUpdate();
					
					PreparedStatement deleteCon = conexao.prepareStatement(deleteUser);
					deleteCon.setInt(1, ID);
					deleteCon.executeUpdate();
				}
				
				if (tipo == 4) {
					String updateImage = "UPDATE users SET profile_picture = ? WHERE idUser = ?";
					PreparedStatement updateCon = conexao.prepareStatement(updateImage);
					updateCon.setString(1, path);
					updateCon.setInt(2, ID);
					updateCon.executeUpdate();
					
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

    private void buttonAlterarFotoActionPerformed(java.awt.event.ActionEvent evt, String username, int id) throws IOException {                                         
        JFileChooser arquivo = new JFileChooser();
        arquivo.showDialog(this, "Escolha seu arquivo de imagem.");
        arquivo.setVisible(true);
        path = arquivo.getSelectedFile().toString();
        sql(4, username, id);
        ImageIcon iconImg = new ImageIcon(path);
	    Image imageImg = iconImg.getImage();
	    Image finalImg = imageImg.getScaledInstance(160, 126, Image.SCALE_SMOOTH);
	    ImageIcon capa = new ImageIcon(finalImg);
	    userImagem.setIcon(capa);
	    userImagem.setVisible(true);
	    String ext = arquivo.getSelectedFile().getAbsolutePath().toString().substring(path.lastIndexOf("."), path.length());
	    path = "C:\\Vapor\\Profile Picture\\ " + username + ext;
	    File verifyPath = new File(path);
	    if(verifyPath.exists()) {
	    	verifyPath.delete();
	    }
	    FileUtils.copyFile(arquivo.getSelectedFile(), new File(path));
    }                                        

    private void buttonAlterarDadosActionPerformed(java.awt.event.ActionEvent evt) {
    	stateButtonDados = !stateButtonDados;
        panelAlteraDados.setVisible(stateButtonDados);
        buttonDev.setVisible(stateButtonDados);
        buttonDeleteAccount.setVisible(stateButtonDados);
    }                
    
    private boolean buttonSalvarDadosActionPerformed(java.awt.event.ActionEvent evt, String username, int id) {                                                  
    	String usuarioText = textFieldNome.getText().trim();
        String emailText = textFieldEmail.getText().trim();
        String idadeText = textFieldIdade.getText().trim();
        String senhaText = new String(textFieldSenha.getPassword()).trim();
        String senhaConfirmarText = new String(textFieldSenhaConfirmar.getPassword()).trim();
        String confirmEmail = "^(.+)@(\\S+)$";
        
        if (!senhaText.equals(senhaConfirmarText)) {
        	errorLabel.setText("As senhas não coincidem.");
        	errorLabel.setVisible(true);
        	return false;
        }
    
        if(!patternMatches(emailText, confirmEmail) || emailText.isEmpty()) {
        	errorLabel.setText("Email inválido.");
        	errorLabel.setVisible(true);
        	return false;
        }
        
        if(usuarioText.length() < 5 || usuarioText.length() > 60 || usuarioText.isEmpty()) {
        	errorLabel.setText("Nome de usuário precisa de pelo menos 5 caracteres e no máximo 60.");
        	errorLabel.setVisible(true);
        	return false;
        }
        
        if(senhaText.length() < 5 || senhaText.length() > 255 || senhaText.isEmpty()) {
        	errorLabel.setText("A senha precisa de pelo menos 5 caracteres e no máximo 255.");
        	errorLabel.setVisible(true);
        	return false;
        } 
        
        if(idadeText.isEmpty() || Integer.parseInt(idadeText) < 6 || Integer.parseInt(idadeText) > 150) {
        	errorLabel.setText("Idade inválida, deixe entre 6 e 150");
        	errorLabel.setVisible(true);
        	return false;
        }
        
        int result = JOptionPane.showConfirmDialog(this, "Tem certeza que quer alterar seus dados?", TOOL_TIP_TEXT_KEY, JOptionPane.YES_NO_OPTION);
        if (result == 1) {
        	return false;
        }
        
        if(!sql(1, username, id)) {
        	errorLabel.setText("Nome de usuário já em uso.");
			errorLabel.setVisible(true);
			JOptionPane.showMessageDialog(this, "Nome de usuário já em uso. Por favor escolha outro nome.");
			return false;
        }
        
        JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!");
        errorLabel.setVisible(false);
        return true;
    }
    
    private static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
          .matcher(emailAddress)
          .matches();
    }
    
    private void radioButtonSenhaActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (radioButtonSenha.isSelected()) {
        	textFieldSenha.setEchoChar('*');
        	textFieldSenhaConfirmar.setEchoChar('*');
        }
        else {
        	textFieldSenha.setEchoChar((char)0);
        	textFieldSenhaConfirmar.setEchoChar((char)0);
        }
    } 
    
    
    private void userImagemMouseEntered(java.awt.event.MouseEvent evt) {                                        
        buttonAlterarFoto.setVisible(true);
    }  
    
    private void buttonDevActionPerformed(java.awt.event.ActionEvent evt, String username, int id) {   
    	
    	int input = JOptionPane.showConfirmDialog(this, "Tem certeza que quer " + (!stateButtonDev ? "ativar":"desativar") + " o modo desenvolvedor?", TOOL_TIP_TEXT_KEY, JOptionPane.YES_NO_OPTION);
        if(!stateButtonDev && input == 0) {
    		sql(2, username, id);
    		stateButtonDev = !stateButtonDev;
        }
        else if (stateButtonDev && input == 0) {
        	sql(2, username, id);
    		stateButtonDev = !stateButtonDev;
        }
		buttonDev.setText((!stateButtonDev ? "Ativar": "Desativar") + " modo desenvolvedor");
    }                                         

    private void buttonDeleteAccountActionPerformed(java.awt.event.ActionEvent evt, String username, int id) {                                                    
        int input = JOptionPane.showConfirmDialog(this, "Você tem certeza que deseja deletar sua conta? "
        		+ "Todos seus dados serão perdidos e não poderão ser recuperados.", TOOL_TIP_TEXT_KEY, JOptionPane.YES_NO_OPTION);
        if (input == 0) {
        	sql(3, username, id);
        	JOptionPane.showMessageDialog(this, "Sua conta foi deletada com sucesso.");
        	System.exit(0);
        }
    }  

    
    private javax.swing.JButton buttonDev;
    private javax.swing.JButton buttonDeleteAccount;
    private javax.swing.JButton buttonAlterarDados;
    private javax.swing.JButton buttonSalvarDados;
    private javax.swing.JButton buttonAlterarFoto;
    private javax.swing.JPanel panelAlteraDados;
    private javax.swing.JLabel qtdJogosLabel;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldIdade;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JPasswordField textFieldSenha;
    private javax.swing.JPasswordField textFieldSenhaConfirmar;
    private javax.swing.JLabel userAlteraEmail;
    private javax.swing.JLabel userAlteraIdade;
    private javax.swing.JLabel userAlteraNome;
    private javax.swing.JLabel userAlteraSenha;
    private javax.swing.JLabel userEmailLabel;
    private javax.swing.JLabel userIdadeLabel;
    private javax.swing.JLabel userImagem;
    private javax.swing.JLabel userNomeLabel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JRadioButton radioButtonSenha;
    private boolean stateButtonDados = false;
    private boolean stateButtonDev = false;
    private String path;
}
