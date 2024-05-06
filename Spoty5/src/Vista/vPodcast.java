package Vista;

import javax.swing.*;
import Audioak.Podcast;
import DAO.PodcastDAO;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.util.List;

/**
 * vPodcast klasea, JFrame klasearen luzapena da, podcast-en erreprodukzio-interfazea diseinatzeko.
 */
public class vPodcast extends JFrame {
    private static final long serialVersionUID = 1L;
    private Clip clip;
    private float speed = 1.0f; // Berezko erreprodukzio abiadura

    /**
     * Klaseko eraikitzailea. JFrame-aren konfigurazioa burutzen du.
     */
    public vPodcast() {
        setTitle("Podcast-reprodukzioa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton btnPlay = new JButton("▶️");
        JButton btnPause = new JButton("⏸️");
        JButton btnStop = new JButton("⏹️");
        JButton btnSpeed05x = new JButton("0.5x");
        JButton btnSpeed1x = new JButton("1x");
        JButton btnSpeed15x = new JButton("1.5x");

        JLabel lblSpeed = new JLabel("Abiadura: " + speed + "x");

        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clip != null && clip.isRunning()) {
                    clip.stop();
                }
                reproducirPodcast();
            }
        });

        btnPause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clip != null && clip.isRunning()) {
                    clip.stop();
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clip != null) {
                    clip.stop();
                    clip.setFramePosition(0);
                }
            }
        });

        btnSpeed05x.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                speed = 0.5f;
                lblSpeed.setText("Abiadura: " + speed + "x");
                if (clip != null && clip.isOpen()) {
                    cambiarVelocidadReproduccion(speed);
                }
            }
        });

        btnSpeed1x.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                speed = 1.0f;
                lblSpeed.setText("Abiadura: " + speed + "x");
                if (clip != null && clip.isOpen()) {
                    cambiarVelocidadReproduccion(speed);
                }
            }
        });

        btnSpeed15x.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                speed = 1.5f;
                lblSpeed.setText("Abiadura: " + speed + "x");
                if (clip != null && clip.isOpen()) {
                    cambiarVelocidadReproduccion(speed);
                }
            }
        });

        JPanel panelBotoiak = new JPanel();
        panelBotoiak.add(btnPlay);
        panelBotoiak.add(btnPause);
        panelBotoiak.add(btnStop);

        JPanel panelAbiadura = new JPanel();
        panelAbiadura.add(btnSpeed05x);
        panelAbiadura.add(btnSpeed1x);
        panelAbiadura.add(btnSpeed15x);
        panelAbiadura.add(lblSpeed);

        panel.add(panelBotoiak, BorderLayout.CENTER);
        panel.add(panelAbiadura, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }

    /**
     * Metodoa podcast-a erreproduzitzeko.
     */
    private void reproducirPodcast() {
        PodcastDAO podcastDAO = new PodcastDAO();
        List<String> podcasts = podcastDAO.obtenerAudiosPorPodcaster("Lola Indigo");
        if (!podcasts.isEmpty()) {
            try {
                int idPodcast = Integer.parseInt(podcasts.get(0));
                Podcast podcast = podcastDAO.obtenerPodcastPorId(idPodcast);
                if (podcast != null) {
                    // Podcast-a erreproduzitzeko logika inplementatu
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Metodoa erreprodukzio abiadura aldatzeko.
     * 
     * @param speed Erreprodukzio abiadura berria.
     */
    private void cambiarVelocidadReproduccion(float speed) {
        if (clip != null && clip.isOpen()) {
            FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            control.setValue(speed);
        }
    }
}
