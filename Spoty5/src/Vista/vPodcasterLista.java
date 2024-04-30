package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.PodcasterListaDAO;

/**
 * Klase hau "vPodcasterLista" klasea da, podcast-ak zerrendatzeko eta hautatzeko interfaze grafikoa eskaintzen duena.
 */
public class vPodcasterLista extends JFrame {
   
   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JComboBox<String> comboBoxPodcasters;
   
   /**
    * Aplikazioa abiarazi.
    * @param args Komando lerroko argumentuak.
    * @param erabiltzaileIzena Erabiltzailearen izena.
    */
   public static void main(String[] args, String erabiltzaileIzena) {
       EventQueue.invokeLater(new Runnable() {
           public void run() {
               try {
                   vPodcasterLista frame = new vPodcasterLista(erabiltzaileIzena);
                   frame.setVisible(true);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });
   }
   
   /**
    * Klasearen eraikitzailea. Podcast-ak zerrendatzeko eta hautatzeko interfaze grafikoa sortzen du.
    * @param erabiltzaileIzena Erabiltzailearen izena.
    */
   public vPodcasterLista(String erabiltzaileIzena) {
       setTitle("Podcaster zerrenda");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(100, 100, 450, 300);
       contentPane = new JPanel();
       contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
       setContentPane(contentPane);
       contentPane.setLayout(null);
      
       JLabel lblPodcasters = new JLabel("Podcaster Zerrenda");
       lblPodcasters.setHorizontalAlignment(SwingConstants.CENTER);
       lblPodcasters.setBounds(127, 11, 185, 14);
       contentPane.add(lblPodcasters);
       
       comboBoxPodcasters = new JComboBox<String>();
       comboBoxPodcasters.setBounds(92, 90, 249, 23);
       contentPane.add(comboBoxPodcasters);
      
       JButton btnVerPodcaster = new JButton("Ikusi Podcaster");
       btnVerPodcaster.setFont(new Font("Tahoma", Font.BOLD, 11));
       btnVerPodcaster.setBounds(149, 206, 129, 23);
       contentPane.add(btnVerPodcaster);
      
       // Ikusi Podcaster botoiaren ekintza
       btnVerPodcaster.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               verPodcaster(erabiltzaileIzena);
           }
       });
      
       JButton btnAtzera = new JButton("Atzera");
       btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
       btnAtzera.setBounds(10, 7, 107, 23);
       contentPane.add(btnAtzera);
       
       btnAtzera.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // Itzuli menu nagusira
               vMenua vMenuaPanel  = new vMenua(erabiltzaileIzena);
               vMenuaPanel .setVisible(true);
               dispose();
           }   
       });
       
       JButton btnProfila = new JButton(erabiltzaileIzena);
       btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
       btnProfila.setBounds(317, 7, 107, 23);
       contentPane.add(btnProfila);
       
       btnProfila.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // Erregistratzeko interfazera joan
               vErregistratu vErregistratuPanel = new vErregistratu(erabiltzaileIzena);
               vErregistratuPanel.setVisible(true);
               dispose();
           }
       });
      
       // Zerrenda kargatu
       cargarListaPodcasters();
   }
  
   /**
    * Podcast-ak zerrendatu eta ComboBox-en gehitu.
    */
   private void cargarListaPodcasters() {
       try {
           PodcasterListaDAO podcasterDAO = new PodcasterListaDAO();
          
           String listaPodcasters = podcasterDAO.obtenerListaPodcasters();
          
           // Podcast-ak ComboBox-en gehitu
           String[] arrayPodcasters = listaPodcasters.split("\n");
           comboBoxPodcasters.removeAllItems();
           for (String podcaster : arrayPodcasters) {
               comboBoxPodcasters.addItem(podcaster);
           }
       } catch (Exception ex) {
           ex.printStackTrace();
           // Hemen errore mezu bat bistaratu dezakezu JOptionPane batean edo pantailako errorean
       }
   }
  
   /**
    * Hautatutako podcastera bistaratu.
    * @param erabiltzaileIzena Erabiltzailearen izena.
    */
   private void verPodcaster(String erabiltzaileIzena) {
       try {
           String podcasterSeleccionado = comboBoxPodcasters.getSelectedItem().toString();
           // Podcastera bistaratzen duen interfazera joan
           vPodcaster vPodcasterFrame = new vPodcaster(podcasterSeleccionado, erabiltzaileIzena);
           vPodcasterFrame.setVisible(true);
           dispose();
       } catch (Exception ex) {
           ex.printStackTrace();
           // Hemen errore mezu bat bistaratu dezakezu JOptionPane batean edo pantailako errorean
       }
   }
}