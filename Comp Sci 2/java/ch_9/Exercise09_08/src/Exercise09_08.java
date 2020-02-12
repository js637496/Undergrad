public class Exercise09_08 {
  public static void main(String[] args) {
    Fan fan1 = new Fan();
    fan1.setSpeed(Fan.FAST);
    fan1.setRaidus(10);
    fan1.setColor("yellow");
    fan1.setOn(true);
    System.out.println(fan1.toString());

    Fan fan2 = new Fan();
    fan2.setSpeed(Fan.MEDIUM);
    fan2.setRaidus(5);
    fan2.setColor("blue");
    fan2.setOn(false);
    System.out.println(fan2.toString());
  }
}

class Fan {
  final static int SLOW = 1;
  final static int MEDIUM = 2;
  final static int FAST = 3;
  
  private int speed; //default SLOW
  private boolean on; //default false
  private double raidus; // defualt 5
  String color; // defualt blue
  
  Fan(){
	  this.speed =  SLOW;
	  this.on = false;
	  this.raidus = 5;
	  this.color = "blue";
  }
public double getRaidus() {
	return raidus;
}
public void setRaidus(double raidus) {
	this.raidus = raidus;
}
public int getSpeed() {
	return speed;
}
public void setSpeed(int speed) {
	this.speed = speed;
}
public boolean isOn() {
	return on;
}
public void setOn(boolean on) {
	this.on = on;
}

public void setColor(String color){
	this.color = color;
}
public String getColor(){
	return this.color;
}
public String toString(){
	if(this.isOn())
		return "" + this.speed  + "" + this.color + "" + this.raidus;
	else
		return "" + this.color + "" + this.raidus + "fan is off";

				
}
  
}