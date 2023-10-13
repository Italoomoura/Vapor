import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TelaCadastro extends javax.swing.JPanel {


    public TelaCadastro(TelaLogin telaLogin, JPanel panelLogin) {
    	setVisible(false);
    	setSize(670, 300);
    	
    	cadastroPanel = new javax.swing.JPanel();
        cadastroLabel = new javax.swing.JLabel();
        fieldsPanel = new javax.swing.JPanel();
        fieldUsuario = new javax.swing.JTextField();
        fieldEmail = new javax.swing.JTextField();
        fieldSenhaConfirmar = new javax.swing.JTextField();
        fieldSenha = new javax.swing.JTextField();
        buttonConfirmarCadastro = new javax.swing.JButton();
        cadastroErrorLabel = new javax.swing.JLabel();
        buttonVoltar = new javax.swing.JButton();

        cadastroPanel.setLayout(new java.awt.BorderLayout());

        cadastroLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        cadastroLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cadastroLabel.setText("Cadastro");
        cadastroPanel.add(cadastroLabel, java.awt.BorderLayout.CENTER);

        fieldUsuario.setText("Usuário");
        fieldUsuario.addFocusListener(new FocusListener() {
        	int focusTimes = 0;

			@Override
			public void focusGained(FocusEvent e) {
				if (focusTimes == 0) {
					fieldUsuario.setText("");
					focusTimes++;
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
			
        });

        fieldEmail.setText("Email");
        fieldEmail.addFocusListener(new FocusListener() {
        	int focusTimes = 0;

			@Override
			public void focusGained(FocusEvent e) {
				if (focusTimes == 0) {
					fieldEmail.setText("");
					focusTimes++;
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
			
        });

        fieldSenhaConfirmar.setText("Confirmar senha");
        fieldSenhaConfirmar.addFocusListener(new FocusListener() {
        	int focusTimes = 0;
        	
			@Override
			public void focusGained(FocusEvent e) {
				if (focusTimes == 0) {
					fieldSenhaConfirmar.setText("");
					focusTimes++;
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
			
        });
        
        fieldSenha.setText("Senha");
        fieldSenha.addFocusListener(new FocusListener() {
        	int focusTimes = 0;
			@Override
			public void focusGained(FocusEvent e) {
				if (focusTimes == 0) {
					fieldSenha.setText("");
					focusTimes++;
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
			
        });
        
        buttonConfirmarCadastro.setFont(new java.awt.Font("Dialog", 1, 12));
        buttonConfirmarCadastro.setText("Confirmar cadastro");
        buttonConfirmarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarCadastroActionPerformed(evt, telaLogin, panelLogin);
            }
        });

        cadastroErrorLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        cadastroErrorLabel.setForeground(new java.awt.Color(255, 51, 51));
        cadastroErrorLabel.setText("Usuário existente");
        cadastroErrorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cadastroErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cadastroErrorLabel.setVisible(false);

        javax.swing.GroupLayout fieldsPanelLayout = new javax.swing.GroupLayout(fieldsPanel);
        fieldsPanel.setLayout(fieldsPanelLayout);
        fieldsPanelLayout.setHorizontalGroup(
            fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fieldsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fieldsPanelLayout.createSequentialGroup()
                        .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fieldsPanelLayout.createSequentialGroup()
                                .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(fieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(fieldsPanelLayout.createSequentialGroup()
                                .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fieldSenhaConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fieldsPanelLayout.createSequentialGroup()
                        .addGap(0, 158, Short.MAX_VALUE)
                        .addComponent(buttonConfirmarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))))
        );
        fieldsPanelLayout.setVerticalGroup(
            fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fieldsPanelLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fieldsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldSenhaConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonConfirmarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buttonVoltar.setFont(new java.awt.Font("Dialog", 1, 14));
        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt, telaLogin, panelLogin);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadastroPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cadastroErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                        .addGap(598, 598, 598))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(fieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fieldsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastroErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }                                                      

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt, TelaLogin telaLogin, JPanel loginPanel) {                                             
        telaLogin.setContentPane(loginPanel);
    	loginPanel.setVisible(true);
    	this.invalidate();
    	this.validate();
    	this.repaint();
    }                                            

    private int buttonConfirmarCadastroActionPerformed(java.awt.event.ActionEvent evt, TelaLogin telaLogin, JPanel loginPanel) {  
    	String usuarioText = fieldUsuario.getText();
        String emailText = fieldEmail.getText();
        String senhaText = fieldSenha.getText();
        String senhaConfirmarText = fieldSenhaConfirmar.getText();
        String confirmEmail = "^(.+)@(\\S+)$";
        
        String valores[] = {usuarioText, emailText, senhaText, senhaConfirmarText};
    	String valoresInvalidos[] = {"Usuário", "Senha", "Email", "Confirmar senha"};
    	
        //Tentei deixar esses cadastroErrorLabel.setText e etc em função, mas pra ficar em função precisa ficar estático, ou seja, não muda o texto quando ta dentro de função.
        
        for (int i=0; i<valores.length; i++) {
        	if(valores[i].strip().length() <= 0) {
        		cadastroErrorLabel.setText("Valor inseridos são inválidos.");
    			cadastroErrorLabel.setVisible(true);
    			return 0;
        	}
        	for(int j=0; j<valoresInvalidos.length; j++) {
        		if(valores[i].equals(valoresInvalidos[j])) {
        			cadastroErrorLabel.setText("Valor inseridos são inválidos.");
        			cadastroErrorLabel.setVisible(true);
        			return 0;
        		}
        	}
        }
        
        if (!senhaText.equals(senhaConfirmarText)) {
        	cadastroErrorLabel.setText("As senhas não coincidem.");
        	cadastroErrorLabel.setVisible(true);
        	return 0;
        }
        

    
        if(!patternMatches(emailText, confirmEmail)) {
        	cadastroErrorLabel.setText("Email inválido.");
        	cadastroErrorLabel.setVisible(true);
        	return 0;
        }
        
        if(usuarioText.length() < 5) {
        	cadastroErrorLabel.setText("Nome de usuário precisa de pelo menos 5 caracteres.");
        	cadastroErrorLabel.setVisible(true);
        	return 0;
        }
        
        if(senhaText.length() < 5) {
        	cadastroErrorLabel.setText("A senha precisa de pelo menos 5 caracteres.");
        	cadastroErrorLabel.setVisible(true);
        	return 0;
        }
        
        
        if(!sqlCadastro(usuarioText, senhaText, emailText)) {
        	cadastroErrorLabel.setText("Usuário já existe");
   		 	cadastroErrorLabel.setVisible(true);
   		 	return 0;
        }
        
        telaLogin.setContentPane(loginPanel);
    	loginPanel.setVisible(true);
    	this.invalidate();
    	this.validate();
    	this.repaint();
        //cadastroErrorLabel.setVisible(false);
        return 1;
    } 
    
    private static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
          .matcher(emailAddress)
          .matches();
    }
    
    private boolean sqlCadastro(String user, String senha, String email) {
    	 Connection conexao = null;
    	 String insertUser = "INSERT INTO users(nickname, senha, email) VALUES (?,?,?);";
    	 String selectUser = "SELECT nickname FROM users WHERE nickname = ?";

         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             String url = "jdbc:mysql://localhost/vapor";
             conexao = DriverManager.getConnection(url, "root", "root");

             if (conexao != null) {
            	 
            	 PreparedStatement st = conexao.prepareStatement(selectUser);
            	 st.setString(1, user);
            	 ResultSet resultado = st.executeQuery();
            	 if(resultado.next()) {
            		 return false;
            	 }
            	 
                 System.out.println("Conexão com o SQL Server estabelecida com sucesso!");
                 PreparedStatement insertCon = conexao.prepareStatement(insertUser);
                 insertCon.setString(1, user.trim());
                 insertCon.setString(2, senha.trim());
                 insertCon.setString(3, email.trim());
                 
                 insertCon.executeUpdate();
                 
                 JOptionPane.showMessageDialog(this, "Dados inseridos com sucesso.");
                 
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
         
         return true;
    }
             
    private javax.swing.JButton buttonConfirmarCadastro;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JLabel cadastroErrorLabel;
    private javax.swing.JLabel cadastroLabel;
    private javax.swing.JPanel cadastroPanel;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldSenha;
    private javax.swing.JTextField fieldSenhaConfirmar;
    private javax.swing.JTextField fieldUsuario;
    private javax.swing.JPanel fieldsPanel;                 
}
