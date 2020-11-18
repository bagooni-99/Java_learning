package bagooni;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Chapter_10_4 extends JFrame{
	private JLabel la = new JLabel("Hello");
	
	public Chapter_10_4(){
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		la.setSize(50,20);
		la.setLocation(30,30);
		c.addMouseListener(new MymouseListener());
		c.add(la);
		
		setSize(250,250);
		setVisible(true);
	}
	
	class MymouseListener implements MouseListener{
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x,y);
			
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static void main(String[] args) {
		new Chapter_10_4();
	}

}

