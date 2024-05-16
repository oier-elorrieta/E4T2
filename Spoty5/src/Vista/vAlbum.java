package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import Artistak.Musikari;
import Audioak.Abestia;
import Audioak.Album;
import DAO.AlbumDAO;
import DAO.ErreproduzioaDAO;
import master.Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * vAlbum klaseak JFrame-aren birtuala da eta musika albumen informazioa
 * erakusteko erabiltzen da. Klase honek musika albumaren argazkia, abestiak,
 * eta informazioa erakusten ditu.
 */
public class vAlbum extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboBoxaAbestiak;
	private Album album;
	private Musikari musikari;

	/**
	 * vAlbum klasearen eraikitzailea. Eraikitzaile honek albumaren izena
	 * ematen du eta albumaren leihoa hasieratzen du.
	 *
	 * @param artistaIzena        Albumaren artista izena
	 * @param erabiltzaileIzena   Erabiltzailearen izena
	 * @param albumIzena          Albumaren izena
	 * @param artistaDeskribapena Albumaren artistaaren deskribapena
	 * @param artistaIrudia       Albumaren artistaaren irudia
	 */
	public vAlbum(String erabiltzaileIzena, Musikari musikari, Album album) {
		this.musikari = musikari;
		this.album = album;
		setTitle("Albuma: " + album.getIzenburua());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnProfila = new JButton(Main.bezero.getErabiltzailea());
		btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProfila.setBounds(493, 9, 107, 23);
		contentPane.add(btnProfila);
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 vErregistratu erregistratuFrame = new vErregistratu(Main.bezero.getErabiltzailea());
			        erregistratuFrame.setUserInfo(Main.bezero);
			        erregistratuFrame.setVisible(true);
			        dispose();
			}
		});

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAtzera.setBounds(10, 10, 85, 21);
		contentPane.add(btnAtzera);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vArtista vArtistaFrame = new vArtista(erabiltzaileIzena, musikari);
				vArtistaFrame.setVisible(true);
				dispose();
			}
		});

		JLabel lblAlbum = new JLabel("Albuma: " + album.getIzenburua());
		lblAlbum.setBounds(172, 14, 182, 13);
		contentPane.add(lblAlbum);

		JLabel lblAbestiZerrenda = new JLabel("Abesti Zerrenda: ");
		lblAbestiZerrenda.setBounds(10, 60, 100, 13);
		contentPane.add(lblAbestiZerrenda);

		JLabel lblAlbumarenInformazioa = new JLabel("Albumaren informazioa");
		lblAlbumarenInformazioa.setBounds(444, 60, 176, 13);
		contentPane.add(lblAlbumarenInformazioa);

		JLabel lblAlbumArgazkia = new JLabel("");
		lblAlbumArgazkia.setBounds(23, 166, 261, 200);
		contentPane.add(lblAlbumArgazkia);
		albumenArgazkia(album.getIrudia(), lblAlbumArgazkia);

		comboBoxaAbestiak = new JComboBox<>();
		comboBoxaAbestiak.setBounds(10, 84, 128, 20);
		contentPane.add(comboBoxaAbestiak);
		abestiakErakutsi();

		JTextArea textAreaAlbumInf = new JTextArea();
		textAreaAlbumInf.setEditable(false);
		textAreaAlbumInf.setLineWrap(true);
		textAreaAlbumInf.setWrapStyleWord(true);
		textAreaAlbumInf.setBounds(411, 102, 189, 87);
		contentPane.add(textAreaAlbumInf);
		kargatuAlbumInformazioa(textAreaAlbumInf);

		JButton btnAbestiAukera = new JButton("Aukeratu");
		btnAbestiAukera.setBounds(170, 83, 89, 23);
		contentPane.add(btnAbestiAukera);
		btnAbestiAukera.setBounds(170, 83, 89, 23);
		contentPane.add(btnAbestiAukera);
		btnAbestiAukera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abestiaIkusi();
			}
		});

	}

	private void abestiaIkusi() { // Aukeratutako musikaria autatu

		String abestiAukeratua = comboBoxaAbestiak.getSelectedItem().toString();
		ErreproduzioaDAO erreproduzioaDAO = new ErreproduzioaDAO();
		Abestia aukeratutakoabesti = erreproduzioaDAO.abestiaLortu(abestiAukeratua);
		// Deitu urrengo orrira
		vErreprodukzio vErreproduzioaFrame = new vErreprodukzio(abestiAukeratua, aukeratutakoabesti, album, musikari,Main.bezero);
		vErreproduzioaFrame.setVisible(true);
		dispose();
	}

	private void kargatuAlbumInformazioa(JTextArea textAreaAlbumInf) {
		AlbumDAO albumDAO = new AlbumDAO();
		Album albumLortuta = albumDAO.albumLortu(album.getIzenburua());
		String generoa = albumLortuta.getGeneroa();
		Date urtea = albumLortuta.getUrtea();
		String albumInfo = "Generoa:  " + generoa + ", Argitaratze urtea: " + urtea.toString();
		textAreaAlbumInf.setText(albumInfo);

	}

	private void abestiakErakutsi() {
		try {
			if (album != null) {
				AlbumDAO albumDAO = new AlbumDAO();

				List<Abestia> abestiak = albumDAO.abestiakLortuAlbumetik(album);

				for (Abestia abesti : abestiak) {
					comboBoxaAbestiak.addItem(abesti.getIzena());
				}
			} else {
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
	private void albumenArgazkia(Blob irudiaBlob, JLabel lblArtistaImg) {
		try {
			if (irudiaBlob != null) {
				byte[] irudiaBytes = irudiaBlob.getBytes(1, (int) irudiaBlob.length()); // Irudia byte[] motan bihurtu
				if (irudiaBytes.length > 0) {
					// Irudia ImageIcon formatuan kargatu
					ImageIcon icon = new ImageIcon(irudiaBytes);
					lblArtistaImg.setIcon(icon);
					return;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
