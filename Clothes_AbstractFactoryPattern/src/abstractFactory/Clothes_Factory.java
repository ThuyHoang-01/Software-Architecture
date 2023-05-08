package abstractFactory;

public class Clothes_Factory extends AbstractFactory {

	public UK getUK(String ukType) {
		if (ukType == null) {
			return null;
		}
		if (ukType.equalsIgnoreCase("Shirt")) {
			return new Shirt();
		} else if (ukType.equalsIgnoreCase("Trousers")) {
			return new Trousers();
		
		}
		return null;
	}

	@Override
	US getUS(String us) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
