package statePattern;

public class StopState implements State {
	
		@Override
		public void doAction(javax.naming.Context context) {
			// TODO Auto-generated method stub
			System.out.println("Player is in stop state");
			context.set (this);
			} 
			public String toString(){
			return "Stop State";
		}
}
