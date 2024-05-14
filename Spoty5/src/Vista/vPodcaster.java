package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import DAO.PodcasterDAO;
import Artistak.Podcaster;
import Audioak.Podcast;

public class vPodcaster extends JFrame {
    private JComboBox<Podcast> comboBoxPodcasts;
    private JTextArea textAreaInformacion;
    private JLabel lblPodcasterImg;
    private Podcaster podcaster; // Nuevo atributo para almacenar el Podcaster

    public vPodcaster(String erabiltzaileIzena, Podcaster podcaster) {
        this.podcaster = podcaster; // Inicializar la variable podcaster
        setTitle(podcaster.getIzena()); // Usar el nombre del Podcaster como título
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 451, 418);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPodcaster = new JLabel(podcaster.getIzena()); // Usar el nombre del Podcaster como etiqueta
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

        textAreaInformacion = new JTextArea();
        textAreaInformacion.setEditable(false);
        textAreaInformacion.setLineWrap(true);
        textAreaInformacion.setWrapStyleWord(true);
        textAreaInformacion.setBounds(246, 59, 159, 130);
        contentPane.add(textAreaInformacion);

        PodcastErakutsi();
        comboBoxPodcasts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Podcast podcast = (Podcast) comboBoxPodcasts.getSelectedItem();
                if (podcast != null) {
                    textAreaInformacion.setText("Izena: " + podcast.getIzena() + "\nIraupena: " + podcast.getIraupena() + " minutu\nKolaboratzaileak: " + podcast.getKolaboratzaileak() + "\nErreprodukzioak: " + podcast.getErreprodukzioak());
                }
            }
        });

        lblPodcasterImg = new JLabel("");
        lblPodcasterImg.setHorizontalAlignment(SwingConstants.CENTER);
        lblPodcasterImg.setBounds(10, 160, 223, 186);
        contentPane.add(lblPodcasterImg);

        PodcasterIrudiaErakutsi();
    }

    private void PodcastErakutsi() {
        PodcasterDAO podcasterDAO = new PodcasterDAO();
        List<Podcast> podcasts = podcasterDAO.PodcastPodcastertatikLortu(podcaster);
        for (Podcast podcast : podcasts) {
            comboBoxPodcasts.addItem(podcast.getIzena()); // Agregar solo el nombre del podcast al comboBox
        }
    }

    private void PodcasterIrudiaErakutsi() {
        PodcasterDAO podcasterDAO = new PodcasterDAO();
        try {
            ImageIcon podcasterIrudi = podcasterDAO.PodcasterIrudiaLortu(podcaster.getIzena());
            lblPodcasterImg.setIcon(podcasterIrudi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
