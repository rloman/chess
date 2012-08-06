package nl.carpago.chess;

public class Bord {
	
	private final int SIZE = 8;

	//private int[][] bord = new int[SIZE][SIZE];
	
	x wat ga ik verder doen ???
			x ik zou maar gewoon de master branch onder GWT hangen...
	
	private Schaakstuk[][] posities = new Schaakstuk[SIZE][SIZE];
	
	public int getSize() {
		return SIZE;
	}
	
	
	public Schaakstuk getStukAtPositie(Positie pos) {
		return this.posities[pos.getxCoord()][pos.getyCoord()];
	}
	
	public void setStukAtPositie(Schaakstuk stuk, Positie pos) {
		this.posities[pos.getxCoord()][pos.getyCoord()] =  stuk;
		stuk.setBord(this);
		stuk.setPositie(pos);
	}
	
	public boolean hasStukAtPositie(Positie pos) {
		return this.posities[pos.getxCoord()][pos.getyCoord()] != null;
	}
	
	public void removeStukAtPositie(Positie pos) {
		this.posities[pos.getxCoord()][pos.getyCoord()] = null;
	}
	
	

}
