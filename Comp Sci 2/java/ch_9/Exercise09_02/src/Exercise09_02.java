public class Exercise09_02 {
  public static void main(String[] args) {
    Stock stock = new Stock("SUNW", "Sun MicroSystems Inc.");
    stock.setPreviousClosingPrice(100);

    // Set current price
    stock.setCurrentPrice(90);

    // Display stock info
    System.out.println("Previous Closing Price: " +
      stock.getPreviousClosingPrice());
    System.out.println("Current Price: " +
      stock.getCurrentPrice());
    System.out.println("Price Change: " +
      stock.getChangePercent() * 100 + "%");
  }
}

class Stock {
  String symbol;
  String name;
  double previousClosingPrice;
  double currentPrice;
  Stock(String setSymbol, String setName){
	  this.symbol = setSymbol;
	  this.name = setName;
  }
  
  double getChangePercent(){
	  return (((previousClosingPrice - this.currentPrice)/previousClosingPrice)) * -1;
  } 
  void setCurrentPrice(double setPrice){
	  this.currentPrice = setPrice;
  }
  void setPreviousClosingPrice(double setPrev){
	  this.previousClosingPrice = setPrev;
  }
  double getPreviousClosingPrice(){
	  return this.previousClosingPrice;
  }
  
  double getCurrentPrice(){
	  return this.currentPrice;
  }
}