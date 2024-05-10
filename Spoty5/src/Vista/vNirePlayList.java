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
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Erabiltzailearen PlayList-ak kudeatzeko interfaze grafikoa eskaintzen duen klasea.
 */
public class vNirePlayList extends JFrame {
	protected static final String erabiltzaileIzena = null;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> listPlayListakModel = new   DefaultListModel<String>() ;
	/**
	 * Aplikazioa abiarazi.
	 * @param args Komando lerroko agumentuak.
	 * @param erabiltzaileIzena Erabiltzailearen izena.
	 */
	public static void main(String[] args, String erabiltzaileIzena) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(10, 11, 107, 23);
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnAtzera);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vMenua menuaFrame = new vMenua(erabiltzaileIzena);
				menuaFrame.setVisible(true);
				dispose();
			}
		});
		
		JButton btnProfila = new JButton(erabiltzaileIzena);
		btnProfila.setBounds(456, 11, 118, 23);
		btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnProfila);
		
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vErregistratu vErregistratuPanel = new vErregistratu(erabiltzaileIzena);
				vErregistratuPanel.setVisible(true);
				dispose();
			}
		});
		

		JButton btnPlayListBerria = new JButton("Berria sortu");
		btnPlayListBerria.setBounds(456, 94, 118, 23);
		contentPane.add(btnPlayListBerria);
		
		btnPlayListBerria.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        String izenaPlayList = eskatuPlayListIzena(erabiltzaileIzena);
		        
		        // PlayList izena ez bada hutsik
		        if (izenaPlayList != null && !izenaPlayList.isEmpty()) {
		            // PlayList berri bat sortzeko metodoa deitu
		            listPlayListakModel.addElement(izenaPlayList); // aktualizatu zerrenda
		            
		            // Hemen sortu zure PlayList-a datu-basean
		            // NirePlayListDAO.playListBerriaSortu(izenaPlayList, erabiltzaileIzena);
		            
		            listPlayListakModel.clear(); 
		            BezeroPlayListZerrenda(listPlayListakModel, erabiltzaileIzena); // Zerrenda berriro kargatu
		        }
		    }
		});

		JButton btnPlayListEzabatu = new JButton("Ezabatu");
		btnPlayListEzabatu.setBounds(456, 168, 118, 23);
		contentPane.add(btnPlayListEzabatu);
		
		JButton btnPlayListImportatu = new JButton("Inportatu");
		btnPlayListImportatu.setBounds(456, 238, 118, 23);
		btnPlayListImportatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		contentPane.add(btnPlayListImportatu);
		
		JButton btnPlayListExportatu = new JButton("Exportatu");
		btnPlayListExportatu.setBounds(456, 306, 118, 23);
		contentPane.add(btnPlayListExportatu);
		
		JScrollPane scrollPanePlayList = new JScrollPane();
		scrollPanePlayList.setBounds(30, 73, 180, 222);
		contentPane.add(scrollPanePlayList);
		
		listPlayListakModel  =  BezeroPlayListZerrenda(listPlayListakModel,erabiltzaileIzena );
		
		JList listPlayListak = new JList(listPlayListakModel);
		scrollPanePlayList.setViewportView(listPlayListak);
		
		listPlayListak.addListSelectionListener(new ListSelectionListener() {
	            public void valueChanged(ListSelectionEvent e) {
	            }
	        });
	}

	private DefaultListModel<String> BezeroPlayListZerrenda(DefaultListModel<String>  listPlayListakModel, String erab) {
			
            List<String> listaplaylist = DAO.NirePlayListDAO.BezeroPlayListZerrenda(erab);
            for (String i : listaplaylist) {
            	listPlayListakModel.addElement(i);
            	}
            return  listPlayListakModel;
            }
	
	private String eskatuPlayListIzena(String erabiltzaileIzena) {
	    String izenaPlayList = JOptionPane.showInputDialog(this, "PlayList berriaren izena:");
	    return izenaPlayList;
	}
}