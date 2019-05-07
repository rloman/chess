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

		for (int moves[] : new int[][] { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } }) {

			int deltaX = moves[0];
			int deltaY = moves[1];
			//System.out.println(new Paard(bord, new Positie(x + deltaX, y + deltaY)));
			if (x + deltaX < bord.getSize() && x + deltaX >= 0) {
				if (y + deltaY < bord.getSize() && y + deltaY >= 0) {
					buren.add(new Paard(bord, new Positie(x + deltaX, y + deltaY)));

				}
			}

		}
		//System.out.println("De buren van:"+this.getPositie()+" zijn:");
		//System.out.println("buren:"+buren);

		return buren;
	}

}
