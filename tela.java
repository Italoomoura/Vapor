import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class tela {
	
	JFrame frame = new JFrame();
	JPanel header = new JPanel();
	JPanel body = new JPanel();
	JButton Bloja, Bbiblioteca, Bperfil;
	
	public tela() {
		frame.setVisible(true);
		frame.setSize(800,500);
		frame.setTitle("Vapor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		header();
		body();	
	}
	
	public void hButton(JButton x) {
		x.setOpaque(false);
		x.setContentAreaFilled(false);
		x.setBorderPainted(false);
		x.setFocusable(false);
		x.setFont(new Font("Arial", Font.PLAIN, 15));
		x.setForeground(Color.white);
	}
	
	public void header() {
		header.setBackground(new Color(0, 60, 0));
		header.setPreferredSize(new Dimension(100,30));
		header.setLayout(new FlowLayout(FlowLayout.LEADING,5,1));
		frame.add(header,BorderLayout.NORTH);
		
		Bloja = new JButton("Loja");
		hButton(Bloja);
		
		Bbiblioteca = new JButton("Biblioteca");
		hButton(Bbiblioteca);
		
		Bperfil = new JButton("Perfil");
		hButton(Bperfil);
		
		header.add(Bloja);
		header.add(Bbiblioteca);
		header.add(Bperfil);
	}
	
	public void body() {
		body.setBackground(new Color(0, 110, 0));
		body.setLayout(new BorderLayout());
		frame.add(body,BorderLayout.CENTER);
	}
}
