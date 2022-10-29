package statePattern;

import javax.naming.Context;

public class StartState implements State{

	@Override
	public void doAction(Context context) {
		// TODO Auto-generated method stub
		System.out.println("Player is in start state");
		context.setSt  (this);
	}
	public String toString(){
	return "Start State";
	}
	
}
