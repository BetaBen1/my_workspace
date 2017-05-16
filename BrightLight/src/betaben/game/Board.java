package betaben.game;

public class Board {
	
	private String[][] board;
	private int numRows;
	private int numCols;
	
	public Board(int rows, int cols){
		board = new String[rows][cols];
		numRows = rows;
		numCols = cols;
		for(int r = 0; r < numRows; r++){
			for(int c = 0; c < numCols; c++){
				board[r][c] = "White";
			}
		}
	}
	
	public String getValue(int row, int col){
		return board[row][col];
	}
	
	public void setValue(int row, int col, String color){
		board[row][col] = color;
	}
	
	public int getNumRows(){
		return numRows;
	}
	
	public int getNumCols(){
		return numCols;
	}
	
}
