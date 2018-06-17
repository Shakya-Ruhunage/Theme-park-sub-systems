import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Helper {
	public static void setWindowOnMiddle(JFrame frame) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int)(d.getWidth()/2) - (frame.getWidth()/2);
		int y = (int)(d.getHeight()/2) - (frame.getHeight()/2);
		frame.setLocation(x, y);
	}
}
