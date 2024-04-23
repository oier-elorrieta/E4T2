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
import DAO.ArtistaDAO;
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
      
        JLabel lblArtista = new JLabel(artistaSeleccionado); // Mostrar solo el nombre del artista
        lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
        lblArtista.setBounds(133, 11, 159, 14);
        contentPane.add(lblArtista);
      
       JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtzera.setBounds(10, 7, 107, 23);
		contentPane.add(btnAtzera);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vArtistaLista frame = new vArtistaLista();
				frame.setVisible(true);
				dispose();
			}	
		});
		
		JButton btnProfila = new JButton("Nire Profila");
		btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProfila.setBounds(317, 7, 107, 23);
		contentPane.add(btnProfila);
		
		JLabel lblNewLabel = new JLabel("Diska Zerrenda");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 36, 98, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informazioa");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(317, 41, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vErregistratu vErregistratuPanel = new vErregistratu();
				vErregistratuPanel.setVisible(true);
				dispose();
			}
		});
		
		// Después de la etiqueta "Diska Zerrenda"
		JComboBox<String> comboBoxAlbumes = new JComboBox<>();
		comboBoxAlbumes.setBounds(50, 60, 350, 20); // Ajusta la posición según sea necesario
		contentPane.add(comboBoxAlbumes);
      
       // Mostrar los álbumes del artista seleccionado
       mostrarAlbumes();
   }
  
   // Método para mostrar los álbumes del artista seleccionado
   private void mostrarAlbumes() {
       try {
           // Crear una instancia del DAO de álbumes
           ArtistaDAO albumDAO = new ArtistaDAO();
          
           // Obtener los álbumes del artista seleccionado
           String[] albumes = albumDAO.obtenerAlbumesPorArtista(artistaSeleccionado);
          
           // Posición inicial de los álbumes
           int yPos = 70; // Cambiar la posición vertical aquí
        // Mostrar los álbumes en la ventana
           for (int i = 0; i < albumes.length; i++) {
               JLabel lblAlbum = new JLabel(albumes[i]);
               lblAlbum.setBounds(50, yPos + i * 20, 350, 14); // Ajusta la posición según sea necesario
               contentPane.add(lblAlbum);
           }
       } catch (Exception ex) {
           ex.printStackTrace();
           // Aquí puedes mostrar un mensaje de error en un JOptionPane o en la consola
       }
   }
  
   
}

