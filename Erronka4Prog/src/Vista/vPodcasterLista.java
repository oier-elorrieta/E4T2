package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class vPodcasterLista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPodcasters;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vPodcasterLista frame = new vPodcasterLista();
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
	public vPodcasterLista() {
		setTitle("Lista de Podcasters");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Podcaster Zerrenda");
		contentPane.add(lblNewLabel);
		
		textFieldPodcasters = new JTextField();
		contentPane.add(textFieldPodcasters);
		textFieldPodcasters.setColumns(10);
		
		JComboBox comboBoxPodcasters = new JComboBox();
		contentPane.add(comboBoxPodcasters);
		
		JButton btnVerPodcaster = new JButton("Ikusi Podcaster");
		contentPane.add(btnVerPodcaster);
		
		JButton btnAtzera = new JButton("Atzera");
		contentPane.add(btnAtzera);
		
		JButton btnProfila = new JButton("Nire Profila");
		contentPane.add(btnProfila);
	}

}
