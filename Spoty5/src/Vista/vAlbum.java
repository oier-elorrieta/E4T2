package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import DAO.AlbumDAO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;

/**
 * {@code vAlbum} klaseak JFrame-aren birtuala da eta musika albumen informazioa erakusteko erabiltzen da.
 * Klase honek musika albumaren argazkia, abestiak, eta informazioa erakusten ditu.
 */
public class vAlbum extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String albumIzena;

	/**
	 * {@code vAlbum} klasearen eraikitzailea. Eraikitzaile honek albumaren izena ematen du 
	 * eta albumaren leihoa hasieratzen du.
	 *
	 * @param artistaIzena        Albumaren artista izena
	 * @param erabiltzaileIzena   Erabiltzailearen izena
	 * @param albumIzena          Albumaren izena
	 * @param artistaDeskribapena Albumaren artistaaren deskribapena
	 * @param artistaIrudia       Albumaren artistaaren irudia
	 */
	public vAlbum(String artistaIzena, String erabiltzaileIzena, String albumIzena, String artistaDeskribapena,
			ImageIcon artistaIrudia) {
		this.albumIzena = albumIzena;
		setTitle("Albuma: " + albumIzena);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAtzera.setBounds(10, 10, 85, 21);
		contentPane.add(btnAtzera);

		

		JLabel lblAlbum = new JLabel("Albuma: " + albumIzena);
		lblAlbum.setBounds(172, 14, 182, 13);
		contentPane.add(lblAlbum);

		JLabel lblAbestiZerrenda = new JLabel("Abesti Zerrenda: ");
		lblAbestiZerrenda.setBounds(10, 60, 100, 13);
		contentPane.add(lblAbestiZerrenda);

		JLabel lblAlbumarenInformazioa = new JLabel("Albumaren informazioa");
		lblAlbumarenInformazioa.setBounds(444, 60, 176, 13);
		contentPane.add(lblAlbumarenInformazioa);

		JComboBox comboBoxAbestiAukeratu = new JComboBox();
		comboBoxAbestiAukeratu.setBounds(10, 84, 137, 21);
		contentPane.add(comboBoxAbestiAukeratu);

		JLabel lblAlbumArgazkia = new JLabel("");
		lblAlbumArgazkia.setBounds(10, 146, 261, 200);
		contentPane.add(lblAlbumArgazkia);

		AlbumIrudiaErakutsi(lblAlbumArgazkia);

		JButton btnAbestiAukera = new JButton("Aukeratu");

		btnAbestiAukera.setBounds(170, 83, 89, 23);
		contentPane.add(btnAbestiAukera);
		btnAbestiAukera.setBounds(170, 83, 89, 23);
		contentPane.add(btnAbestiAukera);
		btnAbestiAukera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String audioIzena = (String) comboBoxAbestiAukeratu.getSelectedItem();
				vErreprodukzio vErreprodukzioFrame = new vErreprodukzio(artistaIzena, erabiltzaileIzena, albumIzena,
						artistaDeskribapena, artistaIrudia, audioIzena);
				vErreprodukzioFrame.setVisible(true);
				dispose();
			}
		});

		JTextArea textAreaAlbumInf = new JTextArea();
		textAreaAlbumInf.setEditable(false);
		textAreaAlbumInf.setLineWrap(true);
		textAreaAlbumInf.setWrapStyleWord(true);
		textAreaAlbumInf.setBounds(411, 102, 189, 87);
		contentPane.add(textAreaAlbumInf);

		AlbumInformazioaErakutsi(textAreaAlbumInf);

		btnAbestiAukera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vErreprodukzio vErreprodukzioFrame = new vErreprodukzio(artistaIzena, erabiltzaileIzena, albumIzena,
						artistaDeskribapena, artistaIrudia, artistaDeskribapena);
				vErreprodukzioFrame.setVisible(true);
				dispose();
			}
		});

		AlbumDAO albumDAO = new AlbumDAO();
		try {
			List<String> abestiak = albumDAO.albumAbestiakHartu(albumIzena);
			for (String abestia : abestiak) {
				comboBoxAbestiAukeratu.addItem(abestia);
			}

			// Aukeratutako albumaren irudia hartu
			if (!abestiak.isEmpty()) {
				String lehenAbestiIzena = abestiak.get(0); // Lehengo abestiaren izena lortu
				ImageIcon albumArgazkia = albumDAO.AlbumIrudiaLortu(lehenAbestiIzena); // Abestiaren irudia lortu
				lblAlbumArgazkia.setIcon(albumArgazkia); // Irudia JLabel-en ezarri
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Albumaren irudia erakutsi.
	 *
	 * @param lblAlbumArgazkia Albumaren irudia erakutsiko den JLabel-a
	 */
	private void AlbumIrudiaErakutsi(JLabel lblAlbumArgazkia) {
		try {
			AlbumDAO albumDAO = new AlbumDAO();
			ImageIcon albumArgazkia = albumDAO.AlbumIrudiaLortu(albumIzena);
			lblAlbumArgazkia.setIcon(albumArgazkia);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Aukeratutako albumaren informazioa JTextArean erakusteko metodoa.
	 *
	 * @param textAreaAlbumInf Albumaren informazioa erakutsiko den JTextArea
	 */
	private void AlbumInformazioaErakutsi(JTextArea textAreaAlbumInf) {
		try {
			AlbumDAO albumDAO = new AlbumDAO();
			String albumInf = albumDAO.AlbumInformazioaLortu(albumIzena);
			textAreaAlbumInf.setText(albumInf);
		} catch (Exception ex) {
			ex.printStackTrace();
			// Hemen errore mezua JOptionPanean edo konsolan erakutsi dezakezu
		}
	}
}
