package bagooni;

import java.awt.*;

import javax.swing.*;

public class ContentPaneEx extends JFrame {
	ContentPaneEx(){
		setTitle("컴넌트 부착하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancle"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ContentPaneEx();

	}

}
