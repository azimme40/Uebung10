package h1;

public class Grid {
	
 //Attributes
 private Cell [][] gridArray; 
 
 //Getter
 public Cell [][] getGridArray()
 {
	 return gridArray;
 }
 
 //Setter
 public void setGridArray(Cell [][] gridArray)
 {
	 this.gridArray= gridArray;
 }
 
 
 public Grid (Cell [] cells, int gridRows, int gridCols)
 {
	this.gridArray = new Cell [gridRows] [gridCols]; 
	
	for (int r = 0; r<gridRows; r++)
	{
		for (int i = 0; i<gridCols; i++)
		{
			gridArray [r][i] = new Cell (r,i);
			
		}
	}
	
	for (Cell c : cells) 
	{
     int r = c.getindexRow();
     int k = c.getindexCol();

     // Prüfen, ob die Indizes im Grid liegen
     if (r >= 0 && r < gridRows && k >= 0 && k < gridCols) 
     {
         gridArray[r][k].setalive(true);
     }
 }

 // 4. Nachbarn zählen und nächste Generation setzen
 for (int p = 0; p < gridRows; p++) {
	 
     for (int l = 0; l < gridCols; l++) {
    	 
         gridArray[p][l].countLivingNeighbors(gridArray);
     }
 }
 
}
 public void computeNextGen()
 {
	 for (int i = 0; i < gridArray.length; i++) {
		            for (int j = 0; j < gridArray[0].length; j++) {
		                 gridArray[i][j].setalive(gridArray[i][j].getisAliveNextGen());
		            }
		        }
		        
		       // Recompute numLivingNeighbors and isAliveNextGen for the new state
		         for (int i = 0; i < gridArray.length; i++) {
		            for (int j = 0; j < gridArray[0].length; j++) {
		                gridArray[i][j].countLivingNeighbors(this.gridArray);
		            } 
		         }
 }
 public void computeGeneration(int n) {
	       if (n == 0) {
	           return; // No change for n=0
	        }
	        for (int i = 0; i < n; i++) {
	             computeNextGen();
	         }
	     }
 
}
