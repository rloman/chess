package nl.carpago.chess.model;

public class Bord {

	private final int	SIZE	= 8;

	public int[][]		bord	= new int[SIZE][SIZE];

	public int getSize() {
		return SIZE;
	}

	public int[][] getBord() {
		return this.bord;
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

	public void toonHeaderFooter() {
		final String separator = "=";
		for (int i = 0; i < 8; i++) {
			System.out.print(separator + separator);
		}
		System.out.println(separator);
	}
}
