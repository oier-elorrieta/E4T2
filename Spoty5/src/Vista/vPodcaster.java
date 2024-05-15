package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import DAO.AlbumDAO;
import DAO.ArtistaDAO;
import DAO.MusikariListaDAO;
import DAO.PodcastDAO;
import DAO.PodcasterDAO;
import DAO.PodcasterListaDAO;
import Artistak.Musikari;
import Artistak.Podcaster;
import Audioak.Album;
import Audioak.Podcast;

public class vPodcaster extends JFrame {
	private JComboBox<String> comboBoxPodcasts;
	private JTextArea textAreaInformacion;
	private JLabel lblPodcasterImg;
	private Podcaster podcaster;
	private Podcast podcast;

	public vPodcaster(String erabiltzaileIzena, Podcaster podcaster, Podcast podcast) {
		this.podcaster = podcaster;
		this.podcast = podcast;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 418);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPodcaster = new JLabel();
		lblPodcaster.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodcaster.setBounds(133, 11, 159, 14);
		contentPane.add(lblPodcaster);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtzera.setBounds(10, 7, 107, 23);
		contentPane.add(btnAtzera);

		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vPodcasterLista frame = new vPodcasterLista(erabiltzaileIzena);
				frame.setVisible(true);
				dispose();
			}
		});

		JButton btnPerfil = new JButton(erabiltzaileIzena);
		btnPerfil.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPerfil.setBounds(317, 7, 107, 23);
		contentPane.add(btnPerfil);

		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vErregistratu erregistratuFrame = new vErregistratu(erabiltzaileIzena);
				erregistratuFrame.setVisible(true);
				dispose();
			}
		});

		JLabel lblPodcasts = new JLabel("Podcasts Zerrenda");
		lblPodcasts.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodcasts.setBounds(25, 41, 98, 14);
		contentPane.add(lblPodcasts);

		JLabel lblInfo = new JLabel("Informazioa");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(291, 41, 68, 14);
		contentPane.add(lblInfo);

		comboBoxPodcasts = new JComboBox<>();
		comboBoxPodcasts.setBounds(10, 61, 128, 20);
		contentPane.add(comboBoxPodcasts);
		podcastErakutsi();

		textAreaInformacion = new JTextArea();
		textAreaInformacion.setEditable(false);
		textAreaInformacion.setLineWrap(true);
		textAreaInformacion.setWrapStyleWord(true);
		textAreaInformacion.setBounds(246, 59, 159, 130);
		contentPane.add(textAreaInformacion);
		kargatuMusikariInformazioa(textAreaInformacion);

		lblPodcasterImg = new JLabel("");
		lblPodcasterImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodcasterImg.setBounds(10, 160, 223, 186);
		contentPane.add(lblPodcasterImg);
		podcasterArgazkia(podcaster.getIrudia(), lblPodcasterImg);

		JButton btnErreproduzituPodcast = new JButton("Erreproduzitu");
		btnErreproduzituPodcast.setBounds(273, 293, 107, 23);
		contentPane.add(btnErreproduzituPodcast);
		btnErreproduzituPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				podcastIkusi();
			}
		});

	}

	private void podcastIkusi() {
		String podcasterAukeratua = comboBoxPodcasts.getSelectedItem().toString();
		PodcastDAO podcastDAO = new PodcastDAO();
		Podcast aukeratutakopodcast = podcastDAO.podcastLortu(podcasterAukeratua);
		vPodcast vPodcastFrame = new vPodcast(podcasterAukeratua, podcaster, aukeratutakopodcast);
		vPodcastFrame.setVisible(true);
		dispose();
	}

	/**
	 * Artistaren informazioa JTextArean erakusteko metodoa.
	 *
	 * @param textAreaInformazioa JTextArea elementua artistaren informazioa
	 *                            erakusteko
	 */
	private void kargatuMusikariInformazioa(JTextArea textAreaInformazioa) {

		PodcasterListaDAO podcasterDAO = new PodcasterListaDAO();
		Podcaster podcasterLortuta = podcasterDAO.podcasterLortu(podcaster.getIzena());
		String informazioa = podcasterLortuta.getDeskribapena();
		textAreaInformazioa.setText(informazioa);

	}

	/**
	 * Artistaren albumak JComboBox-en gehitu.
	 *
	 * @param comboBoxAlbumes JComboBox elementua artistaren albumak erakusteko
	 */
	private void podcastErakutsi() {
		try {
			if (podcaster != null) {
				PodcasterDAO podcasterDAO = new PodcasterDAO();

				List<Podcast> podcastak = podcasterDAO.podcastLortuPodcasterretik(podcaster);

				for (Podcast podcast : podcastak) {
					comboBoxPodcasts.addItem(podcast.getIzena());
				}
			} else {
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Erabiltzaileak hautatutako artistaren irudia erakusteko metodoa.
	 *
	 * @param lblArtistaImg JLabel elementua non artistaren irudia erakusteko
	 */

	private void podcasterArgazkia(Blob irudiaBlob, JLabel lblPodcasterImg) {
		try {
			if (irudiaBlob != null) {
				byte[] irudiaBytes = irudiaBlob.getBytes(1, (int) irudiaBlob.length()); // Irudia byte[] motan bihurtu
				if (irudiaBytes.length > 0) {
					// Irudia ImageIcon formatuan kargatu
					ImageIcon icon = new ImageIcon(irudiaBytes);
					lblPodcasterImg.setIcon(icon);
					return;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
