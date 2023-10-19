import javax.swing.*;


public class Vapor {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	VaporFrame vaporFrame = new VaporFrame();
        	TelaLogin login = new TelaLogin(vaporFrame);
        	login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	login.setVisible(true);
        });
    }
}
