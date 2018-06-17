import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class UserControl1 extends JPanel {
	JFrame parent;
	/**
	 * Create the panel.
	 */
	public UserControl1(JFrame parent) {
		this.parent = parent;
		setLayout(null);
		
		JLabel lblCustomerRegistration = new JLabel("Welcome");
		lblCustomerRegistration.setOpaque(true);
		lblCustomerRegistration.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCustomerRegistration.setBorder(new EmptyBorder(0, 10, 0, 0));
		lblCustomerRegistration.setBackground(SystemColor.scrollbar);
		lblCustomerRegistration.setBounds(0, 0, 609, 34);
		add(lblCustomerRegistration);
		
		JLabel lblPleaseEnterThe = new JLabel("Price for a session is 1000 Rs.");
		lblPleaseEnterThe.setBounds(22, 80, 188, 14);
		add(lblPleaseEnterThe);
		
		JLabel lblPleaseClickpay = new JLabel("Please click 'Pay' and swipe your band over the scanner to make the payment");
		lblPleaseClickpay.setBounds(22, 95, 405, 14);
		add(lblPleaseClickpay);
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwipeBandDialog sbc = new SwipeBandDialog();
				sbc.setAmount(1000);
				sbc.setLocationRelativeTo(parent);
				sbc.setModal(true);
				sbc.setVisible(true);
			}
		});
		btnNewButton.setBounds(338, 180, 89, 23);
		add(btnNewButton);

	}
}
