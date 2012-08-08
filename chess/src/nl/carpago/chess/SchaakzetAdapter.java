package nl.carpago.chess;


public class SchaakzetAdapter {
	
	String[] xCoords = new String[]{"a","b","c","d","e","f","g","h"};
	
	private Schaakstuk stuk;

	public SchaakzetAdapter(Schaakstuk stuk) {
		this.stuk = stuk;
	}
	
	@Override
	public String toString() {
		
		int xCoord = this.stuk.getPositie().getxCoord();
		int yCoord = this.stuk.getPositie().getyCoord();
		
		// String xCoordZet = xCoords.valueOf(arg0)
		String x= xCoords[yCoord];
		String y  = "" + (8-xCoord);
		
		return this.stuk.getClass().getSimpleName() +" op "+x+y;
	}

}
