package nl.carpago.chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Schaak {
	
	private Bord bord ;
	private Positie GOAL = new Positie(1,7);
	
	private List<Schaakstuk> oplossing;// = new ArrayList<Schaakstuk>();
	
	
	
	private Schaakstuk stuk;
	
	public Schaak() {
		
		this.bord = new Bord();
		this.stuk = new Loper(this.bord, new Positie(5,5));
	}
	
	
	public void zoekPad() {
		
		// oplossing = dfs(stuk, new HashSet<Schaakstuk>());
		
		oplossing = bfs(this.stuk, this.GOAL);
	}
	
	public void drukOplossingAf(){
		if(oplossing == null || oplossing.isEmpty()) {
			System.out.println("Er is geen oplossing mogelijk!");
		}
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
	
	public List<Schaakstuk> bfs(Schaakstuk vanaf, Positie target) {
		Map <Schaakstuk, Schaakstuk> discoveredBy = new HashMap<Schaakstuk, Schaakstuk>();
		List<Schaakstuk> result = new ArrayList<Schaakstuk>();
		boolean isFound = false;
		
		if(vanaf.getPositie().equals(target)) {
			result.add(vanaf);
			
			return result;
		}
		
		Set<Positie> bezocht = new HashSet<Positie>();
		Queue<Schaakstuk> q = new LinkedList<Schaakstuk>();
		q.add(vanaf);
		
		Schaakstuk stuk = null;
		
		outer:
		while(!q.isEmpty()) {
			Schaakstuk head = q.poll();
			for(Schaakstuk buur : head.buurknopen()) {
				
				if(buur.getPositie().equals(target)) {
					discoveredBy.put(buur, head);
					isFound = true;
					stuk = buur;
					
					break outer;
				}
				if(!bezocht.contains(buur.getPositie())) {
					discoveredBy.put(buur, head);
					q.add(buur);
					bezocht.add(buur.getPositie());
				}
			}
		}
		
		if(isFound) {
			result.add(stuk);
		}
		while(!vanaf.equals(stuk) && !(stuk == null)) {
			stuk = discoveredBy.get(stuk);
			result.add(0, stuk);
		}
		
		return result;
 	}
	
	
	
	public boolean isGoal(Positie pos){
		return this.GOAL.equals(pos);
	}
	
	public boolean goalIsReached(List<Schaakstuk> l) {
		return !l.isEmpty();
	}
	
	public void addSchaakstuk(Schaakstuk schaakstuk, Positie pos) {
		this.stuk = schaakstuk;
		schaakstuk.setBord(this.bord);
		schaakstuk.setPositie(pos);
	}

}
