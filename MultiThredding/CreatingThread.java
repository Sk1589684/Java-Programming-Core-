package MultiThredding;

public class CreatingThread implements Runnable{

	
	public void run() {
		System.out.println("Thread is being created with help of Runnable Interface");
		
	}
	
	public static void main(String[] args) {
		CreatingThread obj=new CreatingThread();
		
		Thread t=new Thread(obj);
		
		t.start();
	}

}
