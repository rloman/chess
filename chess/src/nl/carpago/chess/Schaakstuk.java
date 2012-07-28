package nl.carpago.chess;

import java.util.Set;

public abstract class Schaakstuk {
	
	public Bord bord;
	
	private Positie pos;
	
	//TODO Implement template method in subclasses
	public abstract Set<Schaakstuk> buurknopen();
	
	@Override
	public String toString() {
		
		return "("+pos.getxCoord()+","+pos.getyCoord()+")";
	}
	
	public Schaakstuk(Bord bord, Positie pos) {
		if(bord == null) {
			System.out.println("Foutje");
		}
		this.bord = bord;
		this.pos = pos;
		
	}
	
	public Positie getPositie(){
		return this.pos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pos == null) ? 0 : pos.hashCode());
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
		Schaakstuk other = (Schaakstuk) obj;
		if (pos == null) {
			if (other.pos != null)
				return false;
		} else if (!pos.equals(other.pos))
			return false;
		return true;
	}
	
	
	
}
