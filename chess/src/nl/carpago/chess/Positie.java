package nl.carpago.chess;

public class Positie {
	
	private int xCoord;
	private int yCoord;
	public int getxCoord() {
		return xCoord;
	}
	public int getyCoord() {
		return yCoord;
	}
	
	
	
	
	public Positie(int xCoord, int yCoord) {
		super();
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xCoord;
		result = prime * result + yCoord;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Positie other = (Positie) obj;
		if (xCoord != other.xCoord)
			return false;
		if (yCoord != other.yCoord)
			return false;
		return true;
	}
}
