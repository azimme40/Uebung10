package h2;

public class Spielstein {
	
	private int currentRow; 
	private int currentCol;
	private Spielbrett brett; 
	
	//Getter&Setter
	public int getCurrentRow()
	{
		return currentRow;
	}
	public void setCurrentRow(int currentRow)
	{
		this.currentRow = currentRow;
	}
	public int getCurrentCol ()
	{
		return currentCol;
	}
	public void setCurrentCol(int currentCol)
	{
		this.currentCol = currentCol;
	}
	//Constructor
	public Spielstein(Spielbrett brett, int indexRow, int indexCol)
	{
		currentRow = indexRow; 
		currentCol = indexCol; 
		this.brett = brett;
			}
	
	private boolean movesOut()
	{
		Feld aktuellesFeld = brett.getBrett()[currentRow][currentCol];
		char direct = aktuellesFeld.getDirection();
		
		if (currentRow == 0 && direct == 'U')
		{
		return true;
		}
		if (currentRow == brett.getDim()-1 && direct == 'D')
		{
			return true; 
		}
		if (currentCol == brett.getDim()-1 && direct == 'R')
		{
			return true; 
		}
		if (currentCol == 0 && direct == 'L')
		{
			return true; 
		}
		
		return false;
	}
	
	public void go (int n)
	{
		Feld aktuellesFeld = brett.getBrett()[currentRow][currentCol];
		char direct = aktuellesFeld.getDirection();
		
		if (n == 0)
		{
			return;
		}
		
		for (int i = 0; i<n; i++)
		{
			aktuellesFeld = brett.getBrett() [currentRow] [currentCol];
			 direct = aktuellesFeld.getDirection();
			
			if (aktuellesFeld.getBoese()== true)
			{
				continue;
			}

			if ( movesOut() == true)
			{
				continue;
			}
			
			switch (direct)
			{
			case 'U':
				
			currentRow --;
			break;
			
			case 'L':
			
			currentCol --;
			break;
			
			case 'R':
				
			currentCol ++;
			break;
				
			case 'D':
				
			currentRow ++;
			break;
			}
			
		}
	}

}
