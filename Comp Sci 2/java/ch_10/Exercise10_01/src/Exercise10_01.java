import java.util.Date;

public class Exercise10_01 {
  public static void main(String[] args) {
    Time time = new Time();
    System.out.println("Hour: " + time.getHour() + " Minute: " +
                       time.getMinute() + " Second: " + time.getSecond());
  }
}

class Time {
	  long hour, minute, second;
	  
	  public long getHour() {
		return hour;
	}
	
	public void setHour(long hour) {
		this.hour = hour;
	}
	
	public long getMinute() {
		return minute;
	}
	
	public void setMinute(long minute) {
		this.minute = minute;
	}
	
	public long getSecond() {
		return second;
	}
	
	public void setSecond(long second) {
		this.second = second;
	}
	
	Time(){
		  
		  
		  second = ((System.currentTimeMillis() / 1000) % 60);
		  minute = (((System.currentTimeMillis() / 1000) / 60) % 60);
		  hour = ((System.currentTimeMillis() / 1000) / 3600) % 24;
	
	  }
	
	Time(long milseconds){
		Date miliseconds = new Date(milseconds);
		second  = ((miliseconds.getTime() / 1000) % 60);
		minute = (((miliseconds.getTime() / 1000) / 60) % 60);
		hour = ((miliseconds.getTime() / 1000) / 3600) % 24;
	 
	}
	
	Time(int shour, int sminute, int ssecond){
		second = ssecond;
		minute = sminute;
		hour = shour;
		
	}
	void setTime(long milseconds){
		Date miliseconds = new Date(milseconds);
		this.second  = ((miliseconds.getTime() / 1000) % 60);
		this.minute = (((miliseconds.getTime() / 1000) / 60) % 60);
		this.hour = ((miliseconds.getTime() / 1000) / 3600) % 24;
	}
}



