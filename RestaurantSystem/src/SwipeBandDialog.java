import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwipeBandDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSlaughterhouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SwipeBandDialog dialog = new SwipeBandDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SwipeBandDialog() {
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 516, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\if_finger-zoom_1291758.png"));
			lblNewLabel.setBounds(218, 33, 64, 64);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblPleaseHoverYour = new JLabel("Please hover your wrist band over the scanner");
			lblPleaseHoverYour.setHorizontalAlignment(SwingConstants.CENTER);
			lblPleaseHoverYour.setBounds(34, 138, 431, 14);
			contentPanel.add(lblPleaseHoverYour);
		}
		{
			JButton okButton = new JButton("Verify");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					SuccessfulDialog sd = new SuccessfulDialog();
					sd.setModal(true);
					sd.setVisible(true);
				}
			});
			okButton.setBounds(206, 229, 88, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			txtSlaughterhouse = new JTextField();
			txtSlaughterhouse.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			txtSlaughterhouse.setHorizontalAlignment(SwingConstants.CENTER);
			txtSlaughterhouse.setText("00313");
			txtSlaughterhouse.setBounds(187, 170, 125, 35);
			contentPanel.add(txtSlaughterhouse);
			txtSlaughterhouse.setColumns(10);
		}
	}

}
