package bagooni;

import java.util.Random;

public class Fish extends GameObject {
	static Random R = new Random();
	static int r_x = R.nextInt(10-1)+1;
	static int r_y = R.nextInt(20-1)+1;
	
	public Fish() {
		super(r_x,r_y,1);
	}

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public char getShape() {
		return '@';
	}
}
