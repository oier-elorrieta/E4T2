package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import javax.swing.JTextPane;

public class vArtistaLista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vArtistaLista frame = new vArtistaLista();
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
	public vArtistaLista() {
		setTitle("Artistak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(10, 11, 104, 23);
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnAtzera);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vMenua menuaFrame = new vMenua();
				menuaFrame.setVisible(true);
				dispose();
			}
		});
		
		JButton btnProfila = new JButton("Nire Profila");
		btnProfila.setBounds(462, 11, 111, 23);
		btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnProfila);
		
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vErregistratu vErregistratuPanel = new vErregistratu();
				vErregistratuPanel.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblArtistaZerrendaIzena = new JLabel("Artisten zerrenda (Entzunaldi kopurua)");
		lblArtistaZerrendaIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistaZerrendaIzena.setBounds(178, 15, 234, 19);
		contentPane.add(lblArtistaZerrendaIzena);
	}
}
