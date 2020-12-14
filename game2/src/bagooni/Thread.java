package bagooni;

import java.awt.Container;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JLabel;

class TimerThread extends Thread {
	private game2 game2;

	public TimerThread(game2 game2) {
		this.game2 = game2;

	}

	public void TimeCheck() {
		if (game2.time_run) {
			game2.current_time = System.currentTimeMillis();
			game2.actual_time = game2.current_time - game2.start_time;// 게임시작버튼을눌렀을때의시간값과 실제시간값으로게임진행시간계산.
			game2.gamepanel.CountDown((int) game2.actual_time / 1000); // 카운트다운표시용시간값전송

			if (!game2.gamepanel.game_status && game2.gamepanel.check <= 25) { // 게임세팅완료후게임시작되면게임진행시간갱신
				game2.show_time = game2.time_format.format(game2.actual_time - 32403000);
				game2.time.setText(game2.show_time);
			}
		}

		if (game2.gamepanel.check > 25) {
			game2.gamepanel.ClearTime(game2.time.getText());// 숫자25까지클릭이끝나면게임클리어메세지띄울준비
		}
	}

	public void run() {
		while (true) {
			try {
				game2.repaint();
				TimeCheck();
				Thread.sleep(15);
			} catch (Exception e) {
			}
		}
	}
}

class TimerThread_second extends Thread {
	private JLabel time_right;
	private MyPanel panel;

	public TimerThread_second(MyPanel panel, JLabel time_right) {
		this.time_right = time_right;
		this.panel = panel;
	}

	public void run() {
		int n = 60 - Integer.parseInt(panel.time);

		while (true) {
			try {
				if (n < 10) {
					time_right.setText("00:00:0" + Integer.toString(n));
					n--;
				} else {
					time_right.setText("00:00:" + Integer.toString(n));
					n--;
				}
				sleep(1000);
			} catch (Exception e) {
				return;
			}
			if (n < 0) {
				panel.game_time = true;
				return;
			}
		}
	}
}

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
			if (obstacleVector.get(i).x < 40) {
				if (obstacleVector.get(i).y > 350)
					obstacleVector.get(i).y = 0;
			} else {
				if (obstacleVector.get(i).y >= 400)
					obstacleVector.get(i).y = 0;
			}
		}
	}

	public void run() {
		while (true) {
			try {
				if(panel.threadcheck) {
					return;
				}
				else
					changeObstaclePosition();
				sleep(100);
			} catch (InterruptedException e) {
				return;
			}
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
			if (playerVector.get(0).y >= 400) {
				playerVector.get(0).y = 400;
			}
		}

		else if (way.equals("left")) {
			if (playerVector.get(0).x <= 0) {
				playerVector.get(0).x = 0;
			}
		}

		else if (way.equals("right")) {
			if (playerVector.get(0).x >= 1050) {
				playerVector.get(0).x = 1050;
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

class ballThread extends Thread {
	Vector<Point> obstacleVector;
	Vector<Point> playerVector;
	MyPanel panel;

	public ballThread(MyPanel panel, Vector<Point> obstacleVector, Vector<Point> playerVector) {
		this.obstacleVector = obstacleVector;
		this.playerVector = playerVector;
		this.panel = panel;
	}

	public void run() {
		while (true) {
			try {
				if (playerVector.get(0).x >= 1010 && playerVector.get(0).y <= 40) {
					panel.game_status = true;
				}
				for (int i = 0; i < obstacleVector.size(); i++) {
					if (playerVector.get(0).y-5 <= obstacleVector.get(i).y+5
						&& playerVector.get(0).y+5 >= obstacleVector.get(i).y-5
						&& playerVector.get(0).x-5 <= obstacleVector.get(i).x+5
						&& playerVector.get(0).x+5 >= obstacleVector.get(i).x-5){
							panel.game_time = true;
							panel.threadcheck = true;
					}
				}
				sleep(100);
			} catch (InterruptedException e) {
				System.out.println("error");
			}
		}
	}
}
