import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class SuccessfulDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SuccessfulDialog dialog = new SuccessfulDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SuccessfulDialog() {
		setResizable(false);
		setBounds(100, 100, 476, 254);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(350, 182, 100, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\if_Tick_Mark_1398911.png"));
		lblNewLabel.setBounds(28, 42, 64, 64);
		contentPanel.add(lblNewLabel);
		
		JLabel lblSuccess = new JLabel("Success");
		lblSuccess.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblSuccess.setBounds(133, 42, 100, 30);
		contentPanel.add(lblSuccess);
		
		JLabel lblYourTransactionHas = new JLabel("Your transaction has been completed successfully");
		lblYourTransactionHas.setBounds(133, 83, 265, 14);
		contentPanel.add(lblYourTransactionHas);
	}
}
