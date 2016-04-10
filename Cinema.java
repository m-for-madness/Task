package Classes;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class Cinema implements Comparator<Days>{
	private TreeMap<Days, Schedule> map;
	private Time open;
	private Time close;
	public Cinema(Time open, Time close) {
		// treemap will sort elements by days
		this.map =new TreeMap<Days,Schedule>(/*new ComparatorDescend()*/);
		try{
			//check if open&close time is correct
			if (open.correctTime()&&close.correctTime()){
				this.open=open;
				this.close=close;
			}
			else {
				throw new InvalidFormatTime();
			}
			
		}
		catch(InvalidFormatTime e){
			e.getMessage();
			System.exit(0);
		}
	}
	// this function delete all movies from all seances
	public void removeMovie(){
		System.out.println("Input name of the movie which you want to remove");
		Scanner sc = new Scanner (System.in);
		String s = sc.nextLine();
		// get access to values of map by keys
		for (final Map.Entry<Days, Schedule> entry : map.entrySet()) {
			//get access to set of Seances 
				for (Seance seance : entry.getValue().getSet()) {
					// check if name of movie is equal to our inputed value
					if (seance.getMovie().getTitle().equalsIgnoreCase(s)){
						// if true delete such movie
						entry.getValue().removeSeance(seance);
					}
				}
			}
	}
	// this function add only 1 seance to the exact schedule
	public void addSeance(Seance s, String day){
		if (map.isEmpty()){
			Schedule sch = new Schedule();
			sch.addSeance(s);
			map.put(Days.valueOf(day),sch);
		}
		for (final Map.Entry<Days, Schedule> entry : map.entrySet()) {
			if (entry.getKey().name().equalsIgnoreCase(day)){
				entry.getValue().getSet().add(s);
			}
		}
	}
	//this function input as many seances as you want 
	public Schedule inputSeances(Time open,Time close ) throws InvalidFormatTime{
		Time t = new Time();
		Scanner sc= new Scanner(System.in);
		boolean b = true;
		String mov="";
		while(b==true){
			System.out.print("Input name of movie : ");
			mov = sc.nextLine();
			if (!mov.isEmpty())
			{
				b=false;
				
			}
			else
			System.out.println("You entered incorrect name of movie, plz try again");
		}
		
		System.out.println("Input duration of movie");
		t.inputTime();
		Movie m = new Movie(mov,t);
		// output created movie
		System.out.println(m);
		Schedule s = new Schedule();
		int g=1;
		while( g==1)
		{
			// input start of the seance
			System.out.println("Input time of the beginning of the film");
			Time t1 = new Time();
			t1.inputTime();
			Seance sea = new Seance(m,t1);
			System.out.println(sea);
			// check if the beginning\ending of the seance isn't earlier than opening\closing of the cinema
			if ((sea.getStartTime().compareTo(open)>=0)&&(sea.getEndTime().compareTo(close)<=0))
			{
				
				s.getSet().add(sea);
			}
				
			else {
				System.out.println("You have input wrong time of the seance");
				
			}
			System.out.println("If you want to add one more seance input 1, otherwise input 0");
			g=sc.nextInt();
		}
		return s;
	}
	// output all schedules
	public void output(){
		for (final Map.Entry<Days, Schedule> entry : map.entrySet()) {
			System.out.println("\n"+entry.getKey() +"'s schedule");
			entry.getValue().Output_seance();
		}
	}

	public void menu(Time t,Time t1) throws InvalidFormatTime{
		
		Scanner sc = new Scanner (System.in);
		Set<Seance> set = new TreeSet<>();
		Schedule s = new Schedule();
		//variable which will start our cycle
		String choice="YES";
		while(choice.equalsIgnoreCase("YES"))
		{
			System.out.println("Input what day of schedule do you want to edit"+"\nIf you want to output all schedules input \"output\"");
			choice=sc.nextLine();
			choice=choice.toUpperCase();
			//System.out.println(choice);
			boolean b = false;
			//check if entered day belong to days
			for (Days d : Days.values()) {
				if (d.name().equals(choice)){
					b=true;
				}
			}
			if (b==true){
				s=inputSeances(t, t1);
				// if map doesn't contain entered day , create key-value
				if (!map.containsKey(Days.valueOf(choice))){
					map.put(Days.valueOf(choice),s);
					output();
				}
				else{
				// if map contain , complete set of seances 
				map.get(Days.valueOf(choice)).getSet().addAll(s.getSet());
				output();
				}
			}
			else 
			{
				System.out.println("You have entered incorrect day");
			}
			if (choice=="OUTPUT")
			{
				output();
			}
			
			
			System.out.println("Do you want to continue? Yes / No");
			choice=sc.nextLine();
		}
		System.out.println("Bye-bye");
		
	}
	@Override
	public int compare(Days d1, Days d2) {
		int res= d1.ordinal()-d2.ordinal();
		return res;
	}
	
	

}
