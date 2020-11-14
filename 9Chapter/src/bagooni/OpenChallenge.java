package bagooni;

import javax.swing.*;
import java.awt.*;

class NorthPanel_2 extends JPanel {
	public NorthPanel_2() {
		setBackground(Color.LIGHT_GRAY);
		add(new JButton("Open"));
		add(new JButton("Read"));
		add(new JButton("Close"));
		setLayout(new FlowLayout());
	}
}

class CenterPanel_2 extends JPanel {
	public CenterPanel_2() {
		setLayout(null);
		JLabel label[] = { new JLabel("Hello"), new JLabel("Java"), new JLabel("Love") };
		for (int i = 0; i < 3; i++) {
			int x = (int) (Math.random() * 200) + 10;
			int y = (int) (Math.random() * 200) + 10;
			label[i].setSize(100, 100);
			label[i].setLocation(x, y);
			add(label[i]);
		}
	}
}

public class OpenChallenge extends JFrame {
	public OpenChallenge() {
		setTitle("Open Challenge 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		c.add(new NorthPanel_2(), BorderLayout.NORTH);
		c.add(new CenterPanel_2(), BorderLayout.CENTER);

		setSize(350, 350);
		setVisible(true);
	}

	public static void main(String[] args) {
		new OpenChallenge();
	}

}
