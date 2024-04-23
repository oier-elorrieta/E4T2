package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.ArtistaDAO;

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
        lblNewLabel.setBounds(25, 41, 98, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Informazioa");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(291, 41, 68, 14);
        contentPane.add(lblNewLabel_1);
        
        btnProfila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vErregistratu vErregistratuPanel = new vErregistratu();
                vErregistratuPanel.setVisible(true);
                dispose();
            }
        });
        
        // Después de la etiqueta "Informazioa"
        JTextField textFieldInformazioa = new JTextField();
        textFieldInformazioa.setBounds(247, 61, 159, 122); // Ajusta la posición según sea necesario
        contentPane.add(textFieldInformazioa);
        
        // Mostrar la información del artista seleccionado en el JTextField
        mostrarInformacionArtista(textFieldInformazioa);
        
        // Después del JTextField
        JComboBox<String> comboBoxAlbumes = new JComboBox<>();
        comboBoxAlbumes.setBounds(10, 61, 128, 20); // Ajusta la posición según sea necesario
        contentPane.add(comboBoxAlbumes);
        
        // Mostrar los álbumes del artista seleccionado
        mostrarAlbumes(comboBoxAlbumes);
    }
  
    // Método para mostrar la información del artista seleccionado en el JTextField
    private void mostrarInformacionArtista(JTextField textFieldInformazioa) {
        try {
            // Crear una instancia del DAO de artistas
            ArtistaDAO artistaDAO = new ArtistaDAO();
            
            // Obtener la información del artista seleccionado
            String informacionArtista = artistaDAO.obtenerInformacionArtista(artistaSeleccionado);
            
            // Mostrar la información en el JTextField
            textFieldInformazioa.setText(informacionArtista);
        } catch (Exception ex) {
            ex.printStackTrace();
            // Aquí puedes mostrar un mensaje de error en un JOptionPane o en la consola
        }
    }
    
    // Método para mostrar los álbumes del artista seleccionado
    private void mostrarAlbumes(JComboBox<String> comboBoxAlbumes) {
        try {
            // Crear una instancia del DAO de álbumes
            ArtistaDAO artistaDAO = new ArtistaDAO();
            
            // Obtener los álbumes del artista seleccionado
            String[] albumes = artistaDAO.obtenerAlbumesPorArtista(artistaSeleccionado);
            
            // Agregar los álbumes al JComboBox
            for (String album : albumes) {
                comboBoxAlbumes.addItem(album);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            // Aquí puedes mostrar un mensaje de error en un JOptionPane o en la consola
        }
    }
}