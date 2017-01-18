import java.util.PriorityQueue;

public class TrollsBridge {

	private PriorityQueue<Woolie> waitingList = new PriorityQueue<Woolie>();
	private int onBridge = 0;
	private final int MAX;
	
	/**
	 * Constructor
	 * 
	 */
	public TrollsBridge(int myMax){
		
		MAX = myMax;
		
	}
	
	/**
	 * enterBridgePlease
	 * 
	 */
	public synchronized void enterBridgePlease(Woolie thisWoolie){
		
		System.out.println(" The troll scowls \"Get in line!\" when " + thisWoolie.getName() + " shows up at the bridge.");
		waitingList.add(thisWoolie);
		/*
		try{
			System.out.print("Waiting 1 ");
			thisWoolie.wait();
			System.out.println("& 2");
		}
		catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
		*/
		
		if(onBridge < MAX){
		
			waitingList.poll();
			onBridge++;
			
		}
		else{
			try{
				thisWoolie.wait();
			}
			catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		
		
	}
	
	/**
	 * leave
	 * 
	 */
	public synchronized void leave(){
		onBridge--;
		notify();
		
		if( !waitingList.isEmpty() ){
			
			waitingList.poll();
			onBridge++;
			
		}
		
	}
	
}
