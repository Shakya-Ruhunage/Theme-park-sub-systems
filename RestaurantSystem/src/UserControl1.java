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
		
		JLabel lblPleaseEnterThe = new JLabel("Syver Kade");
		lblPleaseEnterThe.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblPleaseEnterThe.setBounds(22, 67, 188, 27);
		add(lblPleaseEnterThe);
		
		JLabel lblPleaseClickpay = new JLabel("Please click 'Pay' and swipe your band over the scanner to make the payment");
		lblPleaseClickpay.setBounds(22, 192, 371, 14);
		add(lblPleaseClickpay);
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwipeBandDialog sbc = new SwipeBandDialog();
				sbc.setLocationRelativeTo(parent);
				sbc.setModal(true);
				sbc.setVisible(true);
			}
		});
		btnNewButton.setBounds(304, 217, 89, 23);
		add(btnNewButton);
		
		JLabel lblTotalDue = new JLabel("Total Due:");
		lblTotalDue.setBounds(22, 114, 76, 14);
		add(lblTotalDue);
		
		JLabel lblRs = new JLabel("35,000 Rs.");
		lblRs.setBounds(134, 114, 76, 14);
		add(lblRs);

	}
}
