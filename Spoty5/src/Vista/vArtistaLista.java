package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.ArtistaListaDAO;

public class vArtistaLista extends JFrame {
	
   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JComboBox<String> comboBoxArtistas;
   
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
       // Combo box para seleccionar el artista
       comboBoxArtistas = new JComboBox<String>();
       comboBoxArtistas.setBounds(92, 90, 249, 23);
       contentPane.add(comboBoxArtistas);
      
       JButton btnVerArtista = new JButton("Ikusi Artista");
       btnVerArtista.setFont(new Font("Tahoma", Font.BOLD, 11));
       btnVerArtista.setBounds(149, 206, 129, 23);
       contentPane.add(btnVerArtista);
      
       // Acción del botón para ver el artista seleccionado
       btnVerArtista.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               verArtista(erabiltzaileIzena);
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
      
       cargarListaArtistas();
   }
  
   /// Método para cargar la lista de artistas y mostrarla en el campo de texto
   private void cargarListaArtistas() {
       try {
           ArtistaListaDAO artistaDAO = new ArtistaListaDAO();
          
           String listaArtistas = artistaDAO.obtenerListaArtistas();
          
           // Agregar los artistas al ComboBox
           String[] arrayArtistas = listaArtistas.split("\n");
           comboBoxArtistas.removeAllItems();
           for (String artista : arrayArtistas) {
               comboBoxArtistas.addItem(artista);
           }
       } catch (Exception ex) {
           ex.printStackTrace();
           // Aquí puedes mostrar un mensaje de error en un JOptionPane o en la consola
       }
   }
  
   // Método para abrir la vista de vArtista con el artista seleccionado
   private void verArtista(String erabiltzaileIzena) {
       try {
           String artistaSeleccionado = comboBoxArtistas.getSelectedItem().toString();
           vArtista vArtistaFrame = new vArtista(artistaSeleccionado, erabiltzaileIzena);
           vArtistaFrame.setVisible(true);
           dispose();
       } catch (Exception ex) {
           ex.printStackTrace();
           // Aquí puedes mostrar un mensaje de error en un JOptionPane o en la consola
       }
   }
}
