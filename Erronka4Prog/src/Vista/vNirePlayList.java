package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class vNirePlayList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vNirePlayList frame = new vNirePlayList();
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
	public vNirePlayList() {
		setTitle("Nire PlayList zerrenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtzera.setBounds(10, 11, 107, 23);
		contentPane.add(btnAtzera);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vMenua menuaFrame = new vMenua();
				menuaFrame.setVisible(true);
				dispose();
			}
		});
		
		JButton btnProfila = new JButton("Nire Profila");
		btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProfila.setBounds(456, 11, 118, 23);
		contentPane.add(btnProfila);
		
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vErregistratu vErregistratuPanel = new vErregistratu();
				vErregistratuPanel.setVisible(true);
				dispose();
			}
		});
		
		JButton btnPlayListBerria = new JButton("Berria sortu");
		btnPlayListBerria.setBounds(456, 94, 118, 23);
		contentPane.add(btnPlayListBerria);
		
		JButton btnPlayListEzabatu = new JButton("Ezabatu");
		btnPlayListEzabatu.setBounds(456, 168, 118, 23);
		contentPane.add(btnPlayListEzabatu);
		
		JButton btnPlayListImportatu = new JButton("Inportatu");
		btnPlayListImportatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlayListImportatu.setBounds(456, 238, 118, 23);
		contentPane.add(btnPlayListImportatu);
		
		JButton btnPlayListExportatu = new JButton("Exportatu");
		btnPlayListExportatu.setBounds(456, 306, 118, 23);
		contentPane.add(btnPlayListExportatu);
	}

}
