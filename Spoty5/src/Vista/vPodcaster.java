package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.PodcasterDAO;

public class vPodcaster extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String PodcasterHautatua;
    private JComboBox<String> comboBoxPodcasts;

    public vPodcaster(String PodcasterHautatua, String erabiltzaileIzena) {
        this.PodcasterHautatua = PodcasterHautatua;
        setTitle(PodcasterHautatua);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 451, 418);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPodcaster = new JLabel(PodcasterHautatua);
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

        JLabel lblInfo = new JLabel("Información");
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setBounds(291, 41, 68, 14);
        contentPane.add(lblInfo);

        comboBoxPodcasts = new JComboBox<>();
        comboBoxPodcasts.setBounds(10, 61, 128, 20);
        contentPane.add(comboBoxPodcasts);

        JTextArea textAreaInformacion = new JTextArea();
        textAreaInformacion.setEditable(false);
        textAreaInformacion.setLineWrap(true);
        textAreaInformacion.setWrapStyleWord(true);
        textAreaInformacion.setBounds(246, 59, 159, 130);
        contentPane.add(textAreaInformacion);

        PodcasterInformazioaErakutsi(textAreaInformacion);

        PodcastErakutsi(comboBoxPodcasts);

        JLabel lblPodcasterImg = new JLabel("");
        lblPodcasterImg.setHorizontalAlignment(SwingConstants.CENTER);
        lblPodcasterImg.setBounds(10, 160, 223, 186);
        contentPane.add(lblPodcasterImg);
        PodcasterIrudiaErakutsi(lblPodcasterImg);

        // Botoia Erreproduzitu Podcast
        JButton btnErrePodcast = new JButton("Erreproduzitu Podcast");
        btnErrePodcast.setBounds(246, 222, 164, 23);
        contentPane.add(btnErrePodcast);

        btnErrePodcast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PodcastIkusi(erabiltzaileIzena);
            }
        });
    }

    private void PodcasterInformazioaErakutsi(JTextArea textAreaInformacion) {
        PodcasterDAO podcasterDAO = new PodcasterDAO();
        String informacionPodcaster = podcasterDAO.PodcasterInformazioaLortu(PodcasterHautatua);
        textAreaInformacion.setText(informacionPodcaster);
    }

    private void PodcastErakutsi(JComboBox<String> comboBoxPodcasts) {
        PodcasterDAO podcasterDAO = new PodcasterDAO();
        String[] podcasts = podcasterDAO.PodcastPodcastertatikLortu(PodcasterHautatua);
        for (String podcast : podcasts) {
            comboBoxPodcasts.addItem(podcast);
        }
    }

    private void PodcastIkusi(String erabiltzaileIzena) {
        try {
            String podcastHautatua = comboBoxPodcasts.getSelectedItem().toString();
            vPodcast vPodcastFrame = new vPodcast(podcastHautatua, erabiltzaileIzena);
            vPodcastFrame.setVisible(true);
            dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            // Manejar el error aquí
        }
    }

    private void PodcasterIrudiaErakutsi(JLabel lblPodcasterImg) {
        try {
            PodcasterDAO podcasterDAO = new PodcasterDAO();
            ImageIcon imagenPodcaster = podcasterDAO.PodcasterIrudiaLortu(PodcasterHautatua);
            lblPodcasterImg.setIcon(imagenPodcaster);  
        } catch (Exception ex) {
            ex.printStackTrace();
            // Manejar el error aquí
        }
    }
}