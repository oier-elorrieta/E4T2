package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.ErregistratuDAO;

public class vErregistratu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField lblizena;
    private JTextField lblabizena;
    private JTextField lblerabiltzailea;
    private JTextField lblpasahitza;
    private JTextField lblj_data;
    private JTextField lblerregistro_data;
    private JTextField lblpremium_muga;
    private JComboBox<String> comboBoxHizkuntza;

    /**
     * Create the frame.
     */
    public vErregistratu() {
        setTitle("Erregistratu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Atzera");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para ir hacia atrás, por ejemplo cerrar esta ventana y abrir otra
            }
        });
        btnNewButton.setBounds(10, 11, 93, 29);
        getContentPane().add(btnNewButton);

        lblizena = new JTextField();
        lblizena.setBounds(131, 53, 93, 20);
        getContentPane().add(lblizena);
        lblizena.setColumns(10);

        lblabizena = new JTextField();
        lblabizena.setBounds(315, 53, 101, 20);
        getContentPane().add(lblabizena);
        lblabizena.setColumns(10);

        lblerabiltzailea = new JTextField();
        lblerabiltzailea.setBounds(131, 84, 211, 20);
        getContentPane().add(lblerabiltzailea);
        lblerabiltzailea.setColumns(10);

        lblpasahitza = new JTextField();
        lblpasahitza.setBounds(131, 115, 211, 20);
        getContentPane().add(lblpasahitza);
        lblpasahitza.setColumns(10);

        lblj_data = new JTextField();
        lblj_data.setBounds(131, 146, 211, 20);
        getContentPane().add(lblj_data);
        lblj_data.setColumns(10);

        // Gaurko data artzea
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = formatoFecha.format(fechaActual);

        // Jarri data lblerregistro_datan
        lblerregistro_data = new JTextField(fechaFormateada);
        lblerregistro_data.setBounds(131, 175, 211, 20);
        lblerregistro_data.setEditable(false); // Ezin da editatu
        getContentPane().add(lblerregistro_data);
        lblerregistro_data.setColumns(10);
        
        Date PremiumData = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(PremiumData);
        calendar.add(Calendar.YEAR, 1); // Urte bat gehitu

       
        Date fechaPremium = calendar.getTime();
        SimpleDateFormat formatoFechaPremium = new SimpleDateFormat("yyyy-MM-dd");
        String fechaPremiumFormateada = formatoFechaPremium.format(fechaPremium);

       
        lblpremium_muga = new JTextField(fechaPremiumFormateada);
        lblpremium_muga.setBounds(131, 206, 211, 20);
        lblpremium_muga.setEditable(false); 
        getContentPane().add(lblpremium_muga);
        lblpremium_muga.setColumns(10);


        JLabel lblNewLabel = new JLabel("Izena:");
        lblNewLabel.setBounds(20, 56, 46, 14);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Abizenak:");
        lblNewLabel_1.setBounds(243, 56, 76, 14);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Erabiltzailea:");
        lblNewLabel_2.setBounds(22, 87, 99, 14);
        getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Pasahitza:");
        lblNewLabel_3.setBounds(20, 118, 101, 14);
        getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Jaiotze Data:");
        lblNewLabel_4.setBounds(20, 149, 101, 14);
        getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Erregistro Data:");
        lblNewLabel_5.setBounds(22, 178, 109, 14);
        getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Premium Muga:");
        lblNewLabel_6.setBounds(20, 209, 111, 14);
        getContentPane().add(lblNewLabel_6);

        comboBoxHizkuntza = new JComboBox();
        comboBoxHizkuntza.setBounds(131, 235, 111, 25);
        getContentPane().add(comboBoxHizkuntza);

        JLabel lblNewLabel_7 = new JLabel("Hizkuntza:");
        lblNewLabel_7.setBounds(20, 234, 83, 14);
        getContentPane().add(lblNewLabel_7);

        JButton btnEditatu  = new JButton("Editatu");
        btnEditatu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String izena = lblizena.getText();
                String abizena = lblabizena.getText();
                String id_hizkuntza = (String) comboBoxHizkuntza.getSelectedItem();
                String erabiltzailea = lblerabiltzailea.getText();
                String pasahitza = lblpasahitza.getText();
                String jaiotze_data = lblj_data.getText();
                String erregistro_data = lblerregistro_data.getText();

                ErregistratuDAO erregistratuDAO = new ErregistratuDAO();
                boolean registroExitoso = erregistratuDAO.erregistroaEgin(izena, abizena, id_hizkuntza, erabiltzailea, pasahitza, jaiotze_data, erregistro_data);

                if (registroExitoso) {
                    JOptionPane.showMessageDialog(vErregistratu.this, "Erabiltzailea ondo erregistratu da!");
                } else {
                    JOptionPane.showMessageDialog(vErregistratu.this, "Errorea erabiltzailea erregistratzerakoan.");
                }
            }
        });
        btnEditatu.setBounds(59, 271, 101, 23);
        getContentPane().add(btnEditatu);

        JButton btnPremiumErosi = new JButton("Erosi Premium");
        btnPremiumErosi.setBounds(276, 271, 131, 23);
        getContentPane().add(btnPremiumErosi);

        // Bete JComboBox hizkuntza datuekin
        kargatuHizkuntza();
    }

    private void kargatuHizkuntza() {
        ErregistratuDAO erregistratuDAO = new ErregistratuDAO();
        try {
            // Obtener los datos de la tabla hizkuntza desde la base de datos
            String[] hizkuntzaData = erregistratuDAO.lortuHizkuntza();

            // Agregar los datos al JComboBox
            for (String hizkuntza : hizkuntzaData) {
                comboBoxHizkuntza.addItem(hizkuntza);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de hizkuntza: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
