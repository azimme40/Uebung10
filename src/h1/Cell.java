package h1;




public class Cell {

	// Attribute
	private int indexRow;
	private int indexCol;
	private boolean alive;
	private int numLivingNeighbors;
	private boolean isAliveNextGen;

	// Getter und Setter
	public int getindexRow() {
		return indexRow;
	}

	public void setindexRow(int indexRow) {
		this.indexRow = indexRow;
	}
	public int getindexCol()
	{
		return indexCol;
	}

	public int indexCol() {
		return indexCol;
	}

	public void setindexCol(int indexCol) {
		this.indexCol = indexCol;
	}

	public boolean getalive() {
		return alive;
	}

	public void setalive(boolean alive) {
		this.alive = alive;
	}

	public int getnumLivingNeighbors() {
		return numLivingNeighbors;
	}

	public void setnumLivingNeighbors(int numLivingNeighbors) {
		this.numLivingNeighbors = numLivingNeighbors;
	}

	public boolean getisAliveNextGen() {
		return isAliveNextGen;
	}

	public void setisAliveNextGen(boolean isAliveNextGen) {
		this.isAliveNextGen = isAliveNextGen;
	}

	// Konstruktoren
	public Cell(int indexRow, int indexCol, boolean alive) {
		this.indexRow = indexRow;
		this.indexCol = indexCol;
		this.alive = alive;
		this.numLivingNeighbors= 0; 
		this.isAliveNextGen = false; 
	}

	public Cell(int indexRow, int indexCol) {
		this (indexRow,indexCol, false);
	}

	// Methoden
	private void decideNextStatus() {
		
		 if (alive) {
			           // Überleben: 2 oder 3 Nachbarn -> bleibt am Leben
			         isAliveNextGen = (numLivingNeighbors == 2 || numLivingNeighbors == 3);
			     }
		 else {
			           // Fortpflanzung: genau 3 Nachbarn -> wird lebendig
			           isAliveNextGen = (numLivingNeighbors == 3);
			        }
		
		}
	

	public void countLivingNeighbors(Cell gridArray[][]) {

		int count = 0;
		int rows = gridArray.length;
		int cols = (rows > 0) ? gridArray[0].length : 0;
		

		for (int r = indexRow - 1; r <= indexRow + 1; r++) {
			for (int c = indexCol - 1; r <= indexCol + 1; c++) {

				if (r == indexRow && c == indexCol) {
					continue;
				}
				if (r >= 0 && r < gridArray.length && c >= 0 && c < gridArray.length) {

					if (gridArray[r][c].getalive() == true) {
						count++;
					}

				}
			}
			this.numLivingNeighbors = count; 
			decideNextStatus(); 
		}
		

	}
	
}