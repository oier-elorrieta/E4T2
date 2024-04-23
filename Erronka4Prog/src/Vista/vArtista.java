package Vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.AlbumDAO;
import javax.swing.JTextField;
public class vArtista extends JFrame {
   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private String artistaSeleccionado;
   public vArtista(String artistaSeleccionado) {
       this.artistaSeleccionado = artistaSeleccionado;
       setTitle("Álbumes de " + artistaSeleccionado);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(100, 100, 450, 300);
       contentPane = new JPanel();
       contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
       setContentPane(contentPane);
       contentPane.setLayout(null);
      
       JLabel lblArtista = new JLabel("<dynamic>");
       lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
       lblArtista.setBounds(133, 11, 159, 14);
       contentPane.add(lblArtista);
      
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
      
       // Mostrar los álbumes del artista seleccionado
       mostrarAlbumes();
   }
  
   // Método para mostrar los álbumes del artista seleccionado
   private void mostrarAlbumes() {
       try {
           // Crear una instancia del DAO de álbumes
           AlbumDAO albumDAO = new AlbumDAO();
          
           // Obtener los álbumes del artista seleccionado
           String[] albumes = albumDAO.obtenerAlbumesPorArtista(artistaSeleccionado);
          
           // Mostrar los álbumes en la ventana
           for (int i = 0; i < albumes.length; i++) {
               JLabel lblAlbum = new JLabel(albumes[i]);
               lblAlbum.setBounds(50, 50 + i * 20, 350, 14); // Ajusta la posición según sea necesario
               contentPane.add(lblAlbum);
           }
       } catch (Exception ex) {
           ex.printStackTrace();
           // Aquí puedes mostrar un mensaje de error en un JOptionPane o en la consola
       }
   }
  
   // Método para volver a la lista de artistas
   private void volverAListaArtistas() {
       try {
           vArtistaLista vArtistaListaFrame = new vArtistaLista();
           vArtistaListaFrame.setVisible(true);
           dispose();
       } catch (Exception ex) {
           ex.printStackTrace();
           // Aquí puedes mostrar un mensaje de error en un JOptionPane o en la consola
       }
   }
}

