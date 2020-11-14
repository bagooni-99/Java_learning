package bagooni;

import javax.swing.*;
import java.awt.*;

class NorthPanel_1 extends JPanel {
	public NorthPanel_1() {
		setBackground(Color.LIGHT_GRAY);
		add(new JButton("열기"));
		add(new JButton("닫기"));
		add(new JButton("나가기"));
		setLayout(new FlowLayout());
	}
}

class CenterPanel_1 extends JPanel {
	public CenterPanel_1() {
		setLayout(null);
		
		for (int i = 0; i < 10; i++) {
			JLabel label = new JLabel("*");
			int x = (int) (Math.random() * 200) + 10;
			int y = (int) (Math.random() * 200) + 10;
			label.setSize(20,20);
			label.setOpaque(true);
			label.setForeground(Color.RED);
			label.setLocation(x, y);
			add(label);
		}
	}
}

class SouthPanel_1 extends JPanel {
	public SouthPanel_1() {
		setBackground(Color.yellow);
		add(new JButton("Word Input"));
		add(new JTextField(16));
		setLayout(new FlowLayout());
	}
}

public class num9_8 extends JFrame {
	public num9_8() {
		setTitle("여러 개의 패널을 가진 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		c.add(new NorthPanel_1(), BorderLayout.NORTH);
		c.add(new CenterPanel_1(), BorderLayout.CENTER);
		c.add(new SouthPanel_1(), BorderLayout.SOUTH);

		setSize(350, 350);
		setVisible(true);
	}

	public static void main(String[] args) {
		new num9_8();
	}

}
