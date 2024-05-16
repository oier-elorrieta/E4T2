package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import Artistak.Musikari;
import Audioak.Album;
import DAO.AlbumDAO;
import DAO.ArtistaDAO;
import DAO.MusikariListaDAO;
import master.Main;

/**
 * "vArtista" klaseak JFrame klasea heredatzen du eta artistaren diskoak eta informazioa erakusteko
 * interfaze grafikoa eskaintzen du.
 */
public class vArtista extends JFrame {
	
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxAlbumak;
	private Musikari musikari;

    /**
     * Klaseko eraikitzailea.
     * @param artistaIzena     Artistaren izena
     * @param erabiltzaileIzena    Erabiltzailearen izena
     */
    public vArtista(String erabiltzaileIzena, Musikari musikari) {
    	this.musikari = musikari;
        setTitle(musikari.getIzena() + " diskak");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 451, 418);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblArtista = new JLabel(musikari.getIzena());
        lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
        lblArtista.setBounds(133, 11, 159, 14);
        contentPane.add(lblArtista);
     
        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAtzera.setBounds(10, 7, 107, 23);
        contentPane.add(btnAtzera);
       
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vArtistaLista frame = new vArtistaLista(erabiltzaileIzena);
                frame.setVisible(true);
                dispose();
            }  
        });
       
        JButton btnProfila = new JButton(Main.bezero.getErabiltzailea());
        btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnProfila.setBounds(317, 7, 107, 23);
        contentPane.add(btnProfila);
        btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 vErregistratu erregistratuFrame = new vErregistratu(Main.bezero.getErabiltzailea());
			        erregistratuFrame.setUserInfo(Main.bezero);
			        erregistratuFrame.setVisible(true);
			        dispose();
			}
		});
       
        JLabel lblDiskaZ = new JLabel("Diska Zerrenda");
        lblDiskaZ.setHorizontalAlignment(SwingConstants.CENTER);
        lblDiskaZ.setBounds(25, 41, 98, 14);
        contentPane.add(lblDiskaZ);
       
        JLabel lblInfo = new JLabel("Informazioa");
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setBounds(291, 41, 68, 14);
        contentPane.add(lblInfo);
       
        btnProfila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vErregistratu vErregistratuPanel = new vErregistratu(erabiltzaileIzena);
                vErregistratuPanel.setVisible(true);
                dispose();
            }
        });
       
        JButton btnIkusiAlbuma = new JButton("Ikusi Albuma");
        btnIkusiAlbuma.setBounds(278, 323, 128, 23);
        contentPane.add(btnIkusiAlbuma);

        btnIkusiAlbuma.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        AlbumaIkusi();
    	    }
    	});

        JTextArea textAreaInformazioa = new JTextArea();
        textAreaInformazioa.setEditable(false);
        textAreaInformazioa.setLineWrap(true);
        textAreaInformazioa.setWrapStyleWord(true);
        textAreaInformazioa.setBounds(246, 59, 159, 130);
        contentPane.add(textAreaInformazioa);
        kargatuMusikariInformazioa(textAreaInformazioa);
      
        comboBoxAlbumak = new JComboBox<>(); 
        comboBoxAlbumak.setBounds(10, 61, 128, 20);
        contentPane.add(comboBoxAlbumak);
        albumakErakutsi();
              
        JLabel lblArtistaImg = new JLabel("");
        lblArtistaImg.setHorizontalAlignment(SwingConstants.CENTER);
        lblArtistaImg.setBounds(10, 160, 223, 186);
        contentPane.add(lblArtistaImg);
       
        artistenArgazkia(musikari.getIrudia(), lblArtistaImg);

    }
    
    private void AlbumaIkusi() { //Aukeratutako musikaria autatu
 	   
        String albumAukeratua = comboBoxAlbumak.getSelectedItem().toString();
        AlbumDAO albumDAO = new AlbumDAO();
        Album aukeratutakoalbum = albumDAO.albumLortu(albumAukeratua);
        //Deitu urrengo orrira
        vAlbum vAlbumFrame = new vAlbum(albumAukeratua,musikari,aukeratutakoalbum);
        vAlbumFrame.setVisible(true);
        dispose();
}
 
    /**
     * Artistaren informazioa JTextArean erakusteko metodoa.
     *
     * @param textAreaInformazioa    JTextArea elementua artistaren informazioa erakusteko
     */
    private void kargatuMusikariInformazioa(JTextArea textAreaInformazioa) {
        MusikariListaDAO musikariDAO = new MusikariListaDAO();
        Musikari musikariLortuta = musikariDAO.musikariLortu(musikari.getIzena());
        String informazioa = musikariLortuta.getDeskribapena();
        textAreaInformazioa.setText(informazioa);
        
    }
   
    /**
     * Artistaren albumak JComboBox-en gehitu.
     *
     * @param comboBoxAlbumes JComboBox elementua artistaren albumak erakusteko
     */
    private void albumakErakutsi() {
        try {
            if (musikari != null) {
                ArtistaDAO artistaDAO = new ArtistaDAO();
                
                List<Album> albumak = artistaDAO.albumakLortuArtistetatik(musikari);  
                
                for (Album album : albumak) {
                    comboBoxAlbumak.addItem(album.getIzenburua());
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
    
    private void artistenArgazkia(Blob irudiaBlob, JLabel lblArtistaImg) {
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