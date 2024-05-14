package Vista;

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
import java.util.List;

import DAO.PodcasterDAO;
import DAO.PodcasterListaDAO;
import Artistak.Podcaster;

/**
 * "vPodcasterLista" klaseak JFrame klasea heredatzen du eta podcast-ak zerrendatzeko eta hautatzeko
 * interfaze grafikoa eskaintzen du.
 */
public class vPodcasterLista extends JFrame {

   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JComboBox<String> comboBoxPodcasters;
   private String erabiltzaileIzena;
   
   /**
    * Klasearen eraikitzailea. Podcast-ak zerrendatzeko eta hautatzeko interfaze grafikoa sortzen du.
    * @param erabiltzaileIzena  Erabiltzailearen izena.
    */
   public vPodcasterLista(String erabiltzaileIzena) {
       this.erabiltzaileIzena = erabiltzaileIzena;
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
      
       btnVerPodcaster.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               PodcasterIkusi(erabiltzaileIzena);
           }
       });
      
       JButton btnAtzera = new JButton("Atzera");
       btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
       btnAtzera.setBounds(10, 7, 107, 23);
       contentPane.add(btnAtzera);
       
       btnAtzera.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               vMenua vMenuaPanel  = new vMenua(erabiltzaileIzena);
               vMenuaPanel.setVisible(true);
               dispose();
           }   
       });
       
       JButton btnProfila = new JButton(erabiltzaileIzena);
       btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
       btnProfila.setBounds(317, 7, 107, 23);
       contentPane.add(btnProfila);
       
       btnProfila.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               vErregistratu vErregistratuPanel = new vErregistratu(erabiltzaileIzena);
               vErregistratuPanel.setVisible(true);
               dispose();
           }
       });
       
       PodcasterListaKargatu();
   }
  
   /**
    * Podcast-ak zerrendatu eta ComboBox-en gehitu.
    */
   private void PodcasterListaKargatu() {
	    try {
	        PodcasterListaDAO podcasterDAO = new PodcasterListaDAO();
	        
	        // Lortu artisten zerrenda
	        List<Podcaster> podcasterList = podcasterDAO.PodcasterListaLortu();
	        
	        // Gehitu artisten izenak ComboBox-era
	        for (Podcaster podcaster : podcasterList) {
	            comboBoxPodcasters.addItem(podcaster.getIzena());
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }	       
	}
  
   /**
    * Hautatutako podcastera bistaratu.
    */
   private void PodcasterIkusi(String erabiltzaileIzena) {
	    try {
	        String podcasterHautatuta = comboBoxPodcasters.getSelectedItem().toString();
	        PodcasterDAO podcasterDAO = new PodcasterDAO();
	        String podcasterInfo = podcasterDAO.PodcasterInformazioaLortu(podcasterHautatuta); // Obtener información del podcaster
	        // Crear una instancia de Podcaster con la información obtenida
	        Podcaster podcaster = new Podcaster(0, podcasterHautatuta, null, podcasterInfo);
	        vPodcaster vPodcasterFrame = new vPodcaster(podcaster, erabiltzaileIzena); // Pasar el podcaster como argumento
	        vPodcasterFrame.setVisible(true);
	        dispose();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        // Gestionar el error aquí
	    }
	}
}