package MultiThredding;

public class SleepMethod extends Thread{

	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("You can Do It");
			try {
			Thread.sleep(2000);
		}catch(Exception e){
			
		}
	}}
	public static void main(String[] args) {
	
		SleepMethod thr=new SleepMethod();
		
		thr.start();
		
		for(int i=0;i<5;i++) {
			System.out.println("YO");
		}
	}

}
