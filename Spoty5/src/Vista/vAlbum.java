package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import DAO.AlbumDAO;
import DAO.ArtistaDAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class vAlbum extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String albumIzena;
    


    /**
     * Create the frame.
     */
    public vAlbum(String artistaIzena, String erabiltzaileIzena, String albumIzena, String artistaDeskribapena, ImageIcon artistaIrudia) {
        this.albumIzena = albumIzena;
    setTitle("Album: " + albumIzena );
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
       
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vArtista vArtistaPanel = new vArtista(artistaIzena, erabiltzaileIzena);
                vArtistaPanel.setVisible(true);
                dispose();
            }
        });
       
        JLabel lblAlbum = new JLabel("Album: " + albumIzena );
        lblAlbum.setBounds(172, 14, 182, 13);
        contentPane.add(lblAlbum);
       
        JLabel lblKantaZ = new JLabel("Kanta Zerrenda: ");
        lblKantaZ.setBounds(10, 60, 100, 13);
        contentPane.add(lblKantaZ);
       
        JLabel lblAlbumZ = new JLabel("Albumaren informazioa");
        lblAlbumZ.setBounds(444, 60, 176, 13);
        contentPane.add(lblAlbumZ);
       
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
        btnAbestiAukera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String audioIzena = (String) comboBoxAbestiAukeratu.getSelectedItem();
                vErreprodukzio vErreprodukzioFrame = new vErreprodukzio(artistaIzena, erabiltzaileIzena, albumIzena, artistaDeskribapena, artistaIrudia,audioIzena);
                vErreprodukzioFrame.setVisible(true);
                dispose();
            }
        });
        

        btnAbestiAukera.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        }
        });
        btnAbestiAukera.setBounds(170, 83, 89, 23);
        contentPane.add(btnAbestiAukera);

        
        JTextArea textAreaAlbumInf = new JTextArea();
        textAreaAlbumInf.setEditable(false);
        textAreaAlbumInf.setLineWrap(true);
        textAreaAlbumInf.setWrapStyleWord(true);
        textAreaAlbumInf.setBounds(411, 102, 189, 87);
        contentPane.add(textAreaAlbumInf);
        
 AlbumInformazioaErakutsi(textAreaAlbumInf);
        

        btnAbestiAukera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vErreprodukzio vErreprodukzioFrame = new vErreprodukzio(artistaIzena, erabiltzaileIzena, albumIzena, artistaDeskribapena, artistaIrudia, artistaDeskribapena);
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
           
            // Obtener la imagen de la primera canción en el álbum
            if (!abestiak.isEmpty()) {
                String primeraAbestiIzena = abestiak.get(0); // Obtener el nombre de la primera canción
                ImageIcon albumArgazki = albumDAO.AlbumIrudiaLortu(primeraAbestiIzena); // Obtener la imagen de la canción
                lblAlbumArgazkia.setIcon(albumArgazki); // Establecer la imagen en el JLabel
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void AlbumIrudiaErakutsi(JLabel lblAlbumArgazkia) {
        try {
            AlbumDAO albumDAO = new AlbumDAO();          
            ImageIcon albumArgazki = albumDAO.AlbumIrudiaLortu(albumIzena);
            lblAlbumArgazkia.setIcon(albumArgazki);  
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
 // Aukeratutako albumaren informazioa JTextArean erakusteko metodoa
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