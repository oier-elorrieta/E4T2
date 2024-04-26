package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bezeroak.Mota;
import DAO.ErregistratuDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class vMenua extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErregistratuDAO erregistratuDAO = new ErregistratuDAO();
					String izena = "Hegoi";
                    String abizena = "Vazauez";
                    String id_hizkuntza = "eu";
                    String erabiltzailea = "Vhegoi";
                    String pasahitza = "12345";
                    String jaiotze_data = "2005-11-17";
                    String erregistro_data = "2024-04-26";
                    Mota mota = Mota.FREE;
					String erabiltzaileIzena = erregistratuDAO.erregistroaEgin(izena, abizena, id_hizkuntza, erabiltzailea, pasahitza, jaiotze_data, erregistro_data, mota);
					vMenua frame = new vMenua(erabiltzaileIzena);
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
	public vMenua(String erabiltzaileIzena) {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aukeratu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(170, 11, 98, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtzera.setBounds(10, 15, 107, 23);
		contentPane.add(btnAtzera);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vLogin loginFrame = new vLogin(erabiltzaileIzena);
				loginFrame.setVisible(true);
				dispose();
			}	
		});
		
		
		JButton btnProfila = new JButton(erabiltzaileIzena);
		btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProfila.setBounds(317, 15, 107, 23);
		contentPane.add(btnProfila);
		
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vErregistratu vErregistratuPanel = new vErregistratu(erabiltzaileIzena);
				vErregistratuPanel.setVisible(true);
				dispose();
			}
		});
		
		JButton btnMusikaDeskubritu = new JButton("Musika deskubritu");
		btnMusikaDeskubritu.setBounds(142, 72, 160, 23);
		contentPane.add(btnMusikaDeskubritu);
		
		btnMusikaDeskubritu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vArtistaLista vArtistaListaPanel = new vArtistaLista(erabiltzaileIzena);
				vArtistaListaPanel.setVisible(true);
				dispose();
			}
		});
		
		JButton btnPodcastDeskubritu = new JButton("Podcast deskubritu");
		btnPodcastDeskubritu.setBounds(142, 131, 160, 23);
		contentPane.add(btnPodcastDeskubritu);
		
		btnPodcastDeskubritu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vPodcast vPodcastPanel = new vPodcast(erabiltzaileIzena);
				vPodcastPanel.setVisible(true);
				dispose();
			}
		});
		
		JButton btnPlayList = new JButton("Nire PlayList-ak");
		btnPlayList.setBounds(142, 191, 160, 23);
		contentPane.add(btnPlayList);
		
		btnPlayList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vNirePlayList vNirePlayListPanel = new vNirePlayList(erabiltzaileIzena);
				
				vNirePlayListPanel.setVisible(true);
				dispose();
			}
		});
	}
}
