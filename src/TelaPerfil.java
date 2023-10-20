import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaPerfil extends javax.swing.JPanel {

    public TelaPerfil(String username) {
    	
    	userImagem = new javax.swing.JPanel();
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
        textFieldSenhaConfirmar = new javax.swing.JTextField();
        textFieldIdade = new javax.swing.JTextField();
        textFieldSenha = new javax.swing.JTextField();
        buttonSalvarDados = new javax.swing.JButton();
        radioButtonSenha = new javax.swing.JRadioButton();
        errorLabel = new javax.swing.JLabel();

        buttonAlterarFoto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        buttonAlterarFoto.setText("Mudar foto");
        buttonAlterarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userImagemLayout = new javax.swing.GroupLayout(userImagem);
        userImagem.setLayout(userImagemLayout);
        userImagemLayout.setHorizontalGroup(
            userImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userImagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAlterarFoto)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        userImagemLayout.setVerticalGroup(
            userImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userImagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAlterarFoto)
                .addContainerGap(120, Short.MAX_VALUE))
        );

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
        textFieldSenhaConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSenhaConfirmarActionPerformed(evt);
            }
        });

        textFieldIdade.setText("Idade");

        textFieldSenha.setText("Senha");
        textFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSenhaActionPerformed(evt);
            }
        });

        buttonSalvarDados.setText("Salvar dados");
        buttonSalvarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarDadosActionPerformed(evt);
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
                .addGroup(panelAlteraDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioButtonSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelAlteraDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAlteraDadosLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(textFieldSenhaConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlteraDadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSalvarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panelAlteraDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userEmailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userIdadeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(qtdJogosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(userNomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonAlterarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(90, 90, 90))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userNomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAlterarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userIdadeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(qtdJogosLabel))
                    .addComponent(userImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAlteraDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        
        panelAlteraDados.setVisible(false);
        buttonAlterarFoto.setVisible(false);
        errorLabel.setVisible(false);
        sql(0, username);
    }
    
    private void sql(int tipo, String username) {
    	Connection conexao = null;
		String selectUsers = "SELECT * FROM users WHERE nickname = ? ";
		//String updateUsers = "UPDATE users SET senha = ?, nickname = ?, idade = ?, email = ?, profile_picture = ?, isDev = ? WHERE ";
	
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost/vapor";
	        conexao = DriverManager.getConnection(url, "root", "root");
	
	        if (conexao != null) {
	            System.out.println("Conexão com o SQL Server estabelecida com sucesso!");
	            
				PreparedStatement selectCon = conexao.prepareStatement(selectUsers);
				selectCon.setString(1, username);
	            ResultSet resultado = selectCon.executeQuery();
	            
	            while(resultado.next()) {
	            	userNomeLabel.setText(resultado.getString("nickname"));
	            	userEmailLabel.setText(resultado.getString("email"));
	            	userIdadeLabel.setText("Idade: " + Integer.toString(resultado.getInt("Idade")));
	            }
	            
	            if (tipo == 1) {
	            	//todo
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
    }                                             

    private void textFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void textFieldSenhaConfirmarActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                                                                    

    private void buttonAlterarFotoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void buttonAlterarDadosActionPerformed(java.awt.event.ActionEvent evt) {
    	stateButtonDados = !stateButtonDados;
        panelAlteraDados.setVisible(stateButtonDados);
    }                
    
    private void buttonSalvarDadosActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }
    
    private void radioButtonSenhaActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    } 

                   
    private javax.swing.JButton buttonAlterarDados;
    private javax.swing.JButton buttonSalvarDados;
    private javax.swing.JButton buttonAlterarFoto;
    private javax.swing.JPanel panelAlteraDados;
    private javax.swing.JLabel qtdJogosLabel;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldIdade;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldSenha;
    private javax.swing.JTextField textFieldSenhaConfirmar;
    private javax.swing.JLabel userAlteraEmail;
    private javax.swing.JLabel userAlteraIdade;
    private javax.swing.JLabel userAlteraNome;
    private javax.swing.JLabel userAlteraSenha;
    private javax.swing.JLabel userEmailLabel;
    private javax.swing.JLabel userIdadeLabel;
    private javax.swing.JPanel userImagem;
    private javax.swing.JLabel userNomeLabel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JRadioButton radioButtonSenha;
	private boolean stateButtonDados = false;
}
