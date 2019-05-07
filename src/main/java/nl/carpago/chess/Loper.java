package nl.carpago.chess;

import java.util.HashSet;
import java.util.Set;

public class Loper extends Schaakstuk {

	public Loper(Bord bord, Positie pos) {
		super(bord, pos);
	}

	@Override
	public Set<Schaakstuk> buurknopen() {

		Set<Schaakstuk> buren = new HashSet<Schaakstuk>();

		int x = this.getPositie().getxCoord();
		int y = this.getPositie().getyCoord();

		int[][] moves = new int[][] { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

		for (int[] move : moves) {
			for (int i = 1; i <= 8; i++) {
				int deltaX = i * move[0];
				int deltaY = i * move[1];

				if (x + deltaX < bord.getSize() && x + deltaX >= 0) {
					if (y + deltaY < bord.getSize() && y + deltaY >= 0) {

						buren.add(new Loper(bord, new Positie(x + deltaX, y + deltaY)));
						/*
						 * System.out.println("<knoop>");
						 * System.out.println(this); System.out.println(new
						 * Loper(bord, new Positie(x+deltaX, y+deltaY)));
						 * System.out.println("</knoop>");
						 */

					}
				}

			}

		}

		return buren;
	}

}
