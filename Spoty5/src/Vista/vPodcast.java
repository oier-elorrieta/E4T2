package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Artistak.Podcaster;
import Audioak.Abestia;
import Audioak.Podcast;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import DAO.AlbumDAO;
import DAO.ErreproduzioaDAO;
import DAO.PodcastDAO;
import DAO.PodcasterDAO;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

/**
 * Podcast-a erakusteko interfaze grafikoa eskaintzen duen klasea.
 */
public class vPodcast extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Podcaster podcaster;
    private Podcast podcast;
    private JTextArea textAreaPodcastInfo;
    private JLabel lblPodcasterImage;
    private Clip clip;
	private Timer timer;
	private int denbora;
	private List<Podcast> podcastak;
	private int currentIndex;
	private JLabel lblKontagailua;
	private PodcasterDAO podcasterDAO;
	private PodcastDAO podcastDAO;
	private JLabel lblPodcastIzena;

    /**
     * Klasearen konstruktorea. Podcast-aren interfazea sortzen du.
     * @param podcaster Podcast-aren izena.
     * @param erabiltzaileIzena Erabiltzailearen izena.
     */
	public vPodcast(String erabiltzaileIzena, Podcaster podcaster, Podcast podcast) {
	    this.podcaster = podcaster;
	    this.podcast = podcast;
        podcastDAO = new PodcastDAO(podcaster);
		podcastak = PodcasterDAO.podcastLortuPodcasterretik(podcaster);
        
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

        lblPodcasterImage = new JLabel("");
        lblPodcasterImage.setBounds(164, 21, 239, 205);
        contentPane.add(lblPodcasterImage);
        podcastArgazkia(podcast.getIrudia(),lblPodcasterImage);

        JButton btnMenu = new JButton("Menua");
        btnMenu.setBounds(87, 254, 89, 23);
        contentPane.add(btnMenu);
        
        btnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vMenua menuaPanel = new vMenua(erabiltzaileIzena);
                menuaPanel.setVisible(true);
                dispose();
            }
        });

        JButton btnPreviousPodcast = new JButton("<");
        btnPreviousPodcast.setBounds(186, 254, 41, 23);
        contentPane.add(btnPreviousPodcast);
        btnPreviousPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasadenAbestia();
			}
		});

        JButton btnPlayPodcast = new JButton("Play");
        btnPlayPodcast.setBounds(240, 254, 89, 23);
        contentPane.add(btnPlayPodcast);
        btnPlayPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				audioErreproduzitu(podcast.getIzena(), lblKontagailua);
			}
		});

        JButton btnNextPodcast = new JButton(">");
        btnNextPodcast.setBounds(339, 254, 41, 23);
        contentPane.add(btnNextPodcast);
        btnNextPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				urrengoAbestia();
			}
		});

        JButton btnFavorite = new JButton("Gustokoa");
        btnFavorite.setBounds(390, 254, 89, 23);
        contentPane.add(btnFavorite);

        JLabel lblPodcastInfo = new JLabel("Informazioa");
        lblPodcastInfo.setBounds(71, 288, 78, 14);
        contentPane.add(lblPodcastInfo);

       
        textAreaPodcastInfo = new JTextArea();
        textAreaPodcastInfo.setEditable(false);
        textAreaPodcastInfo.setBounds(71, 313, 436, 52);
        textAreaPodcastInfo.setLineWrap(true);
        textAreaPodcastInfo.setWrapStyleWord(true); 
        contentPane.add(textAreaPodcastInfo);
        kargatuPodcastInformazioa(textAreaPodcastInfo, podcast);
        
        lblPodcastIzena = new JLabel();
        lblPodcastIzena.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPodcastIzena.setBounds(217, 220, 163, 23);
        contentPane.add(lblPodcastIzena);
        
        lblKontagailua = new JLabel("");
        lblKontagailua.setBounds(490, 258, 46, 14);
        contentPane.add(lblKontagailua);
        
    }
    
    private void kargatuPodcastInformazioa(JTextArea textAreaAlbumInf, Podcast podcast) {
		PodcastDAO podcastDAO = new PodcastDAO();
		Podcast podcastLortuta = podcastDAO.podcastLortu(podcast.getIzena());
		Time iraupena = podcastLortuta.getIraupena();
		textAreaPodcastInfo.setText("Podcast iraupena" + iraupena);

	}

	private void podcastArgazkia(Blob irudiaBlob, JLabel lblArtistaImg) {
		try {
			if (irudiaBlob != null) {
				byte[] irudiaBytes = irudiaBlob.getBytes(1, (int) irudiaBlob.length()); // Irudia byte[] motan bihurtu
				if (irudiaBytes.length > 0) {
					// Irudia ImageIcon formatuan kargatu
					ImageIcon icon = new ImageIcon(irudiaBytes);
					lblArtistaImg.setIcon(icon);
					return;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public Clip audioErreproduzitu(String abestiIzena, JLabel lblKontadorea) {
		try {
			URL urlArchivo = getClass().getClassLoader().getResource("media/" + abestiIzena + ".wav");

			if (urlArchivo == null) {
				System.out.println("Ezin da aurkitu: " + abestiIzena);
				return null;
			}

			if (clip != null && clip.isRunning()) {
				clip.stop();
				clip.close();
			}

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(urlArchivo);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);

				denbora = 0;
			lblKontadorea.setText("   " + denbora);

			timer = new Timer(1000, e -> {
				denbora++;
				lblKontadorea.setText("   " + denbora);
			});
			timer.start();

			clip.addLineListener((LineListener) new LineListener() {
				public void update(LineEvent event) {
					if (event.getType() == LineEvent.Type.STOP) {
						clip.close();
						timer.stop();
					}
				}
			});

			clip.start();

			return clip;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void stopAudio() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
			clip.close();
			timer.stop();
		}
	}

	public void urrengoAbestia() {
		if (podcastak.isEmpty()) {
			return;
		}

		if (clip != null && clip.isRunning()) {
			clip.stop();
		}

		currentIndex = (currentIndex + 1) % podcastak.size();
		Podcast podcast = podcastak.get(currentIndex);
		clip = audioErreproduzitu(podcast.getIzena(), lblKontagailua); 
		
		lblPodcastIzena.setText(podcast.getIzena());
		kargatuPodcastInformazioa(textAreaPodcastInfo, podcast);
	}

	public void pasadenAbestia() {
		if (podcastak.isEmpty()) {
			return;
		}

		if (clip != null && clip.isRunning()) {
			clip.stop();
		}

		currentIndex = (currentIndex - 1 + podcastak.size()) % podcastak.size();
		Podcast podcast = podcastak.get(currentIndex);
		clip = audioErreproduzitu(podcast.getIzena(), lblKontagailua); 
		
		lblPodcastIzena.setText(podcast.getIzena());
		kargatuPodcastInformazioa(textAreaPodcastInfo, podcast);
	}
}
