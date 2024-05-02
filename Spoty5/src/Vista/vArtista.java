package Vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
 * vArtista klasea, artista baten diskoak eta informazioa erakusteko interfaze grafikoa.
 * JFrame klasearen extensioa.
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
     * @param artistaIzena artistaren izena
     * @param erabiltzaileIzena Erabiltzaile izena.
     */
    public vArtista(String artistaIzena, String erabiltzaileIzena) {
        this.artistaIzena = artistaIzena;
        setTitle("Álbumes de " + artistaIzena);
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
       
     // Albumen JComboBox-en ondoren
        JButton btnIkusiAlbuma = new JButton("Ikusi Albuma");
        btnIkusiAlbuma.setBounds(278, 323, 128, 23); // Behar bada posizioa egokitu
        contentPane.add(btnIkusiAlbuma);

        btnIkusiAlbuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String nombreAlbum  = comboBoxAlbumak.getSelectedItem().toString();
				vAlbum vAlbumPanel = new vAlbum(artistaIzena, erabiltzaileIzena, nombreAlbum, artistaDeskribapena, artistaIrudia);
                vAlbumPanel.setVisible(true);
                dispose();
            }
        });
       
        JTextArea textAreaInformazioa = new JTextArea();
        textAreaInformazioa.setEditable(false);
        textAreaInformazioa.setLineWrap(true);
        textAreaInformazioa.setWrapStyleWord(true);
        textAreaInformazioa.setBounds(249, 59, 159, 90);
        
        comboBoxAlbumak = new JComboBox<>();
        comboBoxAlbumak.setBounds(10, 61, 128, 20);
        contentPane.add(comboBoxAlbumak);

        AlbumakErakutsi(comboBoxAlbumak);
       
        ArtistaInformazioaErakutsi(textAreaInformazioa);
       
        // JTextArearen ondoren
        JComboBox<String> comboBoxAlbumes = new JComboBox<>();
        comboBoxAlbumes.setBounds(10, 61, 128, 20);
        contentPane.add(comboBoxAlbumes);
       
        AlbumakErakutsi(comboBoxAlbumes);
       
        JLabel lblArtistaImg = new JLabel("");
        lblArtistaImg.setHorizontalAlignment(SwingConstants.CENTER);
        lblArtistaImg.setBounds(10, 160, 223, 186);
        contentPane.add(lblArtistaImg);
       
        ArtistaIrudiaErakutsi(lblArtistaImg);
             
    }
 
 // Aukeratutako artistaren informazioa JTextArean erakusteko metodoa
    private void ArtistaInformazioaErakutsi(JTextArea textAreaInformazioa) {
        try {
        	ArtistaDAO artistaDAO = new ArtistaDAO();
            String informacionArtista = artistaDAO.ArtistaInformazioaLortu(artistaIzena);
            textAreaInformazioa.setText(informacionArtista);
        } catch (Exception ex) {
            ex.printStackTrace();
         // Hemen errore mezua JOptionPanean edo konsolan erakutsi dezakezu
        }
    }
   
    // Aukeratutako artistaren albumak erakusteko metodoa
    private void AlbumakErakutsi(JComboBox<String> comboBoxAlbumes) {
        try {
            ArtistaDAO artistaDAO = new ArtistaDAO();
            String[] albumes = artistaDAO.AlbumakLortuArtistetatik(artistaIzena);
           
            for (String album : albumes) {
                comboBoxAlbumes.addItem(album);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
         // Hemen errore mezua JOptionPanean edo konsolan erakutsi dezakezu
        }
    }
   
    /**
     * Metodoa erabiltzaileak aukeratutako artistaren irudia erakusteko.
     * 
     * @param lblArtistaImg JLabel elementua non artistaaren irudia erakusteko
     */
    private void ArtistaIrudiaErakutsi(JLabel lblArtistaImg) {
        try {
            ArtistaDAO artistaDAO = new ArtistaDAO();           
            ImageIcon imagenArtista = artistaDAO.ArtistaIrudiaLortu(artistaIzena);
            lblArtistaImg.setIcon(imagenArtista);  
        } catch (Exception ex) {
            ex.printStackTrace();
         // Hemen errore mezua JOptionPanean edo konsolan erakutsi dezakezu
        }
    }
}