package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vIragarkia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Timer timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vIragarkia frame = new vIragarkia();
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
	public vIragarkia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIragarkiImg = new JLabel("");
		lblIragarkiImg.setBounds(117, 32, 175, 141);
		contentPane.add(lblIragarkiImg);
		
		JLabel lblIragarkia = new JLabel("IRAGARKIA!");
		lblIragarkia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIragarkia.setBounds(156, 184, 125, 28);
		contentPane.add(lblIragarkia);
		
		timer = new Timer(10000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                timer.stop(); 
            }
        });
        timer.start(); 
	}

}
