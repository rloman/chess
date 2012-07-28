package nl.carpago.chess;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Schaak {
	
	private Bord bord ;
	private Positie GOAL = new Positie(0,7);
	
	private List<Schaakstuk> oplossing;// = new ArrayList<Schaakstuk>();
	
	
	
	private Schaakstuk stuk;
	
	public Schaak() {
		
		this.bord = new Bord();
		this.stuk = new Pion(this.bord, new Positie(7,7));
	}
	
	
	public void zoekPad() {
		
		oplossing = dfs(stuk, new HashSet<Schaakstuk>());
		
	}
	
	public void drukOplossingAf(){
		for(Schaakstuk stuk : oplossing) {
			System.out.println(stuk);
		}
	}
	
	public List<Schaakstuk> dfs(Schaakstuk stuk, Set<Schaakstuk> bezocht) {
		List<Schaakstuk> result = new LinkedList<Schaakstuk>();
		bezocht.add(stuk);
		result.add(stuk);
		
		if(this.isGoal(stuk.getPositie())) {
			return result;
		}
		
		Set<Schaakstuk> buurknopen = stuk.buurknopen(); 
		for(Schaakstuk buur : buurknopen) {
			
			if(!bezocht.contains(buur)) {
				List <Schaakstuk> l = dfs(buur, bezocht);
				if(goalIsReached(l)) {
					result.addAll(l);
					
					return result;
				}
			}
		}
		
		return new LinkedList<Schaakstuk>();
		
	}
	
	
	
	public boolean isGoal(Positie pos){
		return this.GOAL.equals(pos);
	}
	
	public boolean goalIsReached(List<Schaakstuk> l) {
		return !l.isEmpty();
	}

}
