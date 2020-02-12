import java.util.Arrays;
import java.util.Date;

public class Exercise09_06 {

	public static void main(String[] args) {
		int [] test = new int[100000];
		for(int i = 0; i < 100000; i++){
			test[i] = 1 + (int)(Math.random() * 100000);
		}
		StopWatch watch = new StopWatch();
		Arrays.sort(test);
		watch.stop();
		watch.getElapsedTime();

	}

}

class StopWatch {
	  private Date startTime;
	  private Date endTime;
	  
	  StopWatch(){
		  this.startTime = new Date();
	  }
	  void start(){
		  this.startTime = new Date();
	  }
	  void stop(){
		  this.endTime = new Date();
	  }
	  long getElapsedTime(){
		
		  return this.endTime.getTime() - this.startTime.getTime();
	  }
	  
}
