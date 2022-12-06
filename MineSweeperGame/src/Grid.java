
public class Grid {
	
	private boolean [][] bombGrid;
	private int [][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;
	
	
	public Grid() {
		numRows = 10;
		numColumns = 10;
		numBombs = 25;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		createBombGrid();
		createCountGrid();

		
	}
	
	public Grid(int rows, int cols) {
		numRows = rows;
		numColumns = cols;
		this.numBombs = 25;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];

		createBombGrid();
		createCountGrid();
	}
	
	public Grid(int rows, int cols, int numBombs) {
		numRows = rows;
		numColumns = cols;
		this.numBombs = numBombs;
		
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		
		createBombGrid();
		createCountGrid();
	}
	  

	    public boolean isBombAtLocation(int row, int column) {
	    	if(bombGrid[row][column] != true) {
	    		return false;
	    	}else
	    		return true;
	    }
	    
	  
	    
	    public boolean [][] getBombGrid(){
	    	boolean [][] bombGridClone = new boolean[numRows][numColumns];
	    	
	    	for(int r = 0;r < numRows;r++) {
	    		for(int c = 0;c < numColumns;c++) {
	    			bombGridClone[r][c] = bombGrid[r][c];
	    		}
	    		}
	    	return bombGridClone;
	    	}
	    	
	    
	    public int [][] getCountGrid() {
	    	
	    	int [][] countGridClone = new int[numRows][numColumns];
	    	for(int r = 0;r < numRows;r++) {
	    	for(int c = 0;c < numColumns;c++) {
    			countGridClone[r][c] = countGrid[r][c];
    		}
    		}
    	return countGridClone;
    	}
	    
	    public int getNumRows() {
			return numRows;
		}
		public int getNumColumns() {
			return numColumns;
		}
		public int getNumBombs() {
			return numBombs;
		}
		
		public int getCountAtLocation(int row, int column) {
			if(row < 0) {
				return countGrid[0][column];

			}
			
			if(row >= numRows) {
				return countGrid[numRows - 1][column];
			}
			
			if(column < 0) {
				return countGrid[row][0];
			}
			
			if(column >= numColumns) {
				return countGrid[row][numColumns - 1];
			}
			
			if(row < 0 && column < 0) {
				return countGrid[0][0];
			}
			
			if(row >= numRows && column >= numColumns) {
				return countGrid[numRows - 1][numColumns = 1];
			}
			
			if(row < 0 && column >= numColumns) {
				return countGrid[0][numColumns - 1];
			}
			if(row >= 0 && column < 0) {
				return countGrid[numRows - 1][0];
			}
			else
				return countGrid[row][column];
			
		}
		
		public void createCountGrid() {
			for(int r = 0;r < numRows;r++) {
				for(int c = 0;c < numColumns;c++) {
					int count = 0;
					try {
						if(bombGrid[r][c] == true) {
							count++;
						}
					
					}
					catch(ArrayIndexOutOfBoundsException badNum) {
						
					}
					try {
						if(bombGrid[r+1][c] == true) {
							count++;
						}
					}
					catch(ArrayIndexOutOfBoundsException badNum) {
						
					}
					try {
					if(bombGrid[r][c + 1] == true) {
						count++;
					}
					
				}
				catch(ArrayIndexOutOfBoundsException badNum) {
					
				}
					try {
						if(bombGrid[r][c - 1] == true) {
							count++;
						}
						
					}
					catch(ArrayIndexOutOfBoundsException badNum) {
						
					}
					
					try {
						if(bombGrid[r - 1][c] == true) {
							count++;
						}
						
					}
					catch(ArrayIndexOutOfBoundsException badNum) {
						
					}
					
					try {
						if(bombGrid[r + 1][c - 1] == true) {
							count++;
						}
						
					}
					catch(ArrayIndexOutOfBoundsException badNum) {
						
					}
					
					try {
						if(bombGrid[r - 1][c + 1] == true) {
							count++;
						}
						
					}
					catch(ArrayIndexOutOfBoundsException badNum) {
						
					}
					
					try {
						if(bombGrid[r - 1][c - 1] == true) {
							count++;
						}
						
					}
					catch(ArrayIndexOutOfBoundsException badNum) {
						
					}
					
					try {
						if(bombGrid[r + 1][c + 1] == true) {
							count++;
						}
						
					}
					catch(ArrayIndexOutOfBoundsException badNum) {
						
					}
					
					countGrid[r][c] = count;
					
			}
			}
		}
		
		public void createBombGrid() {
			  
			  for(int r = 0;r < numRows;r++) {
				  for(int c = 0;c < numColumns;c++) {
					  bombGrid[r][c] = false;
				  }
			  }
			  
			  for(int e = 0;e < numBombs; e++) {
				  int rows = (int)(Math.random() * (numRows - 1));
				  int columns = (int)(Math.random() * (numColumns - 1));
				  if(bombGrid[rows][columns] == true) {
					e -= 1;  
				  }else
					  bombGrid[rows][columns] = true;
			  }
		 }
		 
}
	     
	    
	    
	    
	    
	    

