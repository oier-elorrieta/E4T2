package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

/**
 * Erabiltzaileak entzunaldiak kudeatzeko interfaze grafikoa eskaintzen duen klasea.
 */
public class vPodcast extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Aplikazioa abiarazi.
	 * @param args Komando lerroko agumentuak.
	 * @param erabiltzaileIzena Erabiltzailearen izena.
	 */
	public static void main(String[] args, String erabiltzaileIzena) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Podcast-ak ikusteko interfazea sortu eta bistaratu
					vPodcast frame = new vPodcast(erabiltzaileIzena);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Podcast-ak bistaratzeko interfazea sortu.
	 * @param erabiltzaileIzena Erabiltzailearen izena.
	 */
	public vPodcast(String erabiltzaileIzena) {
		setTitle("Podcaster");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Atzera botoia
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtzera.setBounds(10, 11, 101, 23);
		contentPane.add(btnAtzera);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Menu nagusira itzuli
				vMenua menuaFrame = new vMenua(erabiltzaileIzena);
				menuaFrame.setVisible(true);
				dispose();
			}
		});
		
		// Profila bistaratzeko botoia
		JButton btnProfila = new JButton(erabiltzaileIzena);
		btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProfila.setBounds(461, 11, 113, 23);
		contentPane.add(btnProfila);
		
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Profila editatzeko pantailara joan
				vErregistratu vErregistratuPanel = new vErregistratu(erabiltzaileIzena);
				vErregistratuPanel.setVisible(true);
				dispose();
			}
		});
		
		// Podcast zerrendaren izena
		JLabel lblPodcasterZerrendaIzena = new JLabel("Podcasterren zerrenda (Entzunaldi kopurua)");
		lblPodcasterZerrendaIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodcasterZerrendaIzena.setBounds(178, 15, 227, 19);
		contentPane.add(lblPodcasterZerrendaIzena);
	}
}