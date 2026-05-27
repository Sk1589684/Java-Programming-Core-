package MultiThredding;

public class CreatingThreadByClass extends Thread{

	public void run() {
		System.out.println("Thread is created by extending Thread Class");
	}
	
	public static void main(String[] args) {
		CreatingThreadByClass t=new CreatingThreadByClass();
		
		
		t.setName("Worker Thread");
//		Here we can name a thread and get the name back using getName Function.
		System.out.println(t.getName());
		
		t.start();
	}
}
