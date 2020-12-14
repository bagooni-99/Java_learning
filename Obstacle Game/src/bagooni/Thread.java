package bagooni;

import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JLabel;

class obstacleThread extends Thread {
	MyPanel panel;
	Vector<Point> obstacleVector;
	Vector<Point> playerVector;
	
	public obstacleThread(MyPanel panel, Vector<Point> obstacleVector, Vector<Point> playerVector) {
		this.panel = panel;
		this.obstacleVector = obstacleVector;
		this.playerVector = playerVector;
	}

	public void changeObstaclePosition() {
		for (int i = 0; i < obstacleVector.size(); i++) {
			obstacleVector.get(i).y += 5;
			if(playerVector.get(0).x==obstacleVector.get(i).x && playerVector.get(0).y==obstacleVector.get(i).y) {
				Container c = panel.getParent();

			}
			if (obstacleVector.get(i).x < 40) {
				if (obstacleVector.get(i).y > 600)
					obstacleVector.get(i).y = 0;
			} else {
				if (obstacleVector.get(i).y > 700)
					obstacleVector.get(i).y = 0;
			}
		}
	}

	public void run() {
		while (true) {
			try {
				sleep(100);
				}
			catch (InterruptedException e) {
				return;
			}
			changeObstaclePosition();
			panel.repaint();
		}
	}
}

class playerThread extends Thread {
	MyPanel panel;
	Vector<Point> playerVector;
	String way;

	public playerThread(MyPanel panel, Vector<Point> playerVector) {
		this.panel = panel;
		this.playerVector = playerVector;
	}

	public void changePlayerPosition() {
		way = panel.get_way();

		if (way.equals("down")) {
			if (playerVector.get(0).y >= 680) {
				playerVector.get(0).y = 680;
			}
		}

		else if (way.equals("left")) {
			if (playerVector.get(0).x <= 0) {
				playerVector.get(0).x = 0;
			}
		}

		else if (way.equals("right")) {
			if (playerVector.get(0).x >= 680) {
				playerVector.get(0).x = 680;
			}
		}

		else if (way.equals("up")) {
			if (playerVector.get(0).y <= 0) {
				playerVector.get(0).y = 0;

			}
		}
	}

	public void run() {
		while (true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				System.out.println("error");
			}
			changePlayerPosition();
			panel.repaint();
		}
	}
}

class ballThread extends Thread{
	Vector<Point> obstacleVector;
	Vector<Point> playerVector;
	MyPanel panel;

	public ballThread(MyPanel panel, Vector<Point> obstacleVector, Vector<Point> playerVector) {
		this.obstacleVector = obstacleVector;
		this.playerVector = playerVector;
		this.panel = panel;
	}
	
	public void run() {
		while(true) {
			try {
				if(playerVector.get(0).x>=660 && playerVector.get(0).y<=40) {
					Container c = panel.getParent();
					c.remove(panel);
					c.revalidate();
					c.repaint();
				}
				sleep(100);
			}
			catch (InterruptedException e) {
				System.out.println("error");
			}
		}
	}
}