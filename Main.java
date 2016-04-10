package Classes;


public class Main {
	
	public static void main(String[] args) throws InvalidFormatTime {
		// enter time of opening and closing of the cinema
		System.out.println("Input time of the opening");
		Time t = new Time();
		t.inputTime();
		System.out.println("Input time of the closing");
		Time t1 = new Time();
		t1.inputTime();
		
		Cinema c= new Cinema(t,t1);
		c.menu(t,t1);
	}
	
}
