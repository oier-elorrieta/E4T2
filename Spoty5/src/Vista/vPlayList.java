package Vista;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bezeroak.Bezeroa;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Erabiltzailearen PlayList-aren interfaze grafikoa eskaintzen duen klasea.
 */
public class vPlayList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtzera;
	private Bezeroa bezeroa;

	/**
	 * Aplikazioa abiarazi.
	 * @param args Komando lerroko agumentuak.
	 * @param erabiltzaileIzena Erabiltzailearen izena.
	 * @param playListIzena PlayList-aren izena.
	 */
	public static void main(String[] args, String erabiltzaileIzena, String playListIzena) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vPlayList frame = new vPlayList(erabiltzaileIzena, playListIzena);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Frame-a sortu.
	 * @param erabiltzaileIzena Erabiltzailearen izena.
	 * @param playListIzena PlayList-aren izena.
	 */
	public vPlayList(String erabiltzaileIzena, String playListIzena) {
		this.bezeroa = bezeroa;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(10, 11, 106, 23);
		contentPane.add(btnAtzera);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vNirePlayList vNirePlayListFrame = new vNirePlayList(bezeroa);
				vNirePlayListFrame.setVisible(true);
				dispose();
			}
		});
		
		JButton btnProfila = new JButton(playListIzena);
		btnProfila.setBounds(318, 11, 106, 23);
		contentPane.add(btnProfila);
		
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vErregistratu vErregistratuPanel = new vErregistratu(playListIzena);
				vErregistratuPanel.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblPlayListIzena = new JLabel(erabiltzaileIzena);
		lblPlayListIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayListIzena.setBounds(164, 15, 106, 14);
		contentPane.add(lblPlayListIzena);		
	}
}