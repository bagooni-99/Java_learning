package bagooni;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Chapter_10_5 extends JFrame{
	private JLabel la = new JLabel("Hello");
	
	public Chapter_10_5(){
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		la.setSize(50,20);
		la.setLocation(30,30);
		c.addMouseListener(new MymouseAdapter());
		c.add(la);
		
		setSize(250,250);
		setVisible(true);
	}
	
	class MymouseAdapter extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x,y);
			
		}
	}
	
	public static void main(String[] args) {
		new Chapter_10_5();
	}

}

