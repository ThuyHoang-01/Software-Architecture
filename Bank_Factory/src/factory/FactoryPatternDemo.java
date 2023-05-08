package factory;

public class FactoryPatternDemo {
  public static void main(String[] args) {
	FactoryBank factoryBank = new FactoryBank();
	 
	Bank bank1 = factoryBank.getBank(" VietinBank");
	bank1.infor();
	
	Bank bank2 = factoryBank.getBank(" SacomBank");
	bank2.infor();
	
	Bank bank3 = factoryBank.getBank(" ACBank");
	bank3.infor();
	
}
}
