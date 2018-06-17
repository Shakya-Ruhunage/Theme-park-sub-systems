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
	private JTextField textField;
	private JTextField textField_1;
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
		
		JButton btnEdit = new JButton("Proceed");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwipeBandDialog sbc = new SwipeBandDialog();
				sbc.setLocationRelativeTo(parent);
				sbc.setModal(true);
				sbc.setVisible(true);
			}
		});
		btnEdit.setBounds(175, 219, 89, 23);
		add(btnEdit);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the following details:");
		lblPleaseEnterThe.setBounds(22, 80, 188, 14);
		add(lblPleaseEnterThe);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(22, 100, 396, 1);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Number of Adults:");
		lblNewLabel.setBounds(22, 132, 106, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number of Kids:");
		lblNewLabel_1.setBounds(22, 169, 89, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(121, 129, 143, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 166, 143, 20);
		add(textField_1);
		textField_1.setColumns(10);

	}
}
