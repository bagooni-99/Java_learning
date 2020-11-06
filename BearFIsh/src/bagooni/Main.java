package bagooni;

import java.util.Random;
import java.util.Scanner;

public class Main {
	Random R = new Random();
	
	Scanner sc = new Scanner(System.in);
	char table[][] = new char[10][20];
	Bear bear = new Bear();
	Fish fish = new Fish();
	static int num = 1;
	static int x_bear;
	static int y_bear;
	static int x_fish;
	static int y_fish;

	public void reset() {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 20; j++)
				table[i][j] = '-';
		x_bear = bear.getX();
		y_bear = bear.getY();
		x_fish = fish.getX();
		y_fish = fish.getY();
		table[x_fish][y_fish] = fish.getShape();
		table[x_bear][y_bear] = bear.getShape();
	}

	public void print() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++)
				System.out.print(table[i][j]);
			System.out.println();
		}
	}

	public void update(String select) {
		int random_num = R.nextInt(4);
		
		if(num%5 == 4 || num%5 == 0) {
			switch(random_num) {
			case 0:
				fish.move(x_fish, y_fish - 1);
				break;
			case 1:
				fish.move(x_fish + 1, y_fish);
				break;
			case 2:
				fish.move(x_fish - 1, y_fish);
				break;
			case 3:
				fish.move(x_fish, y_fish + 1);
				break;
			}
			reset();
		}
		
		switch (select) {
		case "a":
			if (y_bear == 0)
				System.out.println("다시 선택하세요!");
			else
				bear.move(x_bear, y_bear - 1);
			break;
		case "s":
			if (x_bear == 9)
				System.out.println("다시 선택하세요!");
			else
				bear.move(x_bear + 1, y_bear);
			break;
		case "d":
			if (x_bear == 0)
				System.out.println("다시 선택하세요!");
			else
				bear.move(x_bear - 1, y_bear);
			break;
		case "f":
			if (y_bear == 19)
				System.out.println("다시 선택하세요!");
			else
				bear.move(x_bear, y_bear + 1);
			break;
		}
		reset();
		num++;

	}

	public void start() {
		System.out.println("** Bear의 Fish 먹기 게임을 시작합니다.**");

		while (true) {
			
			print();
			
			if(bear.collide(fish)) {
				System.out.println("Bear wins!!");
				break;
			}
			
			System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");

			String select = sc.next();
			update(select);

			System.out.println();
			
			
		}
	}

	public static void main(String[] args) {
		Main bf = new Main();
		bf.reset();
		bf.start();
	}

}
