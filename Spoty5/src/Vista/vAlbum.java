package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class vAlbum extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;


    /**
     * Create the frame.
     */
    public vAlbum(String artistaSeleccionado, String erabiltzaileIzena) {
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
                vArtista vArtistaPanel = new vArtista(artistaSeleccionado, erabiltzaileIzena);
                vArtistaPanel.setVisible(true);
                dispose();
            }
        });
        
        JLabel lblAlbum = new JLabel("Album:");
        lblAlbum.setBounds(105, 14, 182, 13);
        contentPane.add(lblAlbum);
        
        JLabel lblKantaZ = new JLabel("Kanta Zerrenda: ");
        lblKantaZ.setBounds(10, 60, 100, 13);
        contentPane.add(lblKantaZ);
        
        JLabel lblAlbumZ = new JLabel("Albumaren informazioa");
        lblAlbumZ.setBounds(334, 60, 125, 13);
        contentPane.add(lblAlbumZ);
    }

}
