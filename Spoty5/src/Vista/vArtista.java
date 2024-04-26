package Vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Artistak.Artista;
import Artistak.Musikari;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea; // Importar JTextArea en lugar de JTextField

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.SQLException;

import DAO.ArtistaDAO;
import javax.swing.ImageIcon;

public class vArtista extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String artistaSeleccionado;

    public vArtista(String artistaSeleccionado, String erabiltzaileIzena) {
        this.artistaSeleccionado = artistaSeleccionado;
        setTitle("Álbumes de " + artistaSeleccionado);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 451, 418);
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
                vArtistaLista frame = new vArtistaLista(erabiltzaileIzena);
                frame.setVisible(true);
                dispose();
            }   
        });
        
        JButton btnProfila = new JButton(erabiltzaileIzena);
        btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnProfila.setBounds(317, 7, 107, 23);
        contentPane.add(btnProfila);
        
        JLabel lblDiskaZ = new JLabel("Diska Zerrenda");
        lblDiskaZ.setHorizontalAlignment(SwingConstants.CENTER);
        lblDiskaZ.setBounds(25, 41, 98, 14);
        contentPane.add(lblDiskaZ);
        
        JLabel lblInfo = new JLabel("Informazioa");
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setBounds(291, 41, 68, 14);
        contentPane.add(lblInfo);
        
        btnProfila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vErregistratu vErregistratuPanel = new vErregistratu(erabiltzaileIzena);
                vErregistratuPanel.setVisible(true);
                dispose();
            }
        });
        
     // Después del JComboBox de los álbumes
        JButton btnVerAlbum = new JButton("Ver Album");
        btnVerAlbum.setBounds(278, 323, 128, 23); // Ajusta la posición según sea necesario
        contentPane.add(btnVerAlbum);

       

        
        // Después de la etiqueta "Informazioa"
        JTextArea textAreaInformazioa = new JTextArea(); // Cambiar a JTextArea
        textAreaInformazioa.setEditable(false); // Para que no se pueda editar
        textAreaInformazioa.setLineWrap(true); // Para que el texto se envuelva en líneas
        textAreaInformazioa.setWrapStyleWord(true); // Para que el texto se envuelva en palabras
        textAreaInformazioa.setBounds(247, 81, 159, 90); // Ajusta la posición según sea necesario
        contentPane.add(textAreaInformazioa);
        
        // Mostrar la información del artista seleccionado en el JTextArea
        mostrarInformacionArtista(textAreaInformazioa);
        
        // Después del JTextArea
        JComboBox<String> comboBoxAlbumes = new JComboBox<>();
        comboBoxAlbumes.setBounds(10, 61, 128, 20); // Ajusta la posición según sea necesario
        contentPane.add(comboBoxAlbumes);
        
        // Mostrar los álbumes del artista seleccionado
        mostrarAlbumes(comboBoxAlbumes);
        
       
        
        
        try {
            // Obtener la imagen del objeto Musikari
            Blob imagenBlob = Artistak.Musikari.getIrudia();
            
            // Convertir el Blob en un ImageIcon
            if (imagenBlob != null) {
                ImageIcon icon = new ImageIcon(imagenBlob.getBytes(1, (int) imagenBlob.length()));
                
                JLabel lblAlbumIMG = new JLabel("New label");
                lblAlbumIMG.setBounds(10, 175, 164, 135);
                contentPane.add(lblAlbumIMG);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }
    }
  
    // Método para mostrar la información del artista seleccionado en el JTextArea
    private void mostrarInformacionArtista(JTextArea textAreaInformazioa) {
        try {
            // Crear una instancia del DAO de artistas
            ArtistaDAO artistaDAO = new ArtistaDAO();
            
            // Obtener la información del artista seleccionado
            String informacionArtista = artistaDAO.obtenerInformacionArtista(artistaSeleccionado);
            
            // Mostrar la información en el JTextArea
            textAreaInformazioa.setText(informacionArtista);
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