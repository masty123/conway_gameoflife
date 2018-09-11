package test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import gol.Board;
import gol.Cell;
/**
 * Testing cases for Board class.
 * @author Theeruth Borisuth
 * @author Nitith Chayakul
 *
 */
public class TestBoard {

	Board game;
	Cell[][] cells;
	
	@Before
	public void setup() {
		game = new Board();
	}
	
	@Test
	public void Initialize() {
		Cell[][] cells = game.getCells();
		for(int i = 0 ; i< 20 ; i++) {
			for(int j = 0 ; j < 20 ; j++) {
				assertFalse( cells[i][j].isAlive() );
			}
		}
	}
	
	@Test
	public void testSelect() {
		game.select(10, 10);
		cells = game.getCells();
		assertTrue( cells[10][10].isAlive() );
	}
	
	@Test
	public void testNextGen() {
		game.select(10, 10);
		game.nextGen();
		cells = game.getCells();
		assertFalse( cells[10][10].isAlive() );
	}
	
	@Test
	public void testFanCase() {
		game.select(0, 1);
		game.select(1, 1);
		game.select(2, 1);
		
		game.nextGen();
		cells = game.getCells();
		
		assertTrue(cells[1][1].isAlive());
		assertTrue(cells[1][0].isAlive());
		assertTrue(cells[1][2].isAlive());
		
		assertFalse(cells[0][1].isAlive());
		assertFalse(cells[2][1].isAlive());
	}

}
