import java.awt.Point;

public class Square {
	
	public boolean playerOneFinish;
	public boolean playerTwoFinish;
	public boolean playerOneItem;
	public boolean playerTwoItem;
	public boolean obstacle;
	public Point p;
	private Player player;
	
	public Square(boolean p1f, boolean p2f, boolean p1i, boolean p2i, boolean o, Player pl, Point p) {
		playerOneFinish = p1f;
		playerTwoFinish = p2f;
		playerOneItem = p1i;
		playerTwoItem = p2i;
		obstacle = o;
		player = pl;
		this.p = p;
	}
	
	public String display() {
		if (playerOneFinish)
			return " F1";
		if (playerTwoFinish)
			return " F2";
		if (playerOneItem)
			return " I1";
		if (playerTwoItem)
			return " I2";
		if (obstacle)
			return " # ";
		if (player != null && player.getName().equals("P1"))
			return " P1";
		if (player != null && player.getName().equals("P2"))
			return " P2";
		return " - ";
	}
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
}
