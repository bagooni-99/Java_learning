package bagooni;

import java.awt.*;
import javax.swing.*;

public class num9_4 extends JFrame {
	Color[] color = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.MAGENTA,
			Color.GRAY, Color.WHITE, Color.CYAN };

	public num9_4() {
		setTitle("Ten Color Buttons Frame");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new GridLayout(1,10));
		JButton b[] = new JButton[10];
		
		for (int i = 0; i < 10; i++) {
			b[i] = new JButton(Integer.toString(i));
			b[i].setOpaque(true); // 배경색 변경가능
			b[i].setBackground(color[i]);
			c.add(b[i]);
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		new num9_4();
	}

}
