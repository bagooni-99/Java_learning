package bagooni;

import java.awt.Color;
import java.awt.Container;
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
	String way = "left";
	
	public MyPanel(Vector<Point> obstacleVector, Vector<Point> playerVector) {
		this.obstacleVector = obstacleVector;
		this.playerVector = playerVector;
		
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					way = "up";
					playerVector.get(0).y -= 10;
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					way = "left";
					playerVector.get(0).x -= 10;
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					way = "right";
					playerVector.get(0).x += 10;
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					way = "down";
					playerVector.get(0).y += 10;
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
		super.paintComponents(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		g.setColor(Color.RED);
		g.fillRect(0, 660, 40, 40);  //start
		
		g.setColor(Color.RED);
		g.fillRect(660, 0, 40, 40);  //finish
		
		Point A = playerVector.get(0);
		g.setColor(Color.GREEN);
		g.fillOval(A.x, A.y, 10, 10);
		
		g.setColor(Color.yellow);
		for (int i = 0; i < obstacleVector.size(); i++) {
			Point p = obstacleVector.get(i);
			g.fillOval(p.x, p.y, 10, 10);
		}
		
	}
}

public class main extends JFrame {
	Vector<Point> obstacleVector = new Vector<Point>();
	Vector<Point> playerVector = new Vector<Point>();
	public boolean flag = false;
	MyPanel panel;

	public main() {
		setTitle("Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < 50; i++) {
			int x = (int) ((Math.random() * 700));
			int y = (int) ((Math.random() * 700));
			obstacleVector.add(new Point(x, y));
		}
		
		playerVector.add(new Point(10, 670)); //10,675
		
		panel = new MyPanel(obstacleVector, playerVector);
		setContentPane(panel);
		
		Container c = getContentPane();
		c.setLayout(null);
	
		panel.setFocusable(true);
		panel.requestFocus();
		
		obstacleThread obstacle = new obstacleThread(panel, obstacleVector, playerVector);
		obstacle.start();
		playerThread player = new playerThread(panel, playerVector);
		player.start();
		ballThread ball = new ballThread(panel,obstacleVector,playerVector);
		ball.start();
		
		setSize(700, 730);
		setVisible(true);
	}

	public static void main(String[] args) {
		new main();
	}

}
