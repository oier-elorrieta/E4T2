package Vista;

import java.awt.Color;
import java.awt.GridLayout;
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
import javax.swing.border.EmptyBorder;

import DAO.BezeroaDAO;
import master.Bezeroa;

import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class vLogin extends JFrame {
	private JTextField txtErabiltzailea;
    private JPasswordField txtPasahitza;

    public vLogin() {
        
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
        txtErabiltzailea.setBounds(149, 22, 157, 30);
        txtPasahitza = new JPasswordField(20);
        txtPasahitza.setBounds(146, 63, 160, 30);
        JButton btnHasiSaioa = new JButton("Login");
        btnHasiSaioa.setBounds(31, 143, 126, 30);

        
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
                // Crear una instancia del panel de registro (vErregistratu)
                vErregistratu vErregistratuPanel = new vErregistratu();

                // Hacer visible el panel de registro
                vErregistratuPanel.setVisible(true);

                // Cerrar la ventana actual
                dispose();
            }
        });

   

        
        btnHasiSaioa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String erabiltzailea = txtErabiltzailea.getText();
                String pasahitza = new String(txtPasahitza.getPassword());

               
                BezeroaDAO bezero = new BezeroaDAO();
                
                
                boolean balidatuHasiSaioa = bezero.baieztatuAdmin(erabiltzailea, pasahitza);

                if (balidatuHasiSaioa) {
                    JOptionPane.showMessageDialog(vLogin.this, "Barruan zaude");
                    vMenua vMenua = new vMenua();
                    //vMenua.setVisib(true);//Egiten dugu ikusgarria urrengo lehioa, ondo jarri badugu
                } else {
                    JOptionPane.showMessageDialog(vLogin.this, "Erabiltzailea edo pasahitza txarto dago");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	vLogin frame = new vLogin();
                frame.setVisible(true);
            }
        });
    }
}