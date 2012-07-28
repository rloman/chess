package nl.carpago.chess;

import java.util.HashSet;
import java.util.Set;

public class Paard extends Schaakstuk {
	
	
	public Paard(Bord bord, Positie pos) {
		super(bord, pos);
	}

	@Override
	public Set<Schaakstuk> buurknopen() {
		
		Set<Schaakstuk> buren = new HashSet<Schaakstuk>();
		
		int x = this.getPositie().getxCoord();
		int y = this.getPositie().getyCoord();
		
		if(x+1 < bord.getSize()) {
			buren.add(new Paard(bord, new Positie(x+1,y)));
		}
		if(x-1 >= 0) {
			buren.add(new Paard(bord, new Positie(x-1,y)));
		}
		if(y+1 < bord.getSize()) {
			buren.add(new Paard(bord, new Positie(x,y+1)));
		}
		if(y-1 >= 0) {
			buren.add(new Paard(bord, new Positie(x,y-1)));
		}
		
		return buren;
	}

}
