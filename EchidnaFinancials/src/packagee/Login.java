package packagee;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private static String username = "";
	
	private Image echidna;
	private JLabel lblUsername;
	
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
		btnStartGame.setBounds(178, 348, 141, 35);
		
		
		//image logo
		ImageIcon echidna = new ImageIcon("echidnaLogo.png");
		Image temp = echidna.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		echidna= new ImageIcon(temp);
		JLabel imageEchidna = new JLabel(echidna);
		imageEchidna.setBounds(147, 37, 200, 190);
		
		//username entry
		userText = new JTextField(20);
		userText.setBounds(154, 283, 186, 32);
		

		loginFrame.getContentPane().add(imageEchidna);
		loginFrame.getContentPane().add(btnStartGame);
		loginFrame.getContentPane().add(userText);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(128, 247, 141, 26);
		loginFrame.getContentPane().add(lblUsername);
		
		loginFrame.setBounds(100, 100, 500, 500);
		loginFrame.setResizable(false);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnStartGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
				username = userText.getText();
				close();
            }
		});
	}
	
	public void close() {
		loginFrame.dispose();
	}
}
