package bagooni;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class game2 extends JFrame {
	JLabel title = new JLabel();
	JLabel time = new JLabel();
	JLabel time_right = new JLabel();
	JButton start = new JButton("START");
	JButton next = new JButton("NEXT");
	JButton nextstep = new JButton("NEXT STEP");
	GamePanel gamepanel;
	public SimpleDateFormat time_format; //시간 값을 변환하기 위한 포맷
	public String show_time;//진행 시간 값을 받아들일 문자열
	public long start_time, current_time, actual_time; //게임 시작시간, 컴퓨터 시간, 실제 게임 진행 시간
    public boolean time_run = false;
    
    Vector<Point> obstacleVector = new Vector<Point>();
	Vector<Point> playerVector = new Vector<Point>();
	public boolean flag = false;
    MyPanel mypanel;
    
    class MyActionStartListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!time_run && !gamepanel.game_status) {
				start_time = System.currentTimeMillis();//시작버튼눌렀을시시간값받기
				gamepanel.rect_select.clear(); //1-25 숫자 보관용 벡터
				time_run = true;
				gamepanel.gameStart(true);
		}
		}
    }
	
    class MyActionNextListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			mypanel.time = gamepanel.time.substring(gamepanel.time.length()-2,gamepanel.time.length());
			mypanel.setFocusable(true);
			mypanel.requestFocus();
			TimerThread_second timer_second = new TimerThread_second(mypanel, time_right);
			timer_second.start();
		}
    }
    
    class MyActionNextStepListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			start_time=0;
			time.setText("00:00:00");
			gamepanel.CountDown(0);
			time_run=false;
			gamepanel.rect_select.clear();
			gamepanel.gameStart(false);
			gamepanel.check=0;
			mypanel.game_status=false;
			mypanel.game_time=false;
			playerVector.get(0).x = 10;
			playerVector.get(0).y = 370;
			mypanel.threadcheck=false;
		}
    }
    
	public game2() {
		setTitle("Game2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		for (int i = 0; i < 50; i++) {
			int x = (int) ((Math.random() * 1050));
			int y = (int) ((Math.random() * 400));
			obstacleVector.add(new Point(x, y));
		}
		
		playerVector.add(new Point(10, 370)); //10,675
		
		start.setFont(new Font("Default", Font.BOLD, 20));
		start.setSize(100,30);
		start.setLocation(50, 520);
		start.addActionListener(new MyActionStartListener());
		c.add(start);
		// start버튼  
		
		next.setFont(new Font("Default", Font.BOLD, 20));
		next.setSize(100,30);
		next.setLocation(350, 520);
		next.addActionListener(new MyActionNextListener());
		c.add(next);
		// next 버튼  
		
		nextstep.setFont(new Font("Default", Font.BOLD, 20));
		nextstep.setSize(150,30);
		nextstep.setLocation(1410, 520);
		nextstep.addActionListener(new MyActionNextStepListener());
		c.add(nextstep);
		// next step버튼  
		
		gamepanel = new GamePanel();
		gamepanel.setBounds(50, 100, 400, 400);
		c.add(gamepanel);
		//바둑판 
		
		mypanel = new MyPanel(gamepanel, obstacleVector, playerVector);
		mypanel.setBounds(500, 100, 1050, 400);
		mypanel.setBackground(Color.DARK_GRAY);
		c.add(mypanel);
		
		time_right.setText("00:00:00");
		time_right.setFont(new Font("Default", Font.BOLD, 20));
		time_right.setSize(300,30);
		time_right.setLocation(1460, 70);
		c.add(time_right);
		
		time_format = new SimpleDateFormat("HH:mm:ss");
		//시간포맷설정
		
		title.setText("Game");
		title.setFont(new Font("Default", Font.BOLD, 20));
		title.setSize(300,30);
		title.setLocation(225, 25);
		c.add(title);
		//타이틀 
		
		time.setText("00:00:00");
		time.setFont(new Font("Default", Font.BOLD, 20));
		time.setSize(150,30);
		time.setLocation(370, 70);
		c.add(time);
		//시간 
		
		obstacleThread obstacle = new obstacleThread(mypanel, obstacleVector, playerVector);
		obstacle.start();
		playerThread player = new playerThread(mypanel, playerVector);
		player.start();
		ballThread ball = new ballThread(mypanel,obstacleVector,playerVector);
		ball.start();
		
		setSize(1600, 600);
		setVisible(true);
		
		TimerThread timer = new TimerThread(this);
		timer.start();
	}
	
		
	public static void main(String[] args) {
		new game2();
	}

}
