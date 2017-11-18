import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login {
	
	private JFrame loginFrame;
	private static final Color bkgColor = new Color(204, 255, 153);
	private static final Color textColour = new Color(255, 255, 255);
	private static JTextField userText;
	private static JButton btnStartGame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//main frame
		loginFrame = new JFrame();
		loginFrame.setTitle("Echidna Financials");
		loginFrame.getContentPane().setBackground(bkgColor);
		loginFrame.getContentPane().setLayout(null);
		
		//start game button
		btnStartGame = new JButton("Start Game");
		btnStartGame.setBounds(166, 336, 141, 35);
		
		
		//image logo
		ImageIcon echidna = new ImageIcon("echidnaLogo.png");
		Image temp = echidna.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		echidna= new ImageIcon(temp);
		JLabel imageEchidna = new JLabel(echidna);
		imageEchidna.setBounds(137, 37, 200, 190);
		
		//username entry
		userText = new JTextField(20);
		userText.setBounds(144, 267, 186, 32);
		

		loginFrame.getContentPane().add(imageEchidna);
		loginFrame.getContentPane().add(btnStartGame);
		loginFrame.getContentPane().add(userText);
		
		loginFrame.setBounds(100, 100, 500, 500);
		loginFrame.setResizable(false);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
