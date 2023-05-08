package abstractFactory;

public class Footwear_Factory extends AbstractFactory {

	@Override
	UK getUK(String uk) {
		// TODO Auto-generated method stub
		return null;
	}

	public US getUS(String usType) {
		if (usType == null) {
			return null;
		}
		if (usType.equalsIgnoreCase("Shoes")) {
			return new Shose();
		} else if (usType.equalsIgnoreCase("Sandal")) {
			return new Sandal();
		
		}
		return null;
	}

	
}
