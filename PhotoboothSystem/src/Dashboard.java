import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	JPanel panelMain;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
					Dashboard frame = new Dashboard();
					Helper.setWindowOnMiddle(frame);
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
	public Dashboard() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(0, 34, 200, 435);
		contentPane.add(panel);
		
		JLabel lblCustomerRegistration_1 = new JLabel("Welcome");
		lblCustomerRegistration_1.setOpaque(true);
		lblCustomerRegistration_1.setBorder(new EmptyBorder(0,10,0,0));
		lblCustomerRegistration_1.setBackground(SystemColor.controlHighlight);
		lblCustomerRegistration_1.setBounds(0, 11, 212, 30);
		lblCustomerRegistration_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				lblCustomerRegistration_1.setBackground(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				lblCustomerRegistration_1.setBackground(Color.LIGHT_GRAY);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				panelMain.removeAll();
				UserControl1 uc = new UserControl1(Dashboard.this);
				uc.setBounds(0, 0, panelMain.getWidth(), panelMain.getHeight());
				panelMain.add(uc);
				panelMain.updateUI();
			}
		});
		panel.add(lblCustomerRegistration_1);
		
		JLabel lblCashier = new JLabel("Photo Booth");
		lblCashier.setOpaque(true);
		lblCashier.setHorizontalAlignment(SwingConstants.CENTER);
		lblCashier.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCashier.setBackground(SystemColor.scrollbar);
		lblCashier.setBounds(0, 0, 200, 34);
		contentPane.add(lblCashier);
		
		panelMain = new JPanel();
		panelMain.setLayout(null);
		panelMain.setBounds(210, 0, 609, 459);
		contentPane.add(panelMain);
	}
}
