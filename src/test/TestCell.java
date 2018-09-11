package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gol.Cell;
/**
 * Testing cases for Cell class.
 * @author Theeruth Borisuth
 * @author Nitith Chayakul
 *
 */
public class TestCell {

	private Cell cell;
	
	@Before
	public void setup() {
		cell = new Cell();
	}
	
	@Test
	public void testInitialize() {
		assertFalse(cell.isAlive());
	}
	
	@Test
	public void testnextGen() {
		cell.decide(true);
		cell.nextGen();
		assertTrue(cell.isAlive());
	}

}
