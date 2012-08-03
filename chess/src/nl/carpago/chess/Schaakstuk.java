package nl.carpago.chess;

import java.util.Set;

public abstract class Schaakstuk {
	
	public Bord bord;
	
	private Positie pos;
	
	
	public Schaakstuk() {}
	
	public Schaakstuk(Bord bord, Positie pos) {
		this.bord = bord;
		this.pos = pos;
	}
	
	//TODO Implement template method in subclasses
	public abstract Set<Schaakstuk> buurknopen();
	
	@Override
	public String toString() {
		
		return this.getClass().toString() +"op positie ("+pos.getxCoord()+","+pos.getyCoord()+")";
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
	
	public void setBord(Bord bord) {
		this.bord = bord;
	}
	
	
	public void setPositie(Positie pos) {
		this.pos = pos;
	}
	
}
