package MultiThredding;

public class LambdaThreadDemo {

	public static void main(String[] args) {
		
		Thread t=new Thread(()->{
			for(int i=0;i<=5;i++) {
				System.out.println("Child Thread"+i);
				
				try {
					Thread.sleep(500);
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
			}
		});
		
		t.start();
		
		for(int i=0;i<=5;i++) {
			System.out.println("Main Thread "+i);
		}

	}

}
