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
      
       JLabel lblArtista = new JLabel("Álbumes de " + artistaSeleccionado);
       lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
       lblArtista.setBounds(100, 11, 250, 14);
       contentPane.add(lblArtista);
      
       // Botón para volver atrás
       JButton btnVolver = new JButton("Volver");
       btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
       btnVolver.setBounds(169, 227, 89, 23);
       contentPane.add(btnVolver);
      
       // Acción del botón para volver atrás
       btnVolver.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               volverAListaArtistas();
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

