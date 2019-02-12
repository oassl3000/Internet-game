import java.awt.Point;

public class Player {
	
	private String name;
	private Point p;
	public int items = 0;
	
	public Player(String name, Point p) {
		this.name = name;
		this.p = p;
	}
	
	public String getName() {
		return name;
	}
	
	public int getX() {
		return p.x;
	}
	
	public int getY() {
		return p.y;
	}
	public void setPoint(int x, int y) {
		p.setLocation(x, y);
	}
	
}
