package nl.carpago.chess;

import java.util.HashSet;
import java.util.Set;

public class Koning extends Schaakstuk {

	public Koning(Bord bord, Positie pos) {
		super(bord, pos);
	}

	@Override
	public Set<Schaakstuk> buurknopen() {

		Set<Schaakstuk> buren = new HashSet<Schaakstuk>();

		int x = this.getPositie().getxCoord();
		int y = this.getPositie().getyCoord();

		int[][] moves = new int[][] { { -1, 0 }, { -1, -1 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

		for (int[] move : moves) {
			int deltaX = move[0];
			int deltaY = move[1];

			if (x + deltaX < bord.getSize() && x + deltaX >= 0) {
				if (y + deltaY < bord.getSize() && y + deltaY >= 0) {

					buren.add(new Koning(bord, new Positie(x + deltaX, y + deltaY)));
				}
			}
		}
		
		return buren;
	}
}
