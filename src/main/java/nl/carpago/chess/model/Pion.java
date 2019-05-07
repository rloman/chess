package nl.carpago.chess.model;

import java.util.HashSet;
import java.util.Set;

public class Pion extends Schaakstuk {
	
	
	public Pion(Bord bord, Positie pos) {
		super(bord, pos);
	}

	@Override
	public Set<Schaakstuk> buurknopen() {

		Set<Schaakstuk> buren = new HashSet<Schaakstuk>();

		int x = this.getPositie().getxCoord();
		int y = this.getPositie().getyCoord();

		if (x - 1 >= 0) {
			buren.add(new Pion(bord, new Positie(x - 1, y)));
		}

		return buren;
	}

}
