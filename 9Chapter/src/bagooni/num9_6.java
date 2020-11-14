package bagooni;

import java.awt.*;
import javax.swing.*;

public class num9_6 extends JFrame {
	public num9_6() {
		setTitle("Random Labels");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel();
		Container c = getContentPane();
		c.setLayout(null);
		
		for (int i = 0; i < 20; i++) {
			label=new JLabel(Integer.toString(i));
			int x = (int) (Math.random() * 200) + 50;
			int y = (int) (Math.random() * 200) + 50;
			label.setLocation(x, y);
			label.setSize(10, 10);
			label.setOpaque(true);
			label.setBackground(Color.BLUE);
			c.add(label);
		}

		setVisible(true);
	}

	public static void main(String[] args) {
		new num9_6();
	}

}
