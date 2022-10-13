package hoangtothuy.org;

public class Calculator {
	public double add(double a, double b){
		return a + b;
		}
		public double sub(double a, double b){
		return a - b;
		}
		public double product(double a, double b){
		return a * b;
		}
		public double div(double a, double b){
		if (b == 0) throw new RuntimeException("divide by zero");
		return a / b;
		}

}