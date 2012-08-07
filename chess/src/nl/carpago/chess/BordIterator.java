package nl.carpago.chess;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BordIterator implements Iterator<Schaakstuk> {
	
	private List<Schaakstuk> schaakstukken;
	private int positie;
	
	
	public BordIterator(Schaakstuk[][] posities) {
		this.schaakstukken = new LinkedList<Schaakstuk>();
		for(int i =0;i<8;i++) {
			for(int j = 0 ;j<8;j++) {
				Schaakstuk stuk = posities[i][j];
				if(stuk!=null) {
					schaakstukken.add(stuk);
				}
			}
		}
		this.positie = 0;
	}

	@Override
	public boolean hasNext() {
		return positie < schaakstukken.size();
	}

	@Override
	public Schaakstuk next() {
		
		return this.schaakstukken.get(this.positie++);
	}

	@Override
	public void remove() {
		this.schaakstukken.remove(this.positie);
		
	}

}
