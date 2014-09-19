package nl.carpago.chess.model;

public class Bord {

	private final int	SIZE	= 8;

	private int[][]		bord	= new int[SIZE][SIZE];

	public int getSize() {
		return SIZE;
	}

	public void toon() {
		toonHeaderFooter();
		for (int[] horizontaal : bord) {
			for (int verticaal : horizontaal) {
				System.out.print("|" + verticaal);

			}
			System.out.println("|");
		}
		toonHeaderFooter();
	}

	private void toonHeaderFooter() {
		final String separator = "=";
		for (int i = 0; i < 8; i++) {
			System.out.print(separator + separator);
		}
		System.out.println(separator);
	}

	public void setOccupied(Positie pos){
		this.bord[pos.getxCoord()][pos.getyCoord()] = 1;
	}
}
