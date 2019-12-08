package view;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
//import com.toedter.calendar.JDateChooser;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JScrollPane;
//import com.toedter.calendar.JMonthChooser;

import controller.KullaniciController;
import model.Kullanici;
import model.Yetki;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JCheckBox;
import javax.swing.JList;

public class YoneticiKullaniciBilgi extends JFrame {

	private JPanel contentPane;
	int pX, pY;

	JPanel panelMenu;
	JPanel icerikPanel;
	JPanel panel_2;
	JPanel panel_3;
	private JTextField tfAdKayit;
	private JTextField tfMailKayit;
	private JTextField tfAd;
	private JTextField tfEmail;
	private JTextField tfYetki;
	private JTable table;
	private JTextField textField_20;
	private JTextField tfSifreKayit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YoneticiKullaniciBilgi frame = new YoneticiKullaniciBilgi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public YoneticiKullaniciBilgi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 698);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 179, 113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel frameDrag = new JLabel("");
		frameDrag.setBounds(0, 0, 932, 35);
		frameDrag.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pX = e.getX();
				pY = e.getY();
			}
		});
		frameDrag.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x + e.getX() - pX, getLocation().y + e.getY() - pY);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(frameDrag);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(931, 0, 28, 35);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		label_1.setIcon(new ImageIcon(YoneticiKullaniciBilgi.class.getResource("/kucult.png")));
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(957, 0, 28, 35);

		label_2.setIcon(new ImageIcon(YoneticiKullaniciBilgi.class.getResource("/kapat.png")));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(label_2);

		JLabel lblNewLabel = new JLabel("ANA MENU");
		lblNewLabel.setBounds(798, 659, 134, 28);

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setIcon(new ImageIcon(YoneticiMenu.class.getResource("/cikis.png")));
		lblNewLabel.setForeground(new Color(72, 61, 139));
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
				YoneticiMenu yoneticiMenu = new YoneticiMenu();
				yoneticiMenu.setVisible(true);
			}
		});
		contentPane.add(lblNewLabel);

		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		panelMenu.setBackground(new Color(60, 179, 113));
		panelMenu.setBounds(23, 72, 99, 581);
		contentPane.add(panelMenu);
		panelMenu.setLayout(new GridLayout(0, 1, 0, 0));

		JButton button = new JButton();
		button.setIcon(new ImageIcon(Login.class.getResource("/personelekle.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icerikPanel.removeAll();
				icerikPanel.repaint();
				icerikPanel.revalidate();

				icerikPanel.add(panel_2);
				icerikPanel.repaint();
				icerikPanel.revalidate();

			}
		});
		button.setBackground(SystemColor.menu);
		panelMenu.add(button);

		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/personelara.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icerikPanel.removeAll();
				icerikPanel.repaint();
				icerikPanel.revalidate();

				icerikPanel.add(panel_3);
				icerikPanel.repaint();
				icerikPanel.revalidate();

			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(240, 240, 240));
		panelMenu.add(btnNewButton);

		icerikPanel = new JPanel();
		icerikPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		icerikPanel.setBackground(new Color(60, 179, 113));
		icerikPanel.setBounds(156, 72, 776, 581);
		contentPane.add(icerikPanel);
		icerikPanel.setLayout(new CardLayout(0, 0));

		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		panel_2.setBackground(new Color(0, 250, 154));
		icerikPanel.add(panel_2, "name_4516788086034");
		panel_2.setLayout(null);

		JLabel lblAd = new JLabel("Ad*");
		lblAd.setBounds(28, 41, 59, 14);
		panel_2.add(lblAd);

		tfAdKayit = new JTextField();
		tfAdKayit.setBounds(122, 38, 136, 20);
		panel_2.add(tfAdKayit);
		tfAdKayit.setColumns(10);

		JLabel label_4 = new JLabel("Mail Adresi*");
		label_4.setBounds(28, 124, 73, 14);
		panel_2.add(label_4);

		tfMailKayit = new JTextField();
		tfMailKayit.setColumns(10);
		tfMailKayit.setBounds(122, 121, 136, 20);
		panel_2.add(tfMailKayit);

		JLabel label_5 = new JLabel("G\u00F6rev");
		label_5.setBounds(41, 194, 46, 14);
		panel_2.add(label_5);

		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setIcon(new ImageIcon(YoneticiKullaniciBilgi.class.getResource("/kaydet.png")));
		btnKaydet.setBounds(209, 483, 102, 23);
		panel_2.add(btnKaydet);
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kullanici kullanici = new Kullanici();
				//kullanici.ad = 
			}
		});

		JLabel lblPersonelKayt = new JLabel("Kullanici Kay\u0131t");
		lblPersonelKayt.setForeground(Color.WHITE);
		lblPersonelKayt.setFont(new Font("Gabriola", Font.BOLD | Font.ITALIC, 25));
		lblPersonelKayt.setBounds(241, 0, 125, 27);
		panel_2.add(lblPersonelKayt);

		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.setIcon(new ImageIcon(YoneticiKullaniciBilgi.class.getResource("/sil2.png")));
		btnTemizle.setBounds(393, 483, 102, 23);
		panel_2.add(btnTemizle);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Se\u00E7iniz", "1-Y\u00F6netici",
				"2-\u00DCretim M\u00FCd\u00FCr\u00FC", "3-Depo G\u00F6revlisi", "4-Di\u011Fer" }));
		comboBox.setBounds(122, 191, 136, 20);
		panel_2.add(comboBox);

		JLabel lblSifreKayit = new JLabel("\u015Eifre");
		lblSifreKayit.setBounds(28, 77, 46, 14);
		panel_2.add(lblSifreKayit);

		tfSifreKayit = new JTextField();
		tfSifreKayit.setColumns(10);
		tfSifreKayit.setBounds(122, 74, 136, 20);
		panel_2.add(tfSifreKayit);
		
		JCheckBox cbHesapOlustur = new JCheckBox("Hesap olu\u015Ftur");
		cbHesapOlustur.setBounds(270, 150, 97, 23);
		panel_2.add(cbHesapOlustur);

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 250, 154));
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		icerikPanel.add(panel_3, "name_4532427943942");
		panel_3.setLayout(null);

		JLabel label_11 = new JLabel("Ad");
		label_11.setBounds(10, 236, 59, 14);
		panel_3.add(label_11);

		tfAd = new JTextField();
		tfAd.setColumns(10);
		tfAd.setBounds(104, 233, 136, 20);
		KeyListener keyListener = new KeyListener() {
			public boolean run = false;

			public void keyPressed(KeyEvent keyEvent) {
				// printIt("Pressed", keyEvent);
				run = true;
			}

			public void keyReleased(KeyEvent keyEvent) {
				// printIt("Released", keyEvent);
				if (run) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					//ArrayList<Kullanici> bulunan = KullaniciController.Ara(tfAd2.getText(), tfSoyad2.getText());

					//for (int i = 0; i < bulunan.size(); i++) {
					//	model.addRow(new Object[] {bulunan.get(i).TCno, bulunan.get(i).ad, bulunan.get(i).soyad, bulunan.get(i).dogumTarihi,
					//			bulunan.get(i).email,bulunan.get(i).tel1,bulunan.get(i).adres,bulunan.get(i).unvan,bulunan.get(i).maas});
					//}
					run = false;
				}
			}

			public void keyTyped(KeyEvent keyEvent) {
				// printIt("Typed", keyEvent);
			}
		};

		tfAd.addKeyListener(keyListener);

		panel_3.add(tfAd);

		JLabel label_15 = new JLabel("Mail Adresi");
		label_15.setBounds(10, 265, 73, 14);
		panel_3.add(label_15);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(104, 262, 136, 20);
		panel_3.add(tfEmail);

		JLabel lblYetki = new JLabel("Yetki");
		lblYetki.setBounds(10, 290, 46, 14);
		panel_3.add(lblYetki);

		tfYetki = new JTextField();
		tfYetki.setColumns(10);
		tfYetki.setBounds(104, 293, 136, 20);
		panel_3.add(tfYetki);

		JButton button_3 = new JButton("Ekle");
		button_3.setBounds(181, 618, 89, 23);
		panel_3.add(button_3);

		JButton button_4 = new JButton("G\u00FCncelle");
		button_4.setBounds(239, 666, 114, 22);
		panel_3.add(button_4);

		JButton button_5 = new JButton("Sil");
		button_5.setBounds(322, 618, 89, 23);
		panel_3.add(button_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 752, 149);
		panel_3.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Ad", "Email","Yetki" }));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				try {
					tfAd.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
					tfEmail.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
					tfYetki.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
					
				} catch (ArrayIndexOutOfBoundsException ex) {
				}
			}
		});
		ArrayList<Kullanici> liste = KullaniciController.Yenile(Yetki.HEPSI);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		for (int i = 0; i < liste.size(); i++) {
			model.addRow(new Object[] {liste.get(i).ad, liste.get(i).email,Yetki.toString(liste.get(i).yetki)});
		
		scrollPane.setViewportView(table);

		JLabel label_22 = new JLabel("Personel Listesi");
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Gabriola", Font.BOLD | Font.ITALIC, 25));
		label_22.setBounds(258, 0, 153, 27);
		panel_3.add(label_22);

		JLabel label_36 = new JLabel("Telefon");
		label_36.setBounds(10, 352, 46, 14);
		panel_3.add(label_36);

		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(104, 349, 136, 20);
		panel_3.add(textField_20);

		JLabel label_34 = new JLabel("");
		label_34.setIcon(new ImageIcon(YoneticiKullaniciBilgi.class.getResource("/search.png")));
		label_34.setBounds(279, 204, 46, 14);
		panel_3.add(label_34);

		JButton button_2 = new JButton("G\u00FCncelle");
		button_2.setBounds(536, 429, 89, 23);
		panel_3.add(button_2);

		JButton button_7 = new JButton("Sil");
		button_7.setBounds(536, 481, 89, 23);
		panel_3.add(button_7);
		
		JCheckBox chckSilinenler = new JCheckBox("Silinenler dahil");
		chckSilinenler.setSelected(true);
		chckSilinenler.setBounds(420, 200, 123, 23);
		panel_3.add(chckSilinenler);
		
		chckSilinenler.addItemListener(new ItemListener() {
		      public void itemStateChanged(ItemEvent e) {
		        if(chckSilinenler.isSelected())
		        {
		        	
		        	DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
		        	ArrayList<Kullanici> liste = KullaniciController.Yenile(Yetki.HEPSI);
		    		for (int i = 0; i < liste.size(); i++) {
		    			model.addRow(new Object[] {liste.get(i).ad, liste.get(i).email, Yetki.toString(liste.get(i).yetki)});
		    		}
		        }
		        else
		        {
		        	DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
		        
		        	ArrayList<Kullanici> liste = KullaniciController.Yenile(Yetki.GECERLI);
		    		for (int i = 0; i < liste.size(); i++) {
		    			model.addRow(new Object[] {liste.get(i).ad, liste.get(i).email, Yetki.toString(liste.get(i).yetki)});
		    		}
		        }
		      }
		    });

		setUndecorated(true);
		setLocationRelativeTo(null);

	}
}
}