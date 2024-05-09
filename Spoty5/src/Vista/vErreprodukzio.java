package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

import DAO.AlbumDAO;
import DAO.ErreproduzioaDAO;

public class vErreprodukzio extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String albumIzena;
    private String audioIzena;
    private List<String> abestiak; // Lista de canciones del álbum
    private int currentIndex; // Índice de la canción actual

    public vErreprodukzio(String artistaIzena, String erabiltzaileIzena, String albumIzena, String artistaDeskribapena, ImageIcon artistaIrudia, String audioIzena) {
        setTitle("Erreprodukzioa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 601, 415);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.setBounds(10, 11, 89, 23);
        contentPane.add(btnAtzera);
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vAlbum vAlbumPanel = new vAlbum(artistaIzena, erabiltzaileIzena, albumIzena, artistaDeskribapena, artistaIrudia);
                vAlbumPanel.setVisible(true);
                dispose();
            }
        });

        JLabel lblAbestiArgazkia = new JLabel("");
        lblAbestiArgazkia.setBounds(164, 21, 239, 205);
        contentPane.add(lblAbestiArgazkia);
        
        AbestiIrudiaErakutsi(lblAbestiArgazkia, audioIzena);

        JButton btnMenua = new JButton("Menua");
        btnMenua.setBounds(90, 238, 89, 23);
        contentPane.add(btnMenua);
        
        btnMenua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vMenua menuaPanel = new vMenua(audioIzena);
                menuaPanel.setVisible(true);
                dispose();
            }
        });

        JButton btnAurrekoAbesti = new JButton("<");
        btnAurrekoAbesti.setBounds(189, 238, 41, 23);
        contentPane.add(btnAurrekoAbesti);

        JButton btnHasiAbestia = new JButton("Play");
        btnHasiAbestia.setBounds(240, 238, 89, 23);
        btnHasiAbestia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ErreproduzioaDAO dao = new ErreproduzioaDAO();
                dao.audioErreproduzitu(audioIzena + ".wav");
            }
        });
        contentPane.add(btnHasiAbestia);

        JButton btnHurrengoAbesti = new JButton(">");
        btnHurrengoAbesti.setBounds(339, 238, 41, 23);
        contentPane.add(btnHurrengoAbesti);

          

        JButton btnGustokoa = new JButton("Gustokoa");
        btnGustokoa.setBounds(390, 238, 89, 23);
        contentPane.add(btnGustokoa);

        JLabel lblKantaInfo = new JLabel("Informazioa");
        lblKantaInfo.setBounds(43, 288, 473, 65);
        contentPane.add(lblKantaInfo);
        
        AbestiInformazioaErakutsi(lblKantaInfo,audioIzena);

        JButton btnPerfil = new JButton(erabiltzaileIzena);
        btnPerfil.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnPerfil.setBounds(468, 11, 107, 23);
        contentPane.add(btnPerfil);
    }
    
    private void AbestiIrudiaErakutsi(JLabel lblAbestiArgazkia, String audioIzena) {
        try {
            ErreproduzioaDAO erreproduzioaDAO = new ErreproduzioaDAO();          
            ImageIcon abestiArgazki = erreproduzioaDAO.AbestiIrudiaLortu(audioIzena);
            lblAbestiArgazkia.setIcon(abestiArgazki);  
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void AbestiInformazioaErakutsi(JLabel lblKantaInfo, String audioIzena) {
        try {
        	ErreproduzioaDAO erreproduzioaDAO = new ErreproduzioaDAO();
            String albumInf = erreproduzioaDAO.AbestiInformazioaLortu(audioIzena);
            lblKantaInfo.setText(albumInf);
        } catch (Exception ex) {
            ex.printStackTrace();
         // Hemen errore mezua JOptionPanean edo konsolan erakutsi dezakezu
        }
    }
}
