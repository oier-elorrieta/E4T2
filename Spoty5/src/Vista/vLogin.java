package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Bezeroak.Bezeroa;
import Bezeroak.Free;
import Bezeroak.Premium;
import Bezeroak.SaioAldagaiak;
import master.Main;

/**
 * Erabiltzailearen saio hasiera panela erakutsi eta saioa hasteko eta erregistratzeko aukerak eskaintzen duen klasea.
 */
public class vLogin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	protected static final String erabiltzaileIzena = null;
	private JTextField txtErabiltzailea;
    private JPasswordField txtPasahitza;
    private Bezeroa bezeroa;
    
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
        this.bezeroa = bezeroa;
        setTitle("Saio Hasiera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(339, 236);
        setLocationRelativeTo(null);

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
        
        btnHasiSaioa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		vMenua vMenuaPanel = new vMenua(erabiltzaileIzena);
        		vMenuaPanel.setVisible(true);
        		dispose();
        	}
        });    
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(lblErabiltzaile);
        panel.add(txtErabiltzailea);
        panel.add(lblPasahitza);
        panel.add(txtPasahitza);
        panel.add(btnHasiSaioa);
      
        getContentPane().add(panel, BorderLayout.CENTER);
        JButton btnErregistratu = new JButton("Erregistratu");
        btnErregistratu.setBounds(167, 143, 127, 30);
        panel.add(btnErregistratu);       

        btnErregistratu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    	
                vErregistratu vErregistratuPanel = new vErregistratu(erabiltzaileIzena);
                vErregistratuPanel.setVisible(true);
                dispose();
            }
        });
        
        btnHasiSaioa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String erabiltzailea = txtErabiltzailea.getText();
                String pasahitza = new String(txtPasahitza.getPassword());

                SaioAldagaiak saioAldagaiak = SaioAldagaiak.getInstance();
                Bezeroa erabiltzaile = saioAldagaiak.login(erabiltzailea, pasahitza);

                if (erabiltzaile != null) {
                    JOptionPane.showMessageDialog(vLogin.this, "Barruan zaude");
                    if (erabiltzaile instanceof Premium) {
                        Main.bezero = (Premium) erabiltzaile;
                    } else if (erabiltzaile instanceof Free) {
                        Main.bezero = (Free) erabiltzaile;
                    }
                } else {
                    JOptionPane.showMessageDialog(vLogin.this, "Erabiltzailea edo pasahitza txarto dago");
                }
            }
        });

    }
}