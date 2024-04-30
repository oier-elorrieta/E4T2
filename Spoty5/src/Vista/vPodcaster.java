package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ArtistaDAO;
import DAO.PodcasterDAO;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class vPodcaster extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String podcasterSeleccionado;

    public vPodcaster(String podcasterSeleccionado, String usuario) {
        this.podcasterSeleccionado = podcasterSeleccionado;
        setTitle("<dynamic>");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 451, 418);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
      
        JLabel lblPodcaster = new JLabel(podcasterSeleccionado);
        lblPodcaster.setHorizontalAlignment(SwingConstants.CENTER);
        lblPodcaster.setBounds(133, 11, 159, 14);
        contentPane.add(lblPodcaster);
      
        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAtzera.setBounds(10, 7, 107, 23);
        contentPane.add(btnAtzera);
       
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vPodcasterLista frame = new vPodcasterLista(usuario);
                frame.setVisible(true);
                dispose();
            }  
        });
        
        JButton btnPerfil = new JButton(usuario);
        btnPerfil.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnPerfil.setBounds(317, 7, 107, 23);
        contentPane.add(btnPerfil);
        
        JLabel lblPodcasts = new JLabel("Podcasts Zerrenda");
        lblPodcasts.setHorizontalAlignment(SwingConstants.CENTER);
        lblPodcasts.setBounds(25, 41, 98, 14);
        contentPane.add(lblPodcasts);
        
        JLabel lblInfo = new JLabel("Información");
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setBounds(291, 41, 68, 14);
        contentPane.add(lblInfo);
        
        JComboBox<String> comboBoxPodcasts = new JComboBox<>();
        comboBoxPodcasts.setBounds(10, 61, 128, 20);
        contentPane.add(comboBoxPodcasts);
        
        JTextArea textAreaInformacion = new JTextArea();
        textAreaInformacion.setEditable(false);
        textAreaInformacion.setLineWrap(true);
        textAreaInformacion.setWrapStyleWord(true);
        textAreaInformacion.setBounds(246, 59, 159, 130);
        contentPane.add(textAreaInformacion);
        
        mostrarInformacionPodcaster(textAreaInformacion);
        mostrarPodcasts(comboBoxPodcasts);
        
     // Crea el JLabel para mostrar la imagen del podcaster
        JLabel lblPodcasterImg = new JLabel("");
        lblPodcasterImg.setHorizontalAlignment(SwingConstants.CENTER);
        lblPodcasterImg.setBounds(10, 160, 223, 186);
        contentPane.add(lblPodcasterImg);

        // Llama al método para mostrar la imagen del podcaster
        mostrarImagenPodcaster(lblPodcasterImg);
        
        // Aquí puedes agregar más componentes según sea necesario
    
        // Después del JComboBox de los álbumes
        JButton btnErrePodcast = new JButton("Erreproduzitu Podcast");
        btnErrePodcast.setBounds(246, 222, 164, 23); // Ajusta la posición según sea necesario
        contentPane.add(btnErrePodcast);
    }
    
    private void mostrarInformacionPodcaster(JTextArea textAreaInformacion) {
        PodcasterDAO podcasterDAO = new PodcasterDAO();
        String informacionPodcaster = podcasterDAO.obtenerInformacionPodcaster(podcasterSeleccionado);
        textAreaInformacion.setText(informacionPodcaster);
    }
    
    private void mostrarPodcasts(JComboBox<String> comboBoxPodcasts) {
        PodcasterDAO podcasterDAO = new PodcasterDAO();
        String[] podcasts = podcasterDAO.obtenerPodcastsPorPodcaster(podcasterSeleccionado);
        for (String podcast : podcasts) {
            comboBoxPodcasts.addItem(podcast);
        }
    }
    
    private void mostrarImagenPodcaster(JLabel lblPodcasterImg) {
        try {
            // Crear una instancia del DAO de podcaster
            PodcasterDAO podcasterDAO = new PodcasterDAO();
           
            // Obtener la imagen del podcaster seleccionado
            ImageIcon imagenPodcaster = podcasterDAO.obtenerImagenPodcaster(podcasterSeleccionado);
           
            // Mostrar la imagen en el JLabel
            lblPodcasterImg.setIcon(imagenPodcaster);  
        } catch (Exception ex) {
            ex.printStackTrace();
            // Aquí puedes mostrar un mensaje de error en un JOptionPane o en la consola
        }
    }
}

