package Vista;

import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 * Klase honek iragarki bat bistaratzeko interfaz grafikoa errepresentatzen du.
 * Iragarkiaren argazkia eta testua erakusten ditu.
 */
public class vIragarkia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Timer timer;
	private Clip clip;

	/**
     * vIragarkia klasearen main metodoa.
     * Programa hasieratzen du.
     * 
     * @param args Komando lerroan pasa diren argumentuak.
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vIragarkia frame = new vIragarkia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Frame sortu.
	 */
	public vIragarkia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIragarkiImg = new JLabel("");
		lblIragarkiImg.setIcon(new ImageIcon("C:\\Users\\in1dm3-d\\Desktop\\E4T2\\Spoty5\\src\\imgIragarkia\\hotwheels.jpg"));
		lblIragarkiImg.setBounds(24, 20, 386, 273);
		contentPane.add(lblIragarkiImg);
		
		JLabel lblIragarkia = new JLabel("IRAGARKIA!");
		lblIragarkia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIragarkia.setBounds(159, 304, 125, 28);
		contentPane.add(lblIragarkia); 
        
        
	}

}
