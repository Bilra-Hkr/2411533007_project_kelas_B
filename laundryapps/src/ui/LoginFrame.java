package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660,660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel judul = new JLabel("Laundry Apps");
		judul.setForeground(new Color(51, 102, 255));
		judul.setHorizontalAlignment(SwingConstants.CENTER);
		judul.setFont(new Font("Times New Roman", Font.BOLD, 24));
		judul.setBounds(162, 75, 329, 51);
		contentPane.add(judul);
		
		JLabel subjudul = new JLabel("Males aja nyuci, biar kami cuciin~\r\n");
		subjudul.setFont(new Font("Segoe UI", Font.ITALIC, 16));
		subjudul.setBounds(146, 126, 383, 22);
		contentPane.add(subjudul);
		
		JLabel input_username = new JLabel("Username");
		input_username.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		input_username.setBounds(146, 187, 86, 22);
		contentPane.add(input_username);
		
		JLabel input_password = new JLabel("Password");
		input_password.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		input_password.setBounds(146, 284, 86, 22);
		contentPane.add(input_password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(User.login(txtUsername.getText(), txtPassword.getText())) {
					new MainFrame().setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Login Gagal");
				}
			}
		});
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLogin.setBounds(230, 420, 167, 31);
		contentPane.add(btnLogin);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("Username");
		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtUsername.setBounds(146, 219, 329, 40);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setToolTipText("Password");
		txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtPassword.setColumns(10);
		txtPassword.setBounds(146, 316, 329, 40);
		contentPane.add(txtPassword);
	}
}
