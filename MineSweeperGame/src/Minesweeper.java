import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Minesweeper extends JFrame {
	
	private boolean [][] bombGrid;
	private int [][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;
	private int number;
	private JButton button [][];
	
	public Minesweeper() {
		super("MineSweeper");
		numRows = 10;
		numColumns = 10;
		numBombs = 25;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		createBombGrid();
		createCountGrid();
		number = ((numRows * numColumns) - numBombs);
		button = new JButton[numRows][numColumns];
		setLayout(new GridLayout(numRows, numColumns));
		for(int r = 0;r < numRows;r++) {
			for(int c = 0;c < numColumns;c++) {
				button[r][c] = new JButton();
			    button[r][c].setOpaque(true);
			    button[r][c].setBackground(Color.RED);
			    button[r][c].addActionListener(new actionReceiver(r, c));
			    add(button[r][c]);
			}
		}
		
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
			
		
	}
	
	public Minesweeper(int rows, int columns) {
		super("MineSweeper");
		numRows = rows;
		numColumns = columns;
		numBombs = 25;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		createBombGrid();
		createCountGrid();
		number = ((numRows * numColumns) - numBombs);
		button = new JButton[numRows][numColumns];
		setLayout(new GridLayout(numRows, numColumns));
		for(int r = 0;r < numRows;r++) {
			for(int c = 0;c < numColumns;c++) {
				button[r][c] = new JButton();
			    button[r][c].setOpaque(true);
			    button[r][c].setBackground(Color.CYAN);
			    button[r][c].addActionListener(new actionReceiver(r, c));
			    add(button[r][c]);
			}
		}
		
	setSize(900, 900);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
	}
	
	public Minesweeper(int rows, int columns, int bombs) {
		super("MineSweeper");
		numRows = rows;
		numColumns = columns;
		numBombs = bombs;
		bombGrid = new boolean[numRows][numColumns];
		countGrid = new int[numRows][numColumns];
		createBombGrid();
		createCountGrid();
		number = ((numRows * numColumns) - numBombs);
		button = new JButton[numRows][numColumns];
		setLayout(new GridLayout(numRows, numColumns));
		for(int r = 0;r < numRows;r++) {
			for(int c = 0;c < numColumns;c++) {
				button[r][c] = new JButton();
			    button[r][c].setOpaque(true);
			    button[r][c].setBackground(Color.CYAN);
			    button[r][c].addActionListener(new actionReceiver(r, c));
			    add(button[r][c]);
			}
		}
		
	setSize(900, 900);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	
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
		
		private void createCountGrid() {
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
		
		 private void createBombGrid() {
			  
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

	private void reset() {
		
		createBombGrid();
		createCountGrid();
		
		number = ((numRows * numColumns) - numBombs);
		for(int r = 0;r < numRows; r++) {
			for(int c = 0;c < numColumns; c++) {
				button[r][c].setText("");
				button[r][c].setEnabled(true);
			}
		}
		
		
		
	}
	
	private class actionReceiver implements ActionListener {
		int rows;
		int columns;
		
		public actionReceiver(int rows, int columns) {
			this.rows = rows;
			this.columns = columns;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(isBombAtLocation(rows, columns)) {
				int [][] recorder = getCountGrid();
				for(int h = 0;h < numRows;h++) {
					for(int v = 0;v < numColumns;v++) {
						if(isBombAtLocation(h, v)) {
							button[h][v].setText("BOOM!");
						}else {
							button[h][v].setText(String.valueOf(recorder[h][v]));
							
						}
						button[h][v].setEnabled(false);
					}
				}
				
				int finishedGame = JOptionPane.showConfirmDialog(null, "You lost!, Do you want to play again?\n", "Game Over", JOptionPane.YES_NO_OPTION);
				if(finishedGame == JOptionPane.YES_OPTION) {
					reset();
				}else {
					System.exit(0);
				}
				
			}else {
				button[rows][columns].setText(String.valueOf(getCountAtLocation(rows, columns)));
				button[rows][columns].setEnabled(false);
				number--;
				
				if(number == 0) {
					int finishedGame = JOptionPane.showConfirmDialog(null, "You won! Congratulations!\nDo you want to play again?\n", "Game Over", JOptionPane.YES_NO_OPTION);
					if(finishedGame == JOptionPane.YES_OPTION) {
						reset();
					}else
						System.exit(0);
				}
			}
			
		}
		
		
	}
	
	public static void main(String [] args) {
		Minesweeper minesweeper = new Minesweeper();
	}
	
	
	

}
