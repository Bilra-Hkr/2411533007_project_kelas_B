package ui;

import model.User;
import model.Customer;
import model.CustomerBuilder;
import service.RegisterService;
import error.ValidationException;
import util.ValidationUtil;
import javax.swing.JOptionPane;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNama;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtNoHandphone;
	private JTextField txtGmail;
	private JTextField txtConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Buka Rekening");
		lblTitle.setForeground(SystemColor.textHighlight);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblTitle.setBounds(293, 33, 295, 46);
		contentPane.add(lblTitle);
		
		JLabel lblSubTitle = new JLabel("Buka rekaning baru untuk membuat akun :");
		lblSubTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblSubTitle.setForeground(SystemColor.textHighlight);
		lblSubTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSubTitle.setBounds(10, 89, 318, 46);
		contentPane.add(lblSubTitle);
		
		JLabel lblNama = new JLabel("Nama Lengkap :");
		lblNama.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNama.setBounds(10, 172, 126, 40);
		contentPane.add(lblNama);
		
		txtNama = new JTextField();
		txtNama.setColumns(10);
		txtNama.setBounds(156, 179, 241, 33);
		contentPane.add(txtNama);
		
		JLabel lblUsername = new JLabel("UserName :");
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblUsername.setBounds(422, 172, 126, 40);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(568, 179, 241, 33);
		contentPane.add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(568, 229, 241, 33);
		contentPane.add(txtPassword);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPassword.setBounds(422, 222, 126, 40);
		contentPane.add(lblPassword);
		
		txtNoHandphone = new JTextField();
		txtNoHandphone.setColumns(10);
		txtNoHandphone.setBounds(157, 229, 241, 33);
		contentPane.add(txtNoHandphone);
		
		JLabel lblNoHandphone = new JLabel("No. Handphone :");
		lblNoHandphone.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNoHandphone.setBounds(11, 222, 126, 40);
		contentPane.add(lblNoHandphone);
		
		JLabel lblGmail = new JLabel("Gmail :");
		lblGmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblGmail.setBounds(10, 272, 126, 40);
		contentPane.add(lblGmail);
		
		txtGmail = new JTextField();
		txtGmail.setColumns(10);
		txtGmail.setBounds(156, 279, 241, 33);
		contentPane.add(txtGmail);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(422, 272, 141, 40);
		contentPane.add(lblConfirmPassword);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBounds(568, 279, 241, 33);
		contentPane.add(txtConfirmPassword);
		
		JComboBox pilihTier = new JComboBox();
		pilihTier.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pilihTier.setModel(new DefaultComboBoxModel(new String[] {"Pilih tier anda :", "Platinum", "Gold", "Silver"}));
		pilihTier.setBounds(10, 355, 175, 33);
		contentPane.add(pilihTier);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            String nama = txtNama.getText();
		            String username = txtUsername.getText();
		            String password = txtPassword.getText();
		            String confirmPassword = txtConfirmPassword.getText();
		            String phone = txtNoHandphone.getText();
		            String email = txtGmail.getText();
		            String tier = pilihTier.getSelectedItem().toString();

		            // validasi password
		            if (!password.equals(confirmPassword)) {
		                throw new ValidationException("Password dan Confirm Password tidak sama");
		            }

		            // Membuat objek user
		            User user = new User(username, password);

		            // objek customer (builder)
		            Customer customer = new CustomerBuilder()
		                    .setName(nama)
		                    .setPhone(phone)
		                    .setEmail(email)
		                    .setTier(tier)
		                    .build();

		            // validasi
		            ValidationUtil.validate(user);
		            ValidationUtil.validate(customer);

		            // service
		            RegisterService service = new RegisterService();
		            service.register(user, customer);

		            JOptionPane.showMessageDialog(null, "Registrasi berhasil!");
		            new LoginFrame().setVisible(true);
		            dispose();

		        } catch (ValidationException ex) {
		            JOptionPane.showMessageDialog(null, ex.getMessage());
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Registrasi gagal");
		        }
		    }
		});

		btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnSave.setBackground(new Color(60, 179, 113));
		btnSave.setBounds(363, 397, 126, 40);
		contentPane.add(btnSave);
	}
}
