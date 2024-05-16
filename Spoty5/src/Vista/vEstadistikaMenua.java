package Vista;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class vEstadistikaMenua extends JFrame {
	protected static final String erabiltzaileIzena = null;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vEstadistikaMenua frame = new vEstadistikaMenua(erabiltzaileIzena);
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
	public vEstadistikaMenua(String erabiltzaileIzena) {
		setTitle("Estatistikak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtzera.setBounds(10, 11, 100, 23);
		contentPane.add(btnAtzera);
		
		JLabel lblEstatistikak = new JLabel("Estatistikak");
		lblEstatistikak.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEstatistikak.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstatistikak.setBounds(116, 36, 201, 42);
		contentPane.add(lblEstatistikak);
		
		JButton btnTopGAbestiak = new JButton("Top Gustoko Abestiak");
		btnTopGAbestiak.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnTopGAbestiak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTopGAbestiak.setBounds(116, 82, 201, 23);
		contentPane.add(btnTopGAbestiak);
		
		JButton btnTopGPodcast = new JButton("Top Gustoko Podcast");
		btnTopGPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTopGPodcast.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnTopGPodcast.setBounds(116, 116, 201, 23);
		contentPane.add(btnTopGPodcast);
		
		JButton btnTopEntzundakoak = new JButton("Top Entzundakoak");
		btnTopEntzundakoak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTopEntzundakoak.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnTopEntzundakoak.setBounds(116, 150, 201, 23);
		contentPane.add(btnTopEntzundakoak);
		
		JButton btnTopPlayList = new JButton("Top PlayList");
		btnTopPlayList.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnTopPlayList.setBounds(116, 184, 201, 23);
		contentPane.add(btnTopPlayList);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vMenuaAdmin menuAdminFrame = new vMenuaAdmin(erabiltzaileIzena);
				menuAdminFrame.setVisible(true);
				dispose();
			}	
		});
	}
}