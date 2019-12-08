package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import nku.sistemanalizi.marangoz.controller.DB;
import controller.LoginController;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FilenameFilter;

public class Application extends JFrame {
	
	//Where instance variables are declared:
	static JPanel cards;
	public final static String LOGIN_PANEL = "Login";
	public final static String YONETICI_PANEL = "YoneticiMenu";
	public final static String SIFREMI_UNUTTUM_PANEL = "Sifremi Unuttum";
	public static Application theApp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					theApp=frame;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Application()
	{

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
	    //setUndecorated(true);
		setBounds(0, 0, 700, 600);
		
		//Create the panel that contains the "cards".
		cards = new JPanel(new CardLayout());
		cards.add(new view.Login(), LOGIN_PANEL);
		//cards.add(new SifremiUnuttum(), SIFREMI_UNUTTUM_PANEL);
		//cards.add(new YoneticiMenu(), YONETICI_PANEL);
		
		setContentPane(cards);
		//addComponentsToPane(getContentPane());
		//pack();
		setVisible(true);
		ChangePanel( LOGIN_PANEL);
		
	}
	//Method came from the ItemListener class implementation,
	//contains functionality to process the combo box item selecting
	public static void ChangePanel(String panelName) {
	    CardLayout cl = (CardLayout)(cards.getLayout());
	    cl.show(cards, panelName);
	}
	
	public static Application GetInstance()
	{
		return theApp;
	}
	public static void BilgiKutusu(String titleBar,String infoMessage )
	{
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
	public static boolean OnayKutusu(String titleBar,String infoMessage)
	{
		int reply = JOptionPane.showConfirmDialog(null, infoMessage, titleBar, JOptionPane.OK_CANCEL_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
	          return true;
	    }
	    else {
	    	return false;
	    }
	}
	public static String GetDosyaAdi()
	{
		FileDialog fd = new FileDialog(GetInstance(), "Yuklemek istediginiz dosyayi secin", FileDialog.LOAD);
		fd.setDirectory("C:\\");
		fd.setVisible(true);
		String filename = fd.getFile();
	
		if (filename == null)
		{
		  System.out.println("You cancelled the choice");
		}else
		{
		  System.out.println("You chose " + filename);
		}
		return filename;
	}
}
