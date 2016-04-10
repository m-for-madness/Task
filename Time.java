package Classes;

import java.util.Scanner;
//class which implements content of Time
public class Time implements Comparable<Time>{
	private int min;
	private int hour;
	
	public Time() {
	}

	public Time(int min, int hour)throws InvalidFormatTime{
		// check if time is correct
		try{
			if (min> 59||min<0||hour>23||hour<0){
				throw new InvalidFormatTime();
			}
			else {
				this.hour=hour;
				this.min=min;
			}
			
		}
		catch(InvalidFormatTime e){
			e.getMessage();
			System.exit(0);
		}	
		
	}
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return hour+":"+min;
	}
	// function that check if time is correct
	public boolean correctTime(){
		if (min> 59||min<0||hour>23||hour<0)
			return false;
		else return true;
	}
	public void inputTime() throws InvalidFormatTime{
		Scanner sc = new Scanner (System.in);
		boolean b= false;
		while(b==false)
		{
			System.out.print("Input hour : ");
			hour=sc.nextInt();
		
			System.out.print("Input min : ");
			min = sc.nextInt();
			if(correctTime()){
				b=true;
			}
			else{
				System.out.println("You have input wrong time format,plz try again");
			}
		}
		
	}
	// compare two variables by hours, if they are equal, then compare by minutes
	@Override
	public int compareTo(Time t) {
		int res= this.hour-t.hour;
		if (res==0){
			res=this.min-t.min;
			return res;
		}
		return res;
	}
	// add two variables which are type of time
	public Time addTime(Time t1,Time t2){
		Time t = new Time();
		t.hour=t1.hour+t2.hour;
		if (t.hour>23){
			t.hour-=24;
		}
		t.min=t1.min+t2.min;
		if (t.min>59){
			t.min-=60;
			t.hour++;
		}
		return t;
	}
}
class InvalidFormatTime extends Exception{
}
