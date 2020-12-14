package bagooni;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	ImageIcon background = new ImageIcon("images/space.jpg");
	Image img = background.getImage();
	Vector<Point> obstacleVector;
	Vector<Point> playerVector;
	String time;
	String way = "left";
	boolean game_status = false;//도착확인  
	boolean game_time = false; //시간 확인  
	boolean threadcheck = false; //시간 확인 
	GamePanel gamepanel;
	
	public MyPanel(GamePanel gamepanel, Vector<Point> obstacleVector, Vector<Point> playerVector) {
		this.obstacleVector = obstacleVector;
		this.playerVector = playerVector;
		this.gamepanel = gamepanel;
		
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					way = "up";
					playerVector.get(0).y -= 5;
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					way = "left";
					playerVector.get(0).x -= 5;
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					way = "right";
					playerVector.get(0).x += 5;
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					way = "down";
					playerVector.get(0).y += 5;
				}
				repaint();
			}
		});
	}
	
	public String get_way() {
		return way;
	}
	
	
	public void reset() {
		this.removeAll();
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, 1050, 400, this);
		
		g.setColor(Color.RED);
		g.fillRect(1010, 0, 40, 40);  //start
		
		g.setColor(Color.RED);
		g.fillRect(0, 360, 40, 40);  //finish
		
		Point A = playerVector.get(0);
		g.setColor(Color.GREEN);
		g.fillOval(A.x, A.y, 10, 10);
		
		g.setColor(Color.yellow);
		for (int i = 0; i < obstacleVector.size(); i++) {
			Point p = obstacleVector.get(i);
			g.fillOval(p.x, p.y, 10, 10);
		}
		
		if(game_status) {
			g.setColor(Color.blue);
			g.setFont(new Font("Default", Font.BOLD, 50));
			g.drawString("GAME CLEAR!", 360 ,200);
			setFocusable(false);
			requestFocus();
		}
		
		if(game_time) {
			g.setColor(Color.RED);
			g.setFont(new Font("Default", Font.BOLD, 50));
			g.drawString("GAME OVER!", 360 ,200);
			setFocusable(false);
			requestFocus();
		}
		
	}
}
