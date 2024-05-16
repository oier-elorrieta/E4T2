package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Artistak.Musikari;
import Audioak.Abestia;
import Audioak.Album;
import Bezeroak.Bezeroa;
import Bezeroak.Free;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Time;

import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;

import DAO.AlbumDAO;
import DAO.ErreproduzioaDAO;
import master.Main;

import javax.swing.Timer;

public class vErreprodukzio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Abestia abestia;
	private Album album;
	private ErreproduzioaDAO erreprodukzioDAO;
	private Clip clip;
	private Timer timer;
	private int denbora;
	private List<Abestia> abestiak;
	private int currentIndex;
	private JLabel lblKontadorea;
	private JLabel lblKantaIzena;
	private JTextArea textAreaAbestiInf;
	private Musikari musikari;
	private int abestikontagailua;
	private static final int ABESTI_KONT_IRAGARKI = 2;
	private vIragarkia vIragarkia;
	private Bezeroa bezeroa;
	private int indexAbestia;

	public vErreprodukzio(String erabiltzaileIzena, Abestia abestia, Album album, Musikari musikari, Bezeroa bezeroa) {
		this.abestia = abestia;
		this.album = album;
		this.musikari = musikari;
		this.bezeroa = bezeroa;
		abestikontagailua = 0;
		erreprodukzioDAO = new ErreproduzioaDAO(album);
		abestiak = AlbumDAO.abestiakLortuAlbumetik(album);
		vIragarkia = new vIragarkia();

		setTitle("Erreprodukzioa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(10, 11, 89, 23);
		contentPane.add(btnAtzera);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vAlbum vAlbumFrame = new vAlbum(erabiltzaileIzena, musikari, album);
				vAlbumFrame.setVisible(true);
				dispose();
			}
		});

		JLabel lblAbestiArgazkia = new JLabel("");
		lblAbestiArgazkia.setBounds(164, 21, 239, 205);
		contentPane.add(lblAbestiArgazkia);
		abestiArgazkia(abestia.getIrudia(), lblAbestiArgazkia);

		JButton btnMenua = new JButton("Menua");
		btnMenua.setBounds(90, 270, 89, 23);
		contentPane.add(btnMenua);

		btnMenua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vMenua menuaFrame = new vMenua(erabiltzaileIzena);
				menuaFrame.setVisible(true);
				dispose();
			}
		});

		JButton btnAurrekoAbesti = new JButton("<");
		btnAurrekoAbesti.setBounds(190, 270, 41, 23);
		contentPane.add(btnAurrekoAbesti);
		btnAurrekoAbesti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasadenAbestia();
			}
		});

		JButton btnHasiAbestia = new JButton("Play");
		btnHasiAbestia.setBounds(241, 270, 89, 23);
		contentPane.add(btnHasiAbestia);
		btnHasiAbestia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopMusic();
				audioErreproduzitu(abestia.getIzena(), lblKontadorea);
			}
		});

		JButton btnHurrengoAbesti = new JButton(">");
		btnHurrengoAbesti.setBounds(340, 270, 41, 23);
		contentPane.add(btnHurrengoAbesti);
		btnHurrengoAbesti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				urrengoAbestia();
			}
		});

		JButton btnGustokoa = new JButton("Gustokoa");
		btnGustokoa.setBounds(391, 270, 89, 23);
		contentPane.add(btnGustokoa);
		btnGustokoa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Id bezeroa eta Id audioa lortu
		        int bezeroaId = Main.bezero.getId_bezeroa(); 
		        int audioId = abestia.getId_audio(); 
		        ErreproduzioaDAO erreproduzioaDAO = new ErreproduzioaDAO();
		        boolean insertOndo = erreproduzioaDAO.gehituGustokoa(bezeroaId, audioId);
		        
		        if (insertOndo) {
		            btnGustokoa.setBackground(Color.GREEN); 
		            JOptionPane.showMessageDialog(null, "Abestia gordeta", "Mezua", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            JOptionPane.showMessageDialog(null, "Errorea gertatu da. Ezin izan da abestia gorde.", "Errorea", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		JButton btnProfila = new JButton(Main.bezero.getErabiltzailea());
		btnProfila.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProfila.setBounds(450, 11, 107, 23);
		contentPane.add(btnProfila);

		lblKantaIzena = new JLabel(abestia.getIzena());
		lblKantaIzena.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKantaIzena.setBounds(240, 237, 151, 23);
		contentPane.add(lblKantaIzena);

		textAreaAbestiInf = new JTextArea();
		textAreaAbestiInf.setBounds(76, 303, 426, 65);
		contentPane.add(textAreaAbestiInf);
		kargatuAlbumInformazioa(textAreaAbestiInf, abestia);

		lblKontadorea = new JLabel("");
		lblKontadorea.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblKontadorea.setBounds(483, 275, 92, 13);
		contentPane.add(lblKontadorea);
		
		

	}
	
	/**
	 * Albumaren informazioa.
	 *
	 * @param textAreaAlbumInf Albumaren informazioa erakutsiko den JTextArea
	 */

	private void kargatuAlbumInformazioa(JTextArea textAreaAlbumInf, Abestia abestia) {
		ErreproduzioaDAO erreproduzioaDAO = new ErreproduzioaDAO();
		Abestia abestiaLortuta = erreproduzioaDAO.abestiaLortu(abestia.getIzena());
		Time iraupena = abestiaLortuta.getIraupena();
		textAreaAlbumInf.setText("Abestiaren iraupena  " + iraupena.toString());

	}
	
	/**
	 * Albumaren irudia.
	 *
	 * @param lblArtistaImg Albumaren irudia erakutsiko den JLabel
	 */

	private void abestiArgazkia(Blob irudiaBlob, JLabel lblArtistaImg) {
		try {
			if (irudiaBlob != null) {
				byte[] irudiaBytes = irudiaBlob.getBytes(1, (int) irudiaBlob.length()); // Irudia byte[] motan bihurtu
				if (irudiaBytes.length > 0) {
					// Irudia ImageIcon formatuan kargatu
					ImageIcon icon = new ImageIcon(irudiaBytes);
					lblArtistaImg.setIcon(icon);
					return;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * Albumaren abestia entzutea.
	 *
	 * @param lblKontadorea abestiaren denbora ikusteko kontadorea  JLabelean
	 * @param abestiIzena abestiaren izena 
	 */

	public Clip audioErreproduzitu(String abestiIzena, JLabel lblKontadorea) {
		try {
			URL urlArchivo = getClass().getClassLoader().getResource("media/" + abestiIzena + ".wav");

			if (urlArchivo == null) {
				System.out.println("Ezin da aurkitu: " + abestiIzena);
				return null;
			}

			if (clip != null && clip.isRunning()) {
				clip.stop();
				clip.close();
			}

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(urlArchivo);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			denbora = 0;
			lblKontadorea.setText("   " + denbora);

			timer = new Timer(1000, e -> {
				denbora++;
				lblKontadorea.setText("   " + denbora);
			});
			timer.start();

			clip.addLineListener((LineListener) new LineListener() {
				public void update(LineEvent event) {
					if (event.getType() == LineEvent.Type.STOP) {
						clip.close();
						timer.stop();
					}
				}
			});

			clip.start();

			return clip;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void stopAudio() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
			clip.close();
			timer.stop();
		}
	}

	public void urrengoAbestia() {
		if (abestiak.isEmpty()) {
			return;
		}

		if (clip != null && clip.isRunning()) {
			clip.stop();
		}

		currentIndex = (currentIndex + 1) % abestiak.size();
		Abestia abestia = abestiak.get(currentIndex);
		clip = audioErreproduzitu(abestia.getIzena(), lblKontadorea);

		lblKantaIzena.setText(abestia.getIzena());
		kargatuAlbumInformazioa(textAreaAbestiInf, abestia);

		if (bezeroa instanceof Free) {
	        abestikontagailua++;

	        
	        if (abestikontagailua >= ABESTI_KONT_IRAGARKI) {
	            iragarkiaIkusi();
	            abestikontagailua = 0;
	        }
		}
	}

	public void pasadenAbestia() {
		if (abestiak.isEmpty()) {
			return;
		}

		if (clip != null && clip.isRunning()) {
			clip.stop();
		}

		currentIndex = (currentIndex - 1 + abestiak.size()) % abestiak.size();
		Abestia abestia = abestiak.get(currentIndex);
		clip = audioErreproduzitu(abestia.getIzena(), lblKontadorea);

		lblKantaIzena.setText(abestia.getIzena());
		kargatuAlbumInformazioa(textAreaAbestiInf, abestia);
	}

	private void iragarkiaIkusi() {
	    // Gorde idizea abestiarena
		indexAbestia = currentIndex;
	    
	    stopMusic(); 
	    vIragarkia.setVisible(true);
	    try {
	        //Iragarkia ateratzea
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("../media/HotWheels.wav"));
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start(); 
	        
	        // Iragarkiaren denbora
	        Timer closeTimer = new Timer(20000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                vIragarkia.dispose(); 
	                // Jarraitu erreproduzioa gordetako abestitik
	                erreproduzituGordekoAbestia();
	            }
	        });
	        closeTimer.setRepeats(false); 
	        closeTimer.start(); 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private void erreproduzituGordekoAbestia() {
	    
	    Abestia gordetakoAbestia = abestiak.get(indexAbestia);
	    
	    
	    clip = audioErreproduzitu(gordetakoAbestia.getIzena(), lblKontadorea);
	    lblKantaIzena.setText(gordetakoAbestia.getIzena());
	    kargatuAlbumInformazioa(textAreaAbestiInf, gordetakoAbestia);
	}

	public void stopMusic() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
			clip.close();
			if (timer != null) {
				timer.stop();
			}
		}
	}
}
