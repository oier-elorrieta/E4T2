package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import DAO.ErregistratuDAO;

import javax.swing.JTextArea;

public class vErregistratu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	/*public vErregistratu() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 305);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Atzera");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 11, 93, 29);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(131, 53, 93, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(315, 53, 101, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 84, 211, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(131, 115, 211, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(131, 146, 211, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(131, 175, 211, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(131, 206, 211, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Izena:");
		lblNewLabel.setBounds(20, 56, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Abizenak:");
		lblNewLabel_1.setBounds(243, 56, 62, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Erabiltzailea:");
		lblNewLabel_2.setBounds(22, 87, 81, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Pasahitza:");
		lblNewLabel_3.setBounds(20, 118, 69, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Jaiotze Data:");
		lblNewLabel_4.setBounds(20, 149, 83, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Erregistro Data:");
		lblNewLabel_5.setBounds(22, 178, 81, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Premium Muga:");
		lblNewLabel_6.setBounds(20, 209, 83, 14);
		panel.add(lblNewLabel_6);
		
		JButton btnEditatu  = new JButton("Editatu");
		 btnEditatu.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Obtener datos ingresados por el usuario
	                String izena = textField.getText();
	                String abizena = textField_1.getText();
	                String id_hizkuntza = textField_1.getText();
	                String erabiltzailea = textField_2.getText();
	                String pasahitza = textField_3.getText();
	                
	                // Obtener jaiotze_data y erregistro_data, puedes usar fechas ficticias por ahora
	                Date jaiotze_data = new Date(System.currentTimeMillis());
	                Date erregistro_data = new Date(System.currentTimeMillis());

	                // Llamar al método erregistroaEgin de ErregistratuDAO para registrar al usuario
	                ErregistratuDAO erregistratuDAO = new ErregistratuDAO();
	                boolean registroExitoso = erregistratuDAO.erregistroaEgin(izena, abizena,id_hizkuntza, erabiltzailea, pasahitza, jaiotze_data, erregistro_data);

	                // Mostrar mensaje de éxito o error
	                if (registroExitoso) {
	                    JOptionPane.showMessageDialog(vErregistratu.this, "Erabiltzailea ondo erregistratu da!");
	                } else {
	                    JOptionPane.showMessageDialog(vErregistratu.this, "Errorea erabiltzailea erregistratzerakoan.");
	                }
	            }
	        });
		 btnEditatu.setBounds(59, 260, 89, 23);
		panel.add(btnEditatu);
		
		JButton btnNewButton_2 = new JButton("Erosi Premium");
		btnNewButton_2.setBounds(275, 260, 109, 23);
		panel.add(btnNewButton_2);

	}*/
}
