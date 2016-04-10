package Classes;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {
	 private Set<Seance> set;

	public Schedule() {
		this.set =new TreeSet<>();
	}
	
	
	
	public Set<Seance> getSet() {
		return set;
	}
	public void addSeance(Seance ...s){
		for (Seance sea : s) {
			set.add(sea);
		}	
	}
	public void removeSeance(Seance s){
		set.remove(s);
	}

	public void Output_seance() {
		if (set.size()==0){
			System.out.println( "Schedule  on this day is empty");
		}
		else
		for (Seance s : set) {
			System.out.println(s);
		}
	
	}





}
