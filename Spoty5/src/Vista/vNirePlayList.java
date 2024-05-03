package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.DefaultListModel;
import javax.swing.JList;

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
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Atzera botoia
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(10, 11, 107, 23);
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
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
		btnProfila.setBounds(456, 11, 118, 23);
		btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
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
		btnPlayListImportatu.setBounds(456, 238, 118, 23);
		btnPlayListImportatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// PlayList-ak inportatu
			}
		});
		
		contentPane.add(btnPlayListImportatu);
		
		// PlayList-ak esportatzeko botoia
		JButton btnPlayListExportatu = new JButton("Exportatu");
		btnPlayListExportatu.setBounds(456, 306, 118, 23);
		contentPane.add(btnPlayListExportatu);
		
		JScrollPane PlayListPanel = new JScrollPane();
		PlayListPanel.setBounds(10, 73, 375, 256);
		PlayListPanel.setToolTipText("PlayList Zerrenda");
		contentPane.add(PlayListPanel);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();

		listModel.addElement("Gustoko kantak");
		listModel.addElement("PlayList 1");
		listModel.addElement("PlayList 2");

		JList<String> PlayListZerrenda = new JList<>(listModel);

		PlayListPanel.setViewportView(PlayListZerrenda);
		
		PlayListZerrenda.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		        int index = PlayListZerrenda.getSelectedIndex();
		        dispose();
		        
		        if (index != -1 && index != 3) {
		            String selectedItem = PlayListZerrenda.getSelectedValue();
		            dispose();
		            
		            vPlayList vPlayListPanel = new vPlayList(selectedItem, erabiltzaileIzena);
		            vPlayListPanel.setVisible(true);
		            dispose();
		        }
		    }
		});

	}
}