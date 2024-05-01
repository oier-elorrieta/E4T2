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
import DAO.ArtistaListaDAO;

/**
 * 'vArtistaLista' klaseak artisten zerrenda erakusteko eta artistaren informazioa ikusteko interfazea ematen du.
 */
public class vArtistaLista extends JFrame {
	
   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JComboBox<String> comboBoxArtistak;
   
   /**
    * Programaren exekuzioaren hasieran 'vArtistaLista' klasearen instantzia bat sortzeko metodo estatikoa.
    * 
    * @param args Komando lerro argumentuak
    * @param erabiltzaileIzena Erabiltzailearen izena
    */
   public static void main(String[] args,String erabiltzaileIzena) {
       EventQueue.invokeLater(new Runnable() {
           public void run() {
               try {
                   vArtistaLista frame = new vArtistaLista(erabiltzaileIzena);
                   frame.setVisible(true);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });
   }
   
   /**
    * 'vArtistaLista' klasearen eraikitzailea, non erabiltzaileak artisten zerrenda ikusi dezakeen.
    * 
    * @param erabiltzaileIzena Erabiltzailearen izena
    */
   public vArtistaLista(String erabiltzaileIzena) {
       setTitle("Artista lista");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(100, 100, 450, 300);
       contentPane = new JPanel();
       contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
       setContentPane(contentPane);
       contentPane.setLayout(null);
      
       JLabel lblArtistas = new JLabel("Artista Zerrenda");
       lblArtistas.setHorizontalAlignment(SwingConstants.CENTER);
       lblArtistas.setBounds(127, 11, 185, 14);
       contentPane.add(lblArtistas);
       // Artisten aukeratzeko combo boxa
       comboBoxArtistak = new JComboBox<String>();
       comboBoxArtistak.setBounds(92, 90, 249, 23);
       contentPane.add(comboBoxArtistak);
      
       JButton btnVerArtista = new JButton("Ikusi Artista");
       btnVerArtista.setFont(new Font("Tahoma", Font.BOLD, 11));
       btnVerArtista.setBounds(149, 206, 129, 23);
       contentPane.add(btnVerArtista);
      
       // Artista aukeratze botoiaren ekintza
       btnVerArtista.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               ArtistakIkusi(erabiltzaileIzena);
           }
       });
      
       JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtzera.setBounds(10, 7, 107, 23);
		contentPane.add(btnAtzera);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				
				vErregistratu vErregistratuPanel = new vErregistratu(erabiltzaileIzena);
				vErregistratuPanel.setVisible(true);
				dispose();
			}
		});
      
       ArtistaListaKargatu();
   }
  
   /**
    * Artisten zerrenda kargatzeko eta ComboBox-en erakusteko metodoa.
    */
   private void ArtistaListaKargatu() {
       try {
           ArtistaListaDAO artistaDAO = new ArtistaListaDAO();
           
           // Artisten zerrenda lortu
           String listaArtistas = artistaDAO.obtenerListaArtistas();
           
           // Artistak ComboBox-era gehitu
           String[] arrayArtistas = listaArtistas.split("\n");
           comboBoxArtistak.removeAllItems();
           for (String artista : arrayArtistas) {
               comboBoxArtistak.addItem(artista);
           }
       } catch (Exception ex) {
           ex.printStackTrace();
           // Hemen errore mezua JOptionPanean edo konsolan erakutsi dezakezu
       }
   }

   /**
    * 'vArtista' interfazea irekitzeko metodoa, aukeratutako artista batekin.
    * 
    * @param erabiltzaileIzena Erabiltzailearen izena
    */
   private void ArtistakIkusi(String erabiltzaileIzena) {
       try {
           String artistaSeleccionado = comboBoxArtistak.getSelectedItem().toString();
           vArtista vArtistaFrame = new vArtista(artistaSeleccionado, erabiltzaileIzena);
           vArtistaFrame.setVisible(true);
           dispose();
       } catch (Exception ex) {
           ex.printStackTrace();
           // Hemen errore mezua JOptionPanean edo konsolan erakutsi dezakezu
       }
   }
}