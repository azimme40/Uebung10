package h2;

public class Spielbrett {
	
	 
	private int dim; 
	private Feld  [][] brett; 
	
	// Getter&Setter
	public int getDim()
	{
		return dim; 
	}
	public void setDim (int dim)
	{
		this.dim= dim; 
	}
	 public Feld [][] getBrett(){
		 return brett; 
	 }
	 public void setBrett( Feld  [][] brett)
	 {
		 this.brett= brett;
	 }
	 //Constructor
	 public Spielbrett(int dim)
	 {
		 this.dim = dim; 
		 this.brett = new Feld [dim][dim];
		 ; 
	 }

}
