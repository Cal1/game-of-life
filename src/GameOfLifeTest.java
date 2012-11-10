public class GameOfLifeTest {
	
	public static void assertEquals(Integer val1, Integer val2) throws IllegalArgumentException {
		if (!val1.equals(val2)) {
			throw new IllegalArgumentException();
		}
	}
	
	public static void assertTrue(boolean expression) {
		if (!expression) {
			throw new IllegalArgumentException();
		}
	}
	
	public static void assertFalse(boolean expression) {
		if (expression) {
			throw new IllegalArgumentException(); 
		}
	}
	
	public static void testConstructorAndGetters() {
		GameOfLife society = new GameOfLife(5, 8);
		assertEquals(5, society.numberOfRows());
		assertEquals(8, society.numberOfColumns());
		for (int r = 0; r < society.numberOfRows(); r++)
			for (int c = 0; c < society.numberOfColumns(); c++)
				assertFalse(society.cellAt(r, c));
	}

	public static void testGrowCellAtAndCellAt() {
		GameOfLife society = new GameOfLife(4, 4);
		society.growCellAt(1, 1);
		society.growCellAt(2, 2);
		society.growCellAt(3, 3);

		assertTrue(society.cellAt(1, 1));
		assertTrue(society.cellAt(2, 2));
		assertTrue(society.cellAt(3, 3));
	}

	public static void testNeighborsWrapping() {
		GameOfLife society = new GameOfLife(10, 10);
	
		 /*
		 //Corner
		society.growCellAt(0, 0);
		
		society.growCellAt(1,0);    
		society.growCellAt(1,1);     
		society.growCellAt(0,1);    
		society.growCellAt(0,9);   
		society.growCellAt(9,0);    
		society.growCellAt(1,9);    
		society.growCellAt(9,1);
		society.growCellAt(9,9);    
	  
	    assertEquals(8, society.neighborCount(0, 0));
	 
		*/
		/*
		//top mid
		society.growCellAt(0,5);
	
		society.growCellAt(1,5);
		society.growCellAt(1,6);
		society.growCellAt(0,6);
		society.growCellAt(0,4);
		society.growCellAt(9,5);
		society.growCellAt(1,4);
		society.growCellAt(9,4);
		society.growCellAt(9,6);
		
		
		
		assertEquals(8, society.neighborCount(0, 5));
		
		*/
		
		
		
		society.growCellAt(5,5);
		
		
		society.growCellAt(6,5);
		society.growCellAt(6,6);
		society.growCellAt(5,6);
		society.growCellAt(5,4);
		society.growCellAt(4,5);
		society.growCellAt(6,4);
		society.growCellAt(4,6);
		society.growCellAt(4,4);
		
		assertEquals(8, society.neighborCount(5, 5));
		
	}
	
	// ... Add many more @Test methods here
	
	public static void main(String[] awesome) {
		testConstructorAndGetters();
		testGrowCellAtAndCellAt();
		testNeighborsWrapping();
		System.out.println("if we made it to here - things are good!");
	}
}