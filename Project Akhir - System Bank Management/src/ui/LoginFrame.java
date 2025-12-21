package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import error.ValidationException;
import model.User;
import service.LoginService;
import util.ValidationUtil;
import java.awt.SystemColor;

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
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660,445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJudul = new JLabel("Login");
		lblJudul.setForeground(new Color(0, 0, 0));
		lblJudul.setHorizontalAlignment(SwingConstants.CENTER);
		lblJudul.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblJudul.setBounds(162, 75, 329, 51);
		contentPane.add(lblJudul);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblUsername.setBounds(146, 125, 86, 22);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPassword.setBounds(146, 207, 86, 22);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String userValue = txtUsername.getText();
			    String passValue = txtPassword.getText();
			    
			    //Membuat objek user
			    User user = new User(userValue, passValue);

			    try {
			        ValidationUtil.validate(user);
			        LoginService loginService = new LoginService();
			        if(loginService.authenticate(user)) {
			            System.out.println("Login successful!");
			            new MainFrame(user).setVisible(true);
			            dispose();
			        } else {
			            System.out.println("Invalid username or password.");
			            JOptionPane.showMessageDialog(null, "Login Gagal, Invalid username or password.");
			        }
			    } catch (ValidationException | NullPointerException exception) {
			        System.out.println("Data tidak valid : " + exception.getMessage());
			        JOptionPane.showMessageDialog(null, "Login Gagal: " + exception.getMessage());
			    } finally {
			        System.out.println("Selalu di eksekusi");
			    }
			}
		});
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLogin.setBounds(146, 297, 167, 31);
		contentPane.add(btnLogin);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("Username");
		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtUsername.setBounds(146, 157, 329, 40);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setToolTipText("Password");
		txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtPassword.setColumns(10);
		txtPassword.setBounds(146, 237, 329, 40);
		contentPane.add(txtPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(e -> {
		    new RegisterFrame().setVisible(true);
		    dispose();
		});
		btnRegister.setBackground(SystemColor.textHighlight);
		btnRegister.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnRegister.setBounds(323, 297, 151, 31);
		contentPane.add(btnRegister);
	}
}
