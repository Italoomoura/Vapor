import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaLogin extends javax.swing.JFrame {
	
	private JPanel mainPanelLogin = new javax.swing.JPanel();
	TelaCadastro telaCadastro = new TelaCadastro(this, mainPanelLogin);
	private static String UserName;
	

    public TelaLogin() {
    	
    	setTitle("Vapor - Login");
    	setPreferredSize(new Dimension(670, 355));
    	setResizable(false);
    	//setLocationRelativeTo(null);
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	int x = (screenSize.width - getWidth()) / 3;
        int y = (screenSize.height - getHeight()) / 4;

        // Define a posição do JFrame
        setLocation(x, y);
    	
        cadastro_loginPanel = new javax.swing.JPanel();
        labelCadastro = new javax.swing.JLabel();
        cadastroButton = new javax.swing.JButton();
        senhaPanel = new javax.swing.JPanel();
        senhaLabel = new javax.swing.JLabel();
        senhaInput = new javax.swing.JTextField();
        userPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userInput = new javax.swing.JTextField();
        panel = new javax.swing.JPanel();
        bemVindoLabel = new javax.swing.JLabel();
        loginProcedurePanel = new javax.swing.JPanel();
        buttonEntrar = new javax.swing.JButton();
        labelError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cadastro_loginPanel.setLayout(new java.awt.GridLayout(2, 0));

        labelCadastro.setFont(new java.awt.Font("Segoe UI", 1, 12));
        labelCadastro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCadastro.setText("Ainda não é cadastrado?  Cadastre-se aqui:");
        labelCadastro.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cadastro_loginPanel.add(labelCadastro);

        cadastroButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        cadastroButton.setText("Cadastrar");
        cadastroButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cadastroButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cadastroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroButtonActionPerformed(evt);
            }
        });
        cadastro_loginPanel.add(cadastroButton);

        senhaPanel.setPreferredSize(new java.awt.Dimension(300, 67));
        senhaPanel.setLayout(new java.awt.GridLayout(2, 0));

        senhaLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        senhaLabel.setText("Senha:");
        senhaPanel.add(senhaLabel);

        senhaInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        senhaPanel.add(senhaInput);

        userPanel.setLayout(new java.awt.GridLayout(2, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel1.setText("Usuário:");
        userPanel.add(jLabel1);

        userInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        userPanel.add(userInput);

        panel.setLayout(new java.awt.BorderLayout());

        bemVindoLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bemVindoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bemVindoLabel.setText("Bem vindo ao Vapor!");
        bemVindoLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bemVindoLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panel.add(bemVindoLabel, java.awt.BorderLayout.CENTER);

        loginProcedurePanel.setLayout(new java.awt.GridLayout(1, 2));

        buttonEntrar.setText("Entrar");
        buttonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntrarActionPerformed(evt);
            }
        });
        loginProcedurePanel.add(buttonEntrar);

        labelError.setFont(new java.awt.Font("Dialog", 1, 12));
        labelError.setForeground(new java.awt.Color(255, 51, 51));
        labelError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelError.setText("Usuário ou senha incorreto.");
        labelError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelError.setVisible(false);
        loginProcedurePanel.add(labelError);

        javax.swing.GroupLayout mainPanelLoginLayout = new javax.swing.GroupLayout(mainPanelLogin);
        mainPanelLogin.setLayout(mainPanelLoginLayout);
        mainPanelLoginLayout.setHorizontalGroup(
            mainPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLoginLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(mainPanelLoginLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(mainPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(cadastro_loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(mainPanelLoginLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(loginProcedurePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLoginLayout.setVerticalGroup(
            mainPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLoginLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(mainPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLoginLayout.createSequentialGroup()
                        .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(senhaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLoginLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(cadastro_loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(loginProcedurePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanelLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        pack();
    }                                                                  

    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {
        String userText = userInput.getText();
        String senhaText = senhaInput.getText();
        if(sqlLogin(userText, senhaText)) {
        	VaporFrame vaporFrame = new VaporFrame(this);
        	this.dispose();
            vaporFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vaporFrame.setVisible(true);
        }
    }                                            

    private void cadastroButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	this.setContentPane(telaCadastro);
    	telaCadastro.setVisible(true);
    	this.invalidate();
    	this.validate();
    	this.repaint();
    }                   
    
    private boolean sqlLogin(String user, String senha) {
		Connection conexao = null;
		String selectUser = "SELECT nickname, senha FROM users WHERE nickname = ?";
	
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost/vapor";
	        conexao = DriverManager.getConnection(url, "root", "root");
	
	        if (conexao != null) {
	            System.out.println("Conexão com o SQL Server estabelecida com sucesso!");

				PreparedStatement selectCon = conexao.prepareStatement(selectUser);
				selectCon.setString(1, user);
	            
	            ResultSet resultado = selectCon.executeQuery();
	            
	            if(resultado.next() && (resultado.getString("senha")).equals(senha)) {
	            	JOptionPane.showMessageDialog(this, "Usuário logado com sucesso. Bem vindo " + user);
	            	setUserName(user);
	            }
	            else {
	            	labelError.setVisible(true);
	            	labelError.setText("Usuário ou senha incorretos.");
	            	return false;
	            }
	        } 
	        
	        else {
	            labelError.setVisible(true);
	            labelError.setText("Houve problemas com a conexão à base de dados.");
            	return false;
	        } 
	    } 
	    
	    catch (ClassNotFoundException e) {
	        System.out.println("Driver JDBC não encontrado: " + e.getMessage());
	        return false;
	    } 
	    
	    catch (SQLException e) {
	        System.out.println("Erro ao conectar ao SQL Server: " + e.getMessage());
	        return false;
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
	    
	    return true;
   }
                    
    public static String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}



	private javax.swing.JLabel bemVindoLabel;
    private javax.swing.JButton buttonEntrar;
    private javax.swing.JButton cadastroButton;
    private javax.swing.JPanel cadastro_loginPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelCadastro;
    private javax.swing.JPanel loginProcedurePanel;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField senhaInput;
    private javax.swing.JLabel senhaLabel;
    private javax.swing.JPanel senhaPanel;
    private javax.swing.JTextField userInput;
    private javax.swing.JPanel userPanel;                
}
