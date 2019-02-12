import java.awt.Point;

public class Spel {
	
	private final int X = 20;
	private final int Y = 20;
	private Square[][] dimensions = new Square[Y][X];
	Player player1;
	Player player2;
	Player playerToMove;
	
	public Spel() {
		
		player1 = new Player("P1", new Point(19,19));
		player2 = new Player("P2", new Point(0,19));
		
		inialize();
		display();
		
	}

	private void inialize() {
		
		for (int i = 0; i<Y; i++) {
			for (int j = 0; j<X; j++) {
				if (i == 1 && j == 2)
					dimensions[i][j] = new Square(true, false, false, false, false, null, new Point(j,i));	
				else if (i == 1 && j == 16)
					dimensions[i][j] = new Square(false, true, false, false, false, null, new Point(j,i));	
				else if ((i < 16 && j == 10) || (i == 16 && (j < 17 && j > 2)))
					dimensions[i][j] = new Square(false, false, false, false, true, null, new Point(j,i));	
				else if ((i == 5 && j == 5) || (i == 18 && j == 15) || (i == 12 && j == 7))
					dimensions[i][j] = new Square(false, false, true, false, false, null, new Point(j,i));	
				else if ((i == 7 && j == 3) || (i == 14 && j == 13) || (i == 3 && j == 7))
					dimensions[i][j] = new Square(false, false, false, true, false, null, new Point(j,i));
				else if (i == 19 && j == 19)
					dimensions[i][j] = new Square(false, false, false, false, false, player1, new Point(j,i));
				else if (i == 19 && j == 0)
					dimensions[i][j] = new Square(false, false, false, false, false, player2, new Point(j,i));
				else dimensions[i][j] = new Square(false, false, false, false, false, null, new Point(j,i));	
			}
		}
	}

	public void display() {
		clearScreen();
		for (int i = 0; i<Y; i++) {
			for (int j = 0; j<X; j++) {
				System.out.print(dimensions[i][j].display());
				
			}
			System.out.println();
		}
	}
	
	public void movePlayer(String player, String direction) {
		if (player.equals("P1"))
			playerToMove = player1;
		else
			playerToMove = player2;
		int newX = playerToMove.getX(), newY = playerToMove.getY();
		
		switch(direction) {
		case ("r"):
			newX++;
			break;
		case ("l"):
			newX--;
			break;
		case ("u"):
			newY--;
			break;
		case ("d"):
			newY++;
			break;
		default:
			break;
		}
		if (newX == X || newX == -1|| newY == Y || newY == -1)
			return;
		
		Square s = dimensions[newY][newX];
		
		if (s.obstacle || s.getPlayer() != null)
			return;
		if (s.playerOneItem && playerToMove.getName().equals("P1")) {
			playerToMove.items++;
			s.playerOneItem = false;
		}
		else if (s.playerTwoItem && playerToMove.getName().equals("P2")) {
			playerToMove.items++;
			s.playerTwoItem = false;
		}
		s.setPlayer(playerToMove);
		dimensions[playerToMove.getY()][playerToMove.getX()].setPlayer(null);	
		playerToMove.setPoint(newX, newY);
		
		display();
		finished();
		
	}

	private void finished() {
		Square f1 = dimensions[1][2], f2 = dimensions[1][16];
		
		if (	f1.getPlayer() != null &&
				f1.getPlayer().getName() == "P1" &&
				f1.getPlayer().items == 3 &&
				f2.getPlayer() != null &&
				f2.getPlayer().getName() == "P2" &&
				f2.getPlayer().items == 3) {
			System.out.println("Game completed!");
			System.exit(0);
		}
			
	}
	
	private void clearScreen() {
		for (int i = 0; i<30; i++)
			System.out.println();
	}
}
