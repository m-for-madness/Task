package Classes;

public class Seance implements Comparable<Seance>{
	private Movie movie;
	// start of the seance
	private Time startTime;
	//end of the seance which calculates by the sum of start of seance and duration of movie
	private Time endTime;
	public Seance(Movie movie, Time startTime) {
		this.movie = movie;
		this.startTime = startTime;
		
		Time ndTime = new Time();
		// here i calculate end of seance
		ndTime.setHour(movie.getDuration().getHour()+ startTime.getHour());
		//check if time is correct
		if (ndTime.getHour()>23){
			ndTime.setHour(ndTime.getHour()-24);
		}
		ndTime.setMin(movie.getDuration().getMin()+startTime.getMin());
		
		if (ndTime.getMin()>59){
			ndTime.setMin(ndTime.getMin()-60);
			ndTime.setHour(ndTime.getHour()+1);
		}
		this.endTime=ndTime;
	}			
	
	@Override
	public String toString() {
	
		return this.movie + "\n"+ "Seance starts : "+this.startTime+"\n" + "Seance ends : "+ this.endTime;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	@Override
	public int compareTo(Seance s) {
		int res =startTime.compareTo(s.getStartTime());
		return res;
	}
	
}
