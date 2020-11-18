package bagooni;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Chapter_10_2 extends JFrame {
	public Chapter_10_2() {
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 150);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());
		c.add(btn);

		setVisible(true);
	}

	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("Action"))
				b.setText("액션");
			else
				b.setText("Action");
			
			Chapter_10_2.this.setTitle(b.getText());
		}

	}

	public static void main(String[] args) {
		new Chapter_10_2();
	}
}
