package Vista;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Audioak.PlayListak;
import Bezeroak.Bezeroa;
import DAO.NirePlayListDAO;
import master.Main;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

/**
 * Erabiltzailearen PlayList-ak kudeatzeko interfaze grafikoa eskaintzen duen klasea.
 */
public class vNirePlayList extends JFrame {
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultListModel<String> listPlayListakModel = new DefaultListModel<>();
    private JList<String> listPlayListak;
    private JTextField Gustokoenak;
    private Bezeroa bezeroa;
    protected static String erabiltzaileIzena; 
	

	 /**
     * PlayList-ak bistaratzeko interfazea sortu.
     * @param erabiltzaileIzena Erabiltzailearen izena.
     */
    public vNirePlayList(Bezeroa bezeroa) {
    	this.bezeroa = bezeroa;
    	String erabiltzaileIzena = Main.bezero.getErabiltzailea();
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
		
		JButton btnProfila = new JButton(Main.bezero.getErabiltzailea());
		btnProfila.setBounds(456, 11, 118, 23);
		btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnProfila);
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 vErregistratu erregistratuFrame = new vErregistratu(Main.bezero.getErabiltzailea());
			        erregistratuFrame.setUserInfo(Main.bezero);
			        erregistratuFrame.setVisible(true);
			        dispose();
			}
		});
		

		JButton btnPlayListBerria = new JButton("Berria sortu");
		btnPlayListBerria.setBounds(456, 94, 118, 23);
		contentPane.add(btnPlayListBerria);
	        btnPlayListBerria.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String playListIzena = JOptionPane.showInputDialog(null, "Sartu PlayList izena:");
	                if (playListIzena != null && !playListIzena.isEmpty()) {
	                    NirePlayListDAO.sortuPlayList(erabiltzaileIzena, playListIzena);
	                    listPlayListakModel.addElement(playListIzena);
	                }
	            }
	        });
	        contentPane.add(btnPlayListBerria);
		
	

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
		
		
		JList listPlayListak = new JList(listPlayListakModel);
		scrollPanePlayList.setViewportView(listPlayListak);
		kargatuPlayListak(erabiltzaileIzena);
		
		Gustokoenak = new JTextField();
		Gustokoenak.setEditable(false);
		Gustokoenak.setText("Gustokoenak");
		scrollPanePlayList.setColumnHeaderView(Gustokoenak);
		Gustokoenak.setColumns(10);
		
		
	}
	
    private void kargatuPlayListak(String erabiltzaileIzena) {
        List<PlayListak> listaPlaylist = NirePlayListDAO.bezeroPlaylistZerrenda(erabiltzaileIzena);

        if (listaPlaylist.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ez da aurkitu " + erabiltzaileIzena, "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            for (PlayListak playlist : listaPlaylist) {
                listPlayListakModel.addElement(playlist.getIzena());
            }
        }
    }

}
