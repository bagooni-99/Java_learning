package bagooni;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gbbgame extends JFrame {
	private MenuPanel mPanel = new MenuPanel();
	public GamePanel gPanel = new GamePanel();
	
	
	class MenuPanel extends JPanel{
		public ImageIcon gbbIcon[] = {
				new ImageIcon("images/gawi.jpg"), new ImageIcon("images/bawi.jpg"),new ImageIcon("images/bo.jpg")
		};
		private JButton [] gbbBt = new JButton[3];
		private String SAME = "Same !!!";
		private String ME_win = "Me !!!";
		private String COM_win = "Computer !!!";
		
		public MenuPanel(){
			setBackground(Color.gray);
			for(int i=0;i<gbbBt.length;i++) {
				gbbBt[i] = new JButton(gbbIcon[i]);
				add(gbbBt[i]);
				
				gbbBt[i].addActionListener(new MyActionListener());
			}
		}
		
		class MyActionListener implements ActionListener {		
			public void actionPerformed(ActionEvent e) {
				JButton bt = (JButton)e.getSource();
				int com = (int)(Math.random()*3);
				String a = SAME;
				
				if(bt.getIcon() == gbbIcon[0] && com ==2 || bt.getIcon() == gbbIcon[1] && com == 0 || bt.getIcon() == gbbIcon[2] && com == 1)
					a = ME_win;
				else if(bt.getIcon() == gbbIcon[0] && com == 1 || bt.getIcon() == gbbIcon[1] && com == 2 || bt.getIcon() == gbbIcon[2] && com == 0)
					a = COM_win;
				else
					a = SAME;
				
				gPanel.imgDraw(bt.getIcon(), gbbIcon[com], a);
			}
		}
	}
	
	
	class GamePanel extends JPanel{
		private JLabel me = new JLabel("me");
		private JLabel com= new JLabel("com");
		private JLabel win = new JLabel("winner");
		
		public GamePanel(){
			setBackground(Color.yellow);
			add(me);
			add(com);
			win.setForeground(Color.red);
			add(win);
		}
		public void imgDraw(Icon myIcon, Icon comIcon, String word) {
			me.setIcon(myIcon);
			com.setIcon(comIcon);
			win.setText(word);
		}
	}
	
	public gbbgame() {
		setTitle("가위바위보 게임 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c  = getContentPane();
		c.setLayout(new BorderLayout());
		
		add(mPanel, BorderLayout.NORTH);
		add(gPanel, BorderLayout.CENTER);
		
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new gbbgame();
	}

}
