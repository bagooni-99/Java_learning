package bagooni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chapter_10_6 extends JFrame{
	private JLabel[] keymessage = new JLabel[3];
	
	public Chapter_10_6() {
		setTitle("keylistener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MykeyListener());
		
		keymessage[0] = new JLabel(" getKeyCode()  ");
		keymessage[1] = new JLabel(" getKeyChar()  ");
		keymessage[2] = new JLabel(" getKeyText()  ");
		
		for(int i=0;i<keymessage.length;i++) {
			c.add(keymessage[i]);
			keymessage[i].setOpaque(true);
			keymessage[i].setBackground(Color.YELLOW);
		}
		
		setSize(300,150);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MykeyListener implements KeyListener{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			keymessage[0].setText(Integer.toString(keyCode));
			keymessage[1].setText(Character.toString(keyChar));
			keymessage[2].setText(KeyEvent.getKeyText(keyCode));
			
			System.out.println("KeyPressed");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("KeyReleased");
		}

		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("KeyTyped");
		}
	}
	
	public static void main(String[] args) {
		new Chapter_10_6();
	}

}
