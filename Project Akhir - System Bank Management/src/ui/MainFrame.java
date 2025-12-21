package ui;

import model.User;
import service.AccountService;
import service.CustomerService;
import table.TableCustomer;
import model.Customer;
import model.Account;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_7;
	private JTextField textField_1;
	private JTextField textField_8;
	private JTextField txtPassword;
	private JTable table_1;
	
	private JLabel lblNama;
	private JLabel lblNoRekening;
	private JLabel lblSaldo;
	private JLabel lblNoHandphone;
	private JLabel lblEmail;
	private JLabel lblTier;

	
	private User user;
	private Customer customer;
	private Account account;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame frame = new MainFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainFrame(User user) {
	    this.user = user;
	    loadDashboard();
	    CustomerService customerService = new CustomerService();
	    this.customer = customerService.getByUserId(user.getUserId());
	    loadManagementProfile();
	    		
		setTitle("Bank Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 161, 855, 405);
		contentPane.add(tabbedPane);
		
		//Panel Dashboard
		JPanel pnlDashboard = new JPanel();
		tabbedPane.addTab("Dashboard", null, pnlDashboard, null);
		pnlDashboard.setLayout(null);
		
		JLabel lblSubTitle = new JLabel("Selamat Datang Nasabah");
		lblSubTitle.setForeground(SystemColor.textHighlight);
		lblSubTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSubTitle.setBounds(10, 10, 196, 40);
		pnlDashboard.add(lblSubTitle);
		
		JPanel panelSaldo = new JPanel();
		panelSaldo.setBackground(Color.LIGHT_GRAY);
		panelSaldo.setBounds(207, 83, 447, 40);
		pnlDashboard.add(panelSaldo);
		panelSaldo.setLayout(null);
		
		JLabel lblSaldo = new JLabel("Saldo Rekening :");
		lblSaldo.setBounds(10, 0, 433, 40);
		panelSaldo.add(lblSaldo);
		lblSaldo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		lblNama = new JLabel("Nama : -");
		lblNama.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNama.setBounds(36, 133, 326, 40);
		pnlDashboard.add(lblNama);

		lblNoRekening = new JLabel("No Rekening : -");
		lblNoRekening.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNoRekening.setBounds(36, 183, 326, 40);
		pnlDashboard.add(lblNoRekening);

		lblSaldo = new JLabel("Saldo Rekening : -");
		lblSaldo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panelSaldo.add(lblSaldo);

		lblNoHandphone = new JLabel("No. Handphone : -");
		lblNoHandphone.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNoHandphone.setBounds(479, 150, 300, 40);
		pnlDashboard.add(lblNoHandphone);

		lblEmail = new JLabel("Email : -");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblEmail.setBounds(479, 200, 300, 40);
		pnlDashboard.add(lblEmail);

		lblTier = new JLabel("Tier : -");
		lblTier.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblTier.setBounds(36, 245, 300, 40);
		pnlDashboard.add(lblTier);

		
		
		//Panel Setor
		JPanel pnlSetor = new JPanel();
		tabbedPane.addTab("Setor", null, pnlSetor, null);
		pnlSetor.setLayout(null);
		
		
		//Panel Widthdraw
		JPanel pnlWithdraw = new JPanel();
		tabbedPane.addTab("Withdraw", null, pnlWithdraw, null);
		
		
		//Panel Management Profile
		JPanel pnlManagementProfile = new JPanel();
		tabbedPane.addTab("Management Profile", null, pnlManagementProfile, null);
		pnlManagementProfile.setLayout(null);
		
		JLabel lblKeamananPerbarui = new JLabel("Kelola Rekening Anda");
		lblKeamananPerbarui.setBounds(10, 10, 470, 22);
		lblKeamananPerbarui.setForeground(SystemColor.textHighlight);
		lblKeamananPerbarui.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlManagementProfile.add(lblKeamananPerbarui);
		
		JLabel lblNamaLengkap_1_2_1_3 = new JLabel("Nama :");
		lblNamaLengkap_1_2_1_3.setBounds(23, 54, 126, 40);
		lblNamaLengkap_1_2_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlManagementProfile.add(lblNamaLengkap_1_2_1_3);
		
		textField_7 = new JTextField();
		textField_7.setBounds(152, 61, 241, 33);
		textField_7.setColumns(10);
		pnlManagementProfile.add(textField_7);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(23, 303, 126, 40);
		btnUpdate.addActionListener(e -> {
		    try {
		        customer.setName(textField_7.getText());
		        customer.setPhone(textField_1.getText());
		        customer.setEmail(textField_8.getText());

		        CustomerService CustomerService = new CustomerService();
		        customerService.update(customer);

		        JOptionPane.showMessageDialog(this, "Profil berhasil diperbarui");
		        loadDashboard();

		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(this, "Gagal update profil");
		        ex.printStackTrace();
		    }
		});


		pnlManagementProfile.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(175, 303, 126, 40);
		pnlManagementProfile.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(440, 50, 400, 304);
		pnlManagementProfile.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        int row = table_1.getSelectedRow();
		        textField_7.setText(table_1.getValueAt(row, 1).toString());
		        textField_1.setText(table_1.getValueAt(row, 2).toString());
		        textField_8.setText(table_1.getValueAt(row, 3).toString());
		    }
		});

		scrollPane.setViewportView(table_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 121, 241, 33);
		textField_1.setColumns(10);
		pnlManagementProfile.add(textField_1);
		
		JLabel lblNamaLengkap_1_2_1_3_1 = new JLabel("No. Handphone :");
		lblNamaLengkap_1_2_1_3_1.setBounds(23, 114, 126, 40);
		lblNamaLengkap_1_2_1_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlManagementProfile.add(lblNamaLengkap_1_2_1_3_1);
		
		JLabel lblNamaLengkap_1_2_1_3_1_1 = new JLabel("Gmail :");
		lblNamaLengkap_1_2_1_3_1_1.setBounds(23, 175, 126, 40);
		lblNamaLengkap_1_2_1_3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlManagementProfile.add(lblNamaLengkap_1_2_1_3_1_1);
		
		textField_8 = new JTextField();
		textField_8.setBounds(152, 182, 241, 33);
		textField_8.setColumns(10);
		pnlManagementProfile.add(textField_8);
		
		JLabel lblNamaLengkap_1_2_1_3_1_1_1 = new JLabel("Password :");
		lblNamaLengkap_1_2_1_3_1_1_1.setBounds(23, 236, 126, 40);
		lblNamaLengkap_1_2_1_3_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnlManagementProfile.add(lblNamaLengkap_1_2_1_3_1_1_1);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(152, 243, 241, 33);
		txtPassword.setColumns(10);
		pnlManagementProfile.add(txtPassword);
		
		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(Color.LIGHT_GRAY);
		pnlTitle.setBounds(22, 10, 855, 104);
		contentPane.add(pnlTitle);
		pnlTitle.setLayout(null);
		
		JLabel lblTitle = new JLabel("MyBank");
		lblTitle.setBounds(298, 10, 102, 81);
		pnlTitle.add(lblTitle);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 26));
		lblTitle.setIcon(null);
	}
	
	private void loadDashboard() {
	    CustomerService customerService = new CustomerService();
	    AccountService accountService = new AccountService();

	    customer = customerService.getByUserId(user.getUserId());

	    if (customer == null) {
	        JOptionPane.showMessageDialog(this,
	            "Data customer tidak ditemukan",
	            "Error",
	            JOptionPane.ERROR_MESSAGE
	        );
	        return;
	    }

	    account = accountService.getByCustomerId(customer.getCustomerId());

	    if (account == null) {
	        JOptionPane.showMessageDialog(this,
	            "Data rekening tidak ditemukan",
	            "Error",
	            JOptionPane.ERROR_MESSAGE
	        );
	        return;
	    }

	    lblNama.setText("Nama : " + customer.getName());
	    lblNoHandphone.setText("No. Handphone : " + customer.getPhone());
	    lblEmail.setText("Email : " + customer.getEmail());
	    lblTier.setText("Tier : " + customer.getTier());

	    lblNoRekening.setText("No Rekening : " + account.getAccountNumber());
	    lblSaldo.setText("Saldo Rekening : Rp " + account.getBalance());
	}

	
	private void loadManagementProfile() {
	    if (customer == null) return;

	    textField_7.setText(customer.getName());
	    textField_1.setText(customer.getPhone());
	    textField_8.setText(customer.getEmail());
	}
	
//	private void loadCustomerTable() {
//	    CustomerService service = new CustomerService();
//	    List<Customer> list = service.getAll();
//	    table_1.setModel(new TableCustomer(list));
//	}



	
}
