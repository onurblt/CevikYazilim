package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.sun.javafx.font.Disposer;

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

public class SifremiUnuttum extends JFrame {

	private JPanel contentPane;
	private JTextField TextFielduserName;
	private JTextField BtnGiris;
	private JTextField BtniPtal;
	private JLabel lbl2;
	private JLabel lbl0;
	private JLabel BtnClose;
	private JLabel frameDrag;
	int pX;
	int pY;
	private JLabel BtnMinimize;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SifremiUnuttum frame = new SifremiUnuttum();
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
	public SifremiUnuttum() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 650, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		contentPane.add(frameDrag);
		
		BtnMinimize = new JLabel("");
		BtnMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		BtnMinimize.setIcon(new ImageIcon(SifremiUnuttum.class.getResource("/kucult.png")));
		BtnMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		BtnMinimize.setForeground(Color.WHITE);
		BtnMinimize.setFont(new Font("Tahoma", Font.BOLD, 15));
		BtnMinimize.setBounds(591, 0, 30, 31);
		contentPane.add(BtnMinimize);
		
		BtnClose = new JLabel("");
		BtnClose.setIcon(new ImageIcon(SifremiUnuttum.class.getResource("/kapat.png")));
		BtnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		BtnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClose.setForeground(new Color(255, 255, 255));
		BtnClose.setHorizontalAlignment(SwingConstants.CENTER);
		BtnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		BtnClose.setBounds(620, 0, 30, 31);
		contentPane.add(BtnClose);
		
		lbl0 = new JLabel("    S\u0130FREM\u0130 UNUTTUM");
		lbl0.setForeground(new Color(255, 255, 255));
		lbl0.setHorizontalAlignment(SwingConstants.CENTER);
		lbl0.setFont(new java.awt.Font("Gabriola", 7, 25));
		lbl0.setBounds(188, 11, 279, 69);
		contentPane.add(lbl0);
		
		TextFielduserName = new JTextField();
		TextFielduserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TextFielduserName.setBounds(219, 113, 248, 41);
		contentPane.add(TextFielduserName);
		TextFielduserName.setColumns(10);
		
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
		//SifremiUnuttumBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BtnGiris.setHorizontalAlignment(SwingConstants.CENTER);
		BtnGiris.setText("Gönder");
		BtnGiris.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		BtnGiris.setEditable(false);
		BtnGiris.setBounds(219, 220, 111, 41);
		contentPane.add(BtnGiris);
		BtnGiris.setColumns(10);
		
		BtniPtal = new JTextField();
		BtniPtal.setForeground(new Color(255, 255, 255));
		BtniPtal.setBackground(new Color(250, 128, 114));
		BtniPtal.setDisabledTextColor(new Color(255, 127, 80));
		BtniPtal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		BtniPtal.setFocusTraversalPolicyProvider(true);
		BtniPtal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		BtniPtal.setFont(new java.awt.Font("Gabriola", 3, 20));
		BtniPtal.setHorizontalAlignment(SwingConstants.CENTER);
		BtniPtal.setText("ÝptaL");
		BtniPtal.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		BtniPtal.setEditable(false);
		BtniPtal.setColumns(10);
		BtniPtal.setBounds(356, 220, 111, 41);
		contentPane.add(BtniPtal);
		lbl2 = new JLabel("Mail Adresiniz:");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setIcon(new ImageIcon(ClassLoader.getSystemResource("usr.png")));
		lbl2.setBounds(10, 113, 159, 41);
		contentPane.add(lbl2);
		setUndecorated(true);//remove the frame outline
		setLocationRelativeTo(null);
		
	}
}
