package gol;
/**
 * This class is used for collect data of each cell.
 * @version 1.0.0
 * @author Theeruth Borisuth
 * @author Nitith Chayakul
 *
 */
public class Cell {
	//boolean check whether it alive or not.
	private boolean live;
	//boolean for the next generation cell.
	private boolean nextGen;
	
	/*
	 * Initialize Cell.
	 */
	public Cell() {
		live = false;
		nextGen = false;
	}
	
	/*
	 * select the cell to be the oposite of the state.
	 */
	public void select() {
		live = !live;
	}
	
	/*
	 * change it into the next generation cell.
	 */
	public void nextGen() {
		live = nextGen;
	}
	
	/*
	 * Receive the information from the next generation.
	 */
	public void decide(boolean next) {
		nextGen = next;
	}
	
	/*
	 * check whether the cell is alive or not
	 */ 
	public boolean isAlive() {
		return live;
	}

}
