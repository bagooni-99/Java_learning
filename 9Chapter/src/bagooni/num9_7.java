package bagooni;

import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel {
	public NorthPanel() {
		setBackground(Color.LIGHT_GRAY);
		add(new JLabel("수식입력"));
		add(new JTextField(16));
		setLayout(new FlowLayout());
	}
}

class CenterPanel extends JPanel {
	JButton b[] = { new JButton("+"), new JButton("-"), new JButton("x"), new JButton("/") };

	public CenterPanel() {
		JButton button = new JButton();
		setLayout(new GridLayout(4, 4, 2, 2));

		for (int i = 0; i < 10; i++) {
			button = new JButton(Integer.toString(i));
			add(button);
		}
		add(new JButton("CE"));
		add(new JButton("계산"));

		for (int i = 0; i < b.length; i++) {
			b[i].setBackground(Color.BLUE);
			b[i].setOpaque(true);
			add(b[i]);
		}
	}
}

class SouthPanel extends JPanel {
	public SouthPanel() {
		setBackground(Color.yellow);
		add(new JLabel("계산결과"));
		add(new JTextField(16));
		setLayout(new FlowLayout());
	}
}

public class num9_7 extends JFrame {
	public num9_7() {
		setTitle("계산기 프레임");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new num9_7();
	}
}
