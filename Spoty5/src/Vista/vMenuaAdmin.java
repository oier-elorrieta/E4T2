package Vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class vMenuaAdmin extends JFrame {
	
	protected static final String erabiltzaileIzena = null;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vMenuaAdmin frame = new vMenuaAdmin(erabiltzaileIzena);
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
	public vMenuaAdmin(String erabiltzaileIzena) {
		setTitle("Kudeatzailea");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtzera.setBounds(10, 15, 100, 23);
		contentPane.add(btnAtzera);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vLogin loginFrame = new vLogin(erabiltzaileIzena);
				loginFrame.setVisible(true);
				dispose();
			}	
		});
		
		JLabel lblKudeaketa = new JLabel("Kudeaketa Menua");
		lblKudeaketa.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 25));
		lblKudeaketa.setBounds(104, 34, 236, 67);
		contentPane.add(lblKudeaketa);
		
		JButton btnMkudeatu = new JButton("Musika Kudeatu");
		btnMkudeatu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnMkudeatu.setBounds(114, 109, 209, 23);
		contentPane.add(btnMkudeatu);
		
		JButton btnPkudeatu = new JButton("Podcast Kudeatu");
		btnPkudeatu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnPkudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnPkudeatu.setBounds(114, 155, 209, 23);
		contentPane.add(btnPkudeatu);
		
		JButton btnEstatistikak = new JButton("Estatistikak");
		btnEstatistikak.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnEstatistikak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnEstatistikak.setBounds(114, 201, 209, 23);
		contentPane.add(btnEstatistikak);
		
		btnEstatistikak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vEstadistikaMenua estadistikaMFrame = new vEstadistikaMenua(erabiltzaileIzena);
				estadistikaMFrame.setVisible(true);
				dispose();
			}	
		});
	}
}