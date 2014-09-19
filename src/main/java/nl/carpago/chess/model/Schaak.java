package nl.carpago.chess.model;

import java.util.*;

public class Schaak {
	
	private Bord bord ;
	private Positie GOAL = new Positie(0,7);
	
	private List<Schaakstuk> oplossing;// = new ArrayList<Schaakstuk>();
	
	private Schaakstuk stuk;
	
	public Schaak() {
		
		this.bord = new Bord();
		this.stuk = new Paard(this.bord, new Positie(0,0));
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
	
	public List<Schaakstuk> dfs(Schaakstuk localstuk, Set<Schaakstuk> bezocht) {
		List<Schaakstuk> result = new LinkedList<Schaakstuk>();
		bezocht.add(localstuk);
		result.add(localstuk);
		
		if(this.isGoal(localstuk.getPositie())) {
			return result;
		}
		
		Set<Schaakstuk> buurknopen = localstuk.buurknopen(); 
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
		List<Schaakstuk> result = new ArrayList<Schaakstuk>();
		
		if(vanaf.getPositie().equals(target)) {
			result.add(vanaf);
			
			return result;
		}
		
		Map <Schaakstuk, Schaakstuk> discoveredBy = new HashMap<Schaakstuk, Schaakstuk>();
		boolean isFound = false;
		Set<Positie> bezocht = new HashSet<Positie>();
		Queue<Schaakstuk> agenda = new LinkedList<Schaakstuk>();
		agenda.add(vanaf);
		Schaakstuk stuk = null;
		
		outer:
		while(!agenda.isEmpty()) {
			Schaakstuk head = agenda.poll();
			for(Schaakstuk buur : head.buurknopen()) {
				
				if(buur.getPositie().equals(target)) {
					discoveredBy.put(buur, head);
					isFound = true;
					stuk = buur;
					
					break outer;
				}
				if(!bezocht.contains(buur.getPositie())) {
					discoveredBy.put(buur, head);
					agenda.add(buur);
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
