package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class vPlayList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtzera;

	/**
	 * Launch the application.
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
	 * Create the frame.
	 */
	public vPlayList(String erabiltzaileIzena, String playListIzena) {
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
				// Menu nagusira itzuli
				vNirePlayList vNirePlayListFrame = new vNirePlayList(playListIzena);
				vNirePlayListFrame.setVisible(true);
				dispose();
			}
		});
		
		JButton btnProfila = new JButton(playListIzena);
		btnProfila.setBounds(318, 11, 106, 23);
		contentPane.add(btnProfila);
		
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Profila editatzeko pantailara joan
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
