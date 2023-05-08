package factory;

public class FactoryBank {

	public Bank getBank(String bankType) {
		if(bankType == null) {
			return null;
		}
		if( bankType.equalsIgnoreCase(" VietinBank")) {
			return new VietinBank();
		}else if ( bankType.equalsIgnoreCase(" SacomBank")) {
			return new SacomBank();
		}
		else if ( bankType.equalsIgnoreCase(" ACBank")) {
			return new ACBank();
		}
		
		return null;
		
	}
}
