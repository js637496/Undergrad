import java.util.Date;

public class Exercise09_07 {
  public static void main (String[] args) {
    Account account = new Account(1122, 20000);
    Account.setAnnualInterestRate(4.5);
    
    account.withdraw(2500);
    account.deposit(3000);
    System.out.println("Balance is " + account.getBalance());
    System.out.println("Monthly interest is " +
      account.getMonthlyInterest());
    System.out.println("This account was created at " +
      account.getDateCreated());
  }
}

class Account {
  private int id;
  private double balance; //0
  private static double annualInterestRate; //0 
  private Date dateCreated; // account creation
  Account(){
	  this.balance = 0;
	  this.id = 0;
	  this.annualInterestRate = 0;
	  this.dateCreated = new Date();
  }
  Account(int setId, double setBal){
	  this.balance = setBal;
	  this.id = setId;
	  this.annualInterestRate = 0;
	  this.dateCreated = new Date();
  }
  Date getDateCreated(){
	  return this.dateCreated;
  }
  int getId(){
	  return this.id;
	 
  }
  static void setAnnualInterestRate(double rate){
	  annualInterestRate = rate;
  }
  double getBalance(){
	  return this.balance;
  }
  
  double getAnnualInterestRate(){
	  return this.annualInterestRate;
  }
  
  double getMonthlyInterest(){
	  return this.annualInterestRate/12 * this.balance;
  }
  
  void withdraw(double amt){
	  this.balance = this.balance - amt;
  }
  void deposit(double amt){
	  this.balance = this.balance + amt;
  }
  
  
  
}