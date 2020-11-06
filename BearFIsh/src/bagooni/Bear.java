package bagooni;

public class Bear extends GameObject {
	public Bear() {
		super(0, 0, 1);
	}

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public char getShape() {
		return 'B';
	}
}
