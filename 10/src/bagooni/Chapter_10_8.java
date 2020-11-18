package bagooni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chapter_10_8 extends JFrame {
	private final int distance = 10;
	private JLabel la = new JLabel("Hello");
	
	public Chapter_10_8() {
		setTitle("상,하,좌,우 키를 이용하여 텍스트 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.addKeyListener(new MyKeyListener());
		la.setLocation(50,50);
		la.setSize(100,20);
		c.add(la);
		
		setSize(300,300);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component c = (Component)e.getSource();
				c.setFocusable(true);
				c.requestFocus();
			}
		});
	}
	
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keycode = e.getKeyCode();
			
			switch(keycode) {
			case KeyEvent.VK_UP:
				la.setLocation(la.getX(),la.getY()-distance); break;
			case KeyEvent.VK_DOWN:
				la.setLocation(la.getX(),la.getY()+distance); break;
			case KeyEvent.VK_LEFT:
				la.setLocation(la.getX()-distance,la.getY()); break;
			case KeyEvent.VK_RIGHT:
				la.setLocation(la.getX()+distance,la.getY()); break;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		new Chapter_10_8();
	}

}
