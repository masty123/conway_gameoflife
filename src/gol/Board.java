package gol;
/**
 * The Board of Conway's Game of Life and Heart of logics of the cell.
 * @version 1.0.0
 * @author Theeruth Borisuth
 * @author Nitith Chayakul
 *
 */
public class Board {
	//max rows of the board
	private final int MAXROW = 20;
	//max columns of the board
	private final int MAXCOLUMN = 20;
	//arrays of the cells
	private Cell[][] cells = new Cell[MAXROW][MAXCOLUMN];
	
	/**
	 * Generate cells.
	 */
	public Board() {
		for(int i = 0 ; i<MAXROW ; i++) {
			for(int j = 0 ; j < MAXCOLUMN ; j++) {cells[i][j] = new Cell();}
		}
	}
	
	/*
	 * select the cell to be the opposite of the state.
	 */
	public void select(int i, int j) {cells[i][j].select();}
	
	/*
	 * change it into the next generation cell.
	 */
	public void nextGen() {
		for(int i = 0 ; i<MAXROW ; i++) {
			for(int j = 0 ; j < MAXCOLUMN ; j++) {cells[i][j].decide( decide(i, j) );}
		}
		
		for(int i = 0 ; i<MAXROW ; i++) {
			for(int j = 0 ; j < MAXCOLUMN ; j++) {cells[i][j].nextGen();}
		}
	}
	
	/**
	 * get the cells
	 * @return cells
	 */
	public Cell[][] getCells() { return cells; }
	
	/**
	 * Receive the information from the next generation.
	 * @param i : rows
	 * @param j : column
	 * @return boolean true : if neighbors is not 2 or 3
	 * 				   false: if it is or something else.
	 */
	private boolean decide(int i, int j) {
		int neighbors = countNeighbors( i, j);
		if(cells[i][j].isAlive() ) {
			if( neighbors != 2 && neighbors != 3) {return false;} 
			else {return true;}
		} else {
			if( neighbors == 3 ) {return true;}
			return false;
		}
	}
	
	//checking nearby neighbors.
	private boolean notLastColumn(int j ) {return j != MAXCOLUMN-1; }
	private boolean notLastRow(int i    ) {return i != MAXROW-1;}
	private boolean notFirstColumn(int j) {return j != 0;}
	private boolean notFirstRow(int i   ) {return i != 0;}
	
	/**
	 * check the top left most
	 * @param i : rows
	 * @param j : columns
	  * @return boolean true  : if it's not. 
	 * 				   false :  if it is.
	 */
	private boolean notTopLeftMost(int i, int j) {return notFirstRow(i) && notFirstColumn(j);}
	
	/**
	 * check the top right most
	 * @param i : rows
	 * @param j : columns
	  * @return boolean true  : if it's not. 
	 * 				   false : if it is.
	 */
	private boolean notTopRightMost(int i, int j) {return notFirstRow(i) && notLastColumn(j);}
	
	/**
	 * check the bottom left most
	 * @param i : rows
	 * @param j : columns
	 * @return boolean true  : if it's not. 
	 * 				   false : if it is.
	 */
	private boolean notBottomLeftMost(int i, int j) {return notLastRow(i) && notFirstColumn(j);}
	
	/**
	 * check the bottom right most
	 * @param i : rows
	 * @param j : columns
	 * @return boolean true  : if it's not. 
	 * 				   false : if it is.
	 */					
	private boolean notBottomRightMost(int i, int j) {return notLastRow(i) && notLastColumn(j);}
	
	/**
	 * check the nearby neighbors.
	 * @param i : rows
	 * @param j : columns
	 * @return cells that was found nearby
	 */
	private int countNeighbors(int i, int j) {
		int livecells = 0;
		if(notLastColumn(j)         && cells[i  ][j+1].isAlive()) livecells++;
		if(notTopRightMost(i, j)    && cells[i-1][j+1].isAlive()) livecells++;
		if(notFirstRow(i)           && cells[i-1][j  ].isAlive()) livecells++;
		if(notTopLeftMost(i,j)      && cells[i-1][j-1].isAlive()) livecells++;
		if(notFirstColumn(j)        && cells[i  ][j-1].isAlive()) livecells++;
		if(notBottomLeftMost(i,j)   && cells[i+1][j-1].isAlive()) livecells++;
		if(notLastRow(i)            && cells[i+1][j  ].isAlive()) livecells++;
		if(notBottomRightMost(i,j)  && cells[i+1][j+1].isAlive()) livecells++;
		
		return livecells;
	}
}
