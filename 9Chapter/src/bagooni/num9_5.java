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
	JLabel L[] = new JLabel[16];
	
	for(int i =0; i<L.length;i++) {
		L[i]=new JLabel(Integer.toString(i));
		L[i].setOpaque(true); // 배경색 변경가능
		L[i].setBackground(color[i]);
		c.add(L[i]);
	}
	
	setVisible(true);
	}
	
	public static void main(String[] args) {
		new num9_5();

	}

}
