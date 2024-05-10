package Vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Audioak.Album;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.ArtistaDAO;
import javax.swing.ImageIcon;

/**
 * "vArtista" klaseak JFrame klasea heredatzen du eta artistaren diskoak eta informazioa erakusteko
 * interfaze grafikoa eskaintzen du.
 */
public class vArtista extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String artistaIzena;
    private String artistaDeskribapena;
    private ImageIcon artistaIrudia;
    private JComboBox<String> comboBoxAlbumak;

    /**
     * Klaseko eraikitzailea.
     * @param artistaIzena     Artistaren izena
     * @param erabiltzaileIzena    Erabiltzailearen izena
     */
    public vArtista(String artistaIzena, String erabiltzaileIzena) {
        this.artistaIzena = artistaIzena;
        setTitle(artistaIzena + " diskak");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 451, 418);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
     
        JLabel lblArtista = new JLabel(artistaIzena);
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
       
        JButton btnProfila = new JButton(erabiltzaileIzena);
        btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnProfila.setBounds(317, 7, 107, 23);
        contentPane.add(btnProfila);
       
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
                String albumIzena  = comboBoxAlbumak.getSelectedItem().toString();
                vAlbum vAlbumPanel = new vAlbum(artistaIzena, erabiltzaileIzena, albumIzena, artistaDeskribapena, artistaIrudia);
                vAlbumPanel.setVisible(true);
                dispose();
            }
        });
       
        JTextArea textAreaInformazioa = new JTextArea();
        textAreaInformazioa.setEditable(false);
        textAreaInformazioa.setLineWrap(true);
        textAreaInformazioa.setWrapStyleWord(true);
        textAreaInformazioa.setBounds(246, 59, 159, 130);
        contentPane.add(textAreaInformazioa);
       
        ArtistaInformazioaErakutsi(textAreaInformazioa);
       
        comboBoxAlbumak = new JComboBox<>(); 
        comboBoxAlbumak.setBounds(10, 61, 128, 20);
        contentPane.add(comboBoxAlbumak);
       
        AlbumakErakutsi(comboBoxAlbumak);
       
        JLabel lblArtistaImg = new JLabel("");
        lblArtistaImg.setHorizontalAlignment(SwingConstants.CENTER);
        lblArtistaImg.setBounds(10, 160, 223, 186);
        contentPane.add(lblArtistaImg);
       
        ArtistaIrudiaErakutsi(lblArtistaImg);
    }
 
    /**
     * Artistaren informazioa JTextArean erakusteko metodoa.
     *
     * @param textAreaInformazioa    JTextArea elementua artistaren informazioa erakusteko
     */
    private void ArtistaInformazioaErakutsi(JTextArea textAreaInformazioa) {
        try {
            ArtistaDAO artistaDAO = new ArtistaDAO();
            String informazioaArtista = artistaDAO.ArtistaInformazioaLortu(artistaIzena);
            textAreaInformazioa.setText(informazioaArtista);
        } catch (Exception ex) {
            ex.printStackTrace();
<<<<<<< HEAD
         // Hemen errore mezua JOptionPanean edo konsolan erakutsi dezakezu
        }
    }
   
    // Aukeratutako artistaren albumak erakusteko metodoa
    private void AlbumakErakutsi(JComboBox<String> comboBoxAlbumes) {
        try {
            ArtistaDAO artistaDAO = new ArtistaDAO();
            List<Album> albumes = artistaDAO.AlbumakLortuArtistetatik();
           
            for (Album album : albumes) {
                comboBoxAlbumak.addItem(album.getIzenburua()); 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            
=======
>>>>>>> 05e614d397f7d5cf59e36a20b424c86a01b982fc
        }
    }
   
    /**
     * Artistaren albumak JComboBox-en gehitu.
     *
     * @param comboBoxAlbumes JComboBox elementua artistaren albumak erakusteko
     */
    private void AlbumakErakutsi(JComboBox<String> comboBoxAlbumes) {
        try {
            ArtistaDAO artistaDAO = new ArtistaDAO();
            String[] albumak = artistaDAO.AlbumakLortuArtistetatik(artistaIzena);
           
            for (String album : albumak) {
                comboBoxAlbumak.addItem(album);
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
    private void ArtistaIrudiaErakutsi(JLabel lblArtistaImg) {
        try {
            ArtistaDAO artistaDAO = new ArtistaDAO();          
            ImageIcon artistaIrudia = artistaDAO.ArtistaIrudiaLortu(artistaIzena);
            lblArtistaImg.setIcon(artistaIrudia);  
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}