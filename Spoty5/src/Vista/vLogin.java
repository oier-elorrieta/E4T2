package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import DAO.BezeroaDAO;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

/**
 * Erabiltzailearen saio hasiera panela erakutsi eta saioa hasteko eta erregistratzeko aukerak eskaintzen duen klasea.
 */
public class vLogin extends JFrame {
	protected static final String erabiltzaileIzena = null;
	private JTextField txtErabiltzailea;
    private JPasswordField txtPasahitza;
    
    /**
     * Main metodoa.
     * 
     * @param args argumentuak
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
				vLogin frame = new vLogin(erabiltzaileIzena);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Sortu vLogin klasearen instanzia.
     * 
     * @param erabiltzaileIzena Erabiltzailearen izena
     */
    public vLogin(String erabiltzaileIzena) {
        
        setTitle("Saio Hasiera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(339, 236);
        setLocationRelativeTo(null);

        // Erabiltzailea eta pasahitza sartzeko eremuak
        JLabel lblErabiltzaile = new JLabel("Erabiltzailea:");
        lblErabiltzaile.setBounds(0, 22, 139, 30);
        lblErabiltzaile.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lblPasahitza = new JLabel("Pasahitza:");
        lblPasahitza.setBounds(10, 63, 126, 30);
        lblPasahitza.setHorizontalAlignment(SwingConstants.CENTER);
        txtErabiltzailea = new JTextField(20);
        txtErabiltzailea.setBounds(146, 22, 160, 30);
        txtPasahitza = new JPasswordField(20);
        txtPasahitza.setBounds(146, 63, 160, 30);
        JButton btnHasiSaioa = new JButton("Login");
        btnHasiSaioa.setBounds(31, 143, 126, 30);
        
//        btnHasiSaioa.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//        		vMenua vMenuaPanel = new vMenua(erabiltzaileIzena);
//        		vMenuaPanel.setVisible(true);
//        		dispose();
//        	}
//        });
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(lblErabiltzaile);
        panel.add(txtErabiltzailea);
        panel.add(lblPasahitza);
        panel.add(txtPasahitza);
        panel.add(btnHasiSaioa);
      
        getContentPane().add(panel, BorderLayout.CENTER);
        // Erregistratu botoia
        JButton btnErregistratu = new JButton("Erregistratu");
        btnErregistratu.setBounds(167, 143, 127, 30);
        panel.add(btnErregistratu);
        
        // Erregistratu botoiaren ekintza
        btnErregistratu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    	
                vErregistratu vErregistratuPanel = new vErregistratu(erabiltzaileIzena);
                vErregistratuPanel.setVisible(true);
                dispose();
            }
        });

        // Login botoiaren ekintza
        btnHasiSaioa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String erabiltzailea = txtErabiltzailea.getText();
                String pasahitza = new String(txtPasahitza.getPassword());

                BezeroaDAO bezero = new BezeroaDAO();
                
                // Bezeroa baieztatu
                boolean balidatuHasiSaioa = bezero.baieztatuBezeroa(erabiltzailea, pasahitza);

                if (balidatuHasiSaioa) {
                    JOptionPane.showMessageDialog(vLogin.this, "Barruan zaude");
                    
                    vMenua vMenuaPanel = new vMenua(erabiltzailea);
                    vMenuaPanel.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(vLogin.this, "Erabiltzailea edo pasahitza txarto dago");
                }
            }
        });
    }
}