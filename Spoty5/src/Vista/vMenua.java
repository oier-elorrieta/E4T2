package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Bezeroak.Mota;
import DAO.ErregistratuDAO;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Erabiltzailearen menu nagusia erakutsi eta aukera ezberdinak eskaintzen dituen klasea.
 */
public class vMenua extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Aplikazioa abiarazi.
	 * @param args Komando lerroko agumentuak.
	 */
	

	/**
	 * Menua sortu.
	 * @param erabiltzaileIzena Erabiltzailearen izena.
	 */
	public vMenua(String erabiltzaileIzena) {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Menuaren goiburua
		JLabel lblNewLabel = new JLabel("Aukeratu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(170, 11, 98, 26);
		contentPane.add(lblNewLabel);
		
		// Atzera botoia
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtzera.setBounds(10, 15, 107, 23);
		contentPane.add(btnAtzera);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Saioa hasieratzeko
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
				// Profila ikusteko
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
				// Artista zerrenda ikusteko
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
		        // Podcaster zerrenda ikusteko
		        vPodcasterLista vPodcasterListaPanel = new vPodcasterLista(erabiltzaileIzena);
		        vPodcasterListaPanel.setVisible(true);
		        dispose();
		    }
		});
		
		JButton btnPlayList = new JButton("Nire PlayList-ak");
		btnPlayList.setBounds(142, 191, 160, 23);
		contentPane.add(btnPlayList);
		
		btnPlayList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Nire PlayList-ak ikusteko
				vNirePlayList vNirePlayListPanel = new vNirePlayList(erabiltzaileIzena);
				vNirePlayListPanel.setVisible(true);
				dispose();
			}
		});
	}
}