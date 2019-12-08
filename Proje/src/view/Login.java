package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import model.Yetki;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;

public class Login extends JPanel {

	private JTextField TextFielduserName;
	private JPasswordField TextfieldpassWord;
	private JTextField BtnGiris;
	private JTextField BtniPtal;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl0;
	private JLabel BtnSifreUnuttum;
	private JLabel image;
	private JLabel frameDrag;
	int pX;
	int pY;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 650, 430);
		setBackground(new Color(30, 144, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		setLayout(null);
		
		frameDrag = new JLabel("");
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
				 setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
			}
		});
		
		frameDrag.setBounds(0, 0, 562, 31);
		add(frameDrag);
		
		lbl0 = new JLabel("OTEL REZARVASYON SÝS. GÝRÝÞ");
		lbl0.setForeground(new Color(255, 255, 255));
		lbl0.setHorizontalAlignment(SwingConstants.CENTER);
		lbl0.setFont(new java.awt.Font("Gabriola", 7, 25));
		lbl0.setBounds(122, 11, 279, 69);
		add(lbl0);
		
		TextFielduserName = new JTextField();
		TextFielduserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TextFielduserName.setBounds(359, 126, 248, 41);
		add(TextFielduserName);
		TextFielduserName.setColumns(10);
		
		TextfieldpassWord = new JPasswordField();
		TextfieldpassWord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TextfieldpassWord.setBounds(359, 190, 248, 41);
		add(TextfieldpassWord);
		
		BtnGiris = new JTextField();
		BtnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		BtnGiris.setForeground(new Color(255, 255, 255));
		BtnGiris.setBackground(new Color(70, 130, 180));
		BtnGiris.setFocusTraversalPolicyProvider(true);
		BtnGiris.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnGiris.setFont(new java.awt.Font("Gabriola", 3, 20));
		//loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BtnGiris.setHorizontalAlignment(SwingConstants.CENTER);
		BtnGiris.setText("G\u0130R\u0130\u015E");
		BtnGiris.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		BtnGiris.setEditable(false);
		BtnGiris.setBounds(359, 282, 111, 41);
		add(BtnGiris);
		BtnGiris.setColumns(10);
		BtnGiris.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			
				LoginController.Giris(TextFielduserName.getText(), TextfieldpassWord.getText());
				
				if(LoginController.simdikiKullanici.yetki != Yetki.YETKISIZ)
				{
					System.out.println("login");

					Application.BilgiKutusu("Giris Basarili", "Hosgeldiniz");
				}
				else
				{
					Application.BilgiKutusu("Giris Basarisiz", "Sifrenizi Kontrol edin!");
				}
				
			}
		});
		
		BtniPtal = new JTextField();
		BtniPtal.setForeground(new Color(255, 255, 255));
		BtniPtal.setBackground(new Color(250, 128, 114));
		BtniPtal.setDisabledTextColor(new Color(255, 127, 80));
		BtniPtal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//cikis
			}
		});
		BtniPtal.setFocusTraversalPolicyProvider(true);
		BtniPtal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		BtniPtal.setFont(new java.awt.Font("Gabriola", 3, 20));
		BtniPtal.setHorizontalAlignment(SwingConstants.CENTER);
		BtniPtal.setText("\u0130PTAL");
		BtniPtal.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		BtniPtal.setEditable(false);
		BtniPtal.setColumns(10);
		BtniPtal.setBounds(496, 282, 111, 41);
		add(BtniPtal);
		lbl2 = new JLabel("");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setIcon(new ImageIcon(ClassLoader.getSystemResource("usr.png")));
		lbl2.setBounds(250, 126, 59, 41);
		add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setIcon(new ImageIcon(ClassLoader.getSystemResource("pass.png")));
		lbl3.setBounds(250, 192, 59, 41);
		add(lbl3);
		
		image = new JLabel("");
		image.setIcon(new ImageIcon(Login.class.getResource("/login.png")));
		image.setBounds(0, 92, 234, 257);
		add(image);
		
		BtnSifreUnuttum = new JLabel("\u015Eifremi Unuttum!");
		BtnSifreUnuttum.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//dispose();
				SifremiUnuttum sifremiUnuttum = new  SifremiUnuttum();
				sifremiUnuttum.setVisible(true);
			}
		});
		BtnSifreUnuttum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnSifreUnuttum.setFont(new Font("Tahoma", Font.ITALIC, 13));
		BtnSifreUnuttum.setBounds(432, 357, 111, 14);
		add(BtnSifreUnuttum);
		//setUndecorated(true);//remove the frame outline
		//setLocationRelativeTo(null);
		
	}
}
