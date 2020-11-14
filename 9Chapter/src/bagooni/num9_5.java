package bagooni;

import java.awt.*;
import javax.swing.*;

public class num9_5 extends JFrame {
	Color[] color = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.MAGENTA,
			Color.GRAY, Color.WHITE, Color.CYAN , Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK};
	public num9_5() {
	setTitle("4X4 Color Frame");
	setSize(400,200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container c  = getContentPane();
	c.setLayout(new GridLayout(4,4));
	JLabel L = new JLabel();
	
	for(int i =0; i<16;i++) {
		L=new JLabel(Integer.toString(i));
		L.setOpaque(true); // 배경색 변경가능
		L.setBackground(color[i]);
		c.add(L);
	}
	
	setVisible(true);
	}
	
	public static void main(String[] args) {
		new num9_5();

	}

}
