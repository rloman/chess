package nl.carpago.chess;

import java.util.HashSet;
import java.util.Set;

public class Toren extends Schaakstuk {
	
	public Toren(Bord bord, Positie pos) {
		super(bord, pos);
	}
	
	
	@Override
	public Set<Schaakstuk> buurknopen() {
		
		Set<Schaakstuk> buren = new HashSet<Schaakstuk>();

		int x = this.getPositie().getxCoord();
		int y = this.getPositie().getyCoord();
		

		while (++x < bord.getSize() ) {
			
			buren.add(new Toren(bord, new Positie(x, y)));
		}
		
		x = this.getPositie().getxCoord();
		
		
		while(--x >= 0) {
			buren.add(new Toren(bord, new Positie(x, y)));
		}
		
		x=this.getPositie().getxCoord();
		
		while(++y < bord.getSize()) {
			buren.add(new Toren(bord, new Positie(x,y)));
		}
		
		y= this.getPositie().getyCoord();
		
		while(--y >= 0) {
			buren.add(new Toren(bord, new Positie(x,y)));
		}
		
		return buren;

		
	}

}
