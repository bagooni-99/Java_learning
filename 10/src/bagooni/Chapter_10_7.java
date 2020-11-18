package bagooni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chapter_10_7 extends JFrame {
	private JLabel la = new JLabel();
	
	public Chapter_10_7() {
		setTitle("key Code 예제 : F1키:초록색, % 키 노란색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addKeyListener(new MyKeyListener());
		c.add(la);
		
		setSize(300,150);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			Container c = (Container)e.getSource();
			
			la.setText(KeyEvent.getKeyText(e.getKeyCode())+"키가 입력되었음");
			
			if(e.getKeyChar() == '%')
				c.setBackground(Color.yellow);
			else if(e.getKeyCode() == KeyEvent.VK_F1)
				c.setBackground(Color.GREEN);
		}
	}
	
	public static void main(String[] args) {
		new Chapter_10_7();
	}

}
