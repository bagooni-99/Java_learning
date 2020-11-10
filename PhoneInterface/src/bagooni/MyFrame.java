package bagooni;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	MyFrame(){
		setTitle("첫번째 스윙 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();

	}

}
