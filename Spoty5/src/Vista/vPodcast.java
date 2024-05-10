package Vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.PodcastDAO;
import javax.sound.sampled.Clip;

/**
 * Podcast-a erakusteko interfaze grafikoa eskaintzen duen klasea.
 */
public class vPodcast extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String podcaster;

    /**
     * Klasearen konstruktorea. Podcast-aren interfazea sortzen du.
     * @param podcaster Podcast-aren izena.
     * @param erabiltzaileIzena Erabiltzailearen izena.
     */
    public vPodcast(String podcaster, String erabiltzaileIzena) {
        this.podcaster = podcaster;
        setTitle("Podcast");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 601, 415);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnPerfil = new JButton(erabiltzaileIzena);
        btnPerfil.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnPerfil.setBounds(468, 7, 107, 23);
        contentPane.add(btnPerfil);
        
        btnPerfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vErregistratu erregistratuFrame = new vErregistratu(erabiltzaileIzena);
                erregistratuFrame.setVisible(true);
                dispose();
            }
        });

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

        JLabel lblPodcasterImage = new JLabel("");
        lblPodcasterImage.setBounds(164, 21, 239, 205);
        ImageIcon podcasterImage = new PodcastDAO().podcastIrudiaLortu(podcaster);
        lblPodcasterImage.setIcon(podcasterImage);
        contentPane.add(lblPodcasterImage);

        JButton btnMenu = new JButton("Menua");
        btnMenu.setBounds(90, 238, 89, 23);
        contentPane.add(btnMenu);

        JButton btnPreviousPodcast = new JButton("<");
        btnPreviousPodcast.setBounds(189, 238, 41, 23);
        contentPane.add(btnPreviousPodcast);

        JButton btnPlayPodcast = new JButton("Play");
        btnPlayPodcast.setBounds(240, 238, 89, 23);
        btnPlayPodcast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Clip clip = new PodcastDAO().audioErreproduzitu(podcaster);
                if (clip != null) {
                    clip.start();
                }
            }
        });
        contentPane.add(btnPlayPodcast);

        JButton btnNextPodcast = new JButton(">");
        btnNextPodcast.setBounds(339, 238, 41, 23);
        contentPane.add(btnNextPodcast);

        JButton btnFavorite = new JButton("Gustokoa");
        btnFavorite.setBounds(390, 238, 89, 23);
        contentPane.add(btnFavorite);

        JLabel lblPodcastInfo = new JLabel("Informazioa");
        lblPodcastInfo.setBounds(71, 288, 78, 14);
        contentPane.add(lblPodcastInfo);

        String podcastInfo = new PodcastDAO().podcastInformazioaLortu(podcaster);
        JTextArea textAreaPodcastInfo = new JTextArea();
        textAreaPodcastInfo.setText(podcastInfo);
        textAreaPodcastInfo.setEditable(false);
        textAreaPodcastInfo.setBounds(71, 313, 436, 52);
        textAreaPodcastInfo.setLineWrap(true);
        textAreaPodcastInfo.setWrapStyleWord(true); 
        contentPane.add(textAreaPodcastInfo);
    }
}