package bagooni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GamePanel extends JPanel {
	public static JLabel message = new JLabel("시작합니다.");
	public static JLabel[] label = new JLabel[3];

	public GamePanel() {
		setLayout(null);
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel("0");
			label[i].setSize(70, 40);
			label[i].setOpaque(true);
			label[i].setBackground(Color.pink);
			label[i].setForeground(Color.yellow);
			label[i].setFont(new Font("Malgon Gothic", Font.ITALIC, 30));
			label[i].setHorizontalAlignment(JLabel.CENTER);
			label[i].setLocation(110 * i + 50, 50);
			add(label[i]);
		}
		message.setSize(100,40);
		message.setLocation(160,150);
		message.setFont(new Font(null, Font.BOLD,15));
		add(message);
		
		addKeyListener(new MyKeyListener());
	}
}

class MyKeyListener extends KeyAdapter{
	private int x,y,z;
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == '\n') {
			x = (int)(Math.random()*5);
			y = (int)(Math.random()*5);
			z = (int)(Math.random()*5);
			GamePanel.label[0].setText(Integer.toString(x));
			GamePanel.label[1].setText(Integer.toString(y));
			GamePanel.label[2].setText(Integer.toString(z));
		}
		if(x==y && y==z)
			GamePanel.message.setText("축하합니다!!");
		else
			GamePanel.message.setText("아쉽군요");
	}
}

public class Chapter_10_Openchallenge extends JFrame {
	public Chapter_10_Openchallenge() {
		setTitle("Open Challenge 10");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(new GamePanel());
		Container c = getContentPane();
		c.setFocusable(true);
		c.requestFocus();

		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Chapter_10_Openchallenge();
	}
}
