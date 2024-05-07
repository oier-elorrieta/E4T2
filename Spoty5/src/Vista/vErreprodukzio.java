package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class vErreprodukzio extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldAbestia;
    private  String albumIzena;

    

    public vErreprodukzio(String artistaIzena, String erabiltzaileIzena, String albumIzena, String artistaDeskribapena, ImageIcon artistaIrudia) {
    	setTitle("Erreprodukzioa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 601, 415);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.setBounds(10, 11, 89, 23);
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.add(btnAtzera);

        JLabel lblAlbumArgazkia = new JLabel("");
        lblAlbumArgazkia.setBounds(164, 21, 239, 205);
        contentPane.add(lblAlbumArgazkia);


        JButton btnMenua = new JButton("Menua");
        btnMenua.setBounds(90, 238, 89, 23);
        contentPane.add(btnMenua);

        JButton btnHurrengoAbesti = new JButton("<");
        btnHurrengoAbesti.setBounds(189, 238, 41, 23);
        contentPane.add(btnHurrengoAbesti);

        JButton btnHasiAbestia = new JButton("Play");
        btnHasiAbestia.setBounds(240, 238, 89, 23);
        btnHasiAbestia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        contentPane.add(btnHasiAbestia);

        JButton btnAurrekoAbesti = new JButton(">");
        btnAurrekoAbesti.setBounds(339, 238, 41, 23);
        contentPane.add(btnAurrekoAbesti);

        JButton btnGustokoa = new JButton("Gustokoa");
        btnGustokoa.setBounds(390, 238, 89, 23);
        contentPane.add(btnGustokoa);

        JLabel lblKantaInfo = new JLabel("Informazioa");
        lblKantaInfo.setBounds(43, 288, 78, 14);
        contentPane.add(lblKantaInfo);

        textFieldAbestia = new JTextField();
        textFieldAbestia.setBounds(43, 313, 436, 52);
        contentPane.add(textFieldAbestia);
        textFieldAbestia.setColumns(10);
        
        JButton btnPerfil = new JButton(erabiltzaileIzena);
        btnPerfil.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnPerfil.setBounds(468, 11, 107, 23);
        contentPane.add(btnPerfil);
        
        
        
    }
}