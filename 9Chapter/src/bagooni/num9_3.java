package bagooni;

import java.awt.*;
import javax.swing.*;

public class num9_3 extends JFrame {
	public num9_3() {
		setTitle("GridLayout");
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout());
		for(int i=0;i<10;i++)
			c.add(new JButton(Integer.toString(i)));
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new num9_3();
	}

}
