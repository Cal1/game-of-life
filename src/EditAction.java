


public class EditAction {
	
	private int[] pos;
	private int val;
	
	public EditAction(int row, int col, int val) {
		this.pos = new int[2];
		pos[0] = row;
		pos[1] = col;
		this.val = val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
	
	public int getCol() {
		return pos[1];
	}
	public int getVal() {
		return val;
	}
}


