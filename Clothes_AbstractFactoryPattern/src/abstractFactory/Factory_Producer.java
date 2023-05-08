package abstractFactory;

public class Factory_Producer {

	public static AbstractFactory getFactory(String choice) {
		if(choice.equalsIgnoreCase("CLOTHES")){
			return new Clothes_Factory();
			}
		else if(choice.equalsIgnoreCase("FOOTER_FACTORY")){
			return new Footwear_Factory();
			}
		return null;
		
	}

}
