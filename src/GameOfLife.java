import java.util.ArrayList;


public class GameOfLife {
	
	private int _rows;
	private int _cols;
	
	private int[][] grid;
	public GameOfLife(int rows, int cols) {
		_rows = rows;
		_cols = cols;
		grid = new int[_rows][_cols];
	}
	
	public void showGrid() {
		for(int i = 0;i<_rows;i++) {
			for(int e = 0; e<_cols;e++) {
				System.out.print(grid[i][e]);
			}
			System.out.println("");
		}
	}
	
	
	public int numberOfRows() {
		return _rows;
	}
	
	public int numberOfColumns() {
		return _cols;
	}
	
	public void growCellAt(int row, int col) {
		grid[row][col] = 1;
	}
	
	public void killCell(int row, int col) {
		grid[row][col] = 0;
	}
	
	public boolean cellAt(int row, int col) {
			return grid[row][col] == 1;
	}
	
	public int checker(int row, int col) {
		int counter = 0;
		
		if(cellAt((_rows - -(row+1)) % _rows, (_cols- -(col-1)) % _cols)) {    // up left
			counter++;
		} 
		if(cellAt((_rows - -(row+1))%_rows,col%_cols)) {    //up 
			counter++;
		}
		if(cellAt((_rows - -(row+1))%_rows, (_cols - -(col+1))%_cols)) {  // up right
			counter++;
		}
		if(cellAt(row%_rows, (_cols - -(col-1))%_cols)) {   //left
			counter++;
		}
		if(cellAt(row%_rows, (_cols - -(col+1))%_cols)) { // right
			counter++;
		}
		if(cellAt((_rows - -(row-1))%_rows, (_cols - -(col-1))%_cols)) {  // down left
			counter++;
		}
		if(cellAt((_rows - -(row-1))%_rows, col%_cols)) {   // down
			counter++;
		}
		if(cellAt((_rows - -(row-1))%_rows, (_cols - -(col+1))%_cols)) {   //down right
			counter++;
		}
		return counter;
	}
	public int neighborCount(int row, int col) {
		
		int counter = 0;
		
		counter = checker(row, col);
		
		return counter;
		
	}
	
	private boolean emptyTest() {
		
		
		return true;
	}
	
	
	public void start(int numOfGens) {
		int time = 1;
		
		while(numOfGens > 0) {
			System.out.println("T = " + time);
			executeNextGeneration();
			this.showGrid();
			numOfGens--;
			time++;
		}
	}

	public void executeNextGeneration() {
		
		ArrayList<EditAction> killRecord = new ArrayList<EditAction>(); 
		
		for(int r = 0;r<_rows;r++) {
			int count;
			for(int c = 0; c<_cols;c++) {
				count = neighborCount(r,c);
				EditAction currentCol = new EditAction(r, c, 0);
			
				if(cellAt(r, c) && (count < 2 || count > 3)) {

					
				} else if(cellAt(r,c)) {
					currentCol.setVal(1);
					
					
				} if(!cellAt(r, c) && count == 3) {
				
					currentCol.setVal(1);
				}
				killRecord.add(currentCol);
			}
		}
		
		
	
		for(int i = 0; i < _rows; i++) {
			for(int e = 0; e < _cols; e++) {
				grid[i][e] = (killRecord.get((_cols * i) + e)).getVal();
			}
		}
	
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		GameOfLife society = new GameOfLife(10,10);

		society.growCellAt(5,5);
		society.growCellAt(5,6);
		society.growCellAt(5,7);
		society.growCellAt(4,5);
		society.growCellAt(4,7);
		
		society.start(4);
	}
}

