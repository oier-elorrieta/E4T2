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
import DAO.ArtistaDAO;
public class vArtistaLista extends JFrame {
   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JTextField textFieldArtistas;
   private JComboBox<String> comboBoxArtistas;
   public static void main(String[] args) {
       EventQueue.invokeLater(new Runnable() {
           public void run() {
               try {
                   vArtistaLista frame = new vArtistaLista();
                   frame.setVisible(true);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });
   }
   public vArtistaLista() {
       setTitle("Lista de Artistas");
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
      
       textFieldArtistas = new JTextField();
       textFieldArtistas.setEditable(false);
       textFieldArtistas.setBounds(89, 36, 249, 106);
       contentPane.add(textFieldArtistas);
       textFieldArtistas.setColumns(10);
       // Combo box para seleccionar el artista
       comboBoxArtistas = new JComboBox<String>();
       comboBoxArtistas.setBounds(89, 153, 249, 23);
       contentPane.add(comboBoxArtistas);
      
       JButton btnVerArtista = new JButton("Ikusi Artista");
       btnVerArtista.setFont(new Font("Tahoma", Font.BOLD, 11));
       btnVerArtista.setBounds(149, 206, 129, 23);
       contentPane.add(btnVerArtista);
      
       // Acción del botón para ver el artista seleccionado
       btnVerArtista.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               verArtista();
           }
       });
      
       JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtzera.setBounds(10, 7, 107, 23);
		contentPane.add(btnAtzera);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vMenua frame = new vMenua();
				frame.setVisible(true);
				dispose();
			}	
		});
		
		JButton btnProfila = new JButton("Nire Profila");
		btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProfila.setBounds(317, 7, 107, 23);
		contentPane.add(btnProfila);
		
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vErregistratu vErregistratuPanel = new vErregistratu();
				vErregistratuPanel.setVisible(true);
				dispose();
			}
		});
      
       // Cargar la lista de artistas al abrir la ventana
       cargarListaArtistas();
   }
  
   /// Método para cargar la lista de artistas y mostrarla en el campo de texto
   private void cargarListaArtistas() {
       try {
           // Crear una instancia del DAO del artista
           ArtistaDAO artistaDAO = new ArtistaDAO();
          
           // Obtener la lista de artistas como una cadena
           String listaArtistas = artistaDAO.obtenerListaArtistas();
          
           // Mostrar la lista de artistas en el campo de texto
           textFieldArtistas.setText(listaArtistas);
          
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
   private void verArtista() {
       try {
           String artistaSeleccionado = comboBoxArtistas.getSelectedItem().toString();
           vArtista vArtistaFrame = new vArtista(artistaSeleccionado);
           vArtistaFrame.setVisible(true);
           dispose();
       } catch (Exception ex) {
           ex.printStackTrace();
           // Aquí puedes mostrar un mensaje de error en un JOptionPane o en la consola
       }
   }
}
