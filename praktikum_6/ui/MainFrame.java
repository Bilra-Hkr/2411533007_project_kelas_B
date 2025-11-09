package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel judul = new JLabel("Laundry Apps");
		judul.setHorizontalAlignment(SwingConstants.CENTER);
		judul.setForeground(new Color(51, 102, 255));
		judul.setFont(new Font("Segoe UI", Font.BOLD, 24));
		judul.setBounds(207, 41, 329, 51);
		contentPane.add(judul);
		
		JButton btnPesanan = new JButton("PESANAN");
		btnPesanan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnPesanan.setBounds(111, 150, 154, 51);
		contentPane.add(btnPesanan);
		
		JButton btnLayanan = new JButton("LAYANAN");
		btnLayanan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLayanan.setBounds(308, 150, 154, 51);
		contentPane.add(btnLayanan);
		
		JButton btnPelanggan = new JButton("PELANGGAN");
		btnPelanggan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnPelanggan.setBounds(516, 150, 154, 51);
		contentPane.add(btnPelanggan);
		
		JButton btnPengguna = new JButton("PENGGUNA");
		btnPengguna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPengguna.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnPengguna.setBounds(111, 251, 154, 51);
		contentPane.add(btnPengguna);
		
		JButton btnLaporan = new JButton("LAPORAN");
		btnLaporan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLaporan.setBounds(308, 251, 154, 51);
		contentPane.add(btnLaporan);
		
		JButton btnProfile = new JButton("PROFILE");
		btnProfile.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnProfile.setBounds(516, 251, 154, 51);
		contentPane.add(btnProfile);
		
		JButton btnKeluar = new JButton("KELUAR");
		btnKeluar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnKeluar.setBounds(111, 351, 559, 51);
		contentPane.add(btnKeluar);
	}
}
