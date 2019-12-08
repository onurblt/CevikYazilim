package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseMotionAdapter;

public class YoneticiMenu extends JFrame {

	private JPanel contentPane;
	int pX,pY;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YoneticiMenu frame = new YoneticiMenu();
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
	public YoneticiMenu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 179, 113));
		setTitle("Yönetici Giriþi");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel frameDrag = new JLabel("");
		frameDrag.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
			}
		});
		frameDrag.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pX = e.getX();
				pY = e.getY();
			}
		});
		frameDrag.setBounds(0, 0, 696, 35);
		contentPane.add(frameDrag);
		
		JLabel BtnClose = new JLabel("");
		BtnClose.setIcon(new ImageIcon(YoneticiMenu.class.getResource("/kapat.png")));
		BtnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		
		JLabel BtnMinimize = new JLabel("");
		BtnMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		BtnMinimize.setIcon(new ImageIcon(YoneticiMenu.class.getResource("/kucult.png")));
		BtnMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		BtnMinimize.setBounds(699, 0, 28, 27);
		contentPane.add(BtnMinimize);
		BtnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnClose.setForeground(new Color(255, 255, 255));
		BtnClose.setHorizontalAlignment(SwingConstants.CENTER);
		BtnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		BtnClose.setBounds(725, 0, 28, 27);
		contentPane.add(BtnClose);
		
		JLabel BtnKullaniciBilgi = new JLabel("");
		BtnKullaniciBilgi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnKullaniciBilgi.setHorizontalAlignment(SwingConstants.CENTER);
		BtnKullaniciBilgi.setIcon(new ImageIcon(YoneticiMenu.class.getResource("/musteri.png")));
		BtnKullaniciBilgi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				setVisible(false);
				YoneticiKullaniciBilgi bilgi = new YoneticiKullaniciBilgi();
				bilgi.setVisible(true);
			}
		});
		
		JLabel BtnExit = new JLabel("\u00C7IKI\u015E");
		BtnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		BtnExit.setIcon(new ImageIcon(YoneticiMenu.class.getResource("/cikis.png")));
		BtnExit.setHorizontalAlignment(SwingConstants.CENTER);
		BtnExit.setForeground(new Color(72, 61, 139));
		BtnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BtnExit.setBounds(664, 565, 79, 35);
		contentPane.add(BtnExit);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
	}
}
