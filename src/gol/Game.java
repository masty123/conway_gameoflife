package gol;
/**
 * 
 * This class is used for make the cell move or doing their activity.
 * @version 1.0.0
 * @author Theeruth Borisuth
 * @author Nitith Chayakul
 *
 */
public class Game {
	/**
	 * Run the program.
	 * @param args
	 */
	public static void main(String[] args) {
		Board game = new Board();
		game.select(1, 0);
		game.select(1, 1);
		game.select(1, 2);
		
		boolean x = true;
		while(x) {
			Cell[][] cells = game.getCells();
			for(int i = 0 ; i < 10 ; i++) {
				for(int j = 0 ; j < 10 ; j++) {
					if( cells[i][j].isAlive() ) System.out.print("*");
					else System.out.print("-");
					System.out.print(" ");
				}
				System.out.print("\n");
			}
			System.out.println("=======================================");
			game.nextGen();
		}
	}
}
