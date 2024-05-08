package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.PodcasterDAO;

public class vPodcast extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldPodcastInfo;
    private String podcaster;

    public vPodcast(String podcaster) {
        this.podcaster = podcaster;
        setTitle("Podcast");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 601, 415);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnBack = new JButton("Atzera");
        btnBack.setBounds(10, 11, 89, 23);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your action here
            }
        });
        contentPane.add(btnBack);

        JLabel lblPodcasterImage = new JLabel("");
        lblPodcasterImage.setBounds(164, 21, 239, 205);
        ImageIcon podcasterImage = new PodcasterDAO().PodcasterIrudiaLortu(podcaster);
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
                // Add your action here
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
        lblPodcastInfo.setBounds(43, 288, 78, 14);
        contentPane.add(lblPodcastInfo);

        String podcasterInfo = new PodcasterDAO().PodcasterInformazioaLortu(podcaster);
        textFieldPodcastInfo = new JTextField();
        textFieldPodcastInfo.setText(podcasterInfo);
        textFieldPodcastInfo.setEditable(false);
        textFieldPodcastInfo.setBounds(43, 313, 436, 52);
        contentPane.add(textFieldPodcastInfo);
        textFieldPodcastInfo.setColumns(10);
    }
}
