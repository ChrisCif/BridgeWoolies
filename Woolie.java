
public class Woolie extends Thread {
	
	//private String name;
	private int walkSpeed;
	private String destination;
	private TrollsBridge bridge;
	
	/**
	 * Constructor
	 * 
	 */
	public Woolie(String myName, int mySpeed, String myDestination, TrollsBridge myBridge){
		
		super.setName(myName);
		walkSpeed = mySpeed;
		destination = myDestination;
		bridge = myBridge;
		
	}
	
	/**
	 * run
	 * 
	 */
	public void run(){
		
		bridge.enterBridgePlease(this);
	
		System.out.println(getName() + " is starting to cross.");
		for(int i = 1; i <= walkSpeed; i++){
			
			try{
				sleep(1000);	
			}
			catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
			System.out.println(getName() + " " + i + " seconds.");
			
		}
		System.out.println(getName() + " leaves at " + destination);

		
		bridge.leave();
		
	}

}
