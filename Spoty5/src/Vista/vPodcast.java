package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class vPodcast extends JFrame {
    private static final long serialVersionUID = 1L;

    public vPodcast() {
        setTitle("Podcast-reprodukzioa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // Pantailan erdian kokatu

        // Nagusiko panela
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Kontrol botoiak
        JButton btnPlay = new JButton("▶️");
        JButton btnPause = new JButton("⏸️");
        JButton btnStop = new JButton("⏹️");
        JButton btnSpeed05x = new JButton("0.5x");
        JButton btnSpeed1x = new JButton("1x");
        JButton btnSpeed15x = new JButton("1.5x");

        // Azeleratze maila erakusteko etiketa
        JLabel lblSpeed = new JLabel("Abiadura: 1x");

        // Botoiaren ekintza: Play
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Reprodukzio logikoa gehitu
            }
        });

        // Botoiaren ekintza: Pause
        btnPause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Erreprodukzioa pausatzearen logika gehitu
            }
        });

        // Botoiaren ekintza: Stop
        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Erreprodukzioa gelditzeko logika gehitu
            }
        });

        // Botoiaren ekintza: Abiadura 0.5x
        btnSpeed05x.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abiadura 0.5x-ra aldatzeko logika gehitu
                lblSpeed.setText("Abiadura: 0.5x");
            }
        });

        // Botoiaren ekintza: Abiadura 1x
        btnSpeed1x.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abiadura 1x-ra aldatzeko logika gehitu
                lblSpeed.setText("Abiadura: 1x");
            }
        });

        // Botoiaren ekintza: Abiadura 1.5x
        btnSpeed15x.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abiadura 1.5x-ra aldatzeko logika gehitu
                lblSpeed.setText("Abiadura: 1.5x");
            }
        });

        // Botoi panela
        JPanel panelBotoiak = new JPanel();
        panelBotoiak.add(btnPlay);
        panelBotoiak.add(btnPause);
        panelBotoiak.add(btnStop);

        // Abiadura panela
        JPanel panelAbiadura = new JPanel();
        panelAbiadura.add(btnSpeed05x);
        panelAbiadura.add(btnSpeed1x);
        panelAbiadura.add(btnSpeed15x);
        panelAbiadura.add(lblSpeed);

        // Nagusiko panelaren elementuak gehitu
        panel.add(panelBotoiak, BorderLayout.CENTER);
        panel.add(panelAbiadura, BorderLayout.SOUTH);

        // Nagusiko panela bira gehitu
        add(panel);

        // Bistaratu
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new vPodcast();
            }
        });
    }
}
