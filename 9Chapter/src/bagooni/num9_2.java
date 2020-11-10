package bagooni;

import java.awt.*;
import javax.swing.*;

public class num9_2 extends JFrame{
	public num9_2() {
		setTitle("BorderLayout Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,200);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(5,7));
		contentPane.add(new JButton("North"),BorderLayout.NORTH);
		contentPane.add(new JButton("Center"),BorderLayout.CENTER);
		contentPane.add(new JButton("West"),BorderLayout.WEST);
		contentPane.add(new JButton("East"),BorderLayout.EAST);
		contentPane.add(new JButton("South"),BorderLayout.SOUTH);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new num9_2();

	}

}
