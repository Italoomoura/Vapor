import javax.swing.*;


public class Vapor {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	TelaLogin login = new TelaLogin();
        	login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	login.setVisible(true);
        	
            //VaporFrame frame = new VaporFrame();
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.setVisible(true);
        });
    }
}
