package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Erabiltzailearen PlayList-ak kudeatzeko interfaze grafikoa eskaintzen duen klasea.
 */
public class vNirePlayList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Aplikazioa abiarazi.
	 * @param args Komando lerroko agumentuak.
	 * @param erabiltzaileIzena Erabiltzailearen izena.
	 */
	public static void main(String[] args, String erabiltzaileIzena) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// PlayList-ak ikusteko interfazea sortu eta bistaratu
					vNirePlayList frame = new vNirePlayList(erabiltzaileIzena);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * PlayList-ak bistaratzeko interfazea sortu.
	 * @param erabiltzaileIzena Erabiltzailearen izena.
	 */
	public vNirePlayList(String erabiltzaileIzena) {
		setTitle("Nire PlayList zerrenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Atzera botoia
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtzera.setBounds(10, 11, 107, 23);
		contentPane.add(btnAtzera);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Menu nagusira itzuli
				vMenua menuaFrame = new vMenua(erabiltzaileIzena);
				menuaFrame.setVisible(true);
				dispose();
			}
		});
		
		// Profila bistaratzeko botoia
		JButton btnProfila = new JButton(erabiltzaileIzena);
		btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProfila.setBounds(456, 11, 118, 23);
		contentPane.add(btnProfila);
		
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Profila editatzeko pantailara joan
				vErregistratu vErregistratuPanel = new vErregistratu(erabiltzaileIzena);
				vErregistratuPanel.setVisible(true);
				dispose();
			}
		});
		
		// Berriki PlayList bat sortzeko botoia
		JButton btnPlayListBerria = new JButton("Berria sortu");
		btnPlayListBerria.setBounds(456, 94, 118, 23);
		contentPane.add(btnPlayListBerria);
		
		// PlayList bat ezabatzeko botoia
		JButton btnPlayListEzabatu = new JButton("Ezabatu");
		btnPlayListEzabatu.setBounds(456, 168, 118, 23);
		contentPane.add(btnPlayListEzabatu);
		
		// PlayList-ak inportatzeko botoia
		JButton btnPlayListImportatu = new JButton("Inportatu");
		btnPlayListImportatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PlayList-ak inportatu
			}
		});
		btnPlayListImportatu.setBounds(456, 238, 118, 23);
		contentPane.add(btnPlayListImportatu);
		
		// PlayList-ak esportatzeko botoia
		JButton btnPlayListExportatu = new JButton("Exportatu");
		btnPlayListExportatu.setBounds(456, 306, 118, 23);
		contentPane.add(btnPlayListExportatu);
	}
}